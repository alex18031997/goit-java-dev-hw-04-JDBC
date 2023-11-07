package config;

import interfaces.MaxProjectCountClient;
import interfaces.MaxSalaryWorker;
import interfaces.MaxYoungestEldestWorker;
import interfaces.ProjectPrices;
import props.PropertyReader;
import services.DatabaseQueryService;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class Database {
    private static Database INSTANCE = null;

    static {
        try {
            INSTANCE = new Database();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Connection connection;
    private Database() throws SQLException, IOException {
        String url = PropertyReader.getConnectionUrlForPostgres();
        String user = PropertyReader.getConnectionGetUserForPostgres();
        String password = PropertyReader.getConnectionGetPasswordForPostgres();
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        List<MaxSalaryWorker> maxSalaryWorker = new DatabaseQueryService().findMaxSalaryWorker();
        List<MaxYoungestEldestWorker> maxYoungestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorker();
        List<ProjectPrices> projectPrices = new DatabaseQueryService().findProjectPrices();

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(String.format("can not create connection reason: %s", e));
        }

    }


    public static Connection getInstance() {
        return (Connection) INSTANCE;
    }


    public static Connection getConnection() {
        return connection;
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }
    }
}

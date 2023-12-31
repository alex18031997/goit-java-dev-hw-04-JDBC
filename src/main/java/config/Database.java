package config;

import props.PropertyReader;

import java.io.IOException;
import java.sql.*;

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
        String user = PropertyReader.getDataFromProp("postgres.db.user");
        String password = PropertyReader.getDataFromProp("postgres.db.password");

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(String.format("can not create connection reason: %s", e));
        }

    }


    public static Connection getConnection() {
        return connection;
    }

    public static int executeUpdate(String query) {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }
    }

    public static ResultSet executeQuery(String query) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }
    }
}

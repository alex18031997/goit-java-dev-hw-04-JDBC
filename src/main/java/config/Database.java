package config;

import props.PropertyReader;

import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();

    private static Connection connection;
    private Database() {
        String url = PropertyReader.getConnectionUrlForH2();
        String user = PropertyReader.getConnectionGetUserForH2();


        try {
            connection = DriverManager.getConnection(url, user, null);
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

    public static int executeUpdate(String query) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }
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

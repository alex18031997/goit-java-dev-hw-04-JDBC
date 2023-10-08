package services;

import config.Database;
import props.PropertyReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) throws IOException, SQLException {
        Connection conn = Database.getInstance();
        ReadSQLFile readFile = new ReadSQLFile();
        String DBPopulateFile = PropertyReader.getDBPopulateFile();
        String[] sqlStatements = readFile.readFile(DBPopulateFile);

        for (String sql : sqlStatements) {
            Database.executeUpdate(sql);
        }
    }
}

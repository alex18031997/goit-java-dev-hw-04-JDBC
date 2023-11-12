package services;


import config.Database;
import props.PropertyReader;

import java.io.IOException;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) throws IOException, SQLException {
        ReadSQLFile readFile = new ReadSQLFile();
        String DBPopulateFile = PropertyReader.getDataFromProp("db.populate.path");
        String[] sqlStatements = readFile.readFile(DBPopulateFile);

        for (String sql : sqlStatements) {
            Database.executeUpdate(sql);
        }
    }
}

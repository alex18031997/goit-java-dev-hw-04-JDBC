package services;

import config.Database;
import props.PropertyReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseInitService {

    public static void main(String[] args) throws IOException, SQLException {
        Connection conn = Database.getInstance();
        System.out.println(conn);
        String dBInitFile = PropertyReader.getDBInitFile();
        ReadSQLFile readFile = new ReadSQLFile();
        String[] sqlStatements = readFile.readFile(dBInitFile);

        for (String sql : sqlStatements) {
            DatabaseQueryService.executeUpdate(sql);
        }
    }

}

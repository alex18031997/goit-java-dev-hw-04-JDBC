package services;

import config.Database;
import interfaces.*;
import props.PropertyReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private ReadSQLFile readSQLFile = new ReadSQLFile();

    public static void main(String[] args) throws IOException, SQLException {
        Connection conn = Database.getInstance();

    }

    public List<LongestProject> FindLongestProject() throws IOException, SQLException {
        String longestProjectFile = PropertyReader.getDBFindLongestProjectFile();
        String readFile = readSQLFile.readSelectFile(longestProjectFile);

        ResultSet resultSet = Database.executeQuery(readFile);
        List<LongestProject> longestProjects = new ArrayList<>();

        while (resultSet.next()) {
            LongestProject project = new LongestProject();
            String name = resultSet.getString("NAME");
            Integer MONTH_COUNT = resultSet.getInt("MONTH_COUNT");
            project.setName(name);
            project.setMonthCount(MONTH_COUNT);
            longestProjects.add(project);
        }

        return longestProjects;
    }

    public List<MaxProjectsClient> FindMaxProjectsClient() throws IOException, SQLException {
        String maxProjectsClientFile = PropertyReader.getDBFindMaxProjectsClientFile();
        String readFile = readSQLFile.readSelectFile(maxProjectsClientFile);

        ResultSet resultSet = Database.executeQuery(readFile);
        List<MaxProjectsClient> maxProjectsClient = new ArrayList<>();

        while (resultSet.next()) {
            MaxProjectsClient project = new MaxProjectsClient();
            String name = resultSet.getString("NAME");
            Integer MONTH_COUNT = resultSet.getInt("PROJECT_COUNT");
            project.setName(name);
            project.setProjectCount(MONTH_COUNT);
            maxProjectsClient.add(project);
        }

        return maxProjectsClient;
    }

    public List<MaxSalaryWorker> FindFindMaxSalaryWorker() throws IOException, SQLException {
        String maxSalaryWorkerFile = PropertyReader.getDBFindMaxSalaryWorkerFile();
        String readFile = readSQLFile.readSelectFile(maxSalaryWorkerFile);

        ResultSet resultSet = Database.executeQuery(readFile);
        List<MaxSalaryWorker> maxSalaryWorker = new ArrayList<>();

        while (resultSet.next()) {
            MaxSalaryWorker worker = new MaxSalaryWorker();
            String name = resultSet.getString("NAME");
            Integer MONTH_COUNT = resultSet.getInt("SALARY");
            worker.setName(name);
            worker.setSalary(MONTH_COUNT);
            maxSalaryWorker.add(worker);
        }

        return maxSalaryWorker;
    }

    public List<MaxYoungestEldestWorker> FindFindYoungestEldestWorker() throws IOException, SQLException {
        String youngestEldestWorkerFile = PropertyReader.getDBFindYoungestEldestWorkerFile();
        String readFile = readSQLFile.readSelectFile(youngestEldestWorkerFile);

        ResultSet resultSet = Database.executeQuery(readFile);
        List<MaxYoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();

        while (resultSet.next()) {
            MaxYoungestEldestWorker worker = new MaxYoungestEldestWorker();
            String type = resultSet.getString("TYPE");
            String name = resultSet.getString("NAME");
            String birthday = resultSet.getString("BIRTHDAY");
            worker.setType(type);
            worker.setName(name);
            worker.setBirthday(birthday);
            youngestEldestWorkers.add(worker);
        }

        return youngestEldestWorkers;
    }

    public List<ProjectPrices> ProjectPrices() throws IOException, SQLException {
        String projectsPricesFile = PropertyReader.getDBFindProjectsPricesFile();
        String readFile = readSQLFile.readSelectFile(projectsPricesFile);

        ResultSet resultSet = Database.executeQuery(readFile);
        List<ProjectPrices> projectsPrices = new ArrayList<>();

        while (resultSet.next()) {
            ProjectPrices projectPrice = new ProjectPrices();
            String name = resultSet.getString("NAME");
            Integer PRICE = resultSet.getInt("PRICE");
            projectPrice.setName(name);
            projectPrice.setPrice(PRICE);
            projectsPrices.add(projectPrice);
        }

        return projectsPrices;
    }




}

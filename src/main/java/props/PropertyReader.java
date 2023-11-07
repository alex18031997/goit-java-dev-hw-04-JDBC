package props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static String getConnectionUrlForPostgres() {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            return new StringBuilder("jdbc:")
                    .append(prop.getProperty("postgres.db.host"))
                    .append("/")
                    .append(prop.getProperty("postgres.db.database"))
                    .toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getConnectionGetUserForPostgres() {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            return new  StringBuilder(prop.getProperty("postgres.db.user")).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getConnectionGetPasswordForPostgres() {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            return new  StringBuilder(prop.getProperty("postgres.db.password")).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getDBInitFile() throws IOException {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            return new StringBuilder(prop.getProperty("db.init.path")).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getDBPopulateFile() throws IOException {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            return new StringBuilder(prop.getProperty("db.populate.path")).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getDBFindLongestProjectFile() throws IOException {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            return new StringBuilder(prop.getProperty("db.find.longest.project.path")).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getDBFindMaxProjectsClientFile() throws IOException {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            return new StringBuilder(prop.getProperty("db.find.max.projects.client.path")).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getDBFindMaxSalaryWorkerFile() throws IOException {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            return new StringBuilder(prop.getProperty("db.find.max.salary.worker.path")).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getDBFindYoungestEldestWorkerFile() throws IOException {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            return new StringBuilder(prop.getProperty("db.find.youngest.eldest.workers.path")).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getDBFindProjectsPricesFile() throws IOException {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find file application.properties");
                return null;
            }

            prop.load(input);

            return new StringBuilder(prop.getProperty("db.print.projects.prices.path")).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}

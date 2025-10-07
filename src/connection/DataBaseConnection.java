package connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseConnection {


    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            
            Properties props = loadProperties();
            String URL = props.getProperty("db.url");
            String PASSWORD = props.getProperty("db.password");
            String USER = props.getProperty("db.user");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            return connection;
        } catch (SQLException e) {
            System.out.println(" erro ao conectar ao banco -> " + e.getMessage());
            return null;
        }

    }

    private static Properties loadProperties() {
        Properties props = new Properties();

        try (FileInputStream fs = new FileInputStream("db.propriedades")) {
            props.load(fs);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de propriedades -> " + e.getMessage());
        }
        return props;
    }

    public static void connectionClose() {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("error ao fecha connection ->" + e.getMessage());
            }
        }
    }

}

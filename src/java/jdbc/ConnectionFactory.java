package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 
 * @author ph
 */
public class ConnectionFactory {

    private static ConnectionFactory instance = null;

    private String dbHost;
    private String dbPort;
    private String dbName;
    private String dbUser;
    private String dbPassword;

    private ConnectionFactory() {
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }

        return instance;
    }

    public void readProperties() throws IOException {
        Properties properties = new Properties();

        try {
            String path = "jdbc/datasource.properties";
            InputStream input = this.getClass().getClassLoader().getResourceAsStream(path);
            properties.load(input);

            dbHost = properties.getProperty("host");
            dbPort = properties.getProperty("port");
            dbName = properties.getProperty("name");
            dbUser = properties.getProperty("user");
            dbPassword = properties.getProperty("password");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());

            throw new IOException("Erro ao obter informações do banco de dados.");
        }
    }

    public Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            readProperties();

            String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

            connection = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());

            throw new ClassNotFoundException("Erro de conexão ao banco de dados.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

            throw new SQLException("Erro de conexão ao banco de dados.");
        }

        return connection;
    }
}
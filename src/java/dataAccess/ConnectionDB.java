/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;
    import java.sql.Connection ;
    import java.util.logging.Logger ;
    import java.sql.DriverManager ;
    import java.sql.SQLException ;
    import java.util.logging.Level ;
/**
 *
 * @author gerar
 */
public class ConnectionDB {
    private Connection connection = null;
    private static Logger logger = Logger.getLogger(ConnectionDB.class.getName());
    
    public ConnectionDB() {
        /*String dbms="postgresql", host = "200.34.109.174", database = "cienciasbasicas", 
                port = "5432", user = "adminnovus", password = "Ahibrido2017";*/
        String dbms="postgresql", host = "localhost", database = "cbasicas", 
                port = "5432", user = "postgres", password = "test1234";
        try {
            //Postgresql DB
            if (dbms.equals("postgresql")) {
                Class.forName("org.postgresql.Driver");
            } else if (dbms.equals("mysql")) {
                //MySQL DB
                Class.forName("com.mysql.jdbc.Driver");
            }
            String url = "jdbc:" + dbms + "://" + host + ":" + port + "/" + database;            
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException sqle) {
            logger.log(Level.SEVERE,sqle.toString(),sqle);
            throw new RuntimeException(sqle);
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, e.toString(), e);
        }
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return the logger
     */
    public static Logger getLogger() {
        return logger;
    }

    /**
     * @param aLogger the logger to set
     */
    public static void setLogger(Logger aLogger) {
        logger = aLogger;
    }
    
}

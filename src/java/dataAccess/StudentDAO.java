/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gerar
 */
public class StudentDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());
    
    public StudentDAO (Connection connection) {
        this.connection = connection;
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
    
    public void addStudent(Student student){
        /*try { 
            statement = connection.prepareStatement("INSERT INTO Student VALUES (?,?,?,?,?,?,?,?)");
            synchronized(statement) {
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getArea());
                statement.setString(5, user.getAddress());
                statement.setString(6, user.getTelephone());
                statement.executeUpdate();
            }
            statement.close();
        }
        catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }*/
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.Instructor;
import business.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gerar
 */
public class InstructorDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());
    
    public InstructorDAO (Connection connection) {
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
    
    public Instructor findById(String id){
        Instructor instructor = null;
        try {
            statement = connection.prepareStatement("select * from \"User\" where id='"+id+"';");
            

            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    instructor = new Instructor();
                    instructor.setId(results.getString("id"));
                    instructor.setFirstName(results.getString("firstName"));
                    instructor.setLastName1(results.getString("lastName1"));
                    instructor.setLastName2(results.getString("lastName2"));
                    instructor.setEmail(results.getString("email"));
                    instructor.setPassword(results.getString("password"));
                    instructor.setPicPath(results.getString("picPath"));
                }
                statement.close();
            }
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        return instructor;
    }
}

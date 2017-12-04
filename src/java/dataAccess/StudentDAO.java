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
import java.text.*;
import dataAccess.ConnectionDB;
import java.time.LocalDate;
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
    
    /*
    login method verifies the credential for a certain user
    */
    public Student login(Student student) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
         
         String email = student.getEmail();    
         String password = student.getPassword();   
	    
         String searchQuery =
               "SELECT * FROM public." + "\"Student\"" +  " WHERE email='"
                        + email
                        + "' AND password='"
                        + password
                        + "'";
	    
      // "System.out.println"  used to trace the process of the input
      System.out.println("Your email is " + email);          
      System.out.println("Your password is " + password);
      System.out.println("Query: " + searchQuery);
	    
      try 
      {
          
          statement = connection.prepareStatement(searchQuery);
            synchronized(statement) {
                ResultSet rs = statement.executeQuery();
                boolean more = rs.next();
                
                // if user does not exist set the isValid variable to false
                if (!more) 
                {
                   System.out.println("Sorry, you are not a registered user! Please sign up first");
                   student.setValid(false);
                } 
	        
                //if user exists set the isValid variable to true
                else if (more) 
                {
                    String id = rs.getString("id");
                    String firstName = rs.getString("firstName");
                    String lastName1 = rs.getString("lastName1");
                    String lastName2 = rs.getString("lastName2");
                    String major = rs.getString("major");
                    
                    //convert Date to LocalDate due to sqlDate format
                    Date date = rs.getDate("joinDate");
                    LocalDate joinDate = date.toLocalDate();
                    
                    System.out.println("Welcome " + lastName1 + firstName);
                    student.setId(id);
                    student.setFirstName(firstName);
                    student.setLastName1(lastName1);
                    student.setLastName2(lastName2);
                    student.setMajor(major);
                    student.setJoinDate(joinDate);
                    
                    student.setValid(true);
                }
            }
            statement.close();
         //connect to DB 
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
      return student;
      }
    
    /*
    registerStudent is used to insert a new student to the DB
    */
    public String registerStudent(Student student){
        ConnectionDB con = null;
        
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("INSERT INTO public.\"Student\" VALUES (?,?,?,?,?,?,?,?)");
            synchronized(statement) {
                statement.setString(1, student.getId());
                statement.setString(2, student.getFirstName());
                statement.setString(3, student.getLastName1());
                statement.setString(4, student.getLastName2());
                statement.setString(5, student.getEmail());
                statement.setString(6, student.getPassword());
                statement.setString(7, student.getMajor());
                statement.setObject(8, student.getJoinDate());
                statement.executeUpdate();       
            }
            statement.close();
            statement = connection.prepareStatement("INSERT INTO public.\"User\" VALUES (?,?)");
            synchronized(statement) {
                statement.setString(1, student.getId());
                statement.setString(2, "STUDENT");
                statement.executeUpdate();       
            }
            statement.close();
            return "SUCCESS";
        }

        catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        
    }
    
    
    
    
}

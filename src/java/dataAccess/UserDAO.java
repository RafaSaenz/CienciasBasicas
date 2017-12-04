/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;


import static business.Hashing.SALT;
import static business.Hashing.generateHash;
import business.Student;
import business.User;
import business.Instructor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rafa S
 */
public class UserDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());
    
    //Used to hash password
    Map<String, String> DB = new HashMap<String, String>();
    public static final String SALT = "CienciasBasicas";
    
    public UserDAO (Connection connection) {
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
    public User login(User user) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
         
         String id = user.getId();
         String password = user.getPassword();
         
	//Hash password to compare to the one in DB
	String saltedPassword = SALT + user.getPassword();
	String hashedPassword = generateHash(saltedPassword);

         String searchQuery =
               "SELECT * FROM public." + "\"User\"" +  " WHERE id='"
                        + id
                        + "' AND password='"
                        + hashedPassword
                        + "'";
	    
      // "System.out.println"  used to trace the process of the input
      System.out.println("Your id is " + id);          
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
                   user.setValid(false);
                } 
	        
                //if user exists set the isValid variable to true
                else if (more) 
                {
                        //convert Date to LocalDate due to sqlDate format
                        Date date = rs.getDate("joinDate");
                        LocalDate joinDate = date.toLocalDate();
                        
                        user.setId(id);
                        user.setFirstName(rs.getString("firstName"));
                        user.setLastName1(rs.getString("lastName1"));
                        user.setLastName2(rs.getString("lastName2"));
                        user.setEmail(rs.getString("email"));
                        user.setPicPath(rs.getString("picPath"));
                        user.setMajor(rs.getString("major"));
                        user.setJoinDate(joinDate);
                        user.setRole(rs.getString("role"));
                        
                        user.setValid(true);         
                }
            }
            statement.close();
         //connect to DB 
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
      return user;
      }
    
    /*
    registerStudent is used to insert a new student to the DB
    */
    public String registerUser(User user){
        ConnectionDB con = null;
        
        //Hash password before INSERT to the DB
        String saltedPassword = SALT + user.getPassword();
	String hashedPassword = generateHash(saltedPassword);
        
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("INSERT INTO public.\"User\" VALUES (?,?,?,?,?,?,?,?,?,?)");
            synchronized(statement) {
                statement.setString(1, user.getId());
                statement.setString(2, user.getFirstName());
                statement.setString(3, user.getLastName1());
                statement.setString(4, user.getLastName2());
                statement.setString(5, user.getEmail());
                statement.setString(6, hashedPassword);
                statement.setString(7, user.getPicPath());
                statement.setString(8, user.getMajor());
                statement.setObject(9, user.getJoinDate());
                statement.setObject(10, user.getRole());
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

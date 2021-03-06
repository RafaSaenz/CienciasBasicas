/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;


import business.Area;
import static business.Hashing.SALT;
import static business.Hashing.generateHash;
import business.Student;
import business.User;
import business.Instructor;
import business.Resource;
import business.ResourceType;
import business.Subtopic;
import business.Topic;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                        + "' AND status='1'";
	    
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
            statement = connection.prepareStatement("INSERT INTO public.\"User\" VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
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
                //statement.setInt(11, user.getStatus());
                statement.setString(11, user.getTel());
                statement.setString(12, user.getLinkedin());
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
    
    public List<User> getInstructors(){
        ConnectionDB con = null;
        
        List<User> instructors = new ArrayList<>();
        User instructor = null;
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("SELECT * FROM public." + "\"User\"" +  " WHERE role='2' AND status ='1'");
            synchronized(statement) {
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                    instructor = new User();
                    instructor.setId(results.getString("id"));
                    instructor.setFirstName(results.getString("firstName"));
                    instructor.setLastName1(results.getString("lastName1"));
                    instructor.setLastName2(results.getString("lastName2"));
                    instructor.setEmail(results.getString("email"));
                    instructor.setPassword(results.getString("password"));
                    instructor.setPicPath(results.getString("picPath"));
                    instructor.setMajor(results.getString("major"));
                    
                    Date date = results.getDate("joinDate");
                    LocalDate joinDate = date.toLocalDate();
                    
                    instructor.setJoinDate(joinDate);
                    instructor.setRole(results.getString("role"));
                    
                    instructor.setTel(results.getString("tel"));
                    instructor.setLinkedin(results.getString("linkedin"));
                    instructor.setStatus(results.getInt("status"));
                   
                    instructors.add(instructor);
                }
            }
            statement.close();
        }catch (SQLException e) {
            System.err.println(e);
        }
        return instructors;
    }
    
    public List<User> getAllInstructors(){
        ConnectionDB con = null;
        
        List<User> instructors = new ArrayList<>();
        User instructor = null;
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("SELECT * FROM public." + "\"User\"" +  " WHERE role='2'");
            synchronized(statement) {
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                    instructor = new User();
                    instructor.setId(results.getString("id"));
                    instructor.setFirstName(results.getString("firstName"));
                    instructor.setLastName1(results.getString("lastName1"));
                    instructor.setLastName2(results.getString("lastName2"));
                    instructor.setEmail(results.getString("email"));
                    instructor.setPassword(results.getString("password"));
                    instructor.setPicPath(results.getString("picPath"));
                    instructor.setMajor(results.getString("major"));
                    
                    Date date = results.getDate("joinDate");
                    LocalDate joinDate = date.toLocalDate();
                    
                    instructor.setJoinDate(joinDate);
                    instructor.setRole(results.getString("role"));
                    
                    instructor.setTel(results.getString("tel"));
                    instructor.setLinkedin(results.getString("linkedin"));
                    instructor.setStatus(results.getInt("status"));
                   
                    instructors.add(instructor);
                }
            }
            statement.close();
        }catch (SQLException e) {
            System.err.println(e);
        }
        return instructors;
    }
    
        public User getInstructorsById(String id){
        ConnectionDB con = null;
        
        User instructor = new User();
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("SELECT * FROM public." + "\"User\"" +  " WHERE id ='" + id + "'");
            synchronized(statement) {
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                    instructor.setId(results.getString("id"));
                    instructor.setFirstName(results.getString("firstName"));
                    instructor.setLastName1(results.getString("lastName1"));
                    instructor.setLastName2(results.getString("lastName2"));
                    instructor.setEmail(results.getString("email"));
                    instructor.setPassword(results.getString("password"));
                    instructor.setPicPath(results.getString("picPath"));
                    instructor.setMajor(results.getString("major"));
                    
                    Date date = results.getDate("joinDate");
                    LocalDate joinDate = date.toLocalDate();
                    
                    instructor.setJoinDate(joinDate);
                    instructor.setRole(results.getString("role"));
                    
                    instructor.setTel(results.getString("tel"));
                    instructor.setLinkedin(results.getString("linkedin"));
                    instructor.setStatus(results.getInt("status"));
                }
            }
            statement.close();
        }catch (SQLException e) {
            System.err.println(e);
        }
        return instructor;
    }
        
        public List<User> getAllStudents(){
        ConnectionDB con = null;
        
        List<User> students = new ArrayList<>();
        User student = null;
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("SELECT * FROM public." + "\"User\"" +  " WHERE role='3'");
            synchronized(statement) {
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                    student = new User();
                    student.setId(results.getString("id"));
                    student.setFirstName(results.getString("firstName"));
                    student.setLastName1(results.getString("lastName1"));
                    student.setLastName2(results.getString("lastName2"));
                    student.setEmail(results.getString("email"));
                    student.setPassword(results.getString("password"));
                    student.setPicPath(results.getString("picPath"));
                    student.setMajor(results.getString("major"));
                    
                    Date date = results.getDate("joinDate");
                    LocalDate joinDate = date.toLocalDate();
                    
                    student.setJoinDate(joinDate);
                    student.setRole(results.getString("role"));
                    
                    student.setTel(results.getString("tel"));
                    student.setLinkedin(results.getString("linkedin"));
                    student.setStatus(results.getInt("status"));
                   
                    students.add(student);
                }
            }
            statement.close();
        }catch (SQLException e) {
            System.err.println(e);
        }
        return students;
    }
          
        public void disable(String id) {
        try {
            statement = connection.prepareStatement("UPDATE \"User\" SET status='0' where id='" + id + "';");
            synchronized (statement) {
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }

    public void enable(String id) {
        try {
            statement = connection.prepareStatement("UPDATE \"User\" SET status='1' where id='" + id + "';");
            synchronized (statement) {
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
   public String passwordModified(String id){
        ConnectionDB con = null;
        String password = null;
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("SELECT password FROM public.\"User\" WHERE id = '" + 
                    id + "';");
            synchronized(statement) {
                ResultSet rs = statement.executeQuery();
                rs.next();
                password = rs.getString("password");
                
            }
            statement.close();
            return password;
        }

        catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        
    }
    
    public String updateUser(User user){
        ConnectionDB con = null;
        
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("UPDATE public.\"User\" SET \"firstName\" = '" + 
                    user.getFirstName() + "'," +
                    "\"lastName1\" = '" + 
                    user.getLastName1() + "'," +
                    "\"lastName2\" = '" + 
                    user.getLastName2() + "'," +
                    "\"email\" = '" +  
                    user.getEmail() + "'," +
                    "\"picPath\" = '" + 
                    user.getPicPath() + "'," +
                    "\"tel\" = '" + 
                    user.getTel()+ "'," +
                    "\"linkedin\" = '" + 
                    user.getLinkedin() +
                    "' WHERE id='"+ user.getId() + "';");
            synchronized(statement) {
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
    
    public String updateUserPassword(User user){
        ConnectionDB con = null;
        
        //Hash password before INSERT to the DB
        String saltedPassword = SALT + user.getPassword();
	String hashedPassword = generateHash(saltedPassword);
        
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("UPDATE public.\"User\" SET \"firstName\" = '" + 
                    user.getFirstName() + "'," +
                    "\"lastName1\" = '" + 
                    user.getLastName1() + "'," +
                    "\"lastName2\" = '" + 
                    user.getLastName2() + "'," +
                    "\"email\" = '" +  
                    user.getEmail() + "'," +
                    "\"major\" = '" + 
                    user.getMajor() + "'," +
                    "\"password\" = '" + 
                    hashedPassword+
                    "' WHERE id='"+ user.getId() + "';");
            synchronized(statement) {
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
    
    public String updateStudent(User user){
        ConnectionDB con = null;
        
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("UPDATE public.\"User\" SET \"firstName\" = '" + 
                    user.getFirstName() + "'," +
                    "\"lastName1\" = '" + 
                    user.getLastName1() + "'," +
                    "\"lastName2\" = '" + 
                    user.getLastName2() + "'," +
                    "\"email\" = '" +  
                    user.getEmail() + "'," +
                    "\"major\" = '" + 
                    user.getMajor() +
                    "' WHERE id='"+ user.getId() + "';");
            synchronized(statement) {
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
    
    public String updateStudentPassword(User user){
        ConnectionDB con = null;
        
        //Hash password before INSERT to the DB
        String saltedPassword = SALT + user.getPassword();
	String hashedPassword = generateHash(saltedPassword);
        
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("UPDATE public.\"User\" SET \"firstName\" = '" + 
                    user.getFirstName() + "'," +
                    "\"lastName1\" = '" + 
                    user.getLastName1() + "'," +
                    "\"lastName2\" = '" + 
                    user.getLastName2() + "'," +
                    "\"email\" = '" +  
                    user.getEmail() + "'," +
                    "\"picPath\" = '" + 
                    user.getPicPath() + "'," +
                    "\"tel\" = '" + 
                    user.getTel()+ "'," +
                    "\"linkedin\" = '" + 
                    user.getLinkedin() + "'," +
                    "\"password\" = '" + 
                    hashedPassword+
                    "' WHERE id='"+ user.getId() + "';");
            synchronized(statement) {
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
    
    public String passwordStudentModified(String id){
        ConnectionDB con = null;
        String password = null;
        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("SELECT password FROM public.\"User\" WHERE id = '" + 
                    id + "';");
            synchronized(statement) {
                ResultSet rs = statement.executeQuery();
                rs.next();
                password = rs.getString("password");
                
            }
            statement.close();
            return password;
        }

        catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        
    }
    
    //This method checks if the user exist in the DB
        public boolean validUser(String id){
        ConnectionDB con = null;

        try { 
            con = new ConnectionDB();
            statement = connection.prepareStatement("SELECT id FROM public.\"User\" WHERE id = '" + 
                    id + "';");
            synchronized(statement) {
                statement.executeQuery();
                
            }
            statement.close();
            return true;
        }

        catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        
    }
      
}

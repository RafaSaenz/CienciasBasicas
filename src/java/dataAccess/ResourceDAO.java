/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gerar
 */
public class ResourceDAO {

    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());

    public ResourceDAO(Connection connection) {
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
    
    public int getCountByArea(Area area){
        int count = 0;
        try {
            statement = connection.prepareStatement("SELECT \"count\"(*) FROM \"Resource\" WHERE "
                    + "area='" + area.getId() + "'");
            ResultSet results = statement.executeQuery();
                while (results.next()) {
                    count = results.getInt("count");
                }
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        return count;
    }

    public List<Resource> getResources() {
        List<Resource> resources = new ArrayList<>();
        Resource resource = null;
        try {
            statement = connection.prepareStatement("SELECT\n"
                    + "	r.id AS \"r_id\",\n"
                    + "	r.title,\n"
                    + "	r.description,\n"
                    + "	r.level,\n"
                    + "	r.\"filePath\",\n"
                    + "	r.link,\n"
                    + "	r.references,\n"
                    + "	r.review,\n"
                    + "	r.\"addedDate\",\n"
                    + "	r.instructor AS \"i_id\",\n"
                    + "	i.\"firstName\",\n"
                    + "	i.\"lastName1\",\n"
                    + "	i.\"lastName2\",\n"
                    + "	r.type,\n"
                    + "	rt.description as \"rt_description\",\n"
                    + "	r.area AS \"a_id\",\n"
                    + "	a.area,\n"
                    + "	r.topic AS \"t_id\",\n"
                    + "	t.name,\n"
                    + "	r.subtopic AS \"s_id\",\n"
                    + " s.\"name\" AS \"subtopic\",\n"
                    + " r.status AS \"status\" \n"
                    + "FROM\n"
                    + "	\"Resource\" r\n"
                    + "JOIN \"User\" i ON r.instructor = i.id\n"
                    + "JOIN \"ResourceType\" rt ON r.type = rt.id\n"
                    + "JOIN \"Area\" a ON r.area = a.id\n"
                    + "JOIN \"Topic\" t ON r.topic = t.id\n"
                    + "JOIN \"Subtopic\" s ON r.subtopic = s.id\n");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    resource = new Resource();
                    resource.setId(results.getString("r_id"));
                    resource.setTitle(results.getString("title"));
                    resource.setDescription(results.getString("description"));
                    resource.setLevel(results.getString("level"));
                    resource.setFilePath(results.getString("filePath"));
                    resource.setLink(results.getString("link"));
                    resource.setReferences(results.getString("references"));
                    resource.setReview((int) (results.getFloat("review") * 20));
                    resource.setAddedDate(results.getDate("addedDate"));
                    resource.setInstructor(new Instructor(results.getString("i_id"),
                            results.getString("firstName"), results.getString("lastName1"),
                            results.getString("lastName2")));
                    resource.setType(new ResourceType(results.getString("type"),
                            results.getString("rt_description")));
                    resource.setArea(new Area(results.getString("a_id"),
                            results.getString("area")));
                    resource.setTopic(new Topic(results.getString("t_id"),
                            results.getString("name")));
                    resource.setSubtopic(new Subtopic(results.getString("s_id"),
                            results.getString("subtopic")));
                    resource.setStatus(results.getInt("status"));
                    resources.add(resource);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return resources;
    }
    
    public List<Resource> getEnabledResources() {
        List<Resource> resources = new ArrayList<>();
        Resource resource = null;
        try {
            statement = connection.prepareStatement("SELECT\n"
                    + "	r.id AS \"r_id\",\n"
                    + "	r.title,\n"
                    + "	r.description,\n"
                    + "	r.level,\n"
                    + "	r.\"filePath\",\n"
                    + "	r.link,\n"
                    + "	r.references,\n"
                    + "	r.review,\n"
                    + "	r.\"addedDate\",\n"
                    + "	r.instructor AS \"i_id\",\n"
                    + "	i.\"firstName\",\n"
                    + "	i.\"lastName1\",\n"
                    + "	i.\"lastName2\",\n"
                    + "	r.type,\n"
                    + "	rt.description as \"rt_description\",\n"
                    + "	r.area AS \"a_id\",\n"
                    + "	a.area,\n"
                    + "	r.topic AS \"t_id\",\n"
                    + "	t.name,\n"
                    + "	r.subtopic AS \"s_id\",\n"
                    + " s.\"name\" AS \"subtopic\",\n"
                    + " r.status AS \"status\" \n"
                    + "FROM\n"
                    + "	\"Resource\" r\n"
                    + "JOIN \"User\" i ON r.instructor = i.id\n"
                    + "JOIN \"ResourceType\" rt ON r.type = rt.id\n"
                    + "JOIN \"Area\" a ON r.area = a.id\n"
                    + "JOIN \"Topic\" t ON r.topic = t.id\n"
                    + "JOIN \"Subtopic\" s ON r.subtopic = s.id\n"
                    + "WHERE r.status='1';"
                    );
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    resource = new Resource();
                    resource.setId(results.getString("r_id"));
                    resource.setTitle(results.getString("title"));
                    resource.setDescription(results.getString("description"));
                    resource.setLevel(results.getString("level"));
                    resource.setFilePath(results.getString("filePath"));
                    resource.setLink(results.getString("link"));
                    resource.setReferences(results.getString("references"));
                    resource.setReview((int) (results.getFloat("review") * 20));
                    resource.setAddedDate(results.getDate("addedDate"));
                    resource.setInstructor(new Instructor(results.getString("i_id"),
                            results.getString("firstName"), results.getString("lastName1"),
                            results.getString("lastName2")));
                    resource.setType(new ResourceType(results.getString("type"),
                            results.getString("rt_description")));
                    resource.setArea(new Area(results.getString("a_id"),
                            results.getString("area")));
                    resource.setTopic(new Topic(results.getString("t_id"),
                            results.getString("name")));
                    resource.setSubtopic(new Subtopic(results.getString("s_id"),
                            results.getString("subtopic")));
                    resource.setStatus(results.getInt("status"));
                    resources.add(resource);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return resources;
    }

    public Resource getById(String id) {
        Resource resource = new Resource();;
        try {
            statement = connection.prepareStatement("SELECT\n"
                    + "	r.id AS \"r_id\",\n"
                    + "	r.title,\n"
                    + "	r.description,\n"
                    + "	r.level,\n"
                    + "	r.\"filePath\",\n"
                    + "	r.link,\n"
                    + "	r.references,\n"
                    + "	r.review,\n"
                    + "	r.\"addedDate\",\n"
                    + "	r.instructor AS \"i_id\",\n"
                    + "	i.\"firstName\",\n"
                    + "	i.\"lastName1\",\n"
                    + "	i.\"lastName2\",\n"
                    + "	r.type,\n"
                    + "	rt.description as \"rt_description\",\n"
                    + "	r.area AS \"a_id\",\n"
                    + "	a.area,\n"
                    + "	r.topic AS \"t_id\",\n"
                    + "	t.name,\n"
                    + "	r.subtopic AS \"s_id\",\n"
                    + " s.\"name\" AS \"subtopic\",\n"
                    + "	r.status AS \"status\" \n"
                    + "FROM\n"
                    + "	\"Resource\" r\n"
                    + "JOIN \"User\" i ON r.instructor = i.id\n"
                    + "JOIN \"ResourceType\" rt ON r.type = rt.id\n"
                    + "JOIN \"Area\" a ON r.area = a.id\n"
                    + "JOIN \"Topic\" t ON r.topic = t.id\n"
                    + "JOIN \"Subtopic\" s ON r.subtopic = s.id\n"
                    + "WHERE r.id='" + id + "'"
                    + "ORDER BY\n"
                    + "	r. ID");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    resource.setId(results.getString("r_id"));
                    resource.setTitle(results.getString("title"));
                    resource.setDescription(results.getString("description"));
                    resource.setLevel(results.getString("level"));
                    resource.setFilePath(results.getString("filePath"));
                    resource.setLink(results.getString("link"));
                    resource.setReferences(results.getString("references"));
                    resource.setReview((int) (results.getFloat("review") * 20));
                    resource.setAddedDate(results.getDate("addedDate"));
                    resource.setInstructor(new Instructor(results.getString("i_id"),
                            results.getString("firstName"), results.getString("lastName1"),
                            results.getString("lastName2")));
                    resource.setType(new ResourceType(results.getString("type"),
                            results.getString("rt_description")));
                    resource.setArea(new Area(results.getString("a_id"),
                            results.getString("area")));
                    resource.setTopic(new Topic(results.getString("t_id"),
                            results.getString("name")));
                    resource.setSubtopic(new Subtopic(results.getString("s_id"),
                            results.getString("subtopic")));
                    resource.setStatus(results.getInt("status"));
                }
            }
            statement.close();
            return resource;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    public void add(Resource resource) {
        try {
            statement = connection.prepareStatement("INSERT INTO \"Resource\"\n"
                    + "VALUES\n"
                    + "	(\n"
                    + "		?,?,?,?,?,?,?,?,?,?,0.00,?,?,?\n"
                    + "	)");
            synchronized (statement) {
                statement.setString(1, resource.getId());
                statement.setString(2, resource.getTitle());
                statement.setString(3, resource.getDescription());
                statement.setString(4, resource.getType().getId());
                statement.setString(5, resource.getSubtopic().getId());
                statement.setString(6, resource.getLevel());
                statement.setString(7, resource.getFilePath());
                statement.setString(8, resource.getLink());
                statement.setString(9, resource.getInstructor().getId());
                statement.setString(10, resource.getReferences());
                statement.setDate(11, (Date) resource.getAddedDate());
                statement.setString(12, resource.getArea().getId());
                statement.setString(13, resource.getTopic().getId());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public int getCountBySubtopic(Subtopic subtopic) {
        int count = 0;
        try {
            statement = connection.prepareStatement("select count(*) from \"Resource\" where subtopic='"+subtopic.getId()+"'");
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                count = results.getInt("count");
            }
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        return count;
    }
    
    public void delete(String id) {
        try {
            statement = connection.prepareStatement("DELETE FROM \"Resource\" WHERE id='" + id + "'");
            synchronized (statement) {
                
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
}

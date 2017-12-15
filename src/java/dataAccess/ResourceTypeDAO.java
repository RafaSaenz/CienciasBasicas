/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.Instructor;
import business.Resource;
import business.ResourceType;
import business.Topic;
import java.sql.Connection;
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
public class ResourceTypeDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());
    
    public ResourceTypeDAO (Connection connection) {
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
    
    public List<ResourceType> getTypes() {
        List<ResourceType> types = new ArrayList<>();
        ResourceType type = null;
        try {
            statement = connection.prepareStatement("select * from \"ResourceType\" order by id;");            
            synchronized (statement) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    type = new ResourceType();
                    type.setId(results.getString("id"));
                    type.setDescription(results.getString("description"));
                    type.setStatus(results.getInt("status"));
                    types.add(type);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return types;
    }
    
    public List<ResourceType> getEnabledTypes() {
        List<ResourceType> types = new ArrayList<>();
        ResourceType type = null;
        try {
            statement = connection.prepareStatement("select * from \"ResourceType\" where status='1' order by id;");            
            synchronized (statement) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    type = new ResourceType();
                    type.setId(results.getString("id"));
                    type.setDescription(results.getString("description"));
                    type.setStatus(results.getInt("status"));
                    types.add(type);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return types;
    }
    
    public int getCount() {
        int count = 0;
        try {
            statement = connection.prepareStatement("select count(*) from \"ResourceType\";");
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
    
    public void add(ResourceType resType) {
        try {
            statement = connection.prepareStatement("INSERT INTO public.\"ResourceType\"(\n"
                    + "	id, description, status)\n"
                    + "	VALUES (?, ?, ?);");
            synchronized (statement) {
                statement.setString(1, resType.getId());
                statement.setString(2, resType.getDescription());
                statement.setInt(3, resType.getStatus());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public void update(ResourceType resType) {
        try {
            statement = connection.prepareStatement("UPDATE public.\"ResourceType\"\n"
                    + "	SET description=?\n"
                    + "	WHERE id=?;");
            synchronized (statement) {
                statement.setString(1, resType.getDescription());
                statement.setString(2, resType.getId());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public void disable(String id) {
        try {
            statement = connection.prepareStatement("UPDATE \"ResourceType\" SET status='0' where id='" + id + "';");
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
            statement = connection.prepareStatement("UPDATE \"ResourceType\" SET status='1' where id='" + id + "';");
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

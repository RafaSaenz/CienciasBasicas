/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.*;
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
public class SubtopicDAO {

    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());

    public SubtopicDAO(Connection connection) {
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

    public List<Subtopic> getEnabledByTopic(String topic) {
        List<Subtopic> subtopics = new ArrayList<>();
        Subtopic subtopic = null;
        try {
            statement = connection.prepareStatement("select * from \"Subtopic\" where topic='" + topic + "' and status='1' order by id;");

            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    subtopic = new Subtopic();
                    subtopic.setId(results.getString("id"));
                    subtopic.setName(results.getString("name"));
                    subtopic.setTopic(results.getString("topic"));
                    subtopic.setStatus(results.getInt("status"));
                    subtopics.add(subtopic);
                }
                statement.close();
            }
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        return subtopics;
    }
    public List<Subtopic> getByTopic(String topic) {
        List<Subtopic> subtopics = new ArrayList<>();
        Subtopic subtopic = null;
        try {
            statement = connection.prepareStatement("select * from \"Subtopic\" where topic='" + topic + "' order by id;");

            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    subtopic = new Subtopic();
                    subtopic.setId(results.getString("id"));
                    subtopic.setName(results.getString("name"));
                    subtopic.setTopic(results.getString("topic"));
                    subtopic.setStatus(results.getInt("status"));
                    subtopics.add(subtopic);
                }
                statement.close();
            }
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        return subtopics;
    }
    
    public void add(Subtopic subtopic) {
        try {
            statement = connection.prepareStatement("INSERT INTO public.\"Subtopic\"(\n"
                    + "	id, name, topic, status)\n"
                    + "	VALUES (?, ?, ?, ?);");
            synchronized (statement) {
                statement.setString(1, subtopic.getId());
                statement.setString(2, subtopic.getName());
                statement.setString(3, subtopic.getTopic());
                statement.setInt(4, subtopic.getStatus());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public int getCountByTopic(Topic topic) {
        int count = 0;
        try {
            statement = connection.prepareStatement("select count(*) from \"Subtopic\" where topic='" + topic.getId() + "'");
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
    
    public void enable(String id) {
        try {
            statement = connection.prepareStatement("UPDATE \"Subtopic\" SET status='1' where id='" + id + "';");
            synchronized (statement) {
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
            statement = connection.prepareStatement("UPDATE \"Subtopic\" SET status='0' where id='" + id + "';");
            synchronized (statement) {
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public void update(Subtopic subtopic) {
        try {
            statement = connection.prepareStatement("UPDATE public.\"Subtopic\"\n"
                    + "	SET name=?\n"
                    + "	WHERE id=?;");
            synchronized (statement) {
                statement.setString(1, subtopic.getName());
                statement.setString(2, subtopic.getId());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
}

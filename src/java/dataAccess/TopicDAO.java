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
public class TopicDAO {

    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());

    public TopicDAO(Connection connection) {
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

    public List<Topic> getEnabledByArea(String area) {
        List<Topic> topics = new ArrayList<>();
        Topic topic = null;
        try {
            statement = connection.prepareStatement("select * from \"Topic\" where area='" + area + "' and status='1' order by id;");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    topic = new Topic();
                    topic.setId(results.getString("id"));
                    topic.setName(results.getString("name"));
                    topic.setArea(results.getString("area"));
                    topic.setStatus(results.getInt("status"));
                    topics.add(topic);
                }
                statement.close();
            }
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        return topics;
    }

    public List<Topic> getByArea(String area) {
        List<Topic> topics = new ArrayList<>();
        Topic topic = null;
        try {
            statement = connection.prepareStatement("select * from \"Topic\" where area='" + area + "' order by id;");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    topic = new Topic();
                    topic.setId(results.getString("id"));
                    topic.setName(results.getString("name"));
                    topic.setArea(results.getString("area"));
                    topic.setStatus(results.getInt("status"));
                    topics.add(topic);
                }
                statement.close();
            }
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
        return topics;
    }

    public int getCountByArea(Area area) {
        int count = 0;
        try {
            statement = connection.prepareStatement("select count(*) from \"Topic\" where area='" + area.getId() + "'");
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

    public Topic getById(String id) {
        Topic topic = null;
        try {
            statement = connection.prepareStatement("select * from \"Topic\" where id='" + id + "'");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    topic = new Topic();
                    topic.setId(results.getString("id"));
                    topic.setName(results.getString("name"));
                    topic.setStatus(results.getInt("status"));
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return topic;
    }

    public void add(Topic topic) {
        try {
            statement = connection.prepareStatement("INSERT INTO public.\"Topic\"(\n"
                    + "	id, name, area, status)\n"
                    + "	VALUES (?, ?, ?, ?);");
            synchronized (statement) {
                statement.setString(1, topic.getId());
                statement.setString(2, topic.getName());
                statement.setString(3, topic.getArea());
                statement.setInt(4, topic.getStatus());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }

    public void update(Topic topic) {
        try {
            statement = connection.prepareStatement("UPDATE public.\"Topic\"\n"
                    + "	SET name='" + topic.getName() + "'\n"
                    + "	WHERE id='" + topic.getId() + "';");
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
            statement = connection.prepareStatement("UPDATE \"Topic\" SET status='0' where id='" + id + "';");
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
            statement = connection.prepareStatement("UPDATE \"Topic\" SET status='1' where id='" + id + "';");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.Instructor;
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
public class TopicDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());
    
    public TopicDAO (Connection connection) {
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
    
    public List<Topic> findByArea(String area){
        List<Topic> topics = new ArrayList<>();
        Topic topic = null;
        try {
            statement = connection.prepareStatement("select * from \"Topic\" where area='"+area+"';");
            
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    topic = new Topic();
                    topic.setId(results.getString("id"));
                    topic.setName(results.getString("name"));
                    topic.setArea(results.getString("area"));
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
}

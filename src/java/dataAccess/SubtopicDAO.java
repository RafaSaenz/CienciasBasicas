/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.Instructor;
import business.Subtopic;
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
public class SubtopicDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());
    
    public SubtopicDAO (Connection connection) {
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
    
    public List<Subtopic> findByTopic(String topic){
        List<Subtopic> subtopics = new ArrayList<>();
        Subtopic subtopic = null;
        try {
            statement = connection.prepareStatement("select * from \"Subtopic\" where topic='"+topic+"';");
            
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    subtopic = new Subtopic();
                    subtopic.setId(results.getInt("id"));
                    subtopic.setName(results.getString("name"));
                    subtopic.setTopic(results.getString("topic"));
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
}

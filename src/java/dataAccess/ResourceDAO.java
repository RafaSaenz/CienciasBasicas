/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.Resource;
import business.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author gerar
 */
public class ResourceDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());
    
    public ResourceDAO (Connection connection) {
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
    
    public List<Resource> getResources() {
        List<Resource> resources = new ArrayList<>();
        Resource resource = null;
        try {
            statement = connection.prepareStatement("select * from \"Resource\" r join \"Instructor\" i on r.instructor=i.id ORDER BY r.id;");            
            synchronized (statement) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    resource = new Resource();
                    resource.setId(results.getString("id"));
                    resource.setTitle(results.getString("title"));
                    resource.setDescription(results.getString("description"));
                    resource.setType(results.getString("type"));
                    resource.setSubtopic(results.getString("subtopic"));
                    resource.setLevel(results.getString("level"));
                    resource.setFilePath(results.getString("filePath"));
                    resource.setLink(results.getString("link"));
                    resource.setInstructor(results.getString("firstName") + " " + results.getString("lastName1"));
                    resource.setReferences(results.getString("references"));
                    resource.setReview((int)(results.getFloat("review")*20));
                    resource.setAddedDate(results.getDate("addedDate"));
                    resources.add(resource);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return resources;
    }
}

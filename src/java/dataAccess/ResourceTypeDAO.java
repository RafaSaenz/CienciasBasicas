/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.Instructor;
import business.Resource;
import business.ResourceType;
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
            statement = connection.prepareStatement("select * from \"ResourceType\";");            
            synchronized (statement) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    type = new ResourceType();
                    type.setId(results.getString("id"));
                    type.setDescription(results.getString("description"));
                    types.add(type);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return types;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.Area;
import business.FileObj;
import business.Resource;
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
public class FileDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());

    public FileDAO(Connection connection) {
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
    
    public FileObj getById(String id) {
        FileObj file = null;
        try {
            statement = connection.prepareStatement("select * from \"File\" WHERE id=?");
            synchronized (statement) {
                statement.setString(1, id);
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    file = new FileObj();
                    file.setId(results.getString("id"));
                    file.setFilepath(results.getString("filepath"));
                    file.setFilepath(results.getString("type"));
                    file.setResource(new Resource(results.getString("resource")));
                    file.setStatus(results.getInt("status"));
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return file;
    }
    
    public List<FileObj> getByResource(String id) {
        List<FileObj> files = new ArrayList<>();
        FileObj file = null;
        try {
            statement = connection.prepareStatement("select * from \"File\" WHERE resource=?");
            synchronized (statement) {
                statement.setString(1, id);
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    file = new FileObj();
                    file.setId(results.getString("id"));
                    file.setFilepath(results.getString("filepath"));
                    file.setType(results.getString("type"));
                    file.setResource(new Resource(results.getString("resource")));
                    file.setStatus(results.getInt("status"));
                    files.add(file);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return files;
    }
    
    public void add(FileObj fileObj) {
        try {
            statement = connection.prepareStatement("INSERT INTO public.\"File\"(\n"
                    + "	id, filepath, type, resource, status)\n"
                    + "	VALUES (?, ?, ?, ?, ?);");
            synchronized (statement) {
                statement.setString(1, fileObj.getId());
                statement.setString(2, fileObj.getFilepath());
                statement.setString(3, fileObj.getType());
                statement.setString(4, fileObj.getResource().getId());
                statement.setInt(5, fileObj.getStatus());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public int countByResource(String id) {
        int count = 0;
        try {
            statement = connection.prepareStatement("select count(*) from \"File\" where resource=?");
            synchronized (statement) {
                statement.setString(1, id);
            }
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
}

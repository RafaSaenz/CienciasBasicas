/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import business.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author gerar
 */
public class AreaDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(StudentDAO.class.getName());

    public AreaDAO(Connection connection) {
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

    public List<Area> getAreas() {
        List<Area> areas = new ArrayList<>();
        Area area = null;
        try {
            statement = connection.prepareStatement("select * from \"Area\";");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    area = new Area();
                    area.setId(results.getString("id"));
                    area.setArea(results.getString("area"));
                    area.setStatus(results.getInt("status"));
                    areas.add(area);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return areas;
    }
    
    public List<Area> getEnabledAreas() {
        List<Area> areas = new ArrayList<>();
        Area area = null;
        try {
            statement = connection.prepareStatement("select * from \"Area\" where status='1'");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    area = new Area();
                    area.setId(results.getString("id"));
                    area.setArea(results.getString("area"));
                    area.setStatus(results.getInt("status"));
                    areas.add(area);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return areas;
    }
    
    public Area getById(String id) {
        Area area = null;
        try {
            statement = connection.prepareStatement("select * from \"Area\" where id='" + id + "'");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    area = new Area();
                    area.setId(results.getString("id"));
                    area.setArea(results.getString("area"));
                    area.setStatus(results.getInt("status"));
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return area;
    }
}

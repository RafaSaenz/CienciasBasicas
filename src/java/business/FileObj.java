/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author gerar
 */
public class FileObj {
    private String id;
    private String filepath;
    private String type;
    private Resource resource;
    private int status;

    public FileObj(String id) {
        this.id = id;
    }

    public FileObj(String id, String filepath, String extension, Resource resource, int status) {
        this.id = id;
        this.filepath = filepath;
        this.type = extension;
        this.resource = resource;
        this.status = status;
    }

    public FileObj(String id, String filepath, Resource resource, int status) {
        this.id = id;
        this.filepath = filepath;
        this.resource = resource;
        this.status = status;
    }

    public FileObj() {
    }

    public String getId() {
        return id;
    }

    public String getFilepath() {
        return filepath;
    }

    public String getType() {
        return type;
    }

    public Resource getResource() {
        return resource;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
    
}

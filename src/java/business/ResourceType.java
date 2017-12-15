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
public class ResourceType {
    private String id;
    private String description;
    private int status;
    
    public ResourceType(){
        
    }
    
    public ResourceType(String id, String description){
        this.id = id;
        this.description = description;
    }

    public ResourceType(String id, String description, int status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }
    
    public ResourceType(String id){
        this.id = id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}

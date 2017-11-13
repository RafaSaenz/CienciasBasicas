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
public class Topic {
    private String id;
    private String name;
    private String area;

    public Topic(String id, String name, String area){
        this.id = id;
        this.name = name;
        this.area = area;
    }
    
    public Topic(String id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Topic(String id){
        this.id = id;
    }
    
    public Topic(){
        
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }
    
    
}

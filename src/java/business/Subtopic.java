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
public class Subtopic {
    private String id;
    private String name;
    private String topic;

    public Subtopic(String id, String name, String topic){
        this.id = id;
        this.name = name;
        this.topic = topic;
    }
    
    public Subtopic(String id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Subtopic(String id){
        this.id = id;
    }

    public Subtopic() {
        
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
     * @return the subtopic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * @param topic the subtopic to set
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }
}

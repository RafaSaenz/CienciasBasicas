/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;

/**
 *
 * @author gerar
 */
public class Resource {
    private String id;
    private String title;
    private String description;
    private String type;
    private String subtopic;
    private String level;
    private String filePath;
    private String link;
    private String instructor;
    private String references;
    private int review;
    private Date addedDate;
    
    public Resource(){
        
    }
    
    public Resource(String id, String title, String description, String type, String subtopic, String level, String filePath, String link, String instructor, String references, int review, Date addedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.subtopic = subtopic;
        this.level = level;
        this.filePath = filePath;
        this.link = link;
        this.instructor = instructor;
        this.references = references;
        this.review = review;
        this.addedDate = addedDate;
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the subtopic
     */
    public String getSubtopic() {
        return subtopic;
    }

    /**
     * @param subtopic the subtopic to set
     */
    public void setSubtopic(String subtopic) {
        this.subtopic = subtopic;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    /**
     * @return the references
     */
    public String getReferences() {
        return references;
    }

    /**
     * @param references the references to set
     */
    public void setReferences(String references) {
        this.references = references;
    }

    /**
     * @return the review
     */
    public int getReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(int review) {
        this.review = review;
    }

    /**
     * @return the addedDate
     */
    public Date getAddedDate() {
        return addedDate;
    }

    /**
     * @param addedDate the addedDate to set
     */
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}

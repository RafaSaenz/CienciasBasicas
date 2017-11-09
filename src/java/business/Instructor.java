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
public class Instructor {
    private String id;
    private String firstName;
    private String lastName1;
    private String lastName2;
    private String email;
    private String password;
    private String major;
    private String picPath;

    public Instructor(String id, String firstName, String lastName1, 
            String lastName2, String email, String password, 
            String major, String picPath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.email = email;
        this.password = password;
        this.major = major;
        this.picPath = picPath;
    }
    
    public Instructor(){
        
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName1
     */
    public String getLastName1() {
        return lastName1;
    }

    /**
     * @param lastName1 the lastName1 to set
     */
    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    /**
     * @return the lastName2
     */
    public String getLastName2() {
        return lastName2;
    }

    /**
     * @param lastName2 the lastName2 to set
     */
    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the picPath
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * @param picPath the picPath to set
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}

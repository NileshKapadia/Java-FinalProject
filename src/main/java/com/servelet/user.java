/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servelet;

/**
 *
 * @author NILESH
 */
public class user {
    
    private String image;
    private String caption;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String username;
    
    
    
    public user(){
    
    }

    public user(String image, String caption, String username){
    
        
      
        this.image =image;
        this.username= username;
        this.caption=caption;                
        
    }
    
}

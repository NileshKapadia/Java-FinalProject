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

    /**
     *
     * @return
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return
     */
    public String getCaption() {
        return caption;
    }

    /**
     *
     * @param caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    private String username;

    /**
     *
     */
    public user() {

    }

    /**
     *
     * @param image
     * @param caption
     * @param username
     */
    public user(String image, String caption, String username) {

        this.image = image;
        this.username = username;
        this.caption = caption;

    }

}

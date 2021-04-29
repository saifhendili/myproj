/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

/**
 *
 * @author saif
 */
public class Likes {
    private String id;
    private String id_publication;
    private String id_user;

    public Likes(String id, String id_publication, String id_user) {
        this.id = id;
        this.id_publication = id_publication;
        this.id_user = id_user;
    }

    public Likes(String id_publication, String id_user) {
        this.id_publication = id_publication;
        this.id_user = id_user;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_publication() {
        return id_publication;
    }

    public void setId_publication(String id_publication) {
        this.id_publication = id_publication;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    
    
}

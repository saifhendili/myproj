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
public class FormAide {
 private String id;
    private String IdUser;
    private String nom;
    private String prenom;
    private String img;
    private String description;
    private String quantit;
    private String categories;

    public FormAide(String id, String IdUser, String nom, String prenom, String img, String description, String quantit, String categories) {
        this.id = id;
        this.IdUser = IdUser;
        this.nom = nom;
        this.prenom = prenom;
        this.img = img;
        this.description = description;
        this.quantit = quantit;
        this.categories = categories;
    }

    public FormAide(String IdUser, String nom, String prenom, String img, String description, String quantit, String categories) {
        this.IdUser = IdUser;
        this.nom = nom;
        this.prenom = prenom;
        this.img = img;
        this.description = description;
        this.quantit = quantit;
        this.categories = categories;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String IdUser) {
        this.IdUser = IdUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantit() {
        return quantit;
    }

    public void setQuantit(String quantit) {
        this.quantit = quantit;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
   
}

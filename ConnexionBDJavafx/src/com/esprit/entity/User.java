/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

import java.util.Objects;

/**
 *
 * @author Dell
 */
public class User {
    private String id;
    private String nom;
    public String age;
    private String prenom;
    private String adress;
    private String type;
    private String email;
   private String roles;
   private String password;
   private String Speciality;
   private String reset_token;
   private String is_confirmed;
   private String is_activated;
   
   public User(){
        
    }

    public User(String id, String nom, String age, String prenom, String adress, String type, String email, String roles, String password, String Speciality, String reset_token, String is_confirmed, String is_activated) {
        this.id = id;
        this.nom = nom;
        this.age = age;
        this.prenom = prenom;
        this.adress = adress;
        this.type = type;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.Speciality = Speciality;
        this.reset_token = reset_token;
        this.is_confirmed = is_confirmed;
        this.is_activated = is_activated;
    }

    public User(String nom, String age, String prenom, String adress, String type, String email, String password, String Speciality) {
        this.nom = nom;
        this.age = age;
        this.prenom = prenom;
        this.adress = adress;
        this.type = type;
        this.email = email;
        this.password = password;
        this.Speciality = Speciality;
    }

 

    
  
        public User( String nom, String age, String prenom, String adress, String type, String email, String roles, String password, String Speciality, String reset_token, String is_confirmed, String is_activated) {
        
        this.nom = nom;
        this.age = age;
        this.prenom = prenom;
        this.adress = adress;
        this.type = type;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.Speciality = Speciality;
        this.reset_token = reset_token;
        this.is_confirmed = is_confirmed;
        this.is_activated = is_activated;
    }

  

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String Speciality) {
        this.Speciality = Speciality;
    }

    public String getReset_token() {
        return reset_token;
    }

    public void setReset_token(String reset_token) {
        this.reset_token = reset_token;
    }

    public String getIs_confirmed() {
        return is_confirmed;
    }

    public void setIs_confirmed(String is_confirmed) {
        this.is_confirmed = is_confirmed;
    }

    public String getIs_activated() {
        return is_activated;
    }

    public void setIs_activated(String is_activated) {
        this.is_activated = is_activated;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.adress, other.adress)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.Speciality, other.Speciality)) {
            return false;
        }
        if (!Objects.equals(this.reset_token, other.reset_token)) {
            return false;
        }
        if (!Objects.equals(this.is_confirmed, other.is_confirmed)) {
            return false;
        }
        if (!Objects.equals(this.is_activated, other.is_activated)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", age=" + age + ", prenom=" + prenom + ", adress=" + adress + ", type=" + type + ", email=" + email + ", roles=" + roles + ", password=" + password + ", Speciality=" + Speciality + ", reset_token=" + reset_token + ", is_confirmed=" + is_confirmed + ", is_activated=" + is_activated + '}';
    }
   

  


  
  

 


  
    
}

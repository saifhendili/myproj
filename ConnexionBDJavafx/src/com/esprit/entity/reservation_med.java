/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

/**
 *
 * @author ACER
 */
public class reservation_med {
    	private String id ;	
        private String id_med ; 
        private String  nom_med ; 	
        private String id_patient; 	  
        private String id_phar ; 

    public reservation_med(String id, String id_med, String nom_med, String id_patient, String id_phar) {
        this.id = id;
        this.id_med = id_med;
        this.nom_med = nom_med;
        this.id_patient = id_patient;
        this.id_phar = id_phar;
    }

    
    

    public reservation_med(String id_med, String nom_med, String id_patient, String id_phar) {
        this.id_med = id_med;
        this.nom_med = nom_med;
        this.id_patient = id_patient;
        this.id_phar = id_phar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




    public String getId_med() {
        return id_med;
    }

  

    public String getNom_med() {
        return nom_med;
    }

    public void setNom_med(String nom_med) {
        this.nom_med = nom_med;
    }

    public String getId_patient() {
        return id_patient;
    }

    public void setId_patient(String id_patient) {
        this.id_patient = id_patient;
    }

    public String getId_phar() {
        return id_phar;
    }

    public void setId_phar(String id_phar) {
        this.id_phar = id_phar;
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
        final reservation_med other = (reservation_med) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
       
    }

    @Override
    public String toString() {
        return "reservation_med{" + "id=" + id + ", id_med=" + id_med + ", nom_med=" + nom_med + ", id_patient=" + id_patient + ", id_phar=" + id_phar + '}';
    }

  

   
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

import java.util.Objects;

/**
 *
 * @author ACER
 */
public class panier {
    private String id ; 
    private int idmed	;
    private String nommed ;
   private Float prixmed;
private String  id_user;

    public panier(String id, int idmed, String nommed, Float prixmed, String id_user) {
        this.id = id;
        this.idmed = idmed;
        this.nommed = nommed;
        this.prixmed = prixmed;
        this.id_user = id_user;
    }

    public panier(int idmed, String nommed, Float prixmed, String id_user) {
        this.idmed = idmed;
        this.nommed = nommed;
        this.prixmed = prixmed;
        this.id_user = id_user;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public int getIdmed() {
        return idmed;
    }

    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    public String getNommed() {
        return nommed;
    }

    public void setNommed(String nommed) {
        this.nommed = nommed;
    }

    public Float getPrixmed() {
        return prixmed;
    }

    public void setPrixmed(Float prixmed) {
        this.prixmed = prixmed;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final panier other = (panier) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "panier{" + "id=" + id + ", idmed=" + idmed + ", nommed=" + nommed + ", prixmed=" + prixmed + '}';
    }
    
    
}


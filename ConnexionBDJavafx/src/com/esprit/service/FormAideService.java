/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entity.Commentaire;
import com.esprit.entity.FormAide;
import com.esprit.entity.Personne;
import com.esprit.utils.MyDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author saif
 */
public class FormAideService {
    
    Connection cnx;
    Statement ste;

    public FormAideService() throws SQLException {
        cnx = MyDb.getInstance().getConnection();
        ste = cnx.createStatement();
    }

   
    public void ajouterFormAide(FormAide t) throws SQLException {



        String requeteInsert = "INSERT INTO `formaide` (`id`,`IdUser`, `nom`, `prenom`, `img`, `description`, `quantit`, `categories`) VALUES (NULL, '" + t.getIdUser() + "',  '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getImg() + "', '" + t.getDescription() + "', '" + t.getQuantit() + "', '" + t.getCategories() + "');";
        ste.executeUpdate(requeteInsert);
   

    }

    
    public void delete(String id) throws SQLException {
         ResultSet result =  ste.executeQuery("SELECT * FROM `formaide` WHERE `id`= '" + id + "' ");
         result.last();
         if(result.getRow()>0){
           String requeteUpdate = "DELETE FROM `formaide` WHERE `id`='" + id + "';";
        ste.executeUpdate(requeteUpdate);
           System.out.println("produit a été supprimer");
         }else {
            System.out.println("echec");
         }
       
        
    }

    
    public void update(String id ,String img,String description ,String quantit ,String categories) throws SQLException {
             ResultSet result =  ste.executeQuery("SELECT `nom` FROM `formaide` WHERE `id`= '" + id + "' ");
         result.last();
         if(result.getRow()>0){
           String requeteUpdate = "UPDATE `formaide` SET `img`='" + img + "',`description`='" + description + "',`quantit`='" + quantit + "',`categories`='" + categories + "' WHERE `id`='" + id + "';";
        ste.executeUpdate(requeteUpdate);
           System.out.println("Update avec succes");
         }else {
            System.out.println("echec");
         }
       
        
    }

    
    public List<FormAide> readAll() throws SQLException {
        ObservableList<FormAide>  form = FXCollections.observableArrayList();
        ResultSet result =  ste.executeQuery("select * from formaide");
        while(result.next()){
            form.add(new FormAide(result.getString("id"),result.getString("idUser"), result.getString("nom"), result.getString("prenom"), result.getString("img"),result.getString("description"),result.getString("quantit"),result.getString("categories")));
        }
        
        return form;
    }
    
      public List<FormAide> Search(String mychar) throws SQLException {
             ObservableList<FormAide>  forme = FXCollections.observableArrayList();
     
        ResultSet result =  ste.executeQuery("SELECT * FROM `formaide` WHERE `description`LIKE '" + mychar + "'");

         while(result.next()){
            forme.add(new FormAide(result.getString("id"),result.getString("idUser"), result.getString("nom"), result.getString("prenom"), result.getString("img"),result.getString("description"),result.getString("quantit"),result.getString("categories")));
        }
        return forme;
    }
}
    
    







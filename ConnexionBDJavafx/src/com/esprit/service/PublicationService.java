/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entity.Commentaire;
import com.esprit.entity.Personne;
import com.esprit.entity.Publication;
import com.esprit.dao.IService;
import com.esprit.utils.MyDb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author saif
 */
public class PublicationService {
       Connection cnx;
    Statement ste;

    public PublicationService() throws SQLException {
        cnx = MyDb.getInstance().getConnection();
        ste = cnx.createStatement();
    }

      public void ajouter(Publication t) throws SQLException {

               String requeteInsert = "INSERT INTO `publication` (`id`, `id_user`, `publication_text`, `img`, `nom_user`, `prenom_user`) VALUES (NULL, '" + t.getId_user() + "', '" + t.getPublication_text() + "', '" + t.getImg() + "', '" + t.getNom_user() + "', '" + t.getPrenom_user()  + "');";
        ste.executeUpdate(requeteInsert);
    }



      
    public void delete(String id) throws SQLException {
         ResultSet result =  ste.executeQuery("SELECT * FROM `publication` WHERE `id`= '" + id + "' ");
         result.last();
         if(result.getRow()>0){
           String requeteUpdate = "DELETE FROM `publication` WHERE `id`='" + id + "';";
        ste.executeUpdate(requeteUpdate);
           System.out.println("publication a été supprimer");
         }else {
            System.out.println("echec");
         }
       
        
    }
    
   
    public void update(String id ,String publication_text ) throws SQLException {
             ResultSet result =  ste.executeQuery("SELECT* FROM `publication` WHERE `id`= '" + id + "' ");
         result.last();
         if(result.getRow()>0){
           String requeteUpdate = "UPDATE `publication` SET `publication_text`='" + publication_text + "' WHERE `id`= '" + id + "' ;";
        ste.executeUpdate(requeteUpdate);
           System.out.println("Update Publication avec succes");
         }else {
            System.out.println("echec");
         }
       
        
    }

      public List<Publication> readAll() throws SQLException {
      
        ObservableList<Publication>  Publist = FXCollections.observableArrayList();
        ResultSet result =  ste.executeQuery("select * from publication");

        while(result.next()){
        Publist.add(new Publication(result.getString("id"), result.getString(2), result.getString("publication_text"), result.getString("img"), result.getString("nom_user"), result.getString("prenom_user")));
        }
           return Publist;
           }

       
           
           
       public List<Commentaire> MyCommentByPub(String id_pub) throws SQLException {
     ObservableList<Commentaire>  Comment = FXCollections.observableArrayList();
       
        ResultSet result =  ste.executeQuery("SELECT * FROM `commentaire`  WHERE `id_publication`='" + id_pub + "'");
        while(result.next()){
               Comment.add(new Commentaire(result.getString(1), result.getString(2), result.getString(3), result.getString("commentaire_text"), result.getString("nom_user"), result.getString("prenom_user")));

        // Comment.add(new Comment(result.getString("likes"));
        
        }
           return Comment;
           }
      
      
      
}

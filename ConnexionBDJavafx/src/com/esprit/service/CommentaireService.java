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
/**
 *
 * @author saif
  */
public class CommentaireService {
    
    Connection cnx;
    Statement ste;

    public CommentaireService() throws SQLException {
        cnx = MyDb.getInstance().getConnection();
        ste = cnx.createStatement();
    }

    
    public void ajouter(Commentaire t) throws SQLException {

       String requeteInsert = "INSERT INTO `commentaire` (`id`, `id_user`, `id_publication`,`commentaire_text`, `nom_user`, `prenom_user`) VALUES (NULL, '" + t.getId_user() + "', '" + t.getId_publication() + "', '" + t.getCommentaire_text() + "', '" + t.getNom_user() + "', '" + t.getPrenom_user()  + "');";
        ste.executeUpdate(requeteInsert);
    }
    
      public void delete(String id) throws SQLException {
         ResultSet result =  ste.executeQuery("SELECT * FROM `commentaire` WHERE `id`= '" + id + "' ");
         result.last();
         if(result.getRow()>0){
           String requeteUpdate = "DELETE FROM `commentaire` WHERE `id`='" + id + "';";
        ste.executeUpdate(requeteUpdate);
           System.out.println("commentaire a été supprimer");
         }else {
            System.out.println("echec");
         }
       
        
    }
    
   
    public void update(String id ,String commentaire_text  ) throws SQLException {
             ResultSet result =  ste.executeQuery("SELECT* FROM `commentaire` WHERE `id`= '" + id + "' ");
         result.last();
         if(result.getRow()>0){
           String requeteUpdate = "UPDATE `commentaire` SET `commentaire_text`='" + commentaire_text + "' WHERE `id`='" + id + "';";
        ste.executeUpdate(requeteUpdate);
           System.out.println("Update commentaire avec succes");
         }else {
            System.out.println("echec");
         }
       
        
    }
    

}

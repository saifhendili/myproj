/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entity.Likes;
import com.esprit.entity.Personne;
import com.esprit.utils.MyDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author saif
 */
public class LikesService {
    
    Connection cnx;
    Statement ste;

    public LikesService() throws SQLException {
        cnx = MyDb.getInstance().getConnection();
        ste = cnx.createStatement();
    }



    public String gererlikes(Likes l) throws SQLException {
      String likee ;
             ResultSet result =  ste.executeQuery("SELECT* FROM `likes` WHERE `id_publication`= '" + l.getId_publication()  + "' and `id_user`= '" + l.getId_user()  + "'  ");
         result.last();
         if(result.getRow()>0){
         String requeteUpdate = "DELETE FROM `likes` WHERE `id_publication`='" + l.getId_publication()  + "'  and `id_user`='" + l.getId_user()  + "' ;";
 ste.executeUpdate(requeteUpdate);
          likee="j'aime";
         }else {
            
             String requeteUpdate = "INSERT INTO `likes` (`id`, `id_publication`, `id_user`) VALUES (NULL, '" + l.getId_publication()  + "' , '" + l.getId_user()  + "' );;";
             ste.executeUpdate(requeteUpdate);
              likee="je n'aime pas";
         }
       
        
  return likee ;
    }
    
    
        public String getlike(String id,String iduser) throws SQLException {
      String likee ;
             ResultSet result =  ste.executeQuery("SELECT* FROM `likes` WHERE `id_publication`= '" + id + "' and `id_user`= '" + iduser + "'  ");
         result.last();
         if(result.getRow()>0){
        
          likee="je n'aime pas";
         }else {
         
              likee="J'aime";
         }
       
        
  return likee ;
    }

}

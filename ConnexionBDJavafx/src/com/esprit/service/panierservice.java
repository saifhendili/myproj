/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;
import com.esprit.utils.MyDb;

import com.esprit.entity.panier;
import com.esprit.entity.reservation_med;
import java.sql.Connection;
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
 * @author ACER
 */
public class panierservice {
    private Statement ste ; 
    private Connection connection ; 
    private ResultSet rs ; 
    public panierservice(){
    connection=  MyDb.getInstance().getConnection();
    }
    
    
    public void ajoutpanier(panier p, int q) throws SQLException {
        
               String req="INSERT INTO `panier` (`id`, `idmed`, `nommed`, `prixmed`,`id_user`) VALUES (NULL,'"+p.getIdmed()+"', '"+p.getNommed()+"', '"+p.getPrixmed()*q+ "', '"+p.getId_user()+ "');";

            ste= connection.createStatement();
             ste.executeUpdate(req);
             System.out.println("panier remplis");
    
        
    }
   public List<panier> showpanier(String id) throws SQLException{
        String requete="SELECT*FROM `panier` WHERE `id_user`='"+id+"'";
      ObservableList<panier>  List = FXCollections.observableArrayList();
    ste=connection.createStatement();
          ResultSet rs = ste.executeQuery(requete);
         
           while(rs.next()){
           List.add(new panier(rs.getString("id"),rs.getInt("idmed"),rs.getString("nommed"),rs.getFloat("prixmed"),rs.getString("2")));
          }     
       
        return List;
}
      
     public void deletepanier(String id){
    String requete="delete from panier WHERE id='"+id+"'";
        try {
            ste=connection.createStatement();
              ste.executeUpdate(requete);
              System.out.println("medicaùent supprimer du panier");
        } catch (SQLException ex) {
            Logger.getLogger(panierservice.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
       public void updatePanier(String id ,String change) throws SQLException {
       
            String requete = "UPDATE `panier` SET `nommed`='"+change+"' WHERE `id`='"+id+"'";
        ste=connection.createStatement();
            ste.executeUpdate(requete);
            System.out.println("Panier modifiée");
        
    }
    
        public double calcultotalpanier(String id) throws SQLException{
          
           String  req="SELECT SUM(`prixmed`) FROM `panier` WHERE `id_user`='"+id+"'";
         double Total=0;
            ste= connection.createStatement();
           ResultSet rs= ste.executeQuery(req); 
            while(rs.next()){
          Total =  (rs.getFloat(1)*1.19);
          
        }   
            return Total;
        }
        

}

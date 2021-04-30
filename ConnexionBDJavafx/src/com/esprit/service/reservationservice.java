/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;
import com.esprit.utils.MyDb;

import com.esprit.entity.reservation_med;
import java.sql.Connection;
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
public class reservationservice {
    private Statement ste ; 
    private Connection connection ; 
    private ResultSet rs ; 
    public reservationservice() {
      connection= MyDb.getInstance().getConnection();
}
    public void ajoutreservation(reservation_med r) throws SQLException{
    String requete="INSERT INTO `reservation_med` (`id`, `id_med`, `nom_med`, `id_phar`, `id_patient`) VALUES (NULL, '"+r.getId_med()+"', '"+r.getNom_med()+"', '"+r.getId_phar()+"', '"+r.getId_patient()+"');";
     
            ste=connection.createStatement();
            ste.executeUpdate(requete);
            System.out.println("reservation ajoutee");
        
    }
    public void deleteresrvation(String id){
    String requete="delete from reservation_med WHERE id='"+id+"'";
        try {
            ste=connection.createStatement();
           int rs= ste.executeUpdate(requete);
           if(rs>0){
               System.out.println("resrvationsupprimer");
           }
        } catch (SQLException ex) {
            Logger.getLogger(reservationservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public List<reservation_med> affiche(String id) throws SQLException{
        String requete="SELECT * FROM `reservation_med` WHERE `id_patient`='"+id+"'";
        ObservableList<reservation_med>  List = FXCollections.observableArrayList();
         ste=connection.createStatement();
          ResultSet rs=  ste.executeQuery(requete);
              while(rs.next()){
           List.add(new reservation_med(rs.getString("id"),rs.getString("id_med"),rs.getString("nom_med"),rs.getString("id_patient"),rs.getString("id_phar")));
              }
        return List;
        }
        
   
    
           public void ModifierReservaton(String id,String nom_med){
           
            String requete="UPDATE `reservation_med` SET `nom_med`='"+nom_med+"' WHERE `id`='"+id+"' ;";
        try {
             ste=connection.createStatement();
            int rs=ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(reservationservice.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            System.out.println("reservation modifier avec succee");      
       
           }
           
          
           
           public void Rechercherresrvation(String nom_med){
           
            String req="SELECT* FROM reservation_med WHERE id='"+nom_med+"'";
            try {
            ste=connection.createStatement();
            rs= ste.executeQuery(req);
           
              rs.last();
            int nbRow= rs.getRow();
            if (nbRow !=0){
          System.out.println("reservationt est trouvé");
            }
            else {
                System.out.println("reservation non trouvé");
      
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(reservationservice.class.getName()).log(Level.SEVERE, null, ex);
        }
           }

    

   
}       
          
          
          
        




        
        
        
    
    
    
    
    
    
   


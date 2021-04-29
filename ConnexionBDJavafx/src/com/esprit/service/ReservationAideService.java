/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entity.Commentaire;
import com.esprit.entity.Personne;
import com.esprit.entity.ReservationAide;
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
public class ReservationAideService {
     Connection cnx;
    Statement ste;

    public ReservationAideService() throws SQLException {
        cnx = MyDb.getInstance().getConnection();
        ste = cnx.createStatement();
    }

   
    public void ajouterReservation(ReservationAide t) throws SQLException {
             String requeteUpdate = " UPDATE `formaide` SET `quantit`=`quantit`-1 WHERE `id`='" + t.getIdPatient() + "';";

        String requeteInsert = "INSERT INTO `reservationaide` (`id`, `idPatient`, `idProduit`,`produit`,`desc`) VALUES (NULL, '" + t.getIdPatient() + "', '" + t.getIdProduit() + "','" + t.getProduit() + "','" + t.getDesc() + "');";
        ste.executeUpdate(requeteInsert);
         ste.executeUpdate(requeteUpdate);

    }


   
    public void delete(String id) throws SQLException {
            ResultSet result =  ste.executeQuery("SELECT * FROM `reservationaide` WHERE `id`= '" + id + "' ");
         result.last();
         if(result.getRow()>0){
           String requeteUpdate = "DELETE FROM `reservationaide` WHERE `id`='" + id + "';";
        ste.executeUpdate(requeteUpdate);
          System.out.println("reservation a été supprimer");
         }else {
         System.out.println("echec");
         }
    }

  
    public boolean update(Personne t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public List<ReservationAide> readAll() throws SQLException {
        List<ReservationAide> reservationaide = new ArrayList<>();
        ResultSet result =  ste.executeQuery("select * from reservationaide");
        while(result.next()){
            reservationaide.add(new ReservationAide(result.getString(1), result.getString(2), result.getString(3)));
        }
        
        return reservationaide;
    }
    public List<ReservationAide> MyReserv(String IdUser) throws SQLException {
      
             ObservableList<ReservationAide>  reservationaide = FXCollections.observableArrayList();

        ResultSet result =  ste.executeQuery("select * from reservationaide WHERE `idPatient`='" + IdUser + "' ;");
        while(result.next()){
                    reservationaide.add(new ReservationAide(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
        }
        
        return reservationaide;
    }
    
    
    
    
     public List<ReservationAide> MyReservsss(String IdUser) throws SQLException {
      
             ArrayList<ReservationAide>  reservationaide = new ArrayList();

        ResultSet result =  ste.executeQuery("select * from reservationaide WHERE `idPatient`='" + IdUser + "' ;");
        while(result.next()){
            reservationaide.add(new ReservationAide(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
        }
        
        return reservationaide;
    }
    
    
    
    
    
  
}



















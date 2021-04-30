/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;


import com.esprit.entity.paniervac;

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
import com.esprit.utils.MyDb;

/**
 *
 * @author pc doctor
 */
public class PaniervacService {
        private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection connection;

    public PaniervacService(){
        connection=MyDb.getInstance().getConnection();
    }
    
    public void ajouterPanier(paniervac p){
        String req="insert into paniervac(id_vaccin,nom_vaccin,prix_vaccin) values('"+p.getId_vaccin()+"','"+p.getNom_vaccin()+"','"+p.getPrix_vaccin()+"')";
     
        try {
            ste=connection.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(VaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public List<paniervac> readAll(){
           
       String req="select * from paniervac";
       ObservableList<paniervac> list = FXCollections.observableArrayList();
      // List<RDV> list=new ArrayList<>();
       
       try {
           ste=connection.createStatement();
           rs=ste.executeQuery(req);
           
           while(rs.next()){
               list.add(new paniervac (rs.getString("id"),rs.getString("id_vaccin"),rs.getString("nom_vaccin"),rs.getString("prix_vaccin")));
           }
       } catch (SQLException ex) {
       
            Logger.getLogger(VaccinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
 public void Updatepanier(String id_vaccin, String nom_vaccin){
      String req="UPDATE paniervac SET nom_vaccin='"+nom_vaccin+"' WHERE id_vaccin='"+id_vaccin+"'";
    
      try {
            ste=connection.createStatement();
         int   rs=ste.executeUpdate(req);
            if ( rs >0)
            {
                System.out.println("le panier a été bien modifier");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaniervacService.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
        public void Deletepanier(String id_vaccin) {
        
          String req="DELETE From paniervac WHERE id_vaccin='"+id_vaccin+"'";
    
      try {
            ste=connection.createStatement();
         int   rs=ste.executeUpdate(req);
            if ( rs >0)
            {
                System.out.println("le vaccin a été supprimé ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaniervacService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
              public void prixtotal(int id)
   {
       String req="SELECT (`prix_vaccin`+(`prix_vaccin`*0.19))` FROM `paniervac` WHERE id ="+id;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                System.out.println(rs.getFloat("(`prix_vaccin`+(`prix_vaccin`*0.19))`"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaniervacService.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
                public double calcultotalpanier(String id) throws SQLException{
          
           String  req="SELECT SUM(`prix_vaccin`) FROM `paniervac` WHERE `id`='"+id+"'";
         double Total=0;
            ste= connection.createStatement();
           ResultSet rs= ste.executeQuery(req); 
            while(rs.next()){
          Total =  (rs.getFloat(1)*1.19);
          
        }   
            return Total;
        }
    
}

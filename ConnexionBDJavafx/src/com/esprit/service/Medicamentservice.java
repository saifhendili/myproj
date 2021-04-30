/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;
import com.esprit.utils.MyDb;
import com.esprit.entity.medicaments;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author ACER
 */
public class Medicamentservice {

   

   
    private Statement ste ;
    private PreparedStatement pst ;
    private  Connection connection ;
    private ResultSet rs ;
    public Medicamentservice(){
        
    connection= MyDb.getInstance().getConnection();
    }
    public void AjouterMedicaments(medicaments  m) throws SQLException{
  String req="insert into  medicaments (nom,description,prix,quantity,img,id_pharmacie) values('"+m.getNom()+"','"+m.getDescription()+"','"+m.getPrix()+"','"+m.getQuantity()+"','"+m.getImg()+"','"+m.getId_pharmacie()+"')";
        
            ste= connection.createStatement();
            ste.executeUpdate(req);
            System.out.println("ajouter avec succee");
       
    }
//    public void AjouterMedicamentsPST(medicaments m){
//    String req="insert into  medicaments (nom,description,prix,quantity,img,id_pharmacie)values(?,?,?,?,?,?)";
//        try {
//            pst=connection.prepareStatement(req);
//            pst.setString(1, m.getNom());
//             pst.setString(2, m.getDescription());
//             pst.setFloat(3, m.getPrix());
//              pst.setInt(4, m.getQuantity());
//                pst.setString(5, m.getImg());
//                pst.setString(6, m.getId_pharmacie());
//                 pst.executeUpdate();
//                 System.out.println("ajout réuissie");
//                    } catch (SQLException ex) {
//            Logger.getLogger(Medicamentservice.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public List <medicaments> readAll(){
        String req="select* from medicaments ";
        List <medicaments> List=new ArrayList<>();
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            
            while(rs.next()){
                List.add(new medicaments(rs.getString("id"),rs.getString("nom"),rs.getString("description"),rs.getFloat("prix"),rs.getInt("quantity"),rs.getString("img"),rs.getString("id_pharmacie")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Medicamentservice.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return List;
    }
    public void UpdateMedicaments(String id, String nom){
        try{
            String req="Update medicaments SET nom='"+nom+"' WHERE id="+id ;
            ste=connection.createStatement();
          int  rs=ste.executeUpdate(req);
         
            System.out.println("le medicament a ete modifier avec succee");      
        } catch (SQLException ex) {
            Logger.getLogger(Medicamentservice.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
       public  void DeleteMedicaments(String id){
           String req="DELETE from medicaments WHERE id="+id;
            try {
            ste=connection.createStatement();
          int  rs=ste.executeUpdate(req);
           
           if (rs>0){
                System.out.println("le médicament a ete supprimer");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Medicamentservice.class.getName()).log(Level.SEVERE, null, ex);
        } 
           
       }
       public List<medicaments> Search(String mychar) throws SQLException {
             ObservableList<medicaments>  form  = FXCollections.observableArrayList();
     
     String req= "SELECT * FROM `medicaments` WHERE `nom` LIKE '" + mychar + "' ";
     ste= connection.createStatement();
     rs=ste.executeQuery(req);
       
         while(rs.next()){
            form.add(new medicaments(rs.getString("id"),rs.getString("nom"),rs.getString("description"),rs.getFloat("prix"),rs.getInt("quantity"),rs.getString("img"),rs.getString("id_pharmacie")));
        }
        return form;
    }
        

        public List<medicaments> TriMed()
      {
       String req="SELECT * FROM medicaments\n" +
           "ORDER BY prix DESC;";
       List<medicaments> list= new ArrayList<>();
        
           try {
               ste=connection.createStatement();
               rs=ste.executeQuery(req);
               while(rs.next()){
                   list.add(new medicaments(rs.getString("id"),rs.getString("nom"),rs.getString("description"),rs.getFloat("prix"),rs.getInt("quantity"),rs.getString("img"),rs.getString("id_pharmacie")));
               }
           } catch (SQLException ex) {
               Logger.getLogger(Medicamentservice.class.getName()).log(Level.SEVERE, null, ex);
           } return list;
      }

    
 
    }

          
   
   
   
       
    

    
    
    
    

       

    

    
    
    
    
    
    
    
    
    
    
    
    





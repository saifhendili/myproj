/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarra.views;

import com.esprit.service.panierservice;
import com.esprit.entity.medicaments;
import com.esprit.entity.panier;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author ACER
 */
public class PanierController implements Initializable {

    @FXML
    private TableView<panier> tvpanier;
    
    @FXML
    private TableColumn<panier, String> id;
    @FXML
    private TableColumn<panier, Integer> idmedic;
    @FXML
    private TableColumn<panier, String> nommed;
    @FXML
    private TableColumn<panier, Float> prix;
    @FXML
    private TableColumn<panier, Integer> id_user;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button confirmer;

 
   
    String query= null ;
    Connection connection= null ;
    PreparedStatement ps = null;
    ResultSet rs=null;
   medicaments medicaments = null;
      int index =-1 ;
     ObservableList<panier> ListP = FXCollections.observableArrayList();
    @FXML
    private Button refersh;
    @FXML
    private Button somme;
    @FXML
    private TextField idm;
    @FXML
    private TextField nomm;
    @FXML
    private TextField utilisateur;
    
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {
         ListP.clear();
          panierservice pubs=new panierservice() ;
           id.setCellValueFactory(new PropertyValueFactory<>("id"));     
     idmedic.setCellValueFactory(new PropertyValueFactory<>("idmed"));
    nommed.setCellValueFactory(new PropertyValueFactory<>("nommed"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prixmed"));

     id_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
  
          tvpanier.setItems((ObservableList<panier>) pubs.showpanier("2"));
       
      } catch (SQLException ex) {
          Logger.getLogger(AfficheReservationController.class.getName()).log(Level.SEVERE, null, ex);
      }
            
        
        
        
       
          
    confirmer.setOnAction(event-> { 
      
  
          try {
              Parent Page1 = FXMLLoader.load(getClass().getResource("/sarra/views/Acceuilview.fxml"));
              Scene scene = new Scene(Page1);
              Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(AfficheReservationController.class.getName()).log(Level.SEVERE, null, ex);
          }
                      
         
      }); 
    }    

    @FXML
    private void Edit(ActionEvent event) throws SQLException {
     String id = idm.getText();
         String nom =nomm.getText();
           panierservice p =new panierservice() ;
          p.updatePanier(id, nom);
           JOptionPane.showMessageDialog(null, "Update");
//            UpdateTable();
        
    }

    @FXML
    private void delete(ActionEvent event) {
        String id = idm.getText();
     panierservice p =new panierservice() ;
       p.deletepanier(id);
     JOptionPane.showMessageDialog(null, "Delete Done");
//            UpdateTable();
    }

    @FXML
    private void getselected(MouseEvent event) {
                
    index =  tvpanier.getSelectionModel().getSelectedIndex();
    if (index <= -1){
       
   }
    idm.setText(id.getCellData(index).toString());
   nomm.setText( nommed.getCellData(index).toString());
   utilisateur.setText( id_user.getCellData(index).toString());
   
    }

    @FXML
    private void refrech(MouseEvent event) throws SQLException {
           try {
         ListP.clear();
          panierservice pubs=new panierservice() ;
           id.setCellValueFactory(new PropertyValueFactory<>("id"));     
     idmedic.setCellValueFactory(new PropertyValueFactory<>("idmed"));
    nommed.setCellValueFactory(new PropertyValueFactory<>("nommed"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prixmed"));

     id_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 
          tvpanier.setItems((ObservableList<panier>) pubs.showpanier("2"));
      } catch (SQLException ex) {
          Logger.getLogger(AfficheReservationController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    @FXML
    private void gettotal(ActionEvent event) throws SQLException {
        panierservice p = new panierservice();
        double m=p.calcultotalpanier("2");
//    prixtotal.setText();
         JOptionPane.showMessageDialog(null, m);
                       }
}




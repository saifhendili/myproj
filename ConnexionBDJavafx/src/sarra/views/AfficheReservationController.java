/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarra.views;

import com.esprit.service.panierservice;
import com.esprit.service.reservationservice;
import com.esprit.entity.panier;
import com.esprit.entity.reservation_med;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import static javax.print.DocFlavor.BYTE_ARRAY.PDF;
import static javax.print.DocFlavor.INPUT_STREAM.PDF;
import static javax.print.DocFlavor.URL.PDF;

import com.esprit.utils.MyDb;
import javax.swing.JOptionPane;

import static sarra.views.TableviewController.sendMail;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AfficheReservationController implements Initializable {
    
      @FXML
    private TableView<reservation_med> reservation;
   
    @FXML
    private TableColumn<reservation_med, String> idmed;
 
    @FXML
    private TableColumn<reservation_med, String> idpharamcie;
    @FXML
    private TableColumn<reservation_med, String> idpat;
    
    private Button ajout;
    @FXML
    private Button supp;
    @FXML
    private Button modif;
    @FXML
    private TableColumn<reservation_med, String> idreserv;
    @FXML
    private TableColumn<reservation_med, String> nommed1;
    
   int index=-1;
  
  
    
    ObservableList<reservation_med> reservationList = FXCollections.observableArrayList();
    @FXML
    private Button retour;
    @FXML
    private Button panier;
    @FXML
    private TextField id;
    private TextField nom;
    @FXML
    private TextField nomf;
    @FXML
    private Button ajoutp;
    @FXML
    private Button total;
    @FXML
    private Button up;
    @FXML
    private ImageView backg;
    @FXML
    private Button bak;
 
    /**
     * Initializes the controller class.
     */
      @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    up.setOnAction(event-> { 
      
  
          try {
              Parent Page1 = FXMLLoader.load(getClass().getResource("/sarra/views/AfficheReservation.fxml"));
              Scene scene = new Scene(Page1);
              Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(AfficheReservationController.class.getName()).log(Level.SEVERE, null, ex);
          }
              
              
            
         
      }); 
        

        
       
     
      try {
         // reservationList.clear();
          reservationservice pubs=new reservationservice() ;
          
          idreserv.setCellValueFactory(new PropertyValueFactory<>("id"));
          idmed.setCellValueFactory(new PropertyValueFactory<>("id_med"));
          nommed1.setCellValueFactory(new PropertyValueFactory<>("nom_med"));
          idpat.setCellValueFactory(new PropertyValueFactory<>("id_patient"));
          idpharamcie.setCellValueFactory(new PropertyValueFactory<>("id_phar"));
          
 
          reservation.setItems((ObservableList<reservation_med>) pubs.affiche("2"));

          
      } catch (SQLException ex) {
          Logger.getLogger(AfficheReservationController.class.getName()).log(Level.SEVERE, null, ex);
   
      }    
        
      
       
   retour.setOnAction(event-> { 
      
  
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
   panier.setOnAction(event-> { 
      
  
          try {
              Parent Page1 = FXMLLoader.load(getClass().getResource("/sarra/views/panier.fxml"));
              Scene scene = new Scene(Page1);
              Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
          } catch (IOException ex) {
              Logger.getLogger(AfficheReservationController.class.getName()).log(Level.SEVERE, null, ex);
          }
              
   });    
   
   bak.setOnAction(event-> { 
      
  
          try {
              Parent Page1 = FXMLLoader.load(getClass().getResource("/sarra/views/Tableview.fxml"));
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
    private void getselected(MouseEvent event) {
        index =   reservation.getSelectionModel().getSelectedIndex();
    if (index <= -1){ 
   }
    id.setText(idreserv.getCellData(index).toString());
    nomf.setText( nommed1.getCellData(index).toString());

        
    }

   

    @FXML
    private void delete(ActionEvent event) {
         String idreserv = id.getText();
        reservationservice r =new reservationservice();
           r.deleteresrvation("id");
           JOptionPane.showMessageDialog(null, "Delete Done");
//            UpdateTable();
    }

    @FXML
    private void edit(ActionEvent event) {
          String id = idreserv.getText();
         String nom =nomf.getText();
           reservationservice r =new reservationservice();
         r.ModifierReservaton(id, nom);
           JOptionPane.showMessageDialog(null, "Update");
//            UpdateTable();
    }

    @FXML
    private void ajoutPanier(ActionEvent event) throws SQLException, Exception {
        String panier= id.getText();
        panier p1=new panier(panier,12,"doliprane",8.5f,"12");
      panierservice sr=new panierservice();
        sr.ajoutpanier(p1, index);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reservation insérée avec succés un mail de confirmation sera envoyé dans quelque minutes !");
                alert.show();
                sendMail("sarra.meddeb@esprit.tn");
  
        
    }
   
    @FXML
    private void somme(ActionEvent event) throws SQLException {
        
       panierservice p = new panierservice();
       
        double m=p.calcultotalpanier("2");
//   prixtotal.setText();
         JOptionPane.showMessageDialog(null, m);
  
    }

    


}




 

     


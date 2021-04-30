/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarra.views;

import com.esprit.service.Medicamentservice;
import com.esprit.entity.medicaments;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AjoutMedicamentController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfqte;
    @FXML
    private TextField tfimage;
    @FXML
    private TextField tfidphar;
    @FXML
    private Button btnajout;
    @FXML
    private Button btnretour;
    @FXML
    private Button visualiser;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         btnajout.setOnAction((event) -> {
             try {
                 medicaments m = new medicaments(tfnom.getText(),tfdesc.getText(),Float.parseFloat(tfprix.getText()),Integer.parseInt(tfqte.getText()),tfimage.getText(),tfidphar.getText());
                 Medicamentservice po = new Medicamentservice();
                 po.AjouterMedicaments(m);
                 Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("information Dialog")  ;
                 alert.setHeaderText(null);
                 alert.setContentText("Medicament ajoute avec succee");
                 alert.show();
                 tfnom.setText("");
                 tfdesc.setText("");
                 tfprix.setText("");
                 tfqte.setText("");
                 tfimage.setText("");          
                 tfidphar.setText("");
                 
             } catch (SQLException ex) {
                 Logger.getLogger(AjoutMedicamentController.class.getName()).log(Level.SEVERE, null, ex);
             }
     });
         
     btnretour.setOnAction(event-> { 
      
          try {
              Parent Page1 = FXMLLoader.load(getClass().getResource("/sarra/views/Acceuilview.fxml"));
               Scene scene = new Scene(Page1);
               Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
              
              
            
          } catch (IOException ex) {
              Logger.getLogger(AcceuilviewController.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
         
         
         
         
        visualiser.setOnAction(event-> { 
      
          try {
              Parent Page1 = FXMLLoader.load(getClass().getResource("/sarra/views/Tableview.fxml"));
               Scene scene = new Scene(Page1);
               Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
              
              
            
          } catch (IOException ex) {
              Logger.getLogger(AcceuilviewController.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
         
          
         
         
         
 }}


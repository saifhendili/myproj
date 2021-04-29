/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;


import com.esprit.entity.Publication;
import com.esprit.service.PublicationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class AjouterPublicationController implements Initializable {

    @FXML
    private TextField pub_text;
    @FXML
    private Button share_but;

    /**
   * @param url
     * @param rb
     */
    @Override
   public void initialize(URL url, ResourceBundle rb) {
        // TODO     
        share_but.setOnAction(event -> {
      
            try {
                Publication p3 = new Publication( "2" ,pub_text.getText(), "java", "dddd","dddd");
                PublicationService pubs=new PublicationService() ;
                pubs.ajouter(p3);
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Publication insérée avec succés!");
                alert.show();
                pub_text.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(AjouterPublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        
           
       
        });
        
        
    }

    @FXML
    private void clear(MouseEvent event) {
          pub_text.setText(null);
       
    }

    @FXML
    private void back(MouseEvent event) {
            try {
               Parent page3 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AccueilPublication .fxml"));
               Scene scene = new Scene(page3);
               Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AccueilPublicationController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
}

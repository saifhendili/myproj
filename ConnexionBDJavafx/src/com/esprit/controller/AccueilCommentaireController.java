/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class AccueilCommentaireController implements Initializable {

    @FXML
    private Button add_comm;
    @FXML
    private Button display_comm;
    @FXML
    private Text Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            add_comm.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AjouterCommentaire.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AccueilPublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            
            
                display_comm.setOnAction(event -> {

            try {
                Parent page2 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AfficherCommentaire.fxml"));
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AccueilPublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }    

    @FXML

    
    private void back(MouseEvent event) {
            try {
               Parent page3 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AfficherPublication.fxml"));
               Scene scene = new Scene(page3);
               Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AccueilPublicationController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
}

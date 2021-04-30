/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roua.view;

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
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class HomeController implements Initializable {

    @FXML
    private Button Quiz;
    @FXML
    private Button decx;
    @FXML
    private Button animate;
    @FXML
    private Pane merciPane;
    @FXML
    private Label mercitext;
    private Text sahti;
    @FXML
    private Button Musique;
    @FXML
    private Button Profil;
    @FXML
    private Button gopub;
    @FXML
    private Button goform;
    @FXML
    private Button medgo;
    @FXML
    private Button Vaccinsgo;
    @FXML
    private Button homego;
    @FXML
    private Button rendgo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           gopub.setOnAction(event ->{
        try {
            Parent page   = FXMLLoader.load(getClass().getResource("/com/esprit/view/AccueilPublication.fxml"));
            Scene scene = new Scene(page );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        }   catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });  
            goform.setOnAction(event ->{
        try {
            Parent page   = FXMLLoader.load(getClass().getResource("/com/esprit/view/AccueilFormAide.fxml"));
            Scene scene = new Scene(page );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        }   catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });  
            
                rendgo.setOnAction(event ->{
        try {
            Parent page   = FXMLLoader.load(getClass().getResource("/zayneb/views/Accueil.fxml"));
            Scene scene = new Scene(page );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        }   catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });  
            
            
             medgo.setOnAction(event ->{
        try {
            Parent page   = FXMLLoader.load(getClass().getResource("/sarra/views/Tableview.fxml"));
            Scene scene = new Scene(page );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        }   catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });  
             
             
             
              Vaccinsgo.setOnAction(event ->{
        try {
            Parent page   = FXMLLoader.load(getClass().getResource("/nour/view/acceuil.fxml"));
            Scene scene = new Scene(page );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        }   catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });  
                 homego.setOnAction(event ->{
        try {
            Parent page   = FXMLLoader.load(getClass().getResource("/sarra/views/Acceuilview.fxml"));
            Scene scene = new Scene(page );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        }   catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });  
                 
            
            
       Quiz.setOnAction(event ->{
        try {
            Parent page   = FXMLLoader.load(getClass().getResource("/roua/view/Quiz.fxml"));
            Scene scene = new Scene(page );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        }   catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });  
       
        decx.setOnAction(event ->{
        try {
            Parent page   = FXMLLoader.load(getClass().getResource("/roua/view/Deconnexion.fxml"));
            Scene scene = new Scene(page );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        }   catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });  
        
        
        
     Profil.setOnAction(event ->{
        try {
            Parent page   = FXMLLoader.load(getClass().getResource("/roua/view/Profil.fxml"));
            Scene scene = new Scene(page );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        }   catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });  
         
           
    }    


    @FXML
    private void Animation(ActionEvent event) { 
           new animatefx.animation.Pulse(mercitext).play();
        new animatefx.animation.BounceIn(merciPane).play();
        new animatefx.animation.FadeInDownBig(sahti).play();
        new animatefx.animation.FadeInDownBig(decx).play();
        
        new animatefx.animation.RollIn(Quiz);
    }

    @FXML
    private void musique(ActionEvent event) {
         AudioClip note = new AudioClip(this.getClass().getResource("/audio/file_example_WAV_1MG.wav").toString());
    note.play();
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarra.views;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AcceuilviewController implements Initializable {
    private AnchorPane rootLayout;
    private  Stage praimaryStage;
    @FXML
    private Button btmed;
    private Button btafmed;
    @FXML
    private AnchorPane acceuil;
    @FXML
    private Button btnafmed;
    @FXML
    private MediaView media;
  
     private Media mediaaa;
  
     private Media mediaa; 
    private MediaPlayer mediaPlayer;
      private MediaPlayer mediaPlayerr;
    @FXML
    private ImageView backg;
    @FXML
    private Button stop;
    @FXML
    private Button lire;
    @FXML
    private Slider volume;
    @FXML
    private Button stoper;
    @FXML
    private Button music;
    @FXML
    private Button arret;
  

    /**
     * Initializes the controller class.
     */    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
     String Path= new File("src/video/corona.mp4").getAbsolutePath();
        mediaa = new Media(new File(Path).toURI().toString());
        mediaPlayer = new MediaPlayer(mediaa);
        media.setMediaPlayer(mediaPlayer);
        volume.setValue(mediaPlayer.getVolume()*100);
        volume.valueProperty().addListener(new InvalidationListener() {
         @Override
         public void invalidated(Observable observable) {
             mediaPlayer.setVolume(volume.getValue()/100);
         }
     });
        String path = "src/music/music.mp3";
        mediaaa = new Media(new File(path).toURI().toString());
        mediaPlayerr = new MediaPlayer (mediaaa);
       
       
      btmed.setOnAction(event-> { 
      
          try {
              Parent Page1 = FXMLLoader.load(getClass().getResource("/sarra/views/AjoutMedicament.fxml"));
               Scene scene = new Scene(Page1);
               Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
              
              
            
          } catch (IOException ex) {
              Logger.getLogger(AcceuilviewController.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      
      
    
        btnafmed.setOnAction(event-> { 
             
          try {
              
             Parent Page2= FXMLLoader.load(getClass().getResource("/sarra/views/Tableview.fxml"));
              Scene scene = new Scene(Page2);
               Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
             
          } catch (IOException ex) {
              Logger.getLogger(AcceuilviewController.class.getName()).log(Level.SEVERE, null, ex);
          }
               
      });
 
  
    
      
        }

    @FXML
    private void pause(ActionEvent event) {
         mediaPlayer.pause();
    }

    @FXML
    private void play(ActionEvent event) {
         mediaPlayer.play();
    }

    @FXML
    private void stop(ActionEvent event) {
         mediaPlayer.seek(mediaPlayer.getStopTime());
         mediaPlayer.stop();
    }

    @FXML
    private void playsound(ActionEvent event) {
                 mediaPlayerr.play();

        
    }

    @FXML
    private void arret(ActionEvent event) {
         mediaPlayerr.seek(mediaPlayerr.getStopTime());
         mediaPlayerr.stop();
    }

    @FXML
    private void back(MouseEvent event) {
          try {
              Parent Page1 = FXMLLoader.load(getClass().getResource("/roua/view/Home.fxml"));
               Scene scene = new Scene(Page1);
               Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
              
              
            
          } catch (IOException ex) {
              Logger.getLogger(AcceuilviewController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
      
      
      
              }

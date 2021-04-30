/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarra.views;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

 
 
/**
 * FXML Controller class
 *
 * @author ACER
 */
public class MediaController implements Initializable {

    /**
     * Initializes the controller class.
     */
       
    private Media media; 
    private MediaPlayer mediaPlayer; 
  
    @FXML
    private MediaView mediaview;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOO
        String Path= new File("src/video/corona.mp4").getAbsolutePath();
        media = new Media(new File(Path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaview.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        
       
    }    
    
}

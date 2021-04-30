/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import marytts.util.data.audio.MonoAudioInputStream;
import marytts.util.data.audio.StereoAudioInputStream;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.sound.sampled.AudioInputStream;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.modules.synthesis.Voice;
import marytts.signalproc.effects.AudioEffect;
import marytts.signalproc.effects.AudioEffects;
import com.esprit.entity.FormAide;
import com.esprit.entity.Publication;
import com.esprit.service.FormAideService;
import com.esprit.service.PublicationService;
import com.esprit.voice.TextToSpeech;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;

import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import marytts.signalproc.effects.JetPilotEffect;
import marytts.signalproc.effects.LpcWhisperiserEffect;
import marytts.signalproc.effects.RobotiserEffect;
import marytts.signalproc.effects.StadiumEffect;
import marytts.signalproc.effects.VocalTractLinearScalerEffect;
import marytts.signalproc.effects.VolumeEffect;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author saif
 */
public class AjouterProduitController implements Initializable {

    @FXML
    private TextField Desc_text;
    @FXML
    private TextField quan_text;
    @FXML
    private Button add;
    @FXML
    private TextField image_text;
    @FXML
    private Button writeqr;
    @FXML
    private Button lireqr;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           add.setOnAction(event -> {
      
            try {
                FormAide p3 = new FormAide( "2" ,"saif", "hendili", image_text.getText(),Desc_text.getText(),quan_text.getText(),"e");
                FormAideService pubs=new FormAideService() ;
                pubs.ajouterFormAide(p3);
                
                  TextToSpeech tts = new TextToSpeech();        
	// Setting the Current Voice
	tts.setVoice("cmu-rms-hsmm");       
        //VocalTractLinearScalerEffect
		VocalTractLinearScalerEffect vocalTractLSE = new VocalTractLinearScalerEffect(); //russian drunk effect
		vocalTractLSE.setParams("amount:50");
		
		//JetPilotEffect
		          JetPilotEffect jetPilotEffect = new JetPilotEffect(); //epic fun!!!
		jetPilotEffect.setParams("amount:100");
		
		//RobotiserEffect
		          RobotiserEffect robotiserEffect = new RobotiserEffect();
		robotiserEffect.setParams("amount:10");
		
		//StadiumEffect
		          StadiumEffect stadiumEffect = new StadiumEffect();
		stadiumEffect.setParams("amount:80");
		
		//LpcWhisperiserEffect
		          LpcWhisperiserEffect lpcWhisperiserEffect = new LpcWhisperiserEffect(); //creepy
		lpcWhisperiserEffect.setParams("amount:70");
		
		//VolumeEffect
		VolumeEffect volumeEffect = new VolumeEffect(); //be careful with this i almost got heart attack
		volumeEffect.setParams("amount:0");
		
		//Apply the effects
		//----You can add multiple effects by using the method `getFullEffectAsString()` and + symbol to connect with the other effect that you want
		//----check the example below
		tts.getMarytts().setAudioEffects(stadiumEffect.getFullEffectAsString());// + "+" + stadiumEffect.getFullEffectAsString());
		tts.speak("Your product is successfully inserted", 2.0f, false, true);
                
                
          
                   
            } catch (SQLException ex) {
                Logger.getLogger(AjouterPublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
                
  
//       
//                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Information Dialog");
//                alert.setHeaderText(null);
//                alert.setContentText("Produit insérée avec succés!");
//                alert.show(); 
            
                Desc_text.setText("");
                 quan_text.setText("");
                image_text.setText("");
       
        });
                     writeqr.setOnAction(event -> {
                         
                         try{
                         ArrayList<String> List = new ArrayList<String>();       
    List.add(Desc_text.getText());
    List.add(quan_text.getText());
    List.add(image_text.getText());
ByteArrayOutputStream out = QRCode.from(Desc_text.getText())
        .to(ImageType.PNG).stream();

String f_name = image_text.getText();
String Path_name = "D:\\" ;

FileOutputStream fout = new FileOutputStream(new File(Path_name +(f_name + ".PNG")));
fout.write(out.toByteArray());
fout.flush();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Code qr insérée!");
                alert.show(); 
               } catch (IOException ex) {
                   Logger.getLogger(AjouterProduitController.class.getName()).log(Level.SEVERE, null, ex);
               } 
                     });
                     lireqr.setOnAction(event ->{
                         try {
            
            InputStream barcodeInputStream = new FileInputStream("D:\\ssss.png");
            BufferedImage barcBufferedImage = ImageIO.read(barcodeInputStream);
            
            LuminanceSource source = new BufferedImageLuminanceSource(barcBufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Reader reader = new MultiFormatReader();
            Result reslut = reader.decode(bitmap);
            
            Desc_text.setText(reslut.getText());
            
            
            
            
        } catch (Exception e) {
        }
                     
                     });
    }    

    @FXML
    private void add(ActionEvent event) {
     
    }


  @FXML
    private void back(MouseEvent event) {
            try {
               Parent page3 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AccueilFormAide.fxml"));
               Scene scene = new Scene(page3);
               Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AccueilPublicationController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    }
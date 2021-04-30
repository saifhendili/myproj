/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package roua.view;

import com.esprit.service.UserService;
import com.esprit.entity.User;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AjouterUtilisateurController implements Initializable {

    
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField age;
    @FXML
    private TextField adress;
    private TextField type;
    @FXML
    private TextField password;
    @FXML
    private TextField Speciality;
    @FXML
    private Button ajout;
    
    private TextField role;
    @FXML
    private TextField reset_token;
    private TextField is_confirmed;
    private TextField is_activated;
    @FXML
    private Button Retour;
  

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          new animatefx.animation.Pulse(nom).play();
           new animatefx.animation.Pulse(prenom).play();
            new animatefx.animation.Pulse(email).play();
             new animatefx.animation.BounceInDown(age).play();
              new animatefx.animation.BounceInLeft(adress).play();
               //new animatefx.animation.BounceInLeft(type).play();
                new animatefx.animation.FadeIn(password).play();
                // new animatefx.animation.FadeOut(Speciality).play();
             //     new animatefx.animation.Jello(role).play();
               //    new animatefx.animation.Jello(reset_token).play();
                 //   new animatefx.animation.Jello(is_confirmed).play();
                  //  new animatefx.animation.Jello(is_activated).play();
       Retour.setOnAction(event ->{
        try {
            Parent page   = FXMLLoader.load(getClass().getResource("/roua/view/Accueil.fxml"));
            Scene scene = new Scene(page );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
        }   catch (IOException ex) {
                Logger.getLogger(AfficherUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });  
        
        
     ajout.setOnAction(event ->{
         User u = new User (nom.getText(),age.getText(),prenom.getText(),  adress.getText(),"user",email.getText(),
                "user", password.getText(), Speciality.getText(),"user","339IFJZPKZS","yes");
         UserService uservice= new UserService();
         uservice.ajouterUser(u);
         Alert alert = new Alert (AlertType.INFORMATION);
         alert.setTitle("information dialog");
         alert.setHeaderText(null);
         alert.setContentText("utilisateur ajouté avec succès");
         alert.show();
         nom.setText("");
         prenom.setText("");
         email.setText("");
         age.setText("");
         adress.setText("");
         password.setText("");
         Speciality.setText("");
        
    });
    }    
    
}

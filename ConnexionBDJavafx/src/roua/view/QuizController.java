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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class QuizController implements Initializable {

    @FXML
    private Label r1;
    @FXML
    private Label r2;
    @FXML
    private Label r3;
    @FXML
    private Label rp;
    @FXML
    private Label r4;
    @FXML
    private Label r5;
    @FXML
    private Label r6;
    @FXML
    private Label rp2;
    @FXML
    private Label rp3;
    @FXML
    private Label r7;
    @FXML
    private Label r8;
    @FXML
    private Label r9;
    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check4;
    @FXML
    private CheckBox check5;
    @FXML
    private CheckBox check3;
    @FXML
    private CheckBox check6;
    @FXML
    private CheckBox check7;
    @FXML
    private CheckBox check8;
    @FXML
    private CheckBox check9;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        retour.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/roua/view/Home.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    

    @FXML
    private void testQuiz(ActionEvent event) {
        
       if (check2.isSelected())
        {
            r2.setText("Vrai");
        }
        else{
           r3.setText("Faux");
           rp.setText("La bonne réponse est : Grippe");

        }
        if (check4.isSelected())
        {
            r4.setText("Vrai");
        }
        else{
           r5.setText("Faux");
           rp2.setText("La bonne réponse est : Tuberculose");

           

        }
        if (check9.isSelected())
        {
            r9.setText("Vrai");
        }
        else{
           r7.setText("Faux");
           rp3.setText("La bonne réponse est : 3");
       

       
  
    }
    
}
}

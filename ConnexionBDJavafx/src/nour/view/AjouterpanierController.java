/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nour.view;

import com.esprit.entity.paniervac;
import com.esprit.entity.vaccins;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.esprit.service.PaniervacService;
import com.esprit.service.VaccinService;

/**
 * FXML Controller class
 *
 * @author pc doctor
 */
public class AjouterpanierController implements Initializable {

    @FXML
    private Button panier;
    @FXML
    private TextField id_vaccin;
    @FXML
    private TextField nom_vaccin;
    @FXML
    private TextField prix_vaccin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            panier.setOnAction((event) -> { 
    
       paniervac p = new paniervac(id_vaccin.getText(),nom_vaccin.getText(),prix_vaccin.getText());
       PaniervacService ps = new PaniervacService();
        ps.ajouterPanier(p);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("information dialog");
        alert.setHeaderText(null);
        alert.setContentText("vaccin ajouté avec succes");
        alert.show();
        id_vaccin.setText("");
        nom_vaccin.setText("");
        prix_vaccin.setText("");

    });
    }    
    
}

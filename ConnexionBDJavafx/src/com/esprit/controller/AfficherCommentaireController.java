/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.entity.Commentaire;
import com.esprit.entity.Publication;
import com.esprit.service.PublicationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class AfficherCommentaireController implements Initializable {

    @FXML
    private TableView<Publication> table_pub;
    @FXML
    private TableColumn<Publication, String> col_idpub;
    @FXML
    private TableColumn<Publication, String> col_nompub;
    @FXML
    private TableColumn<Publication, String> col_prenompub;
    @FXML
    private TableColumn<Publication, String> col_pub;
    @FXML
    private TableView<Commentaire> table_comm;
    @FXML
    private TableColumn<Commentaire, String> col_idcom;
    @FXML
    private TableColumn<Commentaire, String> col_nomcom;
    @FXML
    private TableColumn<Commentaire, String> col_prenomcom;
    @FXML
    private TableColumn<Commentaire, String> col_com;
    @FXML
    private TextField id_textpub;

    int index=-1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try {
        
            
            
            PublicationService pubs=new PublicationService() ;
         
   // id.setCellValueFactory(new PropertyValueFactory<>("id"));
              col_nompub.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
         col_prenompub.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
          col_pub.setCellValueFactory(new PropertyValueFactory<>("publication_text"));
                    col_idpub.setCellValueFactory(new PropertyValueFactory<>("id"));
       //   iduser_col.setCellValueFactory(new PropertyValueFactory<>("id_user"));

          
          
           table_pub.setItems((ObservableList<Publication>) pubs.readAll());  
        } catch (SQLException ex) {
            Logger.getLogger(AfficherPublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void getSelected(MouseEvent event) throws SQLException {
           index = table_pub.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
   }
        id_textpub.setText(col_idpub.getCellData(index).toString());
        String myid=id_textpub.getText();
        PublicationService pubs=new PublicationService() ;
 
             col_nomcom.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
         col_prenomcom.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
          col_com.setCellValueFactory(new PropertyValueFactory<>("commentaire_text"));
                    col_idcom.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_comm.setItems((ObservableList<Commentaire>)pubs.MyCommentByPub(myid));  
            // JOptionPane.showMessageDialog(null, "Update"+col_com);

    }

    @FXML
    private void back(MouseEvent event) {
           try {
               Parent page3 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AccueilCommentaire.fxml"));
               Scene scene = new Scene(page3);
               Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AccueilPublicationController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
}

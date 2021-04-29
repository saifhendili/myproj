/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.entity.Commentaire;
import com.esprit.entity.Publication;
import com.esprit.service.CommentaireService;
import com.esprit.service.LikesService;
import com.esprit.service.PublicationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class AjouterCommentaireController implements Initializable {

    @FXML
    private TextField text_comment;
    @FXML
    private Button shareComment;
    @FXML
    private Button cleartextcomment;
    @FXML
    private TableView<Publication> tablepub;
    @FXML
    private TableColumn<Commentaire, String> id_col;
    @FXML
    private TableColumn<Commentaire, String>nom_col;
    @FXML
    private TableColumn<Commentaire, String> prenom_col;
    @FXML
    private TableColumn<Commentaire, String> pub_col;
    ObservableList<Publication> listM;
    ObservableList<Publication>  Publist = FXCollections.observableArrayList();
    @FXML
    private TextField text_id;
    int index=-1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            
            text_comment.clear();
            
            
            PublicationService pubs=new PublicationService() ;
            
            // id.setCellValueFactory(new PropertyValueFactory<>("id"));
            id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
            nom_col.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
            prenom_col.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
            pub_col.setCellValueFactory(new PropertyValueFactory<>("publication_text"));
            
            tablepub.setItems((ObservableList<Publication>) pubs.readAll());  
        } catch (SQLException ex) {
            Logger.getLogger(AjouterCommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
          
    }    

    @FXML
    private void ajouterComment(ActionEvent event) {
        
    
      //   shareComment.setOnAction(event -> {
      
            try {
                 String id = text_id.getText();
                Commentaire p3 = new Commentaire( "2",id, text_comment.getText(), "dddd","dddd");
                CommentaireService pubs=new CommentaireService() ;
                pubs.ajouter(p3);
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Publication insérée avec succés!");
                alert.show();
                text_comment.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(AjouterPublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        
           
       
       // });
        
        
    }

    @FXML
    private void clear(MouseEvent event) {
         text_comment.setText(null);
    }

    @FXML
    private void getSelected(MouseEvent event) {
        
          index = tablepub.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
   }
        text_id.setText(id_col.getCellData(index).toString());
   // textiduser.setText(iduser_col.getCellData(index).toString());
       //   textid.setText(id_col.getCellData(index).toString());

  
  // String id = text_id.getText();
    //  String iduser=textiduser.getText();
  

    
        
        
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.entity.Likes;
import com.esprit.entity.Publication;
import com.esprit.service.LikesService;
import com.esprit.service.PublicationService;
import com.esprit.utils.MyDb;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class AfficherPublicationController implements Initializable {

    
    
    
    
    
   @FXML
   private TableView<Publication> tablePub;
   // @FXML
 //    private TableColumn<Publication, String> id;
    @FXML
     private TableColumn<Publication, String> nom_col;
    @FXML
    private TableColumn<Publication, String> prenom_col;
    @FXML
    private TableColumn<Publication, String> pub_col;
    @FXML
       private TextField textPublication;
     @FXML
    private TextField textid;
     @FXML
    private TableColumn<Publication, String> id_col;
    @FXML
    private TableColumn<Publication, String>iduser_col;
 String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Publication publication = null ;
       ObservableList<Publication> listM;
    ObservableList<Publication>  Publist = FXCollections.observableArrayList();
    int index = -1;
 
   /* @FXML
    private TextField textiduser;*/
    @FXML
    private TextField textiduser;
    @FXML
    private Text text_likes;
   int test=0;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

                   try {
            Publist.clear();
            
            PublicationService pubs=new PublicationService() ;
         
   // id.setCellValueFactory(new PropertyValueFactory<>("id"));
              nom_col.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
         prenom_col.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
          pub_col.setCellValueFactory(new PropertyValueFactory<>("publication_text"));
                    id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
          iduser_col.setCellValueFactory(new PropertyValueFactory<>("id_user"));

          
          
           tablePub.setItems((ObservableList<Publication>) pubs.readAll());  
        } catch (SQLException ex) {
            Logger.getLogger(AfficherPublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
          
    }    

    @FXML
    private void close(MouseEvent event) {
    }

    @FXML
    private void GetAddView(MouseEvent event) {
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/com/esprit/view/AjouterPublication.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherPublicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RefreshTable(MouseEvent event) throws SQLException {
//    PublicationService pubs = new PublicationService();
//          pub_col.setCellValueFactory(new PropertyValueFactory<>("publication_text"));
//      //.setItems((ObservableList<Publication>) pubs.readAll());
//      
//         listM = (ObservableList<Publication>) pubs.readAll();
//        tablePub.setItems(listM);
 try {
               Parent page4 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AfficherPublication.fxml"));
               Scene scene = new Scene(page4);
               Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AccueilPublicationController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    @FXML
    private void Edit(ActionEvent event) {
          try {
              
              
      
            String pub = textPublication.getText();
            String id = textid.getText();
           PublicationService pubs=new PublicationService() ;
           pubs.update(id,pub);
           JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
           
            
       } catch (SQLException ex) {
           Logger.getLogger(AfficherPublicationController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }

    @FXML
    private void Delete(ActionEvent event) {
   
    
       try {
             String id = textid.getText();
           PublicationService pubs=new PublicationService() ;
           pubs.delete(id);
           JOptionPane.showMessageDialog(null, "Delete Done");
            UpdateTable();
           
       } catch (SQLException ex) {
           Logger.getLogger(AfficherPublicationController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
 
    @FXML
    private void getSelected(MouseEvent event) throws SQLException {
     
          index = tablePub.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
   }
        textid.setText(id_col.getCellData(index).toString());
    textiduser.setText(iduser_col.getCellData(index).toString());
       //   textid.setText(id_col.getCellData(index).toString());

   textPublication.setText(pub_col.getCellData(index).toString());
    String id = textid.getText();
      String iduser=textiduser.getText();
   LikesService likeSurv =new LikesService();
 String mylike= likeSurv.getlike(id,iduser);
  text_likes.setText(mylike);
//jaime();
    }
 public void UpdateTable(){
    
       try {
            PublicationService pubs = new PublicationService();
              nom_col.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
         prenom_col.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
          pub_col.setCellValueFactory(new PropertyValueFactory<>("publication_text"));
                    id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
          iduser_col.setCellValueFactory(new PropertyValueFactory<>("id_user"));
                  
      tablePub.setItems((ObservableList<Publication>) pubs.readAll());  
       } catch (SQLException ex) {
           Logger.getLogger(AfficherPublicationController.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
    }

    @FXML
    private void jaime() throws SQLException {
         

           String id = textid.getText();
      String iduser=textiduser.getText();
   Likes like =new Likes(id,iduser);
   LikesService likeSurv =new LikesService();
 String mylike= likeSurv.gererlikes(like);
  text_likes.setText(mylike);
       
     
         

    }

  
    
    
    @FXML
    private void comment(MouseEvent event) {
        //  btn_add.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AccueilCommentaire.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AccueilPublicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        //});
    }

    @FXML
    private void back(MouseEvent event) {
         try {
               Parent page3 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AccueilPublication.fxml"));
               Scene scene = new Scene(page3);
               Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AccueilPublicationController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    
}

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import com.esprit.utils.MyDb;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AfficherUtilisateurController implements Initializable {

    @FXML
    private TableColumn<User, String> NomColonne;
    @FXML
    private TableColumn<User, String> PrenomColonne;
    @FXML
    private Button btn_pie;
//  ObservableList<User> readAll;
private final List<User> list= new ArrayList<>();
    @FXML
    private TableColumn<User, String> idColonne;
    @FXML
    private TableColumn<User, String> emailColonne;
    @FXML
    private TableColumn<User, String> rolescolone;
    @FXML
    private TableColumn<User, String> passwordcolone;
    @FXML
    private TableColumn<User, String> typecolone;
    @FXML
    private TableColumn<User, String> specialitycolone;
    @FXML
    private TableColumn<User, String> reset_tokencolone;
    @FXML
    private TableColumn<User, Integer> is_confirmed_colone;
    @FXML
    private TableColumn<User, Integer> is_activatedcolone;
    @FXML
    private TableColumn<User, String> agecolone;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    Connection connection = null;
    String query= null;
    PreparedStatement ps= null;
    ResultSet rs=null;
    User users =null;
//    ObservableList <User> userList=FXCollections.observableArrayList();
  ObservableList<User> usersList=FXCollections.observableArrayList();
  ObservableList<User> oblist=FXCollections.observableArrayList();
    @FXML
    private TableView<User> tableview;
    @FXML
    private TextField textnom;
    @FXML
    private TextField textid;
    int index=-1;
    @FXML
    private TextField filtre;
    @FXML
    private Button back;
    @FXML
    private Button actualiser;
    /**
     * Initializes the controller class.
     * @param url
     */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          btn_pie.setOnAction(event->{
            try {
                System.out.println("testttttttttttttt");
                Parent pagePieChart=FXMLLoader.load(getClass().getResource("/roua/view/PieChartView.fxml"));
                Scene scene=new Scene(pagePieChart);
                Stage stage=(Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        
           actualiser.setOnAction(event->{
            try {
              
                Parent pagePieChart=FXMLLoader.load(getClass().getResource("/roua/view/AfficherUtilisateur.fxml"));
                Scene scene=new Scene(pagePieChart);
                Stage stage=(Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });  
       back.setOnAction(event ->{
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
        
     
            //    loadDate();
            usersList.clear();
          UserService pubs=new UserService() ;
         
    idColonne.setCellValueFactory(new PropertyValueFactory<>("id"));
              NomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
         PrenomColonne.setCellValueFactory(new PropertyValueFactory<>("prenom"));
          emailColonne.setCellValueFactory(new PropertyValueFactory<>("email"));
          rolescolone.setCellValueFactory(new PropertyValueFactory<>("roles"));
          
     passwordcolone.setCellValueFactory(new PropertyValueFactory<>("password"));
      typecolone.setCellValueFactory(new PropertyValueFactory<>("type"));
     specialitycolone.setCellValueFactory(new PropertyValueFactory<>("speciality"));
      reset_tokencolone.setCellValueFactory(new PropertyValueFactory<>("reset_token"));
        is_confirmed_colone.setCellValueFactory(new PropertyValueFactory<>("is_confirmed"));
        is_activatedcolone.setCellValueFactory(new PropertyValueFactory<>("is_activated"));
     agecolone.setCellValueFactory(new PropertyValueFactory<>("age"));
     
      
//          
           tableview.setItems((ObservableList<User>) pubs.readAll());
          
       
      
    }
    
    
  


    @FXML
    private void getAffiche()throws SQLException {
           
 
   
    }

    @FXML
    private void getselected(MouseEvent event) {
         index = tableview.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
   }
    textid.setText(idColonne.getCellData(index).toString());

  
   textnom.setText(NomColonne.getCellData(index).toString());

    }

    @FXML

        private void Edit(ActionEvent event) {
      
              
              
      
            String nom = textnom.getText();
        String id = textid.getText();
           UserService pubs=new UserService() ;
           pubs.updateUser(id, nom);
           JOptionPane.showMessageDialog(null, "Update");
     
    }
        
   

    @FXML
    private void delete(ActionEvent event) {

             String id = textid.getText();
           UserService pubs=new UserService() ;
           pubs.DeleteUser(id);
           JOptionPane.showMessageDialog(null, "Delete Done");
//            UpdateTable();
           
       
    }

    @FXML
    private void RechercherUser(ActionEvent event) {
        tableview.getItems().clear();
        String rch = filtre.getText();
         UserService us =new UserService() ;
         java.util.ArrayList<User> m1 = us.readmy(rch);
         for (int  i =0; i<m1.size(); i++)
         {
             oblist.add(new User(m1.get(i).getId(),m1.get(i).getNom(),m1.get(i).getPrenom(), m1.get(i).getEmail(), m1.get(i).getRoles(),m1.get(i).getPassword(),m1.get(i).getAdress(), m1.get(i).getType(), m1.get(i).getSpeciality(), m1.get(i).getReset_token(), m1.get(i).getIs_confirmed(), m1.get(i).getIs_activated(), m1.get(i).getAge() ));
     
//           oblist.add(new User(m1.get(i).getId(),m1.get(i).getNom(),m1.get(i).getPrenom(), m1.get(i).getEmail(), m1.get(i).getAge(),m1.get(i).getPassword(),m1.get(i).getRoles(),
//                   m1.get(i).getSpeciality(), m1.get(i).getType(),m1.get(i).getIs_activated(), m1.get(i).getIs_confirmed()));
     }
    idColonne.setCellValueFactory(new PropertyValueFactory<>("id"));
              NomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
         PrenomColonne.setCellValueFactory(new PropertyValueFactory<>("prenom"));
          emailColonne.setCellValueFactory(new PropertyValueFactory<>("email"));
          rolescolone.setCellValueFactory(new PropertyValueFactory<>("roles"));
          
     passwordcolone.setCellValueFactory(new PropertyValueFactory<>("password"));
      typecolone.setCellValueFactory(new PropertyValueFactory<>("type"));
     specialitycolone.setCellValueFactory(new PropertyValueFactory<>("speciality"));
      reset_tokencolone.setCellValueFactory(new PropertyValueFactory<>("reset_token"));
        is_confirmed_colone.setCellValueFactory(new PropertyValueFactory<>("is_confirmed"));
        is_activatedcolone.setCellValueFactory(new PropertyValueFactory<>("is_activated"));
     agecolone.setCellValueFactory(new PropertyValueFactory<>("age"));
       
     tableview.setItems(oblist);
        
        
    } 

    
   

}



   

   


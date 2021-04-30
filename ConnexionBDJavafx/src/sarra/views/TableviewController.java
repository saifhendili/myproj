/*
 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarra.views;

import com.esprit.service.Medicamentservice;
import com.esprit.service.reservationservice;
import com.esprit.entity.medicaments;
import com.esprit.entity.reservation_med;
import static java.awt.PageAttributes.MediaType.A;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;


import com.esprit.utils.MyDb;





/**
 * FXML Controller class
 *
 * @author ACER
 */
public class TableviewController implements Initializable {

    @FXML
    private TableView<medicaments> tvmed;
    @FXML
    private TableColumn<medicaments, String> nom;
    @FXML
    private TableColumn<medicaments, String> desc;
    @FXML
    private TableColumn<medicaments, Float> prix;
    @FXML
    private TableColumn<medicaments, Integer> qte;
    @FXML
    private TableColumn<medicaments, String> img;
    @FXML
    private TableColumn<medicaments, String> idphar;

    @FXML
    private Button supp;
    @FXML
    private Button retour;
    @FXML
    private Button ajout;
    @FXML
    private Button affiche;
    
   
    @FXML
    private Button modif;
    @FXML
    private TextField nomt;
    @FXML
    private TextField idt;
    @FXML
    private TableColumn<medicaments, String> id;
  int index=-1;
  String query=null;
  Connection connection=null;
  PreparedStatement ps=null;
  ResultSet rs=null;
  
  
 ObservableList<medicaments> medicamentsList = FXCollections.observableArrayList();
    @FXML
    private TextField recherche;
   
    @FXML
    private ImageView imageview;
    @FXML
    private TextField text_image;
    @FXML
    private Button refrech;
    @FXML
    private Button Reserver;
    @FXML
    private Button reservation;
    @FXML
    private Button notif;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
      
    
        try {
            // TODO
            loadDate();
        } catch (SQLException ex) {
            Logger.getLogger(TableviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                               
                   
           
       
          ajout.setOnAction(event->{
          try {
              
             Parent Page2= FXMLLoader.load(getClass().getResource("/sarra/views/AjoutMedicament.fxml"));
              Scene scene = new Scene(Page2);
               Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
             
          } catch (IOException ex) {
              Logger.getLogger(AcceuilviewController.class.getName()).log(Level.SEVERE, null, ex);
          }
              
    })   ; 
          
          
          retour.setOnAction(event->{
          try {
              
             Parent Page2= FXMLLoader.load(getClass().getResource("/sarra/views/Acceuilview.fxml"));
              Scene scene = new Scene(Page2);
               Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
             
          } catch (IOException ex) {
              Logger.getLogger(AcceuilviewController.class.getName()).log(Level.SEVERE, null, ex);
          }
              
    })   ; 
          
          
    reservation.setOnAction(event-> { 
      
          try {
              Parent Page1 = FXMLLoader.load(getClass().getResource("/sarra/views/AfficheReservation.fxml"));
               Scene scene = new Scene(Page1);
               Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
              
              
            
          } catch (IOException ex) {
              Logger.getLogger(AcceuilviewController.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
   refrech.setOnAction(event-> { 
      
          try {
              Parent Page1 = FXMLLoader.load(getClass().getResource("/sarra/views/Tableview.fxml"));
               Scene scene = new Scene(Page1);
               Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
              
              
            
          } catch (IOException ex) {
              Logger.getLogger(AcceuilviewController.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
    }  
        @FXML
    private void Search(ActionEvent event) throws SQLException {
       tvmed.getItems().clear();
       String rech=recherche.getText();
       Medicamentservice ms= new Medicamentservice();
        List<medicaments> m1=ms.Search(rech);
        for(int i=0;i<m1.size();i++)
        { medicamentsList.add(new medicaments(m1.get(i).getId(),m1.get(i).getNom(),m1.get(i).getDescription(),m1.get(i).getPrix(),m1.get(i).getQuantity(),m1.get(i).getImg(),m1.get(i).getId_pharmacie()));
        }
//     id.setCellValueFactory(new PropertyValueFactory<>("id"));     
     nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
     desc.setCellValueFactory(new PropertyValueFactory<>("description"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     qte.setCellValueFactory(new PropertyValueFactory<>("quantity"));
     img.setCellValueFactory(new PropertyValueFactory<>("img"));
     idphar.setCellValueFactory(new PropertyValueFactory<>("idphar"));
    tvmed.setItems(medicamentsList);
     
         
    }  


    @FXML
    private void getAffiche() throws SQLException {
     medicamentsList.clear();
     query="SELECT * FROM `medicaments`";
     ps=connection.prepareStatement(query);
     rs= ps.executeQuery();
       while(rs.next()){
  medicamentsList.add(new medicaments(rs.getString("id"),rs.getString("nom"),rs.getString("description"),rs.getFloat("prix"),rs.getInt("quantity"),rs.getString("img"),rs.getString("id_pharmacie")));
            }
     tvmed.setItems(medicamentsList);
     
     
 }

    private void loadDate() throws SQLException {
     
          connection = MyDb.getInstance().getConnection();
           getAffiche();
       id.setCellValueFactory(new PropertyValueFactory<>("id"));     
     nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
     desc.setCellValueFactory(new PropertyValueFactory<>("description"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     qte.setCellValueFactory(new PropertyValueFactory<>("quantity"));
     img.setCellValueFactory(new PropertyValueFactory<>("img"));
     idphar.setCellValueFactory(new PropertyValueFactory<>("idphar"));
     
    }

    @FXML
    private void getselected(MouseEvent event) {
        
    index =  tvmed.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
   }
    idt.setText(id.getCellData(index).toString());
    nomt.setText( nom.getCellData(index).toString());
    text_image.setText(img.getCellData(index).toString());
   
    String immmg =text_image.getText();
    
  Image myimage =new Image("com/esprit/image/" + immmg + "");
  //JOptionPane.showMessageDialog(null,myimage);
  imageview.setImage(myimage);
 
    }

    @FXML
    private void Edit(ActionEvent event) {
         String id = idt.getText();
         String nom =nomt.getText();
           Medicamentservice m =new Medicamentservice() ;
           m.UpdateMedicaments(id, nom);
           JOptionPane.showMessageDialog(null, "Update");
//            UpdateTable();
        
    }

    @FXML
    private void delete(ActionEvent event) {
         String id = idt.getText();
         Medicamentservice pubs=new Medicamentservice() ;
           pubs.DeleteMedicaments("id");
           JOptionPane.showMessageDialog(null, "Delete Done");
//            UpdateTable();
           
    }


    @FXML
    private void tri(ActionEvent event) throws SQLException {
              medicamentsList.clear();
    String query= "SELECT * FROM medicaments\n" +
           "ORDER BY prix ;";
     ps=connection.prepareStatement(query);
     rs= ps.executeQuery();
       while(rs.next()){
  medicamentsList.add(new medicaments(rs.getString("id"),rs.getString("nom"),rs.getString("description"),rs.getFloat("prix"),rs.getInt("quantity"),rs.getString("img"),rs.getString("id_pharmacie")));
            }
     tvmed.setItems(medicamentsList);
    }

 

  

    @FXML
    private void reserver(ActionEvent event) throws SQLException, Exception {
        String medicament =idt.getText();
        reservation_med r1= new reservation_med(medicament,"doliprane","2","2");
        reservationservice sr=new reservationservice();
        sr.ajoutreservation(r1);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reservation insérée avec succés!");
                alert.show();
       sendMail("sarra.meddeb@esprit.tn");
        
    }
   public static void sendMail(String recepient) throws SQLException,MessagingException,Exception {
        System.err.println(" email en cours");
    Properties properties = new Properties();
    
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable" ,"true");
    properties.put("mail.smtp.host" ,"smtp.gmail.com");
    properties.put("mail.smtp.port" ,"587");

    String myAccountEmail = "sarra.meddeb@esprit.tn";
    String password = "203JFT3955";
 Session session= Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(myAccountEmail, password);
            }
     
});
 Message message = prepareMessage(session, myAccountEmail, recepient);
 Transport.send(message);
 System.out.println("Mail envoyé avec succée !");
   }

    private static Message prepareMessage(Session session, String myAccountEmail,String recepient) throws AddressException, MessagingException {
     
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Reservation médicament sahty.tn");
            message.setText("Bonjour, \n votre réservation a été bien enregistrer vous ete la bienveneue ");
            return message;
       
    }
    @FXML
    private void Notify(ActionEvent event) {
       // Image img= new Image("/images/doliprane.jpg");
     Notifications notificationBuilder = Notifications.create()
     .title("Nouveaux Médicaments")
     .text("Vastarel est de nouveaux disponible")
      .graphic(null)
      .hideAfter(Duration.seconds(5))
      .position(Pos.TOP_RIGHT)
      .onAction(new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent event) {
            System.out.println("cliquer sur la notification");
         }
      
      });
    //notificationBuilder.darkStyle();
     notificationBuilder.showInformation();
  
       
    }


    }

  




  
    


    
    
    
    

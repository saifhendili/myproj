/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.URL;
//import java.net.URLConnection;
//import java.net.URLEncoder;
import com.esprit.entity.FormAide;
import com.esprit.entity.ReservationAide;
import com.esprit.service.FormAideService;
import com.esprit.service.ReservationAideService;
import java.io.IOException;
//import java.net.HttpURLConnection;
//import javax.mail.PasswordAuthentication;
import java.net.URL;
import java.sql.SQLException;
//import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import javafx.util.Duration;
//import javax.mail.Authenticator;
// import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.swing.JOptionPane;
//import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author saif
 */
public class AfficherProduitController implements Initializable {

    @FXML
    private TableColumn<FormAide, String> quan_prod;
    @FXML
    private TableColumn<FormAide, String> desc_prod;
    @FXML
    private TableColumn<FormAide, String> id_produit;
    @FXML
    private TableView<FormAide> tableview;
    @FXML
    private TextField text_iddd;
    int index=-1;
    @FXML
    private Text Retour;
    @FXML
    private ImageView image;
    @FXML
    private TableColumn<FormAide, String>img_produit;
    @FXML
    private TextField text_image;
    @FXML
    private TextField search_text;
    @FXML
    private TextField nomde_produit;
    @FXML
    private TextField cat;
    @FXML
    private TableColumn<FormAide, String>cat_lab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FormAideService pubs=new FormAideService() ;
            
            // id.setCellValueFactory(new PropertyValueFactory<>("id"));
            quan_prod.setCellValueFactory(new PropertyValueFactory<>("quantit"));
            desc_prod.setCellValueFactory(new PropertyValueFactory<>("description"));
            id_produit.setCellValueFactory(new PropertyValueFactory<>("id"));
                      img_produit.setCellValueFactory(new PropertyValueFactory<>("img"));
      cat_lab.setCellValueFactory(new PropertyValueFactory<>("categories"));
            
            
            
            tableview.setItems((ObservableList<FormAide>) pubs.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public final String ACCOUNT_SID =
            "AC7e219a9b33c6786b10d406d6a3857e09";
    public final String AUTH_TOKEN =
            "5b98339f681632ecd342d44604650216";
    private void smstel(){
   
};
    
    
    
    @FXML
    private void add_reserv(ActionEvent event) throws SQLException, Exception {
        
        String id_prod=text_iddd.getText();
         String name=nomde_produit.getText();
             String cate=cat.getText();

          ReservationAide p3 = new ReservationAide("3",id_prod,"ddd","sss");
               ReservationAideService pubs=new ReservationAideService() ;
                pubs.ajouterReservation(p3);
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reservation insérée avec succés!");
                alert.show();
 //  sendMail("saifhendili12@gmail.com");
           
           //    JavaMailUtil.     
                
                
             
    }

    
    
    
//     public static void sendMail(String recepient) throws MessagingException {
//     
//        Properties properties = new Properties();
//
//        //Enable authentication
//        properties.put("mail.smtp.auth", "true");
//        //Set TLS encryption enabled
//        properties.put("mail.smtp.starttls.enable", "true");
//        //Set SMTP host
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        //Set smtp port
//        properties.put("mail.smtp.port", "587");
//
//        //Your gmail address
//        String myAccountEmail = "saif.hindili.11@gmail.com";
//        //Your gmail password
//        String password = "girod 1313131313";
//
//        //Create a session with account credentials
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(myAccountEmail, password);
//            }
//        });
//
//        //Prepare email message
//        Message message = prepareMessage(session, myAccountEmail, recepient);
//
//        //Send mail
//        Transport.send(message);
//       Alert alert = new Alert(Alert.AlertType.INFORMATION);
//       
//                alert.setTitle("Information Dialog");
//                alert.setHeaderText(null);
//                alert.setContentText("Reservation insérée avec succés!");
//                alert.show();
//                
//                Image imgg=new Image("com/esprit/image/small_tick.png");
//                
//                Notifications notificationBuilder= Notifications.create()
//                .title("Reservation Complete")
//                 .graphic(new ImageView(imgg))
//                .text("Reservation insérée avec succés ")
//                .hideAfter(Duration.seconds(6))
//                        .position(Pos.TOP_RIGHT);
//                 notificationBuilder.show();
//         
//                
//    }
    @FXML
    private void getSlected(MouseEvent event) {
           index = tableview.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
   }
    text_image.setText(img_produit.getCellData(index).toString());
    text_iddd.setText(id_produit.getCellData(index).toString());
    nomde_produit.setText(desc_prod.getCellData(index).toString());
     cat.setText(cat_lab.getCellData(index).toString());
    
    
    String immmg =text_image.getText();
    
  Image myimage =new Image("/com/esprit/image/" + immmg + "");
  //JOptionPane.showMessageDialog(null,myimage);
  image.setImage(myimage);
        
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

    @FXML
    private void Search(ActionEvent event) {
            try {
            FormAideService pubs=new FormAideService() ;
            
            // id.setCellValueFactory(new PropertyValueFactory<>("id"))
            quan_prod.setCellValueFactory(new PropertyValueFactory<>("quantit"));
            desc_prod.setCellValueFactory(new PropertyValueFactory<>("description"));
            id_produit.setCellValueFactory(new PropertyValueFactory<>("id"));
           img_produit.setCellValueFactory(new PropertyValueFactory<>("img"));

            tableview.setItems((ObservableList<FormAide>) pubs.Search("%"+search_text.getText()+"%"));
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    
//     private static Message prepareMessage(Session session, String myAccountEmail, String recepient) throws AddressException, MessagingException {
//       
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(myAccountEmail));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//            message.setSubject("Reservation");
//            String htmlCode = "<h1> Vous avez passer un commande</h1>";
//            message.setContent(htmlCode, "text/html");
//            return message;
//
//    }

    @FXML
    private void getsms(ActionEvent event) {
              Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      String y="+21625609526";
        Message message = Message 
                .creator(new PhoneNumber("+21625609526"), // to
                        new PhoneNumber("+16174154338"), // from
                       "Votre reservation a effectue avec success")
                .create();
  System.out.println("sms telephone");
        System.out.println(message.getSid());

    }
    
   

}

     
        
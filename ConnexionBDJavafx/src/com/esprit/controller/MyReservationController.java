/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.entity.FormAide;
import com.esprit.entity.ReservationAide;
import com.esprit.service.FormAideService;
import com.esprit.service.ReservationAideService;
import com.lowagie.text.Document;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





/**
 * FXML Controller class
 *
 * @author saif
 */
public class MyReservationController implements Initializable {

    @FXML
    private TableColumn<ReservationAide, String> id;
    @FXML
    private TableColumn<ReservationAide, String> idpatient;
    @FXML
    private TableColumn<ReservationAide, String> idproduit;
    @FXML
    private TableColumn<ReservationAide, String> nom;
    @FXML
    private TableColumn<ReservationAide, String> description;
    @FXML
    private TableView<ReservationAide> tableview;
    @FXML
    private Button mypdf;
    @FXML
    private TextField fielname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            ReservationAideService pubs=new ReservationAideService() ;
       ;
            // id.setCellValueFactory(new PropertyValueFactory<>("id"));
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            idpatient.setCellValueFactory(new PropertyValueFactory<>("idPatient"));
            idproduit.setCellValueFactory(new PropertyValueFactory<>("id"));
             nom.setCellValueFactory(new PropertyValueFactory<>("produit"));
             description.setCellValueFactory(new PropertyValueFactory<>("desc"));
                    //  img_produit.setCellValueFactory(new PropertyValueFactory<>("img"));

            
            
            
            tableview.setItems((ObservableList<ReservationAide>) pubs.MyReserv("3"));
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void back(MouseEvent event) {
    }
private  String[] columns = { "First Name", "Last Name", "Email","produit","desc"};
  private List<ReservationAide> contacts = new ArrayList<ReservationAide>();

    @FXML
    private void getlypdf(ActionEvent event) throws DocumentException, FileNotFoundException, IOException, SQLException {
    ReservationAideService rss=new ReservationAideService();
    contacts=rss.MyReservsss("3");

// 
//  contacts.add(new ReservationAide("Sylvain", "Saurel",
//      "sylvain.saurel@gmail.com"));
//    contacts.add(new ReservationAide("Albert", "Dupond",
//      "sylvain.saurel@gmail.com"));
//    contacts.add(new ReservationAide("Pierre", "Dupont",
//      "sylvain.saurel@gmail.com"));
//    
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Contacts");


  
    // Create a Row
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
   //   cell.setCellStyle(headerCellStyle);
    }

    // Create Other rows and cells with contacts data
    int rowNum = 1;

    for (ReservationAide contact : contacts) {
      Row row = sheet.createRow(rowNum++);
      row.createCell(0).setCellValue(contact.id);
      row.createCell(1).setCellValue(contact.idPatient);
      row.createCell(2).setCellValue(contact.idProduit);
       row.createCell(3).setCellValue(contact.produit);
        row.createCell(4).setCellValue(contact.desc);
    
    }

    // Resize all columns to fit the content size
    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }

    // Write the output to a file
    FileOutputStream fileOut = new FileOutputStream("myreserv.xlsx");
    workbook.write(fileOut);
    fileOut.close();
  }
}
    
    


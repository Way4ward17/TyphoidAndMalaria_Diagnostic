/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import Home.Javaconnect;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author way4ward
 */
public class DoctorController implements Initializable {
Connection conn;
PreparedStatement pstmt;
ResultSet rs;
    @FXML
    private TableColumn<?, ?> surname;
    @FXML
    private TableColumn<?, ?> firstname;
    @FXML
    private TableColumn<?, ?> symtoms;
    @FXML
    private TableColumn<?, ?> date;
    private ObservableList<LoadTables> dataa = FXCollections.observableArrayList() ;
    @FXML
    private TableView<LoadTables> table;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> phone;
    @FXML
    private TableColumn<?, ?> test;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = Javaconnect.ConnecrDB();
        setCellTable();
       
         refreshtable();
     
       // 
    }    
      
    
    
    
   private void setCellTable(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
      surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
           symtoms.setCellValueFactory(new PropertyValueFactory<>("symtoms"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
  
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
         test.setCellValueFactory(new PropertyValueFactory<>("test"));
  
    }
  //THIS IS TO FIRST CLEAR THE TABLE B4 ITS REFRESHED
   private void refreshtable(){
       dataa.clear();
     try {
        pstmt = conn.prepareStatement("SELECT * FROM PATIENT");
        rs = pstmt.executeQuery();
        while(rs.next()){
          dataa.add(new LoadTables(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
        }
    } catch (SQLException ex) {
        Logger.getLogger(DoctorController.class.getName()).log(Level.SEVERE, null, ex);
    }

     table.setItems(dataa);
    }   

    @FXML
    private void openHome(ActionEvent event) {
            loadwindow("/Home/Home.fxml","DIANOSTICS SECTION"); 
    }
 
    
      void loadwindow(String loc ,  String title){
        try {  
            Parent root = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage();
            stage.setTitle(title);
              Scene scene = new Scene(root);
              stage.setScene(scene);
  
        stage.initStyle(StageStyle.DECORATED);
      stage.setScene(scene);
      stage.setResizable(false);
      stage.centerOnScreen();
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DoctorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malariaandtyphoid;

import Home.Javaconnect;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;


/**
 *
 * @author way4ward
 */
public class LoginController implements Initializable {
Connection conn;
PreparedStatement pstmt;
ResultSet rs;

    @FXML
    private JFXTextField staffID;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private TextField signUpStaffID;
    @FXML
    private PasswordField signUpPass;
    @FXML
    private TextField signUpFullname;
    @FXML
    private JFXButton submit;
    @FXML
    private AnchorPane splashAnchorPane;
    @FXML
    private AnchorPane signpane;
    @FXML
    private JFXButton signBtn;
    @FXML
    private JFXButton lbBtn;
    @FXML
    private JFXRadioButton Doctor;
    @FXML
    private JFXRadioButton otherStaff;
    @FXML
    private JFXButton closeSignUp;
    @FXML
    private StackPane stick;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stick.setVisible(false);
        signpane.setVisible(false);
        conn = Javaconnect.ConnecrDB();
        closeSignUp.setOnAction(e->{
          signpane.setVisible(false);   
        });
        signBtn.setOnAction(e->{
           signpane.setVisible(true); 
        });
            lbBtn.setOnAction(e-> login(e));
            Random();
    }    
 public void Random(){
          Random rd = new Random();
    signUpStaffID.setText("SFF"+rd.nextInt(8899988+1));        
    } 
    @FXML
    private void signup(ActionEvent event) {
        String sql = "INSERT INTO SIGNUP (ID , FULLNAME , PASSWORD) VALUES (?,?,?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,signUpStaffID.getText());
             pstmt.setString(2,signUpFullname.getText());
            pstmt.setString(3,signUpPass.getText());
           
            pstmt.execute();
              signpane.setVisible(false); 
              Image img = new Image("/images/owk.png");
               Notifications notificationBuilder = Notifications.create()
               .title("Success")
               .text("SUCCESFULL")
               .graphic(new ImageView(img))
               .hideAfter(Duration.seconds(3))
               .position(Pos.BOTTOM_RIGHT);
               notificationBuilder.show();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null ,e);
        }
    }
       private void login(ActionEvent event) {
           if(!Doctor.isSelected() && !otherStaff.isSelected()){
               stick.setVisible(true);
      JFXDialogLayout content =  new JFXDialogLayout();
  content.setHeading(new Text("Error")); // Header of the Dialog
  content.setBody(new Text("Select DOCTOR/STAFF")); // Text in the dialog
  JFXDialog dialog = new JFXDialog(stick, content,JFXDialog.DialogTransition.CENTER);
  JFXButton btn = new JFXButton("Close"); // Button to close Dialog

  btn.setOnAction(new EventHandler <ActionEvent>(){
      @Override
      public void handle(ActionEvent event) {
          dialog.close();
          stick.setVisible(false);
      }
      
  });
  content.setActions(btn);
     
     dialog.show();  
           }else
           
       if(Doctor.isSelected() && !otherStaff.isSelected()){     
      conn = Javaconnect.ConnecrDB();
       String sql = "SELECT * FROM SIGNUP WHERE ID=? AND Password=?";
       try{
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1 , staffID.getText());
           pstmt.setString(2 , pass.getText());
           rs = pstmt.executeQuery();
           if(rs.next()){ 
             
               
               Parent root;  
               Stage stage = new Stage();
              
            root = FXMLLoader.load(getClass().getResource("/Doctor/Doctor.fxml"));
            // JFXDecorator decorator=new JFXDecorator(stage, root, false, false, true);
      //  decorator.setCustomMaximize(false);
    //   decorator.setBorder(Border.EMPTY);
       
        Scene scene = new Scene(root);
//stage = (Stage) lgbtn.getScene().getWindow();
              stage.setScene(scene);
              stage.setResizable(false);
              stage.centerOnScreen();
              stage.show(); 
               splashAnchorPane.getScene().getWindow().hide();
                     Image img = new Image("/images/owk.png");
               Notifications notificationBuilder = Notifications.create()
               .title("LOGIN")
               .text("LOGIN SUCCESFULL")
               .graphic(new ImageView(img))
               .hideAfter(Duration.seconds(3))
               .position(Pos.BOTTOM_RIGHT);
               notificationBuilder.show();
           
           }else{
              Alert alert  = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("INVALID DETAILS");
            alert.showAndWait();
           }
               
       }catch(Exception e){
           
       }
       }else
           
       if(otherStaff.isSelected() && !Doctor.isSelected()){
            conn = Javaconnect.ConnecrDB();
       String sqll = "SELECT * FROM SIGNUP WHERE ID=? AND Password=?";
       try{
           pstmt = conn.prepareStatement(sqll);
           pstmt.setString(1 , staffID.getText());
           pstmt.setString(2 , pass.getText());
           rs = pstmt.executeQuery();
           if(rs.next()){ 
             
               
               Parent root;  
               Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/Home/Home.fxml")); 
          
       
        Scene scene = new Scene(root);
//stage = (Stage) lgbtn.getScene().getWindow();
              stage.setScene(scene);
              stage.setResizable(false);
              stage.centerOnScreen();
              stage.show(); 
               splashAnchorPane.getScene().getWindow().hide();
                     Image img = new Image("/images/owk.png");
               Notifications notificationBuilder = Notifications.create()
               .title("LOGIN")
               .text("LOGIN SUCCESFULL")
               .graphic(new ImageView(img))
               .hideAfter(Duration.seconds(3))
               .position(Pos.BOTTOM_RIGHT);
               notificationBuilder.show();
           
           }else{
              Alert alert  = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("INVALID DETAILS");
            alert.showAndWait();
           }
           
       }catch(Exception e){
           
       }
              
          
       
      
}
       }
}
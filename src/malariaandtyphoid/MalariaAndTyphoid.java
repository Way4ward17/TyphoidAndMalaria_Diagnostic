/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malariaandtyphoid;

import com.jfoenix.controls.JFXDecorator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author way4ward
 */
public class MalariaAndTyphoid extends Application {
    Connection conn;
PreparedStatement pstmt;
ResultSet rs;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/malariaandtyphoid/Login.fxml"));
        
     
       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
        one();
        two();
        three();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void one(){
                 String sqll = "CREATE TABLE IF NOT EXISTS `REPORT` (ID VARCHAR(20) , SURNAME VARCHAR(20) , MIDDLENAME VARCHAR(20), OTHER VARCHAR(20), GENDER VARCHAR(10), PHONE VARCHAR (14), PHONE2 VARCHAR(14),STATUS VARCHAR(200) , TYPE VARCHAR(2000) , EFFECT VARCHAR(2000) , ANEMIA VARCHAR(2000)  ,  OTHERS VARCHAR(2000) , SYMTOMS VARCHAR(2000) , DATE VARCHAR(15), TEST VARCHAR(2000) )";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/fxdiag2","sa","");
        
        pstmt = conn.prepareStatement(sqll);
        pstmt.execute();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null , ex);
    }   
    }
    
     public void two(){
                 String sqll = "CREATE TABLE IF NOT EXISTS `PATIENT` (ID VARCHAR(100), SURNAME VARCHAR(50), MIDDLENAME VARCHAR(30),SYMTOMS VARCHAR(2000),"
                         + " DATE VARCHAR(30),PHONE VARCHAR(30), TEST VARCHAR(2000) )";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/fxdiag2","sa","");
        
        pstmt = conn.prepareStatement(sqll);
        pstmt.execute();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null , ex);
    }
              
       
    }
        public void three(){
                 String sqll = "CREATE TABLE IF NOT EXISTS `SIGNUP` (ID VARCHAR(100), FULLNAME VARCHAR(50), PASSWORD VARCHAR(30) )";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/fxdiag2","sa","");
        
        pstmt = conn.prepareStatement(sqll);
        pstmt.execute();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null , ex);
    }
        }
       
    }
 


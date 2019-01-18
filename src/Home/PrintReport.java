/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.JOptionPane;
/**
 *
 * @author way4ward
 */

public class PrintReport extends JFrame {
    Connection conn = Javaconnect.ConnecrDB();;
PreparedStatement pstmt;
ResultSet rs;



public void PrintReport() throws HeadlessException{
    
}
public void showReport(){
    conn = Javaconnect.ConnecrDB();
    try{
   //String src = ;
    File file = new File("C:\\Users\\Public\\Verifier");
         if(!file.exists()){
             file.mkdirs();
         }
   JasperDesign jasperDesign =JRXmlLoader.load(file+"\\Receipt.jrxml");
   String sql = "select * from REPORT";
   JRDesignQuery jrquery = new JRDesignQuery();
   jrquery.setText(sql);
   jasperDesign.setQuery(jrquery);
    JasperReport jr = JasperCompileManager.compileReport(jasperDesign);
    JasperPrint JasperPrint = JasperFillManager.fillReport(jr,null,conn); 
    JRViewer viewer = new JRViewer(JasperPrint);
    viewer.setOpaque(true);
    viewer.setVisible(true);

    this.add(viewer);
    this.setSize(900, 500);
    this.setVisible(true);
    
   
    }    catch (JRException ex) {
            Logger.getLogger(PrintReport.class.getName()).log(Level.SEVERE, null, ex);
        }
 String sql = "delete from REPORT";
         try{
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null , e);
                
            }
    
    
     

    
}    
    }


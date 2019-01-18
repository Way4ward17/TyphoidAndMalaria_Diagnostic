/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author way4ward
 */
public class HomeController implements Initializable {

    @FXML
    private TextArea infoTab;
    @FXML
    private JFXButton exit;
  
    @FXML
    private AnchorPane feverpane;
    @FXML
    private JFXCheckBox chill;
    @FXML
    private JFXCheckBox fever;
    @FXML
    private JFXCheckBox Anemia;
    @FXML
    private JFXCheckBox diarrhea;
    @FXML
    private JFXCheckBox Mpain;
    @FXML
    private JFXCheckBox bloodStool;
    @FXML
    private JFXCheckBox Abdopain;
    @FXML
    private JFXCheckBox nausea;
    @FXML
    private JFXCheckBox weakFever;
    @FXML
    private JFXCheckBox LOAfever;
    @FXML
    private JFXCheckBox SweatingFever;
    @FXML
    private JFXCheckBox HeadFever;
    @FXML
    private JFXCheckBox VimitingFever;
    @FXML
    private JFXCheckBox MAchesFever;
    @FXML
    private JFXCheckBox fatigue;
    @FXML
    private JFXButton close;
  
    @FXML
    private TextArea malariaStatus;
    @FXML
    private TextArea malariaType;
    @FXML
    private TextArea malariaEffect;
    @FXML
    private TextArea anemiaStatus;
    @FXML
    private TextArea others;
    @FXML
    private TextField bar;
    @FXML
    private JFXButton clearReport;
    @FXML
    private JFXCheckBox appetite;
    @FXML
    private JFXCheckBox Lethargy;
    @FXML
    private JFXCheckBox Headache;
Connection conn;
PreparedStatement pstmt;
ResultSet rs;
    @FXML
    private JFXButton Print;
    @FXML
    private TextField surname;
    @FXML
    private TextField phone2;
    @FXML
    private TextField middle;
    private TextField other;
    @FXML
    private TextField phone;
    @FXML
    private JFXRadioButton male;
    @FXML
    private JFXRadioButton female;
    /**
     * Initializes the controller class.
     */
    private String date;
    private String gender;
    @FXML
    private TextField other2;
    @FXML
    private TextArea symtomsField;
    @FXML
    private Text id;
    @FXML
    private AnchorPane testPane;
    @FXML
    private JFXButton openTest;
    @FXML
    private TextField a; @FXML private TextField b; @FXML  private JFXRadioButton c; @FXML  private JFXRadioButton d;  @FXML  private JFXButton closeTest;
    @FXML  private JFXRadioButton h; @FXML private JFXRadioButton i; @FXML private JFXRadioButton e;  @FXML private JFXRadioButton g; @FXML private TextField f;
    @FXML private JFXRadioButton j;@FXML private JFXRadioButton l; @FXML private JFXRadioButton k; @FXML private JFXRadioButton m; @FXML private JFXRadioButton n;
    @FXML
    private JFXCheckBox wi; @FXML private JFXCheckBox ty; @FXML private JFXCheckBox bl; @FXML private JFXCheckBox rd; @FXML private JFXCheckBox mo;  @FXML private JFXCheckBox an;     @FXML private JFXCheckBox ur; @FXML private TextField bo; 
    @FXML
    private JFXCheckBox mp;
    @FXML
    private JFXRadioButton o;
    @FXML
    private JFXRadioButton p;
    @FXML
    private TextArea symtomsField1;
    @FXML
    private AnchorPane splashAnchorPane;
    @FXML
    private TextField f1;
    @FXML
    private TextField f11;
    @FXML
    private TextField f2;
    @FXML
    private ToggleGroup gen;
    @FXML
    private ToggleGroup dot;
    @FXML
    private ToggleGroup rapid;
    @FXML
    private ToggleGroup sme;
    @FXML
    private ToggleGroup mole;
    @FXML
    private ToggleGroup anti;
    @FXML
    private ToggleGroup parA;
    @FXML
    private TextField phone1;
@Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = Javaconnect.ConnecrDB();
        testPane.setVisible(false);
        openTest.setOnAction(e->{
           testPane.setVisible(true); 
        });
           ur.setOnAction(e->{
           a.setText("0");
           });
        wi.setOnAction(e->{
           b.setText("0");
           bo.setText("0");
           f1.setText("0");
           f11.setText("0");
        });
            male.setOnAction(e->{
          gender = male.getText();
      });
       female.setOnAction(e->{
          gender = female.getText();
      });
       Random();
          Print.setOnAction(e->{
           
            PrintReport viewReport = new PrintReport();
            viewReport.showReport();
          });
        
        clearReport.setOnAction(e->{
           malariaStatus.setText("");
           malariaType.setText("");
           malariaEffect.setText("");
           anemiaStatus.setText("");
           others.setText("");
            String sql = "delete from REPORT";
         try{
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();
                
            }catch(Exception ec){
                JOptionPane.showMessageDialog(null , ec);
                
            }
        });
        exit.setOnAction(e->{
           System.exit(0);
        });
        close.setOnAction(e->{
              feverpane.setVisible(false); 
        });
        
        feverpane.setVisible(false);
       fever.setOnAction(e->{
            if(fever.isSelected()){ 
                
                double kick = Double.parseDouble(bar.getText());double pa = kick + 2;String kicker = String.format("%.2f", pa);bar.setText(kicker);      }
     if(!fever.isSelected()){
         double kick = Double.parseDouble(bar.getText()); double pa = kick - 2; String kicker = String.format("%.2f", pa); bar.setText(kicker); }   
           if(feverpane.isVisible() == (true)){
               feverpane.setVisible(false);
           }else{
          feverpane.setVisible(true);
           }
       });
        chill.setOnAction(ex->{
     if(chill.isSelected()){ double kick = Double.parseDouble(bar.getText());double pa = kick + 2;String kicker = String.format("%.2f", pa);bar.setText(kicker);      }
     if(!chill.isSelected()){double kick = Double.parseDouble(bar.getText()); double pa = kick - 2; String kicker = String.format("%.2f", pa); bar.setText(kicker); }    });
    
           
       
              diarrhea.setOnAction(ex->{
     if(diarrhea.isSelected()){ double kick = Double.parseDouble(bar.getText());double pa = kick + 2;String kicker = String.format("%.2f", pa);bar.setText(kicker);      }
     if(!diarrhea.isSelected()){double kick = Double.parseDouble(bar.getText()); double pa = kick - 2; String kicker = String.format("%.2f", pa); bar.setText(kicker); }    });
                 Mpain.setOnAction(ex->{
     if(Mpain.isSelected()){ double kick = Double.parseDouble(bar.getText());double pa = kick + 2;String kicker = String.format("%.2f", pa);bar.setText(kicker);      }
     if(!Mpain.isSelected()){double kick = Double.parseDouble(bar.getText()); double pa = kick - 2; String kicker = String.format("%.2f", pa); bar.setText(kicker); }    });
                    fatigue.setOnAction(ex->{
                       
     if(fatigue.isSelected()){ 
          weakFever.setSelected(true);
                        MAchesFever.setSelected(true);
         double kick = Double.parseDouble(bar.getText());double pa = kick + 2;String kicker = String.format("%.2f", pa);bar.setText(kicker);      }
     if(!fatigue.isSelected()){
          weakFever.setSelected(false);
                        MAchesFever.setSelected(false);
         double kick = Double.parseDouble(bar.getText()); double pa = kick - 2; String kicker = String.format("%.2f", pa); bar.setText(kicker); }    });
                       bloodStool.setOnAction(ex->{
     if(bloodStool.isSelected()){ double kick = Double.parseDouble(bar.getText());double pa = kick + 2;String kicker = String.format("%.2f", pa);bar.setText(kicker);      }
     if(!bloodStool.isSelected()){double kick = Double.parseDouble(bar.getText()); double pa = kick - 2; String kicker = String.format("%.2f", pa); bar.setText(kicker); }    });
                          Anemia.setOnAction(ex->{
     if(Anemia.isSelected()){ double kick = Double.parseDouble(bar.getText());double pa = kick + 2;String kicker = String.format("%.2f", pa);bar.setText(kicker);      }
     if(!Anemia.isSelected()){double kick = Double.parseDouble(bar.getText()); double pa = kick - 2; String kicker = String.format("%.2f", pa); bar.setText(kicker); }    });
                             Abdopain.setOnAction(ex->{
     if(Abdopain.isSelected()){ double kick = Double.parseDouble(bar.getText());double pa = kick + 2;String kicker = String.format("%.2f", pa);bar.setText(kicker);      }
     if(!Abdopain.isSelected()){double kick = Double.parseDouble(bar.getText()); double pa = kick - 2; String kicker = String.format("%.2f", pa); bar.setText(kicker); }    });
                                nausea.setOnAction(ex->{
     if(nausea.isSelected()){ double kick = Double.parseDouble(bar.getText());double pa = kick + 2;String kicker = String.format("%.2f", pa);bar.setText(kicker);      }
     if(!nausea.isSelected()){double kick = Double.parseDouble(bar.getText()); double pa = kick - 2; String kicker = String.format("%.2f", pa); bar.setText(kicker); }    });
        
    }     

    @FXML
    private void shaking(MouseEvent event) {
        infoTab.setText("");
    }

    @FXML
    private void shakin(MouseEvent event) {
        infoTab.setText("Feeling of being cold without an apparent\n"
                      + "cause");
    }

    @FXML
    private void fiverout(MouseEvent event) {
        infoTab.setText("");
    }

    @FXML
    private void feverin(MouseEvent event) {
        infoTab.setText("When temperature is above the normal range");
    }

    @FXML
    private void anemiaout(MouseEvent event) {
            infoTab.setText("");
    }

    @FXML
    private void anemiain(MouseEvent event) {
            infoTab.setText("It happens when a number of red blood\n"
                         + " cell in your body is too weak. \n"
                         + "Effect: Fatigue ,  Diziness , Shorten of Breath");
    }

    @FXML
    private void diariaout(MouseEvent event) {
            infoTab.setText("");
    }

    @FXML
    private void diariain(MouseEvent event) {
            infoTab.setText("A condition in which faeces are discharged\n"
                          + "from your bowel frequently and in liquid form");
    }

    @FXML
    private void painout(MouseEvent event) {
         infoTab.setText("");
    }

    @FXML
    private void painin(MouseEvent event) {
         infoTab.setText("This type of pain is felt without going into\n"
                 + "any form of stress");
    }

    @FXML
    private void bloodystoolout(MouseEvent event) {
         infoTab.setText("");
    }

    @FXML
    private void bloodystoolin(MouseEvent event) {
         infoTab.setText("When your stool are feaces is red or dark\nin color");
    }
    

    @FXML
    private void abdominalpainout(MouseEvent event) {
          infoTab.setText("");
    }

    @FXML
    private void abdominalpainin(MouseEvent event) {
          infoTab.setText("When feeling pain in your abdominal region");
    }

    @FXML
    private void nauseaout(MouseEvent event) {
          infoTab.setText("");
    }

    @FXML
    private void nauseain(MouseEvent event) {
          infoTab.setText("Stomach Discomfort");
    }

    @FXML
    private void fatigueout(MouseEvent event) {
         infoTab.setText("");
    }

    @FXML
    private void fatiguein(MouseEvent event) {
         infoTab.setText("Lack of Energy and Motivation\n(Physical and Metally)");
    }
  public void Random(){
          Random rd = new Random();
    id.setText("TUTU"+rd.nextInt(8899988+1));        
    } 
    @FXML
    private void diagnostics(ActionEvent event) {
         submitTest();
        if(fatigue.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b + fatigue.getText()+"\n");
        }
        if(diarrhea.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b+ diarrhea.getText()+"\n");
        }
        if(fever.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b + fever.getText()+"\n");
        }
        if(chill.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b+ chill.getText()+"\n");
            
        }if(Anemia.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b+ Anemia.getText()+"\n");
        }if( Abdopain.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b+ Abdopain.getText()+"\n");
        }if( nausea.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b + nausea.getText()+"\n");
        }
          if(weakFever.isSelected()){
              String b = symtomsField.getText(); 
            symtomsField.clear();
              symtomsField.setText(b+ weakFever.getText()+"\n");
            }
            if(MAchesFever.isSelected()){
                String b = symtomsField.getText(); 
            symtomsField.clear();
                symtomsField.setText(b + MAchesFever.getText()+"\n");
            }
        if(HeadFever.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b + HeadFever.getText()+"\n");
        }
        if(Mpain.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b + Mpain.getText()+"\n");
        }
        if( bloodStool.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b+ bloodStool.getText()+"\n");
        }
      if(appetite.isSelected()){
          String b = symtomsField.getText(); 
            symtomsField.clear();
          symtomsField.setText(b + appetite.getText()+"\n");
          
      }
      if(Lethargy.isSelected()){String b = symtomsField.getText(); 
            symtomsField.clear();
          
          symtomsField.setText(b+ Lethargy.getText()+"\n");
      }
      if(Headache.isSelected()){
          String b = symtomsField.getText(); 
            symtomsField.clear();
          symtomsField.setText(b+ Headache.getText()+"\n");
          
      }
      if( LOAfever.isSelected()){
          String b = symtomsField.getText(); 
            symtomsField.clear();
          symtomsField.setText(b + LOAfever.getText()+"\n");
      }
       if(VimitingFever.isSelected()){
           String b = symtomsField.getText(); 
            symtomsField.clear();
           symtomsField.setText(b + VimitingFever.getText()+"\n");
       }   
        if(SweatingFever.isSelected()){
            String b = symtomsField.getText(); 
            symtomsField.clear();
            symtomsField.setText(b + SweatingFever.getText()+"\n");
            
              }
    if(ur.isSelected()){
        int ad = Integer.parseInt(a.getText());
        if(ad > 50){
            String jaga = others.getText();
            others.clear();
        others.setText(jaga +"Urine Test Successful:DISEASE CONFIRMED\n");
        }else if(ad < 51){
            String jaga = others.getText();
            others.clear();
            others.setText(jaga + "Urine Test UnSuccessful:DISEASE UNCONFIRMED\n");
        }
        String b = anemiaStatus.getText();
        anemiaStatus.clear();
        anemiaStatus.setText(b+" ,"+ur.getText());
    }
    if(ty.isSelected()){
        if(c.isSelected()){
            String jaga = others.getText();
            others.clear();
         others.setText(jaga +"Typhidot Test Successful:DISEASE CONFIRMED\n"); 
         
        }else if(d.isSelected()){
            String jaga = others.getText();
            others.clear();
           others.setText(jaga +"Typhidot Test UnSuccessful:DISEASE UNCONFIRMED\n");   
        }  
        String b = anemiaStatus.getText();
        anemiaStatus.clear();
        anemiaStatus.setText(b+" ,"+ty.getText());
    }
    if(bl.isSelected()){ 
          if(e.isSelected()){
                int ad = Integer.parseInt(f.getText());
                if(ad > 50){
                String jaga = others.getText();
            others.clear();
         others.setText(jaga +"Blood Smear Test Successful:DISEASE CONFIRMED\n"); 
                }else if(g.isSelected()){
            String jaga = others.getText();
            others.clear();
           others.setText(jaga +"Blood Smear Test UnSuccessful:DISEASE UNCONFIRMED\n");   
        } 
          } 
        String b = anemiaStatus.getText();
        anemiaStatus.clear();
        anemiaStatus.setText(b+" ,"+bl.getText());
    }
    if(rd.isSelected()){
        if(h.isSelected()){
           String jaga = others.getText();
           others.clear();
           others.setText(jaga +"RDT Test Successful:DISEASE CONFIRMED\n");  
        }else if(i.isSelected()){
           String jaga = others.getText();
           others.clear();
           others.setText(jaga +"RDT Test UnSuccessful:DISEASE UNCONFIRMED\n");  
        }
       
        String b = anemiaStatus.getText();
        anemiaStatus.clear();
        anemiaStatus.setText(b+" ,"+rd.getText());
    }
    if(mo.isSelected()){
       if(j.isSelected()){
           String jaga = others.getText();
           others.clear();
           others.setText(jaga +"Molecular Test UnSuccessful:DISEASE UNCONFIRMED\n");  
       }else
          if(k.isSelected()){
             String jaga = others.getText();
           others.clear();
           others.setText(jaga +"Molecular Test Successful:DISEASE CONFIRMED\n"); 
       }else
             if(l.isSelected()){
             String jaga = others.getText();
           others.clear();
           others.setText(jaga +"Typhoid Test Successful:DISEASE CONFIRMED\n"); 
       }else{
                   String jaga = others.getText();
           others.clear();
           others.setText(jaga +"Typhoid Test UnSuccessful:DISEASE UNCONFIRMED\n"); 
             }
        String b = anemiaStatus.getText();
        anemiaStatus.clear();
        anemiaStatus.setText(b+" ,"+mo.getText());
    }
    if(an.isSelected()){
        if(m.isSelected()){  
           String jaga = others.getText();
           others.clear();
           others.setText(jaga +"AntiBody Test Successful:DISEASE CONFIRMED\n"); 
        }else if(n.isSelected()){ 
           String jaga = others.getText();
           others.clear();
           others.setText(jaga +"AntiBody Test UnSuccessful:DISEASE UNCONFIRMED\n");       
        }
        String b = anemiaStatus.getText();
        anemiaStatus.clear();
        anemiaStatus.setText(b+" ,"+an.getText());
    }
    if(mp.isSelected()){
        if(o.isSelected()){
            int jaga = Integer.parseInt(f1.getText());
            if(jaga > 100){
              String jaga1 = others.getText();
           others.clear();
           others.setText(jaga1 +"MP Test Successful:DISEASE CONFIRMED\n");   
            }else if(jaga < 101){
                String jaga1 = others.getText();
           others.clear();
           others.setText(jaga1 +"MP Test UnSuccessful:DISEASE UNCONFIRMED\n");    
            }
        }
        String b = anemiaStatus.getText();
        anemiaStatus.clear();
        anemiaStatus.setText(b+" ,"+mp.getText());
    }
    if(wi.isSelected()){
     int j = Integer.parseInt(f1.getText());
     int j1 = Integer.parseInt(f11.getText());
     int j11 = Integer.parseInt(b.getText());
     int j111 = Integer.parseInt(bo.getText());
     
     if(j > 50 && j1 > 50 && j11 > 50 && j111 > 50){
          String jaga1 = others.getText();
           others.clear();
           others.setText(jaga1 +"Widal Test Successful:DISEASE CONFIRMED\n"); 
     }else{
          String jaga1 = others.getText();
           others.clear();
           others.setText(jaga1 +"Widal Test UnSuccessful:DISEASE UNCONFIRMED\n"); 
     }
        String b = anemiaStatus.getText();
        anemiaStatus.clear();
        anemiaStatus.setText(b+" ,"+wi.getText()); 
    }
         String nan = "INSERT INTO PATIENT(ID ,  SURNAME ,  MIDDLENAME , SYMTOMS , DATE ,  PHONE , TEST) VALUES (?,?,?,?,?,?,?)";
              try{
                  pstmt = conn.prepareStatement(nan);
                  pstmt.setString(1, id.getText());
                  pstmt.setString(2 , surname.getText());
                  pstmt.setString(3,middle.getText());
                   pstmt.setString(4,symtomsField.getText());
                    Calendar  cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        date = (day +"th:" +(month+1)+ ":"+ year);
                  pstmt.setString(5 , date);
                  pstmt.setString(6,phone.getText());
                  pstmt.setString(7 , symtomsField1.getText());
                  pstmt.execute();
              }catch(Exception e){
                  JOptionPane.showMessageDialog(null , e);
              }
           
   if(fatigue.isSelected() && diarrhea.isSelected() && fever.isSelected() || Mpain.isSelected() && Abdopain.isSelected()){
       malariaStatus.setText("MALARIA");
       malariaType.setText("PLASMODIUM");
       int ran = (int) (Math.random()) * 3 + 1;
       if(ran == 1){
           malariaEffect.setText(" Doxy100 , Primaquine , Aralen , Lariam , Dorxy , Cleocin ,\n Vibramycin , Atovaquine , Monodox , Cardioquine ");
       }
       if(ran == 2){
           malariaEffect.setText("Coartem , Hydroxylchloroquine , Clindamycin ,Cleocin Pediatric ,\n Doryx MPC , Ocudox , Amala  , Amoxyl"); 
       }
       if(ran == 3){
            malariaEffect.setText(" Malarone , Plaquenil , Doxycycline , Mefloquine ,\n Chloroquine , Proguanil , Morgidox , Vibra Tabs");
       }
       
   }else if(bloodStool.isSelected() && diarrhea.isSelected() && Lethargy.isSelected() && appetite.isSelected() || Headache.isSelected() || Abdopain.isSelected()){
       malariaStatus.setText("TYPHOID");
       malariaType.setText("SALMODELLA TYPHI");
       int ran = (int) (Math.random()) * 3 + 1;
       if(ran == 1){
           malariaEffect.setText(" Doxy100 , Primaquine ,\n Aralen , Lariam ,\n Dorxy , Cleocin ,\n Vibramycin , Atovaquine ,\n Monodox , Cardioquine ");
       }
       if(ran == 2){
           malariaEffect.setText("Coartem , Hydroxylchloroquine ,\n Clindamycin ,Cleocin Pediatric ,\n Doryx MPC , Ocudox ,\n Amala  , Amoxyl"); 
       }
       if(ran == 3){
            malariaEffect.setText(" Malarone , Plaquenil ,\n Doxycycline , Mefloquine ,\n Chloroquine , Proguanil , \nMorgidox , Vibra Tabs");
       }
       
   } else{
       malariaStatus.setText("NILL");
       malariaType.setText("NILL");
       int ran = (int) (Math.random()) * 3 + 1;
       if(ran == 1){
           malariaEffect.setText(" NILL ");
       }
       if(ran == 2){
           malariaEffect.setText("NILL"); 
       }
       if(ran == 3){
            malariaEffect.setText(" ");
       }
       others.setText("NILL");
                   
   
      }    
           String sql = "INSERT INTO REPORT (ID  , SURNAME , MIDDLENAME ,  OTHER ,  GENDER, PHONE , PHONE2 , STATUS , "
                   + " TYPE ,  EFFECT ,  ANEMIA , OTHERS , SYMTOMS , DATE ,  TEST) VALUES (? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
              try{
                  pstmt = conn.prepareStatement(sql);
                  pstmt.setString(1 , id.getText());
                  pstmt.setString(2 , surname.getText());
                  pstmt.setString(3 , middle.getText());
                  pstmt.setString(4 , other2.getText());     
                  pstmt.setString(5 , gender);
                  pstmt.setString(6 , phone.getText());
                  pstmt.setString(7 , phone2.getText());
                   pstmt.setString(8 , malariaStatus.getText());
                   pstmt.setString(9 , malariaType.getText());
                   pstmt.setString(10 , malariaEffect.getText());
                   pstmt.setString(11 , anemiaStatus.getText());
                  pstmt.setString(12, others.getText());
                  pstmt.setString(13 , symtomsField.getText());
                    Calendar  cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        date = (day +"th:" +(month+1)+ ":"+ year);
                  pstmt.setString(14 , date);
                  pstmt.setString(15 , symtomsField1.getText());
                   pstmt.execute();
              }catch(Exception ej){
                  JOptionPane.showMessageDialog(null , ej);
              }
              
          Random();   
    }
    

    @FXML
    private void appeout(MouseEvent event) {
        infoTab.setText("");
    }

    @FXML
    private void appein(MouseEvent event) {
        infoTab.setText("The habit of feeling to tired\nto eat or not wanting to\neat");
    }

    @FXML
    private void lategyout(MouseEvent event) {
        infoTab.setText("");
    }

    @FXML
    private void lategyin(MouseEvent event) {
        infoTab.setText("Is a symptoms that cause\nyou to feel sleepy, fatigue\nand sluggish");
    }

    @FXML
    private void headout(MouseEvent event) {
    }

    @FXML
    private void headin(MouseEvent event) {
    }

   
    private void submitTest() {
      
          if(c.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + ty.getText()+"-"+ c.getText()+"\n");
        }
   if(d.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + ty.getText()+"-"+ d.getText()+"\n");
        }
  if(e.isSelected()){
          String baba =   symtomsField1.getText();
          String skiba = f.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + bl.getText()+"-"+ e.getText()+","+skiba+"%\n");
        }
   if(g.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + wi.getText()+"-"+ g.getText()+"\n");
        }
      if(h.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + rd.getText()+"-"+ h.getText()+"\n");
        }
   if(i.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + rd.getText()+"-"+ i.getText()+"\n");
        }
      if(j.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + mo.getText()+"-"+ j.getText()+"\n");
        }
    if(k.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + mo.getText()+"-"+ k.getText()+"\n");
        }
       if(l.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + mo.getText()+"-"+ l.getText()+"\n");
        }
    if(m.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + an.getText()+"-"+ m.getText()+"\n");
        }
     if(n.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + an.getText()+"-"+ n.getText()+"\n");
        }
     if(o.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + mp.getText()+"-"+ o.getText()+"\n");
        }
      if(p.isSelected()){
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + mp.getText()+"-"+ p.getText()+"\n");
        }
      //Urinalisis Action
       if(ur.isSelected()){
            int q = Integer.parseInt(a.getText());
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + ur.getText()+"-"+q+"\n");
        }
        if(wi.isSelected()){
            int q = Integer.parseInt(f1.getText());
            int t = Integer.parseInt(f11.getText());
            int g = Integer.parseInt(bo.getText());
            int q1 = Integer.parseInt(b.getText());
          String baba =   symtomsField1.getText();
            symtomsField1.clear();
            symtomsField1.setText(baba + wi.getText()+"Sensitivity:"+q+"\n"+"Specificity:"+t+"\n"+"PPV:"+g+"\n"
            +"NPV:"+q1+"\n");
        }
      
    }

    @FXML
    private void close(ActionEvent event) {
          testPane.setVisible(false);
    }


   /**
    private void logout() {
        try{
         Parent root;  
               Stage stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/malariaandtyphoid/Login.fxml"));
            
             JFXDecorator decorator=new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
       decorator.setBorder(Border.EMPTY);
       
        Scene scene = new Scene(decorator);
//stage = (Stage) lgbtn.getScene().getWindow();
              stage.setScene(scene);
              stage.centerOnScreen();
              stage.show(); 
               splashAnchorPane.getScene().getWindow().hide();
        }catch(Exception e){
            e.printStackTrace();
        }
    }**/
}

package Home;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Javaconnect {
    public static Connection ConnecrDB(){
        try{
           Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/fxdiag2","sa","");
            
            return conn;
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           return null;
       }
}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

/**
 *
 * @author RodrigoMini
 */
// comentt
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {
    
    static Connection conn = null;
    
    public static void Arrancar() {
      try{
         Class.forName("org.hsqldb.jdbcDriver");
         conn = DriverManager.getConnection("jdbc:hsqldb:file:recursos/data/Database", "sa", "");
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,"No se puede conectar a la base "
                    + "de datos \n"+e , "ERROR", JOptionPane.ERROR_MESSAGE);
      }
    } 
    
    public static Connection Conectar(){
       Arrancar();
      return conn;
   }
    
    public static void desconectar(){
        try {
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se puede conectar a la base "
                    + "de datos \n"+ex , "ERROR", JOptionPane.ERROR_MESSAGE);
        }
   }
}

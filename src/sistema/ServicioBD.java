/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

/**
 *
 * @author daniel
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ServicioBD {
    
    private static String user="postgres",db="sistemaContableDB",
            pass="postgres",ip="localhost";
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException {
	if ( connection == null ) 
	    connection = DriverManager.getConnection("jdbc:postgresql://"+ip+"/"
                    +db,user,pass);
	return connection;
    }    
    
    public static int getCorrelativo(char tipoCuenta){
        int n = 0;
        ResultSet rs;
        String sql="select count(*) from cuenta where \"tipoCuenta\" = ?";        
        try{
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, tipoCuenta +"" );
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            if ( rs.next() )
               n = rs.getInt(1);
            System.out.println("Cuenta "+n);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }        
        return n;
    } 
    public static boolean guardarCuenta(Cuenta cuenta){        
        try{
            PreparedStatement ps =
                getConnection().prepareStatement("insert into cuenta values (?, ?, ?)");
            ps.setString(1, cuenta.getID());
            ps.setString(2, cuenta.getTipo()+"");
            ps.setString(3,cuenta.getDescripcion());
            ps.executeUpdate();
            return  true;
        }catch(SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Error "+e);
            return false;
        }
            
        
    }
    public static void main(String [] args)throws Exception{
        getConnection();
    }
}

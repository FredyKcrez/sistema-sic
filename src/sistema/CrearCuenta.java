/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

/**
 *
 * @author daniel
 */
import java.util.Date;
import javax.swing.JOptionPane;

public class CrearCuenta {
    
    
   public boolean crearCuenta(String idCuenta,String descripcion,int tipo,
           String sMonto,  Date fecha){       
       Cuenta cuenta = new Cuenta(idCuenta, descripcion, tipo);
       float monto;
       if ( (monto = strMontoF(sMonto) ) >  0){
         SaldoInicial saldoInicial = new SaldoInicial(cuenta,monto,fecha);        
         //Almacenar en la BD       
         if( ServicioBD.guardarCuenta(cuenta) )
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Cuenta Creada y almacenada");
         return true;
       }
       return false;
   }
   /** Retorna el monto como un flotante y avisa en caso de error.
    */
   public float strMontoF(String sMonto){
       float monto  = -1;
       try{
           monto = Float.parseFloat(sMonto);
       }catch(Exception e){
       JOptionPane.showMessageDialog(null, "El monto debe ser numérico positivo",
               "Dato inválido", JOptionPane.ERROR_MESSAGE);
        }
       return monto;
   }
}

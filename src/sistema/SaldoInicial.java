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

public class SaldoInicial {
    
    private boolean cargado;
    private float monto;
    private Date fecha;    
    private String idCuenta;
    
    public SaldoInicial(Cuenta cuenta,float monto,Date fecha){
        idCuenta = cuenta.getID();
        this.monto = monto;
        if (cuenta.getTipo() == 'A')
            cargado = true;
        else 
            cargado = false;    
        this.fecha = fecha;
    }
    public float getMonto(){
        return monto;
    }
    
}

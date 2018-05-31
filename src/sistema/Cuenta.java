/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

/**
 *
 * @author daniel
 */
public class Cuenta {
     /* Tipo de CUENTA
     * ACTIVO (A)
     * PASIVO (P)
     * CAPITAL (K)   
     * VENTAS (V)
     * GASTOS (G)
     * Al momento de iniciar las cuentas se asignará el monto en:
     * ACTIVO en el debe.
     * PASIVO en el haber.
     */
    private String descripcion, id;
    private char tipoCuenta;
      
    public Cuenta(String id,String desc, int type){
        this.id = id;
        descripcion = desc;
        tipoCuenta = getTipoChar(type);
    }
    public static char getTipoChar(int tipo){
        char nuevo = '@';
       switch(tipo){
           case 0:nuevo ='A';break;
           case 1:nuevo ='P';break;
           case 2:nuevo ='K';break;
           case 3:nuevo ='V';break;
           case 4:nuevo ='G';break;                           
       }
        return nuevo;
    }
    public char getTipo() { return tipoCuenta; }
    public String getID() { return id; }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(char tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
}

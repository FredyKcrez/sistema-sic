/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author daniel
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        new FPrincipal().setVisible(true);
    }
}

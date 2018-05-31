/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.sql.Connection;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Rodrigo
 */
public class libroDiario {
    
    
    public static JInternalFrame cargarReporte()
    {
        JInternalFrame frame=null;
        try{
                Connection c = ConexionBD.Conectar();
                //Map<String, Object> parametros = new HashMap<>();
                //parametros.put("titulo", "Libro diario ");
                JasperReport reporte = (JasperReport) JRLoader.loadObject(System.getProperty("user.dir")+
                        "/recursos/reportes/libroDiario.jasper");
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, c);
                frame = new JInternalFrame("Libro diario");
                frame.getContentPane().add(new JRViewer(jasperPrint));
                frame.repaint();
                frame.setResizable(true);
                frame.setClosable(true);
                frame.setIconifiable(true);
                frame.setMaximizable(true);
        }catch(Exception as)
        {
            JOptionPane.showMessageDialog(null, as);
        }
        return frame;
    }
    
}

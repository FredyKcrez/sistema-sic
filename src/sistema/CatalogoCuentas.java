/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Rodrigo
 */
public class CatalogoCuentas extends javax.swing.JInternalFrame {

    /**
     * Creates new form CatalogoCuentas
     */
    public CatalogoCuentas() {
        initComponents();
        Actualizar();
    }
    
    public void Actualizar()
 {
        Connection con = ConexionBD.Conectar();
        String []spl;
        String  num_pa;
        Vector<DefaultMutableTreeNode> vector = new Vector();
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("** Cuentas");
        DefaultMutableTreeNode hijo;
        DefaultTreeModel modelo = new DefaultTreeModel(raiz);
        vector.add(raiz);
        try{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, nombre, idpadre FROM cuentas ORDER BY id");
        while( rs.next())
        {
            hijo = new DefaultMutableTreeNode(rs.getString("id")+" "+rs.getString("nombre"));
            num_pa = rs.getString("idpadre");
            for(DefaultMutableTreeNode nodo : vector)
            {
                spl = nodo.toString().split(" ");
                if(spl[0].equals(num_pa))
                {
                    modelo.insertNodeInto(hijo, nodo, nodo.getChildCount());
                    break;
                }
            }
            vector.add(hijo);
        }
        con.close();
        }catch(Exception e){System.out.println(e);}
        arbolCuentas.setModel(modelo);
        vector = null;
        arbolCuentas.repaint();
 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        arbolCuentas = new javax.swing.JTree();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Catálogo de cuentas");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setViewportView(arbolCuentas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 305;
        gridBagConstraints.ipady = 231;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 28, 21, 38);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolCuentas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

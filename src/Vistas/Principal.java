/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author Victor
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        admclientes = new javax.swing.JButton();
        admarticulos = new javax.swing.JButton();
        admfacturas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vibanken");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        admclientes.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        admclientes.setForeground(new java.awt.Color(255, 255, 255));
        admclientes.setText("Administrar Clientes");
        admclientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        admclientes.setBorderPainted(false);
        admclientes.setContentAreaFilled(false);
        admclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admclientesActionPerformed(evt);
            }
        });
        getContentPane().add(admclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 360, 40));

        admarticulos.setBackground(new java.awt.Color(0, 0, 204));
        admarticulos.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        admarticulos.setForeground(new java.awt.Color(255, 255, 255));
        admarticulos.setText("Administrar Articulos");
        admarticulos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        admarticulos.setBorderPainted(false);
        admarticulos.setContentAreaFilled(false);
        getContentPane().add(admarticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, -1, 40));

        admfacturas.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        admfacturas.setForeground(new java.awt.Color(255, 255, 255));
        admfacturas.setText("Administrar Facturas");
        admfacturas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        admfacturas.setBorderPainted(false);
        admfacturas.setContentAreaFilled(false);
        getContentPane().add(admfacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, 37));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondobuenobueno.jpg"))); // NOI18N
        jLabel2.setText("Vibanken");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 830, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admclientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admclientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton admarticulos;
    public javax.swing.JButton admclientes;
    public javax.swing.JButton admfacturas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

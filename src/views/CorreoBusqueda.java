/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Rafal
 */
public class CorreoBusqueda extends javax.swing.JDialog {

    /**
     * Creates new form Becas
     */
    public CorreoBusqueda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarAyudas();
    }

    public void cargarAyudas() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        try {
            System.out.println("Cargando driver");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Error con el driver");
        }

        try {
            System.out.println("Estableciendo conexion con el String");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/horas", "root", "");
            System.out.println("Conectado a la bd");

        } catch (SQLException ex) {
            System.out.println("Error con la cadena String de conexión");

        }
        String sql = "SELECT\n"
                + "`correos`.`idCorreo`,\n"
                + "`estudiantes`.`nombre`,\n"
                + "`estudiantes`.`cedula`,\n"
                + "`correos`.`numAyuda`,\n"
                + "`correos`.`correo`,\n"
                + "`correos`.`estado`,\n"
                + "`correos`.`fecha`\n"
                + "from `estudiantes`\n"
                + "INNER JOIN `ayudas`\n"
                + "on\n"
                + "`estudiantes`.`cedula`=`ayudas`.`idEstudiante`\n"
                + "INNER JOIN `correos`\n"
                + "on `ayudas`.`idAyuda`=`correos`.`numAyuda`";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTableCorreo.setModel(DbUtils.resultSetToTableModel(rs));
            System.out.println("inicial");
            conn.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Eror en la consulta");
        }
    }
    void BuscarCedula() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        try {
            System.out.println("Cargando driver");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Error con el driver");
        }

        try {
            System.out.println("Estableciendo conexion con el String");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/horas", "root", "");
            System.out.println("Conectado a la bd");

        } catch (SQLException ex) {
            System.out.println("Error con la cadena String de conexión");

        }
        String sql = "SELECT\n"
                + "`correos`.`idCorreo`,\n"
                + "`estudiantes`.`nombre`,\n"
                + "`estudiantes`.`cedula`,\n"
                + "`correos`.`numAyuda`,\n"
                + "`correos`.`correo`,\n"
                + "`correos`.`estado`,\n"
                + "`correos`.`fecha`\n"
                + "from `estudiantes`\n"
                + "INNER JOIN `ayudas`\n"
                + "on\n"
                + "`estudiantes`.`cedula`=`ayudas`.`idEstudiante`\n"
                + "INNER JOIN `correos`\n"
                + "on `ayudas`.`idAyuda`=`correos`.`numAyuda` where `estudiantes`.`cedula` like ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtCedula.getText()+"%");
            rs = pst.executeQuery();
            jTableCorreo.setModel(DbUtils.resultSetToTableModel(rs));
            System.out.println("like");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel50 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCorreo = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setText("Buscar Correo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Correo"));

        jLabel1.setText("Nombre");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel2.setText("Cédula");

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTableCorreo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTableCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCorreoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCorreo);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel50)
                .addGap(355, 355, 355))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void jTableCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCorreoMouseClicked
        int row = jTableCorreo.rowAtPoint(evt.getPoint());

        String idCorreo = (jTableCorreo.getValueAt(row, 0).toString());
        Correos.txtIdCorreo.setText(idCorreo);
        
        String numAyuda =(jTableCorreo.getValueAt(row, 3).toString());
        Correos.txtNumAyuda.setText(numAyuda);
        
        String correo =(jTableCorreo.getValueAt(row, 4).toString());
        Correos.txtCorreo.setText(correo);

        String estado = (jTableCorreo.getValueAt(row, 5).toString());
        Correos.txtEstado.setSelectedItem(estado);

        String fecha = (jTableCorreo.getValueAt(row, 6).toString());
        Correos.txtFecha.setText(fecha);
       
        this.setVisible(false);
    }//GEN-LAST:event_jTableCorreoMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        boolean space = evt.getKeyCode() == KeyEvent.VK_BACK_SPACE;
        boolean backSpace = evt.getKeyCode() == KeyEvent.VK_SPACE;
        if (Character.isDigit(c) || space || backSpace) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo letras aceptadas!");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char c = evt.getKeyChar();
        boolean space = evt.getKeyCode() == KeyEvent.VK_BACK_SPACE;
        boolean backSpace = evt.getKeyCode() == KeyEvent.VK_SPACE;
        if (Character.isLetter(c) || space || backSpace) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo numeros aceptados!");
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
       
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
       BuscarCedula();
    }//GEN-LAST:event_txtCedulaKeyReleased

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
            java.util.logging.Logger.getLogger(CorreoBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CorreoBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CorreoBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CorreoBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CorreoBusqueda dialog = new CorreoBusqueda(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCorreo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
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
public class AyudasBusqueda extends javax.swing.JDialog {

    /**
     * Creates new form Becas
     */
    public AyudasBusqueda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarAyudas();
    }

    void buscarNombre() {
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
        String sql = "select\n"
                + "`ayudas`.`idAyuda` AS ID,\n"
                + "`ayudas`.`idEstudiante` AS Cédula,\n"
                + "`estudiantes`.`nombre` AS Nombre,\n"
                + "`ayudas`.`estado` AS Estado,\n"
                + "`ayudas`.`fecha` AS Fecha\n"
                + "from `ayudas`\n"
                + "INNER JOIN\n"
                + "`estudiantes`\n"
                + "on\n"
                + "`ayudas`.`idEstudiante`=`estudiantes`.`cedula`\n"
                + "where `estudiantes`.`nombre` like ?\n"
                + "ORDER BY `ayudas`.`estado`";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtNombre.getText() + "%");
            rs = pst.executeQuery();
            jTableAyudas.setModel(DbUtils.resultSetToTableModel(rs));
            System.out.println("like");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void buscarCedula() {
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
        String sql = "select\n"
                + "`ayudas`.`idAyuda` AS ID,\n"
                + "`ayudas`.`idEstudiante` AS Cédula,\n"
                + "`estudiantes`.`nombre` AS Nombre,\n"
                + "`ayudas`.`estado` AS Estado,\n"
                + "`ayudas`.`fecha` AS Fecha\n"
                + "from `ayudas`\n"
                + "INNER JOIN\n"
                + "`estudiantes`\n"
                + "on\n"
                + "`ayudas`.`idEstudiante`=`estudiantes`.`cedula`\n"
                + "where `ayudas`.`idEstudiante` like ?\n"
                + "ORDER BY `ayudas`.`estado`";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtCedula.getText() + "%");
            rs = pst.executeQuery();
            jTableAyudas.setModel(DbUtils.resultSetToTableModel(rs));
            System.out.println("like");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
        String sql = "select \n"
                + "`ayudas`.`idAyuda` AS ID,\n"
                + "`ayudas`.`idEstudiante` AS Cédula,\n"
                + "`estudiantes`.`nombre` AS Nombre,\n"
                + "`ayudas`.`estado` AS Estado,\n"
                + "`ayudas`.`fecha` AS Fecha\n"
                + "from `ayudas`\n"
                + "INNER JOIN\n"
                + "`estudiantes`\n"
                + "on\n"
                + "`ayudas`.`idEstudiante`=`estudiantes`.`cedula`\n"
                + "ORDER BY `ayudas`.`estado`";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTableAyudas.setModel(DbUtils.resultSetToTableModel(rs));
            System.out.println("inicial");
            conn.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Eror en la consulta");
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
        jTableAyudas = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setText("Buscar Ayuda");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Ayuda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cédula");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        txtCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTableAyudas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableAyudas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTableAyudas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAyudasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAyudas);
        if (jTableAyudas.getColumnModel().getColumnCount() > 0) {
            jTableAyudas.getColumnModel().getColumn(3).setHeaderValue("Title 4");
            jTableAyudas.getColumnModel().getColumn(4).setHeaderValue("Title 5");
        }

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(244, 244, 244)
                            .addComponent(jLabel50))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

    private void jTableAyudasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAyudasMouseClicked
        int row = jTableAyudas.rowAtPoint(evt.getPoint());

        String idAyuda = (jTableAyudas.getValueAt(row, 0).toString());
        Ayudas.txtIdAyuda.setText(idAyuda);
        
        String idEstudiante = (jTableAyudas.getValueAt(row, 1).toString());
        Ayudas.txtIdEstudiante.setText(idEstudiante);

        String estado = (jTableAyudas.getValueAt(row, 2).toString());
        Ayudas.txtEstado.setSelectedItem(estado);

        String fecha = (jTableAyudas.getValueAt(row, 4).toString());
        Ayudas.txtFecha.setText(fecha);
       
        this.setVisible(false);
    }//GEN-LAST:event_jTableAyudasMouseClicked

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
        /*char c = evt.getKeyChar();
        boolean space = evt.getKeyCode() == KeyEvent.VK_BACK_SPACE;
        boolean backSpace = evt.getKeyCode() == KeyEvent.VK_SPACE;
        if (Character.isLetter(c) || space || backSpace) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo numeros aceptados!");
        }*/
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        buscarNombre();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        buscarCedula();
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
            java.util.logging.Logger.getLogger(AyudasBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AyudasBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AyudasBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AyudasBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                AyudasBusqueda dialog = new AyudasBusqueda(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable jTableAyudas;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

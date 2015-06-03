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
public class ConsultasBusqueda extends javax.swing.JDialog {

    /**
     * Creates new form Becas
     */
    public ConsultasBusqueda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarEstudiantes();
    }

    public void cargarEstudiantes() {
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
        String sql = "SELECT \n"
                + "  estudiantes.cedula AS `Cédula`,\n"
                + "  estudiantes.nombre AS Nombre,\n"
                + "  estudiantes.telefono AS `Teléfono`,\n"
                + "  ayudas.estado AS `Estado Ayúda`,\n"
                + "  ayudas.fecha AS `Fecha Modificación Ayúda`\n"
                + "FROM estudiantes\n"
                + "INNER JOIN ayudas\n"
                + "ON \n"
                + "estudiantes.cedula = ayudas.idEstudiante\n"
                + "ORDER BY `ayudas`.`fecha` ";
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

   private void BuscarCedula() {
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
       String sql = "SELECT \n"
               + "  estudiantes.cedula AS `Cédula`,\n"
               + "  estudiantes.nombre AS Nombre,\n"
               + "  estudiantes.telefono AS `Teléfono`,\n"
               + "  ayudas.estado AS `Estado Ayúda`,\n"
               + "  ayudas.fecha AS `Fecha Modificación Ayúda`\n"
               + "FROM estudiantes\n"
               + "INNER JOIN ayudas\n"
               + "ON \n"
               + "estudiantes.cedula = ayudas.idEstudiante  where `estudiantes`.`cedula` like ?\n"
               + "ORDER BY `ayudas`.`fecha`";
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

    private void BuscarNombre() {
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
        String sql = "SELECT \n"
                + "  estudiantes.cedula AS `Cédula`,\n"
                + "  estudiantes.nombre AS Nombre,\n"
                + "  estudiantes.telefono AS `Teléfono`,\n"
                + "  ayudas.estado AS `Estado Ayúda`,\n"
                + "  ayudas.fecha AS `Fecha Modificación Ayúda`\n"
                + "FROM estudiantes\n"
                + "INNER JOIN ayudas\n"
                + "ON \n"
                + "estudiantes.cedula = ayudas.idEstudiante  where `estudiantes`.`nombre` like ?\n"
                + "ORDER BY `ayudas`.`fecha`";
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
        txtCedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAyudas = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setText("Buscar Información Sobre Ayudas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Estudiante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cédula");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addGap(546, 546, 546)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel50)
                .addGap(202, 202, 202))
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

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jTableAyudasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAyudasMouseClicked
        int row = jTableAyudas.rowAtPoint(evt.getPoint());
   
        String cedula = (jTableAyudas.getValueAt(row, 0).toString());
        Consultas.txtCedula.setText(cedula);

        String nombre = (jTableAyudas.getValueAt(row, 1).toString());
        Consultas.txtNombre.setText(nombre);

        String telefono = (jTableAyudas.getValueAt(row, 2).toString());
        Consultas.txtTelefono.setText(telefono);

        String estadoAyuda = (jTableAyudas.getValueAt(row, 3).toString());
        Consultas.txtEstadoAyuda.setText(estadoAyuda);

        String fechaAyuda = (jTableAyudas.getValueAt(row, 4).toString());
        Consultas.txtFechaAyuda.setText(fechaAyuda);
        
        this.setVisible(false);
    }//GEN-LAST:event_jTableAyudasMouseClicked

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

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        BuscarCedula();
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
       BuscarNombre();
    }//GEN-LAST:event_txtNombreKeyReleased

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
            java.util.logging.Logger.getLogger(ConsultasBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultasBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultasBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultasBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                ConsultasBusqueda dialog = new ConsultasBusqueda(new javax.swing.JFrame(), true);
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

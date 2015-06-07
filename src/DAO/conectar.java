package DAO;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List.*;
import javax.swing.JOptionPane;
import views.Estudiantes;
import objetos.Estudiante;

/**
 *
 * @author Rafal
 */
public class conectar {

    public boolean realizado = false;

    static {
        try {
            System.out.println("Cargando driver");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.print("eror del Driver");
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/horas", "root", "");
        System.out.println("Conectado a la bd");
        return conexion;
    }

    public void insertarEstudiante(String cedula, String nombre, String telefono, String correo, String fecha) throws SQLException {
        Connection conexion = getConnection();
        String sql = "insert into estudiantes values (?, ?, ?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, cedula);
        statement.setString(2, nombre);
        statement.setString(3, telefono);
        statement.setString(4, correo);
        statement.setString(5, fecha);
        int actualizados = statement.executeUpdate();
        System.out.println("Registros actualizados: " + actualizados);
        if (actualizados >= 1) {
            realizado = true;
        } else {
            realizado = false;
        }
        if (realizado) {
            JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al insertar");
        }
        conexion.close();
    }

    public void actualizarEstudiante(String cedula, String nombre, String telefono, String correo, String fecha) throws SQLException {
        Connection conexion = getConnection();
        String sql = "update estudiantes set nombre=?, telefono=?, correo=?, fecha=? where cedula=?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, nombre);
        statement.setString(2, telefono);
        statement.setString(3, correo);
        statement.setString(4, fecha);
        statement.setString(5, cedula);
        int actualizados = statement.executeUpdate();
        System.out.println("Registros actualizados: " + actualizados);
        if (actualizados >= 1) {
            realizado = true;
            System.out.println("Exitoso");
        } else {
            realizado = false;

            System.out.println("Error");
        }
        if (realizado) {
            JOptionPane.showMessageDialog(null, "estudiante modificado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error de modificacion");
        }
        conexion.close();
    }

    public void eliminarEstudiante(String cedula) throws SQLException {
        Connection conexion = getConnection();
        String sql = "delete from estudiantes where cedula=?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, cedula);
        int actualizados = statement.executeUpdate();
        if (actualizados > 0) {
            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente: " + actualizados);
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos");
        }
        conexion.close();
    }

    public void insertarAyuda(String codAyuda, String idEstudiante, String estado, String fecha) throws SQLException {
       // int idAyuda=7; // = Integer.parseInt(codigoAyuda);
        Connection conexion = getConnection();
        String sql = "insert into ayudas values (?, ?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(sql);
        int idAyuda =Integer.parseInt(codAyuda);
        statement.setInt(1, idAyuda);
        statement.setString(2, idEstudiante);
        statement.setString(3, estado);
        statement.setString(4, fecha);
        int actualizados = statement.executeUpdate();
        System.out.println("Registros actualizados: " + actualizados);
        if (actualizados >= 1) {
            realizado = true;
        } else {
            realizado = false;
        }
        if (realizado) {
           // JOptionPane.showMessageDialog(null, "Ayuda agregada exitosamente");
            System.out.println("Ayuda agregada exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al insertar Ayuda");
        }
        conexion.close();
    }

    public void actualizarAyuda(String idAyuda, String idEstudiante, String estado, String fecha) throws SQLException {
        Connection conexion = getConnection();
        String sql = "update ayudas set idEstudiante=?, estado=?, fecha=? where idAyuda=?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, idEstudiante);
        statement.setString(2, estado);
        statement.setString(3, fecha);
        int numero = Integer.parseInt(idAyuda);
        statement.setInt(4, numero);
        int actualizados = statement.executeUpdate();
        System.out.println("Registros actualizados: " + actualizados);
        if (actualizados >= 1) {
            realizado = true;
            System.out.println("Exitoso");
        } else {
            realizado = false;

            System.out.println("Error");
        }
        if (realizado) {
            //JOptionPane.showMessageDialog(null, "Ayuda modificada exitosamente");
           System.out.println("Ayuda modificada exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error de modificacion");
        }
        conexion.close();
    }

    public void eliminarAyuda(String idAyuda) throws SQLException {
        Connection conexion = getConnection();
        String sql = "delete from ayudas where idAyuda=?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        int numero = Integer.parseInt(idAyuda);
        statement.setInt(1, numero);
        int actualizados = statement.executeUpdate();
        if (actualizados > 0) {
            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente: " + actualizados);
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos");
        }
        conexion.close();
    }
    
    public void insertarCorreo(String codCorreo, String codAyuda, String correo, String estado, String fecha) throws SQLException {
        // int idAyuda=7; // = Integer.parseInt(codigoAyuda);
        Connection conexion = getConnection();
        String sql = "insert into correos values (?, ?, ?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(sql);
        int idCorreo = Integer.parseInt(codCorreo);
        statement.setInt(1, idCorreo);
        int numAyuda = Integer.parseInt(codAyuda);
        statement.setInt(2, numAyuda);
        statement.setString(3, correo);
        statement.setString(4, estado);
        statement.setString(5, fecha);
        int actualizados = statement.executeUpdate();
        System.out.println("Registros actualizados: " + actualizados);
        if (actualizados >= 1) {
            realizado = true;
        } else {
            realizado = false;
        }
        if (realizado) {
            JOptionPane.showMessageDialog(null, "Ayuda agregada exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al insertar");
        }
        conexion.close();
    }

    public void actualizarCorreo(String idCorreo, String numAyuda, String correo, String estado, String fecha) throws SQLException {
        Connection conexion = getConnection();
        String sql = "update correos set numAyuda=?, correo=?, estado=?, fecha=? where idCorreo=?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        int codAyuda = Integer.parseInt(numAyuda);
        statement.setInt(1, codAyuda);
        statement.setString(2, correo);
        statement.setString(3, estado);
        statement.setString(4, fecha);
        int numero = Integer.parseInt(idCorreo);
        statement.setInt(5, numero);
        int actualizados = statement.executeUpdate();
        System.out.println("Registros actualizados: " + actualizados);
        if (actualizados >= 1) {
            realizado = true;
            System.out.println("Exitoso");
        } else {
            realizado = false;

            System.out.println("Error");
        }
        if (realizado) {
            JOptionPane.showMessageDialog(null, "Ayuda modificada exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error de modificacion");
        }
        conexion.close();
    }

    public void eliminarCorreo(String idCorreo) throws SQLException {
        Connection conexion = getConnection();
        String sql = "delete from correos where idCorreo=?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        int numero = Integer.parseInt(idCorreo);
        statement.setInt(1, numero);
        int actualizados = statement.executeUpdate();
        if (actualizados > 0) {
            //JOptionPane.showMessageDialog(null, "Datos eliminados correctamente: " + actualizados);
            System.out.println("Correo Eliminado Correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos");
        }
        conexion.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Estudiante;
import DAO.conectar;

/**
 *
 * @author Rafal
 */
public class estudianteServicio {

    private conectar conexion = new conectar();

    public Estudiante insertar(String cedula, String nombre, String telefono, String correo, String fecha) {
        Estudiante student = null;
        try {
            conexion.insertarEstudiante(cedula, nombre, telefono, correo, fecha);
        } catch (Exception e) {
            Logger.getLogger(estudianteServicio.class.getName()).log(Level.SEVERE, null, e);
        }
        return student;
    }

    public Estudiante actualizar(String cedula, String nombre, String telefono, String correo, String fecha) {
        Estudiante student = null;
        try {
            conexion.actualizarEstudiante(cedula, nombre, telefono, correo, fecha);
        } catch (Exception e) {
            Logger.getLogger(estudianteServicio.class.getName()).log(Level.SEVERE, null, e);
        }
        return student;
    }

    public Estudiante elimiar(String cedula) {
        Estudiante student = null;
        try {
            conexion.eliminarEstudiante(cedula);
        } catch (Exception e) {
            Logger.getLogger(estudianteServicio.class.getName()).log(Level.SEVERE, null, e);
        }
        return student;
    }
}

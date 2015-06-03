/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.conectar;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Ayuda;

/**
 *
 * @author Rafal
 */
public class ayudaServicio {

    private conectar conexion = new conectar();

    public Ayuda insertar(String idAyuda, String idEstudiante, String estado, String fecha) {
        Ayuda help = null;
        try {
            conexion.insertarAyuda(idAyuda, idEstudiante, estado, fecha);
        } catch (Exception e) {
            Logger.getLogger(ayudaServicio.class.getName()).log(Level.SEVERE, null, e);
        }
        return help;
    }

    public Ayuda actualizar(String idAyuda, String idEstudiante, String estado, String fecha) {
        Ayuda help = null;
        try {
            conexion.actualizarAyuda(idAyuda, idEstudiante, estado, fecha);
        } catch (Exception e) {
            Logger.getLogger(ayudaServicio.class.getName()).log(Level.SEVERE, null, e);
        }
        return help;
    }

    public Ayuda eliminar(String idAyuda) {
        Ayuda help = null;
        try {
            conexion.eliminarAyuda(idAyuda);
        } catch (Exception e) {
            Logger.getLogger(ayudaServicio.class.getName()).log(Level.SEVERE, null, e);
        }
        return help;
    }
}

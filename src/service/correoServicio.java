/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.conectar;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Correo;

/**
 *
 * @author Rafal
 */
public class correoServicio {

    private conectar conexion = new conectar();

    public Correo insertar(String idCorreo, String numAyuda, String correo, String estado, String fecha) {
        Correo mail = null;
        try {
            conexion.insertarCorreo(idCorreo, numAyuda, correo, estado, fecha);
        } catch (Exception e) {
            Logger.getLogger(correoServicio.class.getName()).log(Level.SEVERE, null, e);
        }
        return mail;
    }

    public Correo modificar(String idCorreo, String numAyuda, String correo, String estado, String fecha) {
        Correo mail = null;
        try {
            conexion.actualizarCorreo(idCorreo, numAyuda, correo, estado, fecha);
        } catch (Exception e) {
            Logger.getLogger(correoServicio.class.getName()).log(Level.SEVERE, null, e);
        }
        return mail;
    }

    public Correo eliminar(String idCorreo) {
        Correo mail = null;
        try {
            conexion.eliminarCorreo(idCorreo);
        } catch (Exception e) {
            Logger.getLogger(correoServicio.class.getName()).log(Level.SEVERE, null, e);
        }
        return mail;
    }
}

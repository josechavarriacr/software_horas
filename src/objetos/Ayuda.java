/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Rafal
 */
public class Ayuda {

    private String idAyuda;
    private String idEstudiante;
    private String estado;
    private String fecha;

    public String getIdAyuda() {
        return idAyuda;
    }

    public void setIdAyuda(String idAyuda) {
        this.idAyuda = idAyuda;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.bean;

/**
 *
 * @author Jose.suspes
 */
public class FuenteInformacion {
    
    private long idFuenteInformacion;
    private String codigoFuenteInformacion;
    private String nombreFuenteInformacion;

    public String getCodigoFuenteInformacion() {
        return codigoFuenteInformacion;
    }

    public void setCodigoFuenteInformacion(String codigoFuenteInformacion) {
        this.codigoFuenteInformacion = codigoFuenteInformacion;
    }

    public String getNombreFuenteInformacion() {
        return nombreFuenteInformacion;
    }

    public void setNombreFuenteInformacion(String nombreFuenteInformacion) {
        this.nombreFuenteInformacion = nombreFuenteInformacion;
    }

    public long getIdFuenteInformacion() {
        return idFuenteInformacion;
    }

    public void setIdFuenteInformacion(long idFuenteInformacion) {
        this.idFuenteInformacion = idFuenteInformacion;
    }
}

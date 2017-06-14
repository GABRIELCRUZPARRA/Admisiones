/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.bean;

/**
 *
 * @author jose.suspes
 */
public class TipoIdentificacion {
    
   private String codigoTipoIdentificacion;
   private String nombreTipoIdentificacion;

    public String getCodigoTipoIdentificacion() {
        return codigoTipoIdentificacion;
    }

    public void setCodigoTipoIdentificacion(String codigoTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
    }

    public String getNombreTipoIdentificacion() {
        return nombreTipoIdentificacion;
    }

    public void setNombreTipoIdentificacion(String nombreTipoIdentificacion) {
        this.nombreTipoIdentificacion = nombreTipoIdentificacion;
    }

    @Override
    public String toString() {
        return "TipoIdentificacion{" + "codigoTipoIdentificacion=" + codigoTipoIdentificacion + ", nombreTipoIdentificacion=" + nombreTipoIdentificacion + '}';
    }
    
}

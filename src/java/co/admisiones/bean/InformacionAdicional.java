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
public class InformacionAdicional {

    private FuenteFinanciacion fuenteFinanciacion;
    private FuenteInformacion fuenteInformacion;
    private String otraFuente;

    
    
    public InformacionAdicional() {

        this.fuenteFinanciacion = new FuenteFinanciacion();
        this.fuenteInformacion = new FuenteInformacion();
    }

    public String getOtraFuente() {
        return otraFuente;
    }

    public void setOtraFuente(String otraFuente) {
        this.otraFuente = otraFuente;
    }

    public FuenteFinanciacion getFuenteFinanciacion() {
        return fuenteFinanciacion;
    }

    public void setFuenteFinanciacion(FuenteFinanciacion fuenteFinanciacion) {
        this.fuenteFinanciacion = fuenteFinanciacion;
    }

    public FuenteInformacion getFuenteInformacion() {
        return fuenteInformacion;
    }

    public void setFuenteInformacion(FuenteInformacion fuenteInformacion) {
        this.fuenteInformacion = fuenteInformacion;
    }

}

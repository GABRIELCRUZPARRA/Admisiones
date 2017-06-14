/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.bean;

import java.util.Date;

/**
 *
 * @author Jose.suspes
 */
public class ExamenEstado {
    
    private String snp;
    private TipoIdentificacion tipoIdentificacionPresntacion;
    private String numeroIdentificacion;
    private Date fechaPresentacion;
    private long idExamen;

    public ExamenEstado() {
        this.tipoIdentificacionPresntacion = new TipoIdentificacion();
    }
    
    
    
    

    public String getSnp() {
        return snp;
    }

    public void setSnp(String snp) {
        this.snp = snp;
    }

    public TipoIdentificacion getTipoIdentificacionPresntacion() {
        return tipoIdentificacionPresntacion;
    }

    public void setTipoIdentificacionPresntacion(TipoIdentificacion tipoIdentificacionPresntacion) {
        this.tipoIdentificacionPresntacion = tipoIdentificacionPresntacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Date getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(Date fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(long idExamen) {
        this.idExamen = idExamen;
    }
    
}

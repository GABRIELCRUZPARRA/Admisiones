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
public class Formulario {
    
    private String periodo;
    private Aspirante aspirante;
    private Programa programa;
    private Jornada jornada;
    private TipoSolicitud tipoSolictud;

    
    public Formulario() {
        this.periodo = new String();
        this.aspirante = new Aspirante();
        this.programa = new Programa();
        this.jornada = new Jornada() ;
        this.tipoSolictud = new TipoSolicitud();
    }
    
    
    

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public TipoSolicitud getTipoSolictud() {
        return tipoSolictud;
    }

    public void setTipoSolictud(TipoSolicitud tipoSolictud) {
        this.tipoSolictud = tipoSolictud;
    }
    
    
    
    
    
    
    
    
    
}

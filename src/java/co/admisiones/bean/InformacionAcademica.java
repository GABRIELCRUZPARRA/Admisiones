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
public class InformacionAcademica {
    
    private String graduadoColombia;
    private Colegio colegio;
    private TipoBachiller tipoBachiller;
    private TipoColegio tipoColegio;
    private Calendario calendario;
    private Ciudad ciudadColegio;
    private String anyoGraduacion;

    public InformacionAcademica() {
        this.colegio=new Colegio();
        this.tipoBachiller=new TipoBachiller();
        this.tipoColegio=new TipoColegio();
        this.calendario=new Calendario();
        this.ciudadColegio= new Ciudad();
    }

    public String getGraduadoColombia() {
        return graduadoColombia;
    }

    public void setGraduadoColombia(String graduadoColombia) {
        this.graduadoColombia = graduadoColombia;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public TipoBachiller getTipoBachiller() {
        return tipoBachiller;
    }

    public void setTipoBachiller(TipoBachiller tipoBachiller) {
        this.tipoBachiller = tipoBachiller;
    }

   public TipoColegio getTipoColegio() {
        return tipoColegio;
    }

    public void setTipoColegio(TipoColegio tipoColegio) {
        this.tipoColegio = tipoColegio;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public Ciudad getCiudadColegio() {
        return ciudadColegio;
    }

    public void setCiudadColegio(Ciudad ciudadColegio) {
        this.ciudadColegio = ciudadColegio;
    }

    public String getAnyoGraduacion() {
        return anyoGraduacion;
    }

    public void setAnyoGraduacion(String anyoGraduacion) {
        this.anyoGraduacion = anyoGraduacion;
    }
}

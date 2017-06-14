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
public class Colegio {
    private String idColegio;
    private String nombreColegio;
    private String calendario;

    public Colegio(String idColegio, String nombreColegio, String calendario) {
        this.idColegio = idColegio;
        this.nombreColegio = nombreColegio;
        this.calendario = calendario;
    }

    public Colegio() {
    }
    
    public String getIdColegio() {
        return idColegio;
    }

    public void setIdcolegio(String idColegio) {
        this.idColegio = idColegio;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public String getCalendario() {
        return calendario;
    }

    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }
}

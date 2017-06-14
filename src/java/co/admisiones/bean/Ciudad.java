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
public class Ciudad {
  private String idCiudad;
  private String cdPais;
  private String cdDpto;
  private String cdPoblacion;
  private String cdCiudad;
  private String nombreCiudad;

    public Ciudad(String idCiudad, String cdPais, String cdDpto, String cdPoblacion, String cdCiudad, String nombreCiudad) {
        this.idCiudad = idCiudad;
        this.cdPais = cdPais;
        this.cdDpto = cdDpto;
        this.cdPoblacion = cdPoblacion;
        this.cdCiudad = cdCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public Ciudad() {
    }

  
  
    public String getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCdPais() {
        return cdPais;
    }

    public void setCdPais(String cdPais) {
        this.cdPais = cdPais;
    }

    public String getCdDpto() {
        return cdDpto;
    }

    public void setCdDpto(String cdDpto) {
        this.cdDpto = cdDpto;
    }

    public String getCdPoblacion() {
        return cdPoblacion;
    }

    public void setCdPoblacion(String cdPoblacion) {
        this.cdPoblacion = cdPoblacion;
    }

    public String getCdCiudad() {
        return cdCiudad;
    }

    public void setCdCiudad(String cdCiudad) {
        this.cdCiudad = cdCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
  
}

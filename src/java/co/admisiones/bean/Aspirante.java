/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jose.suspes
 */
public class Aspirante {
    
    private long idEstudiante;
    private TipoIdentificacion tipoIdentificacion;
    private String identificacion;
    private Date fechaNacimiento;
    private Ciudad ciudadExpedicionDocumento;
    private Date fechaExpedicionDocumento;
    private Ciudad ciudadNacimiento;
    private String nombres;
    private String apellidos;
    private String genero;
    private EstadoCivil estadoCivil;
    private String nacionalidad;
    private CondicionEspecial condicionEspecial;
    private String otraCondicionEspecial;
    private GrupoEtnico grupoEtnico;
    private String otroGrupoEtnico;
    private InformacionContacto informacionContacto;
    private InformacionAcademica informacionAcademica;
    private ExamenEstado examenEstado;
    private InformacionAcudiente informacionAcudiente;
    private InformacionAdicional informacionAdicional;
    private String pyz;
    private String estado;
    private String nroCarn;
    private List<Documentos> documentos;
    
    
    
    
    

    public Aspirante() {
        this.tipoIdentificacion= new TipoIdentificacion();
        this.ciudadNacimiento=new Ciudad();
        this.ciudadExpedicionDocumento=new Ciudad();
        this.estadoCivil= new EstadoCivil();
        this.condicionEspecial=new CondicionEspecial();
        this.grupoEtnico= new GrupoEtnico();
        this.informacionContacto= new InformacionContacto();
        this.informacionAcademica=new InformacionAcademica();
        this.examenEstado=new ExamenEstado();
        this.informacionAcudiente=new InformacionAcudiente();
        this.informacionAdicional=new InformacionAdicional ();
        this.documentos=new ArrayList();
    }

    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Ciudad getCiudadExpedicionDocumento() {
        return ciudadExpedicionDocumento;
    }

    public void setCiudadExpedicionDocumento(Ciudad ciudadExpedicionDocumento) {
        this.ciudadExpedicionDocumento = ciudadExpedicionDocumento;
    }

    public Date getFechaExpedicionDocumento() {
        return fechaExpedicionDocumento;
    }

    public void setFechaExpedicionDocumento(Date fechaExpedicionDocumento) {
        this.fechaExpedicionDocumento = fechaExpedicionDocumento;
    }

    public Ciudad getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(Ciudad ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public CondicionEspecial getCondicionEspecial() {
        return condicionEspecial;
    }

    public void setCondicionEspecial(CondicionEspecial condicionEspecial) {
        this.condicionEspecial = condicionEspecial;
    }

    public String getOtraCondicionEspecial() {
        return otraCondicionEspecial;
    }

    public void setOtraCondicionEspecial(String otraCondicionEspecial) {
        this.otraCondicionEspecial = otraCondicionEspecial;
    }

    public GrupoEtnico getGrupoEtnico() {
        return grupoEtnico;
    }

    public void setGrupoEtnico(GrupoEtnico grupoEtnico) {
        this.grupoEtnico = grupoEtnico;
    }

    public String getOtroGrupoEtnico() {
        return otroGrupoEtnico;
    }

    public void setOtroGrupoEtnico(String otroGrupoEtnico) {
        this.otroGrupoEtnico = otroGrupoEtnico;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public void setInformacionContacto(InformacionContacto informacionContacto) {
        this.informacionContacto = informacionContacto;
    }

    public InformacionAcademica getInformacionAcademica() {
        return informacionAcademica;
    }

    public void setInformacionAcademica(InformacionAcademica informacionAcademica) {
        this.informacionAcademica = informacionAcademica;
    }

    public ExamenEstado getExamenEstado() {
        return examenEstado;
    }

    public void setExamenEstado(ExamenEstado examenEstado) {
        this.examenEstado = examenEstado;
    }

    public InformacionAcudiente getInformacionAcudiente() {
        return informacionAcudiente;
    }

    public void setInformacionAcudiente(InformacionAcudiente informacionAcudiente) {
        this.informacionAcudiente = informacionAcudiente;
    }

    public InformacionAdicional getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(InformacionAdicional informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public String getPyz() {
        return pyz;
    }

    public void setPyz(String pyz) {
        this.pyz = pyz;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNroCarn() {
        return nroCarn;
    }

    public void setNroCarn(String nroCarn) {
        this.nroCarn = nroCarn;
    }

    public List<Documentos> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documentos> documentos) {
        this.documentos = documentos;
    }
        
}

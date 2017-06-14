/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.mb;

import co.admisiones.bean.Calendario;
import co.admisiones.bean.Ciudad;
import co.admisiones.bean.Colegio;
import co.admisiones.bean.CondicionEspecial;
import co.admisiones.bean.EstadoCivil;
import co.admisiones.bean.Estrato;
import co.admisiones.bean.Formulario;
import co.admisiones.bean.FuenteFinanciacion;
import co.admisiones.bean.FuenteInformacion;
import co.admisiones.bean.GrupoEtnico;
import co.admisiones.bean.Jornada;
import co.admisiones.bean.Localidad;
import co.admisiones.bean.Parentesco;
import co.admisiones.bean.Programa;
import co.admisiones.bean.TipoBachiller;
import co.admisiones.bean.TipoColegio;
import co.admisiones.bean.TipoIdentificacion;
import co.admisiones.bean.TipoPrograma;
import co.admisiones.bean.TipoSolicitud;
import co.admisiones.constantes.Constantes;

import co.admisiones.servicios.ServiciosAdmisiones;
import co.admisiones.servicios.ServiciosAdmisionesImplementacion;
import co.admisiones.utils.Validaciones;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Jose.suspes
 */
@ManagedBean
@ViewScoped
public class FormularioMB {

    ServiciosAdmisiones servicios;
    List<TipoIdentificacion> tiposIdentificaciones;
    List<TipoPrograma> tiposPrograma;
    List<Programa> programas;
    List<Jornada> jornadas;
    List<TipoSolicitud> tiposSolicitud;
    List<Ciudad> ciudades;
    List<EstadoCivil> estadosCivil;
    List<CondicionEspecial> condicionesEspeciales;
    List<GrupoEtnico> gruposEtnicos;

    List<Localidad> localidades;
    List<Estrato> estratos;
    List<Colegio> colegios;
    List<TipoBachiller> tiposBachiller;
    List<TipoColegio> tiposColegio;
    List<Calendario> calendarios;
    List<Parentesco> parentescos;
    List<FuenteFinanciacion> fuentesFinanciacion;
    List<FuenteInformacion> fuentesInformacion;

    Formulario formulario;
    boolean panelInicio;
    boolean panelPrograma;
    boolean panelInfromacionPersonal;
    boolean otraCondicionEspecial;
    boolean otroGrupoEtnico;
    boolean panelInformacionContacto;
    boolean panelInformacionAcademica;
    boolean panelExamenEstado;
    boolean panelInformacionAcudiente;
    boolean panelInformacionAdicional;
    boolean panelProceso;
    boolean panelDocumentos;

    boolean editarDatosPrograma;
    boolean editarDatosPersonales;
    boolean editarDatosContacto;
    boolean editarDatosAcademicos;
    boolean editarDatosExamen;
    boolean editarDatosAcudiente;
    boolean editarInformacionAdicional;

    boolean mostrarBotonSiguienteInformacionContacto;
    boolean mostrarBotonGuardarInformacionContacto;
    boolean mostrarBotonGuardarInformacionAcademica;
    boolean mostrarBotonSiguienteInformacionAcademica;
    boolean mostrarBotonGuardarInformacionExamen;
    boolean mostrarBotonSiguienteInformacionExamen;
    boolean mostrarBotonGuardarInformacionAcudiente;
    boolean mostrarBotonSiguienteInformacionAcudiente;
    boolean mostrarBotonGuardarInformacionAdicional;
    boolean mostrarBotonSiguienteInformacionAdicional;

    boolean localidadRequerida;
    boolean datosAcademicosRequeridos;

    String operacionRegistro;
    int anyoSistema;

    String pasoActual;

    private final static Logger log = Logger.getLogger(FormularioMB.class);

    /**
     * Creates a new instance of FormularioMB
     */
    @PostConstruct
    public void init() {

        this.servicios = new ServiciosAdmisionesImplementacion();
        this.formulario = new Formulario();
        this.panelInicio = true;
        this.panelPrograma = false;
        this.panelInfromacionPersonal = false;
        this.otraCondicionEspecial = false;
        this.formulario.setPeriodo(consultarPeriodo());
        this.otroGrupoEtnico = false;
        this.cargaListaTipoIdentificacion();
        this.cargaListaCiudades();

        this.panelInformacionContacto = false;
        this.panelInformacionAcademica = false;
        this.panelExamenEstado = false;
        this.panelInformacionAcudiente = false;
        this.panelInformacionAdicional = false;

        this.panelProceso = false;
        this.panelDocumentos = false;

        //Edicion de datos por seccion
        this.editarDatosPrograma = false;
        this.editarDatosPersonales = false;
        this.editarDatosContacto = false;
        this.editarDatosAcademicos = false;
        this.editarDatosExamen = false;
        this.editarDatosAcudiente = false;
        this.editarInformacionAdicional = false;

        //Boton siguiente
        this.mostrarBotonSiguienteInformacionContacto = false;
        this.mostrarBotonGuardarInformacionContacto = false;
        this.mostrarBotonGuardarInformacionAcademica = false;
        this.mostrarBotonGuardarInformacionExamen = false;
        this.mostrarBotonSiguienteInformacionAcademica = false;
        this.mostrarBotonSiguienteInformacionExamen = false;
        this.mostrarBotonGuardarInformacionAcudiente = false;
        this.mostrarBotonSiguienteInformacionAcudiente = false;
        this.mostrarBotonGuardarInformacionAdicional = false;
        this.mostrarBotonSiguienteInformacionAdicional = false;

        this.localidadRequerida = false;

        this.datosAcademicosRequeridos = true;
        this.pasoActual = Constantes.PASO_UNO;

        operacionRegistro = Constantes.GUARDAR_REGISTRO;
        Calendar fecha = Calendar.getInstance();
        anyoSistema = fecha.get(Calendar.YEAR);

    }

    public void cargaListaTipoIdentificacion() {
        tiposIdentificaciones = new ArrayList();
        try {
            this.tiposIdentificaciones = servicios.consultarTiposIdentificacion();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void cargaListaTiposPrograma() {
        tiposPrograma = new ArrayList();
        try {
            this.tiposPrograma = servicios.consultarTipoPrograma();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public String consultarPeriodo() {
        String periodo = new String();
        try {
            periodo = servicios.consultaPeriodo();

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return periodo;
    }

    public void cargaListaProgramas() {
        programas = new ArrayList();
        try {
            this.programas = servicios.consultarPrograma(formulario.getPrograma().getTipoPrograma().getCodigoTipoPrograma());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void mostrarOtraCondicionEspecial() {
        if (formulario.getAspirante().getCondicionEspecial().getCodigoCondicion().equalsIgnoreCase("OT")) {
            otraCondicionEspecial = true;
        } else {
            formulario.getAspirante().setOtraCondicionEspecial(null);
            otraCondicionEspecial = false;
        }
    }

    public void mostrarOtroGrupoEtnico() {
        if (formulario.getAspirante().getGrupoEtnico().getCodigoGrupoEtnico().equalsIgnoreCase("OT")) {
            this.otroGrupoEtnico = true;
        } else {
            formulario.getAspirante().setOtroGrupoEtnico(null);
            otroGrupoEtnico = false;
        }
    }

    public void cargaListaJornadas() {
        jornadas = new ArrayList();
        try {
            this.jornadas = servicios.consultarJornadas();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void cargaListaTiposSolictud() {
        tiposSolicitud = new ArrayList();
        try {
            this.tiposSolicitud = servicios.consultarTipoSolicitud();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void cargaListaColegios() {
        if (colegios == null) {
            try {
                colegios = new ArrayList();
                this.colegios = servicios.consultarColegios();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaCiudades() {

        if (ciudades == null) {
            ciudades = new ArrayList();
            try {
                this.ciudades = servicios.consultarCidades();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaEstadoCivil() {
        if (estadosCivil == null) {
            estadosCivil = new ArrayList();
            try {
                this.estadosCivil = servicios.consultarEstosCiviles();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaCondicionEspecial() {
        if (condicionesEspeciales == null) {
            condicionesEspeciales = new ArrayList();
            try {

                //implementacion provisional se debe cargar en una tabla
                CondicionEspecial dato1 = new CondicionEspecial();
                CondicionEspecial dato2 = new CondicionEspecial();
                CondicionEspecial otro = new CondicionEspecial();

                dato1.setCodigoCondicion("01");
                dato1.setNombreCondicion("Discapaciadad 01");

                dato2.setCodigoCondicion("02");
                dato2.setNombreCondicion("Discapaciadad 02");

                condicionesEspeciales.add(dato1);
                condicionesEspeciales.add(dato2);

                otro.setCodigoCondicion("OT");
                otro.setNombreCondicion("Otro");

                condicionesEspeciales.add(otro);

                //this.condicionEspecial = servicios.consultarCondicionEspecial();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaGrupoEtnico() {
        if (gruposEtnicos == null) {
            gruposEtnicos = new ArrayList();
            try {
                gruposEtnicos = servicios.consultaGruposEtnicos();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaLocalidad() {

        localidades = new ArrayList();
        try {
            localidades = servicios.consultarLocalidades(formulario.getAspirante().getInformacionContacto().getCiudad().getIdCiudad());
            if (localidades.size() > 0) {
                this.localidadRequerida = true;
            } else {
                this.localidadRequerida = false;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    public void cargaListaEstrato() {
        if (estratos == null) {
            estratos = new ArrayList();
            try {
                estratos = servicios.consultarEstratos();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaTipoBachiller() {
        if (tiposBachiller == null) {
            tiposBachiller = new ArrayList();
            try {
                tiposBachiller = servicios.consultarTiposBachiller();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaTipoColegio() {
        if (tiposColegio == null) {
            tiposColegio = new ArrayList();
            try {

                //Implementacion provisional
                TipoColegio dato1 = new TipoColegio();
                TipoColegio dato2 = new TipoColegio();

                dato1.setCodigoTipoColegio("O");
                dato1.setNombreTipoColegio("OFICIAL");

                dato2.setCodigoTipoColegio("P");
                dato2.setNombreTipoColegio("PRIVADO");

                tiposColegio.add(dato1);
                tiposColegio.add(dato2);

            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaCalendario() {
        if (calendarios == null) {
            calendarios = new ArrayList();
            try {
                //Implementacion provisional
                Calendario dato1 = new Calendario();
                Calendario dato2 = new Calendario();

                dato1.setCodigoCalendario("A");
                dato1.setNombreCalendario("A");

                dato2.setCodigoCalendario("B");
                dato2.setNombreCalendario("B");

                calendarios.add(dato1);
                calendarios.add(dato2);

            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaParentesco() {
        if (parentescos == null) {
            parentescos = new ArrayList();
            try {
                parentescos = servicios.consultarParentescos();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaFuentesFinanciacion() {
        if (fuentesFinanciacion == null) {
            fuentesFinanciacion = new ArrayList();
            try {
                fuentesFinanciacion = servicios.consultarFuentesFinanciacion();

            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public void cargaListaFuentesInfromacion() {
        if (fuentesInformacion == null) {
            fuentesInformacion = new ArrayList();
            try {
                fuentesInformacion = servicios.consultarFuentesInformacion();

            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    public List<Ciudad> onCompletarCiudad(String parametro) {
        List<Ciudad> cidadesEncontradas = new ArrayList();
        for (Ciudad ciudad : ciudades) {
            if (StringUtils.startsWithIgnoreCase(ciudad.getNombreCiudad(), parametro)
                    || StringUtils.startsWithIgnoreCase(ciudad.getNombreCiudad(), parametro)) {
                cidadesEncontradas.add(ciudad);
            }
        }

        return cidadesEncontradas;
    }

    public List<Colegio> onCompletarColegios(String parametro) {
        List<Colegio> colegiosEncontrados = new ArrayList();
        for (Colegio colegio : colegios) {

            if (StringUtils.containsIgnoreCase(colegio.getNombreColegio(), parametro) || StringUtils.containsIgnoreCase(colegio.getIdColegio(), parametro)) {

                colegiosEncontrados.add(colegio);
            }
        }

        return colegiosEncontrados;
    }

    public String getPasoActual() {
        return pasoActual;
    }

    public void setPasoActual(String pasoActual) {
        this.pasoActual = pasoActual;
    }

    public ServiciosAdmisiones getServicios() {
        return servicios;
    }

    public void setServicios(ServiciosAdmisiones servicios) {
        this.servicios = servicios;
    }

    public List<TipoIdentificacion> getTiposIdentificaciones() {
        return tiposIdentificaciones;
    }

    public void setTiposIdentificaciones(List<TipoIdentificacion> tiposIdentificaciones) {
        this.tiposIdentificaciones = tiposIdentificaciones;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public boolean isPanelInicio() {
        return panelInicio;
    }

    public void setPanelInicio(boolean panelInicio) {
        this.panelInicio = panelInicio;
    }

    public boolean isPanelPrograma() {
        return panelPrograma;
    }

    public void setPanelPrograma(boolean panelPrograma) {
        this.panelPrograma = panelPrograma;
    }

    public List<TipoPrograma> getTiposPrograma() {
        return tiposPrograma;
    }

    public void setTiposPrograma(List<TipoPrograma> tiposPrograma) {
        this.tiposPrograma = tiposPrograma;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

    public List<Jornada> getJornadas() {
        return jornadas;
    }

    public void setJornadas(List<Jornada> jornadas) {
        this.jornadas = jornadas;
    }

    public boolean isLocalidadRequerida() {
        return localidadRequerida;
    }

    public void setLocalidadRequerida(boolean localidadRequerida) {
        this.localidadRequerida = localidadRequerida;
    }

    public List<TipoSolicitud> getTiposSolicitud() {
        return tiposSolicitud;
    }

    public void setTiposSolicitud(List<TipoSolicitud> tiposSolicitud) {
        this.tiposSolicitud = tiposSolicitud;
    }

    public boolean isPanelInfromacionPersonal() {
        return panelInfromacionPersonal;
    }

    public void setPanelInfromacionPersonal(boolean panelInfromacionPersonal) {
        this.panelInfromacionPersonal = panelInfromacionPersonal;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public List<EstadoCivil> getEstadosCivil() {
        return estadosCivil;
    }

    public void setEstadosCivil(List<EstadoCivil> estadosCivil) {
        this.estadosCivil = estadosCivil;
    }

    public List<CondicionEspecial> getCondicionesEspeciales() {
        return condicionesEspeciales;
    }

    public void setCondicionesEspeciales(List<CondicionEspecial> condicionesEspeciales) {
        this.condicionesEspeciales = condicionesEspeciales;
    }

    public boolean isOtraCondicionEspecial() {
        return otraCondicionEspecial;
    }

    public void setOtraCondicionEspecial(boolean otraCondicionEspecial) {
        this.otraCondicionEspecial = otraCondicionEspecial;
    }

    public List<GrupoEtnico> getGruposEtnicos() {
        return gruposEtnicos;
    }

    public void setGruposEtnicos(List<GrupoEtnico> gruposEtnicos) {
        this.gruposEtnicos = gruposEtnicos;
    }

    public boolean isOtroGrupoEtnico() {
        return otroGrupoEtnico;
    }

    public void setOtroGrupoEtnico(boolean otroGrupoEtnico) {
        this.otroGrupoEtnico = otroGrupoEtnico;
    }

    public boolean isPanelInformacionContacto() {
        return panelInformacionContacto;
    }

    public void setPanelInformacionContacto(boolean panelInformacionContacto) {
        this.panelInformacionContacto = panelInformacionContacto;
    }

    public boolean isPanelInformacionAcademica() {
        return panelInformacionAcademica;
    }

    public void setPanelInformacionAcademica(boolean panelInformacionAcademica) {
        this.panelInformacionAcademica = panelInformacionAcademica;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public List<Estrato> getEstratos() {
        return estratos;
    }

    public void setEstratos(List<Estrato> estratos) {
        this.estratos = estratos;
    }

    public List<Colegio> getColegios() {
        return colegios;
    }

    public void setColegios(List<Colegio> colegios) {
        this.colegios = colegios;
    }

    public List<TipoBachiller> getTiposBachiller() {
        return tiposBachiller;
    }

    public void setTiposBachiller(List<TipoBachiller> tiposBachiller) {
        this.tiposBachiller = tiposBachiller;
    }

    public List<TipoColegio> getTiposColegio() {
        return tiposColegio;
    }

    public void setTiposColegio(List<TipoColegio> tiposColegio) {
        this.tiposColegio = tiposColegio;
    }

    public List<Calendario> getCalendarios() {
        return calendarios;
    }

    public void setCalendarios(List<Calendario> calendarios) {
        this.calendarios = calendarios;
    }

    public boolean isPanelExamenEstado() {
        return panelExamenEstado;
    }

    public void setPanelExamenEstado(boolean panelExamenEstado) {
        this.panelExamenEstado = panelExamenEstado;
    }

    public List<Parentesco> getParentescos() {
        return parentescos;
    }

    public void setParentescos(List<Parentesco> parentescos) {
        this.parentescos = parentescos;
    }

    public boolean isPanelInformacionAcudiente() {
        return panelInformacionAcudiente;
    }

    public void setPanelInformacionAcudiente(boolean panelInformacionAcudiente) {
        this.panelInformacionAcudiente = panelInformacionAcudiente;
    }

    public boolean isPanelInformacionAdicional() {
        return panelInformacionAdicional;
    }

    public void setPanelInformacionAdicional(boolean panelInformacionAdicional) {
        this.panelInformacionAdicional = panelInformacionAdicional;
    }

    public List<FuenteFinanciacion> getFuentesFinanciacion() {
        return fuentesFinanciacion;
    }

    public void setFuentesFinanciacion(List<FuenteFinanciacion> fuentesFinanciacion) {
        this.fuentesFinanciacion = fuentesFinanciacion;
    }

    public List<FuenteInformacion> getFuentesInformacion() {
        return fuentesInformacion;
    }

    public void setFuentesInformacion(List<FuenteInformacion> fuentesInformacion) {
        this.fuentesInformacion = fuentesInformacion;
    }

    public boolean isPanelProceso() {
        return panelProceso;
    }

    public void setPanelProceso(boolean panelProceso) {
        this.panelProceso = panelProceso;
    }

    public boolean isPanelDocumentos() {
        return panelDocumentos;
    }

    public void setPanelDocumentos(boolean panelDocumentos) {
        this.panelDocumentos = panelDocumentos;
    }

    public boolean isEditarDatosPrograma() {
        return editarDatosPrograma;
    }

    public void setEditarDatosPrograma(boolean editarDatosPrograma) {
        this.editarDatosPrograma = editarDatosPrograma;
    }

    public boolean isDatosAcademicosRequeridos() {
        return datosAcademicosRequeridos;
    }

    public void setDatosAcademicosRequeridos(boolean datosAcademicosRequeridos) {
        this.datosAcademicosRequeridos = datosAcademicosRequeridos;
    }

    public String getOperacionRegistro() {
        return operacionRegistro;
    }

    public void setOperacionRegistro(String operacionRegistro) {
        this.operacionRegistro = operacionRegistro;
    }

    public boolean isEditarDatosPersonales() {
        return editarDatosPersonales;
    }

    public void setEditarDatosPersonales(boolean editarDatosPersonales) {
        this.editarDatosPersonales = editarDatosPersonales;
    }

    public boolean isEditarDatosContacto() {
        return editarDatosContacto;
    }

    public void setEditarDatosContacto(boolean editarDatosContacto) {
        this.editarDatosContacto = editarDatosContacto;
    }

    public boolean isEditarDatosExamen() {
        return editarDatosExamen;
    }

    public void setEditarDatosExamen(boolean editarDatosExamen) {
        this.editarDatosExamen = editarDatosExamen;
    }

    public boolean isMostrarBotonSiguienteInformacionContacto() {
        return mostrarBotonSiguienteInformacionContacto;
    }

    public void setMostrarBotonSiguienteInformacionContacto(boolean mostrarBotonSiguienteInformacionContacto) {
        this.mostrarBotonSiguienteInformacionContacto = mostrarBotonSiguienteInformacionContacto;
    }

    public boolean getMostrarBotonGuardarInformacionContacto() {
        return mostrarBotonGuardarInformacionContacto;
    }

    public void setMostrarBotonGuardarInformacionContacto(boolean mostrarBotonGuardarInformacionContacto) {
        this.mostrarBotonGuardarInformacionContacto = mostrarBotonGuardarInformacionContacto;
    }

    public int getAnyoSistema() {
        return anyoSistema;
    }

    public void setAnyoSistema(int anyoSistema) {
        this.anyoSistema = anyoSistema;
    }

    public boolean getMostrarBotonGuardarInformacionAcademica() {
        return mostrarBotonGuardarInformacionAcademica;
    }

    public void setMostrarBotonGuardarInformacionAcademica(boolean mostrarBotonGuardarInformacionAcademica) {
        this.mostrarBotonGuardarInformacionAcademica = mostrarBotonGuardarInformacionAcademica;
    }

    public boolean isMostrarBotonSiguienteInformacionAcademica() {
        return mostrarBotonSiguienteInformacionAcademica;
    }

    public void setMostrarBotonSiguienteInformacionAcademica(boolean mostrarBotonSiguienteInformacionAcademica) {
        this.mostrarBotonSiguienteInformacionAcademica = mostrarBotonSiguienteInformacionAcademica;
    }

    public boolean isEditarDatosAcademicos() {
        return editarDatosAcademicos;
    }

    public void setEditarDatosAcademicos(boolean editarDatosAcademicos) {
        this.editarDatosAcademicos = editarDatosAcademicos;
    }

    public boolean isMostrarBotonGuardarInformacionExamen() {
        return mostrarBotonGuardarInformacionExamen;
    }

    public void setMostrarBotonGuardarInformacionExamen(boolean mostrarBotonGuardarInformacionExamen) {
        this.mostrarBotonGuardarInformacionExamen = mostrarBotonGuardarInformacionExamen;
    }

    public boolean isMostrarBotonSiguienteInformacionExamen() {
        return mostrarBotonSiguienteInformacionExamen;
    }

    public void setMostrarBotonSiguienteInformacionExamen(boolean mostrarBotonSiguienteInformacionExamen) {
        this.mostrarBotonSiguienteInformacionExamen = mostrarBotonSiguienteInformacionExamen;
    }

    public boolean isMostrarBotonGuardarInformacionAcudiente() {
        return mostrarBotonGuardarInformacionAcudiente;
    }

    public void setMostrarBotonGuardarInformacionAcudiente(boolean mostrarBotonGuardarInformacionAcudiente) {
        this.mostrarBotonGuardarInformacionAcudiente = mostrarBotonGuardarInformacionAcudiente;
    }

    public boolean isMostrarBotonSiguienteInformacionAcudiente() {
        return mostrarBotonSiguienteInformacionAcudiente;
    }

    public void setMostrarBotonSiguienteInformacionAcudiente(boolean mostrarBotonSiguienteInformacionAcudiente) {
        this.mostrarBotonSiguienteInformacionAcudiente = mostrarBotonSiguienteInformacionAcudiente;
    }

    public boolean isEditarDatosAcudiente() {
        return editarDatosAcudiente;
    }

    public void setEditarDatosAcudiente(boolean editarDatosAcudiente) {
        this.editarDatosAcudiente = editarDatosAcudiente;
    }

    public boolean isEditarInformacionAdicional() {
        return editarInformacionAdicional;
    }

    public void setEditarInformacionAdicional(boolean editarInformacionAdicional) {
        this.editarInformacionAdicional = editarInformacionAdicional;
    }

    public boolean isMostrarBotonGuardarInformacionAdicional() {
        return mostrarBotonGuardarInformacionAdicional;
    }

    public void setMostrarBotonGuardarInformacionAdicional(boolean mostrarBotonGuardarInformacionAdicional) {
        this.mostrarBotonGuardarInformacionAdicional = mostrarBotonGuardarInformacionAdicional;
    }

    public boolean isMostrarBotonSiguienteInformacionAdicional() {
        return mostrarBotonSiguienteInformacionAdicional;
    }

    public void setMostrarBotonSiguienteInformacionAdicional(boolean mostrarBotonSiguienteInformacionAdicional) {
        this.mostrarBotonSiguienteInformacionAdicional = mostrarBotonSiguienteInformacionAdicional;
    }

    public String onContinuar() {

        String edadValida = Validaciones.validarFechaNacimeinto(formulario.getAspirante().getFechaNacimiento());
        //Valida la edad 
        if (edadValida.equalsIgnoreCase("OK")) {

            cargaListaTiposPrograma();
            cargaListaJornadas();
            cargaListaTiposSolictud();
            this.formulario = servicios.consultarFormulario(this.formulario);
            cargaListaProgramas();
            //valida si ya esta ingresada informacón y habilita la edicion
            if (this.formulario.getPrograma().getIdPrograma() != null) {
                this.editarDatosPrograma = true;
            }
            if (this.formulario.getAspirante().getNombres() != null) {
                this.editarDatosPersonales = true;
            }
            if (this.formulario.getAspirante().getInformacionContacto().getDireccion() != null) {
                this.editarDatosContacto = true;
            }
            this.panelProceso = true;
            this.panelPrograma = true;
            this.panelInicio = false;
            identificarProceso();
            return "#";

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", edadValida));
            return "#";
        }

    }

    public String onSiguientePrograma() {

        this.cargaListaEstadoCivil();
        this.cargaListaCondicionEspecial();
        this.cargaListaGrupoEtnico();
        panelPrograma = false;
        panelInfromacionPersonal = true;
        return "#";

    }

    public String onAnteriorDatosPersonales() {
        panelPrograma = true;
        panelInfromacionPersonal = false;
        return "#";

    }

    public String onSiguienteInformacionPersonal() {

        panelInfromacionPersonal = false;
        panelInformacionContacto = true;

        if (!editarDatosContacto) {
            this.mostrarBotonGuardarInformacionContacto = true;
            this.mostrarBotonSiguienteInformacionContacto = false;
        } else {
            this.mostrarBotonGuardarInformacionContacto = false;
            this.mostrarBotonSiguienteInformacionContacto = true;
        }
        //cargar listas de la seccion
        this.cargaListaEstrato();
        return "#";

    }

    public String onAnteriorInformacionContacto() {
        panelInfromacionPersonal = true;
        panelInformacionContacto = false;
        this.mostrarBotonSiguienteInformacionContacto = false;
        this.mostrarBotonGuardarInformacionContacto = false;
        return "#";

    }

    public String onSiguienteInformacionContacto() {

        //valdacion de email igual
        if (formulario.getAspirante().getInformacionContacto().getEmail().equalsIgnoreCase(formulario.getAspirante().getInformacionContacto().getConfirmarEmail())) {
            this.cargaListaColegios();
            this.panelInformacionAcademica = true;
            this.panelInformacionContacto = false;
            this.mostrarBotonSiguienteInformacionContacto = false;

            if ((((this.formulario.getAspirante().getInformacionAcademica().getGraduadoColombia() == null) ? "X" : this.formulario.getAspirante().getInformacionAcademica().getGraduadoColombia()).equalsIgnoreCase(Constantes.SI)
                    && this.formulario.getAspirante().getInformacionAcademica().getAnyoGraduacion() != null)
                    || ((this.formulario.getAspirante().getInformacionAcademica().getGraduadoColombia() == null) ? "X" : this.formulario.getAspirante().getInformacionAcademica().getGraduadoColombia()).equalsIgnoreCase(Constantes.NO)) {
                this.mostrarBotonGuardarInformacionAcademica = false;
                this.mostrarBotonSiguienteInformacionAcademica = true;
                this.editarDatosAcademicos = true;
            } else {
                this.mostrarBotonGuardarInformacionAcademica = true;
                this.mostrarBotonSiguienteInformacionAcademica = false;
                this.editarDatosAcademicos = false;
            }
            this.cargaListaTipoBachiller();
            this.cargaListaTipoColegio();
            this.cargaListaCalendario();
            return "#";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", "La información registrada para el campo Correo Electrónico y Confirmacion de Correo Electrónico no coinciden."));
        }

        return "#";

    }

    public String onAnteriorInformacionAcademica() {

        this.panelInformacionAcademica = false;
        this.mostrarBotonSiguienteInformacionAcademica = false;
        this.mostrarBotonSiguienteInformacionContacto = false;
        this.panelInformacionContacto = true;
        this.mostrarBotonSiguienteInformacionContacto = true;

        return "#";

    }

    public String onSiguienteInformacionAcademica() {

        this.panelInformacionAcademica = false;
        this.mostrarBotonSiguienteInformacionAcademica = false;
        this.panelExamenEstado = true;
        //Se verifica que la información del examen si se ha guardad no habilita el boton

        if (formulario.getAspirante().getExamenEstado().getSnp() != null) {
            this.mostrarBotonGuardarInformacionExamen = false;
            this.mostrarBotonSiguienteInformacionExamen = true;
            this.editarDatosExamen = true;

        } else {
            this.mostrarBotonGuardarInformacionExamen = true;
            this.mostrarBotonSiguienteInformacionExamen = false;
            this.editarDatosExamen = false;
        }

        return "#";
    }

    public String onAnteriorExamenEstado() {

        this.panelExamenEstado = false;
        this.panelInformacionAcademica = true;
        this.mostrarBotonSiguienteInformacionAcademica = true;
        this.mostrarBotonSiguienteInformacionExamen = false;
        this.mostrarBotonGuardarInformacionExamen = false;
        return "#";

    }

    public String onSiguienteExamenEstado() {

        this.panelExamenEstado = false;
        this.panelInformacionAcudiente = true;
        this.mostrarBotonSiguienteInformacionExamen = false;
        this.mostrarBotonGuardarInformacionExamen = false;
        if (formulario.getAspirante().getInformacionAcudiente().getParentesco().getCodigoParentesco() != null) {
            this.editarDatosAcudiente = true;
            this.mostrarBotonSiguienteInformacionAcudiente = true;
            this.mostrarBotonGuardarInformacionAcudiente = false;
        } else {
            this.editarDatosAcudiente = false;
            this.mostrarBotonSiguienteInformacionAcudiente = false;
            this.mostrarBotonGuardarInformacionAcudiente = true;
        }

        this.cargaListaParentesco();
        return "#";
    }

    public String onAnteriorInformacionAcudiente() {

        this.panelInformacionAcudiente = false;
        this.panelExamenEstado = true;
        this.mostrarBotonSiguienteInformacionAcudiente = false;
        this.mostrarBotonGuardarInformacionAcudiente = false;
        this.mostrarBotonSiguienteInformacionExamen = true;

        return "#";

    }

    public String onSiguienteInformacionAcudiente() {
        this.panelInformacionAcudiente = false;
        this.panelInformacionAdicional = true;
        this.mostrarBotonSiguienteInformacionAcudiente = false;
        this.mostrarBotonGuardarInformacionAcudiente = false;
        this.cargaListaFuentesFinanciacion();
        this.cargaListaFuentesInfromacion();

        if (formulario.getAspirante().getInformacionAdicional().getFuenteFinanciacion().getCodigoFuenteFinanciacion() != null) {
            this.mostrarBotonSiguienteInformacionAdicional = true;
            this.mostrarBotonGuardarInformacionAdicional = false;
            this.editarInformacionAdicional = true;
        } else {
            this.mostrarBotonSiguienteInformacionAdicional = false;
            this.mostrarBotonGuardarInformacionAdicional = true;
            this.editarInformacionAdicional = false;
        }
        return "#";
    }

    public String onAnteriorInformacionAdicional() {

        this.panelInformacionAdicional = false;
        this.panelInformacionAcudiente = true;
        this.mostrarBotonSiguienteInformacionAcudiente = true;
        this.mostrarBotonSiguienteInformacionAdicional = false;
        this.mostrarBotonGuardarInformacionAdicional = false;
        return "#";

    }

    public String onEditarInfromacionPrograma() {
        this.editarDatosPrograma = false;
        return "#";
    }

    public String onSiguienteInformacionAdicional() {
        return "#";
    }

    public void onGuardarEstudiante() {
        if (this.operacionRegistro.equalsIgnoreCase(Constantes.GUARDAR_REGISTRO)) {
            try {
                servicios.guadarEstudiante(formulario);
                this.operacionRegistro = Constantes.ACTULIZAR_REGISTRO;
                this.mostrarBotonGuardarInformacionContacto = false;
                this.mostrarBotonSiguienteInformacionContacto = true;
                this.editarDatosContacto = true;
                this.editarDatosPersonales = true;
                this.editarDatosPrograma = true;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Informacion guardada con exito, click en siguiente para continuar con la inscripción"));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Se presentado error al guardar la información ingresada." + e.getMessage()));
            }

        }

    }

    public void onFijarInformacionAcademicaRequerida() {
        if (((this.formulario.getAspirante().getInformacionAcademica().getGraduadoColombia() == null) ? "S" : this.formulario.getAspirante().getInformacionAcademica().getGraduadoColombia()).equalsIgnoreCase(Constantes.SI)) {
            this.datosAcademicosRequeridos = true;
        } else {
            this.datosAcademicosRequeridos = false;
        }
    }

    public void onGuardarInformacionAcademica() {
        try {
            servicios.actualizarInformacionAcademicaEstudiante(formulario);
            this.mostrarBotonGuardarInformacionAcademica = false;
            this.mostrarBotonSiguienteInformacionAcademica = true;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Informacion guardada con exito, click en siguiente para continuar con la inscripción"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Se presentado error al gurdar la información ingresada." + e.getMessage()));
        }
    }

    public void onGuardarInfromacionExamen() {
        try {

            servicios.actualizarInformacionExamen(formulario);
            this.mostrarBotonGuardarInformacionExamen = false;
            this.mostrarBotonSiguienteInformacionExamen = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Informacion actulizada con exitoInformacion guardada con exito, click en siguiente para continuar con la inscripción"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Se presentado error al gurdar la información ingresada." + e.getMessage()));
        }

    }

    public void onGuardarInformacionAcudiente() {
        try {
            servicios.guardarInformacionAcudiente(formulario);
            this.mostrarBotonSiguienteInformacionAcudiente = true;
            this.mostrarBotonGuardarInformacionAcudiente = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Informacion actulizada con exitoInformacion guardada con exito, click en siguiente para continuar con la inscripción"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Se presentado error al gurdar la información ingresada." + e.getMessage()));
        }

    }

    public void onGuardarInformacionAdicional() {
        try {
            servicios.guardarInformacionAdicional(formulario);
            this.mostrarBotonSiguienteInformacionAdicional = true;
            this.mostrarBotonGuardarInformacionAdicional = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Registro de inscripción finalizado con exito. Imprima su fromulario en la opción Imprimir Formulario"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Se presentado error al gurdar la información ingresada." + e.getMessage()));
        }

    }

    public void identificarProceso() {
        if (formulario.getAspirante().getInformacionAdicional().getFuenteFinanciacion().getCodigoFuenteFinanciacion() != null) {

            this.pasoActual = Constantes.PASO_DOS;
            this.panelInicio = false;
            this.panelPrograma = false;
            this.panelInfromacionPersonal = false;
            this.panelInformacionContacto = false;
            this.panelInformacionAcademica = false;
            this.panelExamenEstado = false;
            this.panelInformacionAcudiente = false;
            this.panelInformacionAdicional = false;
            this.panelDocumentos = true;
        }
    }

    public String irAPasoUno() {
        this.panelPrograma = true;
        this.panelInfromacionPersonal = false;
        this.panelInformacionContacto = false;
        this.panelInformacionAcademica = false;
        this.panelExamenEstado = false;
        this.panelInformacionAcudiente = false;
        this.panelInformacionAdicional = false;
        this.panelInicio = false;
        this.panelDocumentos = false;
        return "#";
    }

    public String irAPasoDos() {
        this.panelPrograma = false;
        this.panelInfromacionPersonal = false;
        this.panelInformacionContacto = false;
        this.panelInformacionAcademica = false;
        this.panelExamenEstado = false;
        this.panelInformacionAcudiente = false;
        this.panelInformacionAdicional = false;
        this.panelInicio = false;
        this.panelDocumentos = true;
        return "#";
    }

}

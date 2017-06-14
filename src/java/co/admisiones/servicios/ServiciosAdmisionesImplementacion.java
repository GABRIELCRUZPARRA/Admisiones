/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.servicios;

import co.admisiones.bean.Ciudad;
import co.admisiones.bean.Colegio;
import co.admisiones.bean.EstadoCivil;
import co.admisiones.bean.Estrato;
import co.admisiones.bean.Formulario;
import co.admisiones.bean.FuenteFinanciacion;
import co.admisiones.bean.FuenteInformacion;
import co.admisiones.bean.GrupoEtnico;
import co.admisiones.bean.Programa;
import co.admisiones.bean.TipoIdentificacion;
import co.admisiones.bean.TipoPrograma;
import co.admisiones.bean.Jornada;
import co.admisiones.bean.Localidad;
import co.admisiones.bean.Parentesco;
import co.admisiones.bean.TipoBachiller;
import co.admisiones.bean.TipoSolicitud;
import co.admisiones.constantes.Constantes;

import co.admisiones.manager.ManagerAdmisiones;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author jose.suspes
 */
public class ServiciosAdmisionesImplementacion implements ServiciosAdmisiones {

    private final static Logger log = Logger.getLogger(ServiciosAdmisionesImplementacion.class);

    @Override
    public List<TipoIdentificacion> consultarTiposIdentificacion() {
        List<TipoIdentificacion> tiposIdentificaciones = new ArrayList();
        try {
            tiposIdentificaciones = (List<TipoIdentificacion>) ManagerAdmisiones.getManager().obtenerListado("obtenerListadoTipoIdentificacion");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return tiposIdentificaciones;
    }

    @Override
    public String consultaPeriodo() {
        String periodo = new String();
        try {
            periodo = (String) ManagerAdmisiones.getManager().obtenerRegistro("obtenerPeriodo");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return periodo;
    }

    @Override
    public List<TipoPrograma> consultarTipoPrograma() {
        List<TipoPrograma> tiposPrograma = new ArrayList();
        try {
            tiposPrograma = (List<TipoPrograma>) ManagerAdmisiones.getManager().obtenerListado("obtenerListadoTipoProgramas");

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return tiposPrograma;
    }

    @Override
    public List<Programa> consultarPrograma(Object obj) {
        List<Programa> programas = new ArrayList();
        try {
            programas = (List<Programa>) ManagerAdmisiones.getManager().obtenerListado("obtenerListadoProgramas", obj);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return programas;
    }

    @Override
    public List<Jornada> consultarJornadas() {
        List<Jornada> jornadas = new ArrayList();
        try {
            jornadas = (List<Jornada>) ManagerAdmisiones.getManager().obtenerListado("obtenerListadoJornada");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return jornadas;
    }

    @Override
    public List<Estrato> consultarEstratos() {
       
        List<Estrato> estratos =new ArrayList();
        try {
            estratos=(List<Estrato>) ManagerAdmisiones.getManager().obtenerListado("obtenerListadoEstrato");
        } catch (Exception e) {
           log.error(e.getMessage());
        }        
        return estratos;
        
    }

    @Override
    public List<TipoBachiller> consultarTiposBachiller() {
        List<TipoBachiller> tiposBachiller= new ArrayList();
        try {
              tiposBachiller=(List<TipoBachiller>)ManagerAdmisiones.getManager().obtenerListado("obtenerListadoTipoBachiller");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
      return  tiposBachiller;
        
    }

    @Override
    public List<Parentesco> consultarParentescos() {
        List<Parentesco> parentescos =new ArrayList();
        try {
            parentescos=(List<Parentesco>)ManagerAdmisiones.getManager().obtenerListado("obtenerListadoResponsable");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return parentescos;
    }

    @Override
    public List<FuenteFinanciacion> consultarFuentesFinanciacion() {
        List<FuenteFinanciacion> fuentesFinanciacion=new ArrayList();
        try {
            fuentesFinanciacion=(List<FuenteFinanciacion>)ManagerAdmisiones.getManager().obtenerListado("obtenerListadoFuenteFiananciacion");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return fuentesFinanciacion; 
    }

    @Override
    public List<TipoSolicitud> consultarTipoSolicitud() {
        List<TipoSolicitud> tipoSolicitud = new ArrayList();
        try {
            tipoSolicitud = (List<TipoSolicitud>) ManagerAdmisiones.getManager().obtenerListado("obtenerListadoTipoSolicitud");
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return tipoSolicitud;
    }

    @Override
    public List<Ciudad> consultarCidades() {

        //
        List<Ciudad> ciudades = new ArrayList();
        try {
            ciudades = (List<Ciudad>) ManagerAdmisiones.getManager().obtenerListado("obtenerListadoCiudades");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ciudades;
    }

    @Override
    public List<EstadoCivil> consultarEstosCiviles() {
        List<EstadoCivil> estadosCiviles = new ArrayList();
        try {
            estadosCiviles = ManagerAdmisiones.getManager().obtenerListado("obtenerListadoEstadoCivil");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return estadosCiviles;
    }

    @Override
    public Ciudad consultaCiudadPorId(String parametro) {

        Ciudad ciudad = new Ciudad();
        try {
            ciudad = (Ciudad) ManagerAdmisiones.getManager().obtenerRegistro("obtenerCiudadPorId", parametro);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return ciudad;
    }

    @Override
    public List<Colegio> consultarColegios() {

        List<Colegio> colegios = new ArrayList();

        try {
            colegios = ManagerAdmisiones.getManager().obtenerListado("obtenerListadoColegios");
        } catch (Exception e) {
            log.error(e);
        }

        return colegios;

    }

    @Override
    public List<FuenteInformacion> consultarFuentesInformacion() {
        List<FuenteInformacion> fuentesInfromacion = new ArrayList();
        try {
            fuentesInfromacion = ManagerAdmisiones.getManager().obtenerListado("obtenerListadoFuenteInformacion");

        } catch (Exception e) {
            log.error(e);
        }
        return fuentesInfromacion;
    }

    @Override
    public List<GrupoEtnico> consultaGruposEtnicos() {
        List<GrupoEtnico> gruposEtnicos= new ArrayList();
        try {
            gruposEtnicos=ManagerAdmisiones.getManager().obtenerListado("obtenerListadoGrupoEtnico");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return gruposEtnicos;
    }

    @Override
    public List<Localidad> consultarLocalidades(Object obj) {
       List<Localidad> localidades=new ArrayList();
        try {
            localidades= ManagerAdmisiones.getManager().obtenerListado("obtenerListadoLocalidad",obj);            
        } catch (Exception e) {
            log.error(e.getMessage());
        }
       return localidades;
    }

    @Override
    public Colegio consultarColegioPorId(String parametro) {
        Colegio colegio = new Colegio();
        try {
            colegio = (Colegio) ManagerAdmisiones.getManager().obtenerRegistro("obtenerColegioPorId", parametro);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return colegio;
    }

    @Override
    public void guadarEstudiante(Formulario formulario) {
        long secuencia = 0;
        try {
            secuencia = obtenerSecuenciaEscolaris(Constantes.TABLA_ESTUDIANTE);
            //Se crea el  regsitro en la tabla estudiante
            formulario.getAspirante().setIdEstudiante(secuencia);
            formulario.getAspirante().setEstado(Constantes.ESTADO);
            formulario.getAspirante().setPyz(Constantes.PYZ);
            formulario.getAspirante().setNroCarn(Constantes.NROCARN);
            /*
            //Datos a guardar
            log.info("idEstudiante: " + formulario.getAspirante().getIdEstudiante());
            log.info("Periodo: " + formulario.getPeriodo());
            log.info("NRO Carnet " + formulario.getAspirante().getNroCarn());
            log.info("Nombres: " + formulario.getAspirante().getNombres());
            log.info("Apellidos: " + formulario.getAspirante().getApellidos());
            log.info("Id Programa: " + formulario.getPrograma().getIdPrograma());
            log.info("Tipo Programa: " + formulario.getPrograma().getTipoPrograma().getCodigoTipoPrograma());
            log.info("Genero: " + formulario.getAspirante().getGenero());
            log.info("Identificacion: " + formulario.getAspirante().getIdentificacion());
            log.info("Tipo Identificacion: " + formulario.getAspirante().getTipoIdentificacion().getCodigoTipoIdentificacion());
            log.info("Id Ciudad Expedicion: " + formulario.getAspirante().getCiudadExpedicionDocumento().getIdCiudad());
            log.info("Fecha exp Documento: " + formulario.getAspirante().getFechaExpedicionDocumento());
            log.info("Estado Civil: " + formulario.getAspirante().getEstadoCivil().getCodigoEstado());
            log.info("Fecha Nacimiento: " + formulario.getAspirante().getFechaNacimiento());
            log.info("Ciudad Nacimeinto: " + formulario.getAspirante().getCiudadNacimiento().getIdCiudad());
            log.info("Nacionalidad: " + formulario.getAspirante().getNacionalidad());
            log.info("Direccion " + formulario.getAspirante().getInformacionContacto().getDireccion());
            log.info("Telefono: " + formulario.getAspirante().getInformacionContacto().getTelefono());
            log.info("Ciudad Direccion: " + formulario.getAspirante().getInformacionContacto().getCiudad().getIdCiudad());
            log.info("Celular: " + formulario.getAspirante().getInformacionContacto().getCelular());
            log.info("Estado: " + formulario.getAspirante().getEstado());
            log.info("Email: " + formulario.getAspirante().getInformacionContacto().getEmail());
            log.info("Jornada: " + formulario.getJornada().getCodigoJornada());
            log.info("Barrio: " + formulario.getAspirante().getInformacionContacto().getBarrio());
            log.info("Estrato: " + formulario.getAspirante().getInformacionContacto().getEstrato().getCodigoEstrato());
            log.info("Localida: " + formulario.getAspirante().getInformacionContacto().getLocalidad().getCodigoLocalidad());
            log.info("Fuente Informacion " + formulario.getAspirante().getInformacionAdicional().getFuenteInformacion().getCodigoFuenteInformacion());
            log.info("PYZ: " + formulario.getAspirante().getPyz());*/

            ManagerAdmisiones.getManager().insertarRegistro("insertarEstudiante", formulario);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarInformacionAcademicaEstudiante(Formulario formulario) {
        try {
            ManagerAdmisiones.getManager().actualizarRegistro("updateEstudianteDatosAcademicos", formulario);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void actualizarInformacionExamen(Formulario formulario) {
        long secuencia = 0;
        try {
            secuencia = obtenerSecuenciaEscolaris(Constantes.TABLA_ICFES);
            formulario.getAspirante().getExamenEstado().setIdExamen(secuencia);
            ManagerAdmisiones.getManager().insertarRegistro("insertarInformacionIcfes", formulario);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void guardarInformacionAcudiente(Formulario formulario) {
        long secuencia = 0;
        try {
            secuencia = obtenerSecuenciaEscolaris(Constantes.TABLA_RESPONSABLE);
            formulario.getAspirante().getInformacionAcudiente().setIdAcudiente(secuencia);
            ManagerAdmisiones.getManager().insertarRegistro("insertarInformacionResponsable", formulario);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public long obtenerSecuenciaEscolaris(String tabla) {
        long secuenciaEscolaris = 0;
        try {
            secuenciaEscolaris = Long.valueOf((String) ManagerAdmisiones.getManager().obtenerRegistro("obtenerSecuenciaEscolaris", tabla));
            actulizarSecuenciaEscolaris(tabla);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return secuenciaEscolaris;
    }

    @Override
    public void actulizarSecuenciaEscolaris(String tabla) {
        try {
            ManagerAdmisiones.getManager().actualizarRegistro("actualizarSecuenciaEscolaris", tabla);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public Formulario consultarFormulario(Formulario formulario) {
        Formulario formuraioConsultado = new Formulario();
        try {
            if (ManagerAdmisiones.getManager().obtenerListado("obtenerEtudiante", formulario).size() > 0) {
                formuraioConsultado = (Formulario) ManagerAdmisiones.getManager().obtenerListado("obtenerEtudiante", formulario).get(0);
            } else {
                formuraioConsultado.setPeriodo(formulario.getPeriodo());
                formuraioConsultado.getAspirante().setIdentificacion(formulario.getAspirante().getIdentificacion());
                formuraioConsultado.getAspirante().getTipoIdentificacion().setCodigoTipoIdentificacion(formulario.getAspirante().getTipoIdentificacion().getCodigoTipoIdentificacion());
                formuraioConsultado.getAspirante().setFechaNacimiento(formulario.getAspirante().getFechaNacimiento());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return formuraioConsultado;
    }

    @Override
    public void actualizarFuenteFinanciacion(Formulario formulario) {
        try {
            ManagerAdmisiones.getManager().insertarRegistro("updateEstudianteFuenteFinanciacion", formulario);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void guardarInformacionFuenteInformacion(Formulario formulario) {
        long secuencia = 0;
        try {
            secuencia = obtenerSecuenciaEscolaris(Constantes.TABLA_PROMOCION);
            formulario.getAspirante().getInformacionAdicional().getFuenteInformacion().setIdFuenteInformacion(secuencia);
            ManagerAdmisiones.getManager().insertarRegistro("insertarFuenteInformacion", formulario);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void guardarInformacionAdicional(Formulario formulario) {

        actualizarFuenteFinanciacion(formulario);
        guardarInformacionFuenteInformacion(formulario);
    }

}

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
import java.util.List;

/**
 *
 * @author jose.suspes
 */
public interface ServiciosAdmisiones {
    
    
    public List<TipoIdentificacion> consultarTiposIdentificacion();
    public String consultaPeriodo();
    public List<TipoPrograma> consultarTipoPrograma(); 
    public List<Programa> consultarPrograma(Object obj);
    public List<Jornada> consultarJornadas();
    public List<TipoSolicitud> consultarTipoSolicitud();
    public List<Ciudad> consultarCidades();
    public List<EstadoCivil> consultarEstosCiviles(); 
    public Ciudad consultaCiudadPorId(String parametro);
    public List<Colegio> consultarColegios();
    public List<FuenteInformacion> consultarFuentesInformacion(); 
    public List<GrupoEtnico> consultaGruposEtnicos();
    public List<Localidad> consultarLocalidades(Object obj);
    public List<Estrato> consultarEstratos();
    public List<TipoBachiller> consultarTiposBachiller();
    public List<Parentesco> consultarParentescos();
    public List<FuenteFinanciacion> consultarFuentesFinanciacion();
    public Colegio consultarColegioPorId(String parametro);
    public void guadarEstudiante(Formulario formulario);  
    public void actualizarInformacionAcademicaEstudiante(Formulario formulario);  
    public void actualizarInformacionExamen(Formulario formulario);  
    public void guardarInformacionAcudiente(Formulario formulario);  
    public long obtenerSecuenciaEscolaris(String tabla); 
    public void actulizarSecuenciaEscolaris(String tabla); 
    public Formulario consultarFormulario(Formulario formulario);
    public void actualizarFuenteFinanciacion(Formulario formulario);  
    public void guardarInformacionFuenteInformacion(Formulario formulario);  
    public void guardarInformacionAdicional(Formulario formulario); 
    
    
}

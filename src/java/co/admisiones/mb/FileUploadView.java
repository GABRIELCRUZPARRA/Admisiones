/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.mb;

import co.admisiones.bean.Foto;
import co.admisiones.bean.TipoIdentificacion;
import co.admisiones.ng.AdminicionesNG;
import co.admisiones.servicios.ServiciosAdmisiones;
import co.admisiones.servicios.ServiciosAdmisionesImplementacion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Jose.suspes
 */
@ManagedBean
@ViewScoped
public class FileUploadView {

    /**
     * Creates a new instance of FileUploadView
     */
    String numeroIdenticacion;
    String periodo;
    
    ServiciosAdmisiones servicios; 
    List <TipoIdentificacion> tiposIdentificaciones;  
    TipoIdentificacion tipoIDentificacion;
    
    private final static Logger log = Logger.getLogger(FileUploadView.class);
    
    public FileUploadView() {
    
    }
     @PostConstruct
    public void init() {
        log.info("Inicio bean de sesion.");
        servicios=new ServiciosAdmisionesImplementacion();
        tipoIDentificacion= new TipoIdentificacion ();
        cargaListaTipoIdentificacion();
    }
    
    public void cargaListaTipoIdentificacion()
    {
       tiposIdentificaciones= new ArrayList();
       try {
             this.tiposIdentificaciones=servicios.consultarTiposIdentificacion();
       } catch (Exception e) {
            log.error(e.getMessage());
        } 
    }
    

    public void uploadFile(FileUploadEvent event) {
        try {
            String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/fotos");
            String archivo = path + File.separator + ((numeroIdenticacion==null)?"fotonoidentificada":numeroIdenticacion)+".jpeg" ;
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            Foto foto =new Foto();
            
            foto.setDocEst((numeroIdenticacion==null)?"-1":numeroIdenticacion);
            foto.setPerIng((periodo==null)?"-1":periodo);
            
            byte[] buffer = new byte[6124];
            int bulk;
            InputStream inputStream = event.getFile().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();
            /**/
            if (!medidasFoto(archivo)) { //borrra el archivo creado
                borrarArchivo(archivo);
                AdminicionesNG.borraFoto(foto);
                FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "La foto no cumple con el tamaño 3X4 exigido. Cambie la foto y carguela nuevamente"));
            } else {
                AdminicionesNG.registrarFoto(foto);
                FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "", "La foto ha sido cargada con exito."));
                
            }

        } catch (IOException e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al subir el archivo"));
        }
    }

    public boolean medidasFoto(String archivo) {
        ImageIcon icono = new ImageIcon(archivo); // Esta llamada espera a que la imagen esté cargada.
        //Valores Fotos 3X4
        //if (icono.getIconHeight() == 531 && icono.getIconWidth() == 413) {
        if ((icono.getIconHeight() < 550 && icono.getIconHeight() >500 )  && (icono.getIconWidth() >= 400 && icono.getIconWidth()<=450)) {
            return true;
        } else {
            return false;
        }
    }

    public void borrarArchivo(String archivo) {
        File fichero = new File(archivo);
        fichero.delete();
    }

    public String getNumeroIdenticacion() {
        return numeroIdenticacion;
    }

    public void setNumeroIdenticacion(String numeroIdenticacion) {
        this.numeroIdenticacion = numeroIdenticacion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<TipoIdentificacion> getTiposIdentificaciones() {
        return tiposIdentificaciones;
    }

    public void setTiposIdentificaciones(List<TipoIdentificacion> tiposIdentificaciones) {
        this.tiposIdentificaciones = tiposIdentificaciones;
    }

    public TipoIdentificacion getTipoIDentificacion() {
        return tipoIDentificacion;
    }

    public void setTipoIDentificacion(TipoIdentificacion tipoIDentificacion) {
        this.tipoIDentificacion = tipoIDentificacion;
    }

}

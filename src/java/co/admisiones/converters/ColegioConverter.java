/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.converters;

import co.admisiones.bean.Ciudad;
import co.admisiones.bean.Colegio;
import co.admisiones.servicios.ServiciosAdmisiones;
import co.admisiones.servicios.ServiciosAdmisionesImplementacion;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

/**
 *
 * @author Jose.suspes
 */
@FacesConverter("colegioConverter")
public class ColegioConverter implements Converter {
    

    private final static Logger log = Logger.getLogger(ColegioConverter.class);

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        ServiciosAdmisiones servicios = new ServiciosAdmisionesImplementacion();
        if (string != null && string.trim().length() > 0) {
            return servicios.consultarColegioPorId(string);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof Colegio) {
            return (((Colegio) o).getIdColegio());
        }
        return null;
    }
}

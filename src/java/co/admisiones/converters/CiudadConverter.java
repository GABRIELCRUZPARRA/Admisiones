/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.converters;

import co.admisiones.bean.Ciudad;
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
@FacesConverter("ciudadConverter")
public class CiudadConverter implements Converter {

    private final static Logger log = Logger.getLogger(CiudadConverter.class);

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        ServiciosAdmisiones servicios = new ServiciosAdmisionesImplementacion();
        if (string != null && string.trim().length() > 0) {
            return servicios.consultaCiudadPorId(string);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof Ciudad) {
            return (((Ciudad) o).getIdCiudad());
        }
        return null;
    }

}

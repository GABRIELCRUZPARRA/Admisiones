/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.utils;

import co.admisiones.constantes.Constantes;
import co.admisiones.mb.FormularioMB;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 *
 * @author Jose.suspes
 */
public class Validaciones {

    private final static Logger log = Logger.getLogger(FormularioMB.class);

    public static String validarFechaNacimeinto(Date fechaNacimiento) {
        Date fechaActual = new Date();

        long anyosDiferencia;
        try {
            //se valida que la fech anos ea superio a la fecha del sistema
            if (fechaActual.after(fechaNacimiento)) {
                anyosDiferencia = (((fechaActual.getTime() - fechaNacimiento.getTime()) / Constantes.MILLSECS_POR_DIA) / 30) / 12;
                if (anyosDiferencia >= Constantes.ANYOS_MINIMOS) {
                    if (anyosDiferencia <= Constantes.ANYOS_MAXIMOS) {
                        return Constantes.OK;
                    } else {
                        return "La edad maxima permitida para la inscripción es de " + Constantes.ANYOS_MAXIMOS + " años";
                    }
                } else {
                    return "La edad minima para la inscripción es de " + Constantes.ANYOS_MINIMOS + " años";
                }
            } else {
                return "La fecha de nacimiento no puede ser mayor la fecha del sistema.";
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            return Constantes.FALLIDO;
        }
    }

}

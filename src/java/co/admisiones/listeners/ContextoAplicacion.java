/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.listeners;

/**
 *
 * @author jsuspes
 */
public class ContextoAplicacion {

    public static final ContextoAplicacion contextoAplicacion = new ContextoAplicacion();
    private String rutaContexto = "";

    private ContextoAplicacion() {
    }

    public static ContextoAplicacion getInstance() {
        return contextoAplicacion;
    }

    public String getRutaContexto() {
        return rutaContexto;
    }

    public void setRutaContexto(String rutaContexto) {
        this.rutaContexto = rutaContexto;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.manager;

import co.admisiones.dao.DaoAdmisiones;
import java.util.List;

/**
 *
 * @author jsuspes
 */
public class ManagerAdmisiones extends ManagerStandard {

    private static final ManagerAdmisiones ManagerBotonPago = new ManagerAdmisiones();

    /**
     * @type Constructor de la clase FacadeGeneral
     * @name FacadeGeneral
     * @return void
     * @desc Crea una instancia de FacadeGeneral
     */
    private ManagerAdmisiones() {
        super();
    }

    /**
     * @type Mï¿½todo de la clase ManagerBP
     * @name getManager
     * @return ManagerBP
     * @desc permite obtener la instancia del objeto ManagerBP (singlenton)
     */
    public static ManagerAdmisiones getManager() {
        return ManagerBotonPago;
    }

    public List obtenerListado(String sqlName, Object objeto) throws Exception {
        DaoAdmisiones serviciosDao = new DaoAdmisiones();
        return (List) serviciosDao.obtenerListado(sqlName, objeto);
    }

    public List obtenerListado(String sqlName) throws Exception {
        DaoAdmisiones serviciosDao = new DaoAdmisiones();
        return (List) serviciosDao.obtenerListado(sqlName);
    }

    public Object ejecutarProcedimiento(String sqlName) throws Exception {
        DaoAdmisiones serviciosDao = new DaoAdmisiones();
        return serviciosDao.ejecutarProcedimiento(sqlName);
    }

    public void generarRegistro(String sqlName, Object object) throws Exception {
        DaoAdmisiones serviciosDao = new DaoAdmisiones();
        serviciosDao.generarOrdenDePagoborrarRegistro(sqlName, object);
    }

    public Object obtenerRegistro(String sqlName, Object object) throws Exception {
        DaoAdmisiones serviciosDao = new DaoAdmisiones();
        return serviciosDao.obtenerRegistro(sqlName, object);
    }

    public Object obtenerRegistro(String sqlName) throws Exception {
        DaoAdmisiones serviciosDao = new DaoAdmisiones();
        return serviciosDao.obtenerRegistro(sqlName);
    }

    public Object insertarRegistro(String qryName, Object objeto)
            throws Exception {
        DaoAdmisiones serviciosDao = new DaoAdmisiones();
        return serviciosDao.insertarRegistro(qryName, objeto);
    }

    public Object actualizarRegistro(String qryName, Object objeto)
            throws Exception {
        DaoAdmisiones serviciosDao = new DaoAdmisiones();
        return serviciosDao.actualizarRegistro(qryName, objeto);
    }

}

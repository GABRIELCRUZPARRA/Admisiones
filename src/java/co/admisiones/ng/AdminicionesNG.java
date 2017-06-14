/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.ng;

import co.admisiones.bean.Foto;
import co.admisiones.dao.Dao;
import co.admisiones.db.DataSourceSQLServer;
import org.apache.log4j.Logger;
import co.admisiones.utils.CargarArchivoPropiedades;
/**
 *
 * @author Jose.suspes
 */
public class AdminicionesNG {

    static Logger logger = Logger.getLogger(AdminicionesNG.class.getName());
    
    public static void registrarFoto(Foto foto) {
        /*se define el datasource de para leer de escolaris*/
        Dao dao = new Dao();
        String sentencia="insert into registro.foto (per_ing,docest,fec_insc)values ('"+foto.getPerIng()+"','"+foto.getDocEst()+"',GETDATE())";
        dao.ejecutarSentencia(DataSourceSQLServer.getConnectionSQLserver(CargarArchivoPropiedades.getProperties()), sentencia);
    }
    
    public static void borraFoto(Foto foto) {
        /*se define el datasource de para leer de escolaris*/
        Dao dao = new Dao();
        String sentencia="delete registro.foto where docest='"+foto.getDocEst()+"";
        dao.ejecutarSentencia(DataSourceSQLServer.getConnectionSQLserver(CargarArchivoPropiedades.getProperties()), sentencia);
    }
}

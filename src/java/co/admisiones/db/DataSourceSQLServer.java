/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author Jose.suspes
 */
public class DataSourceSQLServer //implements IDBCPDataSource 
{
    static Logger logger = Logger.getLogger(DataSourceSQLServer.class.getName());
    public static Connection connsqlserver;
    public static Connection getConnectionSQLserver(Properties props) {
        //a continuacion vamos a formar la cadena de conexion, pero...
        try {
            if (connsqlserver == null) {
                Class.forName(props.getProperty("SQLSERVER_DB_DRIVER_CLASS"));
                String url = props.getProperty("SQLSERVER_DB_URL");
                connsqlserver = DriverManager.getConnection(url, props.getProperty("SQLSERVER_DB_USERNAME"), props.getProperty("SQLSERVER_DB_PASSWORD"));
            }
            return connsqlserver;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}

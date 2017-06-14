/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;


/**
 *
 * @author Jose.suspes
 */
public class Dao {
    
    static Logger logger = Logger.getLogger(Dao.class.getName());
            
    public  List<Object> consultarDatos(Connection con,String sentencia)
    {
        List<Object> datos= new ArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        int index=0;
        try {
             stmt = con.createStatement();
             rs = stmt.executeQuery(sentencia);
             while(rs.next()){
                datos.add(rs.getObject(index) );
                index+=index;
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally{
                try {
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
        }        
       return  datos;
    }  
    
    public void ejecutarSentencia(Connection con,String sentencia)
    {
        Statement stmt = null;
        ResultSet rs = null;
        try {
             stmt = con.createStatement();
             stmt.execute(sentencia);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally{
                try {
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
        }        
    
    }
}

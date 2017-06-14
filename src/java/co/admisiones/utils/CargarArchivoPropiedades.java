/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.utils;

import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author Jose.suspes
 */
public class CargarArchivoPropiedades {

    static Logger logger = Logger.getLogger(CargarArchivoPropiedades.class.getName());

    public  static Properties getProperties() {
        Properties props = new Properties();
        //FileInputStream fis = null;
        try {
            //fis = new FileInputStream("datasource.properties");
            props.load(CargarArchivoPropiedades.class.getClassLoader().getResourceAsStream("datasource.properties"));
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
        return props;
    }

}

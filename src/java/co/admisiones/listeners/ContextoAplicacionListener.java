/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.listeners;

/**
 *
 * @author jsuspes
 */
import co.admisiones.configuracion.ConfiguradorIbatis;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 *
 * @author jsuspes
 */
public class ContextoAplicacionListener implements ServletContextListener {

	//protected static Logger log = Logger.getLogger(ContextoAplicacionListener.class);
	
	/** Propiedad rutaContexto de la clase [ ContextoAplicacionListener.java ] 
	 *  @desc: guarda ela ruta fisica del contexto de la aplicacion */
	private String rutaContexto = "";

    
    public ContextoAplicacionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	
		// Carga la configuracion de Ibatis
		ConfiguradorIbatis.getInstance().configurar("conexiodb");
		
		//hallamos la ruta del contexto de la aplicacion 
		this.rutaContexto = arg0.getServletContext().getRealPath("/");
		
		try {
			Properties prop = new Properties();
			FileInputStream file = new FileInputStream(this.rutaContexto + "WEB-INF/classes/" + "datasource.properties");
			prop.load(file);
			//log.info(prop.getProperty("url"));
			//log.info("username: " + prop.getProperty("username"));
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//log.error(e);
		} catch (IOException e) {
			e.printStackTrace();
			//log.error(e);
		}
		
		//guardamos esta ruta para usarla en otros modulos
		ContextoAplicacion pContextoAplicacion = ContextoAplicacion.getInstance();
		pContextoAplicacion.setRutaContexto ( this.rutaContexto );			
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
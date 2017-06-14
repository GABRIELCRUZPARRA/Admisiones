/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.dao;

import co.admisiones.configuracion.ConfiguradorIbatis;
import java.util.Collection;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author jsuspes
 */
public class DaoStandard implements IDao {

	public  SqlSessionFactory sqlSessionFactory = ConfiguradorIbatis.getInstance().getSqlSessionFactory();
	
	
	public DaoStandard() {
		super();
	}

	
	public Collection obtenerListado(String sqlName) throws Exception {
		throw new Exception("Metodo [ obtenerListado ] no implementado por la clase " + this.getClass());
	}
	
	public Collection obtenerListado(String sqlName, Object objeto) throws Exception {
		throw new Exception("Metodo [ obtenerListado ] no implementado por la clase " + this.getClass());
	}
	
	public Object obtenerRegistro(String sqlName) throws Exception {
		throw new Exception("Metodo [ obtenerRegistro ] no implementado por la clase " + this.getClass());
	}

	public Object obtenerRegistro(String sqlName, Object objeto) throws Exception {
		throw new Exception("Metodo [ obtenerRegistro ] no implementado por la clase " + this.getClass());
	}

	public Object ejecutarProcedimiento(String sqlName) throws Exception {
		throw new Exception("Metodo [ ejecutarProcedimiento ] no implementado por la clase " + this.getClass());
	}
	
	public Object ejecutarProcedimiento(String sqlName, Object objeto) throws Exception {
		throw new Exception("Metodo [ ejecutarProcedimiento ] no implementado por la clase " + this.getClass());
	}

	public Object insertarRegistro(String sqlName, Object objeto) throws Exception {
		throw new Exception("Metodo [ insertarRegistro ] no implementado por la clase " + this.getClass());
	}


	public Object actualizarRegistro(String sqlName, Object objeto) throws Exception {
		throw new Exception("Metodo [ actualizarRegistro ] no implementado por la clase " + this.getClass());
	}

	
	public Object borrarRegistro(String sqlName, Object objeto) throws Exception {
		throw new Exception("Metodo [ borrarRegistro ] no implementado por la clase " + this.getClass());
	}
	
	public Object validarSQL(String sql) throws Exception {
		throw new Exception("Metodo [ validarSQL ] no implementado por la clase " + this.getClass());
	}
}


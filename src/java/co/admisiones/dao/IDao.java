/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.dao;

/**
 *
 * @author jsuspes
 */
import java.util.Collection;

@SuppressWarnings("unchecked")
public interface IDao {

	/**
	 * @type   Mï¿½todo de la clase IDao
	 * @name   obtenerListado
	 * @return Collection
	 * @param objeto
	 * @desc   Este mï¿½todo es la plantilla para traer un listado de objetos producto de una consulta
	 */
	abstract Collection obtenerListado ( String  sqlName) throws Exception;	
	abstract Collection obtenerListado ( String  sqlName, Object object) throws Exception;

	/**
	 * @type   Mï¿½todo de la clase IDao
	 * @name   obtenerRegistro
	 * @return Object
	 * @param objeto
	 * @desc   
	 */
	abstract Object obtenerRegistro ( String sqlName) throws Exception;
	abstract Object obtenerRegistro (String sqlName,  Object objeto ) throws Exception;
	
	
	/**
	 * @type   Mï¿½todo de la clase IDao
	 * @name   insertarRegistro
	 * @return Object
	 * @param objeto
	 * @desc   Este mï¿½todo es la plantilla para insertar registros a la base de datos
	 */
	abstract Object insertarRegistro (String sqlName, Object objeto ) throws Exception;
	

	/**
	 * @type   MÃ©todo de la clase IDao
	 * @name   actualizarRegistro
	 * @return Object
	 * @param objeto
	 * @throws Exception
	 * @desc   Este mï¿½todo es la plantilla para actualizar registros a la base de datos
	 */
	abstract Object actualizarRegistro (String sqlName, Object objeto ) throws Exception;	
	
	/**
	 * @type   MÃ©todo de la clase IDao
	 * @name   borrarRegistro
	 * @return Object
	 * @param objeto
	 * @throws Exception
	 * @desc   Este mï¿½todo es la plantilla para borrar registros a la base de datos
	 */
	abstract Object borrarRegistro (String sqlName, Object objeto ) throws Exception;	
	
	abstract Object validarSQL(String sql) throws Exception;
}

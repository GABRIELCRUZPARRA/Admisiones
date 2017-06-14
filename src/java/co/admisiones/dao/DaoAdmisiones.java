/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.dao;

import java.sql.Connection;
import java.util.Collection;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author jsuspes
 */

@SuppressWarnings("unchecked")
public class DaoAdmisiones extends DaoStandard {

	private SqlSession session = sqlSessionFactory.openSession(true);
	
	@Override
	public Collection obtenerListado(String sqlName) throws Exception {
		try{
			return session.selectList(sqlName);
		}finally{
			session.close();
		}
	}
	
	
	@Override
	public Collection obtenerListado(String sqlName,Object object) throws Exception {
		try{
			return session.selectList(sqlName,object);
		}finally{
			session.close();
		}
	}
	

	@Override
	 public Object obtenerRegistro(String sqlName) throws Exception {
		try{
			return session.selectOne(sqlName);
		}finally{
			session.close();
		}
	}
	
	@Override
	 public Object obtenerRegistro(String sqlName,Object object) throws Exception {
		try{
			return session.selectOne(sqlName,object);
		}finally{
			session.close();
		}
	}
	
	@Override
	 public Object ejecutarProcedimiento(String sqlName) throws Exception {
		try{
			return session.update(sqlName);
		}finally{
			session.close();
		}
	}
	
	@Override
	 public Object ejecutarProcedimiento(String sqlName,Object object) throws Exception {
		try{
			return session.update(sqlName,object);
		}finally{
			session.close();
		}
	}

	
	@Override
	 public Object insertarRegistro(String sqlName,Object object) throws Exception {
		try{
			return session.insert(sqlName,object);
		}finally{
			session.close();
		}
	}

	@Override
	 public Object actualizarRegistro(String sqlName,Object object) throws Exception {
		try{
			return session.update(sqlName,object);
		}finally{
			session.close();
		}
	}
	
	@Override
	 public Object borrarRegistro(String sqlName,Object object) throws Exception {
		try{
			return session.delete(sqlName,object);
		}finally{
			session.close();
		}
	}
	
	public Object validarSQL(String sql) throws Exception {
		try {
			Connection con = session.getConnection();
			return con.prepareStatement(sql);
		} finally {
			session.close();
		}
	}
        
        public void generarOrdenDePagoborrarRegistro(String sqlName,Object object) throws Exception {
		try{
			 session.delete(sqlName,object);
		}finally{
			session.close();
		}
	}
}

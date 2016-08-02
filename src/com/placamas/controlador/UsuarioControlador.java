package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.placamas.beans.MarcasBean;
import com.placamas.beans.OpcionBean;
import com.placamas.beans.UsuarioBean;
import com.placamas.beans.UsuarioRight;
import com.placamas.conexion.ConexionDB;

public class UsuarioControlador {



	public UsuarioBean valida(String login, String clave) {
		UsuarioBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql = "select * from user_data where idUser=? and User_Pasw =?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, clave);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				bean = new UsuarioBean(sql, sql, sql,sql,sql, sql);
				bean.setIdUser(rs.getString("idUser"));
				bean.setUser_Nomb(rs.getString(2));
				bean.setUser_Pasw("User_Pasw");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return bean;
	}


	
	
	public UsuarioBean Pregunta(String login, String pregunta) {
		UsuarioBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql = "select * from user_data where idUser=? and respuesta =?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, pregunta);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				bean = new UsuarioBean(sql, sql, sql,sql,sql,sql);
				bean.setIdUser(rs.getString("idUser"));
				bean.setUser_Nomb(rs.getString(2));
				bean.setUser_Pasw(rs.getString(3));
				bean.setResp("respuesta");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return bean;
	}
	
	
	
	
	public List<OpcionBean> obtieneOpciones(String idUsuario) {

		ArrayList<OpcionBean> data = new ArrayList<OpcionBean>();
		OpcionBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql = "select o.idopcion, o.descripcion from opcion o,acceso a, user_data u where  u.idUser = a.idUser and  o.idopcion = a.idopcion and u.idUser =?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idUsuario);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new OpcionBean();
				bean.setIdOpcion(rs.getInt("idopcion"));
				bean.setDescripcion(rs.getString("descripcion"));
				data.add(bean);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return data;
	}

	
	public int eliminarUsuario(String cod) {
		
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="delete from user_data where idUser=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, cod);
			//5
			valor=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return valor;
		
	}
	
	
	public UsuarioBean cambiarContrase�a(String pass,String preg ,String resp, String log ) {
		
		
		UsuarioBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {conn = new ConexionDB().getConexion();
		String sql = "update user_data"+
					" set User_Pasw=?, pregunta=? , respuesta=?"+
					" where idUser=?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pass);
			pstm.setString(2, preg);
			pstm.setString(3, resp);
			pstm.setString(4, log);
			
			int rs = pstm.executeUpdate();
			
			String mensaje = "Los datos se han Modoficado de Manera Satisfactoria...";
			if (rs>0) {
				JOptionPane.showMessageDialog(null, mensaje);				
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return bean;
		
	}
	
	
	public int insertaUsuario(UsuarioBean x){
		int contador = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="insert into user_data values(?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, x.getIdUser());
			pstm.setString(2, x.getUser_Nomb());
			pstm.setString(3, x.getUser_Pasw());
			pstm.setString(4, x.getPregunta());
			pstm.setString(5, x.getResp());
			pstm.setString(6, x.getEmail());
			

			contador = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return contador;
	}
	
public ArrayList<UsuarioBean> listarUsuario(){
		
		ArrayList<UsuarioBean> data = new ArrayList<UsuarioBean>();
		UsuarioBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="select * from user_data";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				bean = new UsuarioBean(sql, sql, sql,sql,sql,sql);
				bean.setIdUser(rs.getString("idUser"));
				bean.setUser_Nomb(rs.getString("user_Nomb"));
				bean.setUser_Pasw(rs.getString("user_Pasw"));
				bean.setEmail(rs.getString("email"));
				
				data.add(bean);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return data;
	}

public ArrayList<UsuarioRight> listarUsuarioLocal(){

	ArrayList<UsuarioRight> data = new ArrayList<UsuarioRight>();
	UsuarioRight r = null;
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = new ConexionDB().getConexion();
		String sql ="select * from user_right";
		pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()){
			r = new UsuarioRight(rs.getString(1), 
					rs.getString(2));
			data.add(r);
		}
	} catch (Exception e) {
		System.out.println(e);
	} finally{
		try {
			conn.close();
			pstm.close();
		} catch (SQLException e) {
		}
	}
	
		return data;
	}


public ArrayList<UsuarioBean> listarPregunta(String idpreg){
	ArrayList<UsuarioBean> data = new ArrayList<UsuarioBean>();
	UsuarioBean bean = null;
	Connection cn=null;
	PreparedStatement pstm=null;
	ResultSet rs=null;
	try {
		
		cn=new ConexionDB().getConexion();
		String sql="select *  from user_data where IdUser="+idpreg;
	
		pstm=cn.prepareStatement(sql);//esto almacena la pregunta?

		rs=pstm.executeQuery();
		
		while (rs.next()) {
			bean=new UsuarioBean(rs.getString(1),
					rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
			
			data.add(bean);
		}
	
		
	} catch (Exception e) {
		//e.printStackTrace();
	}finally{
		try {
			if(rs!=null) rs.close();
			if(pstm!=null) pstm.close();
			if(cn!=null) cn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return data;
}


}







package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastro.factory.ConnectionFactory;
import br.com.cadastro.model.Usuario;

public class UsuarioDAO {
	//Faz com que o java molde-se ao banco
	/*
	 * create
	 * read
	 * update
	 * delete
	 * 
	 * */
	public void save(Usuario usuario){

		String sql = "INSERT INTO usuario(id, name, email, password, phone) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try{
			conn = ConnectionFactory.createConnectionToMySQL();
			//preparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, usuario.getId());
			pstm.setString(2, usuario.getName());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getPassword());
			pstm.setInt(5, usuario.getPhone());
			
			
			//Executar a query
			pstm.execute();
			System.out.println("Contato salvo com sucesso!");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			//fechar conexões
			try{
				if(pstm!=null){
					pstm.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("finally")
	public List<Usuario> getUsuario(){

	String sql = "SELECT * FROM  usuario";

	
	List<Usuario> usuarios = new ArrayList<Usuario>();

	Connection conn = null;
	PreparedStatement pstm = null;
	//classe que recupera os dados do banco 
	ResultSet rset = null;

	try {
		conn = ConnectionFactory.createConnectionToMySQL();

	pstm = (PreparedStatement) conn.prepareStatement(sql);

	rset = pstm.executeQuery();

	while (rset.next()){
		
		Usuario usuario = new Usuario();
		
		//Recuperar id
		usuario.setId(rset.getInt("id"));
		
		usuario.setName(rset.getString("name"));

		usuario.setEmail(rset.getString("email"));
		usuario.setPassword(rset.getString("password"));
		usuario.setPhone(rset.getInt("phone"));
		
		usuarios.add(usuario);
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			
			try{
			if(rset!=null){
				rset.close();
			}
			if(pstm!=null){
				pstm.close();
			}
			if(conn!=null){
				conn.close();	
			}
		}catch(Exception e) {
			e.printStackTrace();
			}
		
		return usuarios;
		}
}
	

public void removeById(int id){
	 
	 String sql = "DELETE FROM contatos WHERE id = ?";
	 
	 Connection conn = null;
	 PreparedStatement pstm = null;
	 
	 try {
	 conn = ConnectionFactory.createConnectionToMySQL();
	 
	 pstm = conn.prepareStatement(sql);
	 
	 pstm.setInt(1, id);
	 
	 pstm.execute();
	 
	 } catch (Exception e) {
		 e.printStackTrace();
	
	 }finally{
	 
	 try{
	 if(pstm != null){
	 
	 pstm.close();
	 }
	 
	 if(conn != null){
	 conn.close();
	 }
	 
	 }catch(Exception e){
	 
	 e.printStackTrace();
	 }
	}
}
	 
	 public void update(Usuario usuario){
	 
	 String sql = "UPDATE usuarios SET name = ?, email = ?, password = ?" +
	 " WHERE id = ?";
	 
	 Connection conn = null;
	 PreparedStatement pstm = null;
	 
	 try {
	 //Cria uma conexão com o banco
	 conn = ConnectionFactory.createConnectionToMySQL();
	 
	 //Cria um PreparedStatment, classe usada para executar a query
	 pstm = conn.prepareStatement(sql);
	 
	 //Adiciona o valor do primeiro parâmetro da sql
	 pstm.setInt(1, usuario.getId());
	 //Adicionar o valor do segundo parâmetro da sql
	 pstm.setString(2, usuario.getName());
	 //Adiciona o valor do terceiro parâmetro da sql
	 pstm.setString(3, usuario.getEmail());
	 
	 pstm.setString(4, usuario.getPassword());
	 
	 pstm.setInt(5, usuario.getPhone());
	 
	 //Executa a sql para inserção dos dados
	 pstm.execute();
	 
	 } catch (Exception e) {
		 e.printStackTrace();
	 }finally{
	 
	 //Fecha as conexões
	 
		 try{
			 if(pstm != null){
				 pstm.close();
			 }
			 
			 if(conn != null){
				 conn.close();
			 }
			 
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		}
	 }
}
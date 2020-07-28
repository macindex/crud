package br.com.cadastro.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	
	//nome do user mysql
	private static final String USERNAME = "root";

	//passwd do banco
	private static final String PASSWORD = "123456789";		
	
	//caminho do banco, porta, nome do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cadastro?useTimezone=true&serverTimezone=UTC";
	
	public static Connection createConnectionToMySQL()throws Exception{
		//Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Cria a conexão com o BDD
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
		
	}
		public static void main(String[] args) throws Exception{
			
			//Recuperar uma conexão com o banco de dados
			Connection con = createConnectionToMySQL();
			
			//Testar se a conexão é nula
			if(con!=null){
				System.out.println("Conexão obtida com sucesso!");
				con.close();
				
			}
		}
}

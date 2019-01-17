package br.com.pedidosimples.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * classe responsavel por conter os metodos de criar e fechar a conex�o com o banco
 * 
 * @author rafael
 *
 */
public class ConnectionFactoryPostGre implements  IConnectionFactory{
	
	// Caminho do bancoi de dados
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5433/wsrfid";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "passwd";
	
	public Connection criarConexao(){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conex�o com o banco: " + URL);	
			e.printStackTrace();
		}
		
		return conexao;
		
	}
	
	public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs){
		
		try {
			
			if(conexao!=null){
				conexao.close(); 
			}
			
			if(pstmt!=null){
				pstmt.close(); 
			}
			
			if(rs!=null){
			   rs.close(); 
			}
			
		} catch (Exception e) {
			System.out.println();
		}
		
	}
	
}

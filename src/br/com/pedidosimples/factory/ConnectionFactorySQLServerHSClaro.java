package br.com.pedidosimples.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

public class ConnectionFactorySQLServerHSClaro implements IConnectionFactory {
	
	// Caminho do banco de dados
	private static final String DRIVER = "net.sourceforge.jtds.jdbc.Driver"; //jdbc:jtds:sqlserver://<nome ou IP do servidor>:1433/<nome da base de dados>;instance=<nome da inst�ncia>
	private static final String URL = "jdbc:jtds:sqlserver://177.70.116.29:1433;DatabaseName=HSClaro";//;namedPipe=true
	private static final String USUARIO = "sa";              //187.45.226.143           //  
	private static final String SENHA = "qsazul";
	
	private static Logger logger = Logger.getLogger("ConnectionFactorySQLServerRFID");

	@Override
	public Connection criarConexao() {
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conexao com o banco: " + URL);	
			e.printStackTrace();
		}
		
		return conexao;
		
	}

	@Override
	public void fecharConexao(Connection conexao, PreparedStatement pstmt,
			ResultSet rs) {

		try {
			
			if(conexao!= null){
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

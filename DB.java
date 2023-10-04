package db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	//criação de um metódo para conexão do banco de dados.
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if (conn == null) {//teste para verificar a conexão do banco de dados
			try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");//propriedade esta definida dentro do arquivo.
			conn = DriverManager.getConnection(url, props);//conexão com o banco de dados.
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	//metodo para fechar a conexão
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	//método auxiliar para carregamento do arquivo db.properties.
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);//load abre o objeto fs (arquivo) e guarda no props.
			return props;
		}
		catch (Exception e) {
			throw new DbException(e.getMessage());// trata a duas excessões que tivemos no bloco acima.
		}
				
		
	}

}

package br.edu.theproject.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQL {
	
	private static ConexaoSQL conexaoSQL;
	
	public static ConexaoSQL getInstance() {
		if(conexaoSQL == null) {
			conexaoSQL = new ConexaoSQL();
		}
		return conexaoSQL;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/gymsystem?useSSL=false","root", "123456789");
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(getInstance().getConnection());
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}

}

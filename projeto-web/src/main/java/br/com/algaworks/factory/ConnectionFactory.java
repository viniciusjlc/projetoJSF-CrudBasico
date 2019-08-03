package br.com.algaworks.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DRIVER_CLASS = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	public static Connection getConnection() {
		Connection conexao = null;
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		try {
			conexao = DriverManager.getConnection(URL, USER, PASS);
			conexao.setAutoCommit(false);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conexao;
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author barce
 */
    public class Conexao {
	private static final String url = "jdbc:postgresql://localhost:5432/postgres";
	private static final String user = "postgres";
	private static final String password = "123456";
	
	public static Connection criarConexao() {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Encontrado!");
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {

			Connection conexao = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado!");
			return conexao;

		} catch (SQLException e) {
			System.out.println("Falha Conexão");

			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
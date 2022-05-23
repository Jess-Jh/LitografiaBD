package co.edu.uniquindio.litografia.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {
	
	Connection conectar = null;
	
	public Connection conexion() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conectar = DriverManager.getConnection("jdbc:mysql://localhost/litografia", "root", "root@324");
			
			System.out.println("Conexión exitosa");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error de Conexión " + e.getMessage() );
		}
		return conectar;
	}

}

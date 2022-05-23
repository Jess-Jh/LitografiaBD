package co.edu.uniquindio.litografia.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import co.edu.uniquindio.litografia.modelo.Cliente;
import co.edu.uniquindio.litografia.modelo.Papeleria;

public class Persistencia {
	
	static ConexionSQL conexion = new ConexionSQL();
	static Connection con = conexion.conexion();
	
	// ------------------------------------------------------------CRUD Cliente ------------------------------------------------------------->>
	public static void guardarCliente(String cedula, String nombre, String apellido, String telefono, String correoElectronico) {
				
		try {
			String insertCliente = "insert into cliente (cedulaCliente, nombre, apellido, telefono, correoElectronico) "
								 + "values (?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(insertCliente);
			
			pst.setString(1, cedula);
			pst.setString(2, nombre);
			pst.setString(3, apellido);
			pst.setString(4, telefono);
			pst.setString(5, correoElectronico);
			
			pst.execute();
			System.out.println("Almacenado correctamente en la base de datos");
			
		} catch (SQLException e) {
			System.out.println("Error al almacenar el cliente en la base de datos " + e.getMessage());
		}
	}

	public static void cargarDatosClientes(Papeleria papeleria) {
		Cliente cliente;
		String selectCliente = "select * from cliente";
		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(selectCliente);
			
			while(rs.next()) {
				
				cliente = new Cliente(rs.getString("cedulaCliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("correoElectronico"));
				papeleria.getListaClientes().add(cliente);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al cargar el cliente de la base de datos " + e.getMessage());
		}
	}
	
	public static void actualizarCliente(String cedula, String nombre, String apellido, String telefono, String correoElectronico) {
		
		try {
			String updateCliente = "update cliente "
					+ "set cedulaCliente = ?, nombre = ?, apellido = ?, telefono = ?, correoElectronico = ? "
					+ "where cedulaCliente = ?";
			
			PreparedStatement pst = con.prepareStatement(updateCliente);		
			
			pst.setString(1, cedula);
			pst.setString(2, nombre);
			pst.setString(3, apellido);
			pst.setString(4, telefono);
			pst.setString(5, correoElectronico);
			pst.setString(6, cedula);
			
			pst.execute();
			System.out.println("Actualización del cliente correcta en la base de datos");
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar el cliente en la base de datos " + e.getMessage());
		}
	}

	public static void eliminarCliente(String cedula) {
				
		try {
			String deleteCliente = "delete from cliente where cedulaCliente = " + cedula;
			Statement st = con.createStatement();
			
			int flag = st.executeUpdate(deleteCliente);
			
			if(flag >= 0) System.out.println("Cliente eliminado");
			
		} catch (SQLException e) {
			System.out.println("Error al eliminar el cliente de la base de datos " + e.getMessage());
		}
		
	}
		
	// ----------------------------------------------------------------------------------------------------------------------------------------------------||


}

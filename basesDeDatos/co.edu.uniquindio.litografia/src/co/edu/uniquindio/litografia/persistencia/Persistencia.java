package co.edu.uniquindio.litografia.persistencia;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import co.edu.uniquindio.litografia.modelo.Cliente;
import co.edu.uniquindio.litografia.modelo.Empleado;
import co.edu.uniquindio.litografia.modelo.Factura;
import co.edu.uniquindio.litografia.modelo.Papeleria;
import co.edu.uniquindio.litografia.modelo.Producto;
import co.edu.uniquindio.litografia.modelo.Proveedor;
import co.edu.uniquindio.litografia.modelo.TipoEmpleado;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

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
			System.out.println("Cliente almacenado correctamente en la base de datos");
			
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
	
	// ------------------------------------------------------------CRUD Producto ------------------------------------------------------------->>
	public static void guardarProducto(String id, String tipo, String precio) {
				
		try {
			String insertProducto = "insert into producto (idProducto, tipo, precio, cantidad) "
								  + "values (?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(insertProducto);
			
			pst.setString(1, id);
			pst.setString(2, tipo);
			pst.setString(3, precio);
			pst.setString(4, null);
			
			pst.execute();
			System.out.println("Producto almacenado correctamente en la base de datos");
			
		} catch (SQLException e) {
			System.out.println("Error al almacenar el producto en la base de datos " + e.getMessage());
		}
	}

	public static void cargarDatosProductos(Papeleria papeleria) {
		Producto producto;
		String selectCliente = "select * from producto";
		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(selectCliente);
			
			while(rs.next()) {
				producto = new Producto(rs.getString("idProducto"), rs.getString("tipo"), rs.getDouble("precio"), rs.getInt("cantidad"));
				papeleria.getListaProductos().add(producto);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al cargar el producto de la base de datos " + e.getMessage());
		}
	}
	
	public static void actualizarProducto(String id, String tipo, String precio) {
		
		try {
			String updateProducto = "update producto "
					+ "set idProducto = ?, tipo = ?, precio = ?, cantidad = ? "
					+ "where idProducto = ?";
			
			PreparedStatement pst = con.prepareStatement(updateProducto);		
			
			pst.setString(1, id);
			pst.setString(2, tipo);
			pst.setString(3, precio);
			pst.setString(4, null);
			pst.setString(5, id);
			
			pst.execute();
			System.out.println("Se actualizó el producto correctamente en la base de datos");
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar el producto en la base de datos " + e.getMessage());
		}
	}

	public static void eliminarProducto(String idProducto) {
				
		try {
			String deleteProducto = "delete from producto where idProducto = " + idProducto;
			Statement st = con.createStatement();
			
			int flag = st.executeUpdate(deleteProducto);
			
			if(flag >= 0) System.out.println("Producto eliminado");
			
		} catch (SQLException e) {
			System.out.println("Error al eliminar el producto de la base de datos " + e.getMessage());
		}
	}
	// ----------------------------------------------------------------------------------------------------------------------------------------------------||

	// ------------------------------------------------------------CRUD Proveedor ------------------------------------------------------------------------->>
	public static void guardarProveedor(String idProveedor, String rutProveedor, String nombre, String telefono) {
				
		try {
			String insertProducto = "insert into proveedor (idProveedor, rut, nombre, telefono) "
								  + "values (?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(insertProducto);
			
			pst.setString(1, idProveedor);
			pst.setString(2, rutProveedor);
			pst.setString(3, nombre);
			pst.setString(4, telefono);
			
			pst.execute();
			System.out.println("Proveedor almacenado correctamente en la base de datos");
			
		} catch (SQLException e) {
			System.out.println("Error al almacenar el proveedor en la base de datos " + e.getMessage());
		}
	}

	public static void cargarDatosProveedoor(Papeleria papeleria) {
		Proveedor proveedor;
		String selectProveedor = "select * from proveedor";
		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(selectProveedor);
			
			while(rs.next()) {
				proveedor = new Proveedor(rs.getString("idProveedor"), rs.getString("RUT"), rs.getString("nombre"), rs.getString("telefono"));
				papeleria.getListaProveedores().add(proveedor);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al cargar el proveedor de la base de datos " + e.getMessage());
		}
	}
	
	public static void actualizarProveedor(String idProveedor, String rutProveedor, String nombre, String telefono) {
		
		try {
			String updateProveedor = "update proveedor "
					+ "set idProveedor = ?, rut = ?, nombre = ?, telefono = ? "
					+ "where idProveedor = ?";
			
			PreparedStatement pst = con.prepareStatement(updateProveedor);		
			
			pst.setString(1, idProveedor);
			pst.setString(2, rutProveedor);
			pst.setString(3, nombre);
			pst.setString(4, telefono);
			pst.setString(5, idProveedor);
			
			pst.execute();
			System.out.println("Se actualizó el proveedor correctamente en la base de datos");
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar el proveedor en la base de datos " + e.getMessage());
		}
	}

	public static void eliminarProveedor(String idProveedor) {
				
		try {
			String deleteProveedor = "delete from proveedor where idProveedor = " + idProveedor;
			Statement st = con.createStatement();
			
			int flag = st.executeUpdate(deleteProveedor);
			
			if(flag >= 0) System.out.println("Proveedor eliminado");
			
		} catch (SQLException e) {
			System.out.println("Error al eliminar el proveedor de la base de datos " + e.getMessage());
		}
	}
	// ----------------------------------------------------------------------------------------------------------------------------------------------------||

	// ------------------------------------------------------------CRUD Factura ------------------------------------------------------------------------->>
	public static void guardarFactura(String idFactura, String fecha, String cliente) {
						
		try {
			String insertFactura = "insert into factura (idFactura, fecha, precio, idCliente) "
								  + "values (?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(insertFactura);
			
			pst.setString(1, idFactura);
			pst.setString(2, fecha);
			pst.setString(3, null);
			pst.setString(4, cliente);
			
			pst.execute();
			System.out.println("Factura almacenada correctamente en la base de datos");
			
		} catch (SQLException e) {
			System.out.println("Error al almacenar la factura en la base de datos " + e.getMessage());
		}
	}

	public static void cargarDatosFactura(Papeleria papeleria) {
		Factura factura;
		Cliente clienteFactura = null;
		String selectFactura = "select * from factura";
		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(selectFactura);
			
			
			while(rs.next()) {
				
				for (Cliente cliente : papeleria.getListaClientes()) {
					if(cliente.getCedula().equalsIgnoreCase(rs.getString("idCliente")))
						clienteFactura = cliente;
				}
				factura = new Factura(rs.getString("idFactura"), rs.getString("fecha"), clienteFactura, clienteFactura.getCedula());
				papeleria.getListaFacturas().add(factura);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al cargar la factura de la base de datos " + e.getMessage());
		}
	}
	

	public static void eliminarFactura(String idFactura) {
				
		try {
			String deleteFactura = "delete from factura where idFactura = " + idFactura;
			Statement st = con.createStatement();
			
			int flag = st.executeUpdate(deleteFactura);
			
			if(flag >= 0) System.out.println("Factura eliminada");
			
		} catch (SQLException e) {
			System.out.println("Error al eliminar la factura de la base de datos " + e.getMessage());
		}
	}
	// ----------------------------------------------------------------------------------------------------------------------------------------------------||
	
	// ----------------------------------------------------- CARGAR DEMÁS DATOS DE LA BASE DE DATOS ------------------------------------------------------->>
	
	public static void cargarDatosEmpleados(Papeleria papeleria) {
		Empleado empleado;
		String selectEmpleado = "select * from empleado";
		TipoEmpleado tipoEmpleado;
		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(selectEmpleado);
			
			
			while(rs.next()) {
				
				tipoEmpleado = buscarTipoEmpleado(rs.getString("tipo")); 
				
				empleado = new Empleado(rs.getString("cedulaEmpleado"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("eps"), 
										rs.getString("titulo"), rs.getDouble("sueldo"), tipoEmpleado, rs.getString("direccion"),
										rs.getString("usuario"), rs.getString("contrasena"), rs.getBoolean("inicioSesion"));
				papeleria.getListaEmpleados().add(empleado);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al cargar los empleados de la base de datos " + e.getMessage());
		}
	}
	
	private static TipoEmpleado buscarTipoEmpleado(String tipoEmpleado) {
		TipoEmpleado tipoEmpleado2 = null;
		
		if(tipoEmpleado.equalsIgnoreCase(TipoEmpleado.CONTADOR.toString()))
			tipoEmpleado2 = TipoEmpleado.CONTADOR;
		else if(tipoEmpleado.equalsIgnoreCase(TipoEmpleado.DISENADOR.toString()))
			tipoEmpleado2 = TipoEmpleado.DISENADOR;
		else if(tipoEmpleado.equalsIgnoreCase(TipoEmpleado.JEFE_LITOGRAFIA.toString()))
			tipoEmpleado2 = TipoEmpleado.JEFE_LITOGRAFIA;
		else if(tipoEmpleado.equalsIgnoreCase(TipoEmpleado.SECRETARIA.toString()))
			tipoEmpleado2 = TipoEmpleado.SECRETARIA;
		
		return tipoEmpleado2;
	}
	
	public static void agregarDetalleFactura(String idFactura, ObservableList<Producto> listadoDetalleFactura, double valorFactura) {
		try {
			String updateFactura = "update factura "
								 + "set precio = " + valorFactura
								 + " where idFactura = " + idFactura;
			Statement st = con.createStatement();
			
			int flag = st.executeUpdate(updateFactura);
			
			if(flag >= 0) System.out.println("Factura actualizada");
			
			agregarFacturaProducto(idFactura, listadoDetalleFactura);
			
		} catch (SQLException e) {
			System.out.println("Error al actualizar la factura en la base de datos " + e.getMessage());
		}
		
	}

	private static void agregarFacturaProducto(String idFactura, ObservableList<Producto> listadoDetalleFactura) {
		
		for (Producto producto : listadoDetalleFactura) {
			
			String descripcion = "Producto " + producto.getTipo() + " con un valor de "  + producto.getPrecio() + " adquirido para la venta en la factura identificada con un id " + idFactura;
			
			try {
				// Habilitar la foreign_key
				Statement st = con.createStatement();
				String updateFacturaProducto = "set foreign_key_checks=0; ";
				int flag = st.executeUpdate(updateFacturaProducto);
				if(flag >= 0) System.out.println("foreign_key_checks!");
				
				String insertFacturaProducto = "insert into facturaproducto(Producto_idProducto, Factura_idFactura, descripcion) "
						+ "values (?, ?, ?)";
				
				PreparedStatement pst = con.prepareStatement(insertFacturaProducto);
				
				pst.setString(1, producto.getId());
				pst.setString(2, idFactura);
				pst.setString(3, descripcion);
								
				pst.execute();
				System.out.println("Factura producto almacenada correctamente en la base de datos");
				
			} catch (SQLException e) {
				System.out.println("Error al almacenar la factura del producto en la base de datos " + e.getMessage());
			}
		}
	}

	public static void cambiarEstadosesion(Empleado empleado, boolean sesionIniciada) {
			
		try {
			String updateEmpleado = "update empleado "
								 + "set inicioSesion = " + sesionIniciada
								 + " where cedulaEmpleado = " + empleado.getCedula();
			Statement st = con.createStatement();
			
			int flag = st.executeUpdate(updateEmpleado);
			
			if(flag >= 0) System.out.println("Sesión cambiada");
			
		} catch (SQLException e) {
			System.out.println("Error al guardar sesión de la base de datos " + e.getMessage());
		}
	}

	 // -------------------------------------------------------------- REPORTES -------------------------------------------------------------------------->>
	
	private static void cargarReporte(String nombreParametro, String valorParametro, String nombreArchivoJasper) {
		
		try {
			JasperReport reporte = null;
			File file = new File("src/resource/"+nombreArchivoJasper+".jasper");

			Map<String, Object> parametro = new HashMap<>();
			parametro.put(nombreParametro, valorParametro);
			
			// Cargando el archivo jasper
			reporte = (JasperReport) JRLoader.loadObject(file);

			// Generando la información del reporte
			JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, con);
			
			// Vista del reporte
			JasperViewer view = new JasperViewer(jprint, false);
			
			JFrame.setDefaultLookAndFeelDecorated(true);
			
			view.setVisible(true);
			
		} catch (JRException e) {
			System.out.println("Error al generar reporte " + e);
		} catch(Exception e) {
			System.out.println("Error " + e);			
		}
	}
	   
	public static void generarReporte1(String nombre) {	
		
		String filtro = "%"+ nombre +"%";
		cargarReporte("nombre", filtro, "ReporteSimple1");
	}

	public static void generarReporte2(String tipoEmpleado) {
		
		String filtroTipoEmpleado = tipo(tipoEmpleado);
		cargarReporte("tipo", filtroTipoEmpleado, "Reporte2");
	}

	private static String tipo(String tipoEmpleado) {
		String tipo = "";
		
		if(tipoEmpleado.equalsIgnoreCase("Jefe Litografía")) 
			tipo = "JEFE_LITOGRAFIA";
		else if(tipoEmpleado.equalsIgnoreCase("Diseñador"))
			tipo = "DISENADOR";
		else if(tipoEmpleado.equalsIgnoreCase("Secretario(a)"))
			tipo = "SECRETARIA";
		else if(tipoEmpleado.equalsIgnoreCase("Contador(a)"))
			tipo = "CONTADOR";
		
		return tipo;
	}

	public static void generarReporte3(String cedulaEmpleado) {
		cargarReporte("idEmpleado", cedulaEmpleado, "Reporte3");
	}

	public static void generarReporte4(String idProveedor) {
		cargarReporte("idProveedor", idProveedor, "Reporte4");
		
	}


}

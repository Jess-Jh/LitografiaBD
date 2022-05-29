package co.edu.uniquindio.litografia.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uniquindio.litografia.excepciones.ClienteException;
import co.edu.uniquindio.litografia.excepciones.ClienteNoRegistradoException;
import co.edu.uniquindio.litografia.excepciones.FacturaException;
import co.edu.uniquindio.litografia.excepciones.ProductoException;
import co.edu.uniquindio.litografia.excepciones.ProductoNoRegistradoException;
import co.edu.uniquindio.litografia.excepciones.ProveedorException;
import co.edu.uniquindio.litografia.excepciones.ProveedorNoRegistradoException;
import co.edu.uniquindio.litografia.persistencia.Persistencia;
import javafx.collections.ObservableList;

public class Papeleria {
	
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Devolucion> listaDevoluciones;
	private ArrayList<Diseno> listaDisenos;
	private ArrayList<Empleado> listaEmpleados;
	private ArrayList<EspecificacionDiseno> listaEspecificacionesDisenos;
	private ArrayList<EspecificacionLitografica> listaEspecificacionesLitograficas;
	private ArrayList<Factura> listaFacturas;
	private ArrayList<Litografia> listaLitografias;
	private ArrayList<MateriaPrima> listaMateriasPrimas;
	private ArrayList<Pedido> listaPedidos;
	private ArrayList<Producto> listaProductos;
	private ArrayList<Proveedor> listaProveedores;
	
	public Papeleria() {
		
		this.listaClientes = new ArrayList<>();
		this.listaDevoluciones = new ArrayList<>();
		this.listaDisenos = new ArrayList<>();
		this.listaEmpleados = new ArrayList<>();
		this.listaEspecificacionesDisenos = new ArrayList<>();
		this.listaEspecificacionesLitograficas = new ArrayList<>();
		this.listaFacturas = new ArrayList<>();
		this.listaLitografias = new ArrayList<>();
		this.listaMateriasPrimas = new ArrayList<>();
		this.listaPedidos = new ArrayList<>();
		this.listaProductos = new ArrayList<>();
		this.listaProveedores = new ArrayList<>();
		
		Empleado empleado = new Empleado("12343", "Luis", "Martinez", "Salud", "Diseñador", 1600000, TipoEmpleado.DISENADORA, "Cra 18 #34-25", "lumar", "123", true);
		getListaEmpleados().add(empleado);
		
		Empleado empleado1 = new Empleado("12343", "Andrea", "Fajardo", "Salud", "Diseñador", 1600000, TipoEmpleado.DISENADORA, "Cra 18 #34-25", "anfa", "456", false);
		getListaEmpleados().add(empleado1);
		
		Cliente cliente = new Cliente("2141243", "241243", "sdfasdfsaf", "sfasdfasf", "sdfasfdasf");
		getListaClientes().add(cliente);
		
		Producto producto = new Producto("2", "Diseño", 200);
		getListaProductos().add(producto);
		
		Factura factura = new Factura("3", "2022-05-19", cliente, "1234");
		getListaFacturas().add(factura);
	}
	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public ArrayList<Devolucion> getListaDevoluciones() {
		return listaDevoluciones;
	}
	public void setListaDevoluciones(ArrayList<Devolucion> listaDevoluciones) {
		this.listaDevoluciones = listaDevoluciones;
	}
	public ArrayList<Diseno> getListaDisenos() {
		return listaDisenos;
	}
	public void setListaDisenos(ArrayList<Diseno> listaDisenos) {
		this.listaDisenos = listaDisenos;
	}
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	public ArrayList<EspecificacionDiseno> getListaEspecificacionesDisenos() {
		return listaEspecificacionesDisenos;
	}
	public void setListaEspecificacionesDisenos(ArrayList<EspecificacionDiseno> listaEspecificacionesDisenos) {
		this.listaEspecificacionesDisenos = listaEspecificacionesDisenos;
	}
	public ArrayList<EspecificacionLitografica> getListaEspecificacionesLitograficas() {
		return listaEspecificacionesLitograficas;
	}
	public void setListaEspecificacionesLitograficas(
			ArrayList<EspecificacionLitografica> listaEspecificacionesLitograficas) {
		this.listaEspecificacionesLitograficas = listaEspecificacionesLitograficas;
	}
	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}
	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	public ArrayList<Litografia> getListaLitografias() {
		return listaLitografias;
	}
	public void setListaLitografias(ArrayList<Litografia> listaLitografias) {
		this.listaLitografias = listaLitografias;
	}
	public ArrayList<MateriaPrima> getListaMateriasPrimas() {
		return listaMateriasPrimas;
	}
	public void setListaMateriasPrimas(ArrayList<MateriaPrima> listaMateriasPrimas) {
		this.listaMateriasPrimas = listaMateriasPrimas;
	}
	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public ArrayList<Proveedor> getListaProveedores() {
		return listaProveedores;
	}
	public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	// ------------------------------------------------------------CRUD Cliente ------------------------------------------------------------->>
	
	public Cliente agregarCliente(String cedula, String nombre, String apellido, String telefono, String correoElectronico) throws ClienteException {
		if(existeCliente(cedula)) {
			throw new ClienteException("El cliente con cédula " + cedula + " ya se encuentra registrado");
		} else {
			Cliente nuevoCliente = new Cliente(cedula, nombre, apellido, telefono, correoElectronico);
			listaClientes.add(nuevoCliente);
			return nuevoCliente;
		}
	}
	
	private boolean existeCliente(String id) {
		for(Cliente cliente : listaClientes) {
			if(cliente.getCedula().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}

	public Cliente obtenerCliente(String idCliente) {
		for (Cliente cliente : listaClientes) {
			if(cliente.getCedula().equalsIgnoreCase(idCliente)) 
				return cliente;
		}
		return null;
	}

	public Cliente actualizarCliente(String cedula, String nombre, String apellido, String telefono,
			String correoElectronico) throws ClienteNoRegistradoException {
		
		Cliente cliente = obtenerCliente(cedula);
		
		if(cliente != null) {
			cliente.setCedula(cedula);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setTelefono(telefono);
			cliente.setCorreoElectronico(correoElectronico);

			return cliente;
		} else {
			throw new ClienteNoRegistradoException("El cliente al que le desea actualizar los datos no se encuentra registrado");
		}
	}

	public boolean eliminarCliente(String cedula) {
		
		boolean clienteEliminado = false;
		Cliente cliente = obtenerCliente(cedula);
		
		if(cliente != null) {
			getListaClientes().remove(cliente);
			clienteEliminado = true;
		}
		return clienteEliminado;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------------------||
	
	// ------------------------------------------------------------CRUD Producto ------------------------------------------------------------------------>>

	public Producto agregarProducto(String id, String tipo, String precio) throws ProductoException {
		
		double precioProducto = Double.valueOf(precio);
		if(existeProducto(id)) {
			throw new ProductoException("El producto con id " + id + " ya se encuentra registrado");
		} else {
			Producto producto = new Producto(id, tipo, precioProducto);
			listaProductos.add(producto);
			return producto;
		}
	}
	
	private boolean existeProducto(String id) {
		for(Producto producto: listaProductos) {
			if(producto.getId().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}

	public Producto actualizarProducto(String id, String tipo, String precio) throws ProductoNoRegistradoException {
		Producto producto = obtenerProducto(id);
		double precioProducto = Double.valueOf(precio);
		
		if(producto != null) {
			producto.setId(id);
			producto.setTipo(tipo);
			producto.setPrecio(precioProducto);

			return producto;
		} else {
			throw new ProductoNoRegistradoException("El producto al que le desea actualizar los datos no se encuentra registrado");
		}
	}
	
	public Producto obtenerProducto(String id) {
		for (Producto producto : listaProductos) {
			if(producto.getId().equalsIgnoreCase(id)) 
				return producto;
		}
		return null;
	}

	public boolean eliminarProducto(String id) {
		boolean productoEliminado = false;
		Producto producto = obtenerProducto(id);
		
		if(producto != null) {
			getListaProductos().remove(producto);
			productoEliminado = true;
		}
		return productoEliminado;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------------------||
	
	// ------------------------------------------------------------CRUD Proveedor ------------------------------------------------------------------------>>

	public Proveedor agregarProveedor(String id, String rutProveedor, String nombre, String telefono) throws ProveedorException {
		if(existeProveedor(id)) {
			throw new ProveedorException("El proveedor con id " + id + " ya se encuentra registrado");
		} else {
			Proveedor proveedor = new Proveedor(id, rutProveedor, nombre, telefono);
			listaProveedores.add(proveedor);
			return proveedor;
		}
	}
	
	private boolean existeProveedor(String id) {
		for(Proveedor proveedor: listaProveedores) {
			if(proveedor.getId().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}

	public Proveedor actualizarProveedor(String id, String rutProveedor, String nombre, String telefono) throws ProveedorNoRegistradoException {
		Proveedor proveedor = obtenerProveedor(id);
		
		if(proveedor != null) {
			proveedor.setId(id);
			proveedor.setRUT(rutProveedor);
			proveedor.setNombre(nombre);
			proveedor.setTelefono(telefono);

			return proveedor;
		} else {
			throw new ProveedorNoRegistradoException("El proveedor al que le desea actualizar los datos no se encuentra registrado");
		}
	}
	
	public Proveedor obtenerProveedor(String id) {
		for (Proveedor proveedor : listaProveedores) {
			if(proveedor.getId().equalsIgnoreCase(id)) 
				return proveedor;
		}
		return null;
	}

	public boolean eliminarProveedor(String id) {
		boolean proveedorEliminado = false;
		Proveedor proveedor = obtenerProveedor(id);
		
		if(proveedor != null) {
			getListaProveedores().remove(proveedor);
			proveedorEliminado = true;
		}
		return proveedorEliminado;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------------------||
	
	// ------------------------------------------------------------CRUD Factura ------------------------------------------------------------------------>>

	public Factura agregarFactura(String id, String fecha, String cliente) throws FacturaException {
		if(existeFactura(id)) {
			throw new FacturaException("La factura con id " + id + " ya se encuentra registrada");
		} else {
			Cliente clienteFactura = null;
			for (Cliente c : listaClientes) {
				if(c.getCedula().equalsIgnoreCase(cliente))
					clienteFactura = c;
			}
			
			Factura factura = new Factura(id, fecha, clienteFactura, clienteFactura.getCedula());
			listaFacturas.add(factura);
			return factura;
		}
	}
	
	private boolean existeFactura(String id) {
		for(Factura factura: listaFacturas) {
			if(factura.getId().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}
	
	public Factura obtenerFactura(String id) {
		for (Factura factura : listaFacturas) {
			if(factura.getId().equalsIgnoreCase(id)) 
				return factura;
		}
		return null;
	}

	public boolean eliminarFactura(String id) {
		boolean facturaEliminado = false;
		Factura factura = obtenerFactura(id);
		
		if(factura != null) {
			getListaFacturas().remove(factura);
			facturaEliminado = true;
		}
		return facturaEliminado;
	}

	public Factura agregarDetalleFactura(String idFactura, ObservableList<Producto> listadoDetalleFactura, double valorFactura) {
		Factura facturaSeleccionada = null;
		for (Factura factura : listaFacturas) {
			if(factura.getId().equalsIgnoreCase(idFactura)) {
				facturaSeleccionada = factura;
				
				facturaSeleccionada.getListaProductos().addAll(listadoDetalleFactura);
				facturaSeleccionada.setPrecio(valorFactura);
			}
		}
		return facturaSeleccionada;
	}
	// -------------------------------------------------------------------------------------------------------------------------------||
	
	public Empleado confirmarInicioSesion(String usuario, String contrasena, boolean sesionIniciada) {
		
		for (Empleado empleado : listaEmpleados) {
			if(empleado.getUsuario().equals(usuario) && empleado.getContrasena().equals(contrasena)) {
				empleado.setInicioSesion(sesionIniciada);
				return empleado;
			}
		}
		return null;
	}

	public boolean cerrarSesionUsuario() {
		for (Empleado empleado : listaEmpleados) {
			if(empleado.isInicioSesion() == true) {
				empleado.setInicioSesion(false);
				Persistencia.cambiarEstadosesion(empleado, false);
				return true;
			}
		}
		return false;
	}	

}

package co.edu.uniquindio.litografia.modelo;

import java.util.ArrayList;

import co.edu.uniquindio.litografia.excepciones.ClienteException;
import co.edu.uniquindio.litografia.excepciones.ClienteNoRegistradoException;

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
		
		Cliente cliente = new Cliente("2141243", "241243", "sdfasdfsaf", "sfasdfasf", "sdfasfdasf");
		getListaClientes().add(cliente);
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
			throw new ClienteNoRegistradoException("El cliente que al que le desea actualizar los datos no se encuentra registrado");
		}
	}

	public boolean eliminarCliente(String cedula) {
		
		Boolean clienteEliminado = false;
		Cliente cliente = obtenerCliente(cedula);
		
		if(cliente != null) {
			getListaClientes().remove(cliente);
			clienteEliminado = true;
		}
		return clienteEliminado;
	}
	
	// --------------------------------------------------------------------------------------------------------------------------------------------------||
	
	

}

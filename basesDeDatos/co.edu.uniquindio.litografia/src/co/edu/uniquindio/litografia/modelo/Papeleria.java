package co.edu.uniquindio.litografia.modelo;

import java.util.ArrayList;

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
	
	public Papeleria(ArrayList<Cliente> listaClientes, ArrayList<Devolucion> listaDevoluciones,
			ArrayList<Diseno> listaDisenos, ArrayList<Empleado> listaEmpleados,
			ArrayList<EspecificacionDiseno> listaEspecificacionesDisenos,
			ArrayList<EspecificacionLitografica> listaEspecificacionesLitograficas, ArrayList<Factura> listaFacturas,
			ArrayList<Litografia> listaLitografias, ArrayList<MateriaPrima> listaMateriasPrimas,
			ArrayList<Pedido> listaPedidos, ArrayList<Producto> listaProductos, ArrayList<Proveedor> listaProveedores) {
		
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

	public Cliente agregarCliente() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

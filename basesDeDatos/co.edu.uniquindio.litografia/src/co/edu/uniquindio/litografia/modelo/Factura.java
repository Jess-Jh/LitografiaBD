package co.edu.uniquindio.litografia.modelo;

import java.util.ArrayList;

public class Factura {
	
	private String id;
	private String fecha;
	private double precio;
	private Cliente cliente;
	private String cedulaCliente;
	private ArrayList<Producto> listaProductos;
	private ArrayList<Diseno> listaDisenos;
	private ArrayList<Litografia> listaLitografias;
	private ArrayList<Empleado> listaEmpleados;
	
	public Factura(String id, String fecha, Cliente cliente, String cedulaCliente) {
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.cedulaCliente = cliente.getCedula();
		this.listaProductos = new ArrayList<>();
		this.listaDisenos = new ArrayList<>();
		this.listaLitografias = new ArrayList<>();
		this.listaEmpleados = new ArrayList<>();

	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public ArrayList<Diseno> getListadiDisenos() {
		return listaDisenos;
	}
	public void setListadiDisenos(ArrayList<Diseno> listadiDisenos) {
		this.listaDisenos = listadiDisenos;
	}
	public ArrayList<Litografia> getListalLitografias() {
		return listaLitografias;
	}
	public void setListalLitografias(ArrayList<Litografia> listalLitografias) {
		this.listaLitografias = listalLitografias;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	public ArrayList<Diseno> getListaDisenos() {
		return listaDisenos;
	}
	public void setListaDisenos(ArrayList<Diseno> listaDisenos) {
		this.listaDisenos = listaDisenos;
	}
	public ArrayList<Litografia> getListaLitografias() {
		return listaLitografias;
	}
	public void setListaLitografias(ArrayList<Litografia> listaLitografias) {
		this.listaLitografias = listaLitografias;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	
	
	
	
	
	

}

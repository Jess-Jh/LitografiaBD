package co.edu.uniquindio.litografia.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {
	
	private String id;
	private LocalDate fecha;
	private double precio;
	private ArrayList<Producto> listaProductos;
	private ArrayList<Diseno> listaDisenos;
	private ArrayList<Litografia> listaLitografias;
	private Cliente cliente;
	private ArrayList<Empleado> listaEmpleados;
	
	public Factura(String id, LocalDate fecha, double precio, ArrayList<Producto> listaProductos,
			ArrayList<Diseno> listadiDisenos, ArrayList<Litografia> listalLitografias, Cliente cliente,
			ArrayList<Empleado> listaEmpleados) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.precio = precio;
		this.listaProductos = new ArrayList<>();
		this.listaDisenos = new ArrayList<>();
		this.listaLitografias = new ArrayList<>();
		this.cliente = cliente;
		this.listaEmpleados = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
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
	
	
	
	
	
	

}

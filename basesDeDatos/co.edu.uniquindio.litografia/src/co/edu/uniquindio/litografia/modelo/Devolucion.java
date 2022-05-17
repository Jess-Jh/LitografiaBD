package co.edu.uniquindio.litografia.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Devolucion {
	
	private String id;
	private LocalDate fecha;
	private String descripcion;
	private String tipo;
	private Empleado empleado;
	private ArrayList<Pedido> pedido;
	private ArrayList<MateriaPrima> materiaPrima;
	private int cantidad;
	
	public Devolucion(String id, LocalDate fecha, String descripcion, String tipo, Empleado empleado,
			ArrayList<Pedido> pedido, ArrayList<MateriaPrima> materiaPrima, int cantidad) {
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.empleado = empleado;
		this.pedido = new ArrayList<>();
		this.materiaPrima = new ArrayList<>();
		this.cantidad = cantidad;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ArrayList<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(ArrayList<Pedido> pedido) {
		this.pedido = pedido;
	}
	public ArrayList<MateriaPrima> getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(ArrayList<MateriaPrima> materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

}

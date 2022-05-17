package co.edu.uniquindio.litografia.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
	
	private String tipo;
	private LocalDate fecha;
	private double precio;
	private Empleado empleado;
	private ArrayList<MateriaPrima> listaMateriasPrimas;
	
	public Pedido(String tipo, LocalDate fecha, double precio, Empleado empleado,
			ArrayList<MateriaPrima> listaMateriasPrimas) {
		this.tipo = tipo;
		this.fecha = fecha;
		this.precio = precio;
		this.empleado = empleado;
		this.listaMateriasPrimas = new ArrayList<>();
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public ArrayList<MateriaPrima> getListaMateriasPrimas() {
		return listaMateriasPrimas;
	}
	public void setListaMateriasPrimas(ArrayList<MateriaPrima> listaMateriasPrimas) {
		this.listaMateriasPrimas = listaMateriasPrimas;
	}
	

}

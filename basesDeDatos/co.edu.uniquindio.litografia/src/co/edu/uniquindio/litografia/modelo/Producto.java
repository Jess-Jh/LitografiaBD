package co.edu.uniquindio.litografia.modelo;

import java.util.ArrayList;

public class Producto {
	
	private String id;
	private String tipo;
	private double precio;
	private ArrayList<Factura> listaFacturas;

	public Producto(String id, String tipo, double precio) {
		this.id = id;
		this.tipo = tipo;
		this.precio = precio;
		this.listaFacturas = new ArrayList<>();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}
	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	
	
	
	
	

}

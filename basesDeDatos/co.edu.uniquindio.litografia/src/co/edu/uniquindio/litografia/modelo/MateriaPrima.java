package co.edu.uniquindio.litografia.modelo;

import java.util.ArrayList;

public class MateriaPrima {
	
	private String id;
	private String tipo;
	private int cantidad;
	private String descripcion;
	private ArrayList<Proveedor> listaProveedores;
	private ArrayList<Pedido> listaPedidos;
	
	public MateriaPrima(String id, String tipo, int cantidad, String descripcion, ArrayList<Proveedor> listaProveedores,
			ArrayList<Pedido> listaPedidos) {
		this.id = id;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.listaProveedores = new ArrayList<>();
		this.listaPedidos = new ArrayList<>();
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ArrayList<Proveedor> getListaProveedores() {
		return listaProveedores;
	}
	public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}
	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	

}

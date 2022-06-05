package co.edu.uniquindio.litografia.modelo;

import java.util.ArrayList;

public class Diseno {
	
	private String id;
	private String tipo;
	private String tamano;
	private ArrayList<Factura> listaFacturas;
	private ArrayList<EspecificacionDiseno> listaEspecificacionDisenos;
	
	public Diseno(String id, String tipo, String tamano) {
		this.id = id;
		this.tipo = tipo;
		this.tamano = tamano;
		this.listaFacturas = new ArrayList<>();
		this.listaEspecificacionDisenos = new ArrayList<>();
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
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}
	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	public ArrayList<EspecificacionDiseno> getListaEspecificacionDisenos() {
		return listaEspecificacionDisenos;
	}
	public void setListaEspecificacionDisenos(ArrayList<EspecificacionDiseno> listaEspecificacionDisenos) {
		this.listaEspecificacionDisenos = listaEspecificacionDisenos;
	}
	

}

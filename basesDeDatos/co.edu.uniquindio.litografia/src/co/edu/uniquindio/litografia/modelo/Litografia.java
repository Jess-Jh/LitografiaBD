package co.edu.uniquindio.litografia.modelo;

import java.util.ArrayList;

public class Litografia {
	
	private String id;
	private String tipoTroquelado;
	private boolean barnizado;
	private String tamano;
	private String tipoPapel;
	private ArrayList<EspecificacionLitografica> listaEspecificacionLitograficas;
	private ArrayList<Factura> listaFacturas;
	
	public Litografia(String id, String tipoTroquelado, boolean barnizado, String tamano, String tipoPapel,
			ArrayList<EspecificacionLitografica> especificacionLitograficas, ArrayList<Factura> listaFacturas) {
		this.id = id;
		this.tipoTroquelado = tipoTroquelado;
		this.barnizado = barnizado;
		this.tamano = tamano;
		this.tipoPapel = tipoPapel;
		this.listaEspecificacionLitograficas = new ArrayList<>();
		this.listaFacturas = new ArrayList<>();
	}
	
	public ArrayList<EspecificacionLitografica> getListaEspecificacionLitograficas() {
		return listaEspecificacionLitograficas;
	}
	public void setListaEspecificacionLitograficas(ArrayList<EspecificacionLitografica> listaEspecificacionLitograficas) {
		this.listaEspecificacionLitograficas = listaEspecificacionLitograficas;
	}
	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}
	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipoTroquelado() {
		return tipoTroquelado;
	}
	public void setTipoTroquelado(String tipoTroquelado) {
		this.tipoTroquelado = tipoTroquelado;
	}
	public boolean isBarnizado() {
		return barnizado;
	}
	public void setBarnizado(boolean barnizado) {
		this.barnizado = barnizado;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public String getTipoPapel() {
		return tipoPapel;
	}
	public void setTipoPapel(String tipoPapel) {
		this.tipoPapel = tipoPapel;
	}
	

}

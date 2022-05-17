package co.edu.uniquindio.litografia.modelo;

import java.util.ArrayList;

public class Cliente {
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correoElectronico;
	private ArrayList<Factura> listaFacturas;
	private ArrayList<EspecificacionDiseno> listaEspecificacionDisenos;
	private ArrayList<EspecificacionLitografica> listaEspecificacionLitograficas;
	
	public Cliente(String cedula, String nombre, String apellido, String telefono, String correoElectronico,
			ArrayList<Factura> listaFacturas, ArrayList<EspecificacionDiseno> listaEspecificacionDisenos,
			ArrayList<EspecificacionLitografica> listaEspecificacionLitograficas) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.listaFacturas = new ArrayList<>();
		this.listaEspecificacionDisenos = new ArrayList<>();
		this.listaEspecificacionLitograficas = new ArrayList<>();
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
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
	public ArrayList<EspecificacionLitografica> getListaEspecificacionLitograficas() {
		return listaEspecificacionLitograficas;
	}
	public void setListaEspecificacionLitograficas(ArrayList<EspecificacionLitografica> listaEspecificacionLitograficas) {
		this.listaEspecificacionLitograficas = listaEspecificacionLitograficas;
	} 
	
	
	

}

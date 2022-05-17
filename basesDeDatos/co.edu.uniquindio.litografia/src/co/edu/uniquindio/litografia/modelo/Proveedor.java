package co.edu.uniquindio.litografia.modelo;

import java.util.ArrayList;

public class Proveedor {
	
	private String RUT;
	private String id;
	private String nombre;
	private String telefono;
	private ArrayList<MateriaPrima> listaMateriasPrimas;
	
	public Proveedor(String rUT, String id, String nombre, String telefono,
			ArrayList<MateriaPrima> listaMateriasPrimas) {
		RUT = rUT;
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.listaMateriasPrimas = new ArrayList<>();
	}
	
	public String getRUT() {
		return RUT;
	}
	public void setRUT(String rUT) {
		RUT = rUT;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public ArrayList<MateriaPrima> getListaMateriasPrimas() {
		return listaMateriasPrimas;
	}
	public void setListaMateriasPrimas(ArrayList<MateriaPrima> listaMateriasPrimas) {
		this.listaMateriasPrimas = listaMateriasPrimas;
	}
	
	

}

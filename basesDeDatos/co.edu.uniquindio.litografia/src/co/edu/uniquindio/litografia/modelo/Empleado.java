package co.edu.uniquindio.litografia.modelo;

import java.util.ArrayList;

public class Empleado {
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String eps;
	private String titulo;
	private double sueldo;
	private TipoEmpleado tipo;
	private String direccion;
	private String usuario;
	private String contrasena;
	private boolean inicioSesion = false;
	private ArrayList<EspecificacionLitografica>listaEspecificacionLitograficas;
	private ArrayList<EspecificacionDiseno> listaEspecificacionDisenos;
	private ArrayList<Factura> listaFacturas;
	private ArrayList<Pedido> listaPedidos;
	private ArrayList<Devolucion> listaDevoluciones;
	
	public Empleado(String cedula, String nombre, String apellido, String eps, String titulo, double sueldo, TipoEmpleado tipo, String direccion, String usuario, 
			String contrasena, boolean inicioSesion, ArrayList<EspecificacionLitografica> listaEspecificacionLitograficas, ArrayList<EspecificacionDiseno> listaEspecificacionDisenos, 
			ArrayList<Factura> listaFacturas, ArrayList<Pedido> listaPedidos, ArrayList<Devolucion> listaDevoluciones) {
		
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eps = eps;
		this.titulo = titulo;
		this.sueldo = sueldo;
		this.tipo = tipo;
		this.direccion = direccion;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.inicioSesion = inicioSesion;
		this.listaEspecificacionLitograficas = listaEspecificacionLitograficas;
		this.listaEspecificacionDisenos = listaEspecificacionDisenos;
		this.listaFacturas = listaFacturas;
		this.listaPedidos = listaPedidos;
		this.listaDevoluciones = listaDevoluciones;
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
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public TipoEmpleado getTipo() {
		return tipo;
	}
	public void setTipo(TipoEmpleado tipo) {
		this.tipo = tipo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public boolean isInicioSesion() {
		return inicioSesion;
	}
	public void setInicioSesion(boolean inicioSesion) {
		this.inicioSesion = inicioSesion;
	}
	public ArrayList<EspecificacionLitografica> getListaEspecificacionLitograficas() {
		return listaEspecificacionLitograficas;
	}
	public void setListaEspecificacionLitograficas(ArrayList<EspecificacionLitografica> listaEspecificacionLitograficas) {
		this.listaEspecificacionLitograficas = listaEspecificacionLitograficas;
	}
	public ArrayList<EspecificacionDiseno> getListaEspecificacionDisenos() {
		return listaEspecificacionDisenos;
	}
	public void setListaEspecificacionDisenos(ArrayList<EspecificacionDiseno> listaEspecificacionDisenos) {
		this.listaEspecificacionDisenos = listaEspecificacionDisenos;
	}
	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}
	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	public ArrayList<Devolucion> getListaDevoluciones() {
		return listaDevoluciones;
	}
	public void setListaDevoluciones(ArrayList<Devolucion> listaDevoluciones) {
		this.listaDevoluciones = listaDevoluciones;
	}

	
	

}

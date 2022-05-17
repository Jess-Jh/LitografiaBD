package co.edu.uniquindio.litografia.modelo;

public class EspecificacionDiseno {
	
	private String id;
	private String tamano;
	private String tipo;
	private String descripcion;
	private Empleado empleado;
	private Cliente cliente;
	private Diseno diseno;
	
	public EspecificacionDiseno(String id, String tamano, String tipo, String descripcion, Empleado empleado,
			Cliente cliente, Diseno diseno) {
		this.id = id;
		this.tamano = tamano;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.empleado = empleado;
		this.cliente = cliente;
		this.diseno = diseno;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Diseno getDiseno() {
		return diseno;
	}
	public void setDiseno(Diseno diseno) {
		this.diseno = diseno;
	}
	
	
	

}

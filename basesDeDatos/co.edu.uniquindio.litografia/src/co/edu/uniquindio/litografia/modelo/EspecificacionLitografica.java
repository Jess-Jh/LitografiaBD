package co.edu.uniquindio.litografia.modelo;

public class EspecificacionLitografica {

	private String id;
	private String tamano;
	private String tipoPapel;
	private Litografia litografia;
	private Cliente cliente;
	private Empleado empleado;
	
	public EspecificacionLitografica(String id, String tamano, String tipoPapel, Litografia litografia, Cliente cliente,
			Empleado empleado) {
		this.id = id;
		this.tamano = tamano;
		this.tipoPapel = tipoPapel;
		this.litografia = litografia;
		this.cliente = cliente;
		this.empleado = empleado;
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
	public String getTipoPapel() {
		return tipoPapel;
	}
	public void setTipoPapel(String tipoPapel) {
		this.tipoPapel = tipoPapel;
	}
	public Litografia getLitografia() {
		return litografia;
	}
	public void setLitografia(Litografia litografia) {
		this.litografia = litografia;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
}

package co.edu.uniquindio.litografia.excepciones;

public class ProveedorNoRegistradoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ProveedorNoRegistradoException(String mensaje) {
		super(mensaje);
	}

}

package co.edu.uniquindio.litografia.excepciones;

public class ProductoNoRegistradoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ProductoNoRegistradoException(String mensaje) {
		super(mensaje);
	}

}

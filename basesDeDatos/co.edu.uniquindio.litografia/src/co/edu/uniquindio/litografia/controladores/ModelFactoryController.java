package co.edu.uniquindio.litografia.controladores;

import co.edu.uniquindio.litografia.aplicacion.PapeleriaAplicacion;
import co.edu.uniquindio.litografia.excepciones.ClienteException;
import co.edu.uniquindio.litografia.excepciones.ClienteNoRegistradoException;
import co.edu.uniquindio.litografia.modelo.Cliente;
import co.edu.uniquindio.litografia.modelo.Papeleria;

public class ModelFactoryController implements Runnable {

	Papeleria papeleria;
	PapeleriaAplicacion papeleriaAplicacion;
	
	private static class singletonHolder {
		//El contructor del singleton puede ser llamado desde aquí al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}
	
	//Método para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return singletonHolder.eINSTANCE;
	}
	
	public ModelFactoryController() {
		inicializarDatos();
	}
	
	private void inicializarDatos() {
		papeleria = new Papeleria();
	}

	@Override
	public void run() {
		
	}
	
	public Papeleria getPapeleria() {
		return papeleria;
	}

	public void setPapeleria(Papeleria papeleria) {
		this.papeleria = papeleria;
	}
	
	// ------------------------------------------------------------CRUD Cliente ------------------------------------------------------------->>
	
	public Cliente agregarCliente(String cedula, String nombre, String apellido, String telefono, String correoElectronico) throws ClienteException {
		Cliente cliente = papeleria.agregarCliente(cedula, nombre, apellido, telefono, correoElectronico);
		return cliente;
	}

	public Cliente consultarCliente(String idCliente) throws ClienteNoRegistradoException {
		Cliente cliente = papeleria.obtenerCliente(idCliente);
		
		if(cliente == null) throw new ClienteNoRegistradoException("El cliente no se encuentra registrado");
		return cliente;
	}

	public Cliente actualizarCliente(String cedula, String nombre, String apellido, String telefono,
			String correoElectronico) throws ClienteNoRegistradoException {
		Cliente cliente = papeleria.actualizarCliente(cedula, nombre, apellido, telefono, correoElectronico);
		
		return cliente;
	}

	public boolean eliminarCliente(String cedula) {
		
		if(papeleria.eliminarCliente(cedula)) return true;
		return false;	
		
	}

}

package co.edu.uniquindio.litografia.controladores;

import co.edu.uniquindio.litografia.aplicacion.PapeleriaAplicacion;
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
	
	public Cliente agregarCliente(String cedula, String nombre, String apellido, String telefono, String correoElectronico) {
		
		Cliente cliente = papeleria.agregarCliente();
		return cliente;
	}

}

package co.edu.uniquindio.litografia.controladores;

import java.time.LocalDate;

import co.edu.uniquindio.litografia.aplicacion.PapeleriaAplicacion;
import co.edu.uniquindio.litografia.excepciones.ClienteException;
import co.edu.uniquindio.litografia.excepciones.ClienteNoRegistradoException;
import co.edu.uniquindio.litografia.excepciones.FacturaException;
import co.edu.uniquindio.litografia.excepciones.ProductoException;
import co.edu.uniquindio.litografia.excepciones.ProductoNoRegistradoException;
import co.edu.uniquindio.litografia.excepciones.ProveedorException;
import co.edu.uniquindio.litografia.excepciones.ProveedorNoRegistradoException;
import co.edu.uniquindio.litografia.modelo.Cliente;
import co.edu.uniquindio.litografia.modelo.Factura;
import co.edu.uniquindio.litografia.modelo.Papeleria;
import co.edu.uniquindio.litografia.modelo.Producto;
import co.edu.uniquindio.litografia.modelo.Proveedor;

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
	
	// ----------------------------------------------------------------------------------------------------------------------------------------------------||
	
	// ----------------------------------------------------------------CRUD Producto ---------------------------------------------------------------------->>

	public Producto agregarProducto(String id, String tipo, String precio) throws ProductoException {
		Producto producto = papeleria.agregarProducto(id, tipo, precio);
		return producto;
	}

	public Producto actualizarProducto(String id, String tipo, String precio) throws ProductoNoRegistradoException {
		Producto producto = papeleria.actualizarProducto(id, tipo, precio);
		return producto;
	}

	public Producto consultarProducto(String idProducto) throws ProductoNoRegistradoException {
		Producto producto = papeleria.obtenerProducto(idProducto);
		
		if(producto == null) throw new ProductoNoRegistradoException("El producto no se encuentra registrado");
		return producto;
	}

	public boolean eliminarProducto(String id) {
		if(papeleria.eliminarProducto(id)) return true;
		return false;
	}
	// ----------------------------------------------------------------------------------------------------------------------------------------------------||
	
	// ----------------------------------------------------------------CRUD Proveedor ---------------------------------------------------------------------->>

	public Proveedor agregarProveedor(String rutProveedor, String id, String nombre, String telefono) throws ProveedorException {
		Proveedor proveedor = papeleria.agregarProveedor(rutProveedor, id, nombre, telefono);
		return proveedor;
	}

	public Proveedor actualizarProveedor(String rutProveedor, String id, String nombre, String telefono) throws ProveedorNoRegistradoException {
		Proveedor proveedor = papeleria.actualizarProveedor(rutProveedor, id, nombre, telefono);
		return proveedor;
	}

	public Proveedor consultarProveedor(String idProveedor) throws ProveedorNoRegistradoException {
		Proveedor proveedor = papeleria.obtenerProveedor(idProveedor);
		
		if(proveedor == null) throw new ProveedorNoRegistradoException("El proveedor no se encuentra registrado");
		return proveedor;
	}

	public boolean eliminarProveedor(String id) {
		if(papeleria.eliminarProveedor(id)) return true;
		return false;
	}
	
	// ----------------------------------------------------------------------------------------------------------------------------------------------------||
	
	// ----------------------------------------------------------------CRUD Factura ---------------------------------------------------------------------->>

	public Factura agregarFactura(String id, LocalDate fecha, String cliente) throws FacturaException {
		Factura factura = papeleria.agregarFactura(id, fecha, cliente);
		return factura;
	}

	public boolean eliminarFactura(String id) {
		if(papeleria.eliminarFactura(id)) return true;
		return false;
	}

}

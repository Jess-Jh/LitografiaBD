package co.edu.uniquindio.litografia.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.litografia.aplicacion.PapeleriaAplicacion;
import co.edu.uniquindio.litografia.excepciones.ClienteException;
import co.edu.uniquindio.litografia.excepciones.ClienteNoRegistradoException;
import co.edu.uniquindio.litografia.excepciones.DatosInvalidosException;
import co.edu.uniquindio.litografia.modelo.Cliente;
import co.edu.uniquindio.litografia.modelo.Factura;
import co.edu.uniquindio.litografia.modelo.Papeleria;
import co.edu.uniquindio.litografia.modelo.Producto;
import co.edu.uniquindio.litografia.modelo.Proveedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LitografiaController implements Initializable {
	
	//-------SINGLETON------------------------------------------------------>
	
	ModelFactoryController modelFactoryController;
	Papeleria papeleria;
	
	public LitografiaController() {
		modelFactoryController = ModelFactoryController.getInstance();
		papeleria = modelFactoryController.getPapeleria();
	}

	public Papeleria getPapeleria() {
		return papeleria;
	}
	public void setPapeleria(Papeleria papeleria) {
		this.papeleria = papeleria;
	}
	//--------------------------------------------------------------------||

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private Button btnActualizarProducto;

    @FXML
    private Button btnActualizarProveedor;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private Button btnAgregarProductoDetalle;

    @FXML
    private Button btnAgregarProveeodor;

    @FXML
    private Button btnConsultarCliente;

    @FXML
    private Button btnConsultarProducto;

    @FXML
    private Button btnConsultarProveedor;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Button btnEliminarDetalleFactura;

    @FXML
    private Button btnEliminarFactura;

    @FXML
    private Button btnEliminarProducto;

    @FXML
    private Button btnEliminarProveedor;

    @FXML
    private Button btnGuardarFactura;

    @FXML
    private Button btnPagoFactura;

    @FXML
    private ComboBox<String> cmbClienteFactura;
    ObservableList<String> listaCmbClientes = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Cliente, String> columnApellidoCliente;

    @FXML
    private TableColumn<Producto, String> columnCantidadDetalleFactura;

    @FXML
    private TableColumn<Cliente, String> columnCedulaCliente;

    @FXML
    private TableColumn<Factura, Cliente> columnClienteFactura;

    @FXML
    private TableColumn<Factura, String> columnFechaFactura;

    @FXML
    private TableColumn<Factura, String> columnIdFactura;

    @FXML
    private TableColumn<Producto, String> columnIdProducto;

    @FXML
    private TableColumn<Producto, String> columnIdProducto1;

    @FXML
    private TableColumn<Proveedor, String> columnIdProveedor;

    @FXML
    private TableColumn<Cliente, String> columnNombreCliente;

    @FXML
    private TableColumn<Proveedor, String> columnNombreProveedor;

    @FXML
    private TableColumn<Producto, Double> columnPrecioProducto;

    @FXML
    private TableColumn<Producto, Double> columnPrecioProducto1;

    @FXML
    private TableColumn<Producto, String> columnProductoDetalleFactura;

    @FXML
    private TableColumn<Proveedor, String> columnTelefonoProveedor;

    @FXML
    private TableColumn<Producto, String> columnTipoProducto;

    @FXML
    private TableColumn<Producto, String> columnTipoProducto1;

    @FXML
    private Spinner<Integer> spnCantidadProductos;

    @FXML
    private TableView<Cliente> tableViewClientes;

    @FXML
    private TableView<Producto> tableViewDetalleFactura;

    @FXML
    private TableView<Factura> tableViewFacturas;

    @FXML
    private TableView<Producto> tableViewProductos;

    @FXML
    private TableView<Producto> tableViewProductos1;

    @FXML
    private TableView<Proveedor> tableViewProveedores;

    @FXML
    private TextField txtApellidoCliente;

    @FXML
    private TextField txtCedulaCliente;

    @FXML
    private TextField txtCorreoElectronicoCliente;

    @FXML
    private DatePicker txtFechaFactura;

    @FXML
    private TextField txtIdFactura;

    @FXML
    private TextField txtIdProducto;

    @FXML
    private TextField txtIdProveedor;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtNombreProveedor;

    @FXML
    private TextField txtPrecioProducto;

    @FXML
    private TextField txtRutProveedor;

    @FXML
    private TextField txtTelefonoCliente;

    @FXML
    private TextField txtTelefonoProveedor;

    @FXML
    private TextField txtTipoProducto;

    @FXML
    private Label txtTotalFactura;

    @FXML
    private Label txtProductoSeleccionado;
    
    private PapeleriaAplicacion papeleriaAplicacion;

    // Seleccion en las tableviews
    private Producto pedidoSeleccion;
    private Cliente clienteSeleccion;
    private Proveedor proveedorSeleccion;
    private Factura facturaSeleccion;
    
    // Table Views
    ObservableList<Cliente> listadoClientes = FXCollections.observableArrayList();
    ObservableList<Producto> listadoProductos = FXCollections.observableArrayList();
    ObservableList<Proveedor> listadoProveedores = FXCollections.observableArrayList();
    ObservableList<Factura> listadoFacturas = FXCollections.observableArrayList();
    
    
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
		//----------------------------------------- Clientes --------------------------------------------------------------------------->>
		
		this.columnCedulaCliente.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		this.columnNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnApellidoCliente.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		
		//Obtener seleccion de la tabla
		tableViewClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				clienteSeleccion = newSelection;			
				mostrarInformacionCliente();
			}
		});
		//-------------------------------------------------------------------------------------------------------------||
		
		
	}
    
	/**
	 * Mostrar informacion del cliente en la interfaz
	 */
    private void mostrarInformacionCliente() {
		if(clienteSeleccion != null) {
			txtCedulaCliente.setText(clienteSeleccion.getCedula());
			txtNombreCliente.setText(clienteSeleccion.getNombre());
			txtApellidoCliente.setText(clienteSeleccion.getApellido());
			txtTelefonoCliente.setText(clienteSeleccion.getTelefono());
			txtCorreoElectronicoCliente.setText(clienteSeleccion.getCorreoElectronico());
		}	
	}
    
	public void setAplicacion(PapeleriaAplicacion papeleriaAplicacion) {
		this.papeleriaAplicacion = papeleriaAplicacion;
		this.papeleria = papeleriaAplicacion.getPapeleria();
		
		tableViewClientes.getItems().clear();
		tableViewClientes.setItems(getClientes());
	}
	
	private ObservableList<Cliente> getClientes() {		
		listadoClientes.addAll(papeleria.getListaClientes()); 
		return listadoClientes;
	}
	 
	 
	// ------------------------------------------------------------CRUD Cliente ------------------------------------------------------------->>
    @FXML
    public void agregarCliente(ActionEvent event) {
    	agregarCliente(txtCedulaCliente.getText(), txtNombreCliente.getText(), txtApellidoCliente.getText(), txtTelefonoCliente.getText(),
                txtCorreoElectronicoCliente.getText());
    }

	private void agregarCliente(String cedula, String nombre, String apellido, String telefono, String correoElectronico) {
		try {
			verificarDatos(cedula, nombre, apellido, telefono, correoElectronico);
			
			Cliente cliente = modelFactoryController.agregarCliente(cedula, nombre, apellido, telefono, correoElectronico);
			
			papeleriaAplicacion.mostrarMensaje("Registro Cliente", "Registro Cliente", "El cliente " + cliente.getNombre() + " " + cliente.getApellido() 
												+ "  ha sido registrado con éxito", AlertType.INFORMATION); 					
	
			if(cliente != null) listadoClientes.add(0, cliente);
			tableViewClientes.refresh();
						
		} catch (DatosInvalidosException | ClienteException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Registro de Cliente", "Información registro cliente inválida", e.getMessage(), AlertType.WARNING);
		}
	}
	
	private boolean verificarDatos(String cedula, String nombre, String apellido, String telefono, String correoElectronico) throws DatosInvalidosException {
		
		String notificacion = "";	
		
		if(cedula == null || cedula.equals("") || cedula.isEmpty()) {
			notificacion += "Ingrese la Cédula\n";
		}
		if(nombre == null || nombre.equals("")) {
			notificacion += "Ingrese el nombre\n";
		}
		if(apellido == null || apellido.equals("")) {
			notificacion += "Ingrese el apellido\n";
		}
		if(telefono == null || telefono.equals("")) {
			notificacion += "Ingrese el número de teléfono\n";
		}
		if(correoElectronico == null || correoElectronico.equals("")) {
			notificacion += "Ingrese el correo electrónico";
		}
		if(notificacion.equals("")) {
			return true;
		}
		throw new DatosInvalidosException(notificacion); 
	}

	@FXML
    void actualizarCliente(ActionEvent event) {
		if(clienteSeleccion != null) {
			editarCliente(txtCedulaCliente.getText(), txtNombreCliente.getText(), txtApellidoCliente.getText(), txtTelefonoCliente.getText(),
	                txtCorreoElectronicoCliente.getText());			
		} else {
			papeleriaAplicacion.mostrarMensaje("Actualización Cliente", "Actualización Cliente", "No se ha seleccionado ningún cliente", AlertType.WARNING);
		}
    }
	
    private void editarCliente(String cedula, String nombre, String apellido, String telefono, String correoElectronico) {
	
    	try {
			verificarDatos(cedula, nombre, apellido, telefono, correoElectronico);
			
			Cliente cliente = modelFactoryController.actualizarCliente(cedula, nombre, apellido, telefono, correoElectronico);
			
			clienteSeleccion.setCedula(cedula);
			clienteSeleccion.setNombre(nombre);
			clienteSeleccion.setApellido(apellido);
			clienteSeleccion.setTelefono(telefono);
			clienteSeleccion.setCorreoElectronico(correoElectronico);
			
			tableViewClientes.refresh();
			
			papeleriaAplicacion.mostrarMensaje("Notificación Actualización Cliente", "Actualización Cliente", "El cliente " + cliente.getNombre() + " " + cliente.getApellido() 
												+ "  ha sido actualizado con éxito", AlertType.INFORMATION); 					
		} catch (DatosInvalidosException | ClienteNoRegistradoException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Actualización Cliente", "Actualización Cliente", e.getMessage(), AlertType.WARNING);
		}
	}

	@FXML
    void consultarCliente(ActionEvent event) {
    	String idCliente = txtCedulaCliente.getText();
    	try {
			validarDato(idCliente);
			Cliente cliente = modelFactoryController.consultarCliente(idCliente);
			
			papeleriaAplicacion.mostrarMensaje("Notificación Búsqueda de Cliente", "Información búsqueda cliente", cliente.getNombre() + " " + cliente.getApellido() 
												+ "\nCédula: " + cliente.getCedula() + "\nCorreo: " + cliente.getCorreoElectronico(), AlertType.INFORMATION);
		} catch (DatosInvalidosException | ClienteNoRegistradoException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Búsqueda de Cliente", "Información búsqueda cliente inválida", e.getMessage(), AlertType.WARNING);
		}
    }
    
    private boolean validarDato(String idCliente) throws DatosInvalidosException {
    	if(idCliente.equalsIgnoreCase("")) {
    		throw new DatosInvalidosException("Ingrese el número de la cédula para realizar su búsqueda"); 
    	} else {
    		return true;
    	}
	}

	@FXML
    void eliminarCliente(ActionEvent event) {
		
		if(clienteSeleccion != null) {
			
			//Confirmar que el usuario si quiere eliminar el cliente
			boolean mensajeDeConfirmacion = papeleriaAplicacion.mostrarMensaje("Notificación Eliminar Cliente", "Eliminar Cliente", "¿Desea eliminar el cliente de la base de datos?");	
			
			if(mensajeDeConfirmacion == true) {
				modelFactoryController.eliminarCliente(clienteSeleccion.getCedula());
	    		papeleriaAplicacion.mostrarMensaje("Notificación eliminación cliente", "Eliminación Cliente", "Se ha eliminado el cliente", AlertType.INFORMATION);
	    		
	    		listadoClientes.remove(clienteSeleccion);
	    		tableViewClientes.refresh();
			} else {
				papeleriaAplicacion.mostrarMensaje("Notificación eliminación cliente", "Eliminar Cliente", "No se ha eliminado el cliente", AlertType.WARNING);    			
			}
		} else {
			papeleriaAplicacion.mostrarMensaje("Notificación eliminación cliente", "Eliminación Cliente", "No se ha seleccionado ninguna cliente", AlertType.WARNING);
		}
    }
    
	//-------------------------------------------------------------------------------------------------------------------------------------------------||

    // ------------------------------------------------------------CRUD Producto ---------------------------------------------------------------------->>
    
    @FXML
    void agregarProducto(ActionEvent event) {

    }

    @FXML
    void actualizarProducto(ActionEvent event) {

    }
    
    @FXML
    void consultarProducto(ActionEvent event) {

    }
    
    @FXML
    void eliminarProducto(ActionEvent event) {

    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------||

    // -----------------------------------------------------------------CRUD Proveedor ------------------------------------------------------------->>
  
    @FXML
    void agregarProveedor(ActionEvent event) {

    }

    @FXML
    void actualizarProveedor(ActionEvent event) {

    }
    
    @FXML
    void consultarProveedor(ActionEvent event) {

    }
    
    @FXML
    void eliminarProveedor(ActionEvent event) {

    }
    
	//-------------------------------------------------------------------------------------------------------------------------------------------------||

    // ------------------------------------------------------------CRUD Factura ---------------------------------------------------------------------->>

    @FXML
    void guardarFactura(ActionEvent event) {

    }
    
    @FXML
    void eliminarFactura(ActionEvent event) {

    }

    @FXML
    void agregarProductoDetalleFactura(ActionEvent event) {

    }

    @FXML
    void eliminarDetalleFactura(ActionEvent event) {

    }

    @FXML
    void pagarFactura(ActionEvent event) {

    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------||





}


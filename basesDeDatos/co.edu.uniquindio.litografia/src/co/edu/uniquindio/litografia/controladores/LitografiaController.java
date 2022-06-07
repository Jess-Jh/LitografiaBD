package co.edu.uniquindio.litografia.controladores;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.ResourceBundle;

import co.edu.uniquindio.litografia.aplicacion.PapeleriaAplicacion;
import co.edu.uniquindio.litografia.excepciones.ClienteException;
import co.edu.uniquindio.litografia.excepciones.ClienteNoRegistradoException;
import co.edu.uniquindio.litografia.excepciones.DatosInvalidosException;
import co.edu.uniquindio.litografia.excepciones.FacturaException;
import co.edu.uniquindio.litografia.excepciones.ProductoException;
import co.edu.uniquindio.litografia.excepciones.ProductoNoRegistradoException;
import co.edu.uniquindio.litografia.excepciones.ProveedorException;
import co.edu.uniquindio.litografia.excepciones.ProveedorNoRegistradoException;
import co.edu.uniquindio.litografia.modelo.Cliente;
import co.edu.uniquindio.litografia.modelo.Diseno;
import co.edu.uniquindio.litografia.modelo.Empleado;
import co.edu.uniquindio.litografia.modelo.EspecificacionDiseno;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

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
    private Button btnCerrarSesion;
    
    @FXML
    private Button btnGenerarReporte;
    
    @FXML
    private ToggleGroup groupReportes;

    @FXML
    private RadioButton rbtPrimerReporte;
    
    @FXML
    private RadioButton rbtReporte2;
    
    @FXML
    private RadioButton rbtReporte3;

    @FXML
    private RadioButton rbtReporte4;

    @FXML
    private RadioButton rbtReporte5;
    
    @FXML
    private RadioButton rbtReporte6;
    
    @FXML
    private RadioButton rbtReporte7;
    
    @FXML
    private RadioButton rbtReporte8;
    
    @FXML
    private RadioButton rbtReporte9;
    
    @FXML
    private RadioButton rbtReporte10;

    @FXML
    private ComboBox<String> cmbClienteFactura;
    ObservableList<String> listaCmbClientes = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> cmbReporte2;
    ObservableList<String> listaCmbReporte2 = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> cmbReporte3;
    ObservableList<String> listaCmbReporte3 = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> cmbReporte4;
    ObservableList<String> listaCmbReporte4 = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> cmbReporte71;
    ObservableList<String> listaCmbReporte71 = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> cmbReporte72;
    ObservableList<String> listaCmbReporte72 = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> cmbReporte73;
    ObservableList<String> listaCmbReporte73 = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> cmbReporte9;
    ObservableList<String> listaCmbReporte9 = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> cmbReporte101;
    ObservableList<String> listaCmbReporte101 = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> cmbReporte102;
    ObservableList<String> listaCmbReporte102 = FXCollections.observableArrayList();

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
    private Label txtIdFacturaSeleccionada;
    
    @FXML
    private Label txtIdFacturaSeleccionada1;

    @FXML
    private TextField txtIdProducto;
    
    @FXML
    private TextField txtFiltrarProducto;

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
    private TextField txtPrimerReporte;

    @FXML
    private Label txtTotalFactura;

    @FXML
    private Label txtProductoSeleccionado;
    
    @FXML
    public Label txtUsuarioInicioSesion;
    
    private PapeleriaAplicacion papeleriaAplicacion;

    // Seleccion en las tableviews
    private Producto productoSeleccion;
    private Producto productoSeleccion1;
    private Cliente clienteSeleccion;
    private Proveedor proveedorSeleccion;
    private Factura facturaSeleccion;
    
    // Table Views
    ObservableList<Cliente> listadoClientes = FXCollections.observableArrayList();
    ObservableList<Producto> listadoProductos = FXCollections.observableArrayList();
    ObservableList<Proveedor> listadoProveedores = FXCollections.observableArrayList();
    ObservableList<Factura> listadoFacturas = FXCollections.observableArrayList();
    ObservableList<Producto> listadoProductos1 = FXCollections.observableArrayList();
    ObservableList<Producto> listadoDetalleFactura = FXCollections.observableArrayList();
    ObservableList<Producto> filtroListadoProductos1 = FXCollections.observableArrayList();
    
    
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
		for (Empleado empleado : papeleria.getListaEmpleados()) {
			if(empleado.isInicioSesion()) 
				txtUsuarioInicioSesion.setText(empleado.getNombre() + " " + empleado.getApellido());
		}
		
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
		//--------------------------------------------------------------------------------------------------------------------------------||
		//----------------------------------------- Productos --------------------------------------------------------------------------->>
		this.columnIdProducto.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.columnTipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		this.columnPrecioProducto.setCellValueFactory(new PropertyValueFactory<>("precio"));
		
		//Obtener seleccion de la tabla
		tableViewProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				productoSeleccion = newSelection;			
				mostrarInformacionProducto();
			}
		});
		
		//--------------------------------------------------------------------------------------------------------------------------------||
		//----------------------------------------- Productos1 --------------------------------------------------------------------------->>
		this.columnIdProducto1.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.columnTipoProducto1.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		this.columnPrecioProducto1.setCellValueFactory(new PropertyValueFactory<>("precio"));
				
		tableViewProductos1.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				productoSeleccion1 = newSelection;	
				if(productoSeleccion1 != null) txtProductoSeleccionado.setText(productoSeleccion1.getTipo());
				mostrarInformacionProducto();
			}
		});
		//--------------------------------------------------------------------------------------------------------------------------------||

		//----------------------------------------- Proveedores --------------------------------------------------------------------------->>
		this.columnIdProveedor.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.columnNombreProveedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnTelefonoProveedor.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		
		//Obtener seleccion de la tabla
		tableViewProveedores.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
			if(newSelection != null) {
				proveedorSeleccion = newSelection;			
				mostrarInformacionProveedor();
			}
		});
		//--------------------------------------------------------------------------------------------------------------------------------||
		// ----------------------------------------- Facturas --------------------------------------------------------------------------->>
		if(papeleria.getListaFacturas() != null) {
			this.columnIdFactura.setCellValueFactory(new PropertyValueFactory<>("id"));
			this.columnFechaFactura.setCellValueFactory(new PropertyValueFactory<>("fecha"));
			this.columnClienteFactura.setCellValueFactory(new PropertyValueFactory<>("cedulaCliente"));
			
			//Obtener seleccion de la tabla
			tableViewFacturas.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
				if(newSelection != null) {
					facturaSeleccion = newSelection;
					if(facturaSeleccion != null) {
						txtIdFacturaSeleccionada1.setText("Id factura seleccionada: ");
						txtIdFacturaSeleccionada.setText(facturaSeleccion.getId());
						
						//----------------------------------------- Detalle Factura--------------------------------------------------------------------------->>
						if(facturaSeleccion.getListaProductos() != null) {
							this.columnProductoDetalleFactura.setCellValueFactory(new PropertyValueFactory<>("tipo"));
							this.columnCantidadDetalleFactura.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
						//--------------------------------------------------------------------------------------------------------------------------------||
						mostrarInformacionFactura();
						}
					}
				}
			});	
			// Configurar el Spinner de 0-100
			SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
			spnCantidadProductos.setValueFactory(gradesValueFactory);
			spnCantidadProductos.setEditable(true);
		}
		//--------------------------------------------------------------------------------------------------------------------------------||
		
		// Agregar datos al combo box de la factura
		for (Cliente cliente : papeleria.getListaClientes()) {
			listaCmbClientes.add(cliente.getCedula());
		}
		cmbClienteFactura.setItems(listaCmbClientes);
		
		// Agregar datos al combo box del Reporte 2
		listaCmbReporte2.add("Jefe Litografía");
		listaCmbReporte2.add("Diseñador");
		listaCmbReporte2.add("Secretario(a)");
		listaCmbReporte2.add("Contador(a)");
		
		cmbReporte2.setItems(listaCmbReporte2);
		
		// Agregar datos al combo box del Reporte 3
		for (Empleado empleado : papeleria.getListaEmpleados()) {
			listaCmbReporte3.add(empleado.getCedula());
		}
		cmbReporte3.setItems(listaCmbReporte3);

		// Agregar datos al combo box del Reporte 4
		for (Proveedor proveedor : papeleria.getListaProveedores()) {
			listaCmbReporte4.add(proveedor.getId());
		}
		cmbReporte4.setItems(listaCmbReporte4);
		
		// Agregar datos al combo box del reporte 7
		for (Diseno ed : papeleria.getListaDisenos()){
			listaCmbReporte71.add(ed.getTipo());
			listaCmbReporte72.add(ed.getTipo());
			listaCmbReporte73.add(ed.getTipo());
		}
		cmbReporte71.setItems(listaCmbReporte71);
		cmbReporte72.setItems(listaCmbReporte72);
		cmbReporte73.setItems(listaCmbReporte73);	
		
		// Agregar datos al combo box del Reporte 9
		for (Proveedor proveedor : papeleria.getListaProveedores()) {
			listaCmbReporte9.add(proveedor.getNombre());
		}
		cmbReporte9.setItems(listaCmbReporte9);
		
		// Agregar datos al combo box del Reporte 101
		for (int i = 1; i <= 10; i++) {
			listaCmbReporte101.add(i+"0000");			
		}
		cmbReporte101.setItems(listaCmbReporte101);
		
		// Agregar datos al combo box del Reporte 102
		for (Cliente cliente : papeleria.getListaClientes()) {
			listaCmbReporte102.add(cliente.getNombre());
		}
		cmbReporte102.setItems(listaCmbReporte102);
		
	}
    
	/**
	 * Mostrar informacion del cliente en la interfaz
	 */
    private void mostrarInformacionCliente() {
		if(clienteSeleccion != null) {
			txtCedulaCliente.setText(clienteSeleccion.getCedula());
			txtCedulaCliente.setDisable(true);
			txtNombreCliente.setText(clienteSeleccion.getNombre());
			txtApellidoCliente.setText(clienteSeleccion.getApellido());
			txtTelefonoCliente.setText(clienteSeleccion.getTelefono());
			txtCorreoElectronicoCliente.setText(clienteSeleccion.getCorreoElectronico());
		}	
	}
    
    /**
	 * Mostrar informacion del producto en la interfaz
	 */
    private void mostrarInformacionProducto() {
		if(productoSeleccion != null) {
			txtIdProducto.setText(productoSeleccion.getId());
			txtIdProducto.setDisable(true);
			txtTipoProducto.setText(productoSeleccion.getTipo());
			txtPrecioProducto.setText(String.valueOf(productoSeleccion.getPrecio()));
		}	
	}
    
	/**
	 * Mostrar informacion del proveedor en la interfaz
	 */
    private void mostrarInformacionProveedor() {
		if(proveedorSeleccion != null) {
			txtRutProveedor.setText(proveedorSeleccion.getRUT());
			txtIdProveedor.setText(proveedorSeleccion.getId());
			txtIdProveedor.setDisable(true);
			txtNombreProveedor.setText(proveedorSeleccion.getNombre());
			txtTelefonoProveedor.setText(proveedorSeleccion.getTelefono());
		}	
	}
    
    /**
	 * Mostrar informacion del factura en la interfaz
	 */
    private void mostrarInformacionFactura() {
		if(facturaSeleccion != null) {
			txtIdFactura.setText(facturaSeleccion.getId());
			
			//Convertir fecha para mostrar en la interfaz
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String date = facturaSeleccion.getFecha().toString();
			LocalDate localDate = LocalDate.parse(date, formatter); //convert String to LocalDate		
			txtFechaFactura.setValue(localDate);
			
			cmbClienteFactura.setValue(facturaSeleccion.getCliente().getCedula());
		}	
	}
    
	public void setAplicacion(PapeleriaAplicacion papeleriaAplicacion) {
		
		this.papeleriaAplicacion = papeleriaAplicacion;
		this.papeleria = papeleriaAplicacion.getPapeleria();
		
		tableViewClientes.getItems().clear();
		tableViewClientes.setItems(getClientes());
		
		tableViewProductos.getItems().clear();
		tableViewProductos.setItems(getProductos());
		
		tableViewProductos1.getItems().clear();
		tableViewProductos1.setItems(getProductos());
		
		tableViewProveedores.getItems().clear();
		tableViewProveedores.setItems(getProveedores());
		
		tableViewFacturas.getItems().clear();
		tableViewFacturas.setItems(getFacturas());
		
		if(facturaSeleccion != null) {
			tableViewDetalleFactura.getItems().clear();
			tableViewDetalleFactura.setItems(getProductosFactura());			
		}
		
		
	}
	
	private ObservableList<Cliente> getClientes() {		
		listadoClientes.addAll(papeleria.getListaClientes()); 
		return listadoClientes;
	}
	
	private ObservableList<Producto> getProductos() {
		listadoProductos.clear();
		listadoProductos.addAll(papeleria.getListaProductos()); 
		return listadoProductos;
	}
	
	private ObservableList<Proveedor> getProveedores() {		
		listadoProveedores.addAll(papeleria.getListaProveedores()); 
		return listadoProveedores;
	}
	
	private ObservableList<Factura> getFacturas() {		
		listadoFacturas.addAll(papeleria.getListaFacturas()); 
		return listadoFacturas;
	}
	
	private ObservableList<Producto> getProductosFactura() {		
		listadoDetalleFactura.addAll(facturaSeleccion.getListaProductos());
		return listadoProductos;
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
			limpiarCamposCliente();
						
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
			limpiarCamposCliente(); 
			papeleriaAplicacion.mostrarMensaje("Notificación Actualización Cliente", "Actualización Cliente", "El cliente " + cliente.getNombre() + " " + cliente.getApellido() 
												+ "  ha sido actualizado con éxito", AlertType.INFORMATION); 					
		} catch (DatosInvalidosException | ClienteNoRegistradoException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Actualización Cliente", "Actualización Cliente", e.getMessage(), AlertType.WARNING);
		}
	}
    
    public void limpiarCamposCliente() {
    	txtCedulaCliente.setText("");
		txtCedulaCliente.setDisable(false);
		txtNombreCliente.setText("");
		txtApellidoCliente.setText("");
		txtTelefonoCliente.setText("");
		txtCorreoElectronicoCliente.setText("");
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
    
    private boolean validarDato(String id) throws DatosInvalidosException {
    	if(id.equalsIgnoreCase("")) {
    		throw new DatosInvalidosException("Ingrese el id para realizar su búsqueda"); 
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
    	agregarProducto(txtIdProducto.getText(), txtTipoProducto.getText(), txtPrecioProducto.getText());
    }

	private void agregarProducto(String id, String tipo, String precio) {
		try {
			verificarDatosProducto(id, tipo, precio);
			
			Producto producto = modelFactoryController.agregarProducto(id, tipo, precio);
			
			papeleriaAplicacion.mostrarMensaje("Registro Producto", "Registro Producto", "El producto " + producto.getTipo() + "  ha sido registrado con éxito", AlertType.INFORMATION); 					
	
			if(producto != null) {
				listadoProductos.add(0, producto);
				listadoProductos1.add(0, producto);
			}
			if(producto.toString().toLowerCase().contains(txtFiltrarProducto.getText().toLowerCase())) {
				filtroListadoProductos1.add(producto);
			}
			tableViewProductos.refresh();
			tableViewProductos1.refresh();
			limpiarCamposProducto();
						
		} catch (DatosInvalidosException | ProductoException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Registro producto", "Información registro producto inválida", e.getMessage(), AlertType.WARNING);
		}
	}
	
	private boolean verificarDatosProducto(String id, String tipo, String precio) throws DatosInvalidosException {
		
		String notificacion = "";	
		
		if(id == null || id.equals("") || id.isEmpty()) {
			notificacion += "Ingrese el id\n";
		}
		if(tipo == null || tipo.equals("")) {
			notificacion += "Ingrese el tipo\n";
		}
		if(precio == null || precio.equals("")) {
			notificacion += "Ingrese el precio\n";
		}
		if(!(precio.matches("[0-9.]*"))) {
			notificacion += "El precio debe ser un valor numérico\n";
		}
		if(notificacion.equals("")) {
			return true;
		}
		throw new DatosInvalidosException(notificacion); 
	}

    @FXML
    void actualizarProducto(ActionEvent event) {
    	if(productoSeleccion != null) {
			editarProducto(txtIdProducto.getText(), txtTipoProducto.getText(), txtPrecioProducto.getText());			
		} else {
			papeleriaAplicacion.mostrarMensaje("Actualización Producto", "Actualización Producto", "No se ha seleccionado ningún producto", AlertType.WARNING);
		}
    }
    
    private void editarProducto(String id, String tipo, String precio) {
    	try {
			verificarDatosProducto(id, tipo, precio);
			
			Producto producto = modelFactoryController.actualizarProducto(id, tipo, precio);
			double precioProducto = Double.valueOf(precio);
			
			productoSeleccion.setId(id);
			productoSeleccion.setTipo(tipo);
			productoSeleccion.setPrecio(precioProducto);
			
			if(!productoSeleccion.toString().toLowerCase().contains(txtFiltrarProducto.getText().toLowerCase())) 
				filtroListadoProductos1.remove(productoSeleccion);
		
			tableViewProductos.refresh();
			tableViewProductos1.refresh();
			papeleriaAplicacion.mostrarMensaje("Notificación Actualización Producto", "Actualización Producto", "El producto " + producto.getTipo() + "  ha sido actualizado con éxito", AlertType.INFORMATION);
			limpiarCamposProducto();
		} catch (DatosInvalidosException | ProductoNoRegistradoException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Actualización Producto", "Actualización Producto", e.getMessage(), AlertType.WARNING);
		}
	}
    
    public void limpiarCamposProducto() {
    	txtIdProducto.setText("");
		txtIdProducto.setDisable(false);
		txtTipoProducto.setText("");
		txtPrecioProducto.setText("");
    }

	@FXML
    void consultarProducto(ActionEvent event) {
		String idProducto = txtIdProducto.getText();
    	try {
			validarDato(idProducto);
			Producto producto = modelFactoryController.consultarProducto(idProducto);
			
			papeleriaAplicacion.mostrarMensaje("Notificación Búsqueda de Producto", "Información búsqueda producto ", "\nId Producto: " + producto.getId()  
												+ "\nTipo: " + producto.getTipo() + "\nPrecio: " + producto.getPrecio(), AlertType.INFORMATION);
		} catch (DatosInvalidosException | ProductoNoRegistradoException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Búsqueda de Producto", "Información búsqueda producto inválida", e.getMessage(), AlertType.WARNING);
		}
    }
    
    @FXML
    void eliminarProducto(ActionEvent event) {
    	
    	if(productoSeleccion != null) {
			
			//Confirmar que el usuario si quiere eliminar el cliente
			boolean mensajeDeConfirmacion = papeleriaAplicacion.mostrarMensaje("Notificación Eliminar Producto", "Eliminar Producto", "¿Desea eliminar el producto de la base de datos?");	
			
			if(mensajeDeConfirmacion == true) {
				modelFactoryController.eliminarProducto(productoSeleccion.getId());
	    		papeleriaAplicacion.mostrarMensaje("Notificación eliminación producto", "Eliminación Producto", "Se ha eliminado el producto", AlertType.INFORMATION);
	    		
	    		listadoProductos.remove(productoSeleccion);
	    		listadoProductos1.remove(productoSeleccion);
	    		filtroListadoProductos1.remove(productoSeleccion);
	    		tableViewProductos.refresh();
	    		tableViewProductos1.refresh();
			} else {
				papeleriaAplicacion.mostrarMensaje("Notificación eliminación producto", "Eliminar Producto", "No se ha eliminado el producto", AlertType.WARNING);    			
			}
		} else {
			papeleriaAplicacion.mostrarMensaje("Notificación eliminación producto", "Eliminación Producto", "No se ha seleccionado ninguna producto", AlertType.WARNING);
		}
    }
    
    @FXML
    void filtrarProducto(KeyEvent event) {
    	String filtroProducto = txtFiltrarProducto.getText();
    	
    	if(filtroProducto.isEmpty()) {
    		tableViewProductos1.setItems(listadoProductos);
    	} else {
    		filtroListadoProductos1.clear();
    		
    		for (Producto producto: listadoProductos) {
				if(producto.toString().toLowerCase().contains(filtroProducto.toLowerCase())) {
					filtroListadoProductos1.add(producto);
				}
			}
    		tableViewProductos1.setItems(filtroListadoProductos1);
    	}
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------||

    // -----------------------------------------------------------------CRUD Proveedor ------------------------------------------------------------->>
  
    @FXML
    void agregarProveedor(ActionEvent event) {
    	agregarProveedor(txtIdProveedor.getText(), txtRutProveedor.getText(), txtNombreProveedor.getText(), txtTelefonoProveedor.getText());
    }

	private void agregarProveedor(String id, String rutProveedor, String nombre, String telefono) {
		try {
			verificarDatosProveedor(id, rutProveedor, nombre, telefono);
			
			Proveedor proveedor = modelFactoryController.agregarProveedor(id, rutProveedor, nombre, telefono);
			
			papeleriaAplicacion.mostrarMensaje("Registro Proveedor", "Registro Proveedor", "El proveedor " + proveedor.getNombre() + "  ha sido registrado con éxito", AlertType.INFORMATION); 					
	
			if(proveedor != null) listadoProveedores.add(0, proveedor);
			tableViewProveedores.refresh();
			limpiarCamposProveedor();
						
		} catch (DatosInvalidosException | ProveedorException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Registro proveedor", "Información registro proveedor inválida", e.getMessage(), AlertType.WARNING);
		}
	}
	
	private boolean verificarDatosProveedor(String id, String rutProveedor, String nombre, String telefono) throws DatosInvalidosException {
		
		String notificacion = "";	
		
		if(id == null || id.equals("") || id.isEmpty()) {
			notificacion += "Ingrese el id\n";
		}
		if(rutProveedor == null || rutProveedor.equals("")) {
			notificacion += "Ingrese el rut\n";
		}
		if(nombre == null || nombre.equals("")) {
			notificacion += "Ingrese el nombre\n";
		}
		if(telefono == null || telefono.equals("")) {
			notificacion += "Ingrese el telefono\n";
		}
		if(notificacion.equals("")) {
			return true;
		}
		throw new DatosInvalidosException(notificacion); 
	}

    @FXML
    void actualizarProveedor(ActionEvent event) {
    	if(proveedorSeleccion != null) {
			editarProveedor(txtIdProveedor.getText(), txtRutProveedor.getText(), txtNombreProveedor.getText(), txtTelefonoProveedor.getText());			
		} else {
			papeleriaAplicacion.mostrarMensaje("Actualización Proveedor", "Actualización Proveedor", "No se ha seleccionado ningún proveedor", AlertType.WARNING);
		}
    }
    
    private void editarProveedor(String id, String rutProveedor, String nombre, String telefono) {
    	try {
			verificarDatosProveedor(id, rutProveedor, nombre, telefono);
			
			Proveedor proveedor = modelFactoryController.actualizarProveedor(id, rutProveedor, nombre, telefono);
			
			proveedorSeleccion.setId(id);
			proveedorSeleccion.setRUT(rutProveedor);
			proveedorSeleccion.setNombre(nombre);
			proveedorSeleccion.setTelefono(telefono);
		
			tableViewProveedores.refresh();
			papeleriaAplicacion.mostrarMensaje("Notificación Actualización Proveedor", "Actualización Proveedor", "El proveedor " + proveedor.getNombre() + "  ha sido actualizado con éxito", AlertType.INFORMATION);
			limpiarCamposProveedor();
			
		} catch (DatosInvalidosException | ProveedorNoRegistradoException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Actualización Proveedor", "Actualización Proveedor", e.getMessage(), AlertType.WARNING);
		}
	}
    
    public void limpiarCamposProveedor() {
    	txtRutProveedor.setText("");
		txtIdProveedor.setText("");
		txtIdProveedor.setDisable(false);
		txtNombreProveedor.setText("");
		txtTelefonoProveedor.setText("");
    }
    
    @FXML
    void consultarProveedor(ActionEvent event) {
    	String idProveedor = txtIdProveedor.getText();
    	try {
			validarDato(idProveedor);
			Proveedor proveedor = modelFactoryController.consultarProveedor(idProveedor);
			
			papeleriaAplicacion.mostrarMensaje("Notificación Búsqueda de Proveedor", "Información búsqueda proveedor ", "\nId Proveedor: " + proveedor.getId()  
												+ "\nRut: " + proveedor.getRUT() + "\nNombre: " + proveedor.getNombre() + "\nTeléfono: " + proveedor.getTelefono(), AlertType.INFORMATION);
		} catch (DatosInvalidosException | ProveedorNoRegistradoException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Búsqueda de Proveedor", "Información búsqueda proveedor inválida", e.getMessage(), AlertType.WARNING);
		}
    }
    
    @FXML
    void eliminarProveedor(ActionEvent event) {
    	if(proveedorSeleccion != null) {
			
			//Confirmar que el usuario si quiere eliminar el cliente
			boolean mensajeDeConfirmacion = papeleriaAplicacion.mostrarMensaje("Notificación Eliminar Proveedor", "Eliminar Proveedor", "¿Desea eliminar el proveedor de la base de datos?");	
			
			if(mensajeDeConfirmacion == true) {
				modelFactoryController.eliminarProveedor(proveedorSeleccion.getId());
	    		papeleriaAplicacion.mostrarMensaje("Notificación eliminación proveedor", "Eliminación Proveedor", "Se ha eliminado el proveedor", AlertType.INFORMATION);
	    		
	    		listadoProveedores.remove(proveedorSeleccion);
	    		tableViewProveedores.refresh();
			} else {
				papeleriaAplicacion.mostrarMensaje("Notificación eliminación proveedor", "Eliminar Proveedor", "No se ha eliminado el proveedor", AlertType.WARNING);    			
			}
		} else {
			papeleriaAplicacion.mostrarMensaje("Notificación eliminación proveedor", "Eliminación Proveedor", "No se ha seleccionado ninguna proveedor", AlertType.WARNING);
		}

    }
    
	//-------------------------------------------------------------------------------------------------------------------------------------------------||

    // ------------------------------------------------------------CRUD Factura ---------------------------------------------------------------------->>

    @FXML
    void guardarFactura(ActionEvent event) {
    	agregarFactura(txtIdFactura.getText(), txtFechaFactura.getValue(), cmbClienteFactura.getValue());
    }

	private void agregarFactura(String id, LocalDate fecha, String cliente) {
		
		LocalDate localDate = fecha;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fechaFactura = localDate.format(formatter);
		
		try {
			verificarDatosFactura(id, fecha, cliente);
			Factura factura = modelFactoryController.agregarFactura(id, fechaFactura, cliente);
			
			papeleriaAplicacion.mostrarMensaje("Registro Factura", "Registro Factura", "La factura " + factura.getId() + "  ha sido registrada con éxito", AlertType.INFORMATION); 					
	
			if(factura != null) listadoFacturas.add(0, factura);
			tableViewFacturas.refresh();
			limpiarCamposFactura();
						
		} catch (DatosInvalidosException | FacturaException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Registro Factura", "Información registro factura inválida", e.getMessage(), AlertType.WARNING);
		}
	}
	
	private void limpiarCamposFactura() {
		txtIdFactura.setText("");
		txtIdFactura.setDisable(false);
		cmbClienteFactura.setValue("");
		txtFechaFactura.setValue(null);
	}

	private boolean verificarDatosFactura(String id, LocalDate fecha, String cliente) throws DatosInvalidosException {
		
		String notificacion = "";	
		
		if(id == null || id.equals("") || id.isEmpty()) {
			notificacion += "Ingrese el id\n";
		}
		if(fecha == null) {
			notificacion += "Ingrese la fecha\n";
		}
		if(cliente == null || cliente.equals("")) {
			notificacion += "Seleccione el cliente\n";
		}
		if(notificacion.equals("")) {
			return true;
		}
		throw new DatosInvalidosException(notificacion); 
	}
    
    @FXML
    void eliminarFactura(ActionEvent event) {
    	if(facturaSeleccion != null) {
			
			//Confirmar que el usuario si quiere eliminar la factura
			boolean mensajeDeConfirmacion = papeleriaAplicacion.mostrarMensaje("Notificación Eliminar Factura", "Eliminar Factura", "¿Desea eliminar la factura de la base de datos?");	
			
			if(mensajeDeConfirmacion == true) {
				modelFactoryController.eliminarFactura(facturaSeleccion.getId());
	    		papeleriaAplicacion.mostrarMensaje("Notificación eliminación factura", "Eliminación Factura", "Se ha eliminado la factura", AlertType.INFORMATION);
	    		
	    		listadoFacturas.remove(facturaSeleccion);
	    		tableViewFacturas.refresh();
			} else {
				papeleriaAplicacion.mostrarMensaje("Notificación eliminación factura", "Eliminar Factura", "No se ha eliminado la factura", AlertType.WARNING);    			
			}
		} else {
			papeleriaAplicacion.mostrarMensaje("Notificación eliminación factura", "Eliminación Factura", "No se ha seleccionado ninguna factura", AlertType.WARNING);
		}
    }

    @FXML
    void agregarProductoDetalleFactura(ActionEvent event) {
    	
    	try {
			validarSeleccion(txtProductoSeleccionado.getText(), spnCantidadProductos.getValue());
			productoSeleccion1.setCantidad(spnCantidadProductos.getValue());;
			listadoDetalleFactura.add(0, productoSeleccion1);
			
			calcularTotalFactura(listadoDetalleFactura);
			tableViewDetalleFactura.setItems(listadoDetalleFactura);
					
		} catch (DatosInvalidosException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación agregar producto detalle factura", "Agregar Producto", e.getMessage(), AlertType.WARNING);

		}
    }

	private void calcularTotalFactura(ObservableList<Producto> listadoDetalleFactura) {
		double total = 0;
		for (Producto producto : listadoDetalleFactura) {
			total += producto.getPrecio() * producto.getCantidad(); 
		}
		txtTotalFactura.setText(String.valueOf(total));
	}

	private boolean validarSeleccion(String productoSeleccionado, Integer spinner) throws DatosInvalidosException {
		
		String notificacion = "";	
		
		if(productoSeleccionado == null || productoSeleccionado.equals("") || productoSeleccionado.isEmpty()) {
			notificacion += "Seleccione un producto de la lista\n";
		}
		if(spinner <= 0) {
			notificacion += "La cantidad debe ser mayor a cero (0)\n";
		}
		if(notificacion.equals("")) {
			return true;
		}
		throw new DatosInvalidosException(notificacion); 
	}

	@FXML
    void eliminarDetalleFactura(ActionEvent event) {
		if(productoSeleccion1 != null) {
			listadoDetalleFactura.remove(productoSeleccion1);
			
			calcularTotalFactura(listadoDetalleFactura);
			tableViewDetalleFactura.setItems(listadoDetalleFactura);			
		}
    }

    @FXML
    void pagarFactura(ActionEvent event) {
    	
    	if(txtIdFacturaSeleccionada.getText() == null || txtIdFacturaSeleccionada.getText().equals("") || txtIdFacturaSeleccionada.getText().isEmpty()) {
    		papeleriaAplicacion.mostrarMensaje("Notificación Pago Factura", "Pagar Factura", "Seleccione la factura a la que desea agregarle la venta" ,AlertType.WARNING);
    	} else if(txtTotalFactura.getText() == null || txtTotalFactura.getText().equals("") || txtTotalFactura.getText().isEmpty()) {
    		papeleriaAplicacion.mostrarMensaje("Notificación Pago Factura", "Pagar Factura", "Seleccione cualquier producto para realizar la compra" ,AlertType.WARNING);    		
    	} else {
    		String idFactura = txtIdFacturaSeleccionada.getText();
    		double valorFactura = Double.valueOf(txtTotalFactura.getText());
    		Factura factura = modelFactoryController.agregarDetalleFactura(idFactura, listadoDetalleFactura, valorFactura);
    		
    		papeleriaAplicacion.mostrarMensaje("Notificación Pago Factura", "Pago Factura", "Se ha cancelado la factura " + factura.getId() + " con un valor de "
    											+ factura.getPrecio(),AlertType.WARNING);
    		
    		txtIdFacturaSeleccionada.setText("");
    		txtIdFacturaSeleccionada1.setText("");
    		txtTotalFactura.setText("");
     		txtProductoSeleccionado.setText("");
    		
    		listadoDetalleFactura.clear();
    		tableViewDetalleFactura.setItems(listadoDetalleFactura);
    		tableViewDetalleFactura.refresh();
    	}
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------||


    @FXML
    void cerrarSesion(ActionEvent event) {
    	if(modelFactoryController.cerrarSesion())
    		papeleriaAplicacion.mostrarInicioSesionView();
    	else
    		papeleriaAplicacion.mostrarInicioSesionView();
//    		papeleriaAplicacion.mostrarMensaje("Cerrar Sesión", "Cerrar Sesión", "Ocurrió un problema al momento de cerrar la sesión", AlertType.WARNING);
    }
    
    // -------------------------------------------------------------- REPORTES -------------------------------------------------------------------------->>
    
    @FXML
    void generarReporte(ActionEvent event) {
    
		if(rbtPrimerReporte.isSelected()) {
			if(txtPrimerReporte.getText() == null || txtPrimerReporte.getText().equals("") || txtPrimerReporte.getText().isEmpty()) 
				papeleriaAplicacion.mostrarMensaje("Notificación Primer reporte", "Primer Reporte", "Escriba una letra o palabra para generar el reporte", AlertType.WARNING);
			else 
				modelFactoryController.generarReporte1(txtPrimerReporte.getText());	
			
		} else if(rbtReporte2.isSelected()) {
			if(cmbReporte2.getValue() == null || cmbReporte2.getValue().equals("") || cmbReporte2.getValue().isEmpty()) 
				papeleriaAplicacion.mostrarMensaje("Notificación Segundo reporte", "Segundo Reporte", "Seleccione un tipo de la lista para poder generar el reporte", AlertType.WARNING);
			else 
				modelFactoryController.generarReporte2(cmbReporte2.getValue());
			
		} else if(rbtReporte3.isSelected()) {
			if(cmbReporte3.getValue() == null || cmbReporte3.getValue().equals("") || cmbReporte3.getValue().isEmpty()) 
				papeleriaAplicacion.mostrarMensaje("Notificación Tercer reporte", "Tercer Reporte", "Seleccione una cédula de la lista para poder generar el reporte", AlertType.WARNING);
			else 
				modelFactoryController.generarReporte3(cmbReporte3.getValue());
			
		} else if(rbtReporte4.isSelected()) {
			if(cmbReporte4.getValue() == null || cmbReporte4.getValue().equals("") || cmbReporte4.getValue().isEmpty()) 
				papeleriaAplicacion.mostrarMensaje("Notificación Cuarto reporte", "Cuarto Reporte", "Seleccione un id de la lista para poder generar el reporte", AlertType.WARNING);
			else 
				modelFactoryController.generarReporte4(cmbReporte4.getValue());
			
		} else if(rbtReporte5.isSelected()) {
			modelFactoryController.generarReporte5();
			
		} else if(rbtReporte6.isSelected()) {
			modelFactoryController.generarReporte6();
			
		} else if(rbtReporte7.isSelected()) {
			
			if(cmbReporte71.getValue() != null && cmbReporte72.getValue() != null && cmbReporte73.getValue() != null)
				modelFactoryController.generarReporte7(cmbReporte71.getValue(), cmbReporte72.getValue(), cmbReporte73.getValue());
			else if(cmbReporte71.getValue() != null && cmbReporte72.getValue() != null)
				modelFactoryController.generarReporte7(cmbReporte71.getValue(), cmbReporte72.getValue());
			else if(cmbReporte71.getValue() != null)
				modelFactoryController.generarReporte7(cmbReporte71.getValue());
			else 
				papeleriaAplicacion.mostrarMensaje("Notificación Septimo reporte", "Septimo Reporte", "Seleccione un tipo de diseno de la lista para poder generar el reporte", AlertType.WARNING);
			
		} else if(rbtReporte8.isSelected()) {
			modelFactoryController.generarReporte8();
			
		} else if(rbtReporte9.isSelected()) {
			if(cmbReporte9.getValue() == null || cmbReporte9.getValue().equals("") || cmbReporte9.getValue().isEmpty()) 
				papeleriaAplicacion.mostrarMensaje("Notificación noveno reporte", "Noveno Reporte", "Seleccione un nombre de la lista para poder generar el reporte", AlertType.WARNING);
			else 
				modelFactoryController.generarReporte9(cmbReporte9.getValue());
			
		} else if(rbtReporte10.isSelected()) {
			if(cmbReporte101.getValue() == null || cmbReporte101.getValue().equals("") || cmbReporte101.getValue().isEmpty() 
				|| cmbReporte102.getValue() == null || cmbReporte102.getValue().equals("") || cmbReporte102.getValue().isEmpty()) 
				papeleriaAplicacion.mostrarMensaje("Notificación Décimo reporte", "Décimo Reporte", "Seleccione valores de ambos campos para poder generar el reporte", AlertType.WARNING);
			else 
				modelFactoryController.generarReporte10(cmbReporte101.getValue(), cmbReporte102.getValue());
		
		} else {
			papeleriaAplicacion.mostrarMensaje("Notificación reportes", "Reportes", "Seleccione algún reporte para generarlo", AlertType.WARNING);
			
		}
    }





}


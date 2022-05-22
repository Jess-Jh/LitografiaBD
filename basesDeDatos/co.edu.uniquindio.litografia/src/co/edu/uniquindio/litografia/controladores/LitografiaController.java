package co.edu.uniquindio.litografia.controladores;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private Producto productoSeleccion;
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
		//----------------------------------------- Proveedores --------------------------------------------------------------------------->>
		if(papeleria.getListaFacturas() != null) {
			this.columnIdFactura.setCellValueFactory(new PropertyValueFactory<>("id"));
			this.columnFechaFactura.setCellValueFactory(new PropertyValueFactory<>("fecha"));
			this.columnClienteFactura.setCellValueFactory(new PropertyValueFactory<>("cedulaCliente"));
			
			//Obtener seleccion de la tabla
			tableViewFacturas.getSelectionModel().selectedItemProperty().addListener((obs, oldSeletion, newSelection) -> {
				if(newSelection != null) {
					facturaSeleccion = newSelection;			
					mostrarInformacionFactura();
				}
			});			
		}
		
		//--------------------------------------------------------------------------------------------------------------------------------||
		
		// Agregar datos al combo box de la factura
		for (Cliente cliente : papeleria.getListaClientes()) {
			listaCmbClientes.add(cliente.getCedula());
		}
		cmbClienteFactura.setItems(listaCmbClientes);
		
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
			txtIdFactura.setDisable(true);
			
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
		
		tableViewProveedores.getItems().clear();
		tableViewProveedores.setItems(getProveedores());
		
		tableViewFacturas.getItems().clear();
		tableViewFacturas.setItems(getFacturas());
	}
	
	private ObservableList<Cliente> getClientes() {		
		listadoClientes.addAll(papeleria.getListaClientes()); 
		return listadoClientes;
	}
	
	private ObservableList<Producto> getProductos() {		
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
	
			if(producto != null) listadoProductos.add(0, producto);
			tableViewProductos.refresh();
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
		
			tableViewProductos.refresh();
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
	    		tableViewProductos.refresh();
			} else {
				papeleriaAplicacion.mostrarMensaje("Notificación eliminación producto", "Eliminar Producto", "No se ha eliminado el producto", AlertType.WARNING);    			
			}
		} else {
			papeleriaAplicacion.mostrarMensaje("Notificación eliminación producto", "Eliminación Producto", "No se ha seleccionado ninguna producto", AlertType.WARNING);
		}

    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------||

    // -----------------------------------------------------------------CRUD Proveedor ------------------------------------------------------------->>
  
    @FXML
    void agregarProveedor(ActionEvent event) {
    	agregarProveedor(txtRutProveedor.getText(), txtIdProveedor.getText(), txtNombreProveedor.getText(), txtTelefonoProveedor.getText());
    }

	private void agregarProveedor(String rutProveedor, String id, String nombre, String telefono) {
		try {
			verificarDatosProveedor(rutProveedor, id, nombre, telefono);
			
			Proveedor proveedor = modelFactoryController.agregarProveedor(rutProveedor, id, nombre, telefono);
			
			papeleriaAplicacion.mostrarMensaje("Registro Proveedor", "Registro Proveedor", "El proveedor " + proveedor.getNombre() + "  ha sido registrado con éxito", AlertType.INFORMATION); 					
	
			if(proveedor != null) listadoProveedores.add(0, proveedor);
			tableViewProveedores.refresh();
			limpiarCamposProveedor();
						
		} catch (DatosInvalidosException | ProveedorException e) {
			papeleriaAplicacion.mostrarMensaje("Notificación Registro proveedor", "Información registro proveedor inválida", e.getMessage(), AlertType.WARNING);
		}
	}
	
	private boolean verificarDatosProveedor(String rutProveedor, String id, String nombre, String telefono) throws DatosInvalidosException {
		
		String notificacion = "";	
		
		if(rutProveedor == null || rutProveedor.equals("")) {
			notificacion += "Ingrese el rut\n";
		}
		if(id == null || id.equals("") || id.isEmpty()) {
			notificacion += "Ingrese el id\n";
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
			editarProveedor(txtRutProveedor.getText(), txtIdProveedor.getText(), txtNombreProveedor.getText(), txtTelefonoProveedor.getText());			
		} else {
			papeleriaAplicacion.mostrarMensaje("Actualización Proveedor", "Actualización Proveedor", "No se ha seleccionado ningún proveedor", AlertType.WARNING);
		}
    }
    
    private void editarProveedor(String rutProveedor, String id, String nombre, String telefono) {
    	try {
			verificarDatosProveedor(rutProveedor, id, nombre, telefono);
			
			Proveedor proveedor = modelFactoryController.actualizarProveedor(rutProveedor, id, nombre, telefono);
			
			proveedorSeleccion.setRUT(rutProveedor);
			proveedorSeleccion.setId(id);
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
		try {
			verificarDatosFactura(id, fecha, cliente);
			Factura factura = modelFactoryController.agregarFactura(id, fecha, cliente);
			
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

    }

    @FXML
    void eliminarDetalleFactura(ActionEvent event) {

    }

    @FXML
    void pagarFactura(ActionEvent event) {

    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------||





}


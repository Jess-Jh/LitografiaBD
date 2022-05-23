package co.edu.uniquindio.litografia.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import co.edu.uniquindio.litografia.aplicacion.PapeleriaAplicacion;
import co.edu.uniquindio.litografia.excepciones.DatosInvalidosException;
import co.edu.uniquindio.litografia.excepciones.InicioSesionException;
import co.edu.uniquindio.litografia.modelo.Empleado;
import co.edu.uniquindio.litografia.modelo.Papeleria;
/**
 * Controlador inicio sesion
 * @author Jessica Ospina
 */
public class InicioSesionController {
	
	//----------SINGLETON----------------------------------------------------->
	ModelFactoryController modelFactoryController;
	Papeleria papeleria;
	
	public InicioSesionController() {
		modelFactoryController = ModelFactoryController.getInstance();
		papeleria = modelFactoryController.getPapeleria();
	}
	
    public Papeleria getPapeleria() {
		return papeleria;
	}
	public void setGimnasio(Papeleria papeleria) {
		this.papeleria = papeleria;
	}
	//-----------------------------------------------------------------------||

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private CheckBox checkRecordarSesion;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtUsuario;
    
    private PapeleriaAplicacion papeleriaAplicacion;
    
    public void setAplicacion(PapeleriaAplicacion papeleriaAplicacion) {
    	this.papeleriaAplicacion = papeleriaAplicacion;
    	this.papeleria = papeleriaAplicacion.getPapeleria();
    }

    @FXML
    void iniciarSesion(ActionEvent event) {
    	String usuario = txtUsuario.getText();
    	String contrasena = txtContrasena.getText();
    	boolean sesionIniciada = checkRecordarSesion.isSelected();
    	
		try {
			verificarDatos(usuario, contrasena);
			Empleado usuarioSesion = modelFactoryController.iniciarSesionUsuario(usuario, contrasena, sesionIniciada);
			
			papeleriaAplicacion.mostrarMensaje("Inicio Sesión", "Inicio Sesión", "Bienvenido(a) " + usuarioSesion.getNombre() + " " + usuarioSesion.getApellido(), AlertType.CONFIRMATION);
			papeleriaAplicacion.mostrarLitografiaView();
		} catch (DatosInvalidosException | InicioSesionException e) {
			papeleriaAplicacion.mostrarMensaje("Inicio Sesión", "Inicio Sesión", e.getMessage(), AlertType.WARNING);  
		}
    }
    
    /**
     * Verificar que el usuario haya ingresado ambos datos
     * @param usuario
     * @param contrasena
     * @throws DatosInvalidosException 
     */
    private boolean verificarDatos(String usuario, String contrasena) throws DatosInvalidosException {
    	String notificacion = "";
		
		if(usuario == null || usuario.equals("")) {
			notificacion += "Ingrese el usuario\n";
		}
		if(contrasena == null || contrasena.equals("")) {
			notificacion += "Ingrese la contraseÃ±a\n";
		}
		if(notificacion.equals("")) {
			return true;
		}
		throw new DatosInvalidosException(notificacion); 
	}

}

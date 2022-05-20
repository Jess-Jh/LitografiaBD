package co.edu.uniquindio.litografia.aplicacion;

import java.io.IOException;
import java.util.Optional;

import co.edu.uniquindio.litografia.controladores.LitografiaController;
import co.edu.uniquindio.litografia.controladores.ModelFactoryController;
import co.edu.uniquindio.litografia.modelo.Papeleria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PapeleriaAplicacion extends Application {
	
	private Stage primaryStage;
	private Stage dialogStage;
	
	ModelFactoryController modelFactoryController;
	private Papeleria papeleria;
	
	public Papeleria getPapeleria() {
		return papeleria;
	}
	public void setPapeleria(Papeleria papeleria) {
		this.papeleria = papeleria;
	}
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		
		mostrarLitografiaView();
	}
	
	/**
	 * Cargar la vista de la litografía
	 */
	private void mostrarLitografiaView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PapeleriaAplicacion.class.getResource("/co/edu/uniquindio/litografia/vistas/litografiaView.fxml"));
			AnchorPane anchorPane = (AnchorPane)loader.load();
			LitografiaController litografiaController = loader.getController();
			litografiaController.setAplicacion(this);
			
			dialogStage = new Stage();
			dialogStage.setTitle("Litografia");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			
			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
     * MÃ©todo para mostrar un mensaje al usuario
     * @param titulo
     * @param header
     * @param contenido
     * @param alertType
     */
    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
    	Alert alert = new Alert(alertType);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	alert.showAndWait();
    }
    
    public boolean mostrarMensaje(String titulo, String header, String contenido) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle(titulo);
    	alert.setHeaderText(header);
    	alert.setContentText(contenido);
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if (result.get() == ButtonType.OK) return true;
    	return false;
    }

	
	

}

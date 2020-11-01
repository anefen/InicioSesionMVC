package dad.javafx.iniciosesion;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertIniciarSesion {

	public static void mostrarAlert(AlertType tipoAlerta, String cabecera, String contenido) {
		Alert alert = new Alert(tipoAlerta);
		alert.setTitle("Iniciar sesión");
		alert.setHeaderText(cabecera);
		alert.setContentText(contenido);
		
		alert.showAndWait();
	}	
	
}

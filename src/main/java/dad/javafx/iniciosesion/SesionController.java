package dad.javafx.iniciosesion;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;

public class SesionController {

	private SesionView view = new SesionView();
	private SesionModel model = new SesionModel();

	public SesionController() {
		view.getAccessButton().setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					boolean isValid = model.checkLogin(view.getUser(), view.getPassword());
					if (isValid) {
						AlertIniciarSesion.mostrarAlert(AlertType.INFORMATION, "Acceso permitido",
								"Las credenciales de acceso son válidas.");
					} else {
						AlertIniciarSesion.mostrarAlert(AlertType.ERROR, "Acceso denegado",
								"El usuario y/o contraseña no son válidos.");
					}
				} catch (Exception e) {
					AlertIniciarSesion.mostrarAlert(AlertType.ERROR, "Error", e.getMessage());
				}
			};

		});

		view.getCancelButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.getCancelButton().setOnAction(e -> Platform.exit());
			}
		});
	}

	public SesionView getView() {
		return view;
	}

}

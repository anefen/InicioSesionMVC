package dad.javafx.iniciosesion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) {
		SesionController controller = new SesionController();
		Scene scene = new Scene(controller.getView().getRoot(), 300, 250);
		primaryStage.setTitle("Iniciar sesión");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

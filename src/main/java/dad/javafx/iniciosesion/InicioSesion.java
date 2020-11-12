package dad.javafx.iniciosesion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class InicioSesion extends Application {

	private Label userLabel = new Label("Usuario: ");
	private Label passwdLabel = new Label("Contraseña: ");
	private TextField userText = new TextField();
	private PasswordField passwdText = new PasswordField();
	private Button accessButton = new Button("Acceder");
	private Button cancelButton = new Button("Cancelar");
	private GridPane root = new GridPane();
	private HBox buttonsBox = new HBox();

	

	@Override
	public void start(Stage primaryStage) throws Exception {

		userText.setPromptText("Usuario");
		passwdText.setPromptText("Contraseña");

		root.addRow(0, userLabel, userText);
		root.addRow(1, passwdLabel, passwdText);
		buttonsBox.getChildren().addAll(accessButton, cancelButton);
		root.add(buttonsBox, 1, 2);

		root.setPadding(new Insets(5));
		root.setHgap(15);
		root.setVgap(15);
		root.setGridLinesVisible(false);
		root.setAlignment(Pos.CENTER);

		buttonsBox.setSpacing(10);
		buttonsBox.setAlignment(Pos.BASELINE_CENTER);

		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints() };

		root.getColumnConstraints().setAll(cols);

		RowConstraints[] rows = { new RowConstraints(), new RowConstraints(), new RowConstraints() };

		root.getRowConstraints().setAll(rows);

		
		
		accessButton.setOnAction(new EventHandler<ActionEvent>() {
		
						
			public void handle(ActionEvent event) {
				try {				
				String passwordMD5 = DigestUtils.md5Hex(passwdText.getText()).toUpperCase();
				File csvFile = new File("users.csv");
				FileReader fr = new FileReader(csvFile);
				BufferedReader br = new BufferedReader(fr);
		          String line;

				while((line = br.readLine()) != null) {
					String[] lines = line.split(",");
					
					if (lines[0].equals(userText.getText()) && lines[1].equals(passwordMD5)) {
						AlertIniciarSesion.mostrarAlert(AlertType.INFORMATION, "Acceso permitido", "Las credenciales de acceso son válidas.");
						br.close();
					}
				}
			
			
					AlertIniciarSesion.mostrarAlert(AlertType.ERROR, "Acceso denegado", "El usuario y/o contraseña no son válidos.");
					passwdText.clear();
			
		
				}catch (Exception e) {
				}
				
				
				
			};
			
		});
		
		cancelButton.setOnAction(e -> Platform.exit());
	
		
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Iniciar sesión");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

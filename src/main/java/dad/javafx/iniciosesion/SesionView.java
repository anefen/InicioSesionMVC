package dad.javafx.iniciosesion;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

public class SesionView {

	private Label userLabel = new Label("Usuario: ");
	private Label passwdLabel = new Label("Contraseña: ");
	private TextField userText = new TextField();
	private PasswordField passwdText = new PasswordField();
	private Button accessButton = new Button("Acceder");
	private Button cancelButton = new Button("Cancelar");
	private GridPane root = new GridPane();
	private HBox buttonsBox = new HBox();

	public SesionView() {

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
	}

	public String getUser() {

		return userText.getText();
	}

	public String getPassword() {

		return passwdText.getText();
	}

	public Button getAccessButton() {
		return accessButton;
	}

	public GridPane getRoot() {
		return root;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

}

package view.interfaceFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mailBoxGoat.Main;

public class WelcomePage extends Application implements Initializable {
	private Stage stage;
	private Parent root;

	@FXML
	private TextField textAddressee;

	@FXML
	private TextField textMessage;

	@FXML
	private TextField textObject;

	@FXML
	private Label labelInfo;

	public WelcomePage() {
	}

	/**
	 * 
	 * @param args
	 */
	public void launchwindows(String[] args) {
		launch(args);
	}

	// FX methods
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.stage = new Stage();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.root = FXMLLoader.load(getClass().getResource("welcomingPage.fxml"));
		this.stage = primaryStage;
		this.stage.setTitle("Welcome page");
		this.stage.setScene(new Scene(root));

		this.stage.show();
	}

	/**
	 * Creates the page for writing the mail
	 * 
	 * @throws Exception
	 */
	public void startMessage() throws Exception {

		this.root = FXMLLoader.load(getClass().getResource("mail.fxml"));
		this.stage.setTitle("Mail Goat");
		this.stage.setScene(new Scene(root));

		this.stage.show();
	}

	// ACTIONS
	@FXML
	void exitProgram(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void newMessage(ActionEvent event) {
		try {
			this.stage.close();
			startMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void saveDraft(ActionEvent event) {

	}

	@FXML
	void sendMessage(ActionEvent event) {
		String addressee, object, message;

		addressee = this.textAddressee.getText();
		object = this.textObject.getText();
		message = this.textMessage.getText();
		this.labelInfo.setText("");

		if (addressee.isBlank() == false) {
			if (object.isBlank() == false) {
				if (message.isBlank() == false) {
					Main.writeMessage(addressee, object, message);
					Platform.exit();

				} else {
					this.labelInfo.setText("The message is empty !");
				}
			} else {
				this.labelInfo.setText("The mail has no object !");
			}
		} else {
			this.labelInfo.setText("The adresse field is blank !");
		}
	}

}// END PRG

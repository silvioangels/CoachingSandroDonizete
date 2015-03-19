package application.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WelcomeController extends AbstraticController {
	
	private static Stage stage;
	
	private static WelcomeController instance;
	
	public static WelcomeController getInstance(){
		
		if(instance == null){
			instance = new WelcomeController();
		}
		
		return instance;
	}

	@Override
	public void start(Stage initStage) throws Exception {
		try {
			
			Parent parent = FXMLLoader.load(PreLoaderController.class.getResource(TELA_ABERTURA));
			
			initStage.setScene(new Scene(parent));
			initStage.setTitle("Tela de Boas Vindas");
			initStage.show();
			
			setStage(initStage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void criarNovoCadastro() {

		try {
			
			CadastroController.getInstance().start(new Stage());
			WelcomeController.stage.hide();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void OpenWebSite(MouseEvent event) {
		try {
			java.awt.Desktop.getDesktop().browse(new URI(LINK_WEB_SITE));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void OpenFacebook(MouseEvent event) {
		try {
			java.awt.Desktop.getDesktop().browse(new URI(LINK_FACEBOOK));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void OpenYouTube(MouseEvent event) {
		try {
			java.awt.Desktop.getDesktop().browse(new URI(LINK_YOUTUBE));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		WelcomeController.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

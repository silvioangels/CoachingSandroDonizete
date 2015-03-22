package application.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalController extends AbstraticController {
	
	private static Stage stage;
	
	private static PrincipalController instance;
	
	@FXML
	private TitledPane titledPaneCliente;
	
	@FXML
	private AnchorPane telaConteudoPrincipal;
	
	public static PrincipalController getInstance(){
		
		if(instance == null){
			instance = new PrincipalController();
		}
		
		return instance;
	}

	@Override
	public void start(Stage initStage) throws Exception {
		try {
			
			telaConteudoPrincipal = new AnchorPane();
			Parent parent = FXMLLoader.load(getClass().getResource(TELA_PRINCIPAL));
			initStage.setScene(new Scene(parent));
			initStage.setResizable(false);
			initStage.setTitle("Tela de Cadastro");			
			initStage.show();
			
			setStage(initStage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void AbrirGoogleMaps(MouseEvent event) {
		try {
			java.awt.Desktop.getDesktop().browse(new URI(LINK_MAPS));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		PrincipalController.stage = stage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}

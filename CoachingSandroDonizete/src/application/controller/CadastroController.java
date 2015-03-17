package application.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroController extends AppAbstraticController {
	
	private static Stage stage;
	
	private static CadastroController instance;
	
	public static CadastroController getInstance(){
		
		if(instance == null){
			instance = new CadastroController();
		}
		
		return instance;
	}

	@Override
	public void start(Stage initStage) throws Exception {
		try {
			
			Parent parent = FXMLLoader.load(getClass().getResource(TELA_CADASTRO));
			initStage.setScene(new Scene(parent));
			initStage.setTitle("Tela de Cadastro");
			initStage.show();
			initStage.requestFocus();
			
			
			setStage(initStage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@FXML
	private void cancelar() {
		
		try {
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		CadastroController.stage = stage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}

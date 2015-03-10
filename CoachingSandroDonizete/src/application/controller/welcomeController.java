package application.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class welcomeController extends Application {
	
	@Override
	public void start(Stage stage) {
		
		try {
			
			Parent parent = FXMLLoader.load(getClass().getResource("/application/view/fxml/welcome.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Tela de Boas Vindas");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
    private void OpenWebSite(MouseEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("http://www.sandrodonizete.com/"));
        } catch (IOException | URISyntaxException e) {
        	e.printStackTrace();
        }
    }
	
	@FXML
    private void OpenFacebook(MouseEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://www.facebook.com/pages/Dicas-do-Coach-Sandro-Donizete/1408975239395175"));
        } catch (IOException | URISyntaxException e) {
        	e.printStackTrace();
        }
    }
	
	@FXML
    private void OpenYouTube(MouseEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/user/Sandrocoach"));
        } catch (IOException | URISyntaxException e) {
        	e.printStackTrace();
        }
    }


	public static void main(String[] args) {
		launch(args);
	}
}

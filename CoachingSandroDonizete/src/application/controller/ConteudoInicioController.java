package application.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import application.bo.FactoryBO;
import application.enumeration.ResoursesEnum;
import application.enumeration.TelaEnum;
import application.model.ConsultaCoachee;
import application.navigation.ConteudoNavigator;

public class ConteudoInicioController extends AbstraticController implements Initializable{
	
	private static Stage stage;
	
	@FXML
	private TableView<ConsultaCoachee> tabelaCoacheesAtivos;
	
	@FXML
    private TableColumn<ConsultaCoachee, String> nomeCoacheeColuna;
	
	@FXML
    private TableColumn<ConsultaCoachee, String> ultimaSessaoColuna;
	
	@FXML
    private TableColumn<ConsultaCoachee, String> numeroSessaoColuna;
	
	@Override
	public void initialize(URL url, ResourceBundle resorses) {
		
		tabelaCoacheesAtivos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tabelaCoacheesAtivos.getItems().setAll(FactoryBO.getInicioBOInstance().recuperarTodasConsultasCoachee());
		
	}
	
	@Override
	public void start(Stage initStage) throws Exception {
		try {
			
			Parent parent = FXMLLoader.load(PreLoaderController.class.getResource(TelaEnum.TELA_PRINCIPAL.getCaminhoFxml()));
			initStage.setScene(new Scene(parent));
			initStage.show();
			
			setStage(initStage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void cadastroNovoCoachee() {

		try {
			
			ConteudoNavigator.carregarCena(TelaEnum.CONTEUDO_CADASTRO_COACHEE.getCaminhoFxml());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void OpenWebSite(MouseEvent event) {
		try {
			java.awt.Desktop.getDesktop().browse(new URI(ResoursesEnum.LINK_WEB_SITE.getRecurso()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void OpenFacebook(MouseEvent event) {
		try {
			java.awt.Desktop.getDesktop().browse(new URI(ResoursesEnum.LINK_FACEBOOK.getRecurso()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void OpenYouTube(MouseEvent event) {
		try {
			java.awt.Desktop.getDesktop().browse(new URI(ResoursesEnum.LINK_YOUTUBE.getRecurso()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void AbrirGoogleMaps(MouseEvent event) {
		try {
			java.awt.Desktop.getDesktop().browse(new URI(ResoursesEnum.LINK_MAPS.getRecurso()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		ConteudoInicioController.stage = stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import application.enums.TelaControllers;
import application.navigation.ConteudoNavigator;

public class PrincipalController extends AbstraticController {
	
	private static Stage stage;
	
	private static PrincipalController instance;
	
	@FXML
	private AnchorPane anchorPaneCabecalho;
	
	@FXML
	private TitledPane titledPaneCliente;
	
	@FXML
    private StackPane conteudoStackPane;
	
	public static PrincipalController getInstance(){
		
		if(instance == null){
			instance = new PrincipalController();
		}
		
		return instance;
	}
	
	@Override
	public void start(Stage initStage) throws Exception {
		try {

			initStage.setScene(criarCenaPrincipal((carregarTelaPrincipal())));
			initStage.setMaximized(true);
			initStage.setTitle("Delphos Coaching - Excelência em Atingir Metas Pessoais e Profissionais");			
			initStage.show();
			
			setStage(initStage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private Pane carregarTelaPrincipal() throws IOException {
        FXMLLoader loader = new FXMLLoader();
 
        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(TELA_PRINCIPAL));
        PrincipalController mainController = loader.getController();
 
        ConteudoNavigator.setControllerPrincipal(mainController);
        ConteudoNavigator.carregarCena(TelaControllers.CONTEUDO_INICIO.getCaminhoFxml());
 
        return mainPane;
    }
	
	private Scene criarCenaPrincipal(Pane telaPrincipal) {
        Scene cenaPrincipal = new Scene(telaPrincipal);
 
        cenaPrincipal.getStylesheets().add("application/view/css/principal.css");
 
        return cenaPrincipal;
    }
	
	public void abrirConteudoPrincipal(Node node) {
		conteudoStackPane.getChildren().setAll(node);
    }
	
	@FXML
    void abrirTelaCadastroNovoCoachee(ActionEvent event) {
        ConteudoNavigator.carregarCena(TelaControllers.CONTEUDO_CADASTRO_COACHEE.getCaminhoFxml());
    }
	
	@FXML
    void abrirTelaDadosPrograma(ActionEvent event) {
        ConteudoNavigator.carregarCena(TelaControllers.CONTEUDO_DADOS_PROGRAMA.getCaminhoFxml());
    }
	
	@FXML
    void abrirTelaInicio(ActionEvent event) {
        ConteudoNavigator.carregarCena(TelaControllers.CONTEUDO_INICIO.getCaminhoFxml());
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

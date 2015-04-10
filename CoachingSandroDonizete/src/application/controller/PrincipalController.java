package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

import application.enumeration.TelaEnum;
import application.navigation.ConteudoNavigator;

public class PrincipalController extends AbstraticController{
	
	private static Stage stage;
	
	@FXML
	private AnchorPane anchorPaneCabecalho;
	
	@FXML
	private TitledPane titledPaneCliente;
	
	@FXML
    private StackPane conteudoStackPane;
	
	@FXML
	private Button btnInicio;
	
	private static Button btnStaticInicio;
	
	@FXML
	private Button btnCadastroNovoCoachee;
	
	private static Button btnStaticCadastroNovoCoachee;
	
	@FXML
	private Button btnDadosPrograma;
	
	@FXML
	private Button btnSessaoHistoricoRota;
	
	@FXML
	private Button btnCompetencia;
	
	@Override
	public void initialize(URL url, ResourceBundle resourses) {
		atualizarCorSelecaoBotoesMenu(TelaEnum.CONTEUDO_INICIO);
		btnStaticInicio = btnInicio;
		btnStaticCadastroNovoCoachee = btnCadastroNovoCoachee;
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
 
        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(TelaEnum.TELA_PRINCIPAL.getCaminhoFxml()));
        PrincipalController mainController = loader.getController();
 
        ConteudoNavigator.setControllerPrincipal(mainController);
        ConteudoNavigator.carregarCena(TelaEnum.CONTEUDO_INICIO.getCaminhoFxml());
 
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
    void abrirTelaInicio(ActionEvent event) {
		atualizarCorSelecaoBotoesMenu(TelaEnum.CONTEUDO_INICIO);
        ConteudoNavigator.carregarCena(TelaEnum.CONTEUDO_INICIO.getCaminhoFxml());
    }
	
	@FXML
    void abrirTelaCadastroNovoCoachee(ActionEvent event) {
		atualizarCorSelecaoBotoesMenu(TelaEnum.CONTEUDO_CADASTRO_COACHEE);
        ConteudoNavigator.carregarCena(TelaEnum.CONTEUDO_CADASTRO_COACHEE.getCaminhoFxml());
    }
	
	@FXML
    void abrirTelaDadosPrograma(ActionEvent event) {
		if( consultaCoacheeApplication == null){
			JOptionPane.showMessageDialog(null, "Somente é possivel entrar nessa opção com um coachee já cadastrado.","Alerta", JOptionPane.INFORMATION_MESSAGE);
		}else{
			ConteudoNavigator.carregarCena(TelaEnum.CONTEUDO_DADOS_PROGRAMA.getCaminhoFxml());
		}
    }
	
	private void atualizarCorSelecaoBotoesMenu(TelaEnum telaEnum){
		
		String corDeFundoDefault = "-fx-background-color: #e4e4e4;-fx-border-color:gray";
		String corDeFundoSelecionado = "-fx-background-color: red;-fx-border-color:gray";
		
		btnInicio.setStyle(corDeFundoDefault);
		btnCadastroNovoCoachee.setStyle(corDeFundoDefault);
		btnDadosPrograma.setStyle(corDeFundoDefault);
		btnSessaoHistoricoRota.setStyle(corDeFundoDefault);
		btnCompetencia.setStyle(corDeFundoDefault);
		
		switch (TelaEnum.getDadosTelaEnumFromString(telaEnum.getDescricao())) {
		case CONTEUDO_INICIO:
			btnInicio.setStyle(corDeFundoSelecionado);
			break;
		case CONTEUDO_CADASTRO_COACHEE:
			btnCadastroNovoCoachee.setStyle(corDeFundoSelecionado);
			break;
		case CONTEUDO_DADOS_PROGRAMA:
			btnInicio.setStyle(corDeFundoSelecionado);
			break;

		default:
			break;
		}
		
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		PrincipalController.stage = stage;
	}
	
	public static Button getBtnStaticCadastroNovoCoachee() {
		return btnStaticCadastroNovoCoachee;
	}
	
	public static Button getBtnStaticInicio() {
		return btnStaticInicio;
	}

	public static void main(String[] args) {
		launch(args);
	}

}

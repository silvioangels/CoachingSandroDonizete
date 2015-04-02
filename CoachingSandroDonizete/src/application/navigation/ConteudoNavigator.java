package application.navigation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import application.controller.PrincipalController;


public class ConteudoNavigator {

	public static final String CONTEUDO_INICIO  	 = "/application/view/fxml/conteudoInicio.fxml";
    public static final String CONTEUDO_CADASTRO_COACHEE = "/application/view/fxml/conteudoCadastroCoachee.fxml";
    public static final String CONTEUDO_DADOS_PROGRAMA = "/application/view/fxml/conteudoDadosPrograma.fxml";
    
    private static PrincipalController principalController;
    
    public static void setMainController(PrincipalController principalController) {
    	ConteudoNavigator.principalController = principalController;
    }
    
    public static void carregarCena(String fxml) {
        try {
        	principalController.abrirConteudoPrincipal(
                FXMLLoader.load(ConteudoNavigator.class.getResource(fxml))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

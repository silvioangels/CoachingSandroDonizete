package application.navigation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import application.controller.PrincipalController;


public class ConteudoNavigator {

	public static final String CONTEUDO_BOAS_VINDAS  	 = "/application/view/fxml/conteudoBoasVindas.fxml";
    public static final String CONTEUDO_CADASTRO_CLIENTE = "/application/view/fxml/conteudoCadastroCliente.fxml";
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

package application.navigation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import application.controller.PrincipalController;


public class ConteudoNavigator {

    private static PrincipalController principalController;
    
    public static void setControllerPrincipal(PrincipalController principalController) {
    	ConteudoNavigator.principalController = principalController;
    }
    
    public static void carregarCena(String fxml) {
        try {
        	
        	principalController.abrirConteudoPrincipal(FXMLLoader.load(ConteudoNavigator.class.getResource(fxml)));
        	
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

package application.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import application.enumeration.ResoursesEnum;
import application.model.ConsultaCoachee;

public class AbstraticController extends Application implements Initializable{
	
	protected static ConsultaCoachee consultaCoacheeApplication;
	
	private final int tamanhaAlturaCabecalho = Integer.parseInt(ResoursesEnum.PRINCIPAL_CABECALHO_ALTURA.getRecurso());
	private final int tamanhaLargutaMenu = Integer.parseInt(ResoursesEnum.PRINCIPAL_MENU_COMPRIMENTO.getRecurso());
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourses) {
		
	}
	
	protected void ajustarScrollComTamanhoResolucaoTela(ScrollPane scrollPane){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		scrollPane.setPrefSize(screenSize.getWidth()-tamanhaLargutaMenu, screenSize.getHeight()-tamanhaAlturaCabecalho);
		
	}

	
}

package application.controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import application.model.ConsultaCoachee;

public class AbstraticController extends Application{
	
	protected static ConsultaCoachee consultaCoacheeApplication;
	
	private final int tamanhaAlturaCabecalho = 100;
	private final int tamanhaLargutaMenu = 200;
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
	
	protected void ajustarScrollComTamanhoResolucaoTela(ScrollPane scrollPane){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		scrollPane.setPrefSize(screenSize.getWidth()-tamanhaLargutaMenu, screenSize.getHeight()-tamanhaAlturaCabecalho);
		
	}

}

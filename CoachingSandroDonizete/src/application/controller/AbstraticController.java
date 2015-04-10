package application.controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import application.model.ConsultaCoachee;

public class AbstraticController extends Application{
	
	protected static ConsultaCoachee consultaCoacheeApplication;
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
	
	protected void ajustarTamanhoResolucaoTelaPane(AnchorPane anchorPane){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		anchorPane.setPrefSize(screenSize.getWidth(), screenSize.getHeight());
		
	}
	

}

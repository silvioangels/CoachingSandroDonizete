package application.controller;

import javafx.application.Application;
import javafx.stage.Stage;
import application.model.ConsultaCoachee;

public class AbstraticController extends Application{
	
	static{
		consultaCoacheeApplication = new ConsultaCoachee();
	}
	
	protected static ConsultaCoachee consultaCoacheeApplication;
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
	

}

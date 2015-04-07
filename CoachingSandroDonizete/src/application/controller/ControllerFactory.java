package application.controller;

public class ControllerFactory {

	private static PrincipalController principalController;
	
	private static ConteudoInicioController conteudoInicioController;

	public static PrincipalController getPrincipalControllerInstance() {

		if (principalController == null) {
			principalController = new PrincipalController();
		}

		return principalController;
	}
	
	public static ConteudoInicioController getConteudoInicioControllerInstance() {

		if (conteudoInicioController == null) {
			conteudoInicioController = new ConteudoInicioController();
		}

		return conteudoInicioController;
	}

}

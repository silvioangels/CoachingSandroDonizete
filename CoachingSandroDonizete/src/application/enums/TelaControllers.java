package application.enums;

public enum TelaControllers {
	
	CONTEUDO_INICIO("/application/view/fxml/conteudoInicio.fxml"),
	CONTEUDO_CADASTRO_COACHEE("/application/view/fxml/conteudoCadastroCoachee.fxml"),
	CONTEUDO_DADOS_PROGRAMA("/application/view/fxml/conteudoDadosPrograma.fxml");

	TelaControllers(String caminhoFxml){
		this.caminhoFxml = caminhoFxml;
	}
	
	private String caminhoFxml;

	public String getCaminhoFxml() {
		return caminhoFxml;
	}

	public void setCaminhoFxml(String caminhoFxml) {
		this.caminhoFxml = caminhoFxml;
	}
	
	public static TelaControllers getValueByName(String caminho){
		
		TelaControllers retorno = null;
		
		for (TelaControllers telaController : TelaControllers.values()) {
			if(telaController.getCaminhoFxml().equals(caminho)){
				retorno = telaController;
			}
		}
		
		return retorno;
		
	}

}

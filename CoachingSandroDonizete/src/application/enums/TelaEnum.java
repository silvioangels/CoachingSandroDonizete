package application.enums;

public enum TelaEnum {
	
	TELA_PRINCIPAL("/application/view/fxml/principal.fxml"),
	CONTEUDO_INICIO("/application/view/fxml/conteudoInicio.fxml"),
	CONTEUDO_CADASTRO_COACHEE("/application/view/fxml/conteudoCadastroCoachee.fxml"),
	CONTEUDO_DADOS_PROGRAMA("/application/view/fxml/conteudoDadosPrograma.fxml");

	TelaEnum(String caminhoFxml){
		this.caminhoFxml = caminhoFxml;
	}
	
	private String caminhoFxml;

	public String getCaminhoFxml() {
		return caminhoFxml;
	}

	public void setCaminhoFxml(String caminhoFxml) {
		this.caminhoFxml = caminhoFxml;
	}
	
	public static TelaEnum getValueByName(String caminho){
		
		TelaEnum retorno = null;
		
		for (TelaEnum telaController : TelaEnum.values()) {
			if(telaController.getCaminhoFxml().equals(caminho)){
				retorno = telaController;
			}
		}
		
		return retorno;
		
	}

}

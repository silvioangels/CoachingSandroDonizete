package application.enumeration;

public enum TelaEnum {
	TELA_NAO_CADASTRADA("Tela nao Cadastrada","Tela nao Cadastrada"),
	TELA_PRINCIPAL("Tela Principal","/application/view/fxml/principal.fxml"),
	CONTEUDO_INICIO("Conteudo Inicio","/application/view/fxml/conteudoInicio.fxml"),
	CONTEUDO_CADASTRO_COACHEE("Conteudo Cadastro Coachee","/application/view/fxml/conteudoCadastroCoachee.fxml"),
	CONTEUDO_DADOS_PROGRAMA("Conteudo Dados Programa","/application/view/fxml/conteudoDadosPrograma.fxml");

	TelaEnum(String descricao,String caminhoFxml){
		this.descricao = descricao;
		this.caminhoFxml = caminhoFxml;
	}
	
	private String descricao;
	private String caminhoFxml;

	public String getCaminhoFxml() {
		return caminhoFxml;
	}

	public void setCaminhoFxml(String caminhoFxml) {
		this.caminhoFxml = caminhoFxml;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static TelaEnum getDadosTelaEnumFromString(final String descricao){
		
		TelaEnum retorno = TelaEnum.TELA_NAO_CADASTRADA;
		
		for (TelaEnum telaController : TelaEnum.values()) {
			if(telaController.getDescricao().equals(descricao)){
				retorno = telaController;
				break;
			}
		}
		
		return retorno;
		
	}

}

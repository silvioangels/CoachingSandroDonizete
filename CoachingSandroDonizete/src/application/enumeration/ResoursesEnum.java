package application.enumeration;

public enum ResoursesEnum {
	
	IMAGEM_ABERTURA("/application/view/images/delphos_coaching_logo.jpg"),
	LINK_WEB_SITE("http://www.sandrodonizete.com/"),
	LINK_FACEBOOK("https://www.facebook.com/pages/Dicas-do-Coach-Sandro-Donizete/1408975239395175"),
	LINK_YOUTUBE("https://www.youtube.com/user/Sandrocoach"),
	LINK_MAPS("https://www.google.com.br/maps/place/Pra%C3%A7a+Oswaldo+Cruz,+124+-+Para%C3%ADso,+S%C3%A3o+Paulo+-+SP,+04004-903/@-23.570684,-46.6440383,17z/data=!3m1!4b1!4m2!3m1!1s0x94ce5997b5f3de65:0x9905b388a8b9b58b?hl=pt-BR"),
	PRE_LOADER_ALTURA("227"),
	PRE_LOADER_COMPRIMENTO("676"),
	PRINCIPAL_CABECALHO_ALTURA("100"),
	PRINCIPAL_MENU_COMPRIMENTO("200");

	ResoursesEnum(String caminhoRecurso){
		this.caminhoRecurso = caminhoRecurso;
	}
	
	private String caminhoRecurso;

	public String getRecurso() {
		return caminhoRecurso;
	}

	public static ResoursesEnum getDadosResoursesFromString(String descricao){
		
		ResoursesEnum retorno = null;
		
		for (ResoursesEnum telaController : ResoursesEnum.values()) {
			if(telaController.getRecurso().contains(descricao)){
				retorno = telaController;
			}
		}
		
		return retorno;
		
	}

}

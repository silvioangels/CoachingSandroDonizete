package application.bo;

public class FactoryBO {
	
	private static CadastroCoacheeBO cadastroCoacheeBO;
	
	private static InicioBO inicioBO;

	public static CadastroCoacheeBO getCadastroCoacheeBOInstance() {
		
		if(cadastroCoacheeBO == null){
			cadastroCoacheeBO = new CadastroCoacheeBO();
		}
		
		return cadastroCoacheeBO;
	}
	
	public static InicioBO getInicioBOInstance() {
		
		if(inicioBO == null){
			inicioBO = new InicioBO();
		}
		
		return inicioBO;
	}

}

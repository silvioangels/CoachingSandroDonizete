package application.bo;

public class FactoryBO {
	
	private static CadastroCoacheeBO cadastroCoacheeBO;

	public static CadastroCoacheeBO getCadastroCoacheeBOInstance() {
		
		if(cadastroCoacheeBO == null){
			cadastroCoacheeBO = new CadastroCoacheeBO();
		}
		
		return cadastroCoacheeBO;
	}
	
	

}

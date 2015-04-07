package application.bo;

import application.dao.GravacaoDadosDAO;
import application.model.ConsultaCoachee;


public class CadastroCoacheeBO {
	
	public void salvar(ConsultaCoachee consultaCoachee){
		GravacaoDadosDAO.getInstance().gravarConsultaCoachee(consultaCoachee);
	}

}

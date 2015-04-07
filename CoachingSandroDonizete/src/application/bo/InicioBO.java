package application.bo;

import javafx.collections.ObservableList;
import application.dao.GravacaoDadosDAO;
import application.model.ConsultaCoachee;


public class InicioBO {
	
	public ObservableList<ConsultaCoachee> recuperarTodasConsultasCoachee(){
		return GravacaoDadosDAO.getInstance().recuperarTodasConsultasCoachee();
	}

}

package application.model;

import javafx.beans.property.BooleanProperty;

public class ConsultaCoachee {
	
	private BooleanProperty coacheeAtivo;
	
	private CoacheePerson coachee;
	

	public CoacheePerson getCoachee() {
		
		if(coachee == null){
			coachee = new CoacheePerson();
		}
		
		return coachee;
	}

	public void setCoachee(CoacheePerson coachee) {
		this.coachee = coachee;
	}

	public BooleanProperty getCoacheeAtivo() {
		return coacheeAtivo;
	}

	public void setCoacheeAtivo(BooleanProperty coacheeAtivo) {
		this.coacheeAtivo = coacheeAtivo;
	}

}

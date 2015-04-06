package application.model;

public class ConsultaCoachee {
	
	private boolean coacheeAtivo;
	
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

	public boolean isCoacheeAtivo() {
		return coacheeAtivo;
	}

	public void setCoacheeAtivo(boolean coacheeAtivo) {
		this.coacheeAtivo = coacheeAtivo;
	}
	
}

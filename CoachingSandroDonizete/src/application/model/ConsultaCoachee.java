package application.model;

import java.util.Date;


public class ConsultaCoachee {
	
	private boolean coacheeAtivo = true;
	
	private Date dataUltimaSessao = new Date();
	
	private int numeroUltimaSessao = 0;
	
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

	public Date getDataUltimaSessao() {
		return dataUltimaSessao;
	}

	public void setDataUltimaSessao(Date dataUltimaSessao) {
		this.dataUltimaSessao = dataUltimaSessao;
	}

	public int getNumeroUltimaSessao() {
		return numeroUltimaSessao;
	}

	public void setNumeroUltimaSessao(int numeroUltimaSessao) {
		this.numeroUltimaSessao = numeroUltimaSessao;
	}
	
}

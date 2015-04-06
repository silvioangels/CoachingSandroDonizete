package application.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coachees")
public class CoacheeListWrapper {

	private List<ConsultaCoachee> listaConsultaCoachee;
	
	@XmlElement(name = "consultacoachee")
	public List<ConsultaCoachee> getCoacheepersons() {
		return listaConsultaCoachee;
	}

	public void setCoacheepersons(List<ConsultaCoachee> listaConsultaCoachee) {
		this.listaConsultaCoachee = listaConsultaCoachee;
	}

}

package application.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class ConsultaCoacheeWrapper {

	private ConsultaCoachee consultaCoachee;

	@XmlElement(name = "consultacoachee")
	public ConsultaCoachee getConsultaCoachee() {
		return consultaCoachee;
	}

	public void setConsultaCoachee(ConsultaCoachee consultaCoachee) {
		this.consultaCoachee = consultaCoachee;
	}
	
}

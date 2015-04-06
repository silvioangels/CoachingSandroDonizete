package application.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coachees")
public class CoacheeListWrapper {

	private List<CoacheePerson> coacheepersons;
	
	@XmlElement(name = "coachee")
	public List<CoacheePerson> getCoacheepersons() {
		return coacheepersons;
	}

	public void setCoacheepersons(List<CoacheePerson> coacheepersons) {
		this.coacheepersons = coacheepersons;
	}

}

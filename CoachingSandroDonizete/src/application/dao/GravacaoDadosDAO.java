package application.dao;

import java.io.File;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import application.model.CoacheeListWrapper;
import application.model.CoacheePerson;
import application.model.ConsultaCoachee;


public class GravacaoDadosDAO {
	
	
	public static void main(String[] args) {
		
		/*LEITURA*/
		/*try {
			JAXBContext context = JAXBContext.newInstance(CoacheeListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();
			
			File file = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+"testGravaJavafx.txt");
			
			// Reading XML from the file and unmarshalling.
			CoacheeListWrapper wrapper = (CoacheeListWrapper) um.unmarshal(file);
			
			ObservableList<CoacheePerson> coacheepersonsData = FXCollections.observableArrayList();
			coacheepersonsData.addAll(wrapper.getCoacheepersons());
			
			for (CoacheePerson coacheePerson : coacheepersonsData) {
				
				System.out.println(coacheePerson.getNomeCoachee());
				System.out.println(coacheePerson.getDtNascimento());
				
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*GRAVACAO*/
		CoacheePerson newCoachee = new CoacheePerson();
		newCoachee.setNomeCoachee("Silvio");
		newCoachee.setDtNascimento(new Date());
		
		ConsultaCoachee consultaCoachee = new ConsultaCoachee();
		
		consultaCoachee.setCoachee(newCoachee);
		consultaCoachee.setCoacheeAtivo(true);
		
		
		ObservableList<ConsultaCoachee> coacheepersonsData = FXCollections.observableArrayList();
		coacheepersonsData.add(consultaCoachee);
		
		
		File file = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+"gravados"+System.getProperty("file.separator")+"testGravaJavafx.txt");
		
		try {
			JAXBContext context = JAXBContext.newInstance(CoacheeListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Envolvendo nossos dados da pessoa.
			CoacheeListWrapper wrapper = new CoacheeListWrapper();
			wrapper.setCoacheepersons(coacheepersonsData);

			// Enpacotando e salvando XML no arquivo.
			m.marshal(wrapper, file);
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

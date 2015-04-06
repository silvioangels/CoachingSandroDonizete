package application.dao;


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
		/*CoacheePerson newCoachee = new CoacheePerson();
		newCoachee.setNomeCoachee("Silvio");
		newCoachee.setDtNascimento(new Date());
		
		ObservableList<CoacheePerson> coacheepersonsData = FXCollections.observableArrayList();
		coacheepersonsData.add(newCoachee);
		
		
		File file = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+"testGravaJavafx.txt");
		
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
		}*/
		
	}

}

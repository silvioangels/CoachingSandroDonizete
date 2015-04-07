package application.dao;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import application.model.ConsultaCoachee;
import application.model.ConsultaCoacheeWrapper;


public class GravacaoDadosDAO extends AbstractDadosDAO{
	
	public ObservableList<ConsultaCoachee> recuperarTodasConsultasCoachee(){
		
		ObservableList<ConsultaCoachee> listaConsultaCoachee = FXCollections.observableArrayList();
		
		try {
			File fileDiretorioArquivosSalvos = new File(diretorioArquivosSalvos);
			
			if(fileDiretorioArquivosSalvos.exists()){
				
				File listaArquivosSalvosDiretorio[] = fileDiretorioArquivosSalvos.listFiles();
				
				
				JAXBContext context = JAXBContext.newInstance(ConsultaCoacheeWrapper.class);
				Unmarshaller um = context.createUnmarshaller();
				
				for (File arquivoCoacheeSalvo : listaArquivosSalvosDiretorio) {
					// Reading XML from the file and unmarshalling.
					ConsultaCoacheeWrapper wrapper = (ConsultaCoacheeWrapper) um.unmarshal(arquivoCoacheeSalvo);
					ConsultaCoachee consultaCoacheeLido = wrapper.getConsultaCoachee();
					listaConsultaCoachee.add(consultaCoacheeLido);
					
				}
				
			}else{
				fileDiretorioArquivosSalvos.mkdir();
			}
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return listaConsultaCoachee;
	}

	public void gravarConsultaCoachee(ConsultaCoachee consultaCoachee) {
		try {

			JAXBContext context = JAXBContext.newInstance(ConsultaCoacheeWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Envolvendo nossos dados da pessoa.
			ConsultaCoacheeWrapper wrapper = new ConsultaCoacheeWrapper();
			wrapper.setConsultaCoachee(consultaCoachee);

			// Enpacotando e salvando XML no arquivo.
			m.marshal(wrapper, recuperarArquivoSalvo(consultaCoachee));

		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private File recuperarArquivoSalvo(ConsultaCoachee consultaCoachee){
		
		File fileArquivoParaSalvar = null;
		
		try {
			
			File fileDiretorioArquivosSalvos = new File(diretorioArquivosSalvos);
			
			if(!fileDiretorioArquivosSalvos.exists()){
				fileDiretorioArquivosSalvos.mkdir();
			}
			
			FilenameFilter filtro = new FilenameFilter(){
				@Override
	            public boolean accept(File dir, String name) {
					
	               if(name.lastIndexOf('.') > 0)
	               {
	                  // get last index for '.' char
	                  int lastIndex = name.lastIndexOf('.');
	                  
	                  // get extension
	                  String str = name.substring(lastIndex);
	                  
	                  SimpleDateFormat formatadorDMY = new SimpleDateFormat("dd_MM_yyyy");
	                  CharSequence nomeDoArquivo = 	consultaCoachee.getCoachee().getNomeCoachee().substring(0,10).replace(" ", "_").toLowerCase() +"_"+
													formatadorDMY.format(consultaCoachee.getCoachee().getDtNascimento());
	                  
	                  CharSequence nomeAtivo = "true";
	                  
	                  // match path name extension
	                  if(str.equals(".txt") && name.contains(nomeDoArquivo) && name.contains(nomeAtivo))
	                  {
	                     return true;
	                  }
	               }
	               return false;
	            }
			};
			
			File listaArquivosSalvosDiretorio[] = fileDiretorioArquivosSalvos.listFiles(filtro);
			
			String nomeDoArquivo;
			
			if(listaArquivosSalvosDiretorio.length > 0){
				
				nomeDoArquivo=listaArquivosSalvosDiretorio[0].getName();
				
			}else{
				SimpleDateFormat formatadorDMY = new SimpleDateFormat("dd_MM_yyyy");
				SimpleDateFormat formatadorDMYMS = new SimpleDateFormat("dd_MM_yyyy_mm_ss");
				GregorianCalendar gregCalendar = new GregorianCalendar();
				
				nomeDoArquivo = 	consultaCoachee.getCoachee().getNomeCoachee().substring(0,10).replace(" ", "_").toLowerCase() 	+"_"+
									formatadorDMY.format(consultaCoachee.getCoachee().getDtNascimento())							+"_"+
									formatadorDMYMS.format(gregCalendar.getTime())													+"_"+
									consultaCoachee.isCoacheeAtivo()																+".txt";
				
			}
			
			
			fileArquivoParaSalvar = new File(diretorioArquivosSalvos+nomeDoArquivo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileArquivoParaSalvar;
	}
	
}

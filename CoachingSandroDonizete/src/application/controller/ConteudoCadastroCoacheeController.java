package application.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import application.bo.FactoryBO;
import application.list.ListasEstaticas;



public class ConteudoCadastroCoacheeController extends AbstraticController implements Initializable{
	
	@FXML
	private Button btnSalvarInformacoes;
	
	@FXML
	private TextField nomeCoachee;
	
	@FXML
	private DatePicker dtNascimento;
	
	@FXML
	private TextField dddResidencial;
	
	@FXML
	private TextField foneResidencial;
	
	@FXML
	private TextField dddCelular;
	
	@FXML
	private TextField foneCelular;
	
	@FXML
	private ComboBox<String> escolaridade;
	
	@FXML
	private TextField profissao;
	
	@FXML
	private TextField cep;
	
	@FXML
	private TextField endereco;
	
	@FXML
	private TextField bairro;
	
	@FXML
	private TextField cidade;
	
	@FXML
	private ComboBox<String> estado;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField site;
	
	@FXML
	private TextField skype;
	
	@FXML
	private TextField twitter;
	
	@FXML
	private TextArea comoConheceu;
	
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		
		carregarListas();
		
	}
	
	@FXML
	private void salvarInformacoes() {

		try {
			
			if(validarPreenchimentoCamposObrigatorios()){
				
				this.preencherInformacoesTelaConsultaCoacche();
				FactoryBO.getCadastroCoacheeBOInstance().salvar(consultaCoacheeApplication);
				JOptionPane.showMessageDialog(null, "Dados Gravados com sucesso","Confirmação", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void preencherInformacoesTelaConsultaCoacche(){
		
		consultaCoacheeApplication.getCoachee().setNomeCoachee(new SimpleStringProperty(nomeCoachee.getText()));
		consultaCoacheeApplication.getCoachee().setDtNascimento(new SimpleObjectProperty<LocalDate>(dtNascimento.getValue()));
		consultaCoacheeApplication.getCoachee().setDddResidencial(new SimpleStringProperty(dddResidencial.getText()));
		consultaCoacheeApplication.getCoachee().setFoneResidencial(new SimpleStringProperty(foneResidencial.getText()));
		consultaCoacheeApplication.getCoachee().setDddCelular(new SimpleStringProperty(dddCelular.getText()));
		consultaCoacheeApplication.getCoachee().setFoneCelular(new SimpleStringProperty(foneCelular.getText()));
		consultaCoacheeApplication.getCoachee().setEscolaridade(new SimpleStringProperty(escolaridade.getValue()));
		consultaCoacheeApplication.getCoachee().setProfissao(new SimpleStringProperty(profissao.getText()));
		consultaCoacheeApplication.getCoachee().setCep(new SimpleStringProperty(cep.getText()));
		consultaCoacheeApplication.getCoachee().setEndereco(new SimpleStringProperty(endereco.getText()));
		consultaCoacheeApplication.getCoachee().setBairro(new SimpleStringProperty(bairro.getText()));
		consultaCoacheeApplication.getCoachee().setCidade(new SimpleStringProperty(cidade.getText()));
		consultaCoacheeApplication.getCoachee().setEstado(new SimpleStringProperty(estado.getValue()));
		consultaCoacheeApplication.getCoachee().setEmail(new SimpleStringProperty(email.getText()));
		consultaCoacheeApplication.getCoachee().setSite(new SimpleStringProperty(site.getText()));
		consultaCoacheeApplication.getCoachee().setSkype(new SimpleStringProperty(skype.getText()));
		consultaCoacheeApplication.getCoachee().setTwitter(new SimpleStringProperty(twitter.getText()));
		consultaCoacheeApplication.getCoachee().setComoConheceu(new SimpleStringProperty(comoConheceu.getText()));
		consultaCoacheeApplication.setCoacheeAtivo(new SimpleBooleanProperty(true));
	}
	
	private boolean validarPreenchimentoCamposObrigatorios(){
		
		boolean resultado = true;
		
		if(nomeCoachee.getText().isEmpty()){
			resultado = false;
		}
		
		return resultado;
		
	}
	
	private void carregarListas(){
		escolaridade.setItems(ListasEstaticas.getListaEscolaridade());
		estado.setItems(ListasEstaticas.getSiglasEstadosBrasileiros());
	}
	
	

}

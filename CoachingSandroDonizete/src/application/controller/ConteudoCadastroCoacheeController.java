package application.controller;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ResourceBundle;

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
import application.model.CoacheePerson;
import application.model.ConsultaCoachee;



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

		carregarDadosCoachee();
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
		
		CoacheePerson coacheePersonCadastrado = new CoacheePerson();
		coacheePersonCadastrado.setNomeCoachee(nomeCoachee.getText());
		coacheePersonCadastrado.setDtNascimento(Date.valueOf(dtNascimento.getValue()));
		coacheePersonCadastrado.setDddResidencial(dddResidencial.getText());
		coacheePersonCadastrado.setFoneResidencial(foneResidencial.getText());
		coacheePersonCadastrado.setDddCelular(dddCelular.getText());
		coacheePersonCadastrado.setFoneCelular(foneCelular.getText());
		coacheePersonCadastrado.setEscolaridade(escolaridade.getValue());
		coacheePersonCadastrado.setProfissao(profissao.getText());
		coacheePersonCadastrado.setCep(cep.getText());
		coacheePersonCadastrado.setEndereco(endereco.getText());
		coacheePersonCadastrado.setBairro(bairro.getText());
		coacheePersonCadastrado.setCidade(cidade.getText());
		coacheePersonCadastrado.setEstado(estado.getValue());
		coacheePersonCadastrado.setEmail(email.getText());
		coacheePersonCadastrado.setSite(site.getText());
		coacheePersonCadastrado.setSkype(skype.getText());
		coacheePersonCadastrado.setTwitter(twitter.getText());
		coacheePersonCadastrado.setComoConheceu(comoConheceu.getText());
		
		consultaCoacheeApplication = new ConsultaCoachee();
		consultaCoacheeApplication.setCoachee(coacheePersonCadastrado);
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
	
	private void carregarDadosCoachee(){
		
		if(consultaCoacheeApplication != null){
			nomeCoachee.setText(consultaCoacheeApplication.getCoachee().getNomeCoachee());
			dtNascimento.setValue(Instant.ofEpochMilli(consultaCoacheeApplication.getCoachee().getDtNascimento().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
			dddResidencial.setText(consultaCoacheeApplication.getCoachee().getDddResidencial());
			foneResidencial.setText(consultaCoacheeApplication.getCoachee().getFoneResidencial());
			dddCelular.setText(consultaCoacheeApplication.getCoachee().getDddCelular());
			foneCelular.setText(consultaCoacheeApplication.getCoachee().getFoneCelular());
			escolaridade.setValue(consultaCoacheeApplication.getCoachee().getEscolaridade());
			profissao.setText(consultaCoacheeApplication.getCoachee().getEscolaridade());
			cep.setText(consultaCoacheeApplication.getCoachee().getCep());
			endereco.setText(consultaCoacheeApplication.getCoachee().getEndereco());
			bairro.setText(consultaCoacheeApplication.getCoachee().getBairro());
			cidade.setText(consultaCoacheeApplication.getCoachee().getCidade());
			estado.setValue(consultaCoacheeApplication.getCoachee().getEstado());
			email.setText(consultaCoacheeApplication.getCoachee().getEmail());
			site.setText(consultaCoacheeApplication.getCoachee().getSite());
			twitter.setText(consultaCoacheeApplication.getCoachee().getTwitter());
			skype.setText(consultaCoacheeApplication.getCoachee().getSkype());
			comoConheceu.setText(consultaCoacheeApplication.getCoachee().getComoConheceu());
		}
		
	}
	
}

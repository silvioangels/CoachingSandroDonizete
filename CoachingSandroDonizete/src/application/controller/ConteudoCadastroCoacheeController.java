package application.controller;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.JOptionPane;

import application.bo.FactoryBO;
import application.list.ListasEstaticas;
import application.model.CoacheePerson;
import application.model.ConsultaCoachee;
import application.util.MaskFieldUtil;

public class ConteudoCadastroCoacheeController extends AbstraticController{
	
	@FXML
	private AnchorPane anchorPaneConteudoCadastroCoacheePrincipal;
	
	@FXML
	private ScrollPane scrollPaneConteudoCadastroCoachee;
	
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
	public void initialize(URL url, ResourceBundle resourses) {
		try {
			
			ajustarScrollComTamanhoResolucaoTela(scrollPaneConteudoCadastroCoachee);
			
			carregarListas();
			carregarDadosCoachee();
			carregarMascarasCamposEntrada();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
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
		
		String msgValidacao = null;
		
		boolean resultado = true;
		
			
		if(nomeCoachee.getText().isEmpty()){
			msgValidacao = "Favor preencher o campo de Nome";
			resultado = false;
		}else if(dtNascimento.getValue() == null){
			msgValidacao = "Favor inserir corretamente a data de nascimento no formato dd/mm/aaaa";
			resultado = false;
		}else if(dddResidencial.getText().isEmpty()){
			msgValidacao = "Favor preencher o campo de DDD do Telefone";
			resultado = false;
		}else if(foneResidencial.getText().isEmpty()){
			msgValidacao = "Favor preencher o campo de Telefone";
			resultado = false;
		}else if(dddCelular.getText().isEmpty()){
			msgValidacao = "Favor preencher o campo de DDD do Celular";
			resultado = false;
		}else if(foneCelular.getText().isEmpty()){
			msgValidacao = "Favor preencher o campo de Celular";
			resultado = false;
		}else if(escolaridade.getValue() == null){
			msgValidacao = "Favor selecionar alguma opção do campo de Escolaridade";
			resultado = false;
		}else if(profissao.getText().isEmpty()){
			msgValidacao = "Favor preencher o campo de Profissão";
			resultado = false;
		}else if(cep.getText().isEmpty()){
			msgValidacao = "Favor preencher o campo de Cep";
			resultado = false;
		}else if(endereco.getText().isEmpty()){
			msgValidacao = "Favor preencher o campo de Endereço";
			resultado = false;
		}else if(bairro.getText().isEmpty()){
			msgValidacao = "Favor preencher o campo de Bairro";
			resultado = false;
		}else if(cidade.getText().isEmpty()){
			msgValidacao = "Favor preencher o campo de Cidade";
			resultado = false;
		}else if(estado.getValue() == null){
			msgValidacao = "Favor selecionar alguma opção do campo de Estado";
			resultado = false;
		}			
			
		if(!resultado){
			JOptionPane.showMessageDialog(null, msgValidacao,"Validação", JOptionPane.WARNING_MESSAGE);
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
			profissao.setText(consultaCoacheeApplication.getCoachee().getProfissao());
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
	
	private void carregarMascarasCamposEntrada(){
		
		//Dados Coachee
		MaskFieldUtil.maxField(nomeCoachee, 70);
		MaskFieldUtil.dddField(dddResidencial);
		MaskFieldUtil.foneField(foneResidencial);
		MaskFieldUtil.dddField(dddCelular);
		MaskFieldUtil.celularField(foneCelular);
		MaskFieldUtil.maxField(profissao, 50);
		
		//Dados Endereço
		MaskFieldUtil.cepField(cep);
		MaskFieldUtil.maxField(endereco, 30);
		MaskFieldUtil.maxField(bairro, 30);
		MaskFieldUtil.maxField(cidade, 30);
		
		//Dados Digitais
		MaskFieldUtil.maxField(email, 40);
		MaskFieldUtil.maxField(site, 40);
		MaskFieldUtil.maxField(skype, 40);
		MaskFieldUtil.maxField(twitter, 40);
		MaskFieldUtil.maxField(comoConheceu, 200);
		
		
	}
	
}

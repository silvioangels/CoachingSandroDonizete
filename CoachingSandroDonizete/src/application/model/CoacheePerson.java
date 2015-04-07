package application.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class CoacheePerson {
	
	private StringProperty nomeCoachee;
	
	private ObjectProperty<LocalDate> dtNascimento;
	
	private StringProperty dddResidencial;
	
	private StringProperty foneResidencial;
	
	private StringProperty dddCelular;
	
	private StringProperty foneCelular;
	
	private StringProperty escolaridade;
	
	private StringProperty profissao;
	
	private StringProperty cep;
	
	private StringProperty endereco;
	
	private StringProperty bairro;
	
	private StringProperty cidade;
	
	private StringProperty estado;
	
	private StringProperty email;
	
	private StringProperty site;
	
	private StringProperty skype;
	
	private StringProperty twitter;
	
	private StringProperty comoConheceu;

	public StringProperty getNomeCoachee() {
		return nomeCoachee;
	}

	public void setNomeCoachee(StringProperty nomeCoachee) {
		this.nomeCoachee = nomeCoachee;
	}

	public ObjectProperty<LocalDate> getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(ObjectProperty<LocalDate> dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public StringProperty getDddResidencial() {
		return dddResidencial;
	}

	public void setDddResidencial(StringProperty dddResidencial) {
		this.dddResidencial = dddResidencial;
	}

	public StringProperty getFoneResidencial() {
		return foneResidencial;
	}

	public void setFoneResidencial(StringProperty foneResidencial) {
		this.foneResidencial = foneResidencial;
	}

	public StringProperty getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(StringProperty dddCelular) {
		this.dddCelular = dddCelular;
	}

	public StringProperty getFoneCelular() {
		return foneCelular;
	}

	public void setFoneCelular(StringProperty foneCelular) {
		this.foneCelular = foneCelular;
	}

	public StringProperty getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(StringProperty escolaridade) {
		this.escolaridade = escolaridade;
	}

	public StringProperty getProfissao() {
		return profissao;
	}

	public void setProfissao(StringProperty profissao) {
		this.profissao = profissao;
	}

	public StringProperty getCep() {
		return cep;
	}

	public void setCep(StringProperty cep) {
		this.cep = cep;
	}

	public StringProperty getEndereco() {
		return endereco;
	}

	public void setEndereco(StringProperty endereco) {
		this.endereco = endereco;
	}

	public StringProperty getBairro() {
		return bairro;
	}

	public void setBairro(StringProperty bairro) {
		this.bairro = bairro;
	}

	public StringProperty getCidade() {
		return cidade;
	}

	public void setCidade(StringProperty cidade) {
		this.cidade = cidade;
	}

	public StringProperty getEstado() {
		return estado;
	}

	public void setEstado(StringProperty estado) {
		this.estado = estado;
	}

	public StringProperty getEmail() {
		return email;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public StringProperty getSite() {
		return site;
	}

	public void setSite(StringProperty site) {
		this.site = site;
	}

	public StringProperty getSkype() {
		return skype;
	}

	public void setSkype(StringProperty skype) {
		this.skype = skype;
	}

	public StringProperty getTwitter() {
		return twitter;
	}

	public void setTwitter(StringProperty twitter) {
		this.twitter = twitter;
	}

	public StringProperty getComoConheceu() {
		return comoConheceu;
	}

	public void setComoConheceu(StringProperty comoConheceu) {
		this.comoConheceu = comoConheceu;
	}

}

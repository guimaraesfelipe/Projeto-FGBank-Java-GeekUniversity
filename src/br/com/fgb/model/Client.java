package br.com.fgb.model;

import java.util.Date;

import br.com.fgb.helper.Utils;

public class Client {
	private static int counter = 10001;
	private int code;
	private String name;
	private String mail;
	private String cpf;
	private Date birthDate;
	private Date registrationDate;
	
	public Client(String name, String mail, String cpf, Date birthDate) {
		this.code = Client.counter;
		this.name = name;
		this.mail = mail;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.registrationDate = new Date();
		Client.counter++;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Date getRegistrationDate() {
		return this.registrationDate;
	}
	
	@Override
	public String toString() {
		return "Código: " + this.getCode() + "\nNome: " + this.getName() + "\nCPF: " + this.getCpf() + "\nE-mail: " + this.getMail() + "\nData de Nascimento: " + Utils.dateToString(this.getBirthDate()) + "\nData de Cadastro: " + Utils.dateToString(this.getRegistrationDate());
	}
	
}

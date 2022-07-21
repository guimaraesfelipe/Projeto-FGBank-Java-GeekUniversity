package br.com.fgb.model;

import br.com.fgb.helper.Utils;

public class Account {
	private static int code = 10001;
	private int number;
	private Client client;
	private Double balance = 0.00;
	private Double limit = 0.00;
	private Double totalBalance;
	
	public Account(Client client) {
		this.number = Account.code;
		this.client = client;
		Account.code++;
		this.updateTotalBalance();
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getLimit() {
		return limit;
	}
	public void setLimit(Double limit) {
		this.limit = limit;
		this.updateTotalBalance();
	}
	public int getNumber() {
		return number;
	}
	public Double getTotalBalance() {
		return totalBalance;
	}
	
	private void updateTotalBalance() {
		this.totalBalance = this.getBalance() + this.getLimit(); //somente soma
	}
	
	@Override
	public String toString() {
		return "Número da Conta: " + this.getNumber() + "\nCliente: " + this.client.getName() + "\nSaldo Total: " + Utils.doubleToString(this.getTotalBalance());
	}
	
	public void deposit(Double value) {
		if(value > 0) {
			this.balance = this.getBalance() + value;
			this.updateTotalBalance();
			System.out.println("Depósito efetuado com sucesso!");
		}else {
			System.out.println("Valor invalido. Tente novamente.");
		}
	}
	
	public void withdraw(Double value) {
		if(value > 0 && this.getTotalBalance() >= value) {
			if(this.getBalance() >= value) {
				this.balance = this.getBalance() - value;
				this.updateTotalBalance();
				System.out.println("Saque efetuado com sucesso!");
			}else {
				Double remaining = this.getBalance() - value; // sem limite para o limite
				this.limit = this.getLimit() + remaining;
				this.balance = 0.0;
				this.updateTotalBalance();
				System.out.println("Saque efetuado com sucesso!");
			}
		}else {
			System.out.println("Saque não autorizado.");
		}
	
	}
	
	public void transfer(Account beneficiary, Double value) {
		if(value > 0 && this.getTotalBalance() >= value) {
			if(this.getBalance() >= value) {
				this.balance = this.getBalance() - value;
				beneficiary.balance = beneficiary.getBalance() + value;
				this.updateTotalBalance();
				beneficiary.updateTotalBalance();
				System.out.println("Transferência realizada com sucesso!");
			}else {
				Double remaining = this.getBalance() - value;
				this.limit = this.getLimit() + remaining;
				beneficiary.balance = beneficiary.getBalance() + value;
				this.updateTotalBalance();
				beneficiary.updateTotalBalance();
				System.out.println("Transferência realizada com sucesso!");
			}
		}else {
			System.out.println("Transferência não autorizado.");
		}
	}
	
}
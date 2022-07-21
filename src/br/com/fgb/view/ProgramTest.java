package br.com.fgb.view;

import br.com.fgb.helper.Utils;
import br.com.fgb.model.Account;
import br.com.fgb.model.Client;

public class ProgramTest {

	public static void main(String[] args) {
		Client client1 = new Client("CLIENTE UM", "CLIENTE.UM@DOMAIN.COM", "123.456.789-10", Utils.stringToDate("01/01/1990"));
		Client client2 = new Client("CLIENTE DOIS", "CLIENTE.DOIS@DOMAIN.COM", "019.876.543-21", Utils.stringToDate("02/02/1991"));
		
		Account account1 = new Account(client1);
		Account account2 = new Account(client2);
		
		account1.deposit(500.00);
		account2.deposit(500.00);
		
		account1.setLimit(300.00);
		account2.setLimit(300.00);
		
		account1.transfer(account2, -100.00);
		
		System.out.println();
		System.out.println(account1);
		System.out.println();
		System.out.println(account2);
	}

}

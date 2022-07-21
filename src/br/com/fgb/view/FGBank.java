package br.com.fgb.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.fgb.helper.Utils;
import br.com.fgb.model.Account;
import br.com.fgb.model.Client;

public class FGBank {

	static String name = "FGBank";
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Account> accounts;

	public static void main(String[] args) {
		accounts = new ArrayList<Account>();
		menu();
	}

	public static void menu() {
		int option = 0;
		System.out.println("================ FGB ATM ================");
		System.out.println("Selecione uma das opções abaixo: ");
		System.out.println("1 - Abertura de contas");
		System.out.println("2 - Saque em conta");
		System.out.println("3 - Depósito em conta");
		System.out.println("4 - Transferências");
		System.out.println("5 - Visualizar contas");
		System.out.println("6 - Sair");

		try {
			option = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Opção invalida. Informe uma das opções apresentadas no sistema.");
			Utils.pause(2);
			menu();
		}

		switch (option) {
		case 1:
			opening();
			break;
		case 2:
			withdraw();
			break;
		case 3:
			deposit();
			break;
		case 4:
			transfer();
			break;
		case 5:
			toView();
			break;
		case 6:
			System.out.println("Obrigado por escolher o FGBank.\nAté a próxima!");
			Utils.pause(2);
			System.exit(0);
		default:
			System.out.println("Opção invalida. Informe uma das opções apresentadas no sistema.");
			Utils.pause(2);
			menu();
			break;
		}

	}

	private static void opening() {
		System.out.println("==================\nAbertura de Contas\n==================");
		System.out.println("Informe o nome do cliente: ");
		String name = sc.nextLine();

		System.out.println("Informe o e-mail do cliente: ");
		String mail = sc.nextLine();

		System.out.println("Informe o CPF do cliente: ");
		String cpf = sc.nextLine();

		System.out.println("Informe a data de nascimento do cliente: ");
		String birthDate = sc.nextLine();

		Client client = new Client(name, mail, cpf, Utils.stringToDate(birthDate));
		Account account = new Account(client);
		accounts.add(account);

		System.out.println("Abertura de conta efetuada com sucesso!");
		System.out.println();
		System.out.println("Dados da nova conta:\n" + account);
		System.out.println();

		Utils.pause(4);
		menu();
	}

	private static void withdraw() {
		System.out.println("=============\nEfetuar Saque\n=============");
		System.out.println("Informe o número da conta para saque: ");
		int numberAccount = Integer.parseInt(sc.nextLine());

		Account account = searchAccountByNumber(numberAccount);

		if (account != null) {
			System.out.println("Informe o valor que deseja sacar: ");
			Double value = sc.nextDouble();

			account.withdraw(value);

		} else {
			System.err.println("Número da conta não localizado.");
		}

		Utils.pause(3);
		menu();
	}

	private static void deposit() {
		System.out.println("=================\nDepósito em Conta\n=================");
		System.out.println("Informe o número da conta: ");
		int numberAccount = Integer.parseInt(sc.nextLine());

		Account account = searchAccountByNumber(numberAccount);

		if (account != null) {
			System.out.println("Informe o valor que deseja depositar: ");
			Double value = sc.nextDouble();

			account.deposit(value);

		} else {
			System.err.println("Número da conta não localizado.");
		}

		Utils.pause(3);
		menu();
	}

	private static void transfer() {
		System.out.println("======================\nTransferência Bancária\n======================");
		System.out.println("Informe o número da conta que irá efetuar o depósito: ");
		int numberAccountOrigin = Integer.parseInt(sc.nextLine());

		Account accountOrigin = searchAccountByNumber(numberAccountOrigin);

		if (accountOrigin != null) {
			System.out.println("Informe o número da conta beneficiária: ");
			int numberAccountDestination = Integer.parseInt(sc.nextLine());

			Account accountDestination = searchAccountByNumber(numberAccountDestination);

			if (accountDestination != null) {
				System.out.println("Informe o valor a ser transferido: ");
				Double value = sc.nextDouble();

				accountOrigin.transfer(accountDestination, value);
			} else {
				System.err.println("Número da conta de destino não localizado.");
			}

		} else {
			System.err.println("Número da conta de origen não localizado.");
		}

		Utils.pause(3);
		menu();

	}

	private static void toView() {
		if (accounts.size() > 0) {
			System.out.println("==================\nListagem de Contas\n==================");
			System.out.println();

			for (Account account : accounts) {
				System.out.println(account);
				System.out.println("--------------------");
			}

		} else {
			System.out.println("Não existem contas abertas no sistema.");
		}

		Utils.pause(3);
		menu();
	}

	private static Account searchAccountByNumber(int number) {
		Account accountByNumber = null;
		if (accounts.size() > 0) {

			for (Account account : accounts) {
				if (account.getNumber() == number) {
					accountByNumber = account;
				}
			}
		}
		return accountByNumber;
	}

}

package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

/**
 * Bank Account application, a file of customer information is read to be
 * processed in this application
 * 
 * @author sahand-j
 *
 */
public class BankAccountApp {
	public static void main(String[] args) {

		List<Account> accounts = new LinkedList<Account>();

		// read a csv file create accounts based on that data
		String file = "/Users/sahand-j/Desktop/NewBankAccounts.csv";
		List<String[]> newAccHolders = utilities.CSV.read(file);
		for (String[] accountHolder : newAccHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);

			System.out.println(name + " " + sSN + " " + accountType + " " + initDeposit);
			System.out.println("********************");
			System.out.println("");

			if (accountType.equals("Savings")) {
				System.out.println("OPEN A SAVINGS ACCOUNT");
				accounts.add(new Savings(name, sSN, initDeposit));

			} else if (accountType.equals("Checking")) {
				System.out.println("Open A CHECKINGS ACCOUNT");
				accounts.add(new Checking(name, sSN, initDeposit));
			} else {
				System.out.println("ERROR");
			}
		}

		for (Account acc : accounts) {
			System.out.println("\n************");
			acc.showInfo();
		}
	}
}

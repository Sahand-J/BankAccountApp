package bankaccountapp;

/**
 * Class specific to checking account properties
 * 
 * @author sahand-j
 *
 */
public class Checking extends Account {

	// list properties specific to checking account
	private int debitCardNumber, debitCardPin;

	// that initializes account properties
	/**
	 * Initializing checking account properties
	 * 
	 * @param name        account holders full name
	 * @param sSn         account holders SSN
	 * @param initDeposit initial dolalr amount to deposit into account
	 */
	public Checking(String name, String sSn, double initDeposit) {
		super(name, sSn, initDeposit);
		accountNumber = 2 + accountNumber;
		setDebitCard();
	}

	/**
	 * helper method to set base interest rate rate is 15% of base rate from
	 * Interface
	 */
	public void setRate() {
		rate = getBaseRate() * .15;
	}

	/**
	 * helper method to intialize customers unique debitcatd number and pin
	 */
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}

	/**
	 * helper method to Show Checking account information
	 */
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checking Account features" + "\nDebit Card Number: " + debitCardNumber
				+ "\nDebit Card Pin: " + debitCardPin);
	}

}

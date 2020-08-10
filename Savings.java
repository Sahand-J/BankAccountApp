package bankaccountapp;

/**
 * Class specific to savings account properties
 * 
 * @author sahand-j
 *
 */
public class Savings extends Account {

	// list properties specific to savings account
	private int safetyDepositBoxID, safetyDepositBoxKey;

	/**
	 * constructor to initialize setting for savings properties
	 * 
	 * @param name        account hoders full name
	 * @param sSn         account holders SSN
	 * @param initDeposit initial amount to deposit
	 */
	public Savings(String name, String sSn, double initDeposit) {

		super(name, sSn, initDeposit);
		accountNumber = 1 + accountNumber;
		setSafetyDepositBox();
	}

	/**
	 * helper method that generates and sets safety deposit box ID generates number
	 * to have 3 digit box ID and key
	 */
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
		System.out.println("safety key" + safetyDepositBoxID);
	}

	/**
	 * helper method to display Savings account information
	 */
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: SAVINGS");
		super.showInfo();

		System.out.println("Your Savings Account features" + "\nSafety Deposit Box ID: " + safetyDepositBoxID
				+ "\nSafety Depostit Box Key: " + safetyDepositBoxKey);
	}

	/**
	 * sets savings account interest rate based on given criteria
	 */
	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}
}

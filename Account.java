package bankaccountapp;

/**
 * Super class for shared Bank Account assets
 * 
 * @author sahand-j
 */
public abstract class Account implements IBaseRate {

	private String name, sSN;
	protected String accountNumber;
	protected double rate;
	private double balance;
	private static int index = 10000;

	public Account(String name, String sSn, double initDeposit) {
		this.name = name;
		this.sSN = sSn;
		balance = initDeposit;
		this.accountNumber = setAccountNumber();
		setRate();
	}

	public abstract void setRate();

	/**
	 * Sets account number: 1 for savings, 2 for checking, last 2 numbers of ssn,
	 * generated 5 digit number and 3 random numbers
	 * 
	 * @return unique account number based on SSN and account type
	 */
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
		int uniqueID = index;
		index++;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}

	/**
	 * Prints basic Account information
	 */
	public void showInfo() {
		System.out.println("NAME: " + name + "\nACCOUNT NUMBER " + accountNumber + "\nBALANCE: " + balance + "\nRate "
				+ rate + "%");
	}

	/**
	 * method to deposit money into the account
	 * 
	 * @param amount the dollar amount to deposit
	 */
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing $" + amount);
	}

	/**
	 * method to withdraw money from account
	 * 
	 * @param amount dollar amount to withdraw
	 */
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}

	/**
	 * Method to transfer dollar amount from one account to another
	 * 
	 * @param toWhere location for dollar amount to be transfered
	 * @param amount  dollar amount to transfer
	 */
	public void transfer(String toWhere, double amount) {
		balance -= amount;
		System.out.println("transfering $" + amount + "to " + toWhere);
		printBalance();
	}

	/**
	 * helper method to display current Balance
	 */
	public void printBalance() {
		System.out.println("Your Balance is now: $" + balance);
	}

	/**
	 * helper method to compute compounded interest based on the set rate
	 * 
	 */
	public void compound() {
		double accruedInterest = balance * (rate / 100);
		balance += accruedInterest;
		System.out.println("Accrued Interest: " + accruedInterest);
	}

}

package bankaccountapp;

public interface IBaseRate {

	/**
	 * interface binding program to a set interest rate
	 * 
	 * @return base interest rate set by outer source
	 */
	default double getBaseRate() {
		return 2.5;
	}

}

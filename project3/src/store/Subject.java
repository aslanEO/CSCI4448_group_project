package store;

//import java.util.List;

import customers.Customer;


public interface Subject {
	/**
	 * Subject interface in the observer pattern
	 * 
	 */
	
	public void registerCustomer(Customer c);
	public void removeCustomer(Customer c);
	public void notifyCustomersShortage(String customerType);
	public void notifyCustomersSupply(String customerType);
}

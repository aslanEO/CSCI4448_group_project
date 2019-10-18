package customers;


public abstract class CustomerFactory {
	/**
	 * Creator in the factory pattern
	 */
	
	
	public abstract Customer createCustomer(String type, String name);
	
}

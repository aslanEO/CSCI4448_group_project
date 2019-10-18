package customers;


public class CustomerFactoryConcrete extends CustomerFactory{
	/**
	 * Concrete Creator in the factory pattern
	 */

	@Override
	public Customer createCustomer(String type, String name) {
		if (type.equals("Business")) {
			return new CustomerBusiness(name);
		} else if (type.equals("Casual")) {
			return new CustomerCasual(name);
		} else if (type.equals("Regular")) {
			return new CustomerRegular(name);
		} else {
			System.out.println("!!!Unknown customer type identified; A causal customer has been created in place of the Unknown tool!!!");
			return new CustomerCasual(name);
		}
	}
}

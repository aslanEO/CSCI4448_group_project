package customers;


public class CustomerCasual extends Customer {

	public CustomerCasual(String name) {
		super(name);
	}


	@Override
	public int RestrictionOfToolsNum(Customer c, int limit) {
		if (limit == 1) {
			return 1;
		} else {
			return (int)(2.0 * Math.random()) + 1;
		}
	    
	}

	@Override
	public int RestrictionOfRentNight(Customer c) {
	    return (int)(2.0 * Math.random()) + 1;
	}

	@Override
	public String getCustomerType() {
	    return "Casual";
	}
	
}

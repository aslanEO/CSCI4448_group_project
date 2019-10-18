package customers;

public class CustomerRegular extends Customer {

	public CustomerRegular(String name) {
		super(name);
	}

	
	@Override
	public String getCustomerType() {
	    return "Regular";
	}

	@Override
	public int RestrictionOfToolsNum(Customer c, int limit) {
		if (limit == 1) {
			return 1;
		} else {
			return (int)(Math.min(limit, 3.0) * Math.random()) + 1;
		}
	}

	@Override
	public int RestrictionOfRentNight(Customer c) {
	    return (int)(3.0 * Math.random()) + 3;
	}

}

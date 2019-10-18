package customers;


public class CustomerBusiness extends Customer{
	/**
	 * Concrete Observer in the observer pattern
	 * 
	 */

    public CustomerBusiness(String name) {
		super(name);
	}
    
    @Override
	public String getCustomerType() {
	    return "Business";
	}
    
    
    @Override
	public int RestrictionOfToolsNum(Customer c, int limit) {
	    return 3;
	}

	@Override
	public int RestrictionOfRentNight(Customer c) {
	    return 7;
	}

}

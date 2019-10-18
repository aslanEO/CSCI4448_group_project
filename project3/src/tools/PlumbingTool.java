package tools;


public class PlumbingTool extends Tool {
	/**
	 * Concrete product in the factory pattern
	 * Concrete component in the decorator pattern
	 */
	
	public PlumbingTool(String name) {
		super(name);
		category = "Plumbing";
	}

	@Override
	public double cost(int nightNum) {
		return 10.00 * nightNum;
	}
}

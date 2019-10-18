package tools;


public class WoodworkTool extends Tool {
	/**
	 * Concrete product in the factory pattern
	 * Concrete component in the decorator pattern
	 */
	
	public WoodworkTool(String name) {
		super(name);
		category = "Woodwork";
	}

	@Override
	public double cost(int nightNum) {
		return 30.00 * nightNum;
	}
}

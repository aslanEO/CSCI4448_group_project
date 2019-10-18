package tools;


public class YardworkTool extends Tool {
	/**
	 * Concrete product in the factory pattern
	 * Concrete component in the decorator pattern
	 */
	
	public YardworkTool(String name) {
		super(name);
		category = "Yardwork";
	}

	@Override
	public double cost(int nightNum) {
		return 15.00 * nightNum;
	}
}

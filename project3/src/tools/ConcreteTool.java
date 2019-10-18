package tools;

public class ConcreteTool extends Tool {
	/**
	 * Concrete product in the factory pattern
	 * Concrete component in the decorator pattern
	 */
	
	public ConcreteTool(String name) {
		super(name);
		category = "Concrete";
	}

	@Override
	public double cost(int nightNum) {
		return 25.00 * nightNum;
	}
}

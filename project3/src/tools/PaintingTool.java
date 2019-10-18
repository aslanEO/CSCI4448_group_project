package tools;


public class PaintingTool extends Tool {
	/**
	 * Concrete product in the factory pattern
	 * Concrete component in the decorator pattern
	 */
	
	public PaintingTool(String name) {
		super(name);
		category = "Painting";
	}

	@Override
	public double cost(int nightNum) {
		return 20.00 * nightNum;
	}
}

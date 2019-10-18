package tools;


public class ToolFactoryConcrete extends ToolFactory{
	/**
	 * Concrete Creator in the factory pattern
	 */

	@Override
	public Tool createTool(String category, String name) {
		if (category.equals("Painting")) {
			return new PaintingTool(name);
		} else if (category.equals("Concrete")) {
			return new ConcreteTool(name);
		} else if (category.equals("Plumbing")) {
			return new PlumbingTool(name);
		} else if (category.equals("Woodwork")) {
			return new WoodworkTool(name);
		} else if (category.equals("Yardwork")) {
			return new YardworkTool(name);
		} else {
			System.out.println("!!!Unknown tool category identified; A YardworkTool has been created in place of the Unknown tool!!!");
			return new YardworkTool(name);
		}
	}
	
	

}

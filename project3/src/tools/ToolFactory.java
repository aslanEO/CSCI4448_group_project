package tools;


public abstract class ToolFactory {
	/**
	 * Creator in the factory pattern
	 */
	
	
	public abstract Tool createTool(String category, String name);
	
}

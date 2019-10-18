package tools;



public abstract class OptionDecorator extends Tool {
	
	/**
	 * Abstract Decorator in the decorator pattern
	 * extends Tool to make sure options are of the same type as tools.
	 */
	
	protected Tool tool;
	
	public OptionDecorator(Tool tool) {
		super(tool.getName());
		this.tool = tool;
	}
	

	public String getCategory() {
		return tool.getCategory();
	}
	
	public abstract double cost(int nightNum);

}

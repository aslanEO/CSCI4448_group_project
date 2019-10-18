package tools;



public class OptionDecoratorExtension extends OptionDecorator {
	/**
	 * 
	 * Concrete decorator in the decorator pattern
	 */
	
	public OptionDecoratorExtension(Tool tool) {
		super(tool);
		options = tool.options;
		options.add("Extension");
	}


	@Override
	public double cost(int nightNum) {
		if (tool.getCategory().equals("Painting")){
			return tool.cost(nightNum) + 5.00;
		}
		else if (tool.getCategory().equals("Plumbing")){
			return tool.cost(nightNum) + 3.00;
		}
		else if (tool.getCategory().equals("Concrete")){
			return tool.cost(nightNum) + 4.00;
		}
		else if (tool.getCategory().equals("Woodwork")){
			return tool.cost(nightNum) + 10.00;
		}
		else {//Yardwork
			return tool.cost(nightNum) + 8.00;
		}

	}
}

package tools;

import java.util.ArrayList;
import java.util.List;


public abstract class Tool {
	/**
	 * Product in the factory pattern
	 * Abstract Component in the decorator pattern
	 */
	
	public String name;
	String category;
	public List<String> options = new ArrayList<>();
		
	public Tool(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() { 
		return name;
	}

	public String getCategory() {
		return category;
	}
	
	public abstract double cost(int nightNum);

}

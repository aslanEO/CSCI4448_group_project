package customers;

import store.*;

import java.util.ArrayList;
import java.util.List;
import tools.*;

public abstract class Customer implements Observer {
	/**
	 * Concrete observer in the observer pattern
	 */
    protected String name;
    protected Tool tool;
    protected int nightNum;

    public Customer(String name) {
    	this.name = name;
    }

    public String getCustomerName() {
        return name;
    }
    
    public void updateShortage(DataManager dm) {
    	dm.removeCustomer(this);
    }
    
    public void updateSupply(DataManager dm) {
    	dm.registerCustomer(this);
    }

    public Tool addOptions(Tool tool, int optionNum, List<String> optionNameList) {
    	for (int i = 0; i < optionNum; i++) {
    		int ind = (int)(3 * Math.random());
    		String option = optionNameList.get(ind);
    		if (option.equals("Accessory")) {
    			tool = new OptionDecoratorAccessory(tool);
    		} else if (option.equals("Extension")) {
    			tool = new OptionDecoratorExtension(tool);
    		} else if (option.equals("Protective")) {
    			tool = new OptionDecoratorProtective(tool);
    		}
    		else {
    			System.out.println("Option Name not found");
			}
    	}
    	return tool;
    }
    
    
	public List<Object> rentTools(List<Tool> toolInventoryList, List<String> optionNameList, int limit) {
        
		int toolsNum = RestrictionOfToolsNum(this, limit); //randomly choose toolsNum tools from toolInventoryList
		if (toolInventoryList.size() != 0 && toolsNum > toolInventoryList.size()){
			toolsNum = toolInventoryList.size();
		}

		int nightNum = RestrictionOfRentNight(this); //randomly decide nightNum nights to rent the tools
		List<Object> rentInfo = new ArrayList<>();
		List<Tool> rentedTools = new ArrayList<>();
		double totalPay = 0.00;
		
		// rentInfo = [nightNum, toolsWithOptions, payment]
		rentInfo.add(nightNum);

        for (int j = 0; j < toolsNum; j++) {
			//decide which tool to rent
        	if (toolInventoryList.size() != 0) {
				int ind = (int)(toolInventoryList.size() * Math.random());
				Tool tool = toolInventoryList.get(ind);
				toolInventoryList.remove(tool);
		
				// add options to the tool
				int optionNum = (int)(Math.random() * 6);
				tool = addOptions(tool, optionNum, optionNameList);
				rentedTools.add(tool);
				totalPay += tool.cost(nightNum);
        	}
        }
        rentInfo.add(rentedTools);
        rentInfo.add(totalPay);
        return rentInfo;	
	}
    
    
    public abstract int RestrictionOfToolsNum(Customer c, int limit);

    public abstract int RestrictionOfRentNight(Customer c);
    
    public abstract String getCustomerType();

}

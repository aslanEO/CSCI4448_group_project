package store;

import tools.*;
import customers.*;

import java.util.*;

public class DataManager implements Subject {
	/**
	 * Concrete subject in the observer pattern
	 */
	
	private List<String> toolNameList = new ArrayList<>();
    private List<Tool> toolInventoryList = new ArrayList<>();

    private List<String> optionNameList = new ArrayList<>();

    private List<String> customerNameList = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    List<Customer> originalCustomerList = new ArrayList<>();
    
	
	private ArrayList<Customer> businessCustomers = new ArrayList<>();
	private ArrayList<Customer> otherCustomers = new ArrayList<>();


	private ToolFactoryConcrete toolFactoryConcrete = new ToolFactoryConcrete();
	private CustomerFactoryConcrete customerFactoryConcrete = new CustomerFactoryConcrete();

	@Override
	public void registerCustomer(Customer c) {
		customerList.add(c);
		if (c.getCustomerType().equals("Business")) {
			businessCustomers.add(c);
		} else {
			otherCustomers.add(c);
		}
	}

	@Override
	public void removeCustomer(Customer c) {
		customerList.remove(c);
		if (c.getCustomerType().equals("Business")) {
			businessCustomers.remove(c);
		} else {
			otherCustomers.remove(c);
		}
	}

	@Override
	public void notifyCustomersShortage(String customerType) {
		for (Customer customer : originalCustomerList) {
			if (customer.getCustomerType().equals(customerType)) {
        		customer.updateShortage(this);
        	}
		}
	}

	
	@Override
	public void notifyCustomersSupply(String customerType) {
        for (Customer customer : originalCustomerList) {
        	if (customer.getCustomerType().equals(customerType)) {
        		customer.updateSupply(this);
        	}	
		}
	}
	
	
	void addCustomer(Customer c) {
		customerList.add(c);
		if (c.getCustomerType().equals("Business")) {
			businessCustomers.add(c);
		}
		if (c.getCustomerType().equals("Casual")) {
			otherCustomers.add(c);
		}
		if (c.getCustomerType().equals("Regular")) {
			otherCustomers.add(c);
		}
	}
	
	void deleteCustomer(Customer c) {
		customerList.remove(c);
		if (c.getCustomerType().equals("Business")) {
			businessCustomers.remove(c);
		}
		if (c.getCustomerType().equals("Casual")) {
			otherCustomers.remove(c);
		}
		if (c.getCustomerType().equals("Regular")) {
			otherCustomers.remove(c);
		}
	}
	
	
	public void inventoryDecreased(List<Tool> toolInventoryList) {
		if (toolInventoryList.size() < 3 && businessCustomers.size() != 0) {
			notifyCustomersShortage("Business");
		}
		if (toolInventoryList.size() == 0 && otherCustomers.size() != 0) {
			notifyCustomersShortage("Casual");
			notifyCustomersShortage("Regular");
		}
	}
	
	public void inventoryIncreased(List<Tool> toolInventoryList) {
		if (toolInventoryList.size() >= 3 && businessCustomers.size() == 0) {
			notifyCustomersSupply("Business");
		}
		
		if (toolInventoryList.size() >= 1 && otherCustomers.size() == 0) {
			notifyCustomersSupply("Casual");
			notifyCustomersSupply("Regular");
		}
	}
	

    
    List<Object> setCustomerActiveRental(Customer c, int date, List<Tool> toolInventoryList, int limit) {
    	List<Object> activeList = new ArrayList<>();
    	
    	List<String> optionNameList = createOptionNameList();
    	List<Object> rentInfo = c.rentTools(toolInventoryList, optionNameList, limit); // rentInfo = [nightNum, toolsWithOptions, payment]
    	
    	int nightNum = (Integer) rentInfo.get(0);
    	
    	// activeList = [customer, returnDate, nightNum, rentedToolsWithOptions_List, totalCost]
    	activeList.add(c);
    	activeList.add(date + nightNum);
    	activeList.addAll(rentInfo);

    	return activeList;

    }

    List<Tool> refreshTool(List<Tool> tools){
    	List<Tool> toolsRefreshed = new ArrayList<>();
    	for (Tool t : tools) {
    		Tool refreshedT = toolFactoryConcrete.createTool(t.getCategory(), t.getName());
    		toolsRefreshed.add(refreshedT);
    	}
    	return toolsRefreshed;
    }



    private List<String> createToolNameList() {
        for (int i = 0; i < 24; i++){
            if (i < 5){
                String name = "painting" + (i + 1);
                toolNameList.add(name);
            }
            else if (i < 10){
                String name = "plumbing" + (i - 4);
                toolNameList.add(name);
            }
            else if (i < 15){
                String name = "concrete" + (i - 9);
                toolNameList.add(name);
            }
            else if (i < 20){
                String name = "woodwork" + (i - 14);
                toolNameList.add(name);
            }
            else{
                String name = "yardwork" + (i - 19);
                toolNameList.add(name);
            }
        }

        return toolNameList;
    }

    public List<Tool> createToolInventoryList() {

        toolNameList = createToolNameList();

        Tool toolPainting1 = toolFactoryConcrete.createTool("Painting", toolNameList.get(0));
        Tool toolPainting2 = toolFactoryConcrete.createTool("Painting", toolNameList.get(1));
        Tool toolPainting3 = toolFactoryConcrete.createTool("Painting", toolNameList.get(2));
        Tool toolPainting4 = toolFactoryConcrete.createTool("Painting", toolNameList.get(3));
        Tool toolPainting5 = toolFactoryConcrete.createTool("Painting", toolNameList.get(4));

        Tool toolPlumbing1 = toolFactoryConcrete.createTool("Plumbing", toolNameList.get(5));
        Tool toolPlumbing2 = toolFactoryConcrete.createTool("Plumbing", toolNameList.get(6));
        Tool toolPlumbing3 = toolFactoryConcrete.createTool("Plumbing", toolNameList.get(7));
        Tool toolPlumbing4 = toolFactoryConcrete.createTool("Plumbing", toolNameList.get(8));
        Tool toolPlumbing5 = toolFactoryConcrete.createTool("Plumbing", toolNameList.get(9));

        Tool toolConcrete1 = toolFactoryConcrete.createTool("Concrete", toolNameList.get(10));
        Tool toolConcrete2 = toolFactoryConcrete.createTool("Concrete", toolNameList.get(11));
        Tool toolConcrete3 = toolFactoryConcrete.createTool("Concrete", toolNameList.get(12));
        Tool toolConcrete4 = toolFactoryConcrete.createTool("Concrete", toolNameList.get(13));
        Tool toolConcrete5 = toolFactoryConcrete.createTool("Concrete", toolNameList.get(14));

        Tool toolWoodwork1 = toolFactoryConcrete.createTool("Woodwork", toolNameList.get(15));
        Tool toolWoodwork2 = toolFactoryConcrete.createTool("Woodwork", toolNameList.get(16));
        Tool toolWoodwork3 = toolFactoryConcrete.createTool("Woodwork", toolNameList.get(17));
        Tool toolWoodwork4 = toolFactoryConcrete.createTool("Woodwork", toolNameList.get(18));
        Tool toolWoodwork5 = toolFactoryConcrete.createTool("Woodwork", toolNameList.get(19));

        Tool toolYardwork1 = toolFactoryConcrete.createTool("Yardwork", toolNameList.get(20));
        Tool toolYardwork2 = toolFactoryConcrete.createTool("Yardwork", toolNameList.get(21));
        Tool toolYardwork3 = toolFactoryConcrete.createTool("Yardwork", toolNameList.get(22));
        Tool toolYardwork4 = toolFactoryConcrete.createTool("Yardwork", toolNameList.get(23));

        toolInventoryList.addAll(Arrays.asList(toolPainting1, toolPainting2, toolPainting3, toolPainting4, toolPainting5,
        										toolPlumbing1, toolPlumbing2, toolPlumbing3, toolPlumbing4, toolPlumbing5,
        										toolConcrete1, toolConcrete2, toolConcrete3, toolConcrete4, toolConcrete5,
        										toolWoodwork1, toolWoodwork2, toolWoodwork3, toolWoodwork4, toolWoodwork5,
        										toolYardwork1, toolYardwork2, toolYardwork3, toolYardwork4));

        return toolInventoryList;
    }

    private List<String> createCustomerNameList() {
        for (int i = 0; i < 12; i++){
            String name = "customer" + (i + 1);
            customerNameList.add(name);
        }
        return customerNameList;
    }


    public List<Customer> createCustomerList() {

        customerNameList = createCustomerNameList();

        Customer casual1 = customerFactoryConcrete.createCustomer("Casual", customerNameList.get(0));
        Customer casual2 = customerFactoryConcrete.createCustomer("Casual", customerNameList.get(1));
        Customer casual3 = customerFactoryConcrete.createCustomer("Casual", customerNameList.get(2));
        Customer casual4 = customerFactoryConcrete.createCustomer("Casual", customerNameList.get(3));
        Customer casual5 = customerFactoryConcrete.createCustomer("Casual", customerNameList.get(4));
        Customer casual6 = customerFactoryConcrete.createCustomer("Casual", customerNameList.get(5));
        
        Customer business1 = customerFactoryConcrete.createCustomer("Business", customerNameList.get(6));
        Customer business2 = customerFactoryConcrete.createCustomer("Business", customerNameList.get(7));
        Customer business3 = customerFactoryConcrete.createCustomer("Business", customerNameList.get(8));
        Customer business4 = customerFactoryConcrete.createCustomer("Business", customerNameList.get(9));
        
        Customer regular1 = customerFactoryConcrete.createCustomer("Regular", customerNameList.get(10));
        Customer regular2 = customerFactoryConcrete.createCustomer("Regular", customerNameList.get(11));
        
        businessCustomers.addAll(Arrays.asList(business1, business2, business3, business4));

        otherCustomers.addAll(Arrays.asList(casual1, casual2, casual3, casual4,casual5, casual6,
        									regular1, regular2));

        customerList.addAll(businessCustomers);
        customerList.addAll(otherCustomers);
        
        originalCustomerList.addAll(businessCustomers);
        originalCustomerList.addAll(otherCustomers);

        
        return customerList;
    }

    private List<String> createOptionNameList(){
        optionNameList.add("Accessory");
        optionNameList.add("Extension");
        optionNameList.add("Protective");
        return optionNameList;
    }

}

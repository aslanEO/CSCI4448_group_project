package store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import customers.Customer;
import javafx.util.Pair;
import tools.Tool;

public class StoreSimulation {

	private double totalIncome = 0.00;
	private int businessComplete = 0;
	private int casualComplete = 0;
	private int regularComplete = 0;
	
	private DataManager dm = new DataManager();
	private List<Tool> toolInventoryList = dm.createToolInventoryList();
	private List<Customer> customerList = dm.createCustomerList();
	private List<List<Object>> activeRentalRecord = new ArrayList<>();
	private List<List<Object>> completeRentalRecord = new ArrayList<>();
	private List<Integer> activeCountPerCustomer = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
	
	void simulateStore() {
    	Random rand = new Random();


		// # of days to simulate
		int dayNum = 35;
		for (int i = 1; i < dayNum + 1; i++) {

            System.out.println("Day: " + i + "\n");

            ////////////////////////RETURN TOOLS DUE BEFORE STORE OPENS///////////////////////////
            
            List<List<Object>> dailyComplete = new ArrayList<>();
            
            for (List<Object> cr : activeRentalRecord) {
            	int returnTime = (Integer) cr.get(1);//get return data of tools
            	if (returnTime == i) {
            		completeRentalRecord.add(cr);
            		dailyComplete.add(cr);
            		List<Tool> refreshedTools = dm.refreshTool((List<Tool>) cr.get(cr.size()-2));
            		toolInventoryList.addAll(refreshedTools);//get tools and options that customer returned
            		dm.inventoryIncreased(toolInventoryList);//notify customer that tools inventory change
            		
            		// update customers active tool number
            		Customer customer = (Customer) cr.get(0);
            		
            		if (customer.getCustomerType().equals("Business")) {
            			businessComplete += 1;
            		} else if (customer.getCustomerType().equals("Casual")) {
            			casualComplete += 1;
            		} else if (customer.getCustomerType().equals("Regular")) {
            			regularComplete += 1;
            		}
            		
            		int customerID = dm.originalCustomerList.indexOf(customer);
            		int toolNum = refreshedTools.size();
            		int preValue = activeCountPerCustomer.get(customerID);
            		activeCountPerCustomer.set(customerID, preValue-toolNum);
					if (activeCountPerCustomer.get(customerID) != 0 && !customerList.contains(customer)) {
						dm.addCustomer(customer);
            		}
            	}
            } 

            //delete complete rentals from active rental list
            for (List<Object> cr : dailyComplete) {
            	activeRentalRecord.remove(cr);
            }
            
            //////////////////////////RETURN FINISHED!//////////////////////////////
            

            System.out.println("-> All complete rentals at the beginning of the day:"); // A count and list of all completed rentals including which tools and options were rented by which customer, for how many days, along with the total fee for that rental
            System.out.println("\t Count: " + completeRentalRecord.size());
            if (completeRentalRecord.size() == 0) {
            	System.out.println("\t There is no complete rental now.");
            } else {
            	for (int ci = 0; ci < completeRentalRecord.size(); ci++) {
                	List<Object> crr = completeRentalRecord.get(ci);
                	List<Object> completeTools = (List<Object>) crr.get(crr.size()-2);
                	List<String> optionsAdded = new ArrayList<>();
                	List<String> toolNamePrint = new ArrayList<>();
                	for (Object t : completeTools) {
                		Tool tl = (Tool) t;
                		toolNamePrint.add(tl.getName());
                		optionsAdded.addAll(tl.options);
                	}
                	System.out.println("\t " + ((Customer) crr.get(0)).getCustomerName() + ": Days-" + crr.get(2) 
                										  + ", Total rent fee-" + crr.get(crr.size()-1) 
                										  + ", Tools-" + toolNamePrint
                										  + ", Options-" + optionsAdded);
                }
            }
            
            
//            System.out.println("=><=><=> START RENTING <=><=><=\n");
            ///////////////////////////RENT TOOLS/////////////////////////////

            int dailyCustomerNum = 0;
            if (customerList.size() != 0){
                dailyCustomerNum = rand.nextInt(customerList.size());
            }

            double dailyIncome = 0.00;

            List<List<Object>> dailyActive = new ArrayList<>();
            while (customerList.size() != 0 && dailyCustomerNum != 0) {
            	dailyCustomerNum = dailyCustomerNum - 1;
                int randCandInd = rand.nextInt(customerList.size());
                Customer c = customerList.get(randCandInd);
                
                int customerID = dm.originalCustomerList.indexOf(c);
        		int preValue = activeCountPerCustomer.get(customerID);
        		if (preValue < 3) {
	                int limit = 3 - preValue;
	                //Rent tools and update toolInventoryList
	                List<Object> customerRecord = dm.setCustomerActiveRental(c, i, toolInventoryList, limit);
	                //notify customer the change of toolInventoryList
	                dm.inventoryDecreased(toolInventoryList);
	                activeRentalRecord.add(customerRecord);
	                dailyActive.add(customerRecord);
	                //stop the same customer coming twice a day
	                dm.deleteCustomer(c);
	                
	                //get daily income
	                dailyIncome += (double) customerRecord.get(customerRecord.size()-1);
	                // update customers active tool number
	                int toolNum = ((List<Tool>) customerRecord.get(customerRecord.size()-2)).size();
	        		activeCountPerCustomer.set(customerID, preValue+toolNum);
	        		
	//        		if (activeCountPerCustomer.get(customerID) == 3) {
	//        			dm.deleteCustomer(c);
        		}
            }
            
          //Add customers who came today but still have less than 3 tools back to customerList
            for (List<Object> cr : dailyActive) {
            	Customer c = (Customer) cr.get(0);
            	int customerID = dm.originalCustomerList.indexOf(c);
            	if (activeCountPerCustomer.get(customerID) < 3) {
        			dm.addCustomer(c);
        		}
            }
            
            totalIncome += dailyIncome;
//            System.out.println(activeCountPerCustomer);
            
            //////////////////////////RENTING OF TODAY FINISHED!//////////////////////////////
            
            System.out.println("-> All active rentals at the end of the day:"); // A count and list of all active rentals, including which tools are rented by which customer
            System.out.println("\t Count: " + activeRentalRecord.size());
            if (activeRentalRecord.size() == 0) {
            	System.out.println("\t There is no active rental now.");
            } else {
            	for (int ri=0; ri<activeRentalRecord.size(); ri++) {
                	List<Object> r = activeRentalRecord.get(ri);
                	List<Object> activeTools = (List<Object>) r.get(r.size()-2);
                	List<String> toolNamePrint = new ArrayList<>();
                	for (Object t : activeTools) {
                		Tool tl = (Tool) t;
                		toolNamePrint.add(tl.getName());
                	}
                	System.out.println("\t " + ((Customer) r.get(0)).getCustomerName() + ": " + toolNamePrint);
                }
            }

            
            List<String> toolNamesDR = new ArrayList<>();
            for (Tool t : toolInventoryList) {
            	toolNamesDR.add(t.getName());
            }
            
            System.out.println("-> Tool Inventory at the end of the day:"); // A count and list of all tools left in the store and their names
            System.out.println("\t Count: " + toolInventoryList.size());
            System.out.println("\t Tool list: " + toolInventoryList);
            System.out.println("\t Tool names: " + toolNamesDR);

            
//            System.out.println("-> Customer Repository at the end of the day:"); // A count and list of all tools left in the store and their names
//            System.out.println("\t Count: " + customerList.size());
//            System.out.println("\t Customer list: " + customerList);

            
            System.out.println("-> Daily Income: " + dailyIncome + "\n"); // The amount of money the store made that day
//            System.out.println("\t" + dailyIncome + "\n");
            
            System.out.println("------------------------------------------------------------------");
        }

        // At the end of the simulation, print (in a concise format):
        // the **total number** of completed rentals, overall and by type of customers
        // the total money the store made for the 35-day period
        
        System.out.println(); 
        
        System.out.println("Total number of completed rentals-Overall: " + completeRentalRecord.size());
        System.out.println("      Total number of completed rentals-of CASUAL CUSTOMERS: " + casualComplete);
        System.out.println("      Total number of completed rentals-of BUSINESS CUSTOMERS: " + businessComplete);
        System.out.println("      Total number of completed rentals-of REGULAR CUSTOMERS: " + regularComplete);
        
        System.out.println(); 
        
        // The total money the store made for the simulation period (35 days required here)
        System.out.println("Total income for " + dayNum + " days: " + totalIncome);
    }
}

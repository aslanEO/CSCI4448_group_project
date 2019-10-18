package tests;

import customers.Customer;
import customers.CustomerBusiness;
import customers.CustomerCasual;
import customers.CustomerRegular;
import org.junit.Test;

import store.*;
import tools.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MyUnitTest {
	
	// output from each test indicating the identification of the test 
	// and success or failure of each test method

	@Test
	public void testPlumbingToolCost(){
		System.out.println("JUnit test 1: ");
		System.out.println("... Testing the cost of a plumbing tool for 1 night ... ");
		Tool tool = new PlumbingTool("Plumb");
		double result = tool.cost(1);
		
		try {
			assertEquals(10, result, 0);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		System.out.println();
		
	}

	@Test
	public void testTwoNightsYardworkToolCost(){
		System.out.println("JUnit test 2: ");
		System.out.println("... Testing the cost of a yardwork tool for 2 nights ... ");
		Tool tool = new YardworkTool("Yardwork");
		double result = tool.cost(2);
		
		try {
			assertEquals(30, result, 0);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		System.out.println();
		
	}

	@Test
	public void testPaintingToolWithAccessoryCost() {
		System.out.println("JUnit test 3: ");
		System.out.println("... Testing the cost of a painting tool with 1 accessory option for 1 night ... ");
		Tool toolPaint = new PaintingTool("Paint");
		toolPaint = new OptionDecoratorAccessory(toolPaint);
		double result = toolPaint.cost(1);
		
		try {
			assertEquals(23.00, result, 0);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		System.out.println();
		
	}

	@Test
	public void testConcreteToolWithExtensionCost() {
		System.out.println("JUnit test 4: ");
		System.out.println("... Testing the cost of a concrete tool with 2 extension options for 2 nights ... ");
		Tool tool = new ConcreteTool("Concrete");
		tool = new OptionDecoratorExtension(tool);
		tool = new OptionDecoratorExtension(tool);
		double result = tool.cost(2);
		
		try {
			assertEquals(58.00, result, 0);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		System.out.println();
		
		
	}

	@Test
	public void testWoodworkToolWithAccessoryAndProtectiveCost(){
		System.out.println("JUnit test 5: ");
		System.out.println("... Testing the cost of a woodwork tool with 1 protective option and 1 accessory option for 5 nights ... ");
		
		Tool tool = new WoodworkTool("Woodwork");
		tool = new OptionDecoratorProtective(tool);
		tool = new OptionDecoratorAccessory(tool);
		double result = tool.cost(5);
		
		try {
			assertEquals(165,result);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		System.out.println();
		
	}

	@Test
	public void testOptionHasNoCategoryMatchCost(){
		System.out.println("JUnit test 6: ");
		System.out.println("... Testing the cost of a tool when some unknown options are specified for 1 night ... ");
		
		Customer c = new CustomerRegular("testCustomerName");
		Tool tool = new WoodworkTool("testToolName");
		List<String> optionNameList = new ArrayList<>();
		optionNameList.add("Accessory");
		optionNameList.add("Protective");
		optionNameList.add("Extension");
		optionNameList.add("test1");
		optionNameList.add("test2");
		optionNameList.add("test3");

		tool = c.addOptions(tool, 5, optionNameList);
		Tool toolExpected = new WoodworkTool("testToolNameExpected");
		for (String opt : tool.options){
			switch (opt) {
				case "Accessory":
					toolExpected = new OptionDecoratorAccessory(toolExpected);
					break;
				case "Extension":
					toolExpected = new OptionDecoratorExtension(toolExpected);
					break;
				case "Protective":
					toolExpected = new OptionDecoratorProtective(toolExpected);
					break;
			}
		}
		
		try {
			assertEquals(toolExpected.cost(1),tool.cost(1),0);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		System.out.println();
		
		
	}

	@Test
	public void testRemovedAndAddedCustomerNum(){
		System.out.println("JUnit test 7: ");
		System.out.println("... Testing the observer pattern, specifically change in the number of customers in the customer list ... ");
		
		System.out.println("  ---> original length of the customer list");
		DataManager dm = new DataManager();
		List<Customer> customerList = dm.createCustomerList();
		List<Tool> toolInventoryList = dm.createToolInventoryList();
		List<Tool> toolInventoryListComplete = new ArrayList<>(toolInventoryList);

		//Original customerList
		int result0 = customerList.size();
		
		try {
			assertEquals(12, result0, 0);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		
		
		System.out.println("  ---> Removing business customers ... ");
		//when count of toolInventoryList less than 2
		while (toolInventoryList.size() > 2){
			toolInventoryList.remove(0);
		}
		dm.inventoryDecreased(toolInventoryList);

		int result1 = customerList.size();
		
		try {
			assertEquals(8, result1, 0);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		
		
		System.out.println("  ---> Removing casual and regular customers ... ");
		//when number of toolInventoryList is 0
		while (toolInventoryList.size() > 0){
			toolInventoryList.remove(0);
		}
		dm.inventoryDecreased(toolInventoryList);

		int result2 = customerList.size();
		
		try {
			assertEquals(0, result2,0);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		
		
		System.out.println("  ---> Adding casual and regular customers ... ");
		//add tool to toolInventoryList
		for (int i = 0; i < 2; i++){
			toolInventoryList.add(toolInventoryListComplete.get(i));
		}

		dm.inventoryIncreased(toolInventoryList);
		int result3 = customerList.size();
		
		try {
			assertEquals(8, result3,0);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		

		System.out.println("  ---> Adding business customers ... ");
		for (int i = 2; i < toolInventoryListComplete.size(); i++){
			if (toolInventoryList.size() < 3){
				toolInventoryList.add(toolInventoryListComplete.get(i));
			}
		}
		dm.inventoryIncreased(toolInventoryList);
		int result4 = customerList.size();
		
		try {
			assertEquals(12, result4,0);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		System.out.println();
		
	}

	@Test
	public void testRemovedAndAddedCustomerType(){
		System.out.println("JUnit test 8: ");
		System.out.println("... Testing the observer pattern, specifically whether the right type of customer gets added or removed ... ");

		DataManager dm = new DataManager();
		List<Customer> customerList = dm.createCustomerList();
		List<Tool> toolInventoryList = dm.createToolInventoryList();
		List<Tool> toolInventoryListComplete = new ArrayList<>(toolInventoryList);

		System.out.println("  ---> Removing business customers ... ");
		//when count of toolInventoryList less than 2
		while (toolInventoryList.size() > 2){
			toolInventoryList.remove(0);
		}
		dm.inventoryDecreased(toolInventoryList);

		boolean testBusiness = false;
		for (Customer c:customerList){
			if (c.getCustomerType().equals("Business")){
				testBusiness = true;
			}
		}
		try {
			assertFalse(testBusiness);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");

		
		//when number of toolInventoryList is 0
		while (toolInventoryList.size() > 0){
			toolInventoryList.remove(0);
		}
		dm.inventoryDecreased(toolInventoryList);
		boolean testCasual = false;
		boolean testRegular = false;
		for (Customer c:customerList){
			if (c.getCustomerType().equals("Casual")){
				testCasual = true;
			}
			if (c.getCustomerType().equals("Regular")){
				testRegular = true;
			}
		}

		System.out.println("  ---> Adding casual customers ... ");
		try {
			assertFalse(testCasual);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		
		System.out.println("  ---> Adding regular customers ... ");
		
		try {
			assertFalse(testRegular);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		

		//add tool to toolInventoryList
		for (int i = 0; i < 2; i++){
			toolInventoryList.add(toolInventoryListComplete.get(i));
		}

		dm.inventoryIncreased(toolInventoryList);
		for (Customer c:customerList){
			if (c.getCustomerType().equals("Casual")){
				testCasual = true;
			}
			if (c.getCustomerType().equals("Regular")){
				testRegular = true;
			}
			if (c.getCustomerType().equals("Business")){
				testBusiness = true;
			}
		}
		
		System.out.println("  ---> Adding casual customers ... ");
		
		try {
			assertTrue(testCasual);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		
		
		System.out.println("  ---> Adding regular customers ... ");
		
		try {
			assertTrue(testRegular);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		
		
		System.out.println("  ---> Adding business customers ... ");
		
		try {
			assertFalse(testBusiness);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		

		for (int i = 2; i < toolInventoryListComplete.size(); i++){
			if (toolInventoryList.size() < 3){
				toolInventoryList.add(toolInventoryListComplete.get(i));
			}
		}
		dm.inventoryIncreased(toolInventoryList);
		for (Customer c:customerList){
			if (c.getCustomerType().equals("Casual")){
				testCasual = true;
			}
			if (c.getCustomerType().equals("Regular")){
				testRegular = true;
			}
			if (c.getCustomerType().equals("Business")){
				testBusiness = true;
			}
		}
		
		
		System.out.println("  ---> Adding casual customers ... ");
		
		try {
			assertTrue(testCasual);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		
		
		System.out.println("  ---> Adding regular customers ... ");
		
		try {
			assertTrue(testRegular);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		
		
		System.out.println("  ---> Adding business customers ... ");
		
		try {
			assertTrue(testBusiness);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		System.out.println();

	}

	@Test
	public void testRentToolNumLimit(){
		System.out.println("JUnit test 9: ");
		System.out.println("... Test the constriction on the number of tools each type of customer can rent ... ");
		
		System.out.println("  ---> testing casual customers ... ");
		Customer customerCasual = new CustomerCasual("customer1");
		int casualToolsNum = customerCasual.RestrictionOfToolsNum(customerCasual, 1);
		boolean casualTest = true;
		if (casualToolsNum > 2 || casualToolsNum < 1){
			casualTest = false;
		}
		
		try {
			assertTrue(casualTest);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		
		
		System.out.println("  ---> testing business customers ... ");
		Customer customerBusiness = new CustomerBusiness("customer2");
		int businessToolsNum = customerBusiness.RestrictionOfToolsNum(customerBusiness, 0);
		boolean businessTest = true;
		if (businessToolsNum != 3){
			businessTest = false;
		}
		
		try {
			assertTrue(businessTest);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		
		System.out.println("  ---> testing regular customers ... ");
		Customer customerRegular = new CustomerRegular("customer3");
		int regularToolsNum = customerRegular.RestrictionOfToolsNum(customerRegular, 2);
		boolean regularTest = true;
		if (regularToolsNum < 1 || regularToolsNum > 3){
			regularTest = false;
		}
		
		try {
			assertTrue(regularTest);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		System.out.println();
		
	}

	@Test
	public void testRentDaysLimit(){
		System.out.println("JUnit test 10: ");
		System.out.println("... Test the constriction on the number of nights each type of customer can rent tools for ... ");
		
		System.out.println("  ---> testing casual customers ... ");
		
		Customer customerCasual = new CustomerCasual("customer1");
		int casualNight = customerCasual.RestrictionOfRentNight(customerCasual);
		boolean casualTest = true;
		if (casualNight > 2 || casualNight < 1){
			casualTest = false;
		}
		
		try {
			assertTrue(casualTest);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		

		System.out.println("  ---> testing business customers ... ");
		Customer customerBusiness = new CustomerBusiness("customer2");
		int businessNight = customerBusiness.RestrictionOfRentNight(customerBusiness);
		boolean businessTest = true;
		if (businessNight != 7){
			businessTest = false;
		}
		
		try {
			assertTrue(businessTest);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		

		System.out.println("  ---> testing regular customers ... ");
		Customer customerRegular = new CustomerRegular("customer3");
		int regularNight = customerRegular.RestrictionOfRentNight(customerRegular);
		boolean regularTest = true;
		if (regularNight < 3 || regularNight > 5){
			regularTest = false;
		}
		
		try {
			assertTrue(regularTest);
		} catch (AssertionError e) {
		    System.out.println("Oops!!! Test failed.");
		    throw e;
		}
		System.out.println("Congratulations!!! Test passed.");
		System.out.println();
		
	}
}

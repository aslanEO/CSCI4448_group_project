1. 4448/5448 --- OOAD ---- Project 3

2. Date: 10/18/2019

3. Team Members: Yiou Gao, Ling Liu, Ji Zhao

4. Our code is developed and tested on Eclipse and IntelliJ IDEA;

5. The output is in file: project3.out;

6. Descriptions:

6.1 The code has 4 packages: store, customers, tools, and tests;

6.2 Observer pattern was applied to store and customers;
	Factory pattern was applied to instantiate tools;
	Decorator pattern was applied when add options to tools;



6.3  store 

	6.3.1 Main.java is in store package, it implements MyUnitTest
		  first, then implements the StoreSimulation;

	6.3.2 StoreSimulation simulates 35 days and 34 nights rental 
		  activity in store;

	6.3.3 Each day randomly select customer to rent tool(s) with/
		  without options. Each customer can rent once each day;

	6.3.4 Rent and Return rentals will create a record, daily 
		  income will also be recored;

	6.3.5 When number of tools inventory less than 3, the store
		  will notify all Business customers. If tool inventory
		  is 0, it will notify all customers.

		  

6.4  customers 

	6.4.1 Twelve customers were created: 6 of them are Casual type,
		  4 of them are Business type, rest of them are Regular type;

	6.4.2 The number of tools and options and nights that customers
		  can rent have restrictions for different type;

	6.4.3 Customers will return tools timely when rent periods end;

	6.4.4 When tools inventory less than 3, all Business customers
		  will be notified;

	6.4.5 When tools inventory is 0, all customers will be notified;



6.5  tools 

	6.5.1 Different type of tools are created through Factory Pattern;

	6.5.2 Total amount of tools are 24 and they have 5 different 
		  categories: 5 Painting tools, 5 Plumbing tools, 5 Concrete 
		  tools, 5 Woodwork Tools, and 4 Yardwork tools;

	6.5.3 Three kind of options was created: Accessory kit, Extension
		  cord, and Protective gear. Options are always available. 
		  Options can be add when customer rents tools;

	6.5.4 When adding options to tools, use Decorator pattern to add;

	6.5.5 The price of tools and options:
	

| tool\Tool     | Accessory kit | Extension cord | Protective Gear  |
| ------------- |:-------------:|:-------------: | ----------------:| 
| Painting-20   | 3             | 5              | 6                |
| Pluming -10   | 2             | 3              | 2                |
| Concrete-25   | 4             | 4              | 5                |
| Woodwork-30   | 5             | 10             | 10               |
| Yardwork-15   | 6             | 8              | 3                |


									 option price
					Accessory kit	Extension cord	  Protective Gear			
	  Price/tool 		
	  Painting-20		3					5				6
	  Pluming -10		2					3				2
	  Concrete-25		4					4				5
	  Woodwork-30		5					10				10
	  Yardwork-15		6					8				3



6.6  MyUnitTest 
	
	6.6.1 There are 12 JUnit tests in MyUnitTest;

	6.6.2 assertEquals, assertTrue, and assertFalse was use

	6.6.3 Cost of tools, cost of tools and options, and cost of 
		  different rent nights are tested. In addition, cost for
		  unknown category tools tested;
	
	6.6.4 Number of tools and how many days that different type of 
		  customers can rent are tested;

	6.6.5 Observer pattern was tested: when tool inventory less 
		  than 3, Business customers are notified that they do not
		  need to come, so all Business customers will be removed
		  from customer list; when no tools left, all customers are
		  notified that they do not need to come and all customers
		  will be removed, therefore the number customer list will
		  be 0;

	6.6.6 Total income was tested;

	6.6.7 The maximum number of tools that customer can rent was tested;










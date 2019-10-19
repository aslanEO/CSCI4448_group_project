# CSCI4448/5448 --- OOAD ---- Project 3

Date: 10/18/2019

## Team Members: 

Yiou Gao, Ling Liu, Ji Zhao

## Environment

Our code is developed and tested on Eclipse and IntelliJ IDEA.

We used java version "1.8.0_92" and Junit5 library for JUnit test.

## Output file

The output is in file: project3.out.txt.

## PDF file

OOAD_Project3.pdf is the complete version of the required PDF file.

project3_UML_class_diagram.pdf is an extra copy of the UML class diagram attached at the end of the complete PDF file. It is provided for your convenience.

## Descriptions

- The code has 4 packages: store, customers, tools, and tests;

- Observer pattern was applied to store and customers;
	
	Factory pattern was applied to instantiate tools;
	
	Decorator pattern was applied when add options to tools;



- store 

	- Main.java is in store package, it implements MyUnitTest
		  first, then implements the StoreSimulation;

	- StoreSimulation simulates 35 days and 34 nights rental 
		  activity in store;

	- Each day randomly select customer to rent tool(s) with/
		  without options. Each customer can rent once each day;

	- Rent and Return rentals will create a record, daily 
		  income will also be recorded;

	- When number of tools inventory less than 3, the store
		  will notify all Business customers to stop coming. If tool inventory
		  is 0, it will notify all casual and regular customers to stop coming. If tool inventory increases to more than 0, the store will notify all casual and regular customers to come. If tool inventory increases to more than 2, the store will notify all business customers to come.

		  

- customers 

	- Twelve customers were created: 6 of them are Casual type,
		  4 of them are Business type, rest of them are Regular type;

	- The number of tools and options and nights that customers
		  can rent have restrictions for different type;

	- Customers will return tools timely when rent periods end;

	- When tools inventory less than 3, all Business customers
		  will be notified;

	- When tools inventory is 0, all customers will be notified;



- tools 

	- Different type of tools are created through Factory Pattern;

	- Total amount of tools are 24 and they have 5 different 
		  categories: 5 Painting tools, 5 Plumbing tools, 5 Concrete 
		  tools, 5 Woodwork Tools, and 4 Yardwork tools;

	- Three kind of options was created: Accessory kit, Extension
		  cord, and Protective gear. Options are always available. 
		  Options can be add when customer rents tools;

	- When adding options to tools, use Decorator pattern to add;

	- The price of tools and options:
	

		| tool-price    | Accessory kit | Extension cord | Protective Gear  |
		| ------------- |:-------------:|:-------------: | ----------------:| 
		| Painting-20   | 3             | 5              | 6                |
		| Pluming -10   | 2             | 3              | 2                |
		| Concrete-25   | 4             | 4              | 5                |
		| Woodwork-30   | 5             | 10             | 10               |
		| Yardwork-15   | 6             | 8              | 3                |




-  MyUnitTest 
	
	- There are 10 JUnit tests in MyUnitTest;

	- assertEquals, assertTrue, and assertFalse were used;

	- Cost of tools, cost of tools and options, and cost of 
		  different rent nights are tested. In addition, cost for
		  unknown category tools tested;
	
	- Number of tools and how many days that different type of 
		  customers can rent are tested;

	- Observer pattern was tested: when tool inventory less 
		  than 3, Business customers are notified that they do not
		  need to come, so all Business customers will be removed
		  from customer list; when no tools left, all customers are
		  notified that they do not need to come and all customers
		  will be removed, therefore the number customer list will
		  be 0.

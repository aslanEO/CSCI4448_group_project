package store;

import tests.MyUnitTest;

public class Main {

        public static void main(String[] args) {

        	System.out.println("==================");
        	System.out.println("JUnit tests:");
        	System.out.println("==================");
            MyUnitTest myUnitTest = new MyUnitTest();
            myUnitTest.testPlumbingToolCost();
            myUnitTest.testTwoNightsYardworkToolCost();
            myUnitTest.testPaintingToolWithAccessoryCost();
            myUnitTest.testConcreteToolWithExtensionCost();
            myUnitTest.testWoodworkToolWithAccessoryAndProtectiveCost();
            myUnitTest.testOptionHasNoCategoryMatchCost();
            myUnitTest.testRemovedAndAddedCustomerNum();
            myUnitTest.testRemovedAndAddedCustomerType();
            myUnitTest.testRentToolNumLimit();
            myUnitTest.testRentDaysLimit();
            
            System.out.println("\n\n==================");
        	System.out.println("Store Simulation:");
        	System.out.println("==================");
            StoreSimulation ss = new StoreSimulation();
        	ss.simulateStore();

        }

}



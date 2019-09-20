/********* OOAD Project1 - Problem4 *********/
/******** Author: Yiou Gao & Ji Zhao ********/
/************* Date: 09/29/2019 *************/

package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //polymorphism: upcast
        Animal cat1 = new Cat("Cathy");
        Animal cat2 = new Cat("Chloe");
        Animal tiger1 = new Tiger("Tom");
        Animal tiger2 = new Tiger("Tea");
        Animal lion1 = new Lion("Lexie");
        Animal lion2 = new Lion("Lemon");
        Animal wolf1 = new Wolf("Woody");
        Animal wolf2 = new Wolf("Wendy");
        Animal dog1 = new Dog("Danny");
        Animal dog2 = new Dog("Denver");
        Animal hippo1 = new Hippo("Harry");
        Animal hippo2 = new Hippo("Hilton");
        Animal elep1 = new Elephant("Ella");
        Animal elep2 = new Elephant("Emma");
        Animal rhino1 = new Rhino("Ray");
        Animal rhino2 = new Rhino("Roosevelt");

        //add objects to list
        List<Animal> object_list = new ArrayList<>();
        object_list.add(cat1);
        object_list.add(cat2);
        object_list.add(tiger1);
        object_list.add(tiger2);
        object_list.add(lion1);
        object_list.add(lion2);
        object_list.add(wolf1);
        object_list.add(wolf2);
        object_list.add(dog1);
        object_list.add(dog2);
        object_list.add(hippo1);
        object_list.add(hippo2);
        object_list.add(elep1);
        object_list.add(elep2);
        object_list.add(rhino1);
        object_list.add(rhino2);

        //create objects to call the method in this class
        Zookeeper z = new Zookeeper();

        //animals' behavior, some inheritance for superclass, some override the method
        //from first method to the last one
        // 1. wake up animal
        // 2. roll call animal
        // 3. feed animal
        // 4. exercise animal
        // 5. shut down zoo
        System.out.println("1.Wake Up Animal.\r");
        for (Animal a : object_list) {
            z.wakeUpAnimal(a);
        }

        System.out.println("\r\n2. Roll Call Animal.\r");
        for (Animal a : object_list) {
            z.rollCallAnimal(a);
        }

        System.out.println("\r\n3. Feed Animal.\r");
        for (Animal a : object_list) {
            z.feed(a);
        }

        System.out.println("\r\n4. Exercise Animal.\r");
        for (Animal a : object_list) {
            z.exerciseAnimal(a);
        }

        System.out.println("\r\n5. Shut Down Zoo\r");
        for (Animal a : object_list) {
            z.shutDownZoo(a);
        }

    }

}

package com.company;

public class Zookeeper {

    public void wakeUpAnimal(Animal animal){
        System.out.println("wake up - " +  animal.getName() + ", " + animal.getType() + ", " + animal.wakeup());
    }

    public void rollCallAnimal(Animal animal){
        System.out.println("roll call - " +  animal.getName() + ", " + animal.getType() + ", " + animal.makeNoise());
    }

    public void feed(Animal animal){
        System.out.println("feed - " +  animal.getName() + ", " + animal.getType() + ", " + animal.eat());

    }

    public void exerciseAnimal(Animal animal){
        System.out.println("exercise - " +  animal.getName() + ", " + animal.getType() + ", " + animal.roam());
    }

    public void shutDownZoo(Animal animal){
        System.out.println("shut down - " +  animal.getName() + ", " + animal.getType() + ", " + animal.sleep() );
    }
}

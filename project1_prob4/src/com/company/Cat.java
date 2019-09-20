package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cat extends Feline {
    public Cat(String myName) {
        super(myName);
    }

    //overrive makeNoise() method from Feline
    @Override
    public String makeNoise(){
        return " Cat make noise: Meow ";
    }

    //cat have 5 different response to eat()
    //response will be generated randomly
    @Override
    public String eat(){
        List<String> random_eat = new ArrayList<>();
        random_eat.add("Cat eats fish. ");
        random_eat.add("Cat drinks water. ");
        random_eat.add("Cat want to eat meat. ");
        random_eat.add("Cat want to drink.");
        random_eat.add("Cat is eating the fish.");
        Random rand = new Random();
        return random_eat.get(rand.nextInt(random_eat.size()));
    }

    //override wakeup method from Animal
    @Override
    public String wakeup(){
        return "Cat: wake up.";
    }

    @Override
    public String getType(){
        return "Cat";
    }
}

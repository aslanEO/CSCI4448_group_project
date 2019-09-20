package com.company;

public class Dog extends Canine{
    Dog(String myName) {
        super(myName);
    }

    @Override
    public String getType(){
        return "Dog";
    }
}

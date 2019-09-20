package com.company;

public class Lion extends Feline{
    public Lion(String myName) {
        super(myName);
    }

    //override makeNoise() from Feline
    @Override
    public String makeNoise(){
        return " Lion make noise: Roar ";
    }

    @Override
    public String getType(){
        return "Lion";
    }
}

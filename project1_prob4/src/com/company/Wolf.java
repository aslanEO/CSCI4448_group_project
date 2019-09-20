package com.company;

public class Wolf extends Canine{
    Wolf(String myName) {
        super(myName);
    }

    @Override
    public String getType(){
        return "Wolf";
    }
}

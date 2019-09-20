package com.company;

public class Tiger extends Feline{
    public Tiger(String myName) {
        super(myName);
    }

    //override makeNoise() from Feline
    @Override
    public String makeNoise(){
        return " Tiger make noise: Roar ";
    }

    @Override
    public String getType(){
        return "Tiger";
    }
}

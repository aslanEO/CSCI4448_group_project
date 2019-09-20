package com.company;

public class Feline extends Animal {
    public Feline(String felineName) {
        super(felineName);
    }

    //override makeNoise(), eat(), and roam() methods from Animal
    public String makeNoise(){
        return "Feline: make noise. ";
    }

    public String eat() {
        return " Feline: eat. ";
    }

    public String roam(){
        return "Feline: roam. ";
    }
}

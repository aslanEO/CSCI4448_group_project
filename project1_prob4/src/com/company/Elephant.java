package com.company;

public class Elephant extends Pachyderm {
    Elephant(String myName){
        super(myName);
    }

    @Override
    public String getType(){
        return "Elephant";
    }
}

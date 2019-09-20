package com.company;

public class Rhino extends Pachyderm {
    Rhino(String myName){
        super(myName);
    }

    @Override
    public String getType(){
        return "Rhino";
    }
}

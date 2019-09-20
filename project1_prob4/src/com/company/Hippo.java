package com.company;

public class Hippo extends Pachyderm {
    Hippo(String myName){
        super(myName);
    }

    @Override
    public String getType(){
        return "Hippo";
    }
}

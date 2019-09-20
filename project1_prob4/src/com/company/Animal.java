package com.company;

public class Animal {
    private String name;
    private String type;
    public Animal(String animalName){
        name = animalName;
    }
    public String wakeup(){
        return "Animal: wake up";
    }

    public String makeNoise(){
        return "Animal: make noise. ";
    }

    public String eat(){
        return "Animal: eat. ";
    }

    public String roam(){
        return "Animal: roam. ";
    }

    public String sleep(){
        return "Animal: sleep.";
    }

    public String getName() {
        return name;
    }

    public String getType(){
        return type;
    }


}

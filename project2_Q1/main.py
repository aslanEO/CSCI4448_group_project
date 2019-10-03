###### Author: Ji Zhao & Yiou Gao
###### Data: 10/03/2019
###### Title: CSCI 4448/5448 OOAD Project2 - Q1

import sys
from observer import ZooKeeper, ZooAnnouncer
from feline import Feline, Cat, Tiger, Lion
from canine import Canine, Wolf, Dog
from pachyderm import Hippo, Elephant, Rhino
from animal import Animal

def main(argv = None):
    if argv is None:
        argv = sys.argv
    cat1 = Cat('Cathy')
    cat2 = Cat('Chloe')
    tiger1 = Tiger('Tom')
    tiger2 = Tiger('Tea')
    lion1 = Lion('Lexie')
    lion2 = Lion('Lemon')
    wolf1 = Wolf('Woody')
    wolf2 = Wolf('Wendy')
    dog1 = Dog('Danny')
    dog2 = Dog('Denver')
    hippo1 = Hippo('Harry')
    hippo2 = Hippo('Hilton')
    elep1 = Elephant('Ella')
    elep2 = Elephant('Emma')
    rhino1 = Rhino('Ray')
    rhino2 = Rhino('Roosevelt')
    animal_list = [cat1, cat2, tiger1, tiger2, lion1, lion2, wolf1, wolf2, dog1, dog2, hippo1, hippo2, elep1, elep2, rhino1, rhino2]

    zp = ZooKeeper()
    za = ZooAnnouncer(zp)
    for animal in animal_list:
        zp.wakeUpAnimal(animal, 'waking up ')
    
    print('\n')
    for i in range(len(animal_list)):
        if i < 2:
            print('zoo keeper roll call',animal_list[i].getName(),', Type:',animal_list[i].getType())
            animal_list[i].makeNoise()
        else:
            print('zoo keeper roll call',animal_list[i].getName(),', Type:',animal_list[i].getType(),',',animal_list[i].makeNoise())
        zp.rollCallAnimal(animal_list[i], 'rolling call '+ animal.getName())
    
    print('\n')
    for animal in animal_list:
        zp.feed(animal, 'feeding '+ animal.getName())
    
    print('\n')
    for animal in animal_list:
        zp.exerciseAnimal(animal,'exercising '+ animal.getName())

    print('\n')
    for animal in animal_list:
        zp.shutDownZoo(animal, 'shutting down zoo')


# run main() function
if __name__ == "__main__":
    main()





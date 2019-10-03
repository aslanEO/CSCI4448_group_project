/************ Author: Yiou Gao & Ji Zhao ************/
/************      Date: 10/03/2019      ************/
/************     OOAD Project2 - Q1     ************/

language: Python
environment: Mac OS - vim


/*******************************************************/
/*********************** main.py ***********************/
/******************************************************/

1. Instantiate two instances for each animal, instantiate 
   object for ZooKeeper and ZooAnnouncer.
2. Execute Zookeeper's responsibility in order: start with 
   wakeUpAnimal(), then rollCallAnimal(), feed(), exerciseAnimal(), 
   shutDownZoo().


/*******************************************************/
/********************** animal.py **********************/
/*******************************************************/

1. Class Animal has 5 methods: wakeup(), makeNoise(), eat(), 
   roam(), and sleep(). It has 3 subclass: Pachyderm, Feline, 
   and Canine.
2. makeNoise() is the abstract method.



/*******************************************************/
/********************** feline.py **********************/
/*******************************************************/

1. Four classes are included. Superclass is Feline, and it
   has 3 subclasses, Tiger, Lion, and Cat.
2. Feline reference of abstract class MakeNoise, override 
   roam() and eat() method from Animal.
3. Cat has SofterMakeNoise behavior from MakeNoise class.
4. Tiger and Lion inherited eat() and makeNoise() method 
   from Feline;
5. Cat override eat() from Feline, and Cat has 5 different 
   response. These response will be generated randomly. Cat 
   also override wakeup() method from Animal.



/*******************************************************/
/********************** canine.py **********************/
/*******************************************************/

1. Three classes are included. Superclass is Canine, 
   and it has 2 subclasses, Wolf and Dog.
2. Canine references of abstract method makeNoise(), the 
   rest of methods are inherited from class Animal.


/*******************************************************/
/********************* pachyderm.py ********************/
/*******************************************************/

1. Pachyderm has 3 subclasses, Hippo, Elephant, and Rhino.
2. Pachyderm references of abstract method makeNoise(), the 
   rest of methods are inherited from class Animal.



/*******************************************************/
/********************* strategy.py *********************/
/*******************************************************/

1. Class MakeNoise is the interface and all make noise
   classes implement.
2. Make noise implementation for animal that Louder make
   noise and Softer make Noise, that is two implementation 
   classes for MakeNoise are SofterMakeNoise() and 
   LouderMakeNoise().



/******************************************************/
/********************* observer.py ********************/
/******************************************************/

1. Four classes in this file: Subject, Observer, Zookeeper,
   and ZooAnnouncer.
2. Zookeeper has 5 responsibilities: wakeUpAnimal(), 
   rollCallAnimal, feed(), exerciseAnimal, and shutDownZoo();
3. Objects use the Subject interface to register as observer, 
   and remove themselves from being observers.
4. Observer interface has one method update() that gets called
   when the Subject's state changes. 
5. ZooKeeper is a concrete subject that implements the Subject
   interface. ZooAnnouncer is a concrete observer that implements
   the Observer interface.
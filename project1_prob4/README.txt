/***** Author: Yiou Gao & Ji Zhao *****/
/***** Date: 09/19/2019 *****/
/***** OOAD Project1 - Q4 *****/



/****************************************/
/***************** Main *****************/
/****************************************/

1. Instantiate the objects first and two instances for each animal. 
   The total instances is 16.
2. Execute Zookeeper's responsibility in order: start with wakeUpAnimal(), 
   then rollCallAnimal, feed(), exerciseAnimal, shutDownZoo() is the last one.


/****************************************/
/**************** Animal ****************/
/****************************************/

1. Class Animal has 5 methods: wakeup(), makeNoise(), eat(), roam(), and sleep().
2. Animal has 3 subclasses: Pachyderm, Feline, and Canine.
3. Pachyderm has 3 subclasses, Hippo, Elephant, and Rhino. Methods 
   in Pachyderm, Hippo, Elephant, and Rhino are inhireted from 
   Animal class, no override.
4. Canine has 2 subclasses, Wolf and Dog. Methods in Canine, Wolf, 
   and Dog are inherited from Animal class, no override.
5. Feline has 3 subclasses, Tiger, Lion, and Cat.
	5.1 Feline override makeNoise(), roam() and eat() method from Animal;
	5.2 Tiger, Lion, and Cat override makeNoise() method from Feline.
	5.3 Tiger and Lion inherited eat() method from Feline;
	5.4 Cat override eat() from Feline, and Cat has 5 different response. These response 
		will be generated randomly. Cat also override wakeup() method from Animal.



/****************************************/
/*************** Zookeeper **************/
/****************************************/

1. Zookeeper has 5 methods: wakeUpAnimal(), rollCallAnimal, feed(), exerciseAnimal, 
   and shutDownZoo();
2. Each method will give animal's response respectively.
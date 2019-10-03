from animal import Animal
from strategy import LouderMakeNoise, SofterMakeNoise

# Feline
class Feline(Animal):
    def __init__(self):
        self._make_noise_strategy = LouderMakeNoise()
    
    def eat(self):
        return 'Feline: eat.'
    
    def roam(self):
        return 'Feline: roam.'


# Cat        
class Cat(Feline):
    def __init__(self, name):
        self._make_noise_strategy = SofterMakeNoise()
        self.name = name

    def eat(self):
        import random
        eat1 = 'Cat eats fish.'
        eat2 = 'Cat drinks water.'
        eat3 = 'Cat want to eat meat.'
        eat4 = 'Cat want to drink.'
        eat5 = 'Cat is eating the fish.'
        eat_list = [eat1, eat2, eat3, eat4, eat5]
        return eat_list[random.randint(0, len(eat_list) - 1)]
    
    def wakeup(self):
        return 'Cat: wake up.'

    def getType(self):
        return 'Cat'
    
# Lion    
class Lion(Feline):
    def __init__(self, name):
        self.name = name

    def makeNoise(self):
        return 'Lion make Noise.'
    
    def getType(self):
        return 'Lion'    
    
# Tiger    
class Tiger(Feline):
    def __init__(self, name):
        self.name = name
        
    def makeNoise(self):
        return 'Tiger make Noise.'
    
    def getType(self):
        return 'Tiger'

import abc

class Animal(object):
    
    _make_noise_strategy = None 
    animal_type = None
    
    def __init__(self, name):
        self.name = name
    
    def makeNoise(self):
        self._make_noise_strategy.makeNoise()        

    def wakeup(self):
        return 'Animal: wake up.'
    
    def eat(self):
        return 'Animal: eat.'
    
    def roam(self):
        return 'Animal: roam.'
    
    def sleep(self):
        return 'Animal: sleep.'
        
    def getName(self):
        return str(self.name)
    
    def getType(self, animalType):
        return str(self.animalType)
    


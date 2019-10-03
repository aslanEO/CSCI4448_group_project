from animal import Animal

class Canine(Animal):
    def makeNoise(self):
        return 'Canine make noise'


# subclass of Canine: Wolf, Dog
class Wolf(Canine):
    def __init__(self, name):
        self.name = name
        
    def getType(self):
        return 'Wolf'

class Dog(Canine):
    def __init__(self, name):
        self.name = name
        
    def getType(self):
        return 'Dog'
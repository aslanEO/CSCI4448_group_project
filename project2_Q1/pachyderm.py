from animal import Animal

class Pachyderm(Animal):
    def makeNoise(self):
        return 'Pachyderm make noise'


# subclass of Pachyderm: Rhino, Hippo, Elephant
class Rhino(Pachyderm):
    def __init__(self, name):
        self.name = name
        
    def getType(self):
        return 'Rhino'
    
class Hippo(Pachyderm):
    def __init__(self, name):
        self.name = name
        
    def getType(self):
        return 'Hippo'

class Elephant(Pachyderm):
    def __init__(self, name):
        self.name = name
        
    def getType(self):
        return 'Elephant'

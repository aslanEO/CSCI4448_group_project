import abc

class MakeNoise(object):
    __metaclass__ = abc.ABCMeta
    
    @abc.abstractclassmethod
    def makeNoise(self):
    	"""method"""
        
class LouderMakeNoise(MakeNoise):
    def makeNoise(self):
        print("Some Feline make Louder Noise")

class SofterMakeNoise(MakeNoise):
    def makeNoise(self):
        print('cat make Softer Noise')





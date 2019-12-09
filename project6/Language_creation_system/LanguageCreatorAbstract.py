from abc import ABC, abstractmethod

"""
This module defines the abstarct superclass LanguageCreator, i.e. the Creator in the Factory pattern
"""

class LanguageCreator(ABC):

    # def __init__(self):
    #     self.data = {}


    @abstractmethod
    def createData(self, sounds, rules):
        """
        :type sounds: str
        :type rs: str
        """
        language = None
        dataDict = {}
        return language, dataDict

    def storeData(self, sounds, rules):
        """
        :type sounds: str
        :type rs: str
        """
        language, dataDict = self.createData(sounds, rules)
        outpath = "generatedData/" + language.name + "/"
        for k, v in dataDict.items():
            v.export(outpath+ k + ".wav", format="wav")
        return







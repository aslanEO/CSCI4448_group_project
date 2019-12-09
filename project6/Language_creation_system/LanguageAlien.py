from LanguageAbstract import *

"""
This module defines the concrete subclass, i.e. the ConcreteProduct class in the Factory pattern. 
The language defined here is alien.
"""

class LanguageAlien(Language):
    
    def addSounds(self, sounds):
        """

        :param sounds: string
        :return:
        """
        alienvowels = {}
        alienpulmonics = {}
        alienclicks = {}
        alienejectives = {}
        alienimplosives = {}
        for sound in sounds:
            if sound == " ":
                continue
            elif sound in self.vowelDict:
                alienvowels[sound] = self.vowelDict[sound]
                if sound not in self.vowels:
                    self.vowels.add(sound)
            elif sound in self.pulmonicDict:
                alienpulmonics[sound] = self.pulmonicDict[sound]
                self.consonants.add(sound)
            elif sound in self.otherDict:
                alienpulmonics[sound] = self.otherDict[sound]
                self.consonants.add(sound)
            elif sound in self.clickDict:
                alienclicks[sound] = self.clickDict[sound]
                self.consonants.add(sound)
            elif sound in self.ejectiveDict:
                alienejectives[sound] = self.ejectiveDict[sound]
                self.consonants.add(sound)
            elif sound in self.implosiveDict:
                alienimplosives[sound] = self.implosiveDict[sound]
                self.consonants.add(sound)
            else:
                print(sound + " is NOT an IPA symbol.")
        return alienvowels, alienpulmonics, alienclicks, alienejectives, alienimplosives

    def addRules(self, rs):
        # Sanity check can be added here to improve the rule part,
        # though for this project, we didn't specify such language specific rule constraints.
        # That's why we'd like to override this function in subclasses
        """

        :param rs: space-separated strings
        :return:
        """
        alienrules = []
        for r in rs.strip().split(" "):
            alienrules.append(r)
            if r not in self.rules:
                self.rules.add(rs)
        return alienrules


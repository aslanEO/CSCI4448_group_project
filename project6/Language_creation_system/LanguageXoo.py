from LanguageAbstract import *

"""
This module defines the concrete subclass, i.e. the ConcreteProduct class in the Factory pattern. 
The language defined here is xoo.
"""

class LanguageXoo(Language):
    
    def addSounds(self, sounds):
        """

        :param sounds: string
        :return:
        """
        xoovowels = {}
        xoopulmonics = {}
        xooclicks = {}
        for sound in sounds:
            if sound == " ":
                continue
            elif sound in self.vowelDict:
                xoovowels[sound] = self.vowelDict[sound]
                if sound not in self.vowels:
                    self.vowels.add(sound)
            elif sound in self.pulmonicDict:
                xoopulmonics[sound] = self.pulmonicDict[sound]
                self.consonants.add(sound)
            elif sound in self.otherDict:
                xoopulmonics[sound] = self.otherDict[sound]
                self.consonants.add(sound)
            elif sound in self.clickDict:
                xooclicks[sound] = self.clickDict[sound]
                self.consonants.add(sound)
            else:
                # if sound in self.clickDict:
                #     print(sound + " is a Click." + self.languagename + " does not have clicks.")
                if sound in self.ejectiveDict:
                    print(sound + " is an Ejective." + self.languagename + " does not have ejectives.")
                elif sound in self.implosiveDict:
                    print(sound + " is an Implosive." + self.languagename + " does not have implosives.")
                else:
                    print(sound + " is NOT an IPA symbol.")
        return xoovowels, xoopulmonics, xooclicks

    def addRules(self, rs):
        # Sanity check can be added here to improve the rule part,
        # though for this project, we didn't specify such language specific rule constraints.
        # That's why we'd like to override this function in subclasses
        """

        :param rs: space-separated strings
        :return:
        """
        xoorules = []
        for r in rs.strip().split(" "):
            xoorules.append(r)
            if r not in self.rules:
                self.rules.add(rs)
        return xoorules


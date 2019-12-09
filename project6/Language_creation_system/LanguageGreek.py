from LanguageAbstract import *

"""
This module defines the concrete subclass, i.e. the ConcreteProduct class in the Factory pattern. 
The language defined here is greek.
"""

class LanguageGreek(Language):
    
    def addSounds(self, sounds):
        """

        :param sounds: string
        :return:
        """
        greekPhoneme = ['i', 'ɛ', 'u', 'ɔ', 'ɑ'] + ['p', 'b', 'm', 't', 'd', 'n', 'ɾ', 'f', 'v', 'θ', 'ð', 's', 'z',
                                                    'c', 'ɟ', 'ç', 'ʝ', 'j', 'k', 'ɡ', 'x', 'ɣ']
        greekvowels = {}
        greekpulmonics = {}
        for sound in sounds:
            if sound == " ":
                continue
            elif sound not in greekPhoneme:
                print(sound, "is not a Phoneme in Greek.")
            elif sound in self.vowelDict:
                greekvowels[sound] = self.vowelDict[sound]
                if sound not in self.vowels:
                    self.vowels.add(sound)
            elif sound in self.pulmonicDict:
                greekpulmonics[sound] = self.pulmonicDict[sound]
                self.consonants.add(sound)
            elif sound in self.otherDict:
                greekpulmonics[sound] = self.otherDict[sound]
                self.consonants.add(sound)
            else:
                if sound in self.clickDict:
                    print(sound + " is a Click." + self.languagename + " does not have clicks.")
                elif sound in self.ejectiveDict:
                    print(sound + " is an Ejective." + self.languagename + " does not have ejectives.")
                elif sound in self.implosiveDict:
                    print(sound + " is an Implosive." + self.languagename + " does not have implosives.")
                else:
                    print(sound + " is NOT an IPA symbol.")
        return greekvowels, greekpulmonics

    def addRules(self, rs):
        # Sanity check can be added here to improve the rule part,
        # though for this project, we didn't specify such language specific rule constraints.
        # That's why we'd like to override this function in subclasses
        """

        :param rs: space-separated strings
        :return:
        """
        greekrules = []
        for r in rs.strip().split(" "):
            greekrules.append(r)
            if r not in self.rules:
                self.rules.add(rs)
        return greekrules


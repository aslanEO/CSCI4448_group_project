from LanguageAbstract import *

"""
This module defines the concrete subclass, i.e. the ConcreteProduct class in the Factory pattern. 
The language defined here is English.
"""

class LanguageEnglish(Language):
    
    def addSounds(self, sounds):
        """

        :param sounds: string
        :return:
        """
        englishPhoneme = ['i', 'ɪ', 'e', 'ɛ', 'æ', 'ə', 'u', 'ʊ', 'o', 'ʌ', 'ɑ'] + ['p', 'b', 'm', 'f', 'v', 'θ', 'ð', 's', 'z', 'ɹ', 'l',
         't', 'd', 'n', 'ɾ', 'ʃ', 'ʒ', 'j', 'k', 'ɡ', 'ŋ', 'ʔ', 'h']
        englishvowels = {}
        englishpulmonics = {}
        for sound in sounds:
            if sound == " ":
                continue
            elif sound not in englishPhoneme:
                print(sound, "is not a Phoneme in English.")
            elif sound in self.vowelDict:
                englishvowels[sound] = self.vowelDict[sound]
                if sound not in self.vowels:
                    self.vowels.add(sound)
            elif sound in self.pulmonicDict:
                englishpulmonics[sound] = self.pulmonicDict[sound]
                self.consonants.add(sound)
            elif sound in self.otherDict:
                englishpulmonics[sound] = self.otherDict[sound]
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
        return englishvowels, englishpulmonics

    def addRules(self, rs):
        # Sanity check can be added here to improve the rule part,
        # though for this project, we didn't specify such language specific rule constraints.
        # That's why we'd like to override this function in subclasses
        """

        :param rs: space-separated strings
        :return:
        """
        englishrules = []
        for r in rs.strip().split(" "):
            englishrules.append(r)
            if r not in self.rules:
                self.rules.add(rs)
        return englishrules


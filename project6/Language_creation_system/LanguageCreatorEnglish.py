from LanguageCreatorAbstract import *
from LanguageEnglish import *
import random
import os
from pydub import AudioSegment

"""
This module defines the conscrete subclass, i.e. the concrete Creator in the Factory pattern.
Here it is a concrete creator for English data
"""

class LanguageCreatorEnglish(LanguageCreator):

    def createData(self, sounds, rules):
        """
        :type sounds: str
        :type rules: str
        """
        dataDict = {}
        language = LanguageEnglish("English")
        englishvowels, englishpulmonics = language.addSounds(sounds)
        vowellist = list(englishvowels.keys())
        pulmoniclist = list(englishpulmonics.keys())
        englishrules = language.addRules(rules)

        outpath = "generatedData/" + language.name + "/"
        if not os.path.exists(outpath):
            os.makedirs(outpath)

        for k, v in englishvowels.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound
        for k, v in englishpulmonics.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound

        if rules:
            sentString = []
            sentAudio = []
            for r in englishrules:
                comboSounds = []
                for item in r:
                    if item.upper() == 'V': # V for vowel
                        random.shuffle(vowellist)
                        comboSounds.append((vowellist[0], englishvowels[vowellist[0]]))
                        sentString.append(vowellist[0])
                        sentAudio.append(englishvowels[vowellist[0]])
                    elif item.upper() == 'C': # C for pulmonic consonants
                        random.shuffle(pulmoniclist)
                        comboSounds.append((pulmoniclist[0], englishpulmonics[pulmoniclist[0]]))
                        sentString.append(pulmoniclist[0])
                        sentAudio.append(englishpulmonics[pulmoniclist[0]])

                    elif item in englishvowels:
                        comboSounds.append((item, englishvowels[item]))
                        sentString.append(item)
                        sentAudio.append(englishvowels[item])
                    elif item in englishpulmonics:
                        comboSounds.append((item, englishpulmonics[item]))
                        sentString.append(item)
                        sentAudio.append(englishpulmonics[item])
                sentString.append(" ")
                sentAudio.append("soundEdited/silence.wav")
                comboString = comboSounds[0][0]
                comboAudio = AudioSegment.from_wav(comboSounds[0][1])
                for string, audiopath in comboSounds[1:]:
                    comboString = comboString + string
                    comboAudio = comboAudio + AudioSegment.from_wav(audiopath)
                dataDict[comboString] = comboAudio
            sentStringCombined = "".join(sentString)
            sentAudioCombined = AudioSegment.from_wav(sentAudio[0])
            for audiopath in sentAudio[1:]:
                sentAudioCombined = sentAudioCombined + AudioSegment.from_wav(audiopath)
            dataDict[sentStringCombined] = sentAudioCombined
        return language, dataDict








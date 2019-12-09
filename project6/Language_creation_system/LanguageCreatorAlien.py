from LanguageCreatorAbstract import *
from LanguageAlien import *
import random
import os
from pydub import AudioSegment

"""
This module defines the conscrete subclass, i.e. the concrete Creator in the Factory pattern.
Here it is a concrete creator for Alien data
"""

class LanguageCreatorAlien(LanguageCreator):

    def createData(self, sounds, rules):
        """
        :type sounds: str
        :type rules: str
        """
        dataDict = {}
        language = LanguageAlien("Alien")
        alienvowels, alienpulmonics, alienclicks, alienejectives, alienimplosives = language.addSounds(sounds)
        vowellist = list(alienvowels.keys())
        pulmoniclist = list(alienpulmonics.keys())
        clicklist =  list(alienclicks.keys())
        ejectivelist = list(alienejectives.keys())
        implosivelist = list(alienimplosives.keys())
        alienrules = language.addRules(rules)

        outpath = "generatedData/" + language.name + "/"
        if not os.path.exists(outpath):
            os.makedirs(outpath)

        for k, v in alienvowels.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound
        for k, v in alienpulmonics.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound
        for k, v in alienclicks.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound
        for k, v in alienejectives.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound
        for k, v in alienimplosives.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound

        if rules:
            sentString = []
            sentAudio = []
            for r in alienrules:
                comboSounds = []
                for item in r:
                    if item.upper() == 'V': # V for vowel
                        random.shuffle(vowellist)
                        comboSounds.append((vowellist[0], alienvowels[vowellist[0]]))
                        sentString.append(vowellist[0])
                        sentAudio.append(alienvowels[vowellist[0]])
                    elif item.upper() == 'C': # C for pulmonic consonants
                        random.shuffle(pulmoniclist)
                        comboSounds.append((pulmoniclist[0], alienpulmonics[pulmoniclist[0]]))
                        sentString.append(pulmoniclist[0])
                        sentAudio.append(alienpulmonics[pulmoniclist[0]])
                    elif item.upper() == 'CLICK': # Click for click consonants
                        random.shuffle(clicklist)
                        comboSounds.append((clicklist[0], alienclicks[clicklist[0]]))
                        sentString.append(clicklist[0])
                        sentAudio.append(alienclicks[clicklist[0]])
                    elif item.upper() == 'EJECTIVE': # Ejective for ejective consonants
                        random.shuffle(ejectivelist)
                        comboSounds.append((ejectivelist[0], alienejectives[ejectivelist[0]]))
                        sentString.append(ejectivelist[0])
                        sentAudio.append(alienejectives[ejectivelist[0]])
                    elif item.upper() == "IMPLOSIVE": # Implosive for implosive consonants
                        random.shuffle(implosivelist)
                        comboSounds.append((implosivelist[0], alienimplosives[implosivelist[0]]))
                        sentString.append(implosivelist[0])
                        sentAudio.append(alienimplosives[implosivelist[0]])

                    elif item in alienvowels:
                        comboSounds.append((item, alienvowels[item]))
                        sentString.append(item)
                        sentAudio.append(alienvowels[item])
                    elif item in alienpulmonics:
                        comboSounds.append((item, alienpulmonics[item]))
                        sentString.append(item)
                        sentAudio.append(alienpulmonics[item])
                    elif item in alienclicks:
                        comboSounds.append((item, alienclicks[item]))
                        sentString.append(item)
                        sentAudio.append(alienclicks[item])
                    elif item in alienejectives:
                        comboSounds.append((item, alienejectives[item]))
                        sentString.append(item)
                        sentAudio.append(alienejectives[item])
                    elif item in alienimplosives:
                        comboSounds.append((item, alienimplosives[item]))
                        sentString.append(item)
                        sentAudio.append(alienimplosives[item])
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








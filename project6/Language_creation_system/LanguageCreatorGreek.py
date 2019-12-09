from LanguageCreatorAbstract import *
from LanguageGreek import *
import random
import os
from pydub import AudioSegment

"""
This module defines the conscrete subclass, i.e. the concrete Creator in the Factory pattern.
Here it is a concrete creator for Greek data
"""

class LanguageCreatorGreek(LanguageCreator):

    def createData(self, sounds, rules):
        """
        :type sounds: str
        :type rules: str
        """
        dataDict = {}
        language = LanguageGreek("Greek")
        greekvowels, greekpulmonics = language.addSounds(sounds)
        vowellist = list(greekvowels.keys())
        pulmoniclist = list(greekpulmonics.keys())
        greekrules = language.addRules(rules)

        outpath = "generatedData/" + language.name + "/"
        if not os.path.exists(outpath):
            os.makedirs(outpath)

        for k, v in greekvowels.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound
        for k, v in greekpulmonics.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound

        if rules:
            sentString = []
            sentAudio = []
            for r in greekrules:
                comboSounds = []
                for item in r:
                    if item.upper() == 'V': # V for vowel
                        random.shuffle(vowellist)
                        comboSounds.append((vowellist[0], greekvowels[vowellist[0]]))
                        comboSounds.append((vowellist[0], greekvowels[vowellist[0]]))
                        sentString.append(vowellist[0])
                    elif item.upper() == 'C': # C for pulmonic consonants
                        random.shuffle(pulmoniclist)
                        comboSounds.append((pulmoniclist[0], greekpulmonics[pulmoniclist[0]]))
                        sentString.append(pulmoniclist[0])
                        sentAudio.append(greekpulmonics[pulmoniclist[0]])

                    elif item in greekvowels:
                        comboSounds.append((item, greekvowels[item]))
                        sentString.append(item)
                        sentAudio.append(greekvowels[item])
                    elif item in greekpulmonics:
                        comboSounds.append((item, greekpulmonics[item]))
                        sentString.append(item)
                        sentAudio.append(greekpulmonics[item])
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









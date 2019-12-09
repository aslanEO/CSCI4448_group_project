from LanguageCreatorAbstract import *
from LanguageXoo import *
import random
import os
from pydub import AudioSegment

"""
This module defines the conscrete subclass, i.e. the concrete Creator in the Factory pattern.
Here it is a concrete creator for Xoo data
"""

class LanguageCreatorXoo(LanguageCreator):

    def createData(self, sounds, rules):
        """
        :type sounds: str
        :type rules: str
        """
        dataDict = {}
        language = LanguageXoo("Xoo")
        xoovowels, xoopulmonics, xooclicks = language.addSounds(sounds)
        vowellist = list(xoovowels.keys())
        pulmoniclist = list(xoopulmonics.keys())
        clicklist = list(xooclicks.keys())
        xoorules = language.addRules(rules)

        outpath = "generatedData/" + language.name + "/"
        if not os.path.exists(outpath):
            os.makedirs(outpath)

        for k, v in xoovowels.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound
        for k, v in xoopulmonics.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound
        for k, v in xooclicks.items():
            if k+'.wav' not in os.listdir(outpath):
                singleSound = AudioSegment.from_wav(v)
                dataDict[k] = singleSound

        if rules:
            sentString = []
            sentAudio = []
            for r in xoorules:
                comboSounds = []
                for item in r:
                    if item.upper() == 'V': # V for vowel
                        random.shuffle(vowellist)
                        comboSounds.append((vowellist[0], xoovowels[vowellist[0]]))
                        sentString.append(vowellist[0])
                        sentAudio.append(xoovowels[vowellist[0]])
                    elif item.upper() == 'C': # C for pulmonic consonants
                        random.shuffle(pulmoniclist)
                        comboSounds.append((pulmoniclist[0], xoopulmonics[pulmoniclist[0]]))
                        sentString.append(pulmoniclist[0])
                        sentAudio.append(xoopulmonics[pulmoniclist[0]])
                    elif item.upper() == 'CLICK': # Click for click consonants
                        random.shuffle(clicklist)
                        comboSounds.append((clicklist[0], xooclicks[clicklist[0]]))
                        sentString.append(clicklist[0])
                        sentAudio.append(xooclicks[clicklist[0]])

                    elif item in xoovowels:
                        comboSounds.append((item, xoovowels[item]))
                        sentString.append(item)
                        sentAudio.append(xoovowels[item])
                    elif item in xoopulmonics:
                        comboSounds.append((item, xoopulmonics[item]))
                        sentString.append(item)
                        sentAudio.append(xoopulmonics[item])
                    elif item in xooclicks:
                        comboSounds.append((item, xooclicks[item]))
                        sentString.append(item)
                        sentAudio.append(xooclicks[item])
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









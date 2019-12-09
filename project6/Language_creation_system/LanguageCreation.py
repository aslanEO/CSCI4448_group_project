"""
This is the main code to run the language creation system.
You can create new languages and specify what combined audio you'd like to generate in this part.
Newly created audio files will be stored in ./generatedData/LANGUAGENAME/ as IPASYMBOLS.wav.
"""

from LanguageCreatorEnglish import *
from LanguageCreatorGreek import *
from LanguageCreatorXoo import *
from LanguageCreatorAlien import *

print("... Generating English data ...")
createEnglish = LanguageCreatorEnglish()
# createEnglish.createData()
createEnglish.storeData(sounds="ipt", rules="CVC")
createEnglish.storeData(sounds="ipt", rules="pit")
createEnglish.storeData(sounds="ʃitfɪæz", rules="ʃ ʃi ʃit fɪʃ fɪʃɪz ʃi hæz fɪʃ")
createEnglish.storeData(sounds="ʃitfɪæz", rules="ʃi hæz fɪʃ")
print("DONE!")

print("\n... Generating Greek data ...")
createGreek = LanguageCreatorGreek()
createGreek.storeData(sounds="ipt", rules="CVC")
createGreek.storeData(sounds="ipt", rules="pit")
print("DONE!")

print("\n... Generating Xoo data ...")
createXoo = LanguageCreatorXoo()
createXoo.storeData(sounds="ipt", rules="CVC")
createXoo.storeData(sounds="ipt", rules="pit")
createXoo.storeData(sounds="ʘaɟeǁu", rules="ʘ ʘa ʘaɟe ǁuʘ eʘaɟe")
createXoo.storeData(sounds="ʘaɟetsɜnciǁu", rules="ʘaɟe eʘaɟe tsɜnci ǁuʘa")
print("DONE!")

print("\n... Generating Alien data ...")
createAlien = LanguageCreatorAlien()
createAlien.storeData(sounds="ipt", rules="CVC")
createAlien.storeData(sounds="ipt", rules="pit")
print("DONE!")

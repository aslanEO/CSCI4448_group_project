# CSCI4448/5448 --- OOAD ---- Project 6: Happy Learning

Date: 12/09/2019

## Team Members 

Ji Zhao, Yiou Gao, Ling Liu

## Environment

- Language creation system: 

  The language creation system is developed and tested with Python 3.8.0.

  It also requires [pydub](https://github.com/jiaaro/pydub). Please refer to [pydub for installation](https://github.com/jiaaro/pydub#installation).

- Game system:

  The game system is developed and tested with Java 13.0.1, Android Studio 3.5.2, Android SDK Tools 26.1.1, Android Platform Version API 29: Android 10.0 (Q) revision 3. You need to install Android Studio and SDK to run the system.
  
  Firebase is used for data storage.

## PDF file

*project6_FinalReport.pdf* is the required PDF file.

## How to run the code

#### Download the repository:

*$ git clone https://github.com/aslanEO/CSCI4448_group_project.git*

#### Go to the directory for this project:

*$ cd CSCI4448_group_project/project6/*

#### After you are in the directory CSCI4448_group_project/project6/,

- Language creation system: 

  *$ cd Language_creation_system/*
  
  *$ python3 LanguageCreation.py*
  
  After this, audio files will be created as specified in LanguageCreation.py. Created data will be stored in *./generatedData/*. 

- Game system:

  Open *Game_system/* with Android Studio. Then you can run the Happy Learning game system from there.

## Note

Our project includes two parts: Language Creation system and Game system.

The Languages Creation system is used to generate audio data that the Game system needs.

Happy Learning happens with the Game system.



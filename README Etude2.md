# Etude 2
This java class reads the number of syllables in a given word  
It uses a regular expression pattern which can detect if a vowel is present in the string. 
It uses 3 rules to achieve this...
#1: Count the number of vowels (A, E, I, O, U) in the word plus Y for each time it makes the sound of a vowel. 
We assume all vowels together are Diphthongs or Triphthong so count these multiple vowels as syllables. 
#2: Substract one syllable count for each silent "e". 
#3: If word ends in "le" or "les" add 1 count only if the letter before the "le/les" is a consonant.
*Note Rule 2/3 only apply to words >2 characters 


## How to complie
To complie the program just complie the Etude2.java file  
The command to complie the java class is as follows  
```javac Etude2.java```

## How to run the program
To run the program please enter the following file including your test file   
The command to run the java class is as follows   
```java Etude2 < <testFile>```

A file is required to be pipe through to the java class via the commandline

##Test data
Within the folder there 6 text files containing words with known Syllable counts according to the name of the text file.

##Test Results
The program works fairly well counting about 90% of words syllables correctly and when misscountd only tends to be off by one.
Refer to "Test-Results" file to see results. 
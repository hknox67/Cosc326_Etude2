import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/* Filename: Etude2.java
 * This java class reads the number of syllables in a given word
 * It uses a regular expression pattern which can detect if a vowel is present in the string.
 * Rule List:
 * 1: Count the number of vowels (A, E, I, O, U) in the word plus Y for each time it makes the sound of a vowel. 
 * We assume all vowels together are Diphthongs or Triphthong so count these multiple vowels as syllables. 
 * 2: Substract one syllable count for each silent "e". 
 * 3: If word ends in "le" or "les" add 1 count only if the letter before the "le/les" is a consonant.
 * Note Rule 2/3 only apply to words >3 characters 
 */
public class Etude2 {
   static Pattern vowels = Pattern.compile("[aeiouy]+"); // A static data field holding the regular expression for detecting rule 1.
   
    /**
     * The main method processes the input by reading in the stdin through the java scanner and passing the strings to 
     * the method countSyllables
     *
     * @param Passing a text file through piping it in the commandline is required
     */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in); // creates a scanner instance reading from standard input
      try{
         while (input.hasNextLine()) { // while loop reading every line of stdin
            String currentWord = input.nextLine(); // sets the current line to the currentWord string variable
            System.out.println(currentWord);
            if (!(currentWord.isBlank())) { // check if currentWord is blank
               System.out.println(countSyllables(currentWord)); // calls the countSyllables method and prints out the return value         
            }else{
               System.out.println("No Word List Entered"); 
            }
         }
      }catch(Exception e){
         System.out.println(e);
      }
      input.close(); // closes the input scanner
   }

    /**
     * The countSyllables method counts the number of syllables in a string using the regular expression pattern 
     * according to the 3 rules above.
     * @param String word is the word that you want to count the number of syllables that word contains
     * @return returns an int called count which is the total count of syllables found
     */
   public static int countSyllables(String word) {
      word = word.toLowerCase(); // change word String to lowercase and store it
      int count = 0; // initalise count variable to 0
      Matcher match = vowels.matcher(word); // create a matcher instance and use the vowels data field containing the regular expression to find matches
      while (match.find()) { // code block which simply counts all vowels #rule 1
         count++; // if match found increment the count variable
      }
      
      //Rules below do not apply to words less than 3 characters
      if(word.length()>3){  
      /* code block finding all mentions of "les" from #rule3 which subtracts a syllable count 
      * unles the character immediatly behind the "les" is a consonant"
      */ 
         if(word.substring(word.length()-3, word.length()).equals("les")){
            count--; 
            match = vowels.matcher(word.substring(word.length()-4, word.length()-3));
            if(!match.find()){
               System.out.println("les found");
               count++;
            }
         }
      
      /* code block finding all mentions of "le" from #rule3 which subtracts a syllable count 
      * unles the character immediatly behind the "le" is a consonant"
      */ 
         if(word.substring(word.length()-2, word.length()).equals("le")){
            count--; 
            match = vowels.matcher(word.substring(word.length()-3, word.length()-2));
            if(!match.find()){
               count++;
            }
         /*
         * code block for #rule 2 trailing e. Only triggered if the #rule3 "le" case is not already triggered
         */ 
         }else{
            if(word.charAt(word.length()-1)=='e'){
               count--;
            }
         }
      }
   
      return count; // return count variable
   }  
}
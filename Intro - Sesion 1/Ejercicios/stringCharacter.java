import java.util.Scanner;

public class stringCharacter {
  public static void main(String [] args) {
    String words = getString();
    printWords(words);
    String switchword = switchWords(words);
    printWords(switchword);
    countLetters(words);
    boolean number = hasNumbers(words);
    if (number){
      System.out.println("The sentences has numbers");
    }
    String inverted = invertOrder(words);
    printWords(inverted);
  } 

  public static void printWords(String word) {
    System.out.println(word);
  } 

  public static String getString() {
    Scanner input = new Scanner(System.in);
    System.out.print("Write a sentence: ");
    String sentence = input.nextLine();
    return sentence;
  } 

// java.lang.StringBuilder -> class is mutable sequence of characters.
  public static String switchWords(String word) {
    StringBuilder sb = new StringBuilder(word);
    for (int index = 0; index < sb.length(); index++) {
      char c = sb.charAt(index);
// java.lang.Character class wraps a value of the primitive type char in an object
      if (Character.isLowerCase(c)) {
          sb.setCharAt(index, Character.toUpperCase(c));
      } else {
          sb.setCharAt(index, Character.toLowerCase(c));
      }
    }
    return sb.toString();
  } 

  public static void countLetters(String word) {
    int sum = 0;
    for (int index = 0; index < word.length(); index++) {
      char c = word.charAt(index);
      if (c != ' ' && !(c >= '0' && c <= '9')){
        sum++;
      }
    }
    System.out.println("Total letters: " + sum);
  }

  public static boolean hasNumbers(String word) {
    for (int index = 0; index < word.length(); index++) {
      char c = word.charAt(index);
      if (c >= '0' && c <= '9'){
         return true;
      }
    }
    return false;
  }

   public static String invertOrder(String word) {
     return new StringBuilder(word).reverse().toString();
  } 

}
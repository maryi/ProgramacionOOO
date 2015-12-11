 import java.util.*;
//prime number checker
//http://www.math.com/students/calculators/source/prime-number.htm

public class RandomNumbers {
  public static void main(String [] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("how many numbers do you want? ");
    int number = input.nextInt();
    Random r = new Random();
    int[] arrayNum = createNumbers(number, r);
    printArray(arrayNum, "original Array");
    orderArray(arrayNum);
    printArray(arrayNum, "ordered Array");
    int min = minArray(arrayNum);
    int max = maxArray(arrayNum);
    int difference = differenceArray(min, max);
    printVarrayValues(min, max, difference);
    // evenNumbers(arrayNum, number);
    // oddNumbers(arrayNum, number);
    evenOdd(arrayNum, number);
    primeNumbers(arrayNum, number);
  }

  public static void printVarrayValues(int min, int max, int difference) {
    System.out.println("the min value in the Array is: " + min);
    System.out.println("the max value in the Array is: " + max);
    System.out.println("the difference is: " + difference);
  }

  public static void printArray(int[] myArray, String sentence) {
    System.out.println(sentence);
    System.out.println(Arrays.toString(myArray));
  }

  public static void printList(ArrayList<Integer> myList, String sentence) {
    System.out.println(sentence);
    System.out.println(myList.toString());
  }

  public static int[] createNumbers(int num, Random r) {
    int[] numbers = new int [num];
    for (int i = 1; i <= num; i++) {
      numbers[i-1] = r.nextInt(100) + 1;
    }
    return numbers;
  }

  public static void orderArray(int[] myArray) {
     Arrays.sort(myArray);
  }

  public static int minArray(int[] myArray) {
    int min = myArray[0];
    return min;
  }

  public static int maxArray(int[] myArray) {
    int max = myArray[myArray.length-1];
    return max;
  }

  public static int differenceArray(int min, int max) {
    int difference = max - min;
    return difference;
  }
//old evenOdd method
  // public static void evenOdd(int[] myArray, int num) {
  //   int[] evenArray = new int [num];
  //   int[] oddArray = new int [num];
  //   int evenNum = 0;
  //   int oddNum = 0;
  //   for (int i = 0; i < num; i++) {
  //     if (myArray[i]%2 == 0){
  //       evenArray[evenNum] = myArray[i]; 
  //       evenNum++;     
  //     } else {
  //       oddArray[oddNum] = myArray[i];
  //       oddNum++;
  //     }
  //   }
  //   printArray(evenArray, "Even numbers: ");
  //   printArray(oddArray, "Odd numbers: ");
  // }  
// old evenNumbers
  public static void evenNumbers(int[] myArray, int num) {
    boolean even = false;
    System.out.println("Even numbers");
    for (int i = 0; i < num; i++) {
      if (myArray[i]%2 == 0){
        System.out.print(myArray[i] + " ");
        even = true;
      }
    }
    if (even){
      System.out.println();
    } else {
    System.out.println("0");
    } 
  }

// old oddNumbers
  public static void oddNumbers(int[] myArray, int num) {
    boolean odd = false;
    System.out.println("Odd numbers");
    for (int i = 0; i < num; i++) {
      if (myArray[i]%2 != 0){
        System.out.print(myArray[i] + " ");
        odd = true;
      }
    }
    if (odd){
      System.out.println();
    } else {
      System.out.println("0");
    } 
  }
//
  public static void evenOdd(int[] myArray, int num) {
    ArrayList<Integer> evenList = new ArrayList<Integer>();
    ArrayList<Integer> oddList = new ArrayList<Integer>();
    for (int i = 0; i < num; i++) {
      if (myArray[i]%2 == 0){
        evenList.add(myArray[i]);     
      } else {
        oddList.add(myArray[i]);
      }
    }
    printList(evenList, "Even numbers: ");
    printList(oddList, "Odd numbers: ");
  }

  public static void primeNumbers(int[] myArray, int num) {
    boolean primeFlag = false;
    System.out.println("Prime numbers");
    for (int i = 0; i < num; i++) {
        boolean prime = isPrime(myArray[i]);
        if (prime){
          System.out.print(myArray[i] + " ");
          primeFlag = true;
        }
    }
    if (primeFlag){
      System.out.println();
    } else {
      System.out.println("0");
    }
  }

 private static boolean isPrime(int n) { //private?
    //check if n is a multiple of 2
    if (n%2==0) return false;
    //if not, then just check the odds
    for(int i=3;i*i<=n;i+=2) {
        if(n%i==0)
          return false;
    }
    return true;
  }
}
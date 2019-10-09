/* Sahil Gupta - 10/04/2019 - AP CS A
   Lab 3: Static Methods
      -Use static methods that take input via parameters
      and return values through return statements */
public class StaticMethods { // delcare class StaticMethods
   public static void main(String[] args) {                // main method
      String output = getNumberFunFacts(9, 5, 3);          // set String output to method call of getNumberFunFacts
      System.out.println(output);                          // print out the return value given from getNumberFunFacts
    }
   
   public static int getMultiple(int numOne, int numTwo) { // declare method getMultiple with 2 parameters
      return (numOne * numTwo);                            // return the product of the 2 parameters
   }
   
   public static int getPower(int numPow, int powOf) { // declare the method getPower with 2 parameters
      int numPowCon = numPow;                          // declare int numPowCon and set it to numPow
      for(int i = 2; i <= powOf; i++){                 // run a for loop with i = 2 and a boundary of powOf
         numPow = getMultiple(numPow, numPowCon);      // set numPow to the return value of getMultiple
      }
      return numPow;                                   // return the value of numPow
   }
   
   public static String getMultiples(int val, int mulCnt) {                     // delcare the method getMultiples with 2 parameters
      String output = "The first " + mulCnt + " multiples of " + val + " are:"; // delcare output and set to the string value
      int numOut;                                                               // delcare numOut to 0
      for(int k = 1; k <= mulCnt; k++){                                         // run a for loop with mulCnt as a boundary
         numOut = getMultiple(val, k);                                          // set numOut to the value of getMultiple
         output += "\n  " + numOut;                                             // add Strings to output every time
      }
      return output;                                                            // return the value of output
   }
   
   public static String getPowers(int numPow, int powOf) {                     // declare the method getPowers with 2 parameters
      String output = "The first " + powOf + " powers of " + numPow + " are:"; // declare output to the String value
      int numOut;                                                              // delcare numOut to 0
      for(int j = 1; j <= powOf; j++){                                         // run a for loop with a boundary of powOf
         numOut = getPower(numPow, j);                                         // set numOut, to the output of getPower
         output += "\n  " + numOut;                                            // add to the output everytime
      }
      return output;                                                           // return the output
   }
   
   public static String getNumberFunFacts(int val, int mulCnt, int powCnt) { // declare getNumberFunFacts with 3 parameters
      String funOutput = "Here are some fun facts about the number " + val;  // set funOutput to the String value
      String getMulOut = getMultiples(val, mulCnt);                          // set getMulOut to the return value of getMultiples
      String getPowOut = getPowers(val, powCnt);                             // set getPowOut to the return value of getPowers
      funOutput += "\n" + getMulOut + "\n" + getPowOut;                      // add the output of getMulOut and getPowOut to funOutput
      return funOutput;                                                      // return the final value of funOutput
   }
}
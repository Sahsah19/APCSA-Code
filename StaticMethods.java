/* Sahil Gupta - 10/04/2019 - AP CS A
   Lab 3: Static Methods
      -Use static methods that take input via parameters
      and return values through return statements */
public class StaticMethods{ //delcare class "StaticMethods"
   public static void main(String[] args) { //main method
      String output = getNumberFunFacts(9, 5, 3); //set String "output" to method call of getNumberFunFacts
      System.out.println(output); // print out the return value given from getNumberFunFacts
    }
   
   public static int getMultiple(int numOne, int numTwo) { // declare method getMultiple with 2 parameters
      return (numOne * numTwo); // return the product of the 2 parameters
   }
   
   public static int getPower(int numPow, int powOf) { //declare the method getPower with 2 parameters
      int numPowCon = numPow; // declare int "numPowCon" and set it to "numPow"
      for(int i = 2; i <= powOf; i++){ // run a for loop with i = 2 and a boundary of "powOf"
         numPow = getMultiple(numPow, numPowCon);
      }
      return numPow;
   }
   
   public static String getMultiples(int val, int mulCnt) {
      String output = "The first " + mulCnt + " multiples of " + val + " are:";
      int numOut;
      for(int k = 1; k <= mulCnt; k++){
         numOut = getMultiple(val, k);
         output += "\n  " + numOut;    
      }
      return output;
   }
   
   public static String getPowers(int numPow, int powOf) {
      String output = "The first " + powOf + " powers of " + numPow + " are:";
      int numOut;
      for(int j = 1; j <= powOf; j++){
         numOut = getPower(numPow, j);
         output += "\n  " + numOut;   
      }
      return output;
   }
   
   public static String getNumberFunFacts(int val, int mulCnt, int powCnt) {
      String funOutput = "Here are some fun facts about the number " + val;
      String getMulOut = getMultiples(val, mulCnt);
      String getPowOut = getPowers(val, powCnt);
      funOutput += "\n" + getMulOut + "\n" + getPowOut;
      return funOutput;
   }
}
/* Sahil Gupta - AP CS A - 11/15/2019
Frac Calc - Write a program to act
as a calculator using everything from
chapters 1 - 5 */
import java.util.Scanner;

public class FracCalcTest { //start of class
   public static void main(String[] args) { //main method
      Scanner scan = new Scanner(System.in); //declaration of scanner
      System.out.println("Welcome to Sahil's FracCalc!\nType \"quit\" anytime to exit."); //welcome statement

      System.out.print("Enter an expression: "); //input statement
      String expression = scan.nextLine(); //scan the entered string

      while (!expression.equalsIgnoreCase("quit")) { //while the expression does not equal "quit"
         if (expression.equalsIgnoreCase("test")) { //if the expression equals "test"
            runTests(); //call method runTests
         } else { //otherwise
            System.out.println(produceAnswer(expression)); //print out the answer of produceAnswer with the given input
            System.out.print("Expression evaluated, "); //signal statement
         }
         System.out.print("enter another expression: "); //call for another statement
         expression = scan.nextLine(); //scan the input again
      }
      System.out.print("Thank you for using Sahil's FracCalc! Have a great day!"); //goodbye statement
   }

   public static String produceAnswer(String input) { //start of method produceAnswer
      String output = "";
       if (input.indexOf(" ") == -1){
            output = "Error: Invalid Input, You Have to at least Enter 2 Operands and an Operator";
      } else { 
         String[][] separatedOp = separateInput(input.split(" "));
         String[] operands = separatedOp[0];
         String[] operators = separatedOp[1];
      }   
      return output; //return the output
   }
   public static String[][] separateInput(String[] input){
      String cP = "";
      int operatorCnt = 0, operandCnt = 0;
      String separated[][] = new String[2][(input.length) - ((int) Math.floor((input.length) / 2))];
      for(int i = 0; i < input.length; i++){
         cP = input[i];
         if (cP.contains("+") || cP.contains("-") || cP.contains("/") || cP.contains("*")){
            if (cP.equals("/") || cP.equals("-")){
               separated[1][operatorCnt] = "Error: Invalid Operator :(";
            } else {
               separated[1][operatorCnt] = input[i];
            }
            operatorCnt++;
         } else {
            separated[0][operandCnt] = input[i];
            operandCnt++;
         }
      }
      return separated;   
   }
   
   public static String intoMixed(int[] simplified){
      int isNeg = 1;
      String output = "";
      if (simplified[0] < 0){
         isNeg = -1;
      }
      output = (isNeg * (int) Math.floor(Math.abs(simplified[0]) / simplified[1])) + "_" + (Math.abs(simplified[0]) % simplified[1]) +
         "/" + simplified[1];
      return output;   
   }
   
   public static int[] combineOperands(int[] firstOperand, int[] secondOperand, String operator) { //method combineOperands
      int[] outputArray = new int[2]; //outputArray of length of 2
      if (operator.equals("+") || operator.equals("-")) { //if the operator is "+" or "-"
         if (firstOperand[1] != (secondOperand[1])) { //if both denominators are not the same
            outputArray[1] = firstOperand[1] * secondOperand[1]; //multiply both denominators together
            //multiply the denominator with the opposite numerator
            firstOperand[0] = firstOperand[0] * secondOperand[1]; 
            secondOperand[0] = secondOperand[0] * firstOperand[1];
         } else {
            outputArray[1] = firstOperand[1]; //otherwise set the denom. to one of the denoms.
         }
         if (operator.equals("+")) { //if it is addition 
            outputArray[0] = firstOperand[0] + secondOperand[0]; //add the numerators
         } else { //otherwise
            outputArray[0] = firstOperand[0] - secondOperand[0]; //subtract numerators
         }
      } else if (operator.equals("*")) { //multiplication method
         //multiply both numerators by each other
         outputArray[1] = firstOperand[1] * secondOperand[1];
         outputArray[0] = firstOperand[0] * secondOperand[0];
      } else if (operator.equals("/")) { //if it is division
         //flip one of the operands and multiply
         outputArray[1] = firstOperand[1] * secondOperand[0];
         outputArray[0] = firstOperand[0] * secondOperand[1];
      } else { //otherwise it is invalid operator
         //set both to -1
         outputArray[1] = -1;
         outputArray[0] = -1;
      }
      return outputArray; //return the output
   }

   public static int[] simplifyOperand(int[][] combined) { //simplification method
      int boundary = 0; //simple declaration statements
      int isNegative = 1;
      for(int i = 0; i < combined.length; i++){
         int absNum = Math.abs(combined[i][0]);
         int absDenom = Math.abs(combined[i][1]);
         if (combined[i][0] < 0 || combined[i][1] < 0) { // if there is a negative number 
            if (combined[i][0] < 0 && combined[i][1] < 0) { //if there is a neg. num. in both sides
               isNegative = 1; //set to 1
            } else {
               isNegative = -1; //set to -1
            }
         }
         //set boundary to the lowest num.
         if (absNum > absDenom) { 
            boundary = absDenom;
         } else {
            boundary = absNum;
         }
         //for loop until the boundary is reached and simplified
         for (int i = 1; i <= boundary; i++) {
            if (absNum % i == 0 && absDenom % i == 0) {
               combined[i][0] = absNum / i;
               combined[i][1] = absDenom / i;
            }
         }
         combined[i][0] *= isNegative; //multiply if there is negative
      }   
      return combined; //return
   }

   public static int[] condenseOperand(String[][] operands) { //condense operand
      int[][] condensedOperands = new int[operands.length][2]; //new array
      for(int i = 0; i < operands.length; i++){
         if (operands[i][0].equals("0") && !operands[i][1].equals("0")) {
            condensedOperands[i][0] = Integer.parseInt(operands[i][1]);
            condensedOperands[i][1] = Integer.parseInt(operands[i][2]);
         } else if (operands[i][1].equals("0") && operands[i][2].equals("1")) {
            condensedOperands[i][0] = Integer.parseInt(operands[i][0]);
            condensedOperands[i][1] = Integer.parseInt(operands[i][2]);
         } else {
            int negative = 1;
            if (Integer.parseInt(operand[i][0]) < 0) {
               negative = -1;
            }
            condensedOperands[i][0] = (Math.abs(Integer.parseInt(operands[i][0])) * Math.abs(Integer.parseInt(operands[i][2])))
               + Integer.parseInt(operands[i][1]);
            condensedOperands[i][1] = Integer.parseInt(operands[i][2]);
            condensedOperands[i][0] *= negative;
         }   
      }
      return simplifyOperand(condensedOperands); //return the operand
   }

   public static String[][] partsOfOperand(String[] separated) { //parts of operand method
      String[][] components = new String[separated.length][3]; //new array with 3 strings
      for(int i = 0; i < separated.length; i++){
         if (separated[i].indexOf("_") != -1) {
            int locUnderscore = separated[i].indexOf("_");
            components[i][0] = separated[i].substring(0, locUnderscore);
            components[i][1] = separated[i].substring(locUnderscore + 1, separated[i].indexOf("/"));
            components[i][2] = separated[i].substring(separated[i].indexOf("/") + 1, separated[i].length());
            //otherwise whole number
         } else if (separated[i].indexOf("_") == -1 && separated[i].indexOf("/") == -1) {
            components[i][0] = separated[i];
            components[i][1] = "0";
            components[i][2] = "1";
         } else { //otherwise improper fraction
            components[i][0] = "0";
            components[i][1] = separated[i].substring(0, separated[i].indexOf("/"));
            components[i][2] = separated[i].substring(separated[i].indexOf("/") + 1, separated[i].length());
         }
      }   
      return components;
   }

   public static void runTests() { //testing method
      //all the inputs and outputs
      String[][] expectedInNOut = { {"10/4 + 3/2", "4"},
                                    {"2 + 11", "13"},
                                    {"1_3/4 * -4_5/6", "-8_11/24"},
                                    {"1/2 / -4/5", "-5/8"},
                                    {"1/0 - 2", "Error: Cannot Divide by 0 :("},
                                    {"1 -- 4", "Error: Invalid Operator :("},
                                    {"1/2 - 1/2", "0"},
                                    {"1_5/3 * -12_15/28", "-33_3/7"},
                                    {"1 / 0", "Error: Cannot Divide by 0 :("},
                                    {"1/2 + -9_9/10", "-9_2/5"},
                                    {"-3_9/3 + -3_3/4", "-9_3/4"},
                                    {"1_5/3 - 4_1/5", "-1_8/15"},
                                    {"-9_1/6 - -8/3", "-6_1/2"},
                                    {"8/9 - -7_6/2", "10_8/9"},
                                    {"7/4 / 2", "7/8"},
                                    {"7_8/9 * 3_7/2", "51_5/18"},
                                    {"-1 - -1", "0"},
                                    {"0 / 1", "0"},
                                    {"0/1 + 1", "1"},
                                    {"0/1 ** 1", "Error: Invalid Operator :("} };
      int count = 0;
      String testAnswer = "";
      //run the array through produce answer to find any discrepancies
      for(int i = 0; i < expectedInNOut.length; i++) {
         testAnswer = produceAnswer(expectedInNOut[i][0]);
         if(testAnswer.equals(expectedInNOut[i][1])) {
            count++;
            System.out.println("Test Passed :D");
         }else {
            System.out.println("Test Failed D:");
            System.out.println("Input: " + expectedInNOut[i][0]);
            System.out.println("Expected Output: " + expectedInNOut[i][1]);
            System.out.println("Output: " + testAnswer);
         }  
      }
      System.out.print("Testing Complete, " + count + "/" + expectedInNOut.length + ", "); //final statement
   }
}
/* Sahil Gupta - AP CS A - 11/15/2019
Frac Calc - Write a program to act
as a calculator using everything from
chapters 1 - 5 */
import java.util.Scanner;

public class FracCalc { //start of class
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
      String output = ""; //declare output as a empty string
      if (input.indexOf(" ") == -1){
         output = "Error: Invalid Input, You Have to at least Enter 2 Operands";
      } else { 
         String[] inputArray = input.split(" "); //spilt the input into the operands and operators
         String[] firstArray = partsOfOperand(inputArray[0]); //send the first string into the method to find the parts
         String[] secondArray = partsOfOperand(inputArray[2]); //send the second string into the method to find the parts

         if (firstArray[2].equals("0") || secondArray[2].equals("0")) { //if the denominators equal 0 then return a error statement
            output = "Error: Cannot Divide by 0 :("; //error statement
         } else if (inputArray[1].equals("/") && secondArray[0].equals("0") && secondArray[1].equals("0")) { //if the numerator is 0, of the second 
            output = "Error: Cannot Divide by 0 :("; //error statement
         } else { //otherwise
            int[] condensedFirst = condenseOperand(firstArray); //condense the first operand
            int[] condensedSecond = condenseOperand(secondArray); //condense the second operand
            int[] combinedAnswer = combineOperands(condensedFirst, condensedSecond, inputArray[1]); //combine the 2 answers together
   
            if (combinedAnswer[0] == -1 && combinedAnswer[1] == -1) { //if both numerator and denominator equal -1 then it is a invalid operand
               output = "Error: Invalid Operator :("; //error statement
            } else {
               combinedAnswer = simplifyOperand(combinedAnswer); //simplify the combined answer
               if (combinedAnswer[1] == 1) { //if the denominator equals 1
                  output = combinedAnswer[0] + ""; //set the output as a whole number
               } else if (combinedAnswer[0] == 0) { //if the numerator is equal to 0
                  output = "0"; //output is 0
               } else { //otherwise
                  output = combinedAnswer[0] + "/" + combinedAnswer[1]; //output as normal fraction
               }
            }
         }
      }
      return output; //return the output
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

   public static int[] simplifyOperand(int[] combined) { //simplification method
      int boundary = 0; //simple declaration statements
      int isNegative = 1;
      if (combined[0] < 0 || combined[1] < 0) { // if there is a negative number 
         if (combined[0] < 0 && combined[1] < 0) { //if there is a neg. num. in both sides
            isNegative = 1; //set to 1
         } else {
            isNegative = -1; //set to -1
         }
      }
      //set boundary to the lowest num.
      if (Math.abs(combined[0]) > Math.abs(combined[1])) { 
         boundary = Math.abs(combined[1]);
      } else {
         boundary = Math.abs(combined[0]);
      }
      //for loop until the boundary is reached and simplified
      for (int i = 1; i <= boundary; i++) {
         if (Math.abs(combined[0]) % i == 0 && Math.abs(combined[1]) % i == 0) {
            combined[0] = Math.abs(combined[0]) / i;
            combined[1] = Math.abs(combined[1]) / i;
         }
      }
      combined[0] *= isNegative; //multiply if there is negative
      return combined; //return
   }

   public static int[] condenseOperand(String[] operand) { //condense operand
      int[] condensedOperand = new int[2]; //new array
      //determining composition of the operand
      if (operand[0].equals("0") && !operand[1].equals("0")) {
         condensedOperand[0] = Integer.parseInt(operand[1]);
         condensedOperand[1] = Integer.parseInt(operand[2]);
      } else if (operand[1].equals("0") && operand[2].equals("1")) {
         condensedOperand[0] = Integer.parseInt(operand[0]);
         condensedOperand[1] = Integer.parseInt(operand[2]);
      } else {
         int negative = 1;
         if (Integer.parseInt(operand[0]) < 0) {
            negative = -1;
         }
         condensedOperand[0] = (Math.abs(Integer.parseInt(operand[0])) * Math.abs(Integer.parseInt(operand[2])))
               + Integer.parseInt(operand[1]);
         condensedOperand[1] = Integer.parseInt(operand[2]);
         condensedOperand[0] *= negative;
      }
      return simplifyOperand(condensedOperand); //return the operand
   }

   public static String[] partsOfOperand(String operand) { //parts of operand method
      String[] components = new String[3]; //new array with 3 strings
      String whole = ""; //declaration methods
      String numerator = "";
      String denominator = "";
      //if there is a underscore, mixed number
      if (operand.indexOf("_") != -1) {
         int locUnderscore = operand.indexOf("_");
         whole = operand.substring(0, locUnderscore);
         numerator = operand.substring(locUnderscore + 1, operand.indexOf("/"));
         denominator = operand.substring(operand.indexOf("/") + 1, operand.length());
         //otherwise whole number
      } else if (operand.indexOf("_") == -1 && operand.indexOf("/") == -1) {
         whole = operand;
         numerator = "0";
         denominator = "1";
      } else { //otherwise improper fraction
         whole = "0";
         numerator = operand.substring(0, operand.indexOf("/"));
         denominator = operand.substring(operand.indexOf("/") + 1, operand.length());
      }
      //set everything to correct index in array
      components[0] = whole;
      components[1] = numerator;
      components[2] = denominator;
      return components;
   }

   public static void runTests() { //testing method
      //all the inputs and outputs
      String[][] expectedInNOut = { {"10/4 + 3/2", "4"},
                             {"2 + 11", "13"},
                             {"1_3/4 * -4_5/6", "-203/24"},
                             {"1/2 / -4/5", "-5/8"},
                             {"1/0 - 2", "Error: Cannot Divide by 0 :("},
                             {"1 -- 4", "Error: Invalid Operator :("},
                             {"1/2 - 1/2", "0"},
                             {"1_5/3 * -12_15/28", "-468/14"},
                             {"1 / 0", "Error: Cannot Divide by 0 :("},
                             {"1/2 + -9_9/10", "-94/10"},
                             {"-3_9/3 + -3_3/4", "-39/4"},
                             {"1_5/3 - 4_1/5", "-23/15"},
                             {"-9_1/6 - -8/3", "-39/6"},
                             {"8/9 - -7_6/2", "98/9"},
                             {"7/4 / 2", "7/8"},
                             {"7_8/9 * 3_7/2", "923/18"},
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
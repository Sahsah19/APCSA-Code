/* Sahil Gupta - AP CS A - 11/15/2019
   Frac Calc - Write a program to act
   as a calculator using everything from
   chapters 1 - 5 */
import java.util.Scanner;
public class FracCalcCheckpoint3{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.println("Welcome to Sahil's FracCalc!\nType \"quit\" anytime to exit.");
      
      System.out.print("Enter an expression: ");
      String expression = scan.nextLine();
 
      while(!expression.equalsIgnoreCase("quit")){         
         if(expression.equalsIgnoreCase("test")){
            runTests();
         }
         else{
            String[] arrayNumbers= produceAnswer(expression, true);
            System.out.print("Expression evaluated, ");
         }
         System.out.print("enter another expression: ");
         expression = scan.nextLine();
      }
      System.out.print("Thank you for using Sahil's FracCalc! Have a good day!");
   }
   
   public static String[] produceAnswer(String input, boolean togglePrint){
      String[] inputArray = input.split(" ");      
      String[] firstArray = partsOfOperand(inputArray[0]);
      String[] secondArray = partsOfOperand(inputArray[2]);
      String[] condensedFirst = condenseOperand(
      
      if(togglePrint == true){
         System.out.print("whole:" + secondArray[0] + " ");
         System.out.print("numerator:" + secondArray[1] + " ");
         System.out.println("denominator:" + secondArray[2]); 
      }
      
      return secondArray;
   }
   
   public static int[] combineOperands(String[] firstOperand, String[] secondOperand, String operator){
      int[] outputArray = new int[2];
      if(operator.equals("+") || operator.equals("-")){
         if(!firstOperand[1].equals(secondOperand[1])){
            outputArray[1] = (Integer 
         }
      }
   }
   
   public static int[] simplifyOperand(String[] operand){
      while(operand[0] % operand[1] == 0){
         operand[0] /= operand[1];
         operand[1] /= operand[1];
      }
      while(operand[0] % 2 == 0 && operand[1] % 2 == 0){
         operand[0] /= 2;
         operand[1] /= 2;
      }
      while(operand[0] % 3 == 0 && operand[1] % 3 == 0){
         operand[0] /= 3;
         operand[1] /= 3;
      }
      else if(operand[0] % 5 == 0 && operand[1] % 5 == 0){
         operand[0] /= 5;
         operand[1] /= 5;
      }
      return operand;
   }
   
   public static String[] condenseOperand(int[] operand){
      String[] condensedOperand = new String[2];
      if(operand[0] != 0 && operand[1] != 0){
         condensedOperand[0] = "" + (Integer.parseInt(operand[0]) * Integer.parseInt(operand[2]) + Interger.parseInt(operand[1]));
         condensedOperand[1] = operand[2];
      }
      else if(operand[1] == 0 && operand[2] == 1){
         condensedOperand[0] = operand[0];
         condensedOperand[1] = operand[2];
      }
      else{
         condensedOperand[0] = operand[1];
         condensedOperand[1] = operand[2];
      } 
      return condensedOperand;   
   }
      
   public static String[] partsOfOperand(String operand){
      String[] components = new String[3];
      String whole = "";
      String numerator = "";
      String denominator = "";   
      if(operand.indexOf("_") != -1){
         int locUnderscore = operand.indexOf("_");
         whole = operand.substring(0, locUnderscore);
         numerator = operand.substring(locUnderscore + 1, locUnderscore + 2);
         denominator = operand.substring(operand.indexOf("/") + 1, operand.length());
      }
      else if(operand.indexOf("_") == -1 && operand.indexOf("/") == -1){
         whole = operand;
         numerator = "0";
         denominator = "1";
      }
      else{
         whole = "0";
         numerator = operand.substring(0, operand.indexOf("/"));
         denominator = operand.substring(operand.indexOf("/") + 1, operand.length());
      }
      components[0] = whole;
      components[1] = numerator;
      components[2] = denominator;
      return components;
   }
   
   public static void runTests(){
      String[] inputs = {"10/4 + 3/2", "2 + 11", "1_3/4 * -4_5/6", "1/2 / -4/5", "1/0 - 2", "1 -- 4"};
      String[][] expectedOutput = {{"0", "3", "2"}, {"11", "0", "1"}, {"-4", "5", "6"}, {"0", "-4", "5"}, {"2", "0", "1"}, {"4", "0", "1"}};
      int count = 0;
      String output = "";
      String expectOutput = "";
      String[] testArray = new String[3];
      for(int i = 0; i < inputs.length; i++){
         testArray = produceAnswer(inputs[i], false);
         output = testArray[0] + " " + testArray[1] + " " + testArray[2];
         expectOutput = expectedOutput[i][0] + " " + expectedOutput[i][1] + " " + expectedOutput[i][2];
         if(expectOutput.equals(output)){
            count++;
            System.out.println("Test Passed :)");
         }
         else{
            System.out.println("Test Failed :(");
            System.out.println("Input: " + inputs[i]);
            System.out.println("Expected: " + expectOutput);
            System.out.println("Output: " + output);
          }
      }
      System.out.print("Testing complete, " + count + "/6 Tests Passed, ");   
   }
}
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
            System.out.println(produceAnswer(expression));
            System.out.print("Expression evaluated, ");
         }
         System.out.print("enter another expression: ");
         expression = scan.nextLine();
      }
      System.out.print("Thank you for using Sahil's FracCalc! Goodbye!");
   }
   
   public static String produceAnswer(String input){
      String[] inputArray = input.split(" ");      
      String[] firstArray = partsOfOperand(inputArray[0]);
      String[] secondArray = partsOfOperand(inputArray[2]);
      String output = "";
      
      if (firstArray[2].equals("0") || secondArray[2].equals("0")){
         output = "Error: Cannot Divide by 0 :(";
      }
      else{
         int[] condensedFirst = condenseOperand(firstArray);
         int[] condensedSecond = condenseOperand(secondArray);
         int[] combinedAnswer = combineOperands(condensedFirst, condensedSecond, inputArray[1]);
      
         
         if (combinedAnswer[1] == 1){
            output = "" + combinedAnswer[0];
         }
         else if (combinedAnswer[0] == -1 && combinedAnswer[1] == -1){
            output = "Error: Invalid Operator :(";
         }
         else{
            output = combinedAnswer[0] + "/" + combinedAnswer[1];
         }
      }
      return output;
   }
   
   public static int[] combineOperands(int[] firstOperand, int[] secondOperand, String operator){
      int[] outputArray = new int[2];
      if(operator.equals("+") || operator.equals("-")){
         if(firstOperand[1] != (secondOperand[1])){
            outputArray[1] = firstOperand[1] * secondOperand[1];
            firstOperand[0] = firstOperand[0] * secondOperand[1];
            secondOperand[0] = secondOperand[0] * firstOperand[1];
         }
         if(operator.equals("+")){
               outputArray[0] = firstOperand[0] + secondOperand[0];
               outputArray[1] = firstOperand[1];
         }
         else{
            outputArray[0] = firstOperand[0] - secondOperand[0];
            outputArray[1] = firstOperand[1];
         } 
      }
      else if(operator.equals("*")){
         outputArray[1] = firstOperand[1] * secondOperand[1];
         outputArray[0] = firstOperand[0] * secondOperand[0];
      }
      else if(operator.equals("/")){
         outputArray[1] = firstOperand[1] * secondOperand[0];
         outputArray[0] = firstOperand[0] * secondOperand[1];
      }
      else{
         outputArray[1] = -1;
         outputArray[0] = -1; 
      }
      int[] finalArray = simplifyOperand(outputArray);
      return outputArray;
   }
   
   public static int[] simplifyOperand(int[] combined){
      int boundary = 0;
      int isNegative = 1;
      if (combined[0] < 0 || combined[1] < 0){
         if(combined[0] < 0 && combined[1] < 0){
            isNegative = 1;
         }
         else{
            isNegative = -1;
         }
      }
      if (Math.abs(combined[0]) > Math.abs(combined [1])){
         boundary = Math.abs(combined[1]);
      }
      else{
         boundary = Math.abs(combined[0]);
      }
      for (int i = 1; i <= boundary; i++){
         if(Math.abs(combined[0]) % i == 0 && Math.abs(combined[1]) % i == 0){
            combined[0] = Math.abs(combined[0]) / i;
            combined[1] = Math.abs(combined[1]) / i;
         }
      }
      combined[0] *= isNegative;
      return combined;
   }
   
   public static int[] condenseOperand(String[] operand){
      int[] condensedOperand = new int[2];
      if(operand[0].equals("0") && !operand[1].equals("0")){
         condensedOperand[0] = Integer.parseInt(operand[1]);
         condensedOperand[1] = Integer.parseInt(operand[2]);
      }
      else if(operand[1].equals("0") && operand[2].equals("1")){
         condensedOperand[0] = Integer.parseInt(operand[0]);
         condensedOperand[1] = Integer.parseInt(operand[2]);
      }
      else{
         condensedOperand[0] = (Integer.parseInt(operand[0]) * Integer.parseInt(operand[2]) + Integer.parseInt(operand[1]));
         condensedOperand[1] = Integer.parseInt(operand[2]);
      }
      return simplifyOperand(condensedOperand);
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
      String[][] expectedInNOut = { {"10/4 + 3/2", "4"},
                                    {"2 + 11", "13"},
                                    {"1_3/4 * -4_5/6", ""},
                                    {"1/2 / -4/5", "whole:0 numerator:-4 denominator:5"},
                                    {"1/0 - 2", "whole:2 numerator:0 denominator:1"},
                                    {"1 -- 4", "whole:4 numerator:0 denominator:1"} };
   }
}
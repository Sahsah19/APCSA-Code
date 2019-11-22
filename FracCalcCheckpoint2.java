import java.util.Scanner;
/* Sahil Gupta - AP CS A - 11/15/2019
   Frac Calc - Write a program to act
   as a calculator using everything from
   chapters 1 - 5 */
public class FracCalcCheckpoint2{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String condition = "y";
      String expression = "";
      String output = "";
      System.out.println("Welcome to Sahil's FracCalc!\nType \"quit\" anytime to exit.");
      System.out.print("Enter an expression: ");
      expression = scan.nextLine();

      
      while(!expression.equalsIgnoreCase("quit")){         
         if(expression.equalsIgnoreCase("test")){
            runTests();
         }
         else{
            String[] arrayNumbers= produceAnswer(expression);
            System.out.print("Expression evaluated, ");
         }
         System.out.print("enter another expression: ");
         expression = scan.nextLine();
      }
      System.out.print("Thank you for using Sahil's FracCalc! Have a good day!");
   }
   
   public static String[] produceAnswer(String input){
      String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
      String secondOperand = findSecondOperand(input);
      String firstOperand = findFirstOperand(input);
      
      String[] firstArray = partsOfOperand(firstOperand);
      String[] secondArray = partsOfOperand(secondOperand);
      
      System.out.print("whole:" + secondArray[0] + " ");
      System.out.print("numerator:" + secondArray[1] + " ");
      System.out.println("denominator:" + secondArray[2]); 
      
      return secondArray;
   }
   
   public static String findFirstOperand(String input){
      String firstOperand = input.substring(0, input.indexOf(" ") + 1);
      return firstOperand;
   }
   
   public static String findSecondOperand(String input){
      String secondOperand = input.substring(input.indexOf(" ") + 3, input.length());
      if(secondOperand.substring(0, 1).equals(" ")){
         secondOperand = secondOperand.substring(1, 2);
      }
      return secondOperand;  
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
      String[] inputs = {"10/4 + 3/2", "2 + 11", "1_3/4 * 4_5/6", "1/2 / -4/5", "1/0 - 2", "1 -- 4"};
      String[][] expectedOutput = {{"0", "3", "2"}, {"11", "0", "1"}, {"4", "5", "6"}, {"0", "-4", "5"}, {"2", "0", "1"}, {"4", "0", "1"}};
      int count = 0;
      String output = "";
      String expectOutput = "";
      String[] testArray = new String[3];
      for(int i = 0; i < inputs.length; i++){
         testArray = produceAnswer(inputs[i]);
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
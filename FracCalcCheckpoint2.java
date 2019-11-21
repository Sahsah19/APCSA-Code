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
            String[] arrayNumbers = produceAnswer(expression);
            System.out.println("Whole: " + arrayNumbers[0]);
            System.out.println("Numerator: " + arrayNumbers[1]);
            System.out.println("Denominator: " + arrayNumber[2]);
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
      String whole = operand.substring(0, 1);
      String numerator = "";
      String denominator = "";   
      if(operand.indexOf("_") != -1){
       int locUnderscore = operand.indexOf("_");
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
      String[][] expectedOutput = {"3/2", "11", "4_5/6", "-4/5", "2", "4"};
      for(int i = 0; i < inputs.length; i++){
         String[] testArray = produceAnswer(inputs[i]);
         
      }    
   }
}
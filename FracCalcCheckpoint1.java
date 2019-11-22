import java.util.Scanner;
/* Sahil Gupta - AP CS A - 11/15/2019
   Frac Calc - Write a program to act
   as a calculator using everything from
   chapters 1 - 5 */
public class FracCalcCheckpoint1{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String condition = "y";
      String expression = "";
      String output = "";
      System.out.print("Enter an expression: ");
      expression = scan.nextLine();

      if(expression.equalsIgnoreCase("test")){
         runTests();
      }
      else{
         System.out.print(produceAnswer(expression));
      }
   }
   
   public static String produceAnswer(String input){
      String firstOperand = input.substring(0, input.indexOf(" ") + 1);
      String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
      String secondOperand = input.substring(input.indexOf(" ") + 3, input.length());
      
      if(secondOperand.substring(0, 1).equals(" ")){
         secondOperand = secondOperand.substring(1, 2);
      }
      return secondOperand;
   }
   public static void runTests(){
      String[] inputs = {"10/4 + 3/2", "2 + 11", "1_3/4 * 4_5/6", "1/2 / -4/5", "1/0 - 2", "1 -- 4"};
      String[] expectedOutput = {"3/2", "11", "4_5/6", "-4/5", "2", "4"};
      for(int i = 0; i < inputs.length; i++){
         String test = produceAnswer(inputs[i]);
         if(test.equals(expectedOutput[i])){
            System.out.println("Test Passed!");
         }
         else{
            System.out.println("Test Failed :(");
            System.out.println("Input: " + inputs[i]);
            System.out.println("Expected: " + expectedOutput[i]);
            System.out.println("Output: " + test);
         }
      } 
      System.out.print("Testing Complete");    
   }
}
import java.util.Scanner;
/* Sahil Gupta - AP CS A - 11/15/2019
   Frac Calc - Write a program to act
   as a calculator using everything from
   chapters 1 - 5 */
public class FracCalc{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Welcome to Sahil's FracCalc!");
      System.out.print("Enter an expression: ");
      String expression = scan.nextLine();
      
      if(expression.equalsIgnoreCase("test")){
         runTests();
      }
      else{
         String output = produceAnswer(expression);
         System.out.println(output);

      }
      
   }
   public static String produceAnswer(String input){
      String firstOperand = input.substring(0, input.indexOf(" ") + 1);
      String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
      String secondOperand = input.substring(input.indexOf(" ") + 3, input.length());
      
      return secondOperand;
   }
   public static void runTests(){
      System.out.println(produceAnswer("10/4 + 2/2"));
      System.out.println(produceAnswer("7 + 2"));
      System.out.println(produceAnswer("1_3/4 * 2_3/4"));
      System.out.println(produceAnswer("1/2 / -4/5"));
      System.out.println(produceAnswer("1/0 + 2"));
      System.out.println(produceAnswer("1 ++ 3"));
      System.out.print("Testing Complete, Continue using FracCalc? ");
      
   }
}
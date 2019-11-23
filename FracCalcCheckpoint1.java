import java.util.Scanner;
/* Sahil Gupta - AP CS A - 11/15/2019
   Frac Calc - Write a program to act
   as a calculator using everything from
   chapters 1 - 5 */
public class FracCalcCheckpoint1{ //delcare class FracCalcCheckpoint1
   public static void main(String[] args){ //start of main method
      Scanner scan = new Scanner(System.in); //declare Scanner
      System.out.print("Enter an expression: "); //prompt to user to enter an expression
      String expression = scan.nextLine(); //input the expression

      if(expression.equalsIgnoreCase("test")){ //if the expression is equal to "test"
         runTests(); //call method runTests();
      }
      else{ //otherwise
         System.out.print(produceAnswer(expression)); //call produceAnswer and print out the answer
      }
   }
   
   public static String produceAnswer(String input){ //declare method produceAnswer with one parameter
      String firstOperand = input.substring(0, input.indexOf(" ") + 1); //find the first operand
      String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2); //determine the operator
      String secondOperand = input.substring(input.indexOf(" ") + 3, input.length()); //determine the second operand
      
      if(secondOperand.substring(0, 1).equals(" ")){ //if the second operand has a space
         secondOperand = secondOperand.substring(1, secondOperand.length()); //remove the space
      }
      return secondOperand; //return the value of the secondOperand
   }
   public static void runTests(){ //declare method runTests
      String[] inputs = {"10/4 + 3/2", "2 + 11", "1_3/4 * 4_5/6", "1/2 / -4/5", "1/0 - 2", "1 -- 4"}; //array full of inputs
      String[] expectedOutput = {"3/2", "11", "4_5/6", "-4/5", "2", "4"}; //array of the expected output
      for(int i = 0; i < inputs.length; i++){ //run a for loop for the length of the input array
         String test = produceAnswer(inputs[i]); //set a variable for the output of the current value of the input
         if(test.equals(expectedOutput[i])){ //if the output equals the expected
            System.out.println("Test Passed!"); //print out a pass statement
         }
         else{ //otherwise if the output does not equal the expected
            System.out.println("Test Failed :("); //print out error statement
            System.out.println("Input: " + inputs[i]); //print out the input
            System.out.println("Expected: " + expectedOutput[i]); //print out the expected output
            System.out.println("Output: " + test); //print out the actual output
         }
      } 
      System.out.print("Testing Complete"); //print a final statement
   }
}
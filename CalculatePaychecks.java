import java.util.Scanner;
/* Sahil Gupta - 10/11/19 - AP CS A
   Lab 4 - Using scanner with the Math class
      - Write a program to calculate paycheck amounts 
      at different companies using the scanner object,
      static methods, and the Math class. */
public class CalculatePaychecks { //declare class CalculatePaychecks
   public static void main(String[] args) { //main method
      Scanner scan = new Scanner(System.in); //Scanner delcaration
      
      System.out.print("How many hours did the employee work? "); //question for scanner input for hours worked
      int hrsWrkd = scan.nextInt(); //retrieve the number that scanner found and into the variable hrsWrkd
      System.out.print("What is the employee's base salary? "); //question for scanner input for base salary
      double bseSal = scan.nextDouble(); //retrieve the double and set it equal to bseSal
      
      double acmePay = getAcmePay(hrsWrkd, bseSal); //set the value of acmePay to the return value of getAcmePay
      double coyotePay = getCoyotePay(hrsWrkd, bseSal);//set the value of coyotePay to the return value of getCoyotePay
      double roadrunnerPay = getRoadrunnerPay(hrsWrkd, bseSal);//set the value of roadrunnerPay to the return value of getRoadrunnerPay 
      
      String output = "Someone who worked " + hrsWrkd + " hours at base hourly salary of $" + 
         bseSal + " would be paid:"; //set the String output with the variables hrsWrkd and bseSal
      String acmeOut = "\n$" + acmePay + " at Acme Inc";//set the String acmeOut with the variable acmePay
      String coyoteOut = "\n$" + coyotePay + " at Coyote Inc";//set the String coyoteOut with the variable coyotePay
      String roadOut = "\n$" + roadrunnerPay + " at Roadrunner Inc";//set the String roadOut with the variable roadrunnerPay
      
      String fnlOut = output + acmeOut + coyoteOut + roadOut;//add all of the Strings together into one final statement
      
      System.out.println(fnlOut);//print out the final statement
   }
   
   public static double getAcmePay(int hours, double baseSal) {//declare getAcmePay with 2 variables, one int and a double
      double totalSal = 0; //declare totalSal as 0
      for(int i = 1; i <= hours; i++) {//run a for loop to calculate the total paycheck
         totalSal += Math.pow(baseSal, i);//add the power values of baseSal and i to totalSal
      }
      
      return totalSal;//return the double value of totalSal
   }
   
   public static double getCoyotePay(int hours, double baseSal) {//declare getCoyotePay with 2 variables, one int and a double
      double totalSal = 0; //set the value of totalSal to 0 while declaring it
      for(int k = 1; k <= hours; k++) { //run a for loop to calculate the total paycheck
         totalSal += Math.ceil(Math.pow(baseSal, k));//add the value for the power of baseSal to the power of k rounded up to totalSal
      }
      
      return totalSal;//return the double value of totalSal
   }
   
   public static double getRoadrunnerPay(int hours, double baseSal) {//declare getRoadrunnerPay with 2 variables, one int and a double
      double totalSal = 0;//declare and set the value of totalSal to 0
      for(int j = 1; j <= hours; j++) {//run a for loop to calculate the total paycheck
         totalSal += Math.pow(Math.ceil(baseSal), j);//set the value of totalSal, by rounding baseSal and setting it to the power of j
      }
      
      return totalSal;//return the double value of totalSal
   }
}
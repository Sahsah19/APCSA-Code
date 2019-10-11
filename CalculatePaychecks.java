import java.util.Scanner;
/* Sahil Gupta - 10/11/19 - AP CS A
   Lab 4 - Using scanner with the Math class
      - Write a program to calculate paycheck amounts 
      at different companies using the scanner object,
      static methods, and the Math class. */
public class CalculatePaychecks { // declare class CalculatePaychecks
   public static void main(String[] args) { // main method
      Scanner scan = new Scanner(System.in); // Scanner delcaration
      
      System.out.print("How many hours did the employee work? "); // question for scanner input for hours worked
      int hrsWrkd = scan.nextInt(); // retrieve the number that scanner found and into the variable hrsWrkd
      System.out.print("What is the employee's base salary? "); // question for scanner input for base salary
      double bseSal = scan.nextDouble(); // retrieve the double and set it equal to bseSal
      
      double acmePay = getAcmePay(hrsWrkd, bseSal);
      double coyotePay = getCoyotePay(hrsWrkd, bseSal);
      double roadrunnerPay = getRoadrunnerPay(hrsWrkd, bseSal);
      
      String output = "Someone who worked " + hrsWrkd + " hours at base hourly salary of $" + 
         bseSal + " would be paid:";
      String acmeOut = "\n$" + acmePay + " at Acme Inc";
      String coyoteOut = "\n$" + coyotePay + " at Coyote Inc";
      String roadOut = "\n$" + roadrunnerPay + " at Roadrunner Inc";
      
      String fnlOut = output + acmeOut + coyoteOut + roadOut;
      
      System.out.println(fnlOut);   
   }
   
   public static double getAcmePay(int hours, double baseSal) {
      double totalSal = 0;
      for(int i = 1; i <= hours; i++) {
         totalSal += Math.pow(baseSal, i);
      }
      
      return totalSal;
   }
   
   public static double getCoyotePay(int hours, double baseSal) {
      double totalSal = 0;
      for(int k = 1; k <= hours; k++) {
         totalSal += Math.ceil(Math.pow(baseSal, k));
      }
      
      return totalSal;
   }
   
   public static double getRoadrunnerPay(int hours, double baseSal) {
      double totalSal = 0;
      for(int j = 1; j <= hours; j++) {
         totalSal += Math.pow(Math.ceil(baseSal), j);
      }
      
      return totalSal;
   }
}
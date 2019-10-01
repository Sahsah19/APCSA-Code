/* 
   Sahil Gupta - 09/20/19
   Lab 1: Sales Tax
      - determine the sales tax depending on the day for both 
         Tarifftown and Taxville, for an item using for loops,
         static methods, as well operators
                       */   
public class SalesTax{ 
   public static void taxville(int item){ // define static method "taxville" with a parameter called "item"
      for(int day = 1; day <= 31; day++){ // for loop 
         double tax = (day / 100.0); // to find our decimal tax amount we need to divide the day number by a 100.0 for a double result
         double salesTax = tax * item; // sales tax will be determined by multiplying the tax by the price of the item
         double total = salesTax + item; // total will be calculated by our sales tax plus the price of the item
         System.out.println("On January " + day + ", the sales tax is " + day + "%. I will pay $" + salesTax + 
         " in sales tax. I will pay a total of $" + total + ".");
         // print it all out
      }
   }
   
   public static void tarifftown(int item){ //define static method "tarifftown" with a parameter called "item"
      for(int day = 1; day <= 365; day++){ // for loop 
         double tax = (365 - day) / 10.0; // calculate the tax by subtracting 365 from int "day" and divide it by 10.0 to get a double value
         double salesTax = (tax / 100.0) * item; // calculate sales tax by diving tax by 100.0 to get the decimal value and then multiplying it by the price of the item
         double total = salesTax + item; // calculate the sales tax by adding the sales tax and the price of the item
         System.out.println("On day " + day + " of the year, the sales tax is " + tax + "%. I will pay $" + salesTax + 
         " in sales tax. I will pay a total of $" + total + ".");
         // print it all out
      }
   }
   
   public static void main(String[] args){
      int item = 50;    // declare item as 50, as our item is $50
      taxville(item); // run the static method "taxville"
      System.out.println(); //space between 2 methods
      tarifftown(item); // run the static method "tarifftown"
      System.out.println(); // space between print statement and method call
      System.out.println("Tax has been calculated of Taxville and Tarifftown for an item worth $" + item); // print out end statement
   }
}
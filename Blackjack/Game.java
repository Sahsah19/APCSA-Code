import java.util.Scanner;

public class Game{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Welcome to Sahil's Blackjack!");
      
      System.out.print("Enter the Name of the 1st Player: ");
      String firstPlayer = scan.nextLine();
      
      System.out.print("Enter the Name of the 2nd Player: ");
      String secondPlayer = scan.nextLine();
      
      Player first = new Player(firstPlayer);
      Player second = new Player(secondPlayer);
   }
}
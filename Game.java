import java.util.Scanner;

public class Game {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in); // create objects for Scanner and Gamecontrol
      GameControl gc = new GameControl();

      System.out.println("Welcome to Sahil's Blackjack!"); // standard print statements

      System.out.print("Enter the Name of the 1st Player: ");
      String firstPlayer = scan.nextLine();

      System.out.print("Enter the Name of the 2nd Player: ");
      String secondPlayer = scan.nextLine();

      Player first = new Player(firstPlayer); // declaration of objects
      Player second = new Player(secondPlayer);

      String update = "y"; // variables to use in client
      String hitStand = "";
      String openHand = "";
      int gameTurn = 0;
      boolean ifBusted = false;
      gc.getPlayers(first, second); // declare objects in game control
      ifBusted = false;

      while (update.equals("y")) {
         gameTurn = 1;
         gc.startGame();
         openHand = firstPlayer + " shows: " + first.firstCard() + "\n" + secondPlayer + " shows: " + second.firstCard()
               + "\n";

         while (gameTurn % 2 == 1) {
            System.out
                  .println("========================================================================================");
            System.out.println(openHand);
            System.out.println(firstPlayer + ", it is your turn.");
            System.out.println(firstPlayer + ", you have " + first.cards() + " (" + first.getScore() + ")");

            System.out.print("Do you want to [h]it or [s]tand? ");
            hitStand = scan.nextLine();

            while (hitStand.equals("h")) {
               System.out.println("You drew " + gc.getCards(first));
               if (first.getScore() > 21) {
                  System.out.println("Bust!");
                  System.out.println(secondPlayer + " wins!");
                  ifBusted = true;
                  second.updateGame(1);
                  break;
               } else {
                  System.out.println(firstPlayer + ", you have " + first.cards() + " (" + first.getScore() + ")");
                  System.out.print("Do you want to [h]it or [s]tand? ");
                  hitStand = scan.nextLine();
               }
            }
            if(ifBusted == false){
               gameTurn++;
            }else{
               break;
            }
         }

         while (gameTurn % 2 == 0) {
            System.out
                  .println("========================================================================================");
            System.out.println(openHand);
            System.out.println(secondPlayer + ", it is your turn.");
            System.out.println(secondPlayer + ", you have " + second.cards() + " (" + second.getScore() + ")");

            System.out.print("Do you want to [h]it or [s]tand? ");
            hitStand = scan.nextLine();

            while (hitStand.equals("h")) {
               System.out.println("You drew " + gc.getCards(second));
               if (second.getScore() > 21) {
                  System.out.println("Bust!");
                  System.out.println(firstPlayer + " wins!");
                  ifBusted = true;
                  first.updateGame(1);
                  break;
               } else {
                  System.out.println(secondPlayer + ", you have " + second.cards() + " (" + second.getScore() + ")");
                  System.out.print("Do you want to [h]it or [s]tand? ");
                  hitStand = scan.nextLine();
               }
               if(ifBusted == false){
                  gameTurn++;
               }else{
                  break;
               }
            }
         }
         System.out.println("========================================================================================");
         if (ifBusted == false) {
            if (first.getScore() > second.getScore()) {
               System.out.println(firstPlayer + " has won the game!");
               first.updateGame(1);
            } else if (first.getScore() < second.getScore()) {
               System.out.println(secondPlayer + " has won the game!");
               second.updateGame(1);
            } else {
               System.out.println("The game was a tie.");
            }
         }
         System.out.println(firstPlayer + " has " + first.getGameScore() + " wins.");
         System.out.println(secondPlayer + " has " + second.getGameScore() + " wins.");
         first.reset();
         second.reset();
         System.out.print("Play again? (y/n) ");
         update = scan.nextLine();

      }
   }
}

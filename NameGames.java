import java.util.Scanner;
/* Sahil Gupta - 10/18/2019 - AP CS A
   Lab 5 - Name Games - Manipulate a user's name 
   through the usage of the String class, static
   methods, and Scanner                           */
public class NameGames {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      System.out.print("Enter full name: ");
      String first = scan.next();
      String middle = scan.next();
      String last = scan.next();
      
      System.out.print("Enter graduation year: ");
      String year = scan.next();
      
      System.out.print("Enter width of Fun Square: ");
      int width = scan.nextInt(); 
      
      System.out.println(backwardName(first, last, middle));
      System.out.println(getInitials(first, last, middle));
      System.out.println(getId(first, last, year));
   }
   public static String getId(String first, String last, String year) {
      String studentId = last.substring(0, 4) + first.substring(0, 3) + year.substring(2);
      return studentId.toLowerCase();
   }
   public static String getInitials(String first, String last, String middle) {
      String initials = first.substring(0,1) + middle.substring(0,1) + last.substring(0,1);
      return initials.toUpperCase();
   }
   public static String backwardName(String first, String last, String middle) {
      String output = "";
      int lenFir = first.length();
      int lenLast = last.length();
      int lenMid = middle.length();
      for(int j = 1; j <= lenLast; j++) {
         output += last.charAt(last.length() - j);
      }
            
      output += " ";          
      for(int k = 1; k <= lenMid; k++) {
         output += middle.charAt(middle.length() - k);
      }
      
      output += " ";
      for(int i = 1; i <= lenFir; i++){
         output += first.charAt(first.length() - i);
      }

      return output;
   }
}
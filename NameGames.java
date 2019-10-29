import java.util.Scanner;
/* Sahil Gupta - 10/18/2019 - AP CS A
   Lab 5 - Name Games - Manipulate a user's name 
   through the usage of the String class, static
   methods, and Scanner                           */
public class NameGames { //declare class NameGames
   public static void main(String[] args) { //main method
      Scanner scan = new Scanner(System.in); //declare the scanner
      
      System.out.print("Enter full name: "); //first scanner statement
      String first = scan.next(); //scan the first name
      String middle = scan.next(); //scan the middle name
      String last = scan.next(); //scan the last name
      
      System.out.print("Enter graduation year: "); //second print statement for scanner
      String year = scan.next(); //scan the graduation year
      
      System.out.print("Enter width of Fun Square: "); //third print statement for scanner
      int width = scan.nextInt(); //scan the width of the funSquare
      
      String greetings = "Greetings, " + first + ", your initials are " + getInitials(first, last, middle) + "."; //first line of output
      String backward = "Your name backward is \"" + backwardName(first, last, middle) + "\"."; //second line of output
      String studentId = "Your student ID is \"" + getId(first, last, year) + "\"."; //third line of output
      String funSquare = "Your last name \"FunSquare\" of width " + width + " is: \n\n" + funSquare(last, width); //final line of output
      String output = greetings + "\n" + backward + "\n" + studentId + "\n" + funSquare; //add the lines together into one variable
      
      System.out.println(output); //print out the output
   }
   
   public static String funSquare(String last, int width) { //method funSquare which takes a string and integer variable
      if (last.length() < width) { //if statement to determine if width is longer than the last name
         return "Width is too big for Fun Square to compile"; //return the error statement
      }
      else { //otherwise if width is smaller than the last name
         int numOfLn = (last.length() - width) + 1; //determine the number of lines the funSquare is going to be
         String output = ""; //declare output as an empty string
         for(int i = 1; i <= numOfLn; i++) { //run a for loop for the amount of lines
            output += last.substring(i - 1, (last.length() - numOfLn + i)) + "\n"; //add to every line of the fun square
         }
         return output; //return the output
      }
   }
   
   public static String getId(String first, String last, String year) { //declare method getId with 3 string variables
      String studentId = ""; //declare studentId as an empty string
      String lastYear = year.substring(2); //find the last 2 numbers of the graduation year
      if (last.length() < 4) { //determine wether the last name is shorter than 4 letters
         if (first.length() < 3) { //determine wether the first name is shorter than 3 letters
            studentId = last + first + lastYear; //print out the studentID, with no substrings
         }
         studentId = last + first.substring(0, 3) + lastYear; //use substrings for the first name, but not for the last
      }
      else if (first.length() < 3) { //determine whether only the first name is shorter than 3 letters
         studentId = last.substring(0, 4) + first + lastYear; //print out the ID with substrings for the last name
      }
      else { //else statement if both last and first name are over 4 and 3 letters respectively
         studentId = last.substring(0, 4) + first.substring(0, 3) + lastYear; //use substrings to find the ID
      }
      return studentId.toLowerCase(); //return the ID and turn it into lower case letters first
   }
   
   public static String getInitials(String first, String last, String middle) { //declare the method getInitials with 3 string variables
      String initials = first.substring(0,1) + middle.substring(0,1) + last.substring(0,1); //find the first letter of every name 
      return initials.toUpperCase(); //convert each letter to upper case
   }
   
   public static String backwardName(String first, String last, String middle) { //declare a static method with 3 variables
      String output = ""; //declare output as an empty string
      int lenFir = first.length(); //find the length of the first name
      int lenLast = last.length(); //find the length of the last name
      int lenMid = middle.length(); //find the length of the middle name
      for(int j = 1; j <= lenLast; j++) { //run a for loop for the length of the last name
         output += last.charAt(last.length() - j); //add to the output every letter of the last name one by one
      }
            
      output += " "; //add a space to the output      
      for(int k = 1; k <= lenMid; k++) { //run a for loop for the length of the middle name
         output += middle.charAt(middle.length() - k); //add to the output every letter of the middle name
      }
      
      output += " "; //add another space to the output
      for(int i = 1; i <= lenFir; i++) { //run a for loop for the length of the first name
         output += first.charAt(first.length() - i); //add to the output, every letter of the first name
      }

      return output; //return the output
   }
}
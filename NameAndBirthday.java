import java.util.Scanner;
/* Sahil Gupta - AP CS A - 11/4/19
      Lab 6 - Name and Birthday
         Using static methods, the String class, and 
         logical if/else statements to print out
         information depending on a person's name
         and their birthday                      */
public class NameAndBirthday{ //declare class as NameAndBirthday
   public static void main(String[] args){ //main method
      Scanner scan = new Scanner(System.in); //intialize and declare Scanner
      
      System.out.print("Full name: "); //first scanner statement to take first name
      String name = scan.nextLine(); //scan the entire first name
            
      System.out.print("Birthday (month day year): "); //second scanner statement to take the birthdate
      String month = scan.next(); //take the month
      int day = scan.nextInt(); //scan the day born
      int year = scan.nextInt(); //scan the year 
      
      String firstName = findFirst(name); //find the first name by inputting the entire name into the first name method
      int mgcNum = magicNumber(name); //find the magic number by inputting the entire name
      String season = findSeason(month, day); //find the season in which the person was born in, with a month and day
      String letter = favLetter(name); //find the person's "favorite" letter
      boolean lpYr = leapYear(year); //determine whether the year was a leap year
      String animal = favAnimal(year); //determine what animal the person likes the most
      String lpYrCndtn = ""; //declare lpYrCndtn as an empty string
      
      if(lpYr == false){ //if the year is not a leap year...
         lpYrCndtn = "NOT "; //declare lpYrCndtn as "NOT "
      }
      
      String firLine = "Greetings, " + firstName + ", your \"magic number\" is " + mgcNum + ".\n"; //declare the first line of output
      String secLine = "You were born in " + season + ".\n"; //declare the second line of output
      String thirdLine = "Your favorite letter is '" + letter + "'.\n"; //declare the third line of output
      String fourthLine = "Your birth year, " + year + ", was " + lpYrCndtn + "a leap year.\n"; //declare the fourth line of output
      String fifthLine = "Your favorite animal is a " + animal + "."; //declare the fifth line of output
      String output = firLine + secLine + thirdLine + fourthLine + fifthLine; //add all the lines together 
      
      System.out.println(output); //print out the final output         
   }
   public static String findFirst(String name){ //declare method findFirst with one parameter
      return name.substring(0, name.indexOf(" ")); //return the substring of the name, from the first index to the first space
   }
   public static int magicNumber(String name){ //declare method magicNumber with one parameter 
      int count = 0; //declare count as 0
      for(int i = 0; i <= name.length() - 1; i++){ //write a for loop to run for the length of the string length
         if(name.charAt(i) != ' '){ //if the current char is not a space...
            count++; //add 1 to count
         }
      }
      int mgcNum = count; //declare mgcNum as count
      if(mgcNum > 9){ //if mgcNum is greater than 9
         mgcNum = ((mgcNum - (mgcNum % 10)) / 10) + (mgcNum % 10); //add the 2 numbers together
         if(mgcNum > 9){ //if mgcNum is still greater than 9
            mgcNum = ((mgcNum - (mgcNum % 10)) / 10) + (mgcNum % 10); //add the 2 numbers together   
         }
      }
      return mgcNum; //return the magic number
   }
   public static String findSeason(String month, int day){ //declare method findSeason with 2 parameters
      String season = ""; //declare season as an empty string
      String m = month.substring(0, 3).toLowerCase(); //take the first 3 letters of the month
      if((m.equals("dec") && day >= 22) || (m.equals("mar") && day <= 20) || m.equals("jan") || m.equals("feb")){ //if the month is between dec and mar
         season = "Winter"; //set season to Winter
      }
      else if((m.equals("mar") && day >= 21) || (m.equals("jun") && day <= 20) || m.equals("apr") || m.equals("may")){ //if the month is between mar and may
         season = "Spring"; //set season to Spring
      }
      else if((m.equals("jun") && day >= 21) || (m.equals("sep") && day <= 22) || m.equals("jul") || m.equals("aug")){ //if the month is between jun and aug
         season = "Summer"; //set season to Summer
      }
      else{ //else...
         season = "Fall"; //set season to Fall
      }
      return season; //return the value of Season
   }
   public static String favLetter(String name){ //declare method favLetter with one parameter
      int count = 0; //declare int count as 0
      String last = ""; //declare last as an empty string
      String nameWOFirst = name.substring(name.indexOf(" ") + 1, name.length()); //find the name without the first name
      for(int i = 0; i <= name.length() - 1; i ++){ //or loop to verify existence of last and/or middle name
         if(name.charAt(i) == ' '){ //if the current char is equal to a space
            count++; //add to the count
         }   
      }
      if(count == 2){ //if count is equal to 2, meaning that there is a middle name
         last = nameWOFirst.substring(nameWOFirst.indexOf(" ") + 1, nameWOFirst.length()); //find the last name
      }
      else{ //else, no middle name
         last = nameWOFirst; //set the last name to the string delcared earlier
      }
      return last.substring(0, 1).toUpperCase(); //return the string of the first letter
   }
   public static boolean leapYear(int year){ //declare leapYear with one parameter
      boolean ifLeapYear = false; //declare ifLeapYear as false
      if(year % 4 != 0){ //if the year is not divisible by 4
         ifLeapYear = false; //then the year is not a leap year
      }
      else if(year % 100 != 0){ //else if the year is not divisible by 100 
         ifLeapYear = true; //then the year is a leap year
      }S
      else if(year % 400 != 0){ //else if the year is not divisibke by 400 
         ifLeapYear = false; //then the year is not a leap year
      }
      else{ //else...
         ifLeapYear = true; //the year is a leap year
      }
      return ifLeapYear; //return the true or false value
   }
   public static String favAnimal(int year){ //declare method favAnimal with one parameter
      String animal = ""; //declare animal as a empty string
      if(year % 3 == 0 || year % 5 == 0){ //if the year is divisible by 3 or 5
         if(year % 3 == 0 && year % 5 != 0){ //if the year is only divisible by 3
            animal = "raccoon"; //then the favorite animal is a raccoon
         }
         else if(year % 3 != 0 && year % 5 == 0){ //if the year is divisible by 5 but not 3
            animal = "bobcat"; //then the favorite animal is a bobcat
         }
         else{ //if the year is divisible by both
            animal = "cougar"; //then the favorite animal is a cougar
         }   
      }
      else{ //if the year is not divisble by 3 nor 5
         animal = "chipmunk"; //then the favorite animal is a chipmunk
      }
      return animal; //return the animal
   }
}
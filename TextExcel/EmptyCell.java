/*
   Sahil Gupta
   Stutler
   APCSA
   3/16/2020
   
   TextCell Lab - use java and object oriented programming
      to create a spreadsheet in the java terminal */
   
public class EmptyCell implements Cell{ //EmptyCell class initialization
   
   public String abbreviatedCellText(){ //get the abbreviated text, which is empty
      return "         "; //return a empty string
   }
   
   public String fullCellText(){ //get the whole text
      return "         "; //return a empty string
   }
}
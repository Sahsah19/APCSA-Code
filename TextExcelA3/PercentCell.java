/*
   Sahil Gupta
   Stutler
   AP CS A
   5/22/20
   Text Excel - Use object oriented programming
      and other tools to create a virtual spreadsheet
*/


public class PercentCell extends RealCell{ //class header
   
   public PercentCell(String value){ //constructor
      super(value);
   }
   
   public double getDoubleValue(){ //overriden method to return decimal of percentage
      double output = Double.parseDouble(getValue().substring(0, getValue().length() - 1));
      return output / 100.0;
   }
   
   public String abbreviatedCellText(){ //return the correct rounded percent
      int len = 0;
      String output = getValue();
      if(output.contains(".")){
         output = output.substring(0, output.indexOf(".")) + "%";
      }
      len = output.length();
      if(output.length() > 10){
         output = output.substring(0, 9) + "%";
      }else if(output.length() < 10){
         for(int i = 0; i < 10 - len; i++){
            output += " ";
         }
      }
      return output;
   }
   
   public String fullCellText(){ //just return the percent
      return getValue();
   }
}
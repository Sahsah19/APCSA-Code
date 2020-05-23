/*
   Sahil Gupta
   Stutler
   AP CS A
   5/22/20
   Text Excel - Use object oriented programming
      and other tools to create a virtual spreadsheet
*/

 
public class ValueCell extends RealCell{ //class header
   
   public ValueCell(String value){ //constructor going to super
      super(value);
   }
   
   public double getDoubleValue(){ //overriden method
      return Double.parseDouble(getValue());
   }
} 
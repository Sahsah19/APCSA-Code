/*
   Sahil Gupta
   Stutler
   AP CS A
   5/22/20
   Text Excel - Use object oriented programming
      and other tools to create a virtual spreadsheet
*/


public class FormulaCell extends RealCell{ //class header
   
   public FormulaCell(String value){ //constructor
      super(value);
   }
   
   public double getDoubleValue(){ //overriden method returning 0
      return 0.0;
   }
   
   public String abbreviatedCellText(){ //overriden method returning the correct value
      String cellText = fullCellText().substring(2, fullCellText().length() - 2);
      int len = cellText.length();
      if(len > 10){
         cellText = cellText.substring(0, 10);
      }else if(len < 10){
         for(int i = 0; i < 10 - len; i++){
            cellText += " ";
         }
      }
      
      return cellText;
   }
}
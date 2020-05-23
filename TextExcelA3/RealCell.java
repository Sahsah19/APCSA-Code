/*
   Sahil Gupta
   Stutler
   AP CS A
   5/22/20
   Text Excel - Use object oriented programming
      and other tools to create a virtual spreadsheet
*/

public class RealCell implements Cell{ //class header
   
   private String value; //field
   
   public RealCell(String value){ //constructor
      this.value = value;
   }
   
   public double getDoubleValue(){ //getDoubleValue, just returns the double value
      return Double.parseDouble(this.value);
   }
   
   public String abbreviatedCellText(){ //abbreviatedCellText() returning the properly formatted cellText
      //variable declarations
      int len = 0;
      String output = this.value;
      boolean isZero = true;
      
      //remove excess 0
      if(this.value.contains(".")){
         for(int i = this.value.length() - 1; i > this.value.indexOf("."); i--){
            if(this.value.substring(i, i + 1).equals("0") && isZero == true){
               output = this.value.substring(0, i);
            }else if(!this.value.substring(i, i + 1).equals("0")){
               isZero = false;
            }
         } 
         
         if(output.substring(output.length() - 1, output.length()).equals(".")){
            output += "0";
         }
      }
      
      //String cut
      if(output.length() > 10){
         if(!this.value.contains(".")){
            output = output.substring(0, 8) + ".0";
         }else{
            output = output.substring(0, 10);
         }
      }else{
      
         if(!this.value.contains(".")){
            output += ".0";
         }
         len = output.length();
         for(int i = 0; i < 10 - len; i++){
            output += " ";
         }
      } 
      
      
      return output;
   }
   
   public String fullCellText(){ //just return the text
      String output = null;
      if(!this.value.contains(".")){ //add decimal point
         output = this.value + ".0";
      }else{
         output = this.value;
      }
      return output;
   }
   
   public String getValue(){ //extra method to add accessibility.
      return this.value;
   }
}
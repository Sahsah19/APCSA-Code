/*
   Sahil Gupta
   Stutler
   AP CS A
   5/22/20
   Text Excel - Use object oriented programming
      and other tools to create a virtual spreadsheet
*/
 
public class Spreadsheet implements Grid { //class header
   private Cell[][] cells; //array of cells
 
   public Spreadsheet() { //constructor
      this.cells = new Cell[getRows()][getCols()]; //define length of array
 
      //create a array of empty cells
      for (int r = 0; r < getRows(); r++) {
         for (int c = 0; c < getCols(); c++) {
            EmptyCell e = new EmptyCell();
            cells[r][c] = e;
         }
      }
   }
 
   @Override
   public String processCommand(String command) { //process command method
 
      //variable declarations
      String output = null;
      int len = 5;
 
      //start of logic block
      if(command.equals("")){ //if nothing is parsed
         output = "";
 
      }else if(command.equalsIgnoreCase("clear")){ //command to clear entire grid
         clearGrid();
         output = getGridText(); 
 
      }else if(command.length() == 2 || command.length() == 3){ //command is only length 2 or 3, calling for cell return
         SpreadsheetLocation sl = new SpreadsheetLocation(command);
         output = getCell(sl).fullCellText();
 
      }else if(command.contains(" ")){ //if the string parsed has a space
 
         String[] tokens = command.split(" "); //split the parsed string into a array
 
         if(tokens.length == 2){ //if the length of the array is 2
            SpreadsheetLocation sl = new SpreadsheetLocation(tokens[1]); //new object of SpreadsheetLocation using the 1st index of th array
            clearCell(sl);
            output = getGridText();
 
         }else if(tokens[0].length() == 2 || tokens[0].length() == 3 && tokens[1].equals("=")){ //if the command is setting a cell to a value
            SpreadsheetLocation sl = new SpreadsheetLocation(tokens[0]);
            
            if(tokens[0].length() == 3){ //if the loc is a 2 digit num
               len++;
            }
            
            //logic loop to find out which type of cell
            if(command.contains("\"")){
               setCell(sl, command.substring(len, command.length()), "tc");
            }else if(command.contains("%")){
               setCell(sl, command.substring(len, command.length()), "pc");
            }else if(command.contains("(")){
               setCell(sl, command.substring(len, command.length()), "fc");
            }else{
               setCell(sl, command.substring(len, command.length()), "vc");
            }
            
             
            output = getGridText(); // return the grid
         }
      }
 
      return output; //return the output
   }
 
   public void clearGrid(){ //clearGrid method
      //for loops to set the entire spreadsheet to a empty grid
      for(int p = 0; p < getRows(); p++){
         for(int h = 0; h < getCols(); h++){
            this.cells[p][h] = new EmptyCell();
         }
      }
   }
 
   public void setCell(Location loc, String cellText, String typeOf){ //setcell method
      if(typeOf.equals("tc")){
         this.cells[loc.getRow()][loc.getCol()] = new TextCell(cellText); //set the desired cell to the text.
      }else if(typeOf.equals("pc")){
         this.cells[loc.getRow()][loc.getCol()] = new PercentCell(cellText); //desired percent
      }else if(typeOf.equals("fc")){
         this.cells[loc.getRow()][loc.getCol()] = new FormulaCell(cellText); //desired formula
      }else if(typeOf.equals("vc")){
         this.cells[loc.getRow()][loc.getCol()] = new ValueCell(cellText); //desired value
      }
   }
 
   public void clearCell(Location loc){ //clear cell
      this.cells[loc.getRow()][loc.getCol()] = new EmptyCell(); //clear the cell given
   }
 
   @Override
   public int getRows() {
      // TODO Auto-generated method stub
      return 20;
   }
 
   @Override
   public int getCols() {
      // TODO Auto-generated method stub
      return 12;
   }
 
   @Override
   public Cell getCell(Location loc) { //getcell method
      return this.cells[loc.getRow()][loc.getCol()]; //return the certain cell     
   }
 
   @Override
   public String getGridText() { //getgridtext method
      //variable declaration
      String grid = "   ";
      char colLetter = 'A';
      String currCell = "";
 
      //for loop to get the column header
      for(int i = 0; i < getCols(); i++){
         grid += ("|" + colLetter + "         ");
         colLetter++;
      }
 
       grid += "|\n"; //ski[ a line to first row
 
       //for loop to print grid, and row numbers accordingly
       for(int k = 0; k < getRows(); k++){
          if(k < 9){
             grid += (k + 1) + "  ";
          }else{
             grid += (k + 1) + " ";
          }
          for(int s = 0; s < getCols(); s++){
             currCell = this.cells[k][s].abbreviatedCellText();
             grid += "|" + currCell;
             for(int o = 0; o < 10 - currCell.length(); o++){
                grid += " ";
             }
          }
          grid += "|\n";
       }
      return grid; //return the grid
   }
}
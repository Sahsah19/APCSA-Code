// Sahil Gupta, 09/10/2019, Demonstrating Static Methods
public class Squares{
   public static void main(String[] args){
      drawSquare(); // Call for static method 'drawSquare'
      drawSquare();
      drawTriangle();
      for(int i = 1; i <= 2; i++){
         i--;
         slants();
       //drawSquare();
       //drawTriangle();
      }
   }
   
   public static void drawSquare(){ // When 'drawSquare' is called for, run this method
      System.out.println(" +------+");
      System.out.println(" |      |");
      System.out.println(" |      |");
      System.out.println(" +------+");
   }
   
   public static void drawTriangle(){
      System.out.println("    /\\      ");
      System.out.println("   /  \\     ");
      System.out.println("  /    \\    ");
      System.out.println(" /      \\   ");
      System.out.println("/________\\  ");
   }
   
   public static void slants(){
      System.out.println("\\ *     */");
      System.out.println(" \\ *   */ ");
      System.out.println("  \\ * */  ");
      System.out.println("   \\ */   ");
      System.out.println("    \\/    ");
      System.out.println("    /\\    ");
      System.out.println("   /**\\   ");
      System.out.println("  /*  *\\  ");
      System.out.println(" /*    *\\ ");
      System.out.println("/*      *\\");



   }

}
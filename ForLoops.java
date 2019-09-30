/* 
   Sahil Gupta
   APCSA - 1
   Lab 2: For Loops
    - We will use for loops and static methods to print out certain
      patterns
                                                        */

public class ForLoops{
   public static void main(String[] args){
      int spCnt = 0;
      int lnCnt = 7;
      int pyrCnt = 1;
      int lnSze = 6;
//-----------------------------------------------------------------------------------------------------
      numTri();
      invNumTri();
      starPyr(pyrCnt, lnSze);
      numLay();
      invTri(spCnt, lnCnt);
   }
//-----------------------------------------------------------------------------------------------------
   public static void numTri(){
      for(int i = 1; i <= 5; i++){
         for(int k = 1; k <= i; k++){
            System.out.print(i);
         }
         System.out.println();      
      }
      System.out.println();
   }
//-----------------------------------------------------------------------------------------------------
   public static void invNumTri(){
      for(int j = 1; j <= 5; j++){
         for(int h = 1; h <= 5 - j; h++){
            System.out.print(" ");
         }
         for(int q = 1; q <= j; q++){
            System.out.print(j);
         }
         System.out.println();
      }
      System.out.println();
   }
//-----------------------------------------------------------------------------------------------------   
   public static void starPyr(int pyrCnt, int lnSze){
      for(int f = 1; f <= lnSze; f++){
         
         for(int g = 1; g <= lnSze - f; g++){
            System.out.print("-");
         }
         for(int b = 1; b <= lnCnt; b++){
            System.out.print("*");
         }
         for(int a = 1; a <= lnSze - f; a++){
            System.out.print("-");
         }
         lnCnt += 2;
         System.out.println();
      }
      System.out.println();
   }
//-----------------------------------------------------------------------------------------------------   
   public static void numLay(){
      for(int r = 1; r <= 5; r++){
         for(int e = 1; e <= r; e++){
            System.out.print(r);
         }
            
      }
      System.out.println();  
   }
//-----------------------------------------------------------------------------------------------------   
   public static void invTri(int spCnt, int lnCnt){
      for(int p = 1; p <= 4; p++){
         for(int x = 1; x <= spCnt; x++){
            System.out.print(" ");
         }
         System.out.print("\\");
         for(int c = 1; c <= lnCnt; c++){
            System.out.print(":");
         }
         System.out.println("/");
         spCnt++;
         lnCnt -= 2;
      }
      System.out.println();
   }
//-----------------------------------------------------------------------------------------------------   
}
/* 
   Sahil Gupta
   APCSA - 1
   Lab 2: For Loops
    - We will use for loops and static methods to print out certain
      patterns
                                                        */

public class ForLoops{// class name ForLoops
   public static void main(String[] args){ // main method
//--------------Integer Delcarations--------------------------------------------------------------------------------
      int triSze = 5; //declare int 'triSze' to 5
      int spCnt = 0;  //delcare int 'spCnt' to 0
      int lnCnt = 7;  //declare int 'lnCnt' to 7
      int pyrCnt = 1; //declare int 'lnSze' to 6
      int lnSze = 6;
//--------------Method Calls-----------------------------------------------------------------------------------------
      numTri(triSze);         //call for method 'numTri' and give it triSze as a parameter
      invNumTri(triSze);      //call for method 'invNumTri' and give it triSze as a parameter
      starPyr(pyrCnt, lnSze); //call for method 'starPyr' and give it 'pyrCnt' and 'lnSze as parameters
      numLay(triSze);         //call for method 'numLay' and give it 'triSze" as a parameter
      invTri(spCnt, lnCnt);   //call for method 'invTri' and give it 'spCnt' and 'lnCnt' as parameters
   }
//-------------Method "numTri"----------------------------------------------------------------------------------------          Patterns
   public static void numTri(int triSze){              //declare method 'numTri' with integer parameter of 'triSize'               
      for(int numCnt = 1; numCnt <= triSze; numCnt++){ //run the for loop with 'numCnt' and 'triSze' as boundary                   1
         for(int i = 1; i <= numCnt; i++){             //run another for loop with 'i' and 'numCnt' as boundary                    22 
            System.out.print(numCnt);                  //print out the values of 'numCnt'                                          333
         }                                             //                                                                          4444 
         System.out.println();                         //print out a space after every line to create pattern                      55555   
       }
      System.out.println();                            //print out an extra space after pattern has been completed
   }
//-------------Method "invNumTri"------------------------------------------------------------------------------------
   public static void invNumTri(int triSze){           //declare method 'invNumTri' with one parameter 'triSze'
      for(int invNum = 1; invNum <= triSze; invNum++){ //run the for loop with 'invNum' and 'triSze' as a parameter                
         for(int spaCnt = 1; spaCnt <= triSze - invNum; spaCnt++){//run another loop for spaces to print out                           1
            System.out.print(" ");                                //print out spaces                                                  22 
         }                                                        //                                                                 333
         for(int invCnt = 1; invCnt <= invNum; invCnt++){         //run another loop for the number values                          4444
            System.out.print(invNum);                             //print out the number values                                    55555  
         }
         System.out.println();                                    //print out a space after every line
      }
      System.out.println();                                       //print a space after pattern completed
   }
//-------------Method "starPyr"---------------------------------------------------------------------------------------
   public static void starPyr(int pyrCnt, int lnSze){ //delcare method 'starPyr' with parameters 'pyrCnt' and 'lnSze'
      for(int f = 1; f <= lnSze; f++){                //run a loop for entire pattern  
         for(int g = 1; g <= lnSze - f; g++){         //run another loop for first set of dashes                                  -----*-----
            System.out.print("-");                    //print out the dashes                                                      ----***----
         }                                            //                                                                          ---*****---
         for(int b = 1; b <= pyrCnt; b++){            //run another loop for the stars in the middle                              --*******--
            System.out.print("*");                    //print out the stars                                                       -*********-
         }                                            //                                                                          ***********
         for(int a = 1; a <= lnSze - f; a++){         //run another loop for the last set of dashes
            System.out.print("-");                    //print out the dashes
         }                                            //
         pyrCnt += 2;                                 //add 2 to 'pyrCnt' every time
         System.out.println();                        //add a space after every line
      }                                               //
      System.out.println();                           //add a space after pattern is complete
   }
//-------------Method "numLay"----------------------------------------------------------------------------------------- 
   public static void numLay(int layNum){  //declare method 'numLay' with one parameter 'layNum'
      for(int r = 1; r <= layNum; r++){    //run a for loop with int 'r' and a boundary of 'layNum'                          122333444455555
         for(int e = r; e <= layNum; e++){ //run another for loop with 'e' which equals 'r' and the boundary of 'layNum'     22333444455555
            for(int i = 1; i <= e; i++){   //run a final loop with 'i' and a boundary of 'e'                                 333444455555
               System.out.print(e);        //print out 'e'                                                                   444455555
            }                              //                                                                                55555
         }                                 //
         System.out.println();             //add a space after every line
      }                                    //
      System.out.println();                //add a space after pattern is complete
   }
//------------Method "invTri"-------------------------------------------------------------------------------------------   
   public static void invTri(int spCnt, int lnCnt){ //declare method 'invTri' with 2 parameters 'spCnt' and 'lnCnt'   
      for(int p = 1; p <= 4; p++){                  //run a loop with int 'p' 
         for(int x = 1; x <= spCnt; x++){           //run another loop for spaces with boundary 'spCnt'                        \:::::::/
            System.out.print(" ");                  //print out spaces                                                          \:::::/                                                   
         }                                          //                                                                           \:::/
         System.out.print("\\");                    //print out backslashes '\'                                                   \:/ 
         for(int c = 1; c <= lnCnt; c++){           //run another for loop for colons with a boundary of 'lnCnt'
            System.out.print(":");                  //print out colons
         }                                          //
         System.out.println("/");                   //print out the last forward slash '/' and go to next line
         spCnt++;                                   //add one to 'spCnt' everytime
         lnCnt -= 2;                                //subtract 2 from 'lnCnt'
      }                                             //
      System.out.println();                         //skip a line    
   }
//-----------------------------------------------------------------------------------------------------------------------   
}
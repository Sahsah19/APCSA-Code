public class Random{
   public static final int SIZE = 3; 
   public static void main(String[] args){
      for(int i = 1; i <= 5; i++){
         for(int k = 1; k <= 5 - i; k++){
            System.out.print(" ");   
         }
         for(int j = 1; j <= i; j++){
            System.out.print(i);
         }
         System.out.println();
      }
      
      
      
      /*for(int o = 1; o <= 2; o++){ 
         for(int i = 1; i <= SIZE; i++){
            for(int k = 1; k <= SIZE + 1 - i; k++){
               System.out.print("");
            }      
            System.out.println("123456789abcdefghijklmnopqrstuvwxyz");
         }   
         for(int j = 1; j <= SIZE; j++){
            for(int s = 1; s <= j; s++){
               System.out.print("123456789abcdefghijklmnopqrstuvwxyz");
            }     
            System.out.println("123456789abcdefghijklmnopqrstuvwxyz"); 
         }
         o--;
      }*/
   }   
}
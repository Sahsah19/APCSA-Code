public class Testing{
   public static void main(String[] args){
      for(int i = 1; i <= 5; i = i++){
        for(int k = 1; k <= (6 - i); k++){
            System.out.print("-");
        }
        System.out.println();
      }
   }
}
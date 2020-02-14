public class Card{
   Deck dk = new Deck();
   
   public String[] drawCard(){
      int curValue = 0;
      String[] deck = dk.giveCard();
      int[] reference = dk.giveReference();
      String curCard = "";
      boolean isCardRdy = false;
      
      while(isCardRdy == false){
      curValue = (int)(Math.random() * 51) + 1;
         if(reference[curValue] == 1){
            curCard = deck[curValue];
            dk.updateReference(curValue);
            isCardRdy = true;
         }
      }
      int value = 0;
      switch(curCard.substring(0, 3)){
         case "Ace":
            value = 1;
         case "Two":
            value = 2;
         case "Thr":
            value = 3;
         case "Fou": 
            value = 4;
         case "Fiv":
            value = 5;
         case "Six":
            value = 6;
         case "Sev":
            value = 7;
         case "Eig":
            value = 8;
         case "Nin":
            value = 9;
         case "Ten":
            value = 10;
         case "Jac":
            value = 10;
         case "Que":
            value = 10;
         case "Kin":
            value = 10;
     }
     String[] cardValue = {curCard, value + ""};
     return cardValue;       
   }
}
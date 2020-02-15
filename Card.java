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
            break;
         case "Two":
            value = 2;
            break;
         case "Thr":
            value = 3;
            break;
         case "Fou": 
            value = 4;
            break;
         case "Fiv":
            value = 5;
            break;
         case "Six":
            value = 6;
            break;
         case "Sev":
            value = 7;
            break;
         case "Eig":
            value = 8;
            break;
         case "Nin":
            value = 9;
            break;
         case "Ten":
            value = 10;
            break;
         case "Jac":
            value = 10;
            break;
         case "Que":
            value = 10;
            break;
         case "Kin":
            value = 10;
            break;
     }
     String[] cardValue = {curCard, value + ""};
     return cardValue;       
   }
}
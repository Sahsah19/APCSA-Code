public class Deck{
   private String[] deck;
   private int[] referenceNumber = new int[52];
   
   public Deck(){
      String[] useless = {"Ace of Spades",
                   "Ace of Clubs",
                   "Ace of Hearts",
                   "Ace of Diamonds",
                   "Two of Spades",
                   "Two of Clubs",
                   "Two of Hearts",
                   "Two of Diamonds",
                   "Three of Spades",
                   "Three of Clubs",
                   "Three of Hearts",
                   "Three of Diamonds",
                   "Four of Spades",
                   "Four of Clubs",
                   "Four of Hearts",
                   "Four of Diamonds",
                   "Five of Spades",
                   "Five of Clubs",
                   "Five of Hearts",
                   "Five of Diamonds",
                   "Six of Spades",
                   "Six of Clubs",
                   "Six of Hearts",
                   "Six of Diamonds",
                   "Seven of Spades",
                   "Seven of Clubs",
                   "Seven of Hearts",
                   "Seven of Diamonds",
                   "Eight of Spades",
                   "Eight of Clubs",
                   "Eight of Hearts",
                   "Eight of Diamonds",
                   "Nine of Spades",
                   "Nine of Clubs",
                   "Nine of Hearts",
                   "Nine of Diamonds",
                   "Ten of Spades",
                   "Ten of Clubs",
                   "Ten of Hearts",
                   "Ten of Diamonds",
                   "Jack of Spades",
                   "Jack of Clubs",
                   "Jack of Hearts",
                   "Jack of Diamonds",
                   "Queen of Spades",
                   "Queen of Clubs",
                   "Queen of Hearts",
                   "Queen of Diamonds",
                   "King of Spades",
                   "King of Clubs",
                   "King of Hearts",
                   "King of Diamonds"};  
                   
      this.deck = useless;
      
      for(int i = 0; i < 52; i++){
         this.referenceNumber[i] = 1;
      }
   }
   
   public int[] giveReference(){
      return this.referenceNumber;
   }
   
   public String[] giveCard(){
      return this.deck;
   }
   
   public void updateReference(int index){
      this.referenceNumber[index] = -1;
   }

   public void reset(){
      for(int i = 0; i < 52; i++){
         this.referenceNumber[i] = 1;
      }
   }
}
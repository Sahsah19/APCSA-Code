import java.util.ArrayList;

public class Player{
   private ArrayList<String> playerData = new ArrayList<String>();
   private int currScore;
   private int gameScore;
   GameControl gc = new GameControl();
   Deck dk = new Deck();

   public Player(String name){
      this.currScore = 0;
      this.gameScore = 0;
      playerData.add(name);
      playerData.add(this.gameScore + ""); 
      playerData.add(this.currScore + "");
   }

   public void updateScore(int score){
      this.currScore += score;
      playerData.set(2, this.currScore + "");
   }

   public void updateGame(int gameScore){
      this.gameScore += gameScore;
      playerData.set(1, this.gameScore + "");
   }

   public int getGameScore(){
      return this.gameScore;
   }

   public int getScore(){
      return this.currScore;
   }

   public void addCard(String card){
      playerData.add(card);
   }

   public String cards(){
      String cardList = "[" + playerData.get(3);
      for(int i = 4; i < playerData.size(); i++){
         cardList += ", " + playerData.get(i);
      }
      cardList += "]";
      return cardList;
   }
   
   public String firstCard(){
      return playerData.get(3);
   }

   public void reset(){
      for(int i = 2; i < playerData.size(); i++){
         playerData.remove(i);
      }
      dk.reset();
      this.currScore = 0;
   }
}
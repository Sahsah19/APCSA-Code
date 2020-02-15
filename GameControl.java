public class GameControl{
    Card cd = new Card();
    private Player[] playerList = new Player[2];

    public void getPlayers(Player name1, Player name2){
        playerList[0] = name1;
        playerList[1] = name2;

    }
    public String getCards(Player name){
        String[] cardVal = cd.drawCard();
        name.addCard(cardVal[0]);
        getScore(cardVal[1], name);
        return cardVal[0];
    }
    
    public void startGame(){
        String[] draw1 = cd.drawCard();
        String[] draw2 = cd.drawCard();
        String[] draw3 = cd.drawCard();
        String[] draw4 = cd.drawCard();

        playerList[0].addCard(draw1[0]);
        playerList[0].addCard(draw2[0]);
        playerList[1].addCard(draw3[0]);
        playerList[1].addCard(draw4[0]);

        getScore(draw1[1], playerList[0]);
        getScore(draw2[1], playerList[0]);
        getScore(draw3[1], playerList[1]);
        getScore(draw4[1], playerList[1]);
    }

    public void getScore(String score, Player name){
        name.updateScore(Integer.parseInt(score));
    }
    
}
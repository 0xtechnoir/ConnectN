public class MyConnectFour {
	
	public static void main(String[] args){
		int winStreak = Integer.parseInt(args[0]);
		//TODO Check command line input is between 2 and 7 exclusive.
		GameLogic game = new GameLogic(winStreak);
		game.playGame();
	}
}

public class MyConnectFour {
	
	public static void main(String[] args) {

		if (args.length != 0) {
			try {
				int winStreak = Integer.parseInt(args[0]);

				if (winStreak > 2 && winStreak < 7) {
					GameLogic game = new GameLogic(winStreak);
					game.playGame();
				} else {
					// the user entered a parsable integer but it was outside of the accepted range.
					System.out.println("Please ensure the number entered is between 3 and 6 (inclusive)");
				}

			} catch (NumberFormatException e) {
				// Integer.parseInt found nothing parsable
				System.out.println("Please ensure you provide the correct input type. You should enter an integer between 3 and 6");
			}
		} else {
			// arg[0] is empty
			System.out.println("You did not enter a value for winStreak");
		}
	}
}

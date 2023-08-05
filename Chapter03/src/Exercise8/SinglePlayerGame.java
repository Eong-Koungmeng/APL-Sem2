package Exercise8;

class SinglePlayerGame extends Game
{
	void starting()
	{
		gameState = "start";
		System.out.println("Single player game is starting...");
		playingAgainstComputer();
	}
	
	void playingAgainstComputer()
	{
		System.out.println("Playing against computer");
	}
	
}

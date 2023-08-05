package Exercise8;

class MultiplayerGame extends Game
{
	void starting()
	{
		gameState = "start";
		System.out.println("Multiplayer game is starting...");
		playingAgainstPlayers();
	}
	
	void playingAgainstPlayers()
	{
		System.out.println("Playing against other players");
	}
}

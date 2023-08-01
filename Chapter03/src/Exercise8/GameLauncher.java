package Exercise8;

class GameLauncher
{
	private Game gamePlaying;
	private boolean isStarted;
	
	GameLauncher(Game gamePlaying)
	{
		this.gamePlaying = gamePlaying;
		isStarted = true;
	}
	
	GameLauncher()
	{
		gamePlaying = new Game();
		isStarted = true;
	}
	
	void run()
	{
		while(isStarted)
		{
			
			System.out.print("Press 1 to play single player game or 2 to play multiplayer game: ");
			String inputStr = Exercise8.input.nextLine();
			if(inputStr.compareTo("1")==0)
			{
				changeGame(new SinglePlayerGame());
			}
			else if(inputStr.compareTo("2")==0)
			{
				changeGame(new MultiplayerGame());
			}
			starting();
			System.out.print("Press 0 to exit or else to continue: ");
			if(Exercise8.input.nextLine().compareTo("0")==0)
			{
				stopping();
			}
		}
		
	}
	
	private void changeGame(Game game)
	{
		gamePlaying = game;
	}
	
	private void stopping()
	{
		isStarted = false;
		System.out.println("Game launcher is stopping");
	}
	
	private void starting()
	{
		gamePlaying.starting();
		gamePlaying.gameLoop();
	}
	
	
}

package Exercise8;

class Game
{
	protected String gameState;
	
	Game()
	{
		gameState = "stop";
	}
	
	void starting()
	{
		gameState = "start";
		System.out.println("Game is starting...");
	}
	
	void pausing()
	{
		gameState = "pause";
		System.out.println("Game is pausing");
	}
	
	void stopping()
	{
		gameState = "stop";
		System.out.println("Game is stopping");
	}
	
	void gameLoop()
	{
		while(!gameState.equals("stop"))
		{
			if(gameState.equals("start"))
			{
				System.out.print("Game is running. Press X to stop or Y to pause: ");
				String strInput = Exercise8.input.nextLine();
				if(strInput.equals("X"))
				{
					stopping();
				}
				else if(strInput.equals("Y"))
				{
					pausing();
				}
			}
			else
			{
				System.out.print("Game is pausing. Press X to stop or S to resume: ");
				String strInput = Exercise8.input.nextLine();
				if(strInput.equals("X"))
				{
					stopping();
				}
				else if(strInput.equals("S"))
				{
					starting();
				}
			}
			
		}
	}
	
	
	String getState()
	{
		return gameState;
	}
	
	
}

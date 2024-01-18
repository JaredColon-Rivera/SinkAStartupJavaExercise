import java.util.ArrayList;

public class StartupBust {
	
	GameHelper helper = new GameHelper();
	ArrayList<Startup> startups = new ArrayList<Startup>();
	int numOfGuesses = 0;
	
	public static void main(String[] args) {
		StartupBust game = new StartupBust();
		game.setUpGame();
		game.startPlaying();
	}
	
	public void setUpGame() {
		
		// create 3 start up objects;
		Startup uber = new Startup();
		Startup tesla = new Startup();
		Startup starbucks = new Startup();
		
		uber.name = "uber";
		tesla.name = "tesla";
		starbucks.name = "starbucks";
		
		startups.add(uber);
		startups.add(tesla);
		startups.add(starbucks);
		
		System.out.println("Your goal is to sink three startups");
		System.out.println("uber, tesla, starbucks");
		System.out.println("Try to sink them all in the fewest number of guesses");
		
		for(Startup startup : startups) {
			ArrayList<String> newLocation = helper.placeStartup(3);
			startup.setLocationCells(newLocation);
		}
		
	}
	
	public void startPlaying() {
		
		while(!startups.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a coordinate");
			checkUserGuess(userGuess);
		}
		finishGame();
		
	}
	
	public void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		for(Startup startup : startups) {
			result = startup.checkYourself(userGuess);
			if(result.equals("hit")) {
				break;
			}
			else if(result.equals("kill")) {
				startups.remove(startup);
				break;
			}
		}
		
		System.out.println(result);
		
	}
	
	public void finishGame() {
		System.out.println("GAME OVER");
		if(numOfGuesses < 18) {
			System.out.println("WOW good job! You guessed " + numOfGuesses + " times");
		}
		else {
			System.out.println("WOW that wasn't very good. You guessed " + numOfGuesses + " times");
		}
	}

}

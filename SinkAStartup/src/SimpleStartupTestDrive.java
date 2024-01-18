import java.util.ArrayList;

public class SimpleStartupTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameHelper helper = new GameHelper();

		Startup startup = new Startup();
		ArrayList<String> location = helper.placeStartup(3);
		startup.setLocationCells(location);
		
		String userGuess = "C3";
		
		String result = startup.checkYourself(userGuess);
		String testResult = "failed";

		
		if(result.equals("hit")) {
			testResult = "passed";
		}
		
		System.out.println(testResult);
		
		
	}

}

import java.util.ArrayList;

public class Startup {
	
	private ArrayList<String> locationCells;
	String name;
	
	public void setLocationCells(ArrayList<String> locationCells) {
		this.locationCells = locationCells;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String checkYourself(String input) {
		String result = "miss";
		int index = locationCells.indexOf(input);
		
		if(index >= 0) {
			locationCells.remove(index);
			
			if(locationCells.isEmpty()) {
				result = "kill";
			}
			else {
				result = "hit";
			}
		}
		
		return result;
	}

}

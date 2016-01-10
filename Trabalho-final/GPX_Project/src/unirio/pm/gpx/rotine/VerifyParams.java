package unirio.pm.gpx.rotine;

public class VerifyParams {
	
	static public void verify(String[] args) {
		
		//Verify if the params are null
		if(isNull(args)) {
			System.out.println("No parameters identified. Please, revise your command and try again later.");
			System.exit(0);
		}
		
		//Verify if there are three params
		if(!areThree(args)) {
			System.out.println("For this program it's necessary to have three parameters. Please, revise your command and try again later.");
			System.exit(0);
		}
	}
	
	//Verify if the params are null
	static private boolean isNull(String[] args) {
		if(args == null) {
			return true;
		} else {
			return false;
		}
	}
	
	//Verify if there are three params
	static private boolean areThree(String[] args) {
		if(args == null) {
			return true;
		} else {
			return false;
		}
	}

}

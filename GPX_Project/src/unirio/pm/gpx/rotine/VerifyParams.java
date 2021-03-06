package unirio.pm.gpx.rotine;

public class VerifyParams {

	static public void verify(String[] args) {
		
		//Verify if the parameters are null
		if(paramsAreNull(args)) {
			System.out.println("No parameters identified. Please, review your command and try again later.");
			System.exit(0);
		}
		
		//Verify if there are three parameters
		if(!areThree(args)) {
			System.out.println("For this program it's necessary to have three parameters. Please, review your command and try again later.");
			System.exit(0);
		}
		
		//Verify if file is GPX
		if(!filesAreGPX(args[1], args[2])) {
			System.out.println("For this program it's necessary to have two GPX files. Please, review your command and try again later.");
			System.exit(0);
		}
		
		//Verify if file is not null
		if(!filesNotEmpty(args[1], args[2])) {
			System.out.println("For this program it's necessary to have two GPX files. Please, review your command and try again later.");
			System.exit(0);
		}
	}
	
	//Verify if the parameters are null
	static private boolean paramsAreNull(String[] args) {
		if(args == null) {
			return true;
		} else {
			return false;
		}
	}
	
	//Verify if there are three parameters
	static private boolean areThree(String[] args) {
		if(args.length == 3) {
			return true;
		} else {
			return false;
		}
	}
	
	//Verify if both files are gpx
	static public boolean filesAreGPX(String arg2, String arg3) {
		if(arg2.endsWith(".gpx") && arg3.endsWith(".gpx")) {
			return true;
		} else {
			return false;
		}
	}
	
	//Verify if both files are not empty
	static public boolean filesNotEmpty(String arg2, String arg3) {
		if(arg2.equals(".gpx") && arg3.equals(".gpx")) {
			return false;
		} else {
			return true;
		}
	}

}

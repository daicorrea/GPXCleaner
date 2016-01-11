package unirio.pm.gpx.calc;
import unirio.pm.gpx.model.TrackPoint;

 public class DistanceCalculator {
	
	static public double getDistance(TrackPoint current, TrackPoint previous, TrackPoint next){
		
		//x1 = longitude of previous point
		double x1 = previous.getLongitude(); 
		//y1 = latitude of previous point
		double y1 = previous.getLatitude();
		//x2 = longitude of previous point
		double x2 = current.getLongitude();
		//y1 = latitude of previous point
		double y2 = current.getLatitude(); 
		//x3 = longitude of next point
		double x3 = next.getLongitude(); 
		//y3 = latitude of next point
		double y3 = next.getLatitude(); 
		
		double d = distanceBetweenPoints(x1, y1, x2, y2, x3, y3);
		//Converting from KM to M
		d = d/1000; 
		
		return d;
		
	}

	static public double distanceBetweenPoints(double x1, double y1, double x2, double y2, double x3, double y3){		
		
		System.out.println("ENTRANDOOOOOO");
		System.out.println("x1: " + x1);
		System.out.println("y1: " + y1);
		System.out.println("x2: " + x2);
		System.out.println("y2: " + y2);
		System.out.println("x3: " + x3);
		System.out.println("y3: " + y3);
		
		//Calculating Slope
		double a = calculateSlope(x1, x3, y1, y3);
		
		//Calculating Y-intercept
		double b = calculateYIntercept (a, x3, y3);	
		
		//Calculating Orthogonal parameters
		double orthA = calculateOrthogonalSlope(a);
		double orthB = calculateOrthogonalYIntercept(a, x2, y2);
		double x4 = calculateOrthogonalX(a, orthA, b, orthB);
		double y4 = calculateOrthogonalY(orthA, orthB, x4);
		
		//Calculating distance using haversine
		double d = haversine(x2,y2,x4,y4);
		System.out.println("d : " + d);
		return d;

	}

	static private double calculateSlope(double x1, double x3, double y1, double y3){
		
		double a = (y1 - y3)/(x1 - x3);
		return a;
		
	}
	
	static private double calculateYIntercept(double a, double x3, double y3){
		
		double b = y3 - (a * x3);
		return b;
	}
	
	//Orthogonal Parameters
	static private double calculateOrthogonalSlope(double a){
		
		double orthA = -1/a;
		return orthA;
		
	}
	
	static private double calculateOrthogonalYIntercept(double a, double x2, double y2){
		
		double orthB = y2 - (a * x2);
		return orthB;
		
	}
	
	static private double calculateOrthogonalX(double a, double orthA, double b, double orthB){
		
		double x4 = (orthB - b)/(a - orthA);
		return x4;
	
	}
	
	static private double calculateOrthogonalY(double orthA, double orthB, double x4){
		
		double y4 = (orthA * x4) + orthB;
		return y4;
		
	}
	
	//Calculating distance between coordinates
    static public double haversine(double y1, double x1, double y3, double x3) {
    	
		 double R = 6372.8f; 
		 double dLat =  Math.toRadians(y3 - y1);
		 double dLon =  Math.toRadians(x3 - x1);
		 y1 =  Math.toRadians(y1);
		 y3 =  Math.toRadians(y3);
		 double a =  (Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(y1) * Math.cos(y3));
		 double c =  (2 * Math.asin(Math.sqrt(a)));
		 return R * c;
		 
	}
		
}
	
	
	
	

	
	
	


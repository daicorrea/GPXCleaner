package unirio.pm.gpx.calc;
import unirio.pm.gpx.model.TrackPoint;

public class DistanceCalculator {
	
	public double getDistance(TrackPoint current, TrackPoint previous, TrackPoint next){
		//if primeiro ou ultimo n fazer isso
		//TrackPoint previous = current.indexOf()
		//TrackPoint next = current.getNext();
		/*
		System.out.println("previous d: ");
		System.out.println(previous);
		System.out.println("next d: ");
		System.out.println(next);
		System.out.println("current d:"+ current);
		*/
		double x1 = previous.getLongitude(); //x1 = longitude of previous point
		double y1 = previous.getLatitude(); //y1 = latitude of previous point
		double x2 = current.getLongitude(); //x1 = longitude of previous point
		double y2 = current.getLatitude(); //y1 = latitude of previous point
		double x3 = next.getLongitude(); //x3 = longitude of next point
		double y3 = next.getLatitude(); //y3 = latitude of next point
		
		/*
		System.out.println("x1 d: " + x1);
		System.out.println("x2 d: " + x2);
		System.out.println("x3 d: " + x3);
		System.out.println("y1 d: " + y1);
		System.out.println("y2 d: " + y2);
		System.out.println("y3 d: " + y3);
		*/
		double d = distanceBetweenTwoPoints(x1, y1, x2, y2, x3, y3);
		d = d/1000; //Convert from KM to M
		//System.out.println("d: " + d);
		
		return d;
		
	}

	public double distanceBetweenTwoPoints(double x1, double y1, double x2, double y2, double x3, double y3){		
		
		// Calculating Slope
		double a = calculateSlope(x1, x3, y1, y3);
		// Calculating Y-intercept
		double b = calculateYIntercept (a, x3, y3);	
		//Calculating Orthogonal parameters
		double orthA = calculateOrthogonalSlope(a);
		double orthB = calculateOrthogonalYIntercept(a, x2, y2);
		double x4 = calculateOrthogonalX(a, orthA, b, orthB);
		double y4 = calculateOrthogonalY(orthA, orthB, x4);
		//Calculating distance
		
		double d = haversine(x2,y2,x4,y4);
		return d;

	}

	private double calculateSlope(double x1, double x3, double y1, double y3){
		
		double a = (y1 - y3)/(x1 - x3);
		//System.out.println("(y1 - y3): " + (y1 - y3));
		//System.out.println("(x1 - x3): " + (x1 - x3));
		//System.out.println("a: " + a);
		return a;
		
	}
	
	private double calculateYIntercept(double a, double x3, double y3){
		
		double b = y3 - (a * x3);
		//System.out.println("b: " + b);
		return b;
	}
	
	//Orthogonal Parameters
	private double calculateOrthogonalSlope(double a){
		
		double orthA = -1/a;
		return orthA;
		
	}
	
	private double calculateOrthogonalYIntercept(double a, double x2, double y2){
		
		double orthB = y2 - (a * x2);
		return orthB;
	}
	
	private double calculateOrthogonalX(double a, double orthA, double b, double orthB){
		
		double x4 = (orthB - b)/(a - orthA);
		return x4;
	}
	
	private double calculateOrthogonalY(double orthA, double orthB, double x4){
		
		double y4 = (orthA * x4) + orthB;
		return y4;
		
	}
	
	//Calculating distance between coordinates
    private double haversine(double y1, double x1, double y3, double x3) {
    	
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
	
	
	
	

	
	
	


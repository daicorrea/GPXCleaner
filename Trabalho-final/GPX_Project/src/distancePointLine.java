

public class distancePointLine {

	
	public Double calculateDistance (Trackpoint current, Trackpoint previous, Trackpoint next){
		
		Double y, a, c, x, b; // a = slope   b = y-intercept  (y = ax + b) equation of a line
		
		
		//x = longitude
		//y = latitude
		
		//determines the slope - if its gonna be a growing (+) or decreasing (-) line
		//Formula: a = (y2 - y1)/(x2 - x1)
		
		a = (previous.getLatitude() - next.getLatitude()) / (previous.getLongitude() - next.getLongitude());
		
		//determines the y-intercept of the line
		//Formula: b = y - ax 
		
		b = (next.getLatitude()) - (a * next.getLongitude());
		
		//Calculating x
		x = (c - b) / (2 * a);
		
		//Finally, calculating y
		y = a*x + b;
		
	}
	
}

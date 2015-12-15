
public class DistanceCalculator {
	
	public float getDistance(TrackPoint current){
		
		TrackPoint previous = current.getPrevious();
		TrackPoint next = current.getNext();
		
		
		float x1 = previous.getLongitude(); //x1 = longitude of previous point
		float y1 = previous.getLatitude(); //y1 = latitude of previous point
		float x2 = current.getLongitude(); //x1 = longitude of previous point
		float y2 = current.getLatitude(); //y1 = latitude of previous point
		float x3 = next.getLongitude(); //x3 = longitude of next point
		float y3 = next.getLatitude(); //y3 = latitude of next point
		
		float d = distanceBetweenTwoPoints(x1, y1, x2, y2, x3, y3);
		
		return d;
		
	}

	public float distanceBetweenTwoPoints(float x1, float y1, float x2, float y2, float x3, float y3){		
		
		// Calculating Slope
		float a = calculateSlope(x1, x3, y1, y3);
		// Calculating Y-intercept
		float b = calculateYIntercept (a, x3, y3);	
		//Calculating Orthogonal parameters
		float orthA = calculateOrthogonalSlope(a);
		float orthB = calculateOrthogonalYIntercept(a, x2, y2);
		float x4 = calculateOrthogonalX(a, orthA, b, orthB);
		float y4 = calculateOrthogonalY(orthA, orthB, x4);
		//Calculating distance
		
		float d = haversine(x2,y2,x4,y4);
		return d;

	}

	private float calculateSlope(float x1, float x3, float y1, float y3){
		
		float a = (y1 - y3)/(x1 - x3);
		return a;
		
	}
	
	private float calculateYIntercept(float a, float x3, float y3){
		
		float b = y3 - (a * x3);
		return b;
	}
	
	//Orthogonal Parameters
	
	private float calculateOrthogonalSlope(float a){
		
		float orthA = -1/a;
		return orthA;
		
	}
	
	private float calculateOrthogonalYIntercept(float a, float x2, float y2){
		
		float orthB = y2 - (a * x2);
		return orthB;
	}
	
	private float calculateOrthogonalX(float a, float orthA, float b, float orthB){
		
		float x4 = (orthB - b)/(a - orthA);
		return x4;
	}
	
	private float calculateOrthogonalY(float orthA, float orthB, float x4){
		
		float y4 = (orthA * x4) + orthB;
		return y4;
		
	}
	
	//Calculating distance between coordinates
		
    private float haversine(float y1, float x1, float y3, float x3) {
		        
		 float R = 6372.8f; 
		 float dLat = (float) Math.toRadians(y3 - y1);
		 float dLon = (float) Math.toRadians(x3 - x1);
		 y1 = (float) Math.toRadians(y1);
		 y3 = (float) Math.toRadians(y3);
		 float a = (float) (Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(y1) * Math.cos(y3));
		 float c = (float) (2 * Math.asin(Math.sqrt(a)));
		 return R * c;
	}
		
}
	
	
	
	

	
	
	


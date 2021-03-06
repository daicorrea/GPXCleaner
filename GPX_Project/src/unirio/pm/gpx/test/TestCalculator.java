package unirio.pm.gpx.test;

import static org.junit.Assert.*;

import org.junit.Test;

import unirio.pm.gpx.calc.DistanceCalculator;

public class TestCalculator {

	@Test
	//Testing the haversine function
	public void testHaversine() {
		
		//Calculating distance between coordinates
		//According to http://rosettacode.org/wiki/Haversine_formula#Java
		double h = DistanceCalculator.haversine(36.12, -86.67, 33.94, -118.40);
		double hResult = 2887.2599506071106;
		
		//Testing with the delta as 1
        assertEquals(h, hResult, 1); 
		
	}

	@Test
	//Testing Slope Function
	public void testCalculateSlope() {
		
		double result = DistanceCalculator.calculateSlope(6, 10, 4, 2);
		double expectedResult = 0.25;
		
		//Testing with the delta as 0.5
        assertEquals(result, expectedResult, 0.5); 
		
	}
	
	@Test
	//Testing YIntercept function
	public void testCalculateYIntercept() {
		
		double result = DistanceCalculator.calculateYIntercept(2, 3, 10);
		double expectedResult = 4.0;
			
		//Testing with the delta as 0.5
	    assertEquals(result, expectedResult, 0.5); 
			
	}
	
	@Test
	//Testing Orthogonal Slope
	public void testCalculateOrthogonalSlope() {
		
		double result = DistanceCalculator.calculateOrthogonalSlope(2);
		double expectedResult = -1/2;
			
		//Testing with the delta as 0.5
	    assertEquals(result, expectedResult, 0.5); 
			
	}
}

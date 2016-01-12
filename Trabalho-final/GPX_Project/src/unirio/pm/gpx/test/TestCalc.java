package unirio.pm.gpx.test;

import static org.junit.Assert.*;

import org.junit.Test;

import unirio.pm.gpx.calc.DistanceCalculator;

public class TestCalc {

	@Test
	public void testHaversine() {
		
		//Calculating distance between coordinates
		//According to http://rosettacode.org/wiki/Haversine_formula#Java
		double h = DistanceCalculator.haversine(36.12, -86.67, 33.94, -118.40);
		double hResult = 2887.2599506071106;
		System.out.println("HAQUI: "+h);
		System.out.println("hResult: "+hResult);
		
		//Testing with the delta as 1
        assertEquals(h, hResult, 1); 
		
	}
	
	/*@Test
	public void TestDistance() {
		
		//Calculating distance between coordinates
		double h = DistanceCalculator.distanceBetweenPoints(2, 4, 6, 8, 10, 12);
		System.out.println("HAQUIM: "+h);
		double hResult = 2887.2599506071106;
		
		//Testing with the delta as 1
        assertEquals(h, hResult, 1.0); 
		
	}*/
	
	@Test
	//Test Slope
	public void testCalculateSlope() {
		
		double result = DistanceCalculator.calculateSlope(6, 10, 4, 2);
		double expectedResult = 4.0;
		
		//Testing with the delta as 0.5
        assertEquals(result, expectedResult, 0.5); 
		
	}
	
	@Test
	//Test Intercept
	public void testCalculateYIntercept() {
		
		double result = DistanceCalculator.calculateYIntercept(2, 3, 10);
		System.out.println("result: "+result);
		double expectedResult = 4.0;
			
		//Testing with the delta as 0.5
	    assertEquals(result, expectedResult, 0.5); 
			
	}
	
	@Test
	//Test Orthogonal Slope
	public void testCalculateOrthogonalSlope() {
		
		double result = DistanceCalculator.calculateOrthogonalSlope(2);
		System.out.println("result: "+result);
		double expectedResult = 1/2;
			
		//Testing with the delta as 0.5
	    assertEquals(result, expectedResult, 0.5); 
			
	}
	
	
	
	
	

}

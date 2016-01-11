package unirio.pm.gpx.calc;
 
import java.util.ArrayList;

import unirio.pm.gpx.calc.DistanceCalculator;
import unirio.pm.gpx.model.TrackPoint;

public class TrackPointReducer {
	
	static public ArrayList<TrackPoint> reducePointsByDistance(ArrayList<TrackPoint> trackPointList, Double distance) {
		
		//Creating objects
		TrackPoint previous = null;
		TrackPoint next = null;
		ArrayList<TrackPoint> newTrackPointList = new ArrayList<TrackPoint>();
		double d = 0;
		int i = 0;
		int trackPointListSize = trackPointList.size();
		
		//Verifying if the list is empty
		if(emptyList(trackPointList)){
			System.out.println("There was an error while reading the file. Please verify it and try again later.");
			System.exit(0);
		}
		
		//Verifying if there's more than two TrackPoints
		if(onlyTwoTrackPoints(trackPointList)){
			System.out.println("Your list has only two values, the file will not be changed.");
			System.exit(0);
		}
		
		//Creating Loop for TrackPoint List
		for (TrackPoint trackPoint : trackPointList) {
								
			//For the calc, the TrackPoint can't be the first or the last on the list
			if((i!=0)&&(i!=trackPointListSize-1)) {
					
				//Get the previous and the next TrackPoint
				previous = trackPointList.get(i-1);
				next = trackPointList.get(i+1);
					
				//Calculating the distance from the TrackPoints
				d = DistanceCalculator.getDistance(trackPoint, previous, next);
				//System.out.println("d retornado: " + d);
				//System.out.println((d > meters));
					
				//Verifying if the calculated distance is bigger than the desired one
				if(d > distance) {
					System.out.println("adicionou um!!");
						
					//Adding to the new TrackPoint list
					newTrackPointList.add(trackPoint);
				}
					
			}
			i++;	
		}
		
		return newTrackPointList;
		
	}
	
static public ArrayList<TrackPoint> reducePointsByPercentage(ArrayList<TrackPoint> trackPointList, int percentage) {
		
		System.out.println("entrou em reducePointsByPercentage");
		
		//Counter to know how many TrackPoints were already removed
		int trackPointCount = 0;
		
		//Quantity of TrackPoints from percentage to remove
		int trackPointsToRemove = ((trackPointList.size() * percentage)/100);
		System.out.println("trackPointsToRemove: " + trackPointsToRemove);
		
		//Index of the TrackPoint to remove from the list
		int trackPointToRemove;
		
		//New list to return
		//ArrayList<TrackPoint> newTrackPointList = new ArrayList<TrackPoint>();
		
		//Loop to last until the percentage is achieved
		while(trackPointsToRemove > trackPointCount) {
			
			//Get the smallest TrackPoint
			trackPointToRemove = smallestTrackPoint(trackPointList);
			
			//Remove it from the list
			trackPointList.remove(trackPointToRemove);
			
			trackPointCount++;
		}
		
		return trackPointList;
		
	}

	//Verify the TrackPoint with the smallest distance
	static private int smallestTrackPoint(ArrayList<TrackPoint> trackPointList) {
		
		//Object to identify smallest distance
		double smallestDistance = 1000000;
		
		//Index to return
		int indexSmallest = 0;
		
		//Creating objects
		TrackPoint previous = null;
		TrackPoint next = null;
		double d = 0;
		int i = 0;
		int trackPointListSize = trackPointList.size();
		System.out.println("tamanho da lista : " + trackPointListSize);
		
		//Verifying if the list is empty
		if(emptyList(trackPointList)){
			System.out.println("There was an error while reading the file. Please verify it and try again later.");
			System.exit(0);
		}
				
		//Creating Loop for TrackPoint List
		for (TrackPoint trackPoint : trackPointList) {
			//System.out.println("tamanho : " + i);
						
			//For the calc, the TrackPoint can't be the first or the last on the list
			if((i!=0)&&(i!=trackPointListSize-1)) {
					
				//Get the previous and the next TrackPoint
				previous = trackPointList.get(i-1);
				next = trackPointList.get(i+1);
					
				//Calculating the distance from the TrackPoints
				d = DistanceCalculator.getDistance(trackPoint, previous, next);
				//System.out.println("d retornado: " + d);
				//System.out.println((d > meters));
				
				//Verifying if the calculated distance is bigger than the desired one
				if(d < smallestDistance) {
					//System.out.println("removeu um!!");
					indexSmallest = i;
				}
			}
			i++;	
		}
		return indexSmallest;
	}
	
	//Verify if there's at least one TrackPoint in the list.
	static public boolean emptyList(ArrayList<TrackPoint> trackPointList) {
		
		if (trackPointList.size() > 0){
			return false;
		} else {
			return true;
		}
		
	}
	
	//Verify if the list has only two TrackPoints. As it's not possible to take the
	//first and the last TrackPoints, the output will be the same as the input.
	static private boolean onlyTwoTrackPoints(ArrayList<TrackPoint> trackPointList) {
		
		if (trackPointList.size() > 2){
			return false;
		} else {
			return true;
		}
		
	}
		
}
	

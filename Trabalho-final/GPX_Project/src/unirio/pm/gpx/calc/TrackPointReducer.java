package unirio.pm.gpx.calc;
 
import java.util.ArrayList;
import unirio.pm.gpx.calc.DistanceCalculator;
import unirio.pm.gpx.model.TrackPoint;

public class TrackPointReducer {
	
	static public ArrayList<TrackPoint> reducePointsByDistance(ArrayList<TrackPoint> trackPointList, Double distance) {
		
		System.out.println("entrou em reducePointsByDistance");
		
		//Creating objects
		TrackPoint previous = null;
		TrackPoint next = null;
		ArrayList<TrackPoint> newTrackPointList = new ArrayList<TrackPoint>();
		double d = 0;
		int i = 0;
		int ni = 0;
		int TrackPointListSize = trackPointList.size();
		System.out.println("tamanho da lista : " + TrackPointListSize);
		
		//Creating Loop for TrackPoint List
		for (TrackPoint trackPoint : trackPointList) {
			System.out.println("tamanho : " + i);
			
			//Verifying if the list is empty
			if(!emptyList(trackPointList)) {
								
				//For the calc, the TrackPoint can't be the first or the last on the list
				if((i!=0)&&(i!=TrackPointListSize-1)) {
					
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
						ni++;
					}
					
				}
				i++;	
			}
		}
		
		System.out.println("ni : " + ni);
		return newTrackPointList;
		
	}
	
static public ArrayList<TrackPoint> reducePointsByPercentage(ArrayList<TrackPoint> trackPointList, int percentage) {
		
		System.out.println("entrou em reducePointsByPercentage");
		
		//Total from percentage to remove
		int totalTrackPointsToRemove = (trackPointList.size() * percentage)/100;
		
		//Creating objects
		TrackPoint previous = null;
		TrackPoint next = null;
		ArrayList<TrackPoint> newTrackPointList = new ArrayList<TrackPoint>();
		double d = 0;
		int i = 0;
		int ni = 0;
		int TrackPointListSize = trackPointList.size();
		System.out.println("tamanho da lista : " + TrackPointListSize);
		
		//Creating Loop for TrackPoint List
		for (TrackPoint trackPoint : trackPointList) {
			System.out.println("tamanho : " + i);
			
			//Verifying if the list is empty
			if(!emptyList(trackPointList)) {
								
				//For the calc, the TrackPoint can't be the first or the last on the list
				if((i!=0)&&(i!=TrackPointListSize-1)) {
					
					//Get the previous and the next TrackPoint
					previous = trackPointList.get(i-1);
					next = trackPointList.get(i+1);
					
					//Calculating the distance from the TrackPoints
					d = DistanceCalculator.getDistance(trackPoint, previous, next);
					//System.out.println("d retornado: " + d);
					//System.out.println((d > meters));
					
					//Verifying if the calculated distance is bigger than the desired one
					if(d > percentage) {
						System.out.println("adicionou um!!");
						
						//Adding to the new TrackPoint list
						newTrackPointList.add(trackPoint);
						ni++;
					}
					
				}
				i++;	
			}
		}
		
		System.out.println("ni : " + ni);
		return newTrackPointList;
		
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
	static public boolean onlyTwoTrackPoints(ArrayList<TrackPoint> trackPointList) {
		
		if (trackPointList.size() > 2){
			return false;
		} else {
			return true;
		}
		
	}
	
	
	/*
	 static public ArrayList<TrackPoint> reducePointsByMeters(ArrayList<TrackPoint> trackPointList, Double meters){
		System.out.println("entrou em reducePointsByMeters");
		double d = 0;
		TrackPoint previous = null;
		TrackPoint next = null;
		/*for (Track track : trackList) {
			System.out.println("entrou: track");
			ArrayList<TrackSegment> trackSegmentList = track.getSegments();
			for (TrackSegment trackSegment : trackSegmentList) {
				System.out.println("tamanho"+trackSegmentList.size());
				System.out.println("entrou: segment");
				ArrayList<TrackPoint> trackPointList = trackSegment.getTrackPoints();
				//////////FECHAR AQUI *  /
				int i = 1;
				for (TrackPoint trackPoint : trackPointList) {
					int tamanho = trackPointList.size();
					System.out.println("tamanho : " + tamanho);
					//it can't be the first or the last trackpoint from the list
					if(trackPointList.size() > 2) {
						while(i < (trackPointList.size()-1)) {
							//System.out.println("entrou: trackpoint");
							//if((i!=0)||(i!=trackPointList.size()-1)) {
								//previous = trackSegment.getTrackPoints().get(i-1);
							previous = trackPointList.get(i-1);
								//System.out.println("previous: ");
								//System.out.println(previous);
								//next = trackSegment.getTrackPoints().get(i+1);
							next = trackPointList.get(i+1);
								//System.out.println("next: ");
								//System.out.println(next);
								//System.out.println("current:"+ trackPoint);
								d = DistanceCalculator.getDistance(trackPoint, previous, next);
								System.out.println("d retornado: " + d);
								//System.out.println("metros: " + meters);
								System.out.println((d < meters));
								if(d < meters) {
									//remove the trackpoint from the list
									//System.out.println("removeu um!!");
									trackPointList.remove(trackPoint);
								}
							//}
							i++;
							//System.out.println(i);
						}
					}
				//}
				
			//}
			
		}
		return trackPointList;
	}
	
	 */
	
	
		
		
}
	

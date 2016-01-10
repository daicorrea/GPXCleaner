package unirio.pm.gpx.calc;
 
import java.util.ArrayList;
import unirio.pm.gpx.calc.DistanceCalculator;
import unirio.pm.gpx.model.TrackPoint;

public class TrackpointsReducer {
	
	static public ArrayList<TrackPoint> reducePointsByMeters(ArrayList<TrackPoint> trackPointList, Double meters) {
		
		System.out.println("entrou em reducePointsByMeters");
		
		//Creating objects
		TrackPoint previous = null;
		TrackPoint next = null;
		double d = 0;
		int i = 0;
		
		int TrackPointListSize = trackPointList.size();
		
		//Loop for TrackPoint List
		for (TrackPoint trackPoint : trackPointList) {
			System.out.println("tamanho : " + i);
			//it can't be the first or the last trackpoint from the list
			if(!emptyList(trackPointList)) {
					//System.out.println("entrou: trackpoint");
					if((i!=0)&&(i!=TrackPointListSize-1)) {
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
							System.out.println("removeu um!!");
							trackPointList.remove(trackPoint);
						}
					//System.out.println(i);
				}
			}
		}
		
		return trackPointList;
		
	}
	
	//Verify if there's at least one TrackPoint in the list.
	static public boolean emptyList(ArrayList<TrackPoint> trackPointList) {
		
		if (trackPointList.size() > 0){
			return true;
		} else {
			return false;
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
	

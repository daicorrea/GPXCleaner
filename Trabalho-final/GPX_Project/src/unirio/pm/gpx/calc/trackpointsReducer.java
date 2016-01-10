package unirio.pm.gpx.calc;
import unirio.pm.gpx.model.Track;

import java.util.ArrayList;

import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;


public class TrackpointsReducer {
//ARRUMAR
	public static void reducePointsByMeters(ArrayList<Track> trackList, Double meters){
		System.out.println("entrou: 1");
		DistanceCalculator distanceCalc = new DistanceCalculator();
		double d = 0;
		TrackPoint previous = null;
		TrackPoint next = null;
		for (Track track : trackList) {
			System.out.println("entrou: track");
			ArrayList<TrackSegment> trackSegmentList = track.getSegments();
			for (TrackSegment trackSegment : trackSegmentList) {
				System.out.println("tamanho"+trackSegmentList.size());
				System.out.println("entrou: segment");
				ArrayList<TrackPoint> trackPointList = trackSegment.getTrackPoints();
				
				int i = 1;
				for (TrackPoint trackPoint : trackPointList) {
					int tamanho = trackPointList.size();
					System.out.println("tamanho : " + tamanho);
					//it can't be the first or the last trackpoint from the list
					if(trackPointList.size() > 2) {
						while(i < (trackPointList.size()-1)) {
							//System.out.println("entrou: trackpoint");
							//if((i!=0)||(i!=trackPointList.size()-1)) {
								previous = trackSegment.getTrackPoints().get(i-1);
								//System.out.println("previous: ");
								//System.out.println(previous);
								next = trackSegment.getTrackPoints().get(i+1);
								//System.out.println("next: ");
								//System.out.println(next);
								//System.out.println("current:"+ trackPoint);
								d = distanceCalc.getDistance(trackPoint, previous, next);
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
				}
				
			}
		}		
	}
	
	public boolean emptyList(ArrayList<TrackPoint> trackPointList){
		if (trackPointList.size() > 0){
			return true;
		} else {
			return false;
		}
	}
	
	//Verify if the list has only two trackpoints. As it's not possible to take the
	//first and the last the last trackpoint, the output will be the same as the input
	public boolean onlyTwoTrackPoints(ArrayList<TrackPoint> trackPointList){
		if (trackPointList.size() > 0){
			return true;
		} else {
			return false;
		}
	}
	
	
		
		
}
	

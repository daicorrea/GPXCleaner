package unirio.pm.gpx.rotine;

import java.util.ArrayList;

import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;

public class TrackPointToTrack {
	
	static public Track addingTrackPointsToTrack(String trackName, ArrayList<TrackPoint> trackPointList) {
		
		System.out.println("TAMANHO DO NOVO ENTRANDO: "+ trackPointList.size());
		
		//Creating new null Track
		TrackSegment trackSegment = new TrackSegment();
		ArrayList<TrackSegment> trackSegmentList = new ArrayList<TrackSegment>();
		
		//Setting the input TrackPoint list into the new TrackSegment list
		trackSegment.setTrackPoints(trackPointList);
		
		trackSegmentList.add(trackSegment);
		
		//Setting the new TrackSegment into the new track
		System.out.println("PASSANDO");
		Track track = new Track(trackName, trackSegmentList);
		
		return track;
		
	}

}

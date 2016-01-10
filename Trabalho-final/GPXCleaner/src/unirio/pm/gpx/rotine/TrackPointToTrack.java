package unirio.pm.gpx.rotine;

import java.util.ArrayList;
import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;

public class TrackPointToTrack {
	
	static public Track addingTrackPointsToTrack(String trackName, ArrayList<TrackPoint> trackPointList) {
	
		//Creating TrackSegment objects
		TrackSegment trackSegment = new TrackSegment();
		ArrayList<TrackSegment> trackSegmentList = new ArrayList<TrackSegment>();
		
		//Setting the input TrackPoint list into the new TrackSegment list
		trackSegment.setTrackPoints(trackPointList);
		
		//Adding the new segment to a list
		trackSegmentList.add(trackSegment);
		
		//Setting the new TrackSegment into a new track
		Track track = new Track(trackName, trackSegmentList);
		System.out.println("CONTANDO NOVA LISTA: " + track.countTrackPoints());
		
		
		return track;
		
	}

}

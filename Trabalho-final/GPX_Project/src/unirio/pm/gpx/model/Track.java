package unirio.pm.gpx.model;
import java.util.*;


public class Track {
	
	//Track name
	private String name;
	
	//Track Segment List
	private ArrayList<TrackSegment> segments;
	
	public Track(String name, ArrayList<TrackSegment> segments) {
		super();
		this.name = name;
		this.segments = segments;
	}

	public Track() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<TrackSegment> getSegments() {
		return segments;
	}

	public void setSegments(ArrayList<TrackSegment> segments) {
		this.segments = segments;
	}
	
	public int countTrackPoints() {
		int trackPointTotal = 0;
		System.out.println("CONTANDOOOO");
		for (TrackSegment trackSegment : this.getSegments()){
			for (TrackPoint trackPoint : trackSegment.getTrackPoints()){
				trackPointTotal++;
			}
		}
		System.out.println(trackPointTotal);
		return trackPointTotal;
	}
	
	public void addSegmentToTrack(TrackSegment trackSegment) {
		this.segments.add(trackSegment);
	}
	
}

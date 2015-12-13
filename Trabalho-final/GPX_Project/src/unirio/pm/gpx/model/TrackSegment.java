package unirio.pm.gpx.model;

import java.util.*;

public class TrackSegment {
	private Integer id;
	private ArrayList<TrackPoint> trackPoints;
	
	public TrackSegment(Integer id, ArrayList<TrackPoint> trackPoints) {
		super();
		this.id = id;
		this.trackPoints = trackPoints;
	}

	public TrackSegment() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<TrackPoint> getTrackPoints() {
		return trackPoints;
	}

	public void setTrackPoints(ArrayList<TrackPoint> trackPoints) {
		this.trackPoints = trackPoints;
	}
	
}

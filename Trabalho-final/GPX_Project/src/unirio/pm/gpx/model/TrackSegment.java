package unirio.pm.gpx.model;
import unirio.pm.gpx.calc.DistancePointLine;
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
	
	public void addDistanceTrackPointLine() {
		DistancePointLine distancePntLine = new DistancePointLine();
		for (TrackPoint trackpoint : trackPoints) {
			boolean firstTrackPoint = trackPoints.indexOf(trackpoint) == 0;
			boolean lastTrackPoint = trackPoints.indexOf(trackpoint) == (trackPoints.size() - 1);
			if(!firstTrackPoint && !lastTrackPoint) {
				TrackPoint previousPoint = trackPoints.get(trackPoints.indexOf(trackpoint) - 1);
				TrackPoint nextPoint = trackPoints.get(trackPoints.indexOf(trackpoint) + 1);
				float distance = distancePntLine.calculateDistance(trackpoint, previousPoint, nextPoint);
				trackpoint.setDistanceAdjLine(distance);
			}
		}
	}
	
}

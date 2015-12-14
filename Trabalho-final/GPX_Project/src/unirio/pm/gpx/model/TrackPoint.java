package unirio.pm.gpx.model;

import java.util.Comparator;

public class TrackPoint {
	private Integer id;
	private float latitude;
	private float longitude;
	private float ele;
	private String time;
	private double distanceAdjLine;
	
	public TrackPoint(Integer id, float latitude, float longitude, float ele, String time) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.ele = ele;
		this.time = time;
	}

	public TrackPoint() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getEle() {
		return ele;
	}

	public void setEle(float ele) {
		this.ele = ele;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getDistanceAdjLine() {
		return distanceAdjLine;
	}

	public void setDistanceAdjLine(double distanceAdjLine) {
		this.distanceAdjLine = distanceAdjLine;
	}
	
	
	public static Comparator<TrackPoint> getComparatorDate() {
		return new Comparator<TrackPoint>() {
			@Override
			public int compare(TrackPoint point1, TrackPoint point2) {
				return point1.getTime().compareTo(point2.getTime());
			}
		};
	}

	public static Comparator<TrackPoint> getComparatorDistance() {
		return new Comparator<TrackPoint>() {
			@Override
			public int compare(TrackPoint point1, TrackPoint point2) {
				return (Double.toString(point1.getDistanceAdjLine())).compareTo((Double.toString(point2.getDistanceAdjLine())));
			}
		};
	
	
	}
}

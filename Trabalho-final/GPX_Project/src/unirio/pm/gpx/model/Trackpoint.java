package unirio.pm.gpx.model;

public class TrackPoint {
	private Integer id;
	private double latitude;
	private double longitude;
	private double ele;
	private String time;
	
	public TrackPoint(Integer id, double latitude, double longitude, double ele, String time) {
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

	public double getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getEle() {
		return ele;
	}

	public void setEle(double ele) {
		this.ele = ele;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}

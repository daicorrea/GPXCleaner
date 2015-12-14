package unirio.pm.gpx.model;

public class TrackPoint {
	private Integer id;
	private float latitude;
	private float longitude;
	private float ele;
	private String time;
	private float distanceAdjLine;
	
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

	public float getDistanceAdjLine() {
		return distanceAdjLine;
	}

	public void setDistanceAdjLine(float distanceAdjLine) {
		this.distanceAdjLine = distanceAdjLine;
	}
}

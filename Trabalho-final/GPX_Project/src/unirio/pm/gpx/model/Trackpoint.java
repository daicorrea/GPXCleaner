package unirio.pm.gpx.model;

public class Trackpoint {
	private float id;
	private float lat;
	private float lon;
	private float ele;
	private String time;
	
	public Trackpoint(float id, float lat, float lon, float ele, String time) {
		super();
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.ele = ele;
		this.time = time;
	}

	public float getId() {
		return id;
	}

	public void setId(float id) {
		this.id = id;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
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
	

}

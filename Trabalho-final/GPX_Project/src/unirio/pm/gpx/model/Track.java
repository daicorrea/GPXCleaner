package unirio.pm.gpx.model;
import java.util.*;

public class Track {
	
	private Integer id;
	private String name;
	private ArrayList<TrackSegment> segments;
	
	public Track(Integer id, String name, ArrayList<TrackSegment> segments) {
		super();
		this.id = id;
		this.name = name;
		this.segments = segments;
	}

	public Track() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
}

package unirio.pm.gpx.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import unirio.pm.gpx.calc.TrackPointReducer;
import unirio.pm.gpx.model.TrackPoint;

public class TestReducer {

	@Test
	//Verify if TrackPoint list is not empty
	public void testEmptyList() {
		//Adding TrackPoints to the list
		ArrayList<TrackPoint> trackPointlist = new ArrayList<TrackPoint>();
		TrackPoint trackPoint = createTrackPoint("42.050664", "-71.267238", "63.584351", "2002-03-06T04:23:07Z");
		trackPointlist.add(trackPoint);
		
		//Testing
		assertFalse(TrackPointReducer.emptyList(trackPointlist));
	}
	
	//Creating new TrackPoint
	static private TrackPoint createTrackPoint(String latitude, String longitude, String ele, String time) {
		TrackPoint trackPoint = new TrackPoint(Float.valueOf(latitude),Float.valueOf(longitude),Float.valueOf(ele),time);	
		return trackPoint;
	}
	
	
	

}

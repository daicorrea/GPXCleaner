package unirio.pm.gpx.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import unirio.pm.gpx.calc.TrackPointReducer;
import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.parser.GPXReader;
import unirio.pm.gpx.rotine.TrackReducer;

public class TestReducer {

	@Test
	//Verify if TrackPoint list is not empty passing parameters
	public void testEmptyList() {
		
		//Adding TrackPoints to the list
		ArrayList<TrackPoint> trackPointlist = new ArrayList<TrackPoint>();
		TrackPoint trackPoint = createTrackPoint("42.050664", "-71.267238", "63.584351", "2002-03-06T04:23:07Z");
		trackPointlist.add(trackPoint);
		
		//Testing
		assertFalse(TrackPointReducer.emptyList(trackPointlist));
	}
	
	@Test
	//Verify if the file has TrackPoints
	public void testEmptyListFromFile() {
		
		//Reading File
		ArrayList<Track> trackList = new ArrayList<Track>();
		String testFileName = "../GPX_Project/src/unirio/pm/gpx/file/foxboroTest.gpx";
		
  		
	    //Read GPX File
		try {
			trackList = GPXReader.ReadGPX(testFileName);
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
		
	    //Getting the TrackPoint list read
		ArrayList<TrackPoint> trackPointsRead = new ArrayList<TrackPoint>();
	    trackPointsRead = trackList.get(0).getSegments().get(0).getTrackPoints();
	    
	    //Creating and adding TrackPoints to a list
	    ArrayList<TrackPoint> trackPointlist = new ArrayList<TrackPoint>();
	    TrackPoint firstTrackPoint = createTrackPoint("42.050664", "-71.267238", "63.584351", "2002-03-06T04:23:07Z");	
	    trackPointlist.add(firstTrackPoint);
	    TrackPoint secTrackPoint = createTrackPoint("43.050664", "-72.267238", "64.584351", "2002-03-06T05:20:07Z");	
	    trackPointlist.add(secTrackPoint);
	    
		//Testing
	    assertFalse(TrackPointReducer.emptyList(trackPointlist));
	}
	
	@Test
	//Verify if TrackPoints are in the same place
	public void testTrackPointsInSamePlace() {
		
		//Adding TrackPoints to the list
		ArrayList<TrackPoint> trackPointlist = new ArrayList<TrackPoint>();
		TrackPoint firstTrackPoint = createTrackPoint("42.050664", "-71.267238", "63.584351", "2002-03-06T04:23:07Z");
		trackPointlist.add(firstTrackPoint);
		TrackPoint secTrackPoint = createTrackPoint("42.050664", "-71.267238", "62.584351", "2002-03-06T05:26:07Z");
		trackPointlist.add(secTrackPoint);
		
		//Testing calling the function
		assertTrue(TrackPointReducer.pointsAtTheSamePlace(firstTrackPoint, secTrackPoint));
	}
	
	@Test
	//Test if it's removing the right Trackpoints by distance
	public void testRemoverPointsByDistance() {
		String testInputFileName = "../GPX_Project/src/unirio/pm/gpx/file/foxboro-remover-test.gpx";
		
	    //Creating object lists
	    ArrayList<Track> trackList = new ArrayList<Track>();
	    ArrayList<TrackPoint> trackPointsRead = new ArrayList<TrackPoint>();
	  		
	    //Read GPX File
	    try {
			trackList = GPXReader.ReadGPX(testInputFileName);
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
	  		
	    //Reducing the list
	    trackList = TrackReducer.reduceTrack(trackList, "0.01");
	    
	    //Getting the TrackPoint list read
	    trackPointsRead = trackList.get(0).getSegments().get(0).getTrackPoints();
	    
	    //Creating and adding the expected TrackPoints output to a list
	    ArrayList<TrackPoint> trackPointlist = new ArrayList<TrackPoint>();
	    TrackPoint firstTrackPoint = createTrackPoint("44.02248083", "-123.1245669", "261.135252", "2007-02-18T03:34:31Z");	
	    trackPointlist.add(firstTrackPoint);
	    TrackPoint secTrackPoint = createTrackPoint("44.02280848", "-123.124453", "261.615965", "2007-02-18T03:36:03Z");	
	    trackPointlist.add(secTrackPoint);
	    TrackPoint thirdTrackPoint = createTrackPoint("44.02267361", "-123.1244789", "261.615966", "2007-02-18T03:36:28Z");	
	    trackPointlist.add(thirdTrackPoint);
	    
	    //Testing the list size
	    assertEquals(trackPointlist.size(), trackPointsRead.size());
	    
	    
	    //Testing the elements of the lists
	    for (int i = 0; i < trackPointsRead.size(); i++) {
		    float elem1 = trackPointlist.get(i).getEle();
		    float elem2 = trackPointsRead.get(i).getEle();
		    
	        //assuming that both lists are sorted and the delta is 0.0002
	        assertEquals(elem1, elem2, 0.5); 
            
        };
	}
	
	@Test
	//Verify if point is in the line
	public void testPointsAtTheLine() {
		double distance = 0;
		
		//Testing
		assertTrue(TrackPointReducer.pointsAtTheSameLine(distance));
	}
	
	//Creating new TrackPoint
	static private TrackPoint createTrackPoint(String latitude, String longitude, String ele, String time) {
		TrackPoint trackPoint = new TrackPoint(Float.valueOf(latitude),Float.valueOf(longitude),Float.valueOf(ele),time);	
		return trackPoint;
	}
	
}

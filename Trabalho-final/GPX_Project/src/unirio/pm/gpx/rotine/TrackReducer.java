package unirio.pm.gpx.rotine;

import java.io.IOException;
import java.util.ArrayList;

import unirio.pm.gpx.calc.TrackpointsReducer;
import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;
import unirio.pm.gpx.parser.ReadGPX;
import unirio.pm.gpx.parser.WriteGPX;

public class TrackReducer {
	
	static public void distanceRemover() throws IOException{
		ArrayList<Track> trackList = new ArrayList<Track>();
		ArrayList<TrackSegment> trackSegmentList = new ArrayList<TrackSegment>();
		ArrayList<TrackPoint> trackPointList = new ArrayList<TrackPoint>();
		
		//Read GPX File
		ReadGPX reader = new ReadGPX();
		trackList = reader.gpxReader("../GPX_Project/src/unirio/pm/gpx/file/Century-2007-02-18.gpx");
		
		//Get all the TrackPoints from each Track
		TrackpointsReducer trackReducer = new TrackpointsReducer();
		
		System.out.println("comecando a testar novo: ");
		for (Track track : trackList) { 
			track.countTrackPoints();
		}
		trackReducer.reducePointsByMeters(trackList, 250.0);
		for (Track track : trackList) { 
			track.countTrackPoints();
		}
		
		//Write the new GPX File
		WriteGPX writer = new WriteGPX();
		writer.gpxWriter(trackList, "../GPX_Project/src/unirio/pm/gpx/file/NewFileCentury-2007-02-18-teste_sem_id.gpx");
	
		
	}

}

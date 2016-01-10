package unirio.pm.gpx.rotine;

import java.io.IOException;
import java.util.ArrayList;
import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;
import unirio.pm.gpx.parser.ReadGPX;
import unirio.pm.gpx.parser.WriteGPX;
import unirio.pm.gpx.rotine.TrackPointListFromTrack;
import unirio.pm.gpx.calc.TrackPointReducer;

public class TrackReducer {
	
	static public void distanceRemover() throws IOException{
		
		//Creating object lists
		ArrayList<Track> trackList = new ArrayList<Track>();
		ArrayList<TrackSegment> trackSegmentList = new ArrayList<TrackSegment>();
		ArrayList<TrackPoint> trackPointList = new ArrayList<TrackPoint>();
		
		//Read GPX File
		ReadGPX reader = new ReadGPX();
		trackList = reader.gpxReader("../GPX_Project/src/unirio/pm/gpx/file/Century-2007-02-18.gpx");
				
		//Verify if the list is empty
		if(!emptyList(trackList)){
			System.out.println("There was an error while reading the file. Please verify it and try again later.");
			System.exit(0);
		}
		
		//Creating a loop to get into each Track
		for (Track track : trackList) { 
			
			//Count the TrackPoints from the Track before reducing
			track.countTrackPoints();
			
			//Get all the TrackPoints from each Track
			trackPointList = TrackPointListFromTrack.getTrackPointList(track);
			
			//Reduce TrackPoints
			trackPointList = TrackPointReducer.reducePointsByMeters(trackPointList, 12.0);
			
			//Count the TrackPoints from the track after reducing
			track.countTrackPoints();
		}
		//trackPointReducer.reducePointsByMeters(trackList, 250.0);
		for (Track track : trackList) { 
			track.countTrackPoints();
		}
		
		//Write the new GPX File
		WriteGPX.gpxWriter(trackList, "../GPX_Project/src/unirio/pm/gpx/file/NewFileCentury-2007-02-18-teste_sem_id.gpx");
		
	}
	
	//Verify if there is at least one Track in the list.
	static public boolean emptyList(ArrayList<Track> trackList){
		if (trackList.size() > 0){
			return true;
		} else {
			return false;
		}
	}

}

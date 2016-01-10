package unirio.pm.gpx.rotine;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.parser.ReadGPX;
import unirio.pm.gpx.parser.WriteGPX;
import unirio.pm.gpx.parser.newReadGPX;
import unirio.pm.gpx.rotine.TrackPointListFromTrack;
import unirio.pm.gpx.calc.TrackPointReducer;
import unirio.pm.gpx.rotine.TrackPointToTrack;

public class TrackReducer {
	
	static public void remover() throws IOException, ParserConfigurationException, SAXException{
		
		//Creating object lists
		ArrayList<Track> trackList = new ArrayList<Track>();
		
		//Read GPX File
		//ReadGPX reader = new ReadGPX();
		newReadGPX reader = new newReadGPX();
		//trackList = reader.gpxReader("../GPX_ProjectDaiane/src/unirio/pm/gpx/file/foxboro.gpx");
		trackList = newReadGPX.ReadGPX("../GPX_Project/src/unirio/pm/gpx/file/foxboro.gpx");
		//newReadGPX.ReadGPX("../GPX_ProjectDaiane/src/unirio/pm/gpx/file/foxboro.gpx");
		//Verify if the list is empty
//		if(!emptyList(trackList)){
//			System.out.println("There was an error while reading the file. Please verify it and try again later.");
//			System.exit(0);
//		}
		
		//Reducing the list
//		trackList = reduceTrack(trackList);
		
		//Write the new GPX File
		WriteGPX.gpxWriter(trackList, "../GPX_Project/src/unirio/pm/gpx/file/NewFilefoxboro.gpx");
		
		System.out.println("Your file is ready. Enjoy.");
	}
	
	//Verify if there is at least one Track in the list.
	static private boolean emptyList(ArrayList<Track> trackList){
		if (trackList.size() > 0){
			return true;
		} else {
			return false;
		}
	}
	
	//Reduce the Track
	static private ArrayList<Track> reduceTrack(ArrayList<Track> trackList) {
		
		//Creating list objects
		ArrayList<TrackPoint> trackPointList = new ArrayList<TrackPoint>();
		ArrayList<Track> newTrackList = new ArrayList<Track>();
		
		//Creating a loop to get into each Track
		for (Track track : trackList) { 
			
			//Count the TrackPoints from the Track before reducing
			track.countTrackPoints();
			
			//Get all the TrackPoints from the Track
			trackPointList = TrackPointListFromTrack.getTrackPointList(track);
					
			//Reduce TrackPoints
			//trackPointList = TrackPointReducer.reducePointsByDistance(trackPointList, 12.0);
			trackPointList = TrackPointReducer.reducePointsByPercentage(trackPointList, 10);	
			
			//Put the TrackPoints back to the Track
			track =  TrackPointToTrack.addingTrackPointsToTrack(track.getName(), trackPointList);
					
			//Count the TrackPoints from the track after reducing
			track.countTrackPoints();
				
			//Adding the changed Track to the new TrackList
			newTrackList.add(track);
		}
		
		return newTrackList;
	}
	

}

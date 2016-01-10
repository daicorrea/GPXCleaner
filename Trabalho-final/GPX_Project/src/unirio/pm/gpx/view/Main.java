package unirio.pm.gpx.view;
import java.io.IOException;
import unirio.pm.gpx.rotine.TrackReducer;


public class Main {
	public static void main(String[] args) throws IOException {
		TrackReducer.distanceRemover();
		//TrackpointsReducer trackReducer = new TrackpointsReducer();
		//ArrayList<Track> trackList = new ArrayList<Track>();
		
		//ReadGPX reader = new ReadGPX();
		//trackList = reader.gpxReader("../GPX_Project/src/unirio/pm/gpx/file/Century-2007-02-18.gpx");
		/*
		System.out.println("comecando a testar novo: ");
		for (Track track : trackList) { 
			track.countTrackPoints();
		}
		trackReducer.reducePointsByMeters(trackList, 250.0);
		for (Track track : trackList) { 
			track.countTrackPoints();
		}

		WriteGPX writer = new WriteGPX();
		writer.gpxWriter(trackList, "../GPX_Project/src/unirio/pm/gpx/file/NewFileCentury-2007-02-18-teste_sem_id.gpx");
	*/
	}
}

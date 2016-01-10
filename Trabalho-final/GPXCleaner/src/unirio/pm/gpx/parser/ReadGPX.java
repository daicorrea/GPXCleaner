package unirio.pm.gpx.parser;
import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;
import java.io.File;
import java.util.*;
import parserPackage.*;
import javax.xml.bind.*;

//Create class for parsing the GPX file
public class ReadGPX { 
	
	//Receives a .gpx file and reads its elements
	public ArrayList<Track> gpxReader(String file) {
		
		//Creating a new Track List
		ArrayList<Track> trackList = new ArrayList<Track>();
		
		GpxType gpx = null; 
		try {
			
			//Receives the package to use its classes
			JAXBContext jc = JAXBContext.newInstance("parserPackage");  
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			
			//Reads the file
			JAXBElement<GpxType> root = (JAXBElement<GpxType>) unmarshaller.unmarshal(new File(file)); 
			
			//Puts the file on the gpx variable
			gpx = root.getValue(); 
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		//Gets the Node TRK (root)
		List<TrkType> trkList = gpx.getTrk(); 
		//As we will get the tracks, we count how many we have to create an ID
		int trackID = 0;
		Track track = null;
		//For each of the list to read its elements (referring to the root node TRK)
		for (TrkType trk : trkList) { 
			trackID = trackID++;
			track = createTrack(trk, trackID);
			trackList.add(track);
			//System.out.println("Testando: ");
			//System.out.println(track.getSegments().get(2).getTrackPoints().get(2).getLatitude());
		}
		return trackList;
	}

	private Track createTrack(TrkType trk, int trackID){
		ArrayList<TrackSegment> segments = new ArrayList<TrackSegment>();
		//Second in the hierarchy comes the "trkseg" node 
		for (TrksegType trkseg : trk.getTrkseg()){ 
			TrackSegment trackSegment = createTrackSegment(trkseg);
			segments.add(trackSegment);
		}
		Track track = new Track(trk.getName(),segments);
		return track;
	}

	private TrackSegment createTrackSegment(TrksegType trkseg) {
		ArrayList<TrackPoint> trackPoints = new ArrayList<TrackPoint>();
		//Finally it reads the point that contains the attributes such as latitude
		for (WptType trkpt : trkseg.getTrkpt()){
			TrackPoint trackPoint = createTrackPoint(trkpt);
			//adding the new trackpoint to the list for the segments
			trackPoints.add(trackPoint);
		}
		TrackSegment trackSegment = new TrackSegment(trackPoints);
		return trackSegment;
	}

	private TrackPoint createTrackPoint(WptType trkpt) {
		//System.out.println("longitude = " + trkpt.getLon());
		//System.out.println("latitude = " + trkpt.getLat());
		TrackPoint trackPoint = new TrackPoint(trkpt.getLat().floatValue(),
				trkpt.getLon().floatValue(),trkpt.getEle().floatValue(),
					trkpt.getTime().toString());
		return trackPoint;
	}
}
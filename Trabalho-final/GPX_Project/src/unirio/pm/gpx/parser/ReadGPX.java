package unirio.pm.gpx.parser;
import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;

import java.io.File;
import java.util.*;

import parserPackage.*;

import javax.xml.bind.*;

//Creat class for parsing the GPX file
public class ReadGPX{ 
	//Creating variables to count the id
	private Integer trackID;
	private Integer trackSegID;
	private Integer trackPointID;
	//Receives a .gpx file and reads its elements
	@SuppressWarnings("unchecked")
	public Track gpxReader(String file){
		Track track = null;
		trackID = 0;
		trackSegID = 0;
		trackPointID = 0;
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
		//For each of the list to read its elements (referring to the root node TRK)
		for (TrkType trk : trkList) { 
			trackID = trackID++;
			//Usually there's only one
			ArrayList<TrackSegment> segments = new ArrayList<TrackSegment>();
			//Second in the hierarchy comes the "trkseg" node 
			for (TrksegType trkseg : trk.getTrkseg()){ 
				trackSegID = trackSegID++;
				ArrayList<TrackPoint> trackPoints = new ArrayList<TrackPoint>();
				//Finally it reads the point that contains the attributes such as latitude
				for (WptType trkpt : trkseg.getTrkpt()){
					trackPointID = trackPointID++;
					System.out.println("longitude = " + trkpt.getLon());
					System.out.println("latitude = " + trkpt.getLat());
					TrackPoint trackPoint = new TrackPoint(trackPointID,trkpt.getLat().floatValue(),
							trkpt.getLon().floatValue(),trkpt.getEle().floatValue(),
							trkpt.getTime().toString());
					//adding the new trackpoint to the list for the segments
					trackPoints.add(trackPoint);
				}
				TrackSegment trackSegment = new TrackSegment(trackPoints);
				segments.add(trackSegment);
			}
			track = new Track(trackID,trk.getName(),segments);
			System.out.println("Testando: ");
			System.out.println(track.getSegments().get(2).getTrackPoints().get(2).getLatitude());
		}
		return track;
	}
}
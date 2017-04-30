package unirio.pm.gpx.parser;
import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GPXWriter {
	
	//Create XML header
	private static final String xml_header = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";
	
	//Create GPX opening tag
	private static final String tag_gpx = "<gpx "+ "\n" + 
		"\t" + "creator=\"Daiane Correa, Felipe Guedes, Cesar\"" + "\n" + 
		"\t" + "version=\"1.1\" xmlns=\"http://www.topografix.com/GPX/1/1\"" + "\n" +
		"\t" + "xmlns:geocache=\"http://www.groundspeak.com/cache/1/0\"" + "\n" +
		"\t" + "xmlns:gpxdata=\"http://www.cluetrust.com/XML/GPXDATA/1/0\"" + "\n" +
		"\t" + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " + "\n" +
		"\t" + "xsi:schemaLocation=\"http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd" + "\n" +
		"\t" + "http://www.cluetrust.com/XML/GPXDATA/1/0 http://www.cluetrust.com/Schemas/gpxdata10.xsd\">";
	
	// Writes the GPX file
	public static void gpxWriter(ArrayList<Track> trackList, String targetFile)
			throws IOException {
		
		FileWriter fw = new FileWriter(new File(targetFile));
		fw.write(xml_header + "\n");
		fw.write(tag_gpx + "\n");
		
		for (Track track : trackList) {
			fw.write("\t" + "<trk>" + "\n");
			
			//Writes the name tag
			fw.write("\t\t" + "<name>" + track.getName() + "</name>" + "\n");
			
			//For each segment inside the track
			for (TrackSegment trackSegment : track.getSegments()) {
				writeTrackSegment(fw, trackSegment);
			}
			
			fw.write("\t" + "</trk>" + "\n");
			fw.write("</gpx>");
			fw.close();
		}
	}
	
	//Write Segments
	public static void writeTrackSegment(FileWriter fw, TrackSegment trackSegment)
			throws IOException {
		
		fw.write("\t\t" + "<trkseg>" + "\n");
		
		for (TrackPoint trackPoint : trackSegment.getTrackPoints()) {
			writeTrackPoints(fw, trackPoint);
		}
		
		fw.write("\t\t" + "</trkseg>" + "\n");
	}

	//Write trackPoints
	public static void writeTrackPoints(FileWriter fw, TrackPoint trackPoint)
			throws IOException {
		
			StringBuffer out = new StringBuffer();
			out.append("\t\t\t" + "<trkpt lat=\"" + trackPoint.getLatitude()
					+ "\" " + "lon=\"" + trackPoint.getLongitude() + "\">" + "\n");
			out.append("\t\t\t\t" + "<ele>" + trackPoint.getEle() + "</ele>" + "\n");
			out.append("\t\t\t\t" + "<time>" + trackPoint.getTime()
					+ "</time>" + "\n");
			out.append("\t\t\t" + "</trkpt>" + "\n");
			fw.write(out.toString());
	}
}


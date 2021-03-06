package unirio.pm.gpx.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;

//Create class for parsing the GPX file
public class GPXReader {
	
	//Receives a .gpx file and reads its elements
	public static ArrayList<Track> ReadGPX(String file) throws IOException, ParserConfigurationException, SAXException {
		
			File GPXFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(GPXFile);
	
			//Optional, but recommended
			//read more - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
			
			//Creating a new Track List
			ArrayList<Track> trackList = new ArrayList<Track>();
			
			//List Tracks
			NodeList nListTrk = doc.getElementsByTagName("trk");
			int trackListSize = nListTrk.getLength();
			
			//For each of the list to read its elements
			for(int i = 0; i < trackListSize; i++) { 
				//get the Track name
				Node nNodeTrk = nListTrk.item(i);
				Element elementTrk = (Element) nNodeTrk;
				String trkName = elementTrk.getElementsByTagName("name").item(i).getTextContent();
				
				//get TrackSegment List
				NodeList nListTrkseg = doc.getElementsByTagName("trkseg");
				int trackSegmentListSize = nListTrkseg.getLength();
				ArrayList<TrackSegment> TrackSegmentList = new ArrayList<TrackSegment>();

				//Second in the hierarchy comes the "trkseg" node 
				for(int j = 0; j < trackSegmentListSize; j++){ 
					Element trackSeg = (Element) nListTrkseg.item(j);
					
					//Getting TrackPoints
					NodeList nListTrkpt = trackSeg.getElementsByTagName("trkpt");
					int trackPointListSize = nListTrkpt.getLength();
					ArrayList<TrackPoint> TrackPointlist = new ArrayList<TrackPoint>();
					
					for(int k = 0; k < trackPointListSize; k++) { 
						Node nNode = nListTrkpt.item(k);
						
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode;
							
							String latitude = eElement.getAttribute("lat");
							String longitude = eElement.getAttribute("lon");
							String ele = eElement.getElementsByTagName("ele").item(i).getTextContent();
							String time	= eElement.getElementsByTagName("time").item(i).getTextContent();	
							
							//Creating new TrackPoing
							TrackPoint trackpoint = new TrackPoint(Float.valueOf(latitude),Float.valueOf(longitude),Float.valueOf(ele),time);	
							TrackPointlist.add(trackpoint);
						}
					}
					//Creating new TrackSegment
					TrackSegment trackSegment = new TrackSegment(TrackPointlist);
					TrackSegmentList.add(trackSegment);
				}
				
				//Creating new track
				Track track = new Track(trkName,TrackSegmentList);
				trackList.add(track);
			}
			return trackList;
			
	}	
	
}
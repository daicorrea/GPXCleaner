package unirio.pm.gpx.parser;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;

public class newReadGPX {
	static public void ReadXML() throws IOException{
	try {

		File fXmlFile = new File("/Users/cesar/Desktop/GPX_ProjectDaiane/src/unirio/pm/gpx/file/Century-2007-09-01.gpx");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		//Puts the file on the gpx variable
	
		
		//Gets the Node TRK (root)
	//gpx =  
		
		NodeList nListTrkpt = doc.getElementsByTagName("trkpt");
		NodeList nListTrk = doc.getElementsByTagName("trk");
		NodeList nListTrkseg = doc.getElementsByTagName("trkseg");
		
		System.out.println("tamanho Trkpt : " +nListTrkpt.getLength());
		System.out.println("tamanho Trkseg : " +nListTrkseg.getLength());
		
		
		Node nNode2 = nListTrk.item(0);
		Element eElement2 = (Element) nNode2;
		String name = eElement2.getElementsByTagName("name").item(0).getTextContent();
		
		ArrayList<TrackSegment> TrackSegmentList = new ArrayList<TrackSegment>();
		
		ArrayList<TrackPoint> TrackPointlist = new ArrayList<TrackPoint>();
		//TrackSegment trackSegment = new TrackSegment(TrackPointlist);
		//TrackSegment trackSegment;
		
	for (int temp = 0; temp < nListTrk.getLength(); temp++) {
	for (int temp3 = 0; temp3 < nListTrkseg.getLength(); temp3++) {
		for (int temp2 = 0; temp2 < nListTrkpt.getLength(); temp2++) {
			Node nNode = nListTrkpt.item(temp);
			
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
		/*
		System.out.println("latitude : " + eElement.getAttribute("lat"));
		System.out.println("longitude : " + eElement.getAttribute("lon"));
		System.out.println("Element : " + eElement.getElementsByTagName("ele").item(0).getTextContent());
		System.out.println("Time : " + eElement.getElementsByTagName("time").item(0).getTextContent());
		*/	
		
				String latitude 	= eElement.getAttribute("lat");
				String longitude 	= eElement.getAttribute("lon");
				String ele 			= eElement.getElementsByTagName("ele").item(0).getTextContent();
				String time 		= eElement.getElementsByTagName("time").item(0).getTextContent();	
		
				TrackPoint trackpoint = new TrackPoint(Float.valueOf(latitude),Float.valueOf(longitude),Float.valueOf(ele),time);	
				TrackPointlist.add(trackpoint);
		System.out.println("Estamos no segundo for : "+ TrackPointlist.get(temp2).getLatitude()); 
		//System.out.println("Estamos no segundo for 2 : " + TrackPointlist.get(temp2).getEle());
			}
		}
		
		
		TrackSegment trackSegment = new TrackSegment(TrackPointlist);
		TrackSegmentList.add(trackSegment);
	}
	
	}	
		System.out.println("Estamos no primeiro for  : " + TrackSegmentList.get(0).getTrackPoints().get(2).getLatitude());
		
		Track Track = new Track(name,TrackSegmentList);
	} catch (Exception e) {
		e.printStackTrace();
	}
		

	
}	
}
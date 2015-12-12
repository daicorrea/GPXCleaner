package unirio.pm.gpxcleaner.test;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.fmt.gps.track.TrackPoint;

public class ReadXMLFile {
 
	public static void ReadXML() {
      Document document = null;
      SAXBuilder builder = new SAXBuilder();
      try {
         document = builder.build("C:/Users/cesar/Documents/pm/Trabalho-final/Century-2007-02-18.gpx");
      } catch (Exception e) {
         e.printStackTrace();
      }
      Element trk = document.getRootElement();
      List list = trk.getChildren("trkseg");
      
      for (int i = 0; i < list.size(); i++) {
    	  Element node = (Element) list.get(i);
    	 // System.out.println("trackpoint: " + node.getChildText("trkpt"));
    	  System.out.println("ele: " + node.getChildText("ele"));
    	  System.out.println("time: " + node.getChildText("time"));
    	//  System.out.println("faculdade: " + node.getChildText("faculdade"));
      }    
	}
}
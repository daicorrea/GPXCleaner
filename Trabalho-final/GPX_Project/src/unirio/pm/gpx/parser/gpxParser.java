package unirio.pm.gpx.parser;
import java.io.File;
import java.util.List;
import parserPackage.*;
import javax.xml.bind.*;

//Creat class for parsing the GPX file
public class gpxParser{ 
	//Receives a .gpx file and reads its elements
	public void gpxReader(String file){  
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
			//Second in the hierarchy comes the "trkseg" node 
			for (TrksegType trkseg : trk.getTrkseg()){ 
				//Finally it reads the point that contains the attributes such as latitude
				for (WptType trkpt : trkseg.getTrkpt()){ 
					System.out.println("longitude = " + trkpt.getLon());
					System.out.println("latitude = " + trkpt.getLat());
				}
			}
		}
	}
}
import java.io.File;
import java.util.List;
import parserPackage.*;
import javax.xml.bind.*;


public class gpxParser{ //Class for parsing the GPX file

	
	public void gpxReader(String file){ //Receives a .gpx file and reads its elements 
		
		GpxType gpx = null; 
		
		try {

			JAXBContext jc = JAXBContext.newInstance("parserPackage"); //Receives the package to use its classes 
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			JAXBElement<GpxType> root = (JAXBElement<GpxType>) unmarshaller.unmarshal(new File(file)); //Reads the file
			
			gpx = root.getValue(); //Puts the file on the gpx variable
		
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		List<TrkType> trkList = gpx.getTrk(); //Gets the Node TRK (root)
	
		for (TrkType trk : trkList) { //For each of the list to read its elements (referring to the root node TRK)
			for (TrksegType trkseg : trk.getTrkseg()){ //Second in the hierarchy comes the "trkseg" node 
				for (WptType trkpt : trkseg.getTrkpt()){ //Finally it reads the point that contains the attributes such as latitude
					
					System.out.println("longitude = " + trkpt.getLon());
					System.out.println("latitude = " + trkpt.getLat());
					
					
				}
				
			}
			
		}

	}
		
	
}
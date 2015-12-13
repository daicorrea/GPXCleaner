package unirio.pm.gpxcleaner.test;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;


public class ReadXMLFile {
 
	public static void ReadXML() {
      Document document = null;
      Document document2 = null;
      SAXBuilder builder = new SAXBuilder();
      try {
         document = builder.build("C:/Users/cesar/Documents/pm/Trabalho-final/test.xml");
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      try {
          document2 = builder.build("C:/Users/cesar/Documents/pm/Trabalho-final/Century-2007-02-18.gpx");
       } catch (Exception e) {
          e.printStackTrace();
       }
      
      
      Element teste = document.getRootElement();
 
      List list = teste.getChildren("pessoa");
    //  tamanhho da lista
     System.out.println("teste: " + list.size());
      
    
     Element trk = document2.getRootElement();
         List list2 = trk.getChildren("trkseg");
       //  tamanhho da lista
        System.out.println("trkseg: " + list2.size());
         
     
     
      for (int i = 0; i < list.size(); i++) {
    	  Element node = (Element) list.get(i);
    	 // System.out.println("ele: " + node.getChildText("ele"));
    	//  System.out.println("time: " + node.getChildText("time"));
      }    
	}
}
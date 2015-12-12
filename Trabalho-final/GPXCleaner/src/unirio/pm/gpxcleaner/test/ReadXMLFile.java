package unirio.pm.gpxcleaner.test;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ReadXMLFile {
	public static void ReadXML() {
      Document document = null;
      SAXBuilder builder = new SAXBuilder();
      try {
         document = builder.build("C:/Users/Daiane/Documents/GitHub/password/pm/Trabalho-final/test.xml");
      } catch (Exception e) {
         e.printStackTrace();
      }
      Element test = document.getRootElement();
      List list = test.getChildren("pessoa");
      for (int i = 0; i < list.size(); i++) {
    	  Element node = (Element) list.get(i);
    	  System.out.println("nome: " + node.getChildText("nome"));
    	  System.out.println("sobrenome: " + node.getChildText("sobrenome"));
    	  System.out.println("materia: " + node.getChildText("materia"));
    	  System.out.println("faculdade: " + node.getChildText("faculdade"));
      }    
	}
}
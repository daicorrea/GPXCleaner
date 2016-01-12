package unirio.pm.gpx.view;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import unirio.pm.gpx.rotine.TrackReducer;
import unirio.pm.gpx.rotine.VerifyParams;


public class Main {
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		
		VerifyParams.verify(args);
		
		TrackReducer.remover(args);
		
	}
}

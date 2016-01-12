package unirio.pm.gpx.view;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import unirio.pm.gpx.rotine.TrackReducer;
import unirio.pm.gpx.rotine.VerifyParams;


public class Main {
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		
		String[] argsal = {"10%", "../GPX_Project/src/unirio/pm/gpx/file/foxboro.gpx", "../GPX_Project/src/unirio/pm/gpx/file/NewFilefoxboro.gpx"};
		VerifyParams.verify(argsal);
		
		TrackReducer.remover("0.1", "../GPX_Project/src/unirio/pm/gpx/file/foxboro.gpx", "../GPX_Project/src/unirio/pm/gpx/file/NewFilefoxboro.gpx");
		
	}
}

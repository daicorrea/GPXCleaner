package unirio.pm.gpx.view;
import unirio.pm.gpx.parser.ReadGPX;

public class Main {
	public static void main(String[] args) {
		ReadGPX reader = new ReadGPX();
		reader.gpxReader("../GPX_Project/src/unirio/pm/gpx/file/Century-2007-02-18.gpx");
	}
}

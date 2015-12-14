package unirio.pm.gpx.view;
import java.io.IOException;

import unirio.pm.gpx.model.Track;
import unirio.pm.gpx.parser.ReadGPX;
import unirio.pm.gpx.parser.WriteGPX;

public class Main {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		Track track = new Track();
		ReadGPX reader = new ReadGPX();
		track = reader.gpxReader("../GPX_Project/src/unirio/pm/gpx/file/Century-2007-02-18.gpx");
		WriteGPX writer = new WriteGPX();
		writer.gpxWriter(track, "../GPX_Project/src/unirio/pm/gpx/file/NewFileCentury-2007-02-18-teste_sem_id.gpx");
	}
}

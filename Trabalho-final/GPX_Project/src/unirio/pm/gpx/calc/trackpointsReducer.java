package unirio.pm.gpx.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;


public class trackpointsReducer {


	public TrackSegment trackSegmentReducebyPercent(TrackSegment BaseTrackSegment, Double percent) {
		int QuantityOfEliminatePoints = (int) (BaseTrackSegment.getTrackPoints().size() * (percent / 100));

		List<TrackPoint> reducedTracksegment = new ArrayList<TrackPoint>(BaseTrackSegment.getTrackPoints());
		//Collections.sort(reducedTracksegment, TrackPoint.getComparatorDistanciaARetaCrescente());
		for (int i = 0; i < QuantityOfEliminatePoints; i++) {
			reducedTracksegment.remove(i);
		}
		//Collections.sort(reducedTracksegment, TrackPoint.getComparatorDataCrescente());
		//return new TrackSegment(reducedTracksegment);
	}
 
	
	
	public TrackSegment reduzTrajetoriaPorDistancia(TrackSegment BaseTrackSegment, Double pointRange) {
		Double kilometerPointRange = pointRange / 1000;
		List<TrackPoint> reducedTracksegment = new ArrayList<TrackPoint>(BaseTrackSegment.getTrackPoints());
		for (TrackPoint point : reducedTracksegment) {
			//if (point.getDistanciaARetaAdjacente() <= kilometerPointRange) {
				reducedTracksegment.remove(point);
			}
		}
		//Collections.sort(trajetoriaMinimizada, TrackPoint.getComparatorDataCrescente());
		//return new TrackSegment(trajetoriaMinimizada);

	}
}
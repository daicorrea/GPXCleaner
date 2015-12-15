package unirio.pm.gpx.calc;

import java.util.ArrayList;
import java.util.Collections;

import unirio.pm.gpx.model.TrackPoint;
import unirio.pm.gpx.model.TrackSegment;


public class trackpointsReducer {


	public TrackSegment trackSegmentReducebyPercent(TrackSegment BaseTrackSegment, Double percent) {
		int QuantityOfEliminatePoints = (int) (BaseTrackSegment.getTrackPoints().size() * (percent / 100));

		ArrayList<TrackPoint> reducedTracksegment = new ArrayList<TrackPoint>(BaseTrackSegment.getTrackPoints());
		Collections.sort(reducedTracksegment, TrackPoint.getComparatorDistance());
		for (int i = 0; i < QuantityOfEliminatePoints; i++) {
			reducedTracksegment.remove(i);
		}
		Collections.sort(reducedTracksegment, TrackPoint.getComparatorDate());
		return new TrackSegment(reducedTracksegment);
	}
 
	
	
	public TrackSegment reduzTrajetoriaPorDistancia(TrackSegment BaseTrackSegment, Double pointRange) {
		Double kilometerPointRange = pointRange / 1000;
		ArrayList<TrackPoint> reducedTracksegment = new ArrayList<TrackPoint>(BaseTrackSegment.getTrackPoints());
		for (TrackPoint point : reducedTracksegment) {
			if (point.getDistanceAdjLine() <= kilometerPointRange) {
				reducedTracksegment.remove(point);
			}
		}
		Collections.sort(reducedTracksegment, TrackPoint.getComparatorDate());
		return new TrackSegment(reducedTracksegment);

	}
}
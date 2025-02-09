package com.ScienceFair;

public class DistanceCalculator {
    private final static int EARTH_RADIUS = 6381;

    public static double ManhattanDistance(Point start, Point end) {
        Point intermediate = new Point(start.latitude, end.longitude);
        return EuclideanDistance(start, intermediate) + EuclideanDistance(intermediate, end);
    }

    public static double EuclideanDistance(Point start, Point end) {
        return haversine(start, end);
    }

    public static double toMiles(double kilometers) {
        return (kilometers * 0.62137119224);
    }

    public static double toKilometers(double miles) {
        return (miles / 0.62137119224);
    }

    private static double haversine(Point start, Point end) {
        return haversineUtil(start.latitude, start.longitude, end.latitude, end.longitude);
    }

    private static double haversineUtil(double lat1, double lon1, double lat2, double lon2) {
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);


        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return EARTH_RADIUS * c;
    }
}

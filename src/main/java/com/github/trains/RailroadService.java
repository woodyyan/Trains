package com.github.trains;

import com.github.algorithm.TripAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class RailroadService {
    private final List<Route> allRoutes;
    private TripAlgorithm tripAlgorithm;
    private Station departure;
    private Station arrival;
    private List<Station> stops;

    public RailroadService(List<Route> allRoutes) {
        this.allRoutes = allRoutes;
    }

    List<Route> getAllRoutes() {
        return allRoutes;
    }

    public void setTripAlgorithm(TripAlgorithm tripAlgorithm) {
        this.tripAlgorithm = tripAlgorithm;
    }

    public List<Trip> queryTrips(Station from, Station to) {
        if (tripAlgorithm != null) {
            return tripAlgorithm.queryTrips(from, to);
        }

        return new ArrayList<>();
    }

    public RailroadService departure(Station from) {
        this.departure = from;
        return this;
    }

    public RailroadService passingBy(List<Station> stops) {
        this.stops = stops;
        return this;
    }

    public RailroadService arrival(Station to) {
        this.arrival = to;
        return this;
    }

    public Integer queryDistance() {
        Integer distance = 0;
        stops.add(0, departure);
        stops.add(arrival);
        for (int i = 0; i < stops.size() - 1; i++) {
            Station from = stops.get(i);
            Station to = stops.get(i + 1);
            Route route = allRoutes
                    .stream()
                    .filter(f -> f.getFromStation().getName().equals(from.getName()) && f.getToStation().getName().equals(to.getName()))
                    .findFirst()
                    .get();
            distance += route.getDistance();
        }
        return distance;
    }
}

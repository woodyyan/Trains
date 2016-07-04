package com.github.trains;

import com.github.algorithm.TripAlgorithm;

import java.util.List;

public class RailroadService {
    private final List<Route> allRoutes;
    private TripAlgorithm tripAlgorithm;

    public List<Route> getAllRoutes() {
        return allRoutes;
    }

    public RailroadService(List<Route> allRoutes) {
        this.allRoutes = allRoutes;
    }

    public void setTripAlgorithm(TripAlgorithm tripAlgorithm) {
        this.tripAlgorithm = tripAlgorithm;
    }

    public List<Trip> queryTrips(Station startStation, Station endStation) {
        return tripAlgorithm.queryTrips(startStation, endStation);
    }
}

package com.github.trains;

import com.github.algorithm.TripAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class RailroadService {
    private final List<Route> allRoutes;
    private TripAlgorithm tripAlgorithm;

    public RailroadService(List<Route> allRoutes) {
        this.allRoutes = allRoutes;
    }

    public List<Route> getAllRoutes() {
        return allRoutes;
    }

    public void setTripAlgorithm(TripAlgorithm tripAlgorithm) {
        this.tripAlgorithm = tripAlgorithm;
    }

    public List<Trip> queryTrips(Station fromStation, Station toStation) {
        if (tripAlgorithm != null) {
            return tripAlgorithm.queryTrips(fromStation, toStation);
        }

        return new ArrayList<>();
    }
}

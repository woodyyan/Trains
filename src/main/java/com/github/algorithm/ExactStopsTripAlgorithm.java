package com.github.algorithm;

import com.github.trains.Route;
import com.github.trains.Station;
import com.github.trains.Trip;

import java.util.ArrayList;
import java.util.List;

public class ExactStopsTripAlgorithm extends TripAlgorithm {
    private final Integer exactStops;
    private final List<Route> allRoutes;

    public ExactStopsTripAlgorithm(Integer exactStops, List<Route> allRoutes) {
        this.exactStops = exactStops;
        this.allRoutes = allRoutes;
    }

    @Override
    public List<Trip> queryTrips(Station startStation, Station endStation) {
        return new ArrayList<>();
    }
}

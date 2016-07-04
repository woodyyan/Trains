package com.github.algorithm;

import com.github.trains.Route;
import com.github.trains.Station;
import com.github.trains.Trip;

import java.util.ArrayList;
import java.util.List;

public class ExactlyStopsTripAlgorithm extends TripAlgorithm {
    private final Integer exactlyStops;
    private final List<Route> allRoutes;

    public ExactlyStopsTripAlgorithm(Integer exactlyStops, List<Route> allRoutes) {
        this.exactlyStops = exactlyStops;
        this.allRoutes = allRoutes;
    }

    @Override
    public List<Trip> queryTrips(Station fromStation, Station toStation) {
        return new ArrayList<>();
    }
}

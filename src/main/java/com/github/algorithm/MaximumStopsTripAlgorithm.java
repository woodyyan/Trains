package com.github.algorithm;

import com.github.trains.Route;
import com.github.trains.Station;
import com.github.trains.Trip;

import java.util.ArrayList;
import java.util.List;

public class MaximumStopsTripAlgorithm extends TripAlgorithm {

    private final Integer limitStops;
    private final List<Route> allRoutes;

    public MaximumStopsTripAlgorithm(Integer maxStops, List<Route> allRoutes) {
        this.limitStops = maxStops;
        this.allRoutes = allRoutes;
    }

    @Override
    public List<Trip> queryTrips(Station startStation, Station endStation) {

        return new ArrayList<>();
    }
}

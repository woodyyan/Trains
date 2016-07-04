package com.github.algorithm;

import com.github.trains.Route;
import com.github.trains.Station;
import com.github.trains.Trip;

import java.util.ArrayList;
import java.util.List;

public class MaxDistanceTripAlgorithm extends TripAlgorithm {
    private final Integer maxDistance;
    private final List<Route> allRoutes;

    public MaxDistanceTripAlgorithm(Integer maxDistance, List<Route> allRoutes) {
        this.maxDistance = maxDistance;
        this.allRoutes = allRoutes;
    }

    @Override
    public List<Trip> queryTrips(Station startStation, Station endStation) {
        return new ArrayList<>();
    }
}

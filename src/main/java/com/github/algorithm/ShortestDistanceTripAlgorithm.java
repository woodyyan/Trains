package com.github.algorithm;

import com.github.trains.Route;
import com.github.trains.Station;
import com.github.trains.Trip;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceTripAlgorithm extends TripAlgorithm {
    public ShortestDistanceTripAlgorithm(List<Route> allRoutes) {
        super();
    }

    @Override
    public List<Trip> queryTrips(Station startStation, Station endStation) {
        return new ArrayList<>();
    }
}

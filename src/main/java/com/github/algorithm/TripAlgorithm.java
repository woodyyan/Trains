package com.github.algorithm;

import com.github.trains.Station;
import com.github.trains.Trip;

import java.util.List;

public abstract class TripAlgorithm {
    public abstract List<Trip> queryTrips(Station startStation, Station endStation);
}

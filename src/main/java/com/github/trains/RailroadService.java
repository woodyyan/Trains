package com.github.trains;

import com.github.algorithm.TripAlgorithm;

import java.util.List;

public class RailroadService {

    private TripAlgorithm tripAlgorithm;

    public void setTripAlgorithm(TripAlgorithm tripAlgorithm) {
        this.tripAlgorithm = tripAlgorithm;
    }

    public List<Trip> queryTrips(Station startStation, Station endStation) {
        return tripAlgorithm.queryTrips(startStation, endStation);
    }
}
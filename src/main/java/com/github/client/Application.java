package com.github.client;

import com.github.algorithm.MaxDistanceTripAlgorithm;
import com.github.factory.RouteFactory;
import com.github.trains.RailroadService;
import com.github.trains.Route;
import com.github.trains.Station;
import com.github.trains.Trip;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RouteFactory factory = new RouteFactory("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");
        List<Route> allRoutes = factory.getAllRoutes();
        RailroadService railroadService = new RailroadService(allRoutes);
        railroadService.setTripAlgorithm(new MaxDistanceTripAlgorithm(5, null));
        List<Trip> trips = railroadService.queryTrips(new Station(""), new Station(""));

        Station from = new Station("A");
        Station to = new Station("C");
        List<Station> stops = new ArrayList<>();
        stops.add(new Station("B"));
        Integer distance = railroadService.departure(from).passingBy(stops).arrival(to).queryDistance();
        System.out.println(distance);
    }
}
package com.github.client;

import com.github.trains.RailroadService;
import com.github.trains.Route;
import com.github.trains.Station;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Station stationA = new Station("A");
        Station stationB = new Station("B");
        Station stationC = new Station("C");
        Station stationD = new Station("D");
        Station stationE = new Station("E");
        List<Route> allRoutes = new ArrayList<>();
        allRoutes.add(new Route(stationA, stationB, 5));
        allRoutes.add(new Route(stationB, stationC, 4));
        allRoutes.add(new Route(stationC, stationD, 8));
        allRoutes.add(new Route(stationD, stationC, 8));
        allRoutes.add(new Route(stationD, stationE, 6));
        allRoutes.add(new Route(stationA, stationD, 5));
        allRoutes.add(new Route(stationC, stationE, 2));
        allRoutes.add(new Route(stationE, stationB, 3));
        allRoutes.add(new Route(stationA, stationE, 7));

        RailroadService railroadService = new RailroadService(allRoutes);
    }
}
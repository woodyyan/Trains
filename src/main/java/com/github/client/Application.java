package com.github.client;

import com.github.factory.RouteFactory;
import com.github.trains.RailroadService;
import com.github.trains.Route;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RouteFactory factory = new RouteFactory();
        List<Route> allRoutes = factory.getAllRoutes();
        RailroadService railroadService = new RailroadService(allRoutes);
    }
}
package com.github.client;

import com.github.factory.RouteFactory;
import com.github.trains.RailroadService;
import com.github.trains.Route;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RouteFactory factory = new RouteFactory("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");
        List<Route> allRoutes = factory.getAllRoutes();
        RailroadService railroadService = new RailroadService(allRoutes);
    }
}
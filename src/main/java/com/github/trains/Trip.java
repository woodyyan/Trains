package com.github.trains;

import java.util.List;

public class Trip {
    private final List<Route> routes;

    Trip(List<Route> routes) {
        this.routes = routes;

    }

    Integer getDistance() {
        Integer distance = 0;
        for (Route route : routes) {
            distance += route.getDistance();
        }
        return distance;
    }
}
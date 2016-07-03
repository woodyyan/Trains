package com.github.trains;

class Route {
    private final Integer distance;
    private final Station startStation;
    private final Station endStation;

    Integer getDistance() {
        return distance;
    }

    Route(Station startStation, Station endStation, Integer distance) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
    }
}

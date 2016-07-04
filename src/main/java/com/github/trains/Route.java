package com.github.trains;

public class Route {
    private final Integer distance;
    private final Station startStation;
    private final Station endStation;

    public Station getEndStation() {
        return endStation;
    }

    public Station getStartStation() {
        return startStation;
    }

    Integer getDistance() {
        return distance;
    }

    public Route(Station startStation, Station endStation, Integer distance) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
    }
}

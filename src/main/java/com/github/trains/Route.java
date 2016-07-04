package com.github.trains;

public class Route {
    private final Integer distance;
    private final Station fromStation;
    private final Station toStation;

    public Station getToStation() {
        return toStation;
    }

    public Station getFromStation() {
        return fromStation;
    }

    Integer getDistance() {
        return distance;
    }

    public Route(Station fromStation, Station toStation, Integer distance) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.distance = distance;
    }
}

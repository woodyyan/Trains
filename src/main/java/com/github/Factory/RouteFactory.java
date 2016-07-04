package com.github.factory;

import com.github.trains.Route;
import com.github.trains.Station;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class RouteFactory {
    private List<Route> routes;

    public RouteFactory() {
        routes = new ArrayList<>();
    }

    public Route getRoute(Station startStation, Station endStation) throws InvalidParameterException {

        Route result = null;
        for (Route route : routes) {
            if (route.getStartStation().getName().equals(startStation.getName())
                    && route.getEndStation().getName().equals(endStation.getName())) {
                result = route;
                break;
            }
        }

        if (result == null) {
            throw new InvalidParameterException("NO SUCH ROUTE");
        }

        return result;
    }
}

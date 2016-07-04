package com.github.factory;

import com.github.trains.Route;
import com.github.trains.Station;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class RouteFactory {

    private List<Route> routes;

    public RouteFactory(String trainGraph) {
        routes = new ArrayList<>();
        parseGraph(trainGraph);
    }

    public List<Route> getAllRoutes() {
        return routes;
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

    private void parseGraph(String graph) {
        String splitChar = ",";
        String[] items = graph.split(splitChar);
        for (String item : items) {
            String startName = Character.toString(item.charAt(0));
            String endName = Character.toString(item.charAt(1));
            Integer distance = Integer.parseInt(Character.toString(item.charAt(2)));
            Station start = new Station(startName);
            Station end = new Station(endName);
            routes.add(new Route(start, end, distance));
        }
    }
}

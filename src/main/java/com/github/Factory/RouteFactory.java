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

    public Route getRoute(Station from, Station to) throws InvalidParameterException {

        Route result = null;
        for (Route route : routes) {
            if (route.getFromStation().getName().equals(from.getName())
                    && route.getToStation().getName().equals(to.getName())) {
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
            String fromName = Character.toString(item.charAt(0));
            String toName = Character.toString(item.charAt(1));
            Integer distance = Integer.parseInt(Character.toString(item.charAt(2)));
            Station from = new Station(fromName);
            Station to = new Station(toName);
            routes.add(new Route(from, to, distance));
        }
    }
}

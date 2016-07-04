package com.github.trains;

import com.github.trains.Factory.RouteFactory;
import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class TripTest {
    @Test
    public void should_return_distance_9_from_station_A_to_station_B_to_station_C() {
        //given
        List<Route> routes = new ArrayList<>();
        Station stationA = new Station("A");
        Station stationB = new Station("B");
        Station stationC = new Station("C");
        routes.add(new Route(stationA, stationB, 5));
        routes.add(new Route(stationB, stationC, 4));

        //when
        Trip trip = new Trip(routes);
        Integer result = trip.getDistance();

        //then
        Assert.assertThat(result, is(9));
    }

    @Test
    public void should_return_distance_5_from_station_A_to_station_D() {
        //given
        List<Route> routes = new ArrayList<>();
        Station stationA = new Station("A");
        Station stationD = new Station("D");
        routes.add(new Route(stationA, stationD, 5));

        //when
        Trip trip = new Trip(routes);
        Integer result = trip.getDistance();

        //then
        Assert.assertThat(result, is(5));
    }

    @Test
    public void should_return_distance_13_from_station_A_to_station_D_to_station_C() {
        //given
        List<Route> routes = new ArrayList<>();
        Station stationA = new Station("A");
        Station stationD = new Station("D");
        Station stationC = new Station("C");
        routes.add(new Route(stationA, stationD, 5));
        routes.add(new Route(stationD, stationC, 8));

        //when
        Trip trip = new Trip(routes);
        Integer result = trip.getDistance();

        //then
        Assert.assertThat(result, is(13));
    }

    @Test
    public void should_return_distance_22_from_station_A_to_station_E_to_station_B_to_station_C_to_station_D() {
        //given
        List<Route> routes = new ArrayList<>();
        Station stationA = new Station("A");
        Station stationE = new Station("E");
        Station stationB = new Station("B");
        Station stationC = new Station("C");
        Station stationD = new Station("D");
        routes.add(new Route(stationA, stationE, 7));
        routes.add(new Route(stationE, stationB, 3));
        routes.add(new Route(stationB, stationC, 4));
        routes.add(new Route(stationC, stationD, 8));

        //when
        Trip trip = new Trip(routes);
        Integer result = trip.getDistance();

        //then
        Assert.assertThat(result, is(22));
    }

    @Test
    public void should_return_no_such_trip_from_station_A_to_station_E_to_station_D() throws Exception {
        //given
        Station stationA = new Station("A");
        Station stationE = new Station("E");
        Station stationD = new Station("D");

        //when
        String result = "";
        RouteFactory routeFactory = new RouteFactory();
        try {
            Route route1 = routeFactory.getRoute(stationA, stationE);
            Route route2 = routeFactory.getRoute(stationE, stationD);
        } catch (InvalidParameterException ex) {
            result = ex.getMessage();
        }

        //then
        Assert.assertThat(result, is("NO SUCH ROUTE"));
    }
}

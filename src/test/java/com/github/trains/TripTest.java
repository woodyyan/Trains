package com.github.trains;

import org.junit.Assert;
import org.junit.Test;

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
}

package com.github.trains;

import com.github.algorithm.ExactStopsTripAlgorithm;
import com.github.algorithm.MaximumStopsTripAlgorithm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class RailroadServiceTest {
    private List<Route> allRoutes;

    @Before
    public void setUp() {
        Station stationA = new Station("A");
        Station stationB = new Station("B");
        Station stationC = new Station("C");
        Station stationD = new Station("D");
        Station stationE = new Station("E");
        allRoutes = new ArrayList<>();
        allRoutes.add(new Route(stationA, stationB, 5));
        allRoutes.add(new Route(stationB, stationC, 4));
        allRoutes.add(new Route(stationC, stationD, 8));
        allRoutes.add(new Route(stationD, stationC, 8));
        allRoutes.add(new Route(stationD, stationE, 6));
        allRoutes.add(new Route(stationA, stationD, 5));
        allRoutes.add(new Route(stationC, stationE, 2));
        allRoutes.add(new Route(stationE, stationB, 3));
        allRoutes.add(new Route(stationA, stationE, 7));
    }

    @Test
    public void should_return_count_2_when_start_from_station_C_and_pass_less_than_3_stations_to_station_C() {
        //given
        Station startStation = new Station("C");
        Station endStation = new Station("C");

        //when
        RailroadService railroadService = new RailroadService(allRoutes);
        railroadService.setTripAlgorithm(new MaximumStopsTripAlgorithm(3, allRoutes));
        List<Trip> trips = railroadService.queryTrips(startStation, endStation);
        Integer result = trips.size();

        //then
        Assert.assertThat(result, is(2));
    }

    @Test
    public void should_return_count_3_when_start_from_station_A_and_pass_4_stations_to_station_C() {
        //given
        Station startStation = new Station("A");
        Station endStation = new Station("C");

        //when
        RailroadService railroadService = new RailroadService(allRoutes);
        railroadService.setTripAlgorithm(new ExactStopsTripAlgorithm(4, allRoutes));
        List<Trip> trips = railroadService.queryTrips(startStation, endStation);
        Integer result = trips.size();

        //then
        Assert.assertThat(result, is(3));
    }

    @Test
    public void should_return_the_shortest_distance_9_from_station_A_to_station_C() {
        //given
        Station startStation = new Station("A");
        Station endStation = new Station("C");

        //when
        RailroadService railroadService = new RailroadService(allRoutes);
        Trip trip = railroadService.queryShortestTrip(startStation, endStation);
        Integer result = trip.getDistance();

        //then
        Assert.assertThat(result, is(9));
    }
}

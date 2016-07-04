package com.github.trains;

import com.github.algorithm.ExactlyStopsTripAlgorithm;
import com.github.algorithm.MaxDistanceTripAlgorithm;
import com.github.algorithm.MaximumStopsTripAlgorithm;
import com.github.algorithm.ShortestDistanceTripAlgorithm;
import com.github.factory.RouteFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class RailroadServiceTest {
    private RailroadService railroadService;

    @Before
    public void setUp() {
        RouteFactory factory = new RouteFactory("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");
        List<Route> routes = factory.getAllRoutes();
        railroadService = new RailroadService(routes);
    }

    @Test
    public void should_return_count_2_when_start_from_station_C_and_pass_less_than_3_stations_to_station_C() {
        //given
        Station startStation = new Station("C");
        Station endStation = new Station("C");

        //when
        railroadService.setTripAlgorithm(new MaximumStopsTripAlgorithm(3, railroadService.getAllRoutes()));
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
        railroadService.setTripAlgorithm(new ExactlyStopsTripAlgorithm(4, railroadService.getAllRoutes()));
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
        railroadService.setTripAlgorithm(new ShortestDistanceTripAlgorithm(railroadService.getAllRoutes()));
        List<Trip> trips = railroadService.queryTrips(startStation, endStation);
        Integer result = trips.get(0).getDistance();

        //then
        Assert.assertThat(result, is(9));
    }

    @Test
    public void should_return_the_shortest_distance_9_from_station_B_to_station_B() {
        //given
        Station startStation = new Station("B");
        Station endStation = new Station("B");

        //when
        railroadService.setTripAlgorithm(new ShortestDistanceTripAlgorithm(railroadService.getAllRoutes()));
        List<Trip> trips = railroadService.queryTrips(startStation, endStation);
        Integer result = trips.get(0).getDistance();

        //then
        Assert.assertThat(result, is(9));
    }

    @Test
    public void should_return_count_7_from_station_C_and_max_distance_is_less_than_30_to_station_C() {
        //given
        Station startStation = new Station("C");
        Station endStation = new Station("C");

        //when
        railroadService.setTripAlgorithm(new MaxDistanceTripAlgorithm(4, railroadService.getAllRoutes()));
        List<Trip> trips = railroadService.queryTrips(startStation, endStation);
        Integer result = trips.size();

        //then
        Assert.assertThat(result, is(7));
    }
}

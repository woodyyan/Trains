package com.github.trains;

import com.github.factory.RouteFactory;
import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.CoreMatchers.is;

public class RouteTest {

    @Test
    public void should_return_no_such_trip_from_station_A_to_station_E_to_station_D() throws Exception {
        //given
        Station stationA = new Station("A");
        Station stationE = new Station("E");
        Station stationD = new Station("D");

        //when
        String result = "";
        RouteFactory routeFactory = new RouteFactory("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");
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

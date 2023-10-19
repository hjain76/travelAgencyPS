package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DestinationTest {

    @Test
    void ShouldNotAddActivity(){
        Destination d1 = new Destination("Dubai");
        Activity camelRide = new Activity.Builder()
                .name("CamelRide")
                .capacity(1)
                .description("Riding camel in the dessert")
                .destination(d1)
                .cost(5000)
                .build();
        d1.addActivity(camelRide);
        Assertions.assertEquals(1, d1.getActivities().size());
    }

    @Test
    void ShouldAddActivity(){
        Destination d1 = new Destination("Dubai");
        Activity camelRide = new Activity.Builder()
                .name("CamelRide")
                .capacity(1)
                .description("Riding camel in the dessert")
                .destination(d1)
                .cost(5000)
                .build();
        Activity skyDiving = new Activity.Builder()
                .name("SkyDiving")
                .cost(30000)
                .destination(d1)
                .description("Jump from 15000 ft")
                .capacity(2)
                .build();
        d1.addActivity(camelRide);
        d1.addActivity(skyDiving);
        d1.addActivity(skyDiving);
        Assertions.assertEquals(2, d1.getActivities().size());
    }

}

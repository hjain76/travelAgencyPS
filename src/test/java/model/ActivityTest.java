package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActivityTest {

    @Test
    void ShouldReturnTrueWhenActivityIsFull(){
        Activity activity = new Activity.Builder()
                .name("SkyDiving")
                .cost(30000)
                .destination(new Destination("Bahamas"))
                .description("Jump from 15000 ft")
                .capacity(2)
                .build();
        Passenger p1 = new Passenger.Builder().name("Andrew").passengerNumber(5618).membershipType(MembershipType.STANDARD).build();
        Passenger p2 = new Passenger.Builder().name("Lucas").passengerNumber(5619).membershipType(MembershipType.GOLD).build();
        activity.enrollPassenger(p1);
        activity.enrollPassenger(p2);
        Assertions.assertTrue(activity.isFull());
    }

    @Test
    void ShouldReturnFalseWhenActivityIsNotFull(){
        Activity activity = new Activity.Builder()
                .name("SkyDiving")
                .cost(30000)
                .destination(new Destination("Bahamas"))
                .description("Jump from 15000 ft")
                .capacity(2)
                .build();
        Passenger p1 = new Passenger.Builder().name("Andrew").passengerNumber(5618).membershipType(MembershipType.STANDARD).build();
        activity.enrollPassenger(p1);
        Assertions.assertFalse(activity.isFull());
    }

    @Test
    void ShouldEnrollPassenger(){
        Activity activity = new Activity.Builder()
                .name("SkyDiving")
                .cost(30000)
                .destination(new Destination("Bahamas"))
                .description("Jump from 15000 ft")
                .capacity(2)
                .build();
        Passenger p1 = new Passenger.Builder().name("Andrew").passengerNumber(5618).membershipType(MembershipType.STANDARD).build();

        Passenger p2 = new Passenger.Builder().name("Lucas").passengerNumber(5619).membershipType(MembershipType.GOLD).build();

        activity.enrollPassenger(p1);
        activity.enrollPassenger(p2);
        Assertions.assertEquals(2, activity.getEnrolledPassengers().size());
    }

    @Test
    void ShouldNotEnrollPassengerAsFilled(){
        Activity activity = new Activity.Builder()
                .name("SkyDiving")
                .cost(30000)
                .destination(new Destination("Bahamas"))
                .description("Jump from 15000 ft")
                .capacity(1)
                .build();
        Passenger p1 = new Passenger.Builder().name("Andrew").passengerNumber(5618).membershipType(MembershipType.STANDARD).build();

        Passenger p2 = new Passenger.Builder().name("Lucas").passengerNumber(5619).membershipType(MembershipType.GOLD).build();

        activity.enrollPassenger(p1);
        activity.enrollPassenger(p2);
        Assertions.assertEquals(1, activity.getEnrolledPassengers().size());
    }
}

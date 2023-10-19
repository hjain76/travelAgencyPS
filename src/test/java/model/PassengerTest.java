package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PassengerTest {

    @Test
    void ShouldEnrollPassengerForActivity(){
        Activity hiking = new Activity.Builder().name("Hiking").destination(new Destination("Manali")).capacity(2).cost(2000).build();
        Activity climbing = new Activity.Builder().name("Climbing").destination(new Destination("Shimla")).capacity(10).cost(2000).build();

        Passenger p1 = new Passenger.Builder().name("Raj").passengerNumber(123).membershipType(MembershipType.PREMIUM).balance(100).build();
        Passenger p2 = new Passenger.Builder().name("Aniket").passengerNumber(124).membershipType(MembershipType.GOLD).balance(3000.00).build();
        p1.enrollForActivity(hiking);
        p1.enrollForActivity(climbing);
        p2.enrollForActivity(climbing);
        p1.displayPassengerDetails();
        p2.displayPassengerDetails();
        Assertions.assertEquals(2,p1.getEnrolledActivities().size());
    }

    @Test
    void ShouldNotEnrollPassengerAsActivityFull(){
        Activity activity = new Activity.Builder().name("Hiking").destination(new Destination("Manali")).capacity(2).cost(2000.0).build();
        Passenger p1 = new Passenger.Builder().name("Raj").passengerNumber(123).membershipType(MembershipType.PREMIUM).balance(100.0).build();
        p1.enrollForActivity(activity);

        Passenger p2 = new Passenger.Builder().name("Aniket").passengerNumber(124).membershipType(MembershipType.STANDARD).balance(3000.00).build();
        p2.enrollForActivity(activity);

        Passenger p3 = new Passenger.Builder().name("Aarav").passengerNumber(125).membershipType(MembershipType.STANDARD).balance(10000.78).build();
        p3.enrollForActivity(activity);

        Assertions.assertEquals(2,activity.getEnrolledPassengers().size());
    }

    @Test
    void ShouldNotEnrollPassengerAsInsufficientBalance(){
        Activity activity = new Activity.Builder().name("Hiking").destination(new Destination("Manali")).capacity(2).cost(2000.0).build();
        Passenger p1 = new Passenger.Builder().name("Raj").passengerNumber(123).membershipType(MembershipType.PREMIUM).balance(100.0).build();
        p1.enrollForActivity(activity);

        Passenger p2 = new Passenger.Builder().name("Aniket").passengerNumber(124).membershipType(MembershipType.STANDARD).balance(500.0).build();
        p2.enrollForActivity(activity);

        Passenger p3 = new Passenger.Builder().name("Aarav").passengerNumber(125).membershipType(MembershipType.STANDARD).balance(10000.78).build();
        p3.enrollForActivity(activity);

        Assertions.assertEquals(2,activity.getEnrolledPassengers().size());
    }
}

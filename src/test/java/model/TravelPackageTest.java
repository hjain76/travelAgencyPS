package model;

import org.junit.jupiter.api.Test;

class TravelPackageTest {

    @Test
    void ShouldDisplayItineraryDetails(){
        TravelPackage travelPackage = new TravelPackage("Adventure Package", 30);

        Destination bahamas = new Destination("Bahamas");
        Destination dubai = new Destination("Dubai");
        travelPackage.addDestination(bahamas);
        travelPackage.addDestination(dubai);

        Activity skyDiving = new Activity.Builder().name("Sky Diving").cost(30000).capacity(5).destination(dubai).description("Jump from 15000 ft").build();
        Activity safari = new Activity.Builder().name("Safari").cost(1500).capacity(20).destination(bahamas).description("Jungle Safari").build();
        Activity camelRide = new Activity.Builder().name("Camel Ride").cost(3000).capacity(1).destination(dubai).description("Camel Ride in Dessert").build();
        Activity paraGliding = new Activity.Builder().name("Para Gliding").cost(15000).capacity(1).destination(bahamas).description("Para Gliding").build();

        Passenger raj = new Passenger.Builder().name("Raj").passengerNumber(123).membershipType(MembershipType.PREMIUM).balance(100.0).build();
        travelPackage.addPassenger(raj);

        Passenger aniket = new Passenger.Builder().name("Aniket").passengerNumber(124).membershipType(MembershipType.STANDARD).balance(1000000.00).build();
        travelPackage.addPassenger(aniket);

        Passenger aarav = new Passenger.Builder().name("Aarav").passengerNumber(125).membershipType(MembershipType.GOLD).balance(25000.00).build();
        travelPackage.addPassenger(aarav);

        raj.enrollForActivity(skyDiving);
        raj.enrollForActivity(paraGliding);
        aarav.enrollForActivity(skyDiving);
        aniket.enrollForActivity(camelRide);
        aniket.enrollForActivity(safari);

        travelPackage.displayItinerary();
        travelPackage.displayPassengerList();
        aniket.displayPassengerDetails();
        aarav.displayPassengerDetails();
        raj.displayPassengerDetails();
    }
}

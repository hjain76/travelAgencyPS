package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TravelPackage {

    private String name;
    private Integer passengerCapacity;
    private List<Passenger> passengers;
    private Set<Destination> destinations;

    public TravelPackage(String name, Integer passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.passengers = new ArrayList<>();
        this.destinations = new HashSet<>();
    }

    public void displayItinerary(){
        System.out.println("Travel Package : " + name);
        for (Destination destination: destinations) {
            System.out.println("+++++++++++++++++++++++++++++++++++++");
            System.out.println("    Destination : "+ destination.getName());
            for (Activity activity: destination.getActivities()) {
                System.out.println("        Activity : "+activity.getName());
                System.out.println("            Description : "+activity.getDescription());
                System.out.println("            Cost : "+activity.getCost());
                System.out.println("            Capacity : "+activity.getCapacity());
                System.out.println("------------------------------------------");
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++");
        }
    }

    public void displayPassengerList(){
        System.out.println("Travel Package : " + name);
        System.out.println("Passenger Capacity : " + passengerCapacity);
        System.out.println("Number of passengers currently enrolled : " + passengers.size());
        System.out.println("------ Passenger Details -------");
        for(Passenger passenger : passengers){
            System.out.println("Name : " + passenger.getName());
            System.out.println("PRN : "+ passenger.getPassengerNumber());
            System.out.println("--------------------------------");
        }
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Travel package is full, cannot add more passengers.");
        }
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Set<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(Set<Destination> destinations) {
        this.destinations = destinations;
    }
}

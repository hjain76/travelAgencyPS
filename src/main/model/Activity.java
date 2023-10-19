package model;

import java.util.ArrayList;
import java.util.List;

/*
Used Builder Pattern to create Activity Objects as the class could evolve and be more complex
And also there could be a potential use case where we would need to create objects of the Activity Class by using only some of the fields
In that case we might end up creating constructors for every scenario
 */

// An Alternative way is to use @Builder annotation from lombok library which would provide us with the Builder class for the class annotated
public class Activity {

    private final String name;
    private final String description;
    private final double cost;
    private final Integer capacity;
    private final Destination destination;
    private List<Passenger> enrolledPassengers;

    private Activity(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.cost = builder.cost;
        this.capacity = builder.capacity;
        this.destination = builder.destination;
        if(this.destination != null){
            destination.addActivity(this);
        }
        this.enrolledPassengers = new ArrayList<>();
    }


    /*
        Checks whether activity is filled or not
     */
    public boolean isFull() {
        return enrolledPassengers.size() >= capacity;
    }

    /*
        Enroll a passenger by adding it to the list of enrolled passengers
        if the activity is not filled yet
     */
    public void enrollPassenger(Passenger passenger) {
        if (!isFull()) {
            enrolledPassengers.add(passenger);
            passenger.enrollForActivity(this);
        } else {
            System.out.println("Activity is already full.");
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Destination getDestination() {
        return destination;
    }

    public List<Passenger> getEnrolledPassengers() {
        return enrolledPassengers;
    }

    // Builder class
    public static class Builder{

        private String name;
        private String description;
        private double cost;
        private Integer capacity;
        private Destination destination;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder cost(double cost) {
            this.cost = cost;
            return this;
        }

        public Builder capacity(Integer capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder destination(Destination destination) {
            this.destination = destination;
            return this;
        }

        public Activity build(){
            return new Activity(this);
        }

    }
}

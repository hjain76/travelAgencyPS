package model;

import java.util.ArrayList;
import java.util.List;

/*
Used Builder Pattern to create Passenger Objects as the class could evolve and be more complex
Example -- There could be age restrictions for some of the activities.
And also there could be a potential use case where we would need to create objects of the Passenger Class by using only some of the fields
In that case we might end up creating constructors for every scenario.
 */

// An Alternative way is to use @Builder annotation from lombok library which would provide us with the Builder class for the class annotated
public class Passenger {

    private final String name;
    private final int passengerNumber;
    private double balance;
    private final List<Activity> enrolledActivities;
    private final MembershipType membershipType;
    private final Membership membership;

    private Passenger(Builder builder) {
        this.name = builder.name;
        this.passengerNumber = builder.passengerNumber;
        this.membershipType = builder.membershipType;
        this.membership = builder.membership;
        this.balance = builder.balance;
        this.enrolledActivities = new ArrayList<>();
    }

    /*
       A Passenger can enroll for an activity if :
        1. Activity is not filled yet and
        2. Passenger has enough wallet balance to pay for the activity or
        3. Passenger has a PREMIUM membership
     */

    public void enrollForActivity(Activity activity) {
        if (!activity.isFull()) {
            double discountedPrice = membership.calculateEffectivePrice(activity.getCost());
            if (balance >= discountedPrice || membershipType.equals(MembershipType.PREMIUM)) {
                balance -= discountedPrice;
                enrolledActivities.add(activity);
                activity.getEnrolledPassengers().add(this);
            } else {
                System.out.println("Cannot enroll for the activity as their is insufficient balance.");
            }
        } else {
            System.out.println("Cannot enroll for the activity as the activity is already full.");
        }
    }

    public void displayPassengerDetails(){
        System.out.println("--------------------------------");
        System.out.println("Name : " + getName());
        System.out.println("PRN : " + passengerNumber);
        if(balance > 0){
            System.out.println("Current Balance : " + getBalance());
        }
        System.out.println("---------- Activity Details -----------");
        for (Activity activity : enrolledActivities) {
            System.out.println("\tName : " + activity.getName());
            System.out.println("\tDestination : " + activity.getDestination().getName());
            System.out.println("\tCost Incurred : " + membership.calculateEffectivePrice(activity.getCost()));
            System.out.println("--------------------------------");
        }
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getEnrolledActivities() {
        return enrolledActivities;
    }


    public MembershipType getMembershipType() {return membershipType;}

    public Membership getMembership() {return membership;}

    //Builder class
    public static class Builder{

        private String name;
        private int passengerNumber;
        private double balance;
        private MembershipType membershipType;
        private Membership membership;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder passengerNumber(int passengerNumber) {
            this.passengerNumber = passengerNumber;
            return this;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder membershipType(MembershipType membershipType) {
            this.membershipType = membershipType;
            switch (this.membershipType){
                case GOLD -> this.membership = new GoldMembership();
                case PREMIUM -> this.membership = new PremiumMembership();
                case STANDARD -> this.membership = new StandardMembership();
            }
            return this;
        }

        public Passenger build(){
            return new Passenger(this);
        }

    }
}

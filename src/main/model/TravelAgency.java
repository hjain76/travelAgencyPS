package model;

import java.util.ArrayList;
import java.util.List;

public class TravelAgency {

    private String name;
    private List<TravelPackage> travelPackages;

    public TravelAgency(String name) {
        this.name = name;
        this.travelPackages = new ArrayList<>();
    }

    public void addTravelPackage(TravelPackage travelPackage) {
        travelPackages.add(travelPackage);
    }

    public void displayAgencyDetails() {
        System.out.println("Agency Name: " + name);
        System.out.println("Travel Packages:");
        for (TravelPackage travelPackage : travelPackages) {
            System.out.println("---------------------------");
            travelPackage.displayItinerary();
            System.out.println("---------------------------");
        }
    }

    public void displayAvailableActivities(){
        for(TravelPackage travelPackage : travelPackages){
            System.out.println("Travel Package Name : " + travelPackage.getName());
            for(Destination destination : travelPackage.getDestinations()){
                for(Activity activity : destination.getActivities()){
                    int availableSpace = activity.getCapacity() - activity.getEnrolledPassengers().size();
                    if(availableSpace > 0){
                        System.out.println("Activity: " + activity.getName());
                        System.out.println("Destination: " + activity.getDestination().getName());
                        System.out.println("Available Spaces: " + availableSpace);
                        System.out.println("------------");
                    }
                }
            }
        }
    }
}

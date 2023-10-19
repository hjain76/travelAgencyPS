package model;

import java.util.ArrayList;
import java.util.List;

public class Destination {

    private final String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    /*
    * Adding activity to a destination by ensuring that the activity does not already belong
    * to a destination
    */
    public void addActivity(Activity activity) {
        if(!activities.contains(activity)){
            activities.add(activity);
        }else{
            System.out.println("Activity : " + activity.getName() + " already belongs to a destination.");
        }
    }

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }
}

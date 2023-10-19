package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PremiumMembershipTest {

    @Test
    void testGetEffectivePrice(){
        Activity activity = new Activity.Builder().name("Hiking").cost(1000).build();
        Passenger p1 = new Passenger.Builder().name("Raj").membershipType(MembershipType.PREMIUM).balance(100).build();
        Assertions.assertEquals(0.0,p1.getMembership().calculateEffectivePrice(activity.getCost()));
    }
}

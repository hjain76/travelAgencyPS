package model;

public class PremiumMembership implements Membership{
    /*
    Calculating effective price by free access for the PREMIUM membership
     */
    @Override
    public double calculateEffectivePrice(double basePrice) {
        return 0.0;
    }
}

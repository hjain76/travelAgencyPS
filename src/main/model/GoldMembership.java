package model;

public class GoldMembership implements Membership{

    /*
    Calculating effective price by giving 10% discount for the GOLD membership
     */
    @Override
    public double calculateEffectivePrice(double basePrice) {
        return basePrice - 0.1 * basePrice;
    }
}

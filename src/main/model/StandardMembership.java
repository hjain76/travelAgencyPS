package model;

public class StandardMembership implements Membership{
    /*
    Standard membership does not provide any discount
     */
    @Override
    public double calculateEffectivePrice(double basePrice) {
        return basePrice;
    }
}

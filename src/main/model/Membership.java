package model;

/*
Intuition - As we have to change the discounting methodology at runtime depending on
the type of membership.

Therefore, I have used strategy pattern which addresses that use case drawn from the
analogy of discounting strategies
 */
public interface Membership {

    double calculateEffectivePrice(double basePrice);
}

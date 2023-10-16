package model.rules;

  /**
   * Soft 17 rule. Dealer has to take another card if the score is 17 and contains an ace.
   *
   */
  public class SoftSeventeenStrategy implements HitStrategy {
    private static final int hitLimit = 17;

    public boolean doHit(model.Player a_dealer) {
      if (a_dealer.calcScore() == hitLimit) {
        for (model.Card c : a_dealer.getHand()) {
          if (c.getValue() == model.Card.Value.Ace) {
            return true;
          }
        }
      }
      return a_dealer.calcScore() <= hitLimit;
    }
  }
  
  


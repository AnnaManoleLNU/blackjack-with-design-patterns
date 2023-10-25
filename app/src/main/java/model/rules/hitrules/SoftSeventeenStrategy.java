package model.rules.hitrules;

/**
 * Soft 17 rule. Dealer has to take another card if the score is 17 and contains
 * an ace.
 *
 */
public class SoftSeventeenStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  /**
   * Check if the dealer should take another card.
   *
   * @param dealer The dealer to check.
   * @return true if the dealer should take another card, false otherwise.
   */
  public boolean doHit(model.Player dealer) {
    if (dealer.calcScore() == hitLimit) {
      for (model.Card c : dealer.getHand()) {
        if (c.getValue() == model.Card.Value.Ace) {
          return true;
        }
      }
    }
    return dealer.calcScore() <= hitLimit;
  }
}

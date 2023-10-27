package model.rules.hitrules;

import model.Player;
import model.rules.RuleVisitor;

/**
 * Rule interface that encapsulates when a player (the dealer) should take more cards.
 */
public interface HitStrategy {
  /**
   * Checks if the player (dealer) should take more cards.

   * @param dealer the player to check.
   * @return True if the rule decided the player should take another card.
   */
  boolean doHit(Player dealer);

  void accept(RuleVisitor visitor);
}
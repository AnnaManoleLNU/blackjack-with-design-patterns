package model.rules.hitrules;

import model.Player;

/**
 * Basic hit strategy.
 */
public class BasicHitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    return dealer.calcScore() < hitLimit;
  }
}
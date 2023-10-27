package model.rules.hitrules;

import model.Player;
import model.rules.RuleVisitor;

/**
 * Basic hit strategy.
 */
public class BasicHitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    return dealer.calcScore() < hitLimit;
  }

  @Override
  public void accept(RuleVisitor visitor) {
    visitor.visit(this);
  }
}
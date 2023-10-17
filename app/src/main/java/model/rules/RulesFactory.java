package model.rules;

import model.rules.gamerules.AmericanNewGameStrategy;
import model.rules.gamerules.NewGameStrategy;
import model.rules.hitrules.HitStrategy;
import model.rules.hitrules.SoftSeventeenStrategy;
import model.rules.winrules.EqualScoreDealerWins;
import model.rules.winrules.WinCondition;

/**
 * Creates concrete rules.
 */
public class RulesFactory {

  /**
   * Creates the rule to use for the dealer's hit behavior.

   * @return The rule to use
   */
  public HitStrategy getHitRule() {
    return new SoftSeventeenStrategy(); // new BasicHitStrategy();
  }

  /**
   * Creates the rule to use when starting a new game.

   * @return The rule to use.
   */
  public NewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy(); // new InternationalNewGameStrategy();
  }

  public WinCondition getWinCondition() {
    return new EqualScoreDealerWins(); 
    // return new EqualScorePlayerWins();
  }
}
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
public class AmericanSoftSeventeenDealerWinFactory implements RulesAbstractFactory {
  public NewGameStrategy createNewGameStrategy() {
    return new AmericanNewGameStrategy();
  }
  
  public HitStrategy createHitStrategy() {
    return new SoftSeventeenStrategy();
  }

  public WinCondition createWinCondition() {
    return new EqualScoreDealerWins();
  }
}

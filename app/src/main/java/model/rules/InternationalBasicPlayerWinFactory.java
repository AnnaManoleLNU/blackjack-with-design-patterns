package model.rules;

import model.rules.gamerules.InternationalNewGameStrategy;
import model.rules.gamerules.NewGameStrategy;
import model.rules.hitrules.BasicHitStrategy;
import model.rules.hitrules.HitStrategy;
import model.rules.winrules.EqualScorePlayerWins;
import model.rules.winrules.WinCondition;

/**
 * Creates concrete rules.
 */
public class InternationalBasicPlayerWinFactory implements RulesAbstractFactory {
  public NewGameStrategy createNewGameStrategy() {
    return new InternationalNewGameStrategy();
  }
  
  public HitStrategy createHitStrategy() {
    return new BasicHitStrategy();
  }

  public WinCondition createWinCondition() {
    return new EqualScorePlayerWins();
  }
}

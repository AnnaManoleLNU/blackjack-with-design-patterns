package model.rules;

import model.rules.gamerules.NewGameStrategy;
import model.rules.hitrules.HitStrategy;
import model.rules.winrules.WinCondition;


/**
 * Creates concrete rules.
 */
public interface RulesAbstractFactory {
  HitStrategy createHitStrategy();

  NewGameStrategy createNewGameStrategy();

  WinCondition createWinCondition();
}

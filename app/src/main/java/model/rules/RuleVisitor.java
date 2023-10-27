package model.rules;

import model.rules.gamerules.AmericanNewGameStrategy;
import model.rules.gamerules.InternationalNewGameStrategy;
import model.rules.hitrules.BasicHitStrategy;
import model.rules.hitrules.SoftSeventeenStrategy;
import model.rules.winrules.EqualScoreDealerWins;
import model.rules.winrules.EqualScorePlayerWins;

/**
 * Visitor interface for the rules. Visit each rule.
 */
public interface RuleVisitor {
  
  void visit(AmericanNewGameStrategy americanNewGameStrategy);

  void visit(InternationalNewGameStrategy internationalNewGameStrategy);
  
  void visit(BasicHitStrategy basicHitStrategy);

  void visit(SoftSeventeenStrategy softSeventeenHitStrategy);

  void visit(EqualScoreDealerWins equalScoreDealerWins);

  void visit(EqualScorePlayerWins equalScorePlayerWins);
}

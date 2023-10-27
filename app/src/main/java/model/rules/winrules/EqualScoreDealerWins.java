package model.rules.winrules;

import model.rules.RuleVisitor;

/**
 * Class that implements the win condition where the dealer wins on equal score.
 *
 */
public class EqualScoreDealerWins implements WinCondition {
  
  /**
   * Dealer wins on equal score.
   *
   * @param dealerScore The dealer's score.
   * @param playerScore The player's score.
   * @param maxScore The maximum score.
   */
  public boolean isDealerWinner(int dealerScore, int playerScore, int maxScore) {
    // Look if the player bust first. Dealer wins.
    if (playerScore > maxScore) {
      return true;
    // Then look if the dealer bust. Player wins.
    } else if (dealerScore > maxScore) {
      return false;
    // Then look if the scores are equal. Dealer wins.
    } else if (dealerScore == playerScore) {
      return true;
    }

    // Check if the dealer has a score higher than the player.
    return dealerScore > playerScore;
  }

  @Override
  public void accept(RuleVisitor visitor) {
    visitor.visit(this);
  }
}

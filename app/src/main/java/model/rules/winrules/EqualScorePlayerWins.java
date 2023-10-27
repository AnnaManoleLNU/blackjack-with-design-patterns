package model.rules.winrules;

import model.rules.RuleVisitor;

/**
 * Class that implements the win condition where the player wins on equal score.
 *
 */
public class EqualScorePlayerWins implements WinCondition {
  
  /**
   * Player wins on equal score.
   *
   * @param dealerScore The dealer's score.
   * @param playerScore The player's score.
   * @param maxScore The maximum score.
   */
  public boolean isDealerWinner(int dealerScore, int playerScore, int maxScore) {
    // Look if the dealer bust first. Player wins.
    if (dealerScore > maxScore) {
      return false; 
    // Then look if the player bust. Dealer wins.
    } else if (playerScore > maxScore) {
      return true; 
    // Then look if the scores are equal. Player wins.
    } else if (dealerScore == playerScore) {
      return false;
    }

    // Check if the player has a score higher than the dealer.
    return dealerScore > playerScore;
  }

  @Override
  public void accept(RuleVisitor visitor) {
    visitor.visit(this);
  }
}

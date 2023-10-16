package model.rules;

public class EqualScoreDealerWins implements WinCondition {
  
  /**
   * Dealer wins on equal score.
   *
   * @param dealerScore The dealer's score.
   * @param playerScore The player's score.
   * @param maxScore The maximum score.
   */
  public boolean isDealerWinner(int dealerScore, int playerScore, int maxScore) {
    if (playerScore > maxScore) {
      return true;
    } else if (dealerScore > maxScore) {
      return false;
    }
    return dealerScore >= playerScore;
  }
}

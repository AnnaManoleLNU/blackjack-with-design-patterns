package model.rules;

public class EqualScorePlayerWins implements WinCondition {
  
  /**
   * Player wins on equal score.
   *
   * @param dealerScore The dealer's score.
   * @param playerScore The player's score.
   * @param maxScore The maximum score.
   */
  public boolean isDealerWinner(int dealerScore, int playerScore, int maxScore) {
    if (playerScore > maxScore) {
      return false;
    } else if (dealerScore > maxScore) {
      return true;
    }
    return playerScore >= dealerScore;
  }
}

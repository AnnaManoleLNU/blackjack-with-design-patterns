package model.rules;

public class EqualScoreDealerWins implements WinCondition {
  
  // rule for who wins the game. Change who wins on an equal score. In one variant the dealer wins on equal score, in another the player wins on equal score.
  public boolean isDealerWinner(int dealerScore, int playerScore, int maxScore) {
    if (playerScore > maxScore) {
      return true;
    } else if (dealerScore > maxScore) {
      return false;
    }
    return dealerScore >= playerScore;
  }
}

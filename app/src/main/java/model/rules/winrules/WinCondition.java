package model.rules.winrules;

/**
 * Interface for the win condition.
 *
 */
public interface WinCondition {
  
  /**
   * Rule on who wins on equal score. Dealer or player.
   *
   * @param dealerScore The dealer's score.
   * @param playerScore The player's score.
   * @param maxScore The maximum score.
   */
  boolean isDealerWinner(int dealerScore, int playerScore, int maxScore);
}

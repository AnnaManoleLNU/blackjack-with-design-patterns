package model.rules;

public interface WinCondition {
  
  // rule for who wins the game. Change who wins on an equal score. In one variant the dealer wins on equal score, in another the player wins on equal score.
  boolean isDealerWinner(int dealerCore, int playerScore, int maxScore);
}

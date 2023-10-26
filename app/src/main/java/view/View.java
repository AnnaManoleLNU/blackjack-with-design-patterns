package view;

import model.Game;

/**
 * Encapsulates the generic view functionality.
 */
public interface View {

  /**
   * Represents the different actions that can be performed by the player.
   */
  public enum GameAction {
    Play,
    Hit,
    Stand,
    Quit
  }

  /**
   * Shows a welcome message.
   */
  void displayWelcomeMessage();

  /**
   * Returns pressed characters from the keyboard.

   * @return the pressed character.
   */
  GameAction getInput();
  

  /**
   * Displays a card.

   * @param card The card to display.
   */
  void displayCard(model.Card card);

  /**
   * Displays the cards and score of the player.

   * @param hand the player's hand.
   * @param score the player's score.
   */
  void displayPlayerHand(Iterable<model.Card> hand, int score);

  /**
   * Displays the cards and score of the dealer.

   * @param hand the dealer's score.
   * @param score the players's score.
   */
  void displayDealerHand(Iterable<model.Card> hand, int score);

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  void displayGameOver(boolean dealerIsWinner);

  void redrawUi(Game game);

  abstract void accept(ViewVisitor visitor);

}
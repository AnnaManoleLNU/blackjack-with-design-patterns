package view;

import model.Card;
import model.Game;

/**
 * Implements an english console view.
 */
public class EnglishView implements View {

  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }
    System.out.println("Hello Black Jack World");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  /**
   * Returns pressed characters from the keyboard.

   * @return the pressed character.
   */
  public GameAction getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      switch (c) {
        case 'p':
          return GameAction.Play;
        case 'h':
          return GameAction.Hit;
        case 's':
          return GameAction.Stand;
        case 'q':
          return GameAction.Quit;
        default:
          return getInput();
      }
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return null;
    }
  }

  public void displayCard(model.Card card) {
    System.out.println("" + card.getValue() + " of " + card.getColor());
  }

  public void displayCardForRedraw(model.Card card) {
    System.out.print("" + card.getValue() + " of " + card.getColor());
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Player", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Dealer", hand, score);
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Has: ");
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Score: " + score);
    System.out.println("");
  }

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("GameOver: ");
    if (dealerIsWinner) {
      System.out.println("Dealer Won!");
    } else {
      System.out.println("You Won!");
    }

  }

  @Override
  public void redrawUi(Game game) {
    System.out.println();

    System.out.print("Dealer: ");
    for (Card card : game.getDealerHand()) {
      if (game.getLastDealerCard() == card) {
        displayCardForRedraw(card);
      } else {
        displayCardForRedraw(card);
        System.out.print(", ");
      } 
    }

    System.out.println();

    System.out.print("Player: ");
    for (Card card : game.getPlayerHand()) {
      if (game.getLastPlayerCard() == card) {
        displayCardForRedraw(card);
      } else {
        displayCardForRedraw(card);
        System.out.print(", ");
      } 
    }
  }
}

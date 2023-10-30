package view;

import model.Card;
import model.Game;
import model.rules.gamerules.AmericanNewGameStrategy;
import model.rules.gamerules.InternationalNewGameStrategy;
import model.rules.hitrules.BasicHitStrategy;
import model.rules.hitrules.SoftSeventeenStrategy;
import model.rules.winrules.EqualScoreDealerWins;
import model.rules.winrules.EqualScorePlayerWins;

/**
 * Encapsulates the generic view functionality. The language based messages are
 * implemented in the subclasses.
 */
public abstract class BaseView implements View {

  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }
    displayLanguageBasedMessage();
  }

  protected abstract void displayLanguageBasedMessage();

  /**
   * Returns pressed characters from the keyboard.
   *
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

  public String displayCard(model.Card card) {
    return card.getValue() + " of " + card.getColor();
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand(getPlayerString(), hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand(getDealerString(), hand, score);
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println();
    System.out.println(name + " " + getHasString() + " " + score);
    for (model.Card c : hand) {
      System.out.println(displayCard(c));
    }
    System.out.println(getScoreString() + " " + score);
    System.out.println("");
  }

  /**
   * Displays the winner of the game.
   *
   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    displayGameOverMessage();
    if (dealerIsWinner) {
      displayDealerWinsMessage();
    } else {
      displayPlayerWinsMessage();
    }
  }

  /**
   * Redraws the UI, by displaying the last card that was dealt, one for the dealer and one for the player.
   *
   * @param game The game object.
   */
  public void redrawUi(Game game) {
    System.out.println();

    System.out.print(getDealerString() + ": ");
    for (Card card : game.getDealerHand()) {
      if (game.getLastDealerCard() == card) {
        System.out.print(displayCard(card));
      } else {
        System.out.print(displayCard(card) + ", ");
      } 
    }

    System.out.println();

    System.out.print(getPlayerString() + ": ");
    for (Card card : game.getPlayerHand()) {
      if (game.getLastPlayerCard() == card) {
        System.out.print(displayCard(card));
      } else {
        System.out.print(displayCard(card) + ", ");
      } 
    }
  }

  public void visit(AmericanNewGameStrategy americanNewGameStrategy) {
    displayAmericanNewGameStrategy();
  }

  public void visit(InternationalNewGameStrategy internationalNewGameStrategy) {
    displayInternationalNewGameStrategy();
  }

  public void visit(BasicHitStrategy basicHitStrategy) {
    displayBasicHitStrategy();
  }

  public void visit(SoftSeventeenStrategy softSeventeenHitStrategy) {
    displaySoftSeventeenStrategy();
  }

  public void visit(EqualScoreDealerWins equalScoreDealerWins) {
    displayEqualScoreDealerWins();
  }

  public void visit(EqualScorePlayerWins equalScorePlayerWins) {
    displayEqualScorePlayerWins();
  }

  protected abstract void displayGameOverMessage();

  protected abstract void displayDealerWinsMessage();

  protected abstract void displayPlayerWinsMessage();

  protected abstract void displayAmericanNewGameStrategy();

  protected abstract void displayInternationalNewGameStrategy();

  protected abstract void displayBasicHitStrategy();

  protected abstract void displaySoftSeventeenStrategy();

  protected abstract void displayEqualScoreDealerWins();

  protected abstract void displayEqualScorePlayerWins();

  protected abstract String getPlayerString();

  protected abstract String getDealerString();

  protected abstract String getHasString();

  protected abstract String getScoreString();

}

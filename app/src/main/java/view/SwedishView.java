package view;

import model.Card;
import model.Game;

/**
 * Implements a Swedish console view.
 */
public class SwedishView extends BaseView {

  /**
   * Displays welcome message according to the language.
   */
  public void displayLanguageBasedMessage() {
    System.out.println("Hej Black Jack Världen");
    System.out.println("----------------------");
    System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
  }

  /**
   * Displays a card.

   * @param card The card to display.
   */
  public void displayCard(model.Card card) {
    if (card.getColor() == model.Card.Color.Hidden) {
      System.out.println("Dolt Kort");
    } else {
      String[] colors = { "Hjärter", "Spader", "Ruter", "Klöver" };
      String[] values = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio",
                          "knekt", "dam", "kung", "ess" };
      System.out.println("" + colors[card.getColor().ordinal()] + " " + values[card.getValue().ordinal()]);
    }
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Spelare", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Croupier", hand, score);
  }

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("Slut: ");
    if (dealerIsWinner) {
      System.out.println("Croupiern Vann!");
    } else {
      System.out.println("Du vann!");
    }
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println();
    System.out.println(name + " Har: " + score);
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Poäng: " + score);
    System.out.println("");
  }

  @Override
  public void redrawUi(Game game) {
    System.out.println();

    System.out.print("Croupier: ");
    for (Card card : game.getDealerHand()) {
      displayCard(card);
    }

    System.out.println();

    System.out.print("Spelare: ");
    for (Card card : game.getPlayerHand()) {
      displayCard(card);
    }
  }

  public void displayAmericanNewGameStrategy() {
    System.out.print("Använder Amerikansk Spelstrategi. ");
  }

  public void displayInternationalNewGameStrategy() {
    System.out.println("Använder Internationell Spelstrategi. ");
  }

  public void displayBasicHitStrategy() {
    System.out.println("Använder Grundläggande Träffstrategi. ");
  }

  public void displaySoftSeventeenStrategy() {
    System.out.println("Använder Soft Seventeen Strategi. ");
  }

  public void displayEqualScoreDealerWins() {
    System.out.println("Croupier vinner vid lika poäng. ");
  }

  public void displayEqualScorePlayerWins() {
    System.out.println("Spelare vinner vid lika poäng. ");
  }

}

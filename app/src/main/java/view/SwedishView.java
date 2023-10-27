package view;

import model.Card;
import model.Game;

/**
 * Implements a Swedish console view.
 */
public class SwedishView implements View {

  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }

    System.out.println("Hej Black Jack Världen");
    System.out.println("----------------------");
    System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
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

  @Override
  public void visit(model.rules.gamerules.AmericanNewGameStrategy americanNewGameStrategy) {
    System.out.println("Använder American New Game Strategy. ");
  }

  @Override
  public void visit(model.rules.gamerules.InternationalNewGameStrategy internationalNewGameStrategy) {
    System.out.println("Använder International New Game Strategy. ");
  }

  @Override
  public void visit(model.rules.hitrules.BasicHitStrategy basicHitStrategy) {
    System.out.println("Använder Basic Hit Strategy. ");
  }

  @Override
  public void visit(model.rules.hitrules.SoftSeventeenStrategy softSeventeenHitStrategy) {
    System.out.println("Använder Soft Seventeen Hit Strategy. ");
  }

  @Override
  public void visit(model.rules.winrules.EqualScoreDealerWins equalScoreDealerWins) {
    System.out.println("Använder Equal Score Dealer Wins Rule. ");
  }

  @Override
  public void visit(model.rules.winrules.EqualScorePlayerWins equalScorePlayerWins) {
    System.out.println("Använder Equal Score Player Wins Rule. ");
  }

  

}

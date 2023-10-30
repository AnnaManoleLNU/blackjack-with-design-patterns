package view;

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
   *
   * @param card The card to display.
   */
  public String displayCard(model.Card card) {
    if (card.getColor() == model.Card.Color.Hidden) {
      return "Dolt Kort";
    } else {
      String[] colors = { "Hjärter", "Spader", "Ruter", "Klöver" };
      String[] values = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio",
          "knekt", "dam", "kung", "ess" };
      return colors[card.getColor().ordinal()] + " " + values[card.getValue().ordinal()];
    }
  }

  public void displayGameOverMessage() {
    System.out.println("Slut! ");
  }

  public void displayDealerWinsMessage() {
    System.out.println("Croupiern Vann!");
  }

  public void displayPlayerWinsMessage() {
    System.out.println("Du vann!");
  }

  protected String getPlayerString() {
    return "Spelare";
  }

  protected String getDealerString() {
    return "Croupier";
  }

  protected String getHasString() {
    return "Har:";
  }

  protected String getScoreString() {
    return "Poäng:";
  }

  public void displayAmericanNewGameStrategy() {
    System.out.print("Använder Amerikansk Spelstil. ");
  }

  public void displayInternationalNewGameStrategy() {
    System.out.print("Använder Internationell Spelstil. ");
  }

  public void displayBasicHitStrategy() {
    System.out.print("Använder Grundläggande Träffstrategi. ");
  }

  public void displaySoftSeventeenStrategy() {
    System.out.print("Använder Soft Seventeen Strategi. ");
  }

  public void displayEqualScoreDealerWins() {
    System.out.println("Croupier vinner vid lika poäng.");
  }

  public void displayEqualScorePlayerWins() {
    System.out.println("Spelare vinner vid lika poäng.");
  }

}

package view;

/**
 * Implements an english console view.
 */
public class EnglishView extends BaseView {

  /**
   * Displays welcome message according to the language.
   */
  public void displayLanguageBasedMessage() {
    System.out.println("Hello Black Jack World");
    System.out.println("----------------------");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  protected String getPlayerString() {
    return "Player";
  }

  protected String getDealerString() {
    return "Dealer";
  }

  protected String getHasString() {
    return "Has:";
  }

  protected String getScoreString() {
    return "Score:";
  } 

  public void displayGameOverMessage() {
    System.out.println("Game Over! ");
  }

  public void displayDealerWinsMessage() {
    System.out.println("Dealer Won!");
  }

  public void displayPlayerWinsMessage() {
    System.out.println("You Won!");
  }

  public void displayAmericanNewGameStrategy() {
    System.out.print("Using American game style. ");
  }

  public void displayInternationalNewGameStrategy() {
    System.out.print("Using International game style. ");
  }

  public void displayBasicHitStrategy() {
    System.out.print("Using Basic Hit Strategy. ");
  }

  public void displaySoftSeventeenStrategy() {
    System.out.print("Using Soft Seventeen Strategy. ");
  }

  public void displayEqualScoreDealerWins() {
    System.out.println("Dealer wins on equal score.");
  }

  public void displayEqualScorePlayerWins() {
    System.out.println("Player wins on equal score.");
  }
}

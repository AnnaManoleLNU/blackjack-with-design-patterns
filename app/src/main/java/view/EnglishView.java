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

  public void displayAmericanNewGameStrategy() {
    System.out.println("American Strategy. ");
  }

  public void displayInternationalNewGameStrategy() {
    System.out.println("International Strategy. ");
  }

  public void displayBasicHitStrategy() {
    System.out.println("Basic Hit Strategy. ");
  }

  public void displaySoftSeventeenStrategy() {
    System.out.println("Soft Seventeen Strategy. ");
  }

  public void displayEqualScoreDealerWins() {
    System.out.println("Equal Score Dealer Wins. ");
  }

  public void displayEqualScorePlayerWins() {
    System.out.println("Equal Score Player Wins. ");
  }
}

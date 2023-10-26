package model;

import model.rules.RulesAbstractFactory;
import model.rules.gamerules.NewGameStrategy;
import model.rules.hitrules.HitStrategy;
import model.rules.winrules.WinCondition;

/**
 * Represents a dealer player that handles the deck of cards and runs the game using rules.
 */
public class Dealer extends Player {

  private Deck deck;
  private RulesAbstractFactory rulesFactory;
  private HitStrategy hitStrategy;
  private NewGameStrategy newGameStrategy;
  private WinCondition winCondition;

  /**
   * Initializing constructor.

   * @param rulesFactory A factory that creates the rules to use.
   */
  public Dealer(RulesAbstractFactory rulesFactory) {
    this.rulesFactory = rulesFactory;
    hitStrategy = rulesFactory.createHitStrategy();
    newGameStrategy = rulesFactory.createNewGameStrategy();
    winCondition = rulesFactory.createWinCondition();
  }

  /**
   * Starts a new game if the game is not currently under way.

   * @param player The player to play against.
   * @return True if the game could be started.
   */
  public boolean newGame(Player player) {
    if (deck == null || isGameOver()) {
      deck = new Deck();
      clearHand();
      player.clearHand();
      return newGameStrategy.newGame(deck, this, player);
    }
    return false;
  }

  /**
   * Gives the player one more card if possible. I.e. the player hits.

   * @param player The player to give a card to.
   * @return true if the player could get a new card, false otherwise.
   */
  public boolean hit(Player player) {
    if (deck != null && player.calcScore() < maxScore && !isGameOver()) {
      Card.Mutable c;
      c = deck.getCard();
      c.show(true);
      player.dealCard(c);
      return true;
    }
    return false;
  }

  /**
   * Checks if the dealer is the winner compared to a player.

   * @param player The player to check against.
   * @return True if the dealer is the winner, false if the player is the winner.
   */
  public boolean isDealerWinner(Player player) {
    return winCondition.isDealerWinner(calcScore(), player.calcScore(), maxScore);
  }

  /**
   * Checks if the game is over, i.e. the dealer can take no more cards.

   * @return True if the game is over.
   */
  public boolean isGameOver() {
    if (deck != null && hitStrategy.doHit(this) != true) {
      return true;
    }
    return false;
  }

  /**
   * The player has choosen to take no more cards, it is the dealers turn.
   */
  public boolean stand(Player player) {
    if (deck != null) {
      showHand();
      while (rulesFactory.createHitStrategy().doHit(this)) {
        Card.Mutable c;
        c = deck.getCard();
        c.show(true);
        dealCard(c);
      }
      return true;
    }
    
    return false;
  }

}
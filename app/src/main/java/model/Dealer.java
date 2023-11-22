package model;

import model.rules.RulesFactory;
import model.rules.gamerules.CardDealerUtil;
import model.rules.gamerules.NewGameStrategy;
import model.rules.hitrules.HitStrategy;
import model.rules.winrules.WinCondition;

/**
 * Represents a dealer player that handles the deck of cards and runs the game using rules.
 */
public class Dealer extends Player {

  private Deck deck;
  private NewGameStrategy newGameRule;
  private HitStrategy hitRule;
  private WinCondition winCondition;
  private CardDealerUtil cardDealer;

  /**
   * Initializing constructor.

   * @param rulesFactory A factory that creates the rules to use.
   */
  public Dealer(RulesFactory rulesFactory) {
    newGameRule = rulesFactory.getNewGameRule();
    hitRule = rulesFactory.getHitRule();
    winCondition = rulesFactory.getWinCondition();
    this.cardDealer = new CardDealerUtil();
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
      return newGameRule.newGame(deck, this, player);
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
      cardDealer.dealCard(deck, player, true);
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
    if (deck != null && hitRule.doHit(this) != true) {
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
      while (hitRule.doHit(this)) {
        cardDealer.dealCard(deck, this, true);
      }
      return true;
    }   
    return false;
  }

}
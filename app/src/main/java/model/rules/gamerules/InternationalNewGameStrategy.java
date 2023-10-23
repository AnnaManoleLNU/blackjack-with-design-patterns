package model.rules.gamerules;

import model.Dealer;
import model.Deck;
import model.Player;

/**
 * The International version of the game has the dealer deal themselves only one card face up.
 */
public class InternationalNewGameStrategy extends BaseNewGameStrategy {

  /**
   * Deal two cards to the player and one card to the dealer (face up).
   *
   * @param deck The deck to deal cards from.
   * @param dealer The dealer to deal cards to.
   * @param player The player to deal cards to.
   * @return true
   */
  public boolean newGame(Deck deck, Dealer dealer, Player player) {
    dealCardToPlayer(deck, player, true);
    dealCardToDealer(deck, dealer, true);
    dealCardToPlayer(deck, player, true);
    return true;
  }
}
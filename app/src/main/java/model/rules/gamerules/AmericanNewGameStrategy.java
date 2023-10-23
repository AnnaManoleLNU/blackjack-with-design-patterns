package model.rules.gamerules;

import model.Dealer;
import model.Deck;
import model.Player;

/**
 * The American version of the game has the dealer deal themselves a second card face down.
 */
public class AmericanNewGameStrategy extends BaseNewGameStrategy {

  /**
   * Deal two cards to the player and two cards to the dealer (one face down to dealer).
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
    dealCardToDealer(deck, dealer, false);

    return true;
  }
}
package model.rules.gamerules;

import model.Card;
import model.Deck;
import model.Player;

/**
 * Utility class for dealing cards.
 */
public class CardDealerUtil {

  /**
   * Deals a card from the deck to a player.
   * 
   * @param deck   The deck to deal from.
   * @param player The player to deal the card to.
   * @param show   Whether the card should be shown or hidden.
   */
  public void dealCard(Deck deck, Player player, boolean show) {
    Card.Mutable c = deck.getCard();
    c.show(show);
    player.dealCard(c);
  }
}

package model.rules.gamerules;

import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;

/**
 * Template method pattern. Subclasses implement the method from the interface - newGame().
 */
public abstract class BaseNewGameStrategy implements NewGameStrategy {

  protected void dealCardToPlayer(Deck deck, Player player, boolean show) {
    dealCard(deck, player, show);
  }

  protected void dealCardToDealer(Deck deck, Dealer dealer, boolean show) {
    dealCard(deck, dealer, show);
  }

  private void dealCard(Deck deck, Player player, boolean show) {
    Card.Mutable c;
    c = deck.getCard();
    c.show(show);
    player.dealCard(c);
  }
  
}

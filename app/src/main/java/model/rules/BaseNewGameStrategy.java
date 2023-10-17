package model.rules;

import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;

public abstract class BaseNewGameStrategy implements NewGameStrategy {

  protected void dealCard(Deck deck, Dealer dealer, Player player, boolean showToPlayer, boolean... showToDealer) {
    Card.Mutable c;

    c = deck.getCard();
    c.show(showToPlayer);
    player.dealCard(c);

    for (boolean show : showToDealer) {
      c = deck.getCard();
      c.show(show);
      dealer.dealCard(c);
    }
  }
}

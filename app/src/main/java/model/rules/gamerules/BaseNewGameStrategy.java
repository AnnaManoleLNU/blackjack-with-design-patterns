package model.rules.gamerules;

import model.Dealer;
import model.Deck;
import model.Player;

/**
 * Template method pattern. Subclasses implement the method from the interface - newGame().
 */
public abstract class BaseNewGameStrategy implements NewGameStrategy {
  private CardDealerUtil cardDealer;

  public BaseNewGameStrategy() {
    cardDealer = new CardDealerUtil();
  }

  protected void dealCardToPlayer(Deck deck, Player player, boolean show) {
    cardDealer.dealCard(deck, player, show);
  }

  protected void dealCardToDealer(Deck deck, Dealer dealer, boolean show) {
    cardDealer.dealCard(deck, dealer, show);
  }
  
}

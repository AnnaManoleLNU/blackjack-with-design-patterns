package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;


class InternationalNewGameStrategy extends BaseNewGameStrategy {

  @Override
  public boolean newGame(Deck deck, Dealer dealer, Player player) {
    dealCardToPlayer(deck, player, true);
    dealCardToDealer(deck, dealer, true);
    dealCardToPlayer(deck, player, true);
    return true;
  }
}
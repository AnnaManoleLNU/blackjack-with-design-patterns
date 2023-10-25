package model;

import controller.PlayerSubscriber;

/**
 * Represents a player in the game. Dealer and Player are both players.
 */
public interface ReadOnlyPlayer {
  // Getter for hand
  Iterable<Card> getHand();

  // Add a subscriber to the player
  void addSubscriber(PlayerSubscriber subscriber);
}

package model;

/**
 * Represents a subscriber to a Player. A PlayerSubscriber is notified when the Player's hand gets a new card.
 */
public interface PlayerSubscriber {
  /**
   * Called when the player's hand changes.
   */
  void newCardDealt();
}

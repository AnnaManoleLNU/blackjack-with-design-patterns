package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a player in the Black Jack game. A Player has a hand of cards.
 */
public class Player {
  // In an observer pattern, the player is the publisher.
  private List<PlayerSubscriber> subscribers = new LinkedList<PlayerSubscriber>();

  private List<Card.Mutable> hand;
  protected final int maxScore = 21;

  public Player() {
    hand = new LinkedList<Card.Mutable>();
  }

  /**
   * Adds a card to the Player's hand. 

   * @param addToHand The card to add to the hand.
   */
  public void dealCard(Card.Mutable addToHand) {
    // System.out.println("Dealing card: " + addToHand);  
    hand.add(addToHand);
    // System.out.println("Current hand: " + hand); 
    // notify subscribers when a new card is dealt
    notifySubscribers();
  }

  /**
   * Returns the cards in thand.

   * @return the cards in the Player's hand
   */
  public Iterable<Card> getHand() {
    return new LinkedList<Card>(hand);
  }

  /**
   * Removes all cards from the hand.
   */
  public void clearHand() {
    // System.out.println("Clearing hand: " + hand);
    hand.clear();
  }

  /**
   * Shows all cards in the hand.
   */
  public void showHand() {
    for (Card.Mutable c : hand) {
      c.show(true);
    }
  }

  /**
   * Calculates the score of the hand according to Black Jack rules.

   * @return The score.
   */
  public int calcScore() {
    // the number of scores is dependant on the number of scorable values
    // as it seems there is no way to do this check at compile time in java ?!
    // cardScores[13] = {...};
    int[] cardScores = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
    assert (cardScores.length == Card.Value.Count.ordinal())
        : "Card Scores array size does not match number of card values";

    int score = 0;

    for (Card c : getHand()) {
      if (c.getValue() != Card.Value.Hidden) {
        score += cardScores[c.getValue().ordinal()];
      }
    }

    if (score > maxScore) {
      for (Card c : getHand()) {
        if (c.getValue() == Card.Value.Ace && score > maxScore) {
          score -= 10;
        }
      }
    }

    return score;
  }

  public void addSubscriber(PlayerSubscriber sub) {
    subscribers.add(sub);
  }

  public void removeSubscriber(PlayerSubscriber sub) {
    subscribers.remove(sub);
  }

  /**
   * Notifies all subscribers that the player's hand has changed.
   */
  protected void notifySubscribers() {
    for (PlayerSubscriber sub : subscribers) {
      sub.newCardDealt();
    }
  }

  /**
   * Returns the last card in the player's hand.
   *
   * @return the last card in the player's hand.
   */
  public Card getLastCard() {
    if (hand.size() == 0) {
      return null;
    }
    return hand.get(hand.size() - 1);
  }
}

package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a hand of cards.
 */
public class Hand {
  private List<Card.Mutable> hand = new LinkedList<>();
  private List<HandSubscriber> subscribers = new ArrayList<>();

  public void addCard(Card.Mutable card) {
    hand.add(card);
    notifySubscribers();
  }

  public Iterable<Card.Mutable> getCards() {
    return new LinkedList<Card.Mutable>(hand);
  }

  public Iterable<Card> getCardsImmutable() {
    return new LinkedList<Card>(hand);
  }

  public void clear() {
    hand.clear();
  }

  public void addSubscriber(HandSubscriber sub) {
    subscribers.add(sub);
  }

  public void removeSubscriber(HandSubscriber sub) {
    subscribers.remove(sub);
  }

  protected void notifySubscribers() {
    for (HandSubscriber sub : subscribers) {
      sub.onHandChanged(this);
    }
  }

  public Card getLastCard() {
    return hand.get(hand.size() - 1);
  }
}

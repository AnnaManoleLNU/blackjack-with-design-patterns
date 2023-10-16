package model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.RulesFactory;
import model.rules.SoftSeventeenStrategy;


public class SimpleTest {

  private Dealer dealer;
  private RulesFactory mockRulesFactory = new RulesFactory() {
    @Override
    public HitStrategy getHitRule() {
      return new SoftSeventeenStrategy();
    }

    @Override
    public NewGameStrategy getNewGameRule() {
      return null; // Not needed for this test
    }
  };

  @BeforeEach
  public void setUp() {
    dealer = new Dealer(mockRulesFactory);
  }

  @Test
  public void testBelowSeventeenShouldHit() {
    dealer.dealCard(new Card.Mutable(Card.Color.Hearts, Card.Value.Two));
    dealer.dealCard(new Card.Mutable(Card.Color.Hearts, Card.Value.Three));

    // get the stategy and test it directly
    HitStrategy hitStrategy = mockRulesFactory.getHitRule();
    assertTrue(hitStrategy.doHit(dealer));
  }

  @Test
  public void testSoftSeventeenShouldHit() {
    dealer.dealCard(new Card.Mutable(Card.Color.Hearts, Card.Value.Ace));
    dealer.dealCard(new Card.Mutable(Card.Color.Hearts, Card.Value.Six));

    // get the stategy and test it 
    HitStrategy hitStrategy = mockRulesFactory.getHitRule();
    assertTrue(hitStrategy.doHit(dealer));
  }

  @Test
  public void testHardSeventeenShouldNotHit() {
    dealer.dealCard(new Card.Mutable(Card.Color.Hearts, Card.Value.Eight));
    dealer.dealCard(new Card.Mutable(Card.Color.Hearts, Card.Value.Nine));

    assertFalse(dealer.hit(new Player()));
  }

  @Test
  public void testEighteenShouldNotHit() {
    dealer.dealCard(new Card.Mutable(Card.Color.Hearts, Card.Value.Nine));
    dealer.dealCard(new Card.Mutable(Card.Color.Hearts, Card.Value.Nine));

    assertFalse(dealer.hit(new Player()));
  }

}

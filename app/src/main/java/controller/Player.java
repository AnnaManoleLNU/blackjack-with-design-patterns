package controller;

import model.Game;
import model.HandSubscriber;
// import model.PlayerSubscriber;
import view.View;



/**
 * Scenario controller for playing the game.
 */
public class Player implements HandSubscriber {
  private Game game;
  private View view;

  /**
   * Creates a new instance of the Player class.
   *
   * @param game The game state.
   * @param view The view to use.
   */
  public Player(Game game, View view) {
    this.game = game;
    this.view = view;

    // add the controller as a subscriber to the player and dealer
    this.game.getPlayerHand().addSubscriber(this);
    this.game.getDealerHand().addSubscriber(this);
  }

  /**
   * Runs the play use case.

   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play(Game game, View view) {
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand().getCardsImmutable(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand().getCardsImmutable(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    View.GameAction action = view.getInput();

    switch (action) {
      case Play:
        game.newGame();
        break;
      case Hit:
        game.hit();
        break;
      case Stand:
        game.stand();
        break;
      case Quit:
        return false;
      default:
        break;
    }

    return action != View.GameAction.Quit;
  }

  @Override
  public void onHandChanged(model.Hand hand) {
    view.redrawUi(game);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }   
  }
}

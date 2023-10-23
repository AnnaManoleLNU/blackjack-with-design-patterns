package controller;

import model.Game;
import view.View;


/**
 * Scenario controller for playing the game.
 */
public class Player implements PlayerSubscriber {
  private Game game;
  private View view;

  public Player(Game game, View view) {
    this.game = game;
    this.view = view;

    // add the controller as a subscriber to the player and dealer
    this.game.getPlayer().addSubscriber(this);
    this.game.getDealer().addSubscriber(this);
  }

  /**
   * Runs the play use case.

   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play(Game game, View view) {
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

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
  public void newCardDealt() {
    redrawUi();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
  }

  private void redrawUi() {
    view.redrawUi(game);   
  }
}
package controller;

import model.Game;
import view.View;


/**
 * Scenario controller for playing the game.
 */
public class Player {

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
}
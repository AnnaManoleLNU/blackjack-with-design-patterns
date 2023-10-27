package controller;

import model.Game;
import model.PlayerSubscriber;
import view.View;


/**
 * Scenario controller for playing the game.
 */
public class Player implements PlayerSubscriber {
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

    // Display the rules.
    game.getDealer().accept(view);

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
    view.redrawUi(game);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }   
  }
}

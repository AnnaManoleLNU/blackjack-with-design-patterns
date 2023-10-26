package controller;

import model.Game;
import model.rules.AmericanSoftSeventeenDealerWinFactory;
import model.rules.RulesAbstractFactory;
import view.EnglishView;
// import view.SwedishView;
import view.View;

/**
 * Starts the application using the console.
 */
public class App {
  /**
   * Starts the game.

  * @param args Not used.
  */
  public static void main(String[] args) {

    RulesAbstractFactory rulesFactory = new AmericanSoftSeventeenDealerWinFactory();
    Game g = new Game(rulesFactory);
    View v = new EnglishView();
    // View v = new SwedishView();
    Player ctrl = new Player(g, v);
    while (ctrl.play(g, v)) {
    }
  }
}
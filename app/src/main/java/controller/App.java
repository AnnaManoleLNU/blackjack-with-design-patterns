package controller;

import model.Game;
import view.WindowView;

/**
 * Starts the application using the console.
 */
public class App {
  /**
   * Starts the game.

  * @param args Not used.
  */
  public static void main(String[] args) {
    Game g = new Game();
    WindowView wv = new WindowView(g);
    Player ctrl = new Player(g, wv);
    while (ctrl.play(g, wv)) {
    }
  }
}
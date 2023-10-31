package view;

import javax.swing.JFrame;

/**
 * Create a window for the game, using swing.
 */
public class WindowView {
  int boardWidth = 800;
  int boardHeight = 600;
  JFrame frame = new JFrame("Blackjack");

  public WindowView() {
    configureFrame();
  }

  private void configureFrame() {
    frame.setVisible(true);
    frame.setSize(boardWidth, boardHeight);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

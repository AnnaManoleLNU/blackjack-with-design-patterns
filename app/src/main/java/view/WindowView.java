package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Card;
import model.Game;

/**
 * Create a window for the game, using swing.
 */
public class WindowView extends EnglishView {
  int boardWidth = 800;
  int boardHeight = 600;

  int cardWidth = 110;
  int cardHeight = 154;

  JFrame frame = new JFrame("Blackjack");
  JPanel panel = new JPanel() {
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      drawTheStackOfCards(g);
      displayWelcomeMessage(g);
    }
  };

  /**
   * Creates the window with all the panels.
   */
  public WindowView() {
    configureFrame();
    configurePanel();
  }

  private void configureFrame() {
    frame.setVisible(true);
    frame.setSize(boardWidth, boardHeight);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void configurePanel() {
    BorderLayout layout = new BorderLayout();
    panel.setLayout(layout);
    Color background = new Color(54, 61, 94);
    panel.setBackground(background);
    frame.add(panel);
  }

  private void drawTheStackOfCards(Graphics g) {
    try {
      Image image = new ImageIcon(getClass().getResource("/cards/BACK.png")).getImage();
      g.drawImage(image, 650, 20, cardWidth, cardHeight, null);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Displays an infomative message.
   */
  private void displayWelcomeMessage(Graphics g) {
    g.setColor(Color.WHITE);
    g.setFont(g.getFont().deriveFont(20.0f));
    g.drawString("Hello Black Jack World! Hit 'h' to Hit, 's' to stand.", 20, 20);
  }

}

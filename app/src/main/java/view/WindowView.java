package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Card;
import model.Game;

/**
 * Create a window for the game, using swing.
 */
public class WindowView implements View {
  private BlockingQueue<GameAction> keyEventsQueue = new LinkedBlockingQueue<>();

  int boardWidth = 900;
  int boardHeight = 600;

  int cardWidth = 110;
  int cardHeight = 154;

  int deckX = 750;
  int deckY = 40;

  private Game game;

  Font font = new Font("Consolas", Font.PLAIN, 18);
  Color gameOverColor;

  JFrame frame = new JFrame("Blackjack");
  JPanel panel = new JPanel() {
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      redrawUi(game, g);

      displayGameOver(game.isDealerWinner(), g);
      colorGameOver(game.isDealerWinner(), g);
    }
  };

  /**
   * Creates the window with all the panels.
   */
  public WindowView(Game game) {
    configureFrame();
    configurePanel();
    addEventListenerToKeyPress();
    this.game = game;
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
      Image image = new ImageIcon(getClass().getResource("/cards/HiddenHidden.png")).getImage();
      g.drawImage(image, deckX, deckY, cardWidth, cardHeight, null);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public void displayWelcomeMessage() {
    panel.repaint();
    System.out.println("displayWelcomeMessage");
  }

  /**
   * Displays an infomative message.
   */
  private void displayWelcomeMessage(Graphics g) {
    g.setColor(Color.WHITE);
    g.setFont(font);
    g.drawString("Hello Black Jack World! Press 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit!", 20, 20);
  }

  private void displayDealerScore(Graphics g, int score) {
    g.setColor(Color.WHITE);
    g.setFont(font);
    g.drawString("Dealer score: " + score, 20, 120);
  }

  private void displayPlayerScore(Graphics g, int score) {
    g.setColor(Color.WHITE);
    g.setFont(font);
    g.drawString("Player score: " + score, 20, 420);
  }

  /**
   * Returns pressed characters from the keyboard.
   *
   * @return the pressed character.
   */
  public GameAction getInput() {
    try {
      return keyEventsQueue.take(); // This will wait until a key is pressed
    } catch (InterruptedException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Adds a key listener to the frame.
   */
  private void addEventListenerToKeyPress() {
    frame.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
          case KeyEvent.VK_P:
            keyEventsQueue.add(GameAction.Play);
            break;
          case KeyEvent.VK_H:
            keyEventsQueue.add(GameAction.Hit);
            break;
          case KeyEvent.VK_S:
            keyEventsQueue.add(GameAction.Stand);
            break;
          case KeyEvent.VK_Q:
            keyEventsQueue.add(GameAction.Quit);
            break;
          default:
            break;
        }
      }
    });
  }

  private Image getCardImage(Card card) {
    Image image = new ImageIcon(getClass().getResource("/cards/" + card.getValue()
        + card.getColor() + ".png")).getImage();
    return image;
  }

  @Override
  public void displayCard(Card card) {
    System.out.println("" + card.getValue() + " of " + card.getColor());
  }

  public void displayCard(Card card, int x, int y, Graphics g) {
    Image image = getCardImage(card);
    g.drawImage(image, x, y, cardWidth, cardHeight, null);
  }

  /**
   * Displays the cards and score of the player.
   */
  public void displayPlayerHand(Iterable<Card> hand, int score, Graphics g) {
    int x = 200;
    int y = 300;
    for (Card card : hand) {
      try {
        displayCard(card, x, y, g);
      } catch (Exception e) {
        System.out.println("Error in displayPlayerHand");
      }
      x += 50;
    }
  }

  @Override
  public void displayPlayerHand(Iterable<Card> hand, int score) {
    panel.repaint();
    System.out.println("displayPlayerHand");
  }

  /**
   * Displays the cards and score of the dealer.
   */
  public void displayDealerHand(Iterable<Card> hand, int score, Graphics g) {
    int x = 200;
    int y = 80;
    for (Card card : hand) {
      try {
        displayCard(card, x, y, g);
      } catch (Exception e) {
        System.out.println("Error in displayDealerHand");
      }
      x += 50;
    }
  }

  @Override
  public void displayDealerHand(Iterable<Card> hand, int score) {
    panel.repaint();
    System.out.println("displayDealerHand");
  }

  /**
   * Draws the game over message.
   */
  private void drawGameOver(boolean dealerIsWinner, Graphics g) {
    g.setColor(gameOverColor);
    g.setFont(font);
    g.drawString("Game over! " + (dealerIsWinner ? "Dealer" : "Player") + " won!", 20, 550);
  }

  private void displayGameOver(boolean dealerIsWinner, Graphics g) {
    if (game.isGameOver()) {
      drawGameOver(dealerIsWinner, g);
    }
  }

  @Override
  public void displayGameOver(boolean dealerIsWinner) {
    panel.repaint();
    System.out.println("displayGameOver");
  }

  /**
   * Colors the game over message. Red if the dealer won, green if the player won.
   */
  private void colorGameOver(boolean dealerIsWinner, Graphics g) {
    if (game.isDealerWinner()) {
      gameOverColor = Color.RED;
    } else {
      gameOverColor = Color.GREEN;
    }
  }

  /**
   * Redraws the UI.
   */
  public void redrawUi(Game game, Graphics g) {
    drawTheStackOfCards(g);
    displayWelcomeMessage(g);
    displayDealerScore(g, game.getDealerScore());
    displayPlayerScore(g, game.getPlayerScore());
    displayPlayerHand(game.getPlayerHand(), game.getPlayerScore(), g);
    displayDealerHand(game.getDealerHand(), game.getDealerScore(), g);
  }

  @Override
  public void redrawUi(Game game) {
    SoundPlayer soundPlayer = new SoundPlayer();
    soundPlayer.playSound();

    panel.repaint();
  }



}

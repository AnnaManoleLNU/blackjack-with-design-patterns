package view;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * Implements a sound player.
 */
public class SoundPlayer {

  /**
   * Plays a sound for the card.
   */
  public void playSound() {
    try {
      URL url = this.getClass().getClassLoader().getResource("sounds/cardSound.wav");
      if (url == null) {
        System.out.println("Could not find file");
        return;
      }
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
      e.printStackTrace();
    }
  }
  
}

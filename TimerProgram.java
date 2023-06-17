import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.*;

public class TimerProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minutes: ");
        int minutes = scanner.nextInt();

        System.out.print("Enter seconds: ");
        int seconds = scanner.nextInt();

        int totalSeconds = minutes * 60 + seconds;

        try {
            Thread.sleep(totalSeconds * 1000);

            File audioFile = new File("File path");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.println("END TIMER");

            // Wait for the audio to finish playing
            Thread.sleep(clip.getMicrosecondLength() / 1000);

            clip.close();
            audioStream.close();
        } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}

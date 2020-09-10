package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class AudioController {
    private FloatControl gainControl;
    private boolean stato;
    static String filePath;
    AudioInputStream audioInputStream;
    Long currentFrame;// to store current position
    String status; // current status of clip
    Clip clip;



    public AudioController(String filePath){ // constructor to initialize streams and clip
        this.filePath = filePath;
        stato = true;
        // create AudioInputStream object
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException | LineUnavailableException e) {
            e.printStackTrace();
        }


    }

    // Method to play the audio
    public void play(){
        //start the clip
        clip.start();

        status = "play";
    }



    // Method to restart the audio
    public void restart(){
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    // Method to stop the audio
    public void stop(){
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void onOff(){
        if(stato == true){
            stato = false;
            stop();
        }

        else{
            stato = true;
            restart();
        }
    }


    // Method to reset audio stream
    public void resetAudioStream(){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e  ) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }



}

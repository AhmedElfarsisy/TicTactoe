/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.helper;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import tictactoe.repository.defaults.DefaultKey;
import tictactoe.repository.defaults.UserDefaults;

/**
 *
 * @author yasmineghazy
 */
public class MusicPlayer {
    private static MediaPlayer mediaPlayer;
    private Thread thread;
    
    private static MusicPlayer shared; 
    public static MusicPlayer getInstance(){
        if(shared == null)
            shared = new MusicPlayer();
        
        return shared;
    }
    
    private MusicPlayer() {
        thread = new Thread(() -> {
            String fileDirectroy = System.getProperty("user.dir");
            String musicFile = fileDirectroy + "/src/tictactoe/resource/sounds/music.mp3";
            Media sound = new Media(new File(musicFile).toURI().toString());
            mediaPlayer = new MediaPlayer(sound);
            
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setVolume(getVolume());
            mediaPlayer.setOnReady(() -> {
                mediaPlayer.play();
            });
           

            mediaPlayer.setOnReady(() -> {
                mediaPlayer.play();
            });
            mediaPlayer.setOnEndOfMedia(() -> {
                mediaPlayer.seek(Duration.ZERO);
            });
            mediaPlayer.play();
        });
       
    }
    
    public  void setVolume(Double volume){
//        if(volume == 0){
//            stop();
//        }
        mediaPlayer.setVolume(volume);
        UserDefaults.getInstance().set(DefaultKey.MUSICVOLUME, volume);
    }
    
    public Double getVolume(){
        Double volume = (Double) UserDefaults.getInstance().get(DefaultKey.MUSICVOLUME);
        if(volume == null){
            setVolume(0.5);
        }
        return volume;
    }

    
    public void play(){
        
        thread.start();        
    }
    
    public void stop(){
        mediaPlayer.stop();
        thread.stop();
        System.out.println(thread.getState());
        System.out.println(Thread.activeCount());
    }
}

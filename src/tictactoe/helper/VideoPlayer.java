/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.helper;

import java.io.File;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import tictactoe.repository.defaults.DefaultKey;
import tictactoe.repository.defaults.UserDefaults;

/**
 *
 * @author Heba
 */
public class VideoPlayer {

    private static MediaPlayer mediaPlayer;
    private static MediaView mediaView;
    private Thread thread;

    private static VideoPlayer shared;

    //userState indicate whether a user is winner or loser
    public static VideoPlayer getInstance(String userState) {
        if (shared == null) {
            shared = new VideoPlayer(userState);
        }

        return shared;
    }

    //decide upon player status
    private VideoPlayer(String userState) {

        String fileDirectroy = System.getProperty("user.dir");
        String winnerVideoFile = fileDirectroy + "/src/tictactoe/resource/videos/vid0.mp4";
        String loserVideoFile = fileDirectroy + "/src/tictactoe/resource/videos/vid2.mp4";
        Media video;
        if (userState.equalsIgnoreCase("winner")) {
            video = new Media(new File(winnerVideoFile).toURI().toString());
            mediaPlayer = new MediaPlayer(video);

        } else {
            video = new Media(new File(loserVideoFile).toURI().toString());
            mediaPlayer = new MediaPlayer(video);
        }
    }

    public void play(StackPane pane) {
        mediaPlayer.setVolume((double) UserDefaults.getInstance().get(DefaultKey.MUSICVOLUME));
        mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(600);
        mediaView.setFitHeight(400);
        pane.getChildren().add(mediaView);
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.stop();
            mediaPlayer.seek(Duration.ZERO);
            pane.getChildren().remove(mediaView);
        });
    }

    public void stop() {
        mediaPlayer.stop();
    }
}

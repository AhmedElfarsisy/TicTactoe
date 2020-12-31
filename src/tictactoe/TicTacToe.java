/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.File;
import javafx.application.Application;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoe.helper.BaseController;
import tictactoe.helper.Constants;
import tictactoe.presenter.home.HomeController;
import tictactoe.presenter.spalsh.SplashController;

/**
 *
 * @author A.Elfarsisy
 */
public class TicTacToe extends Application {

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setResizable(false);
        Scene scene = new Scene(SplashController.buildVC().getView());
        scene.getStylesheets().add(getClass().getResource(Constants.STYLE).toString());
        stage.setScene(scene);
        stage.show();
        playMusic();
        goToHome();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void changeScene(BaseController controller) {
        Scene scene = new Scene(controller.getView());
        stage.setScene(scene);
        stage.show();
    }

    private void goToHome() {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(4500);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                changeScene(new HomeController());
            }
        });
        new Thread(sleeper).start();
    }

    private void playMusic() {
        new Thread(() -> {   // For example
//            String musicFile = "C:/Users/A.Elfarsisy/TicTacToe/src/tictactoe/resource/sounds/music.mp3";
            Media sound = new Media(getClass().getResource(Constants.MUSIC).toExternalForm());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setOnReady(() -> {
            mediaPlayer.play();
        });

            mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);

            });
            mediaPlayer.play();
        }).start();

    }

}

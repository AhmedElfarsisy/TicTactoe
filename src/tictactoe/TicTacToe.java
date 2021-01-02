/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.helper.BaseController;
import tictactoe.helper.Constants;
import tictactoe.helper.MusicPlayer;
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
        MusicPlayer.getInstance().play();
        Scene scene = new Scene(SplashController.buildVC().getView());
        scene.getStylesheets().add(getClass().getResource(Constants.STYLE).toString());
        stage.setScene(scene);
        stage.show();
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
        scene.getStylesheets().add(controller.getClass().getResource(Constants.STYLE).toString());
        stage.setScene(scene);
        stage.show();
    }
    
    private void goToHome() {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(4000);
                    
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded((WorkerStateEvent event) -> {
             changeScene(new HomeController()); 
        });
        new Thread(sleeper).start();
    }    
}


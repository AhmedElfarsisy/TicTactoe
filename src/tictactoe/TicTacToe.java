/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;
import tictactoe.presenter.home.HomeController;

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
        //Set Home Screen as the starting scene

        Scene scene = new Scene((new HomeController()).getView());
        stage.setScene(scene);
        stage.show();
    
//        stage.setOnShown((event)->{
//            System.out.println("Showen");
//            Navigator.goToHome();          
//        });
                

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
}

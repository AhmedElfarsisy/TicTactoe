/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.presenter.home.HomeController;
import tictactoe.presenter.home.HomeViewBase;
import tictactoe.presenter.options.OptionsController;

/**
 *
 * @author A.Elfarsisy
 */
public class TicTacToe extends Application {

    HomeController homeController;
    OptionsController optionsController;

    @Override
    public void start(Stage stage) throws Exception {
        homeController = new HomeController(stage);
       
        Parent root = homeController.getHomeView();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        optionsController = new OptionsController();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void change
}

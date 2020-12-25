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
import tictactoe.helper.BaseController;
import tictactoe.presenter.home.HomeController;
import tictactoe.presenter.home.HomeViewBase;
import tictactoe.presenter.options.OptionsController;

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

        Scene scene = new Scene((new HomeController()).getHomeView());
        stage.setScene(scene);
        stage.show();
  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void changeScene(BaseController controller) {
        Scene scene = new Scene(controller.getViewBase());
        stage.setScene(scene);
        stage.show();
    }
}

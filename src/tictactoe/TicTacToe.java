/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.helper.BaseController;
import tictactoe.helper.Constants;
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
        Scene scene = new Scene(new HomeController().getView());
        scene.getStylesheets().add(getClass().getResource(Constants.STYLE).toString());
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
        Scene scene = new Scene(controller.getView());
        stage.setScene(scene);
        stage.show();
    }

}

//    private void createGameFile() {
//        GameDao gameDao=new GameDao(); 
//        gameDao.createGameFile();
//        gameDao.createRecordGameFile();
//        gameDao.addDummyData();
//        gameDao.writeGame();
//        
//    }


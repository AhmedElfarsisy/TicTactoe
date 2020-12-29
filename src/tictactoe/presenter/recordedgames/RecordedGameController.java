/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.recordedgames;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;
import tictactoe.presenter.onlineplayers.OnlinePlayersBase;
import tictactoe.repository.GameDao;
import tictactoe.repository.models.Game;

/**
 * FXML Controller class
 *
 * @author Mostafa Abdalla
 */
public class RecordedGameController extends BaseController implements Initializable {

    private RecordedGameBase rg;
    private GameDao gameDao;
    ArrayList<Game> gamesList;

    public RecordedGameController() {

        //create new view
        rg = new RecordedGameBase();
        //DAO Object 
        gameDao = new GameDao();

        gameDao.getRecordedGames();
        gamesList = gameDao.readGamesFromFiles();
        showGamesOnTable();
       
        //4 - Set viewBase -> Parent = currentView -> Child
        viewBase = rg;
        rg.backbtn.setOnAction((event) -> {
            Navigator.goToOptions();
           
        });

        rg.showbtn.setOnAction((event) -> {

        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void showGamesOnTable() {
        System.out.println("show table");
        rg.recordedGamestTV.getItems().addAll(gamesList);
        rg.player1RecordedGameTC.setCellValueFactory(new PropertyValueFactory<>("playerOneName"));
        rg.player2RecordedGameTC.setCellValueFactory(new PropertyValueFactory<>("playerTwoName"));
        rg.resultRecordedGameTC.setCellValueFactory(new PropertyValueFactory<>("gameState"));
    }

}

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
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;
import tictactoe.repository.GameDao;
import tictactoe.repository.models.Game;

/**
 * FXML Controller class
 *
 * @author Mostafa Abdalla
 */
public class RecordedGameController extends BaseController implements Initializable {

    private RecordedGameBase view;
    private GameDao gameDao;
    ArrayList<Game> gamesList;

    public RecordedGameController() {

        //create new view
        view = new RecordedGameBase();
        //DAO Object 
        gameDao = new GameDao();

        gameDao.getRecordedGames();
        gamesList = gameDao.readGamesFromFiles();
        showGamesOnTable();

        view.backBtn.setOnAction((event) -> {
            Navigator.goToOptions();
           
        });

        view.showBtn.setOnAction((event) -> {
            
        });
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void showGamesOnTable() {
        view.recordedGamestTV.getItems().addAll(gamesList);
        view.player1RecordedGameTC.setCellValueFactory(new PropertyValueFactory<>("playerOneName"));
        view.player2RecordedGameTC.setCellValueFactory(new PropertyValueFactory<>("playerTwoName"));
        view.resultRecordedGameTC.setCellValueFactory(new PropertyValueFactory<>("gameState"));
    }
 
    
    //MARK: - Implement BaseController method  
    @Override
    public Pane getView() {
        return view;
    }

}

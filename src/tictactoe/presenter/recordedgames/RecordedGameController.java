/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.recordedgames;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TablePosition;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;
import tictactoe.model.Game;
import tictactoe.repository.GameDao;
import tictactoe.repository.defaults.DefaultKey;
import tictactoe.repository.defaults.UserDefaults;
import tictactoe.repository.models.TableGame;

/**
 * FXML Controller class
 *
 * @author Mostafa Abdalla
 */
public class RecordedGameController extends BaseController implements Initializable {

    private RecordedGameBase view;
    private GameDao gameDao;
    ArrayList<Game> gamesList;
    Game game;

    public RecordedGameController() {

        //create new view
        view = new RecordedGameBase();
        //DAO Object 
        gameDao = GameDao.getInstance();
        
        gamesList = gameDao.readGamesFromFiles("Player 1");
        showGamesOnTable();
        view.recordedGamestTV.setEditable(false);
        
        view.backBtn.setOnAction((event) -> {
            Navigator.goToOptions();
        });

        view.recordingCheckBox.setOnAction((event) -> {
            UserDefaults.getInstance().add(DefaultKey.ISGAMERECORDED,
                                           view.recordingCheckBox.isSelected());
        });
        ObservableList selectedCells = view.recordedGamestTV.getSelectionModel().getSelectedCells();
        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
               int row = tablePosition.getRow();
                System.out.println(gamesList.get(0).getWinner());
                Navigator.goToRecordedGame(gamesList.get(row));
      
            }
        });
        
        view.recordingCheckBox.setSelected((boolean)UserDefaults.getInstance().get(DefaultKey.ISGAMERECORDED));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void showGamesOnTable() {

        ArrayList<TableGame> tableGameList = new ArrayList<>();
        gamesList.forEach((game) -> {
            tableGameList.add(new TableGame(game));
        });

        view.recordedGamestTV.getItems().addAll(tableGameList);
        view.player1RecordedGameTC.setCellValueFactory(new PropertyValueFactory<>("playerOneName"));
        view.player2RecordedGameTC.setCellValueFactory(new PropertyValueFactory<>("playerTwoName"));
        view.resultRecordedGameTC.setCellValueFactory(new PropertyValueFactory<>("gameState"));
        view.dateRecordedGameTC.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    //MARK: - Implement BaseController method  
    @Override
    public Pane getView() {
        return view;
    }


}

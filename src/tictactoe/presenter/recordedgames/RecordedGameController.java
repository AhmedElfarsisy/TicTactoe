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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TablePosition;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;
import tictactoe.model.Game;
import tictactoe.model.PlayMode;
import tictactoe.model.Player;
import tictactoe.model.Symbol;
import tictactoe.repository.GameDao;
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

    public RecordedGameController() {

        //create new view
        view = new RecordedGameBase();
        //DAO Object 
        gameDao = GameDao.getInstance();
        gamesList = gameDao.readGamesFromFiles("Ahmed Elfarsisy");
        showGamesOnTable();
        view.backBtn.setOnAction((event) -> {
            Navigator.goToOptions();
        });

        view.showBtn.setOnAction((event) -> {
            view.recordedGamestTV.setEditable(false);

        });
        ObservableList selectedCells = view.recordedGamestTV.getSelectionModel().getSelectedCells();
        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                int row = tablePosition.getRow();
                
            }
        });

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

    }

    //MARK: - Implement BaseController method  
    @Override
    public Pane getView() {
        return view;
    }

//     Player [] players={new Player("Ahmed Elfarsisy", Symbol.O),new Player("Yasmin Ghazy",Symbol.X)};
//            Game game =new Game(players,PlayMode.MULTIOFFLINE);
//            gameDao.createRecordGameFile(players[0].getUser().getUserName());
//            gameDao.writeGame(game);
//    
}

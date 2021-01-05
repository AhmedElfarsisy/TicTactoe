/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.onlineplayers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TablePosition;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Constants;
import tictactoe.helper.Navigator;
import tictactoe.helper.Toast;
import tictactoe.helper.UIHelper;
import tictactoe.model.*;
import tictactoe.network.NWDelegate;
import tictactoe.network.NetworkSession;
import tictactoe.network.model.NWResponse;
import tictactoe.network.model.Request;
import tictactoe.network.model.RequestType;
import tictactoe.repository.defaults.DefaultKey;
import tictactoe.repository.defaults.UserDefaults;

/**
 * FXML Controller class
 *
 * @author Mostafa Abdalla
 */
public class OnlinePlayersController extends BaseController implements Initializable, NWDelegate {

    private OnlinePlayersViewBase view;
    ArrayList<User> playersList;

    public OnlinePlayersController() {
        NetworkSession.getInstance().setDelegate(this);

        //create new view
        view = new OnlinePlayersViewBase();
        view.refreshPlayerListBtn.setVisible(false);
        playersList = new ArrayList<>();
        view.onlinePlayersTV.setEditable(false);
        view.backBtn.setOnAction((event) -> {
            Navigator.goToHome();
        });
        view.refreshPlayerListBtn.setOnAction((event) -> {
            loadData();
        });

        ObservableList selectedCells = view.onlinePlayersTV.getSelectionModel().getSelectedCells();
        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                if (!selectedCells.isEmpty()) {
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    int row = tablePosition.getRow();
                    //Send request to player
                    System.out.println(playersList.get(row).getUserName());

                    Request request = new Request(RequestType.REQUESTGAME, playersList.get(row));
                    NetworkSession.getInstance().sendRequest(request);
                }

            }
        });
        loadData();

        view.label2.setText(Constants.currentUser.getUserName());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void loadData() {
        Request<User> request = new Request<>(RequestType.GETONLINEPLAYERS, Constants.currentUser);
        NetworkSession.getInstance().sendRequest(request);
    }

    private void showPlayersOnTable() {
        view.onlinePlayersTV.getItems().clear();
        view.onlinePlayersTV.getItems().addAll(playersList);
        view.playerTC.setCellValueFactory(new PropertyValueFactory<>("userName"));
        view.scoreTC.setCellValueFactory(new PropertyValueFactory<>("score"));
    }

    //MARK: - Implement BaseController method  
    @Override
    public Pane getView() {
        return view;
    }
    //MARK: - Implement NWDelegate Method

    @Override
    public void updateOnlinePlayers(ArrayList<User> players) {
        playersList = players;
        showPlayersOnTable();

    }

    @Override
    public void requestGame(User user) {
        //accept - reject
        Request request;
        if (showDialogRequest(user.getUserName())) {
            request = new Request(RequestType.ACCEPTGAME, user);
            Game game;
            Player player1 = new Player(user, Symbol.X);
            Player player2 = new Player(Constants.currentUser, Symbol.O);
            Player[] players = {player1, player2};
            game = new Game(players, PlayMode.MULTIONLINE);
            Navigator.goToOnlineGame(game);
        } else {
            request = new Request(RequestType.REJECTGAME, user);
        }
        NetworkSession.getInstance().sendRequest(request);
    }

    @Override
    public void acceptGame(User user) {
        Game game;
        Player player1 = new Player(Constants.currentUser, Symbol.X);
        Player player2 = new Player(user, Symbol.O);
        Player[] players = {player1, player2};
        game = new Game(players, PlayMode.MULTIONLINE);
        Navigator.goToOnlineGame(game);
    }

    public void rejectGame(User user) {
        Toast.showError(user.getUserName() + "  reject the game request");
    }

    public static boolean showDialogRequest(String user) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Request Game");
        alert.setHeaderText("This player want to play with you");
        alert.setContentText(user);
        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            return true;
        } else {
            return false;
        }
    }
}

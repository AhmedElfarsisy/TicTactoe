/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.onlineplayers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TablePosition;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;
import tictactoe.helper.UIHelper;
import tictactoe.model.*;
import tictactoe.network.ClientSession;
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
public class OnlinePlayersController extends BaseController implements Initializable {

    private OnlinePlayersViewBase view;
    ArrayList<User> playersList;

    public OnlinePlayersController() {

        //create new view
        view = new OnlinePlayersViewBase();

        playersList = new ArrayList<>();
        playersList.add(new User("Yasmine", 10));

        view.recordedGamestTV.setEditable(false);

        view.backBtn.setOnAction((event) -> {
            Navigator.goToHome();
        });

        ObservableList selectedCells = view.recordedGamestTV.getSelectionModel().getSelectedCells();
        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                int row = tablePosition.getRow();
                //Send request to player
                System.out.println(playersList.get(row).getUserName());
                             
                Navigator.goToOnlineGame(playersList.get(row));
            }
        });

        Request<User> request = new Request<>(RequestType.GETONLINEPLAYERS, (User) UserDefaults.getInstance().get(DefaultKey.USER));
        NWResponse response = ClientSession.getInstance().sendRequest(request);
        switch (response.getStatus()) {
            case SUCCESS:
                playersList = (ArrayList<User>) response.getData();
                showPlayersOnTable();

                break;
            case FAILURE:
                UIHelper.showDialog(response.getMessage());
                break;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void showPlayersOnTable() {
        view.recordedGamestTV.getItems().addAll(playersList);
        view.playerTC.setCellValueFactory(new PropertyValueFactory<>("userName"));
        view.scoreTC.setCellValueFactory(new PropertyValueFactory<>("score"));

    }

    //MARK: - Implement BaseController method  
    @Override
    public Pane getView() {
        return view;
    }

}

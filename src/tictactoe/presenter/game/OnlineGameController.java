/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.game;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import tictactoe.model.Game;
import tictactoe.model.Move;
import tictactoe.network.NetworkSession;
import tictactoe.network.model.GameModel;
import tictactoe.network.model.Request;
import tictactoe.network.model.RequestType;
import tictactoe.network.NWDelegate;

/**
 *
 * @author yasmineghazy
 */
public class OnlineGameController extends GameController implements NWDelegate {

    //MARK: - Properties
    Request<GameModel> request;

    //MARK: - Constructor
    public OnlineGameController(Game game) {
        super(game);
        NetworkSession.getInstance().setDelegate(this);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                (gridButtons[x][y]).setOnAction((ActionEvent event) -> {
                    Button btn = (Button) event.getSource();
                    performMove(btn);
                    sendMove(btn);
                });
            }

        }

    }
    //MARK: - Methods

    protected void sendMove(Button btn) {
        Move move = new Move(getInt(btn, 0), getInt(btn, 1));
        GameModel gameModel = new GameModel(game.getUser(0), game.getUser(1), move);
        request = new Request<>(RequestType.PLAYGAME, gameModel);
        NetworkSession.getInstance().notifyServer(request);
    }

    @Override
    public void updateMove(Move move) {
        performMove(gridButtons[move.getX()][move.getY()]);

    }

}

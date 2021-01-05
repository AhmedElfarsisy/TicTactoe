/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.game;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import tictactoe.helper.Constants;
import tictactoe.helper.VideoPlayer;
import tictactoe.model.Game;
import tictactoe.model.Move;
import tictactoe.network.NetworkSession;
import tictactoe.network.model.GameModel;
import tictactoe.network.model.Request;
import tictactoe.network.model.RequestType;
import tictactoe.network.NWDelegate;
import tictactoe.repository.GameDao;
import tictactoe.repository.defaults.DefaultKey;
import tictactoe.repository.defaults.UserDefaults;

/**
 *
 * @author yasmineghazy
 */
public class OnlineGameController extends GameController implements NWDelegate {

    //MARK: - Properties
    Request<Object> request;

    //MARK: - Constructor
    public OnlineGameController(Game game) {
        super(game);
        NetworkSession.getInstance().setDelegate(this);

        if (!Constants.currentUser.getUserName().equals(game.getPlayerName(0))) {
            setBoardDisable(true);
        }

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                (gridButtons[x][y]).setOnAction((ActionEvent event) -> {
                    Button btn = (Button) event.getSource();
                    performMove(btn);
                    sendMove(btn);
                    checkGameEnd();
                });
            }

        }

    }
    //MARK: - Methods

    protected void sendMove(Button btn) {
        Move move = new Move(getInt(btn, 0), getInt(btn, 1));
        GameModel gameModel = new GameModel(game.getUser(0), game.getUser(1), move);
        request = new Request<>(RequestType.PLAYGAME, gameModel);
        NetworkSession.getInstance().sendRequest(request);
        setBoardDisable(true);
    }

    @Override
    public void updateMove(Move move) {
        performMove(gridButtons[move.getX()][move.getY()]);
        setBoardDisable(false);
        checkGameEnd();

    }

    @Override
    protected void checkGameEnd() {
        if (isGameEnded()) {

            setBoardDisable(true);
            if ((Boolean) UserDefaults.getInstance().get(DefaultKey.ISGAMERECORDED)) {
                GameDao.getInstance().addGame(game);
            }

            request = new Request<>(RequestType.ENDGAME, (Integer) game.checkWinner());
            NetworkSession.getInstance().sendRequest(request);

        } else {
            togglePlayer();
        }
    }

    @Override
    protected Boolean isGameEnded() {
        Boolean isGameEnded = true;
        if (game.checkWinner() == 0) { //First player wins 
            showWinner(0);

            showVideo(0);
        } else if (game.checkWinner() == 1) { //Second player wins
            showWinner(1);
            showVideo(1);
        } else if (game.isBoardFull()) {
            showWinner(-1);
        } else {
            isGameEnded = false;
        }
        return isGameEnded;
    }

    public void  showVideo(int winner) {
        if (Constants.currentUser.getUserName().equals(game.getPlayerName(winner))) {
            VideoPlayer.getInstance("winner").play(view.videoStackPane);
        } else {
            VideoPlayer.getInstance("looser").play(view.videoStackPane);
        }
    }

    @Override
    protected void performMove(Button btn) {
        btn.setDisable(true);
        btn.setText(game.getPlayerSymbol(currentPlayer));
        game.setMove(btn.getText(), getInt(btn, 0), getInt(btn, 1));
    }

    @Override
    protected void setBoardDisable(Boolean isDisable) {
        view.gameBoardGP.getChildren().forEach((ch) -> {
            ((Button) ch).setDisable(isDisable);
        });
        game.getMoves().forEach((move) -> {
            gridButtons[move.getX()][move.getY()].setDisable(true);
        });
    }
}

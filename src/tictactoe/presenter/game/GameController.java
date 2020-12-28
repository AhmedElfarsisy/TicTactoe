/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import tictactoe.helper.*;
import tictactoe.model.*;


/**
 *
 * @author yasmineghazy
 */

//3 - Inherit from BaseController
public class GameController extends BaseController implements Initializable {
    
    //MARK: - Properties
    private final GameViewBase view;
    private final Game game;
    private int currentPlayer;
    
    //MARK: - Constructor
    public GameController(){
        
        //create new view
        view = new GameViewBase();
        
        //Set game
        
        Player player1 = new Player("Player 1", Symbol.O);
        Player player2 = new Player("Player 2", Symbol.X);
        Player [] players = {player1, player2};
        Game g = new Game(players,PlayMode.MULTIOFFLINE);
        this.game = g;
        currentPlayer = 0;
        startGame();
        
        //Set action handler
        setActionHandler();
    }

    
    //MARK: - Implement Initializable callback method
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    }  
    
    //MARK: - Implement BaseController method  
    @Override
    public Pane getView() {
        //set super view
        return view;
    }
    
    //MARK: - Methods
    private void setActionHandler(){
        
        for(int pos = 0; pos < 9; pos++){
            (getBoardButton(pos)).setOnAction((ActionEvent event) -> {
                Button btn = (Button) event.getSource();
                btn.setText(game.getPlayerSymbol(currentPlayer));
                btn.setDisable(true);
                game.setMove(btn.getText(), getInt(btn, 0), getInt(btn, 1));
                checkGameEnd();
                togglePlayer();  
            });
        }
          
        view.playAgainBtn.setOnAction((event) -> { startGame(); });
        view.backBtn.setOnAction((event) -> { Navigator.goToHome(); });
    }
    
    private int getInt(Button btn,int index){
        return btn.getId().charAt(index) - '0';
    }
    
    private void checkGameEnd(){
        if(isGameEnded()){
            //startGame();
        }
    }
    
    private Boolean isGameEnded(){
        Boolean isGameEnded = true;
        if(game.getWinner() == 0){ //First player wins
           showWinner(0);
        }else if(game.getWinner() == 1){ //Second player wins
           showWinner(1);
        }else if(game.isBoardFull()){
          (new Alert(AlertType.INFORMATION, "You Draw")).show();
        }else{
            isGameEnded = false;
        }
        return isGameEnded;
    }
    
    private void showWinner(int index){
        (new Alert(AlertType.INFORMATION, game.getPlayerName(index) + "Win")).show();
         currentPlayer = index;
         game.updatePlayerScore(index);
    }
    
    //Reinitialize board
    private void startGame(){
        resetBoard();
        view.firstPlayerCharLbl.setText(game.getPlayerSymbol(0));
        view.firstPlayerNameLbl.setText(game.getPlayerName(0));
        view.firstPlayerScoreLbl.setText(game.getPlayerScore(0));
        view.secondPlayerCharLbl.setText(game.getPlayerSymbol(1));
        view.secondPlayerNameLbl.setText(game.getPlayerName(1));
        view.secondPlayerScoreLbl.setText(game.getPlayerScore(1));
        view.playerTurnLbl.setText(game.getPlayerName(currentPlayer) + " Turn");
    }
    
    private Button getBoardButton(int pos){
        return (Button) view.gameBoardGP.getChildren().get(pos);
    }
    
    private void resetBoard(){
        game.resetBoard();
        view.gameBoardGP.getChildren().forEach((ch) -> {
                ((Button) ch).setText("");
                 ((Button) ch).setDisable(false);
        });
    }
    
    private void togglePlayer(){
        currentPlayer = currentPlayer == 0 ? 1 : 0;
        view.playerTurnLbl.setText(game.getPlayerName(currentPlayer) + "Turn");
    }
    
    
    
}

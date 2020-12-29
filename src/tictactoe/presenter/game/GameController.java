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
    private int currentPlayer = 0;
    private Button[][] gridButtons;
    
    //MARK: - Constructor
    public GameController(Game g){
        
        //create new view
        view = new GameViewBase();
        
        //Set game
        this.game = g;
       
        setupViews();
        startGame();
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
    private void setupViews(){
        view.playAgainBtn.setVisible(false);
        setBoardButtons();
    }
    
    private void setBoardButtons(){
        gridButtons = new Button[3][3];
        gridButtons[0][0] = getBoardButton(0);
        gridButtons[0][1] = getBoardButton(1);
        gridButtons[0][2] = getBoardButton(2);
        gridButtons[1][0] = getBoardButton(3);
        gridButtons[1][1] = getBoardButton(4);
        gridButtons[1][2] = getBoardButton(5);
        gridButtons[2][0] = getBoardButton(6);
        gridButtons[2][1] = getBoardButton(7);
        gridButtons[2][2] = getBoardButton(8);
    }
    
    private void setActionHandler(){
        
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                (gridButtons[x][y]).setOnAction((ActionEvent event) -> {
                Button btn = (Button) event.getSource();
                btn.setText(game.getPlayerSymbol(currentPlayer));
                btn.setDisable(true);
                game.setMove(btn.getText(), getInt(btn, 0), getInt(btn, 1));
                checkGameEnd();
                  
            });
            }
        }
          
        view.playAgainBtn.setOnAction((event) -> { startGame(); });
        view.backBtn.setOnAction((event) -> { Navigator.goToHome(); });
    }
    
    private int getInt(Button btn,int index){
        return btn.getId().charAt(index) - '0';
    }
    
    private void checkGameEnd(){
        if(isGameEnded()){
            view.playAgainBtn.setVisible(true);
            setBoardDisable(true);
        }else{
            togglePlayer();
        }
    }
    
    private Boolean isGameEnded(){
        Boolean isGameEnded = true;
        if(game.getWinner() == 0){ //First player wins
           showWinner(0);
        }else if(game.getWinner() == 1){ //Second player wins
           showWinner(1);
        }else if(game.isBoardFull()){
           view.playerTurnLbl.setText("You Draw");
        }else{
            isGameEnded = false;
        }
        return isGameEnded;
    }
    
    private void showWinner(int index){
         view.playerTurnLbl.setText(game.getPlayerName(index) + " Win");
         currentPlayer = index;
         game.updatePlayerScore(index);
         view.firstPlayerScoreLbl.setText(game.getPlayerScore(0));
         view.secondPlayerScoreLbl.setText(game.getPlayerScore(1));
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
        view.playAgainBtn.setVisible(false);
    }
    
    private Button getBoardButton(int pos){
        return (Button) view.gameBoardGP.getChildren().get(pos);
    }
    
    private void resetBoard(){
        game.resetBoard();
        view.playAgainBtn.setVisible(true);
        setBoardDisable(false);
        clearBoard();
    }
    
    private void setBoardDisable(Boolean isDisable){
        view.gameBoardGP.getChildren().forEach((ch) -> {
                ((Button) ch).setDisable(isDisable);
        });
    }
    
    private void clearBoard(){
        view.gameBoardGP.getChildren().forEach((ch) -> {
                ((Button) ch).setText("");
        });
    }
    
    
    private void togglePlayer(){
        currentPlayer = currentPlayer == 0 ? 1 : 0;
        view.playerTurnLbl.setText(game.getPlayerName(currentPlayer) + " Turn");
        
        if(game.getMode() == PlayMode.SINGLE){
           if(currentPlayer == 1){//Computer
              Move move = game.getBoard().getNextMove(game.getPlayerSymbol(currentPlayer));
              gridButtons[move.getX()][move.getY()].fire();
           }
        }
    }
}

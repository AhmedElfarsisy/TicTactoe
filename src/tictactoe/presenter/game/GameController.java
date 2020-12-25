/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;


/**
 *
 * @author yasmineghazy
 */

//3 - Inherit from BaseController
public class GameController extends BaseController implements Initializable {
    
    //MARK: - Properties
    private GameViewBase gameView;
    
    //MARK: - Constructor
    public GameController(){
        
        //create new view
        gameView = new GameViewBase();
        
        //4 - Set viewBase -> Parent = currentView -> Child
        viewBase = gameView;
        
        //Set action handler
          for(Object ch: gameView.gameBoardGP.getChildren()){
            ((Button) ch).setOnAction((ActionEvent event) -> {
            ((Button) event.getSource()).setText("X");
        });
        }
          
          
          gameView.playAgainBtn.setOnAction((ActionEvent event) -> {
              
              for(Object ch: gameView.gameBoardGP.getChildren()){
                    ((Button) ch).setText("");
              }
          });
          
          gameView.backBtn.setOnAction((ActionEvent event) -> {
              Navigator.goToRecordedGame();//2. Calling
              
          });
    }

    
    //MARK: - Implement Initializable callback method
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    }  
    
    //MARK: - Getters
    public GameViewBase getGameView(){
        return  gameView;
    }   

//    protected void setViewPane() {
//        //set super view
//        viewBase = gameView;
//    }
    
}

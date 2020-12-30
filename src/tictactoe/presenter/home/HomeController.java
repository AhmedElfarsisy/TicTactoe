/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.home;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;
import tictactoe.model.PlayMode;
//import tictactoe.repository.models.Game;
import tictactoe.model.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author A.Elfarsisy
 */
public class HomeController extends BaseController implements Initializable {

    private HomeViewBase view;

    //Home Controller Constarctor 
    public HomeController() {
        //create Home view
        view = new HomeViewBase();
        //Go to Single Game Page
        view.singlePlayerBtn.setOnAction((event) -> {Navigator.goToGame(PlayMode.SINGLE);});
        
        //Go to MultiPlayer Offline Game Page
          view.multiPlayerOnlineBtn.setOnAction((event) -> {
              //Navigator.goToLogin();
              
              //testing
              
              Player[] players = { new Player("Player1", Symbol.X) , new Player("Player2", Symbol.O)};
              String [][] tiles = {{"X","O","O"},{"X","O","O"},{"X","O","O"} };
              ArrayList<Move> moves = new ArrayList(Arrays.asList(new Move(1,1), new Move(0,1), new Move(1,0), new Move(2,1), new Move(2,2)));
    
              Game g = new Game(players, 0,0, PlayMode.SINGLE, tiles,moves);
              Navigator.goToRecordedGame(g);
          
          });
        //homeView.multiPlayerOnlineBtn.setOnAction((event) -> {Navigator.goToOnlinePlayers();});

        //Go to MultiPlayer Offline Game Page
        view.multiPlayerOfflineBtn.setOnAction((event) -> {Navigator.goToGame(PlayMode.MULTIOFFLINE);});

        //Go to Option Page
        view.optionsBtn.setOnAction((event) -> {
            Navigator.goToOptions();
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    //Get Home View 

        //MARK: - Implement BaseController method  
    @Override
    public Pane getView() {
        //set super view
        return view;
    }

}

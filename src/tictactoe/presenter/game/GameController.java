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
    private GameViewBase view;
    
    //MARK: - Constructor
    public GameController(){
        
        //create new view
        view = new GameViewBase();
        
        //4 - Set viewBase -> Parent = currentView -> Child
        //viewBase = view;
        
        //Set action handler
        view.gameBoardGP.getChildren().forEach((ch) -> {
            ((Button) ch).setOnAction(( event) -> {((Button) event.getSource()).setText("X");});
        });
          
          
          view.playAgainBtn.setOnAction((event) -> {
              view.gameBoardGP.getChildren().forEach((ch) -> {
                  ((Button) ch).setText("");
            });
          });

          view.backBtn.setOnAction((event) -> {Navigator.goToHome();});

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
    
}

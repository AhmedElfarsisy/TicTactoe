/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.options;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;

/**
 *
 * @author A.Elfarsisy
 */
public class OptionsController extends BaseController implements Initializable{
     private  OptionsViewBase view;
    
    //Options Controller Constarctor 
     public OptionsController() {
         //create Options view
        view = new OptionsViewBase();
        view.backBtn.setOnAction((event) -> {Navigator.goToHome();});
        view.recordedGamesBtn.setOnAction((event) -> {Navigator.goToRecordedGame();});
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    //MARK: - Implement BaseController method  
    @Override
    public Pane getView() {
        //set super view
        return view;
    }
    
}

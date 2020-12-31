/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.onlineplayers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;
import tictactoe.presenter.game.GameViewBase;

/**
 * FXML Controller class
 *
 * @author Mostafa Abdalla
 */
public class OnlinePlayersController extends BaseController implements Initializable {

    private OnlinePlayersViewBase view;
    
    public OnlinePlayersController(){
    //create new view
        view = new OnlinePlayersViewBase();
        
        view.backBtn.setOnAction((event) -> {Navigator.goToHome();});
    
    }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.recordedgames;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import tictactoe.helper.BaseController;
import tictactoe.presenter.onlineplayers.OnlinePlayersBase;

/**
 * FXML Controller class
 *
 * @author Mostafa Abdalla
 */
public class RecordedGameController extends BaseController implements Initializable {

    private RecordedGameBase rg;
    
    public RecordedGameController(){
     
        //create new view
        rg= new RecordedGameBase();
        
        //4 - Set viewBase -> Parent = currentView -> Child
        viewBase = rg;
    
        
        
    
    
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

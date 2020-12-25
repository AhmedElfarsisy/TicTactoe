/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.options;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;

/**
 *
 * @author A.Elfarsisy
 */
public class OptionsController extends BaseController implements Initializable{
     private  OptionsViewBase optionsView;
    
    //Options Controller Constarctor 
     public OptionsController() {
         //create Options view
        optionsView = new OptionsViewBase();
        //4 - Set viewBase -> Parent = currentView -> Child
        viewBase = optionsView;
        optionsView.backOptionsBtn.setOnAction((event) -> {Navigator.goToHome();});
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
     //Get Options View 
    public OptionsViewBase getHomeView() {
        return optionsView;
    } 
    
}

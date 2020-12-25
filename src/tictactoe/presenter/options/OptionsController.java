/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.options;
import tictactoe.presenter.home.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.helpers.BaseController;

/**
 *
 * @author A.Elfarsisy
 */
public class OptionsController extends BaseController implements Initializable {
    
 
    
    @FXML
    private OptionsViewBase optionsView;

 
    public OptionsController() {
       
        
        optionsView = new OptionsViewBase();
        this.viewBase=optionsView;
        optionsView.backOptionsBtn.setOnAction((event) -> {navigateBackHome();}); 
        
    }

   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

     
    
}

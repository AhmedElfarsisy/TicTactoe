/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.auth.register;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;

/**
 * FXML Controller class
 *
 * @author Heba
 */
public class RegisterController extends BaseController implements Initializable {

    private RegisterViewBase registerView;

    //Home Controller Constarctor 
    public RegisterController() {
        //create Register view
        registerView = new RegisterViewBase();
        //4 - Set viewBase -> Parent = currentView -> Child
        viewBase = registerView;
        //Go to avaliable  player list  Game screen
        registerView.signUpBtn.setOnAction((event) -> {/*go to player list*/    Navigator.goToGame();});
        //Go to Home screen 
        registerView.signUpBackBtn.setOnAction((event) -> {Navigator.goToHome();});
        //Go to MultiPlayer Offline Game Page
        registerView.signUpBackBtn.setOnAction((event) -> {Navigator.goToLogin();});
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

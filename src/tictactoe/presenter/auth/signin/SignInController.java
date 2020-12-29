/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.auth.signin;

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
public class SignInController extends BaseController implements Initializable {

      private SignInViewBase signInView;

    //SignIn Controller Constarctor 
    public SignInController() {
        //create SignIn view
        signInView = new SignInViewBase();
        //4 - Set viewBase -> Parent = currentView -> Child
        viewBase = signInView;
        //Go to available  Player  screen 
        signInView.loginBtn.setOnAction((event) -> {  /*Navigator.goToAvailable ();*/  Navigator.goToAvailablePlayer();});
        //Go to register  screen
        signInView.signUpHP.setOnAction((event) -> {Navigator.goToRegister();});
        //Go back to home 
        signInView.backBtn.setOnAction((event) -> {   Navigator.goToHome();});
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

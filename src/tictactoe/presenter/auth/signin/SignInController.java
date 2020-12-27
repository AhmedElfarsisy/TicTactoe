/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.auth.signin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;

/**
 * FXML Controller class
 *
 * @author Heba
 */
public class SignInController extends BaseController implements Initializable {

      private SignInViewBase view;

    //SignIn Controller Constarctor 
    public SignInController() {
        //create SignIn view
        view = new SignInViewBase();
        //Go to available  Player  screen 
        view.loginBtn.setOnAction((event) -> {  /*Navigator.goToAvailable ();*/  Navigator.goToGame();});
        //Go to register  screen
        view.signUpHP.setOnAction((event) -> {Navigator.goToRegister();});
        //Go back to home 
        view.backBtn.setOnAction((event) -> {   Navigator.goToHome();});
        
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.auth.register;

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
public class RegisterController extends BaseController implements Initializable {

    private RegisterViewBase view;

    //Home Controller Constarctor 
    public RegisterController() {
        //create Register view
        view = new RegisterViewBase();
        //Go to avaliable  player list  Game screen
        view.signUpBtn.setOnAction((event) -> {/*go to player list*/    Navigator.goToHome();});
        //Go to Home screen 
        view.signUpBackBtn.setOnAction((event) -> {Navigator.goToHome();});
        //Go to MultiPlayer Offline Game Page
        view.signUpBackBtn.setOnAction((event) -> {Navigator.goToLogin();});
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

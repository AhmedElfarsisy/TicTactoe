/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.auth.signin;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;
import javafx.fxml.Initializable;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tictactoe.helper.Constants;


/**
 * FXML Controller class
 *
 * @author Heba
 */
public class SignInController extends BaseController implements Initializable {

      private SignInViewBase signInView;
      Alert userErr= new Alert(Alert.AlertType.WARNING);
     
    //SignIn Controller Constarctor 
    public SignInController() {
        //create SignIn view
        signInView = new SignInViewBase();
        //4 - Set viewBase -> Parent = currentView -> Child
        viewBase = signInView;
        //Go to available  Player  screen 
        //signInView.loginBtn.setOnAction((event) -> {  /*Navigator.goToAvailable ();*/  Navigator.goToGame();});
        signInView.loginBtn.setOnAction((event) -> {  /*Navigator.goToAvailable ();*/  
          //  signInValidation.totalSignInValidation();
        String userName = signInView.userNameTF.getText();
        String pass = signInView.passwordPF.getText();
           

            try {
                if (!userName.matches(Constants.VALIDATION_REGEX_USER)) {
                    userErr.setContentText("Username should be more than 3 and begins with a letter");
                    userErr.show();
                } else if (!pass.matches(Constants.VALIDATION_REGEX_PASS)) {
                    userErr.setContentText("Password shouldn't be less than 3 letters");
                    userErr.show();
                } else {
                    Navigator.goToGame();
                }

            } catch (PatternSyntaxException ex) {
                // Invalid regex 
                ex.printStackTrace();
            }
        });

        //Go to register  screen
        signInView.signUpHP.setOnAction((event) -> {Navigator.goToRegister();});
        //Go back to home 
        signInView.backBtn.setOnAction((event) -> {   Navigator.goToHome();});
        
    }
    
    @FXML
      private Button loginBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}

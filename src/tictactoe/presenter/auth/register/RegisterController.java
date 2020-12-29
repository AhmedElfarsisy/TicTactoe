/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.auth.register;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import tictactoe.helper.BaseController;
import tictactoe.helper.Constants;
import tictactoe.helper.Navigator;

/**
 * FXML Controller class
 *
 * @author Heba
 */
public class RegisterController extends BaseController implements Initializable {

    private RegisterViewBase registerView;
    Alert userErr = new Alert(Alert.AlertType.WARNING);

    //Home Controller Constarctor 
    public RegisterController() {
        //create Register view
        registerView = new RegisterViewBase();
        //4 - Set viewBase -> Parent = currentView -> Child
        viewBase = registerView;
        //Go to avaliable  player list  Game screen
        registerView.signUpBtn.setOnAction((event) -> {
            /*go to player list*/ //case 1: user entered a value more than 20 or less than 3 for user name
            String userName = registerView.userNameTF.getText();
            String pass = registerView.passwordPF.getText();
            String confPass = registerView.confirmPasswordPF.getText();

            try {
                if (!userName.matches(Constants.VALIDATION_REGEX_USER)) {
                    userErr.setContentText("Username should be more than 3 and begins with a letter");
                    userErr.show();
                } else if (!pass.matches(Constants.VALIDATION_REGEX_PASS)) {
                    userErr.setContentText("Password shouldn't be less than 3 letters");
                    userErr.show();
                } else if (!pass.equals(confPass)) {
                    userErr.setContentText("Password fields should have the same input");
                    userErr.show();
                } else {
                    Navigator.goToGame();
                }

            } catch (PatternSyntaxException ex) {
                // Invalid regex 
                ex.printStackTrace();
            }

        });
        //Go to Home screen 
        registerView.signUpBackBtn.setOnAction((event) -> {
            Navigator.goToHome();
        });
        //Go to MultiPlayer Offline Game Page
        registerView.signUpBackBtn.setOnAction((event) -> {
            Navigator.goToLogin();
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

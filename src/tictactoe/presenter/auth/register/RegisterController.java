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
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Constants;
import tictactoe.helper.Navigator;
import tictactoe.helper.UIHelper;
import tictactoe.model.PlayMode;
import tictactoe.model.User;
import tictactoe.network.ClientSession;
import tictactoe.network.NWDelegate;
import tictactoe.network.NetworkSession;
import tictactoe.network.model.NWResponse;
import tictactoe.network.model.Request;
import tictactoe.network.model.RequestType;
import tictactoe.repository.defaults.DefaultKey;
import tictactoe.repository.defaults.UserDefaults;

/**
 * FXML Controller class
 *
 * @author Heba
 */
public class RegisterController extends BaseController implements Initializable, NWDelegate {

    Alert userErr = new Alert(Alert.AlertType.WARNING);
    private RegisterViewBase view;

    //Home Controller Constarctor 
    public RegisterController() {
        
        NetworkSession.getInstance().setDelegate(this);

        //create Register view
        view = new RegisterViewBase();
        //Go to avaliable  player list  Game screen

        view.signUpBtn.setOnAction((event) -> {
            /*go to player list*/ //case 1: user entered a value more than 20 or less than 3 for user name
            String userName = view.userNameTF.getText();
            String pass = view.passwordPF.getText();
            String confPass = view.confirmPasswordPF.getText();

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
                    Request<User> request = new Request<>(RequestType.SIGNUP, new User(userName, pass));
                    NetworkSession.getInstance().sendRequest(request);

                }

            } catch (PatternSyntaxException ex) {
                // Invalid regex 
                ex.printStackTrace();
            }

        });
        //Go to Home screen 
        view.backBtn.setOnAction((event) -> {
            Navigator.goToHome();
        });
        //Go to MultiPlayer Offline Game Page
        view.backBtn.setOnAction((event) -> {
            Navigator.goToLogin();
        });

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
    //MARK: - Implement NWDelegate Method

    @Override
    public void handleResponse(Object data) {
        Constants.currentUser = (User) data;
        Navigator.goToAvailablePlayer();
    }
}

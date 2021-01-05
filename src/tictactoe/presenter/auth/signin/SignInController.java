/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.auth.signin;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.PatternSyntaxException;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.TilePane;
import tictactoe.helper.Constants;
import tictactoe.helper.UIHelper;
import tictactoe.model.Move;
import tictactoe.model.User;
import tictactoe.network.NWDelegate;
import tictactoe.network.NetworkSession;
import tictactoe.network.model.NWResponse;
import tictactoe.network.model.Request;
import tictactoe.network.model.RequestType;
import tictactoe.helper.VideoPlayer;

/**
 * FXML Controller class
 *
 * @author Heba
 */
public class SignInController extends BaseController implements Initializable, NWDelegate {

    Alert userErr = new Alert(Alert.AlertType.WARNING);
    private SignInViewBase view;

    //SignIn Controller Constarctor 
    public SignInController() {
        NetworkSession.getInstance().setDelegate(this);
        view = new SignInViewBase();

        view.loginBtn.setOnAction((event) -> {
            String userName = view.userNameTF.getText();
            String pass = view.passwordPF.getText();

            try {
                if (!userName.matches(Constants.VALIDATION_REGEX_USER)) {
                    userErr.setContentText("Username should be more than 3 and begins with a letter");
                    userErr.show();
                } else if (!pass.matches(Constants.VALIDATION_REGEX_PASS)) {
                    userErr.setContentText("Password shouldn't be less than 3 letters");
                    userErr.show();
                } else {
                    Request<User> request = new Request<>(RequestType.LOGIN, new User(userName, pass));
                    NetworkSession.getInstance().sendRequest(request);

                }

            } catch (PatternSyntaxException ex) {
                // Invalid regex 
                ex.printStackTrace();
            }
        });

        //Go to register  screen
        view.signUpHP.setOnAction((event) -> {
            Navigator.goToRegister();
        });
        //Go back to home 
        view.backBtn1.setOnAction((event) -> {
            Navigator.goToHome();
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

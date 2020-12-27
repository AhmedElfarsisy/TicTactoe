/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.auth.signin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tictactoe.presenter.auth.signin.SignInViewBase;
/**
 * FXML Controller class
 *
 * @author Heba
 */
public class MySignInViewController implements Initializable {
     SignInViewBase signInViewBase= new SignInViewBase();
     SignInValidation signInValidation= new SignInValidation();
    @FXML
      private Button loginBtn;
    @FXML
    private Label loginLbl;
    @FXML
    private Label userNameLbl;
    @FXML
    private TextField userNameTF;
    @FXML
    private Label passwordLbl;
    @FXML
    private PasswordField passwordPF;
    @FXML
    private Hyperlink signUpHP;
    @FXML
    private Label notHaveAccountLbl;
    @FXML
    private Button backBtn;
    @FXML
    private Label xCandyOLbl;
    @FXML
    private Label letsPlayLbl;
    @FXML
    private Label ticTacToeLbl;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call validation functon here
                signInValidation.signInValidation();
            }
        });
        
        
        signUpHP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //move to signUp page
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    
    
}

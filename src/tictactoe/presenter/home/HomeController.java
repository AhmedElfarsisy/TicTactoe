/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.home;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;

/**
 *
 * @author A.Elfarsisy
 */
public class HomeController extends BaseController implements Initializable {

    private HomeViewBase view;

    //Home Controller Constarctor 
    public HomeController() {
        //create Home view
        view = new HomeViewBase();
        //Go to Single Game Page
        view.singlePlayerBtn.setOnAction((event) -> {Navigator.goToGame();});
        
        //Go to MultiPlayer Offline Game Page
          view.multiPlayerOnlineBtn.setOnAction((event) -> {Navigator.goToLogin();});
        //homeView.multiPlayerOnlineBtn.setOnAction((event) -> {Navigator.goToOnlinePlayers();});

        //Go to MultiPlayer Offline Game Page
        view.multiPlayerOfflineBtn.setOnAction((event) -> {Navigator.goToGame();});

        //Go to Option Page
        view.optionsBtn.setOnAction((event) -> {
            Navigator.goToOptions();
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    //Get Home View 

        //MARK: - Implement BaseController method  
    @Override
    public Pane getView() {
        //set super view
        return view;
    }

}

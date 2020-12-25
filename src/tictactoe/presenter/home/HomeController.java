/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.home;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import tictactoe.helper.BaseController;
import tictactoe.helper.Navigator;

/**
 *
 * @author A.Elfarsisy
 */
public class HomeController extends BaseController implements Initializable {

    private HomeViewBase homeView;

    //Home Controller Constarctor 
    public HomeController() {
        //create Home view
        homeView = new HomeViewBase();
        //4 - Set viewBase -> Parent = currentView -> Child
        viewBase = homeView;
        //Go to Single Game Page
        homeView.singlePlayerBtn.setOnAction((event) -> {Navigator.goToGame();});
        
        //Go to MultiPlayer Offline Game Page
        homeView.multiPlayerOnlineBtn.setOnAction((event) -> {Navigator.goToLogin();});
        //Go to MultiPlayer Offline Game Page
        homeView.multiPlayerOfflineBtn.setOnAction((event) -> {Navigator.goToGame();});

        //Go to Option Page
        homeView.optionsBtn.setOnAction((event) -> {
            Navigator.goToOptions();
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    //Get Home View 

    public HomeViewBase getHomeView() {
        return homeView;
    }

}

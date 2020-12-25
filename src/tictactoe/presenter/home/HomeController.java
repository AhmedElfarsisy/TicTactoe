/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.home;

import tictactoe.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tictactoe.presenter.options.OptionsViewBase;

/**
 *
 * @author A.Elfarsisy
 */
public class HomeController implements Initializable {
     @FXML
    private HomeViewBase homeView;
    Stage stage;

    public HomeController(Stage s) {
        stage = s;
        homeView = new HomeViewBase();
        homeView.optionsBtn.setOnAction((event) -> {navigateToOptions();});
    }

    public HomeViewBase getHomeView() {
        return homeView;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    public void navigateToOptions() {
        Parent root = new OptionsViewBase();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

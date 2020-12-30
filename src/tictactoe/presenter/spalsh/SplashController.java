/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.presenter.spalsh;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import tictactoe.helper.BaseController;
/**
 *
 * @author yasmineghazy
 */

//3 - Inherit from BaseController
public class SplashController extends BaseController implements Initializable {
    
    //MARK: - Properties
    private final SplashViewBase view;
    
    //MARK: - Constructor
    public SplashController(){
        
        //create new view
        view = new SplashViewBase();
        
    }
    
    public static SplashController buildVC(){
        return new SplashController();
    }

    
    //MARK: - Implement Initializable callback method
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
    
    //MARK: - Methods
    
}

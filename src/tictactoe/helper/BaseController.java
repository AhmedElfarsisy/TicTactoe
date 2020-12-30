/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.helper;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

/**
 *
 * @author yasmineghazy
 * This Class is the base controller that all controllers inherits from.
 */

public abstract class BaseController{
    
    //Child will override this method and return its own view
    public abstract Pane getView();  
}

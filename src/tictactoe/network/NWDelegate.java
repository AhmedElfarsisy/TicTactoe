/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.network;

import java.util.ArrayList;
import tictactoe.model.Move;
import tictactoe.model.User;

/**
 *
 * @author A.Elfarsisy
 */
public interface NWDelegate {

    default public void updateMove(Move move) {}

    default public void handleResponse(Object data) {}
    
    default public void requestGame(User user){}
    
    default public void acceptGame(User user){}
    
    default public void rejectGame(User user){}
    default public void updateOnlinePlayers(ArrayList<User> players){}
    
}

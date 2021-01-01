/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.network.model.Request;
import tictactoe.network.model.RequestType;
import tictactoe.network.model.User;

/**
 *
 * @author A.Elfarsisy
 */
public class ClientSession {

    Socket mySocket;
    ObjectInputStream ois;
    ObjectOutputStream oos;

    public ClientSession() {

        try {
            mySocket = new Socket(InetAddress.getLocalHost(), 5006);
            oos = new ObjectOutputStream(mySocket.getOutputStream());
            ois = new ObjectInputStream(mySocket.getInputStream());

        } catch (IOException ex) {
            try {
                oos.close();
                ois.close();
                mySocket.close();
                Logger.getLogger(ClientSession.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex1) {
                Logger.getLogger(ClientSession.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }

    public void sendRequest(Request<User> request) {
        try {
            oos.writeObject(request);
            oos.flush();
        } catch (IOException ex) {
            try {
                ois.close();
                oos.close();
                mySocket.close();
                Logger.getLogger(ClientSession.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex1) {
                Logger.getLogger(ClientSession.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

}

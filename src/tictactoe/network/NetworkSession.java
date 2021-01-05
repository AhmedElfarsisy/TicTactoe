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
import java.net.SocketException;
import java.util.ArrayList;

import javafx.application.Platform;
import tictactoe.helper.Toast;
import tictactoe.model.User;
import tictactoe.network.model.GameModel;
import tictactoe.network.model.NWResponse;
import tictactoe.network.model.Request;

/**
 *
 * @author A.Elfarsisy
 */
public class NetworkSession extends Thread {

    ObjectInputStream ois;
    ObjectOutputStream oos;
    Socket serverSocket;
    NWDelegate delegate;
    Object readObject;

    private static NetworkSession shared;

    public static NetworkSession getInstance() {
        if (shared == null) {
            shared = new NetworkSession();
        }
        return shared;
    }

    private NetworkSession() {

        if (isConnectionAvailable()) {
            start();
        }

    }

    private Boolean isConnectionAvailable() {

        if (oos == null || serverSocket.isClosed()) {
            startConnection();
        }
        return oos != null && !serverSocket.isClosed();

    }

    private void startConnection() {

        try {
            serverSocket = new Socket(InetAddress.getLocalHost(), 5006);
            oos = new ObjectOutputStream(serverSocket.getOutputStream());
            ois = new ObjectInputStream(serverSocket.getInputStream());

        } catch (IOException ex) {
            System.out.println("ex 1" + ex.getMessage());
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                readObject = ois.readObject();
                if (readObject instanceof Request) {
                    handleRequest((Request) readObject);
                } else {
                    handleResponse((NWResponse) readObject);
                }
            } catch (SocketException se) {
                System.out.println(se.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("ex 2 " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("ex 3 " + ex.getMessage());
            }
        }
    }

    public void setDelegate(NWDelegate delegate) {
        this.delegate = delegate;
    }

    private void handleResponse(NWResponse response) {
        Platform.runLater(
                () -> {
                    // Update UI here.
                    switch (response.getStatus()) {
                        case SUCCESS:
                            delegate.handleResponse(response.getData());
                            break;
                        case FAILURE:
                            Toast.showError(response.getMessage());
                            break;
                    }
                }
        );

    }

    private void handleRequest(Request request) {
        Platform.runLater(
                () -> {
                    if(delegate!=null)
                    switch (request.getType()) {
                        case PLAYGAME:
                            GameModel data = (GameModel) request.getData();
                            delegate.updateMove(data.getMove());
                            break;
                        case REQUESTGAME:
                            delegate.requestGame((User) request.getData());
                            break;
                        case ACCEPTGAME:
                            delegate.acceptGame((User) request.getData());
                            break;
                        case REJECTGAME:
                            delegate.rejectGame((User) request.getData());
                            break;
                        case UPDATEONLINEPLAYERS:
                            delegate.updateOnlinePlayers((ArrayList<User>) request.getData());
                            break;
                            

                    }
                });
    }

    public void sendRequest(Request request) {
        if (isConnectionAvailable()) {

            try {
                System.out.println("\n\n\n================================\n"
                        + "Client : request sent: "
                        + request.getType() + ""
                        + ""
                        + "\n==============================\n");
                oos.writeObject(request);
                oos.flush();
            } catch (SocketException se) {
                System.out.println(se.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            Toast.showError("Sorry, No Connection");
        }
    }

   public  void closeConnection() {
        try {
            System.out.println("Client:Connction closed ");
            oos.close();
            ois.close();
            serverSocket.close();
            stop();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

}

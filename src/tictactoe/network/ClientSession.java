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
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.network.model.GameModel;
import tictactoe.network.model.NWResponse;
import tictactoe.network.model.Request;
import tictactoe.network.model.ResponseStatus;

/**
 *
 * @author A.Elfarsisy
 */
public class ClientSession {

    Socket mySocket;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    static ClientSession shared;
    NWDelegate delegate;

    public static ClientSession getInstance() {
        if (shared == null) {
            shared = new ClientSession();
        }
        return shared;
    }

    private ClientSession() {
        establishConnection();

    }

    public void setDelegate(NWDelegate delegate) {
        this.delegate = delegate;
    }

    public NWResponse sendRequest(Request request) {
        NWResponse response = null;
        try {
            if (mySocket.isClosed()) {
                establishConnection();
            }
            System.out.println("\n\n\n================================\n"
                    + "CLIENT : request sent: "
                    + request.getType() + " "
                    + request.getData().toString() + ""
                    + "\n==============================\n");
            oos.writeObject(request);
            oos.flush();

            Object readObject = ois.readObject();
            if (readObject instanceof Request) {
                handleRequest((Request) readObject);
                System.out.println("\n\n\n================================\n"
                        + "CLIENT : request Recieved: "
                        + request.getType() + " "
                        + request.getData().toString() + ""
                        + "\n==============================\n");
            } else {
                response = (NWResponse) readObject;
                if(response!=null){
                System.out.println("\n\n\n================================\n"
                        + "Client : response recieved : "
                        + response.getStatus() + " "
                        + response.getData().toString() + " "
                        + response.getMessage() + ""
                        + "\n==============================\n");}
            }

        } catch (SocketException se) {
            try {
                oos.close();
                ois.close();
                mySocket.close();
                response = new NWResponse(null, ResponseStatus.FAILURE, se.getMessage());
                se.printStackTrace();
            } catch (IOException ex) {
                response = new NWResponse(null, ResponseStatus.FAILURE, ex.getMessage());
                Logger.getLogger(ClientSession.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            response = new NWResponse(null, ResponseStatus.FAILURE, ex.getMessage());
            try {
                oos.close();
                ois.close();
                mySocket.close();
                Logger.getLogger(ClientSession.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex1) {
                response = new NWResponse(null, ResponseStatus.FAILURE, ex.getMessage());
                Logger.getLogger(ClientSession.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (ClassNotFoundException ex) {
            response = new NWResponse(null, ResponseStatus.FAILURE, ex.getMessage());
            Logger.getLogger(ClientSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    private void establishConnection() {
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

    private void handleRequest(Request request) {
        NWResponse response = null;

        switch (request.getType()) {
            case PLAYGAME:
//                response = handlePlayGame(request);
                GameModel data = (GameModel) request.getData();
                System.out.println(data.getMove().getX() + "  " + data.getMove().getY());
                delegate.updateMove(data.getMove());
                break;

        }
    }

}

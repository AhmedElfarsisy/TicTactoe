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
import javafx.application.Platform;
import tictactoe.helper.Toast;
import tictactoe.network.model.GameModel;
import tictactoe.network.model.NWResponse;
import tictactoe.network.model.Request;
import tictactoe.network.model.ResponseStatus;

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
        try {
            serverSocket = new Socket(InetAddress.getLocalHost(), 5006);
            oos = new ObjectOutputStream(serverSocket.getOutputStream());
            ois = new ObjectInputStream(serverSocket.getInputStream());
            start();
        } catch (IOException ex) {
            Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex);
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
            } catch (IOException ex) {
                try {
                    stop();
                    ois.close();
                    oos.close();
                    serverSocket.close();
                    Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex1) {
                    Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex);
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
                    switch (request.getType()) {
                        case PLAYGAME:
                            GameModel data = (GameModel) request.getData();
                            delegate.updateMove(data.getMove());
                            break;
                    }
                });
    }

    public void notifyServer(Request request) {
        sendRequest(request, false);
    }

    public NWResponse sendRequest(Request request) {
        return sendRequest(request, true);
    }

    public NWResponse sendRequest(Request request, Boolean hasResponse) {
        NWResponse response = null;
        try {
            oos.writeObject(request);
            oos.flush();
            if (hasResponse) {
                response = (NWResponse) ois.readObject();

                System.out.println("\n\n\n================================\n"
                        + "SERVER : response sent : "
                        + response.getStatus() + ""
                        + response.getData().toString() + ""
                        + response.getMessage() + ""
                        + "\n==============================\n");
            }

        } catch (SocketException se) {
            try {
                oos.close();
                ois.close();
                serverSocket.close();
                response = new NWResponse(null, ResponseStatus.FAILURE, se.getMessage());
                se.printStackTrace();
            } catch (IOException ex) {
                response = new NWResponse(null, ResponseStatus.FAILURE, ex.getMessage());
                Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            response = new NWResponse(null, ResponseStatus.FAILURE, ex.getMessage());
            try {
                oos.close();
                ois.close();
                serverSocket.close();
                Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex1) {
                response = new NWResponse(null, ResponseStatus.FAILURE, ex.getMessage());
                Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

//    public void sendRequest(Request request, Boolean hasResponse) {
//        NWResponse response = null;
//        try {
//            oos.writeObject(request);
//            oos.flush();
//            if (hasResponse) {
//               // response = (NWResponse) ois.readObject();
//               response = (NWResponse) readObject;
//            }
//
//            System.out.println("\n\n\n================================\n"
//                    + "SERVER : response sent : "
//                    + response.getStatus() + ""
//                    + response.getData().toString() + ""
//                    + response.getMessage() + ""
//                    + "\n==============================\n");
//
//        } catch (SocketException se) {
//            try {
//                oos.close();
//                ois.close();
//                serverSocket.close();
//                response = new NWResponse(null, ResponseStatus.FAILURE, se.getMessage());
//                se.printStackTrace();
//            } catch (IOException ex) {
//                response = new NWResponse(null, ResponseStatus.FAILURE, ex.getMessage());
//                Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (IOException ex) {
//            response = new NWResponse(null, ResponseStatus.FAILURE, ex.getMessage());
//            try {
//                oos.close();
//                ois.close();
//                serverSocket.close();
//                Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex1) {
//                response = new NWResponse(null, ResponseStatus.FAILURE, ex.getMessage());
//                Logger.getLogger(NetworkSession.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//        }
//        return response;
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.helper;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author A.Elfarsisy
 */
public class Toast {

    public static void showError(String message) {
        Platform.runLater(
                () -> {
                    Alert a = new Alert(AlertType.ERROR, message);
                    a.show();
                });
    }

    public static void showSuccess(String message) {
        Platform.runLater(
                () -> {
                    Alert a = new Alert(AlertType.INFORMATION, message);
                    a.show();
                });
    }

}

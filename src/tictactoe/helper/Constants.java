/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.helper;

import tictactoe.model.User;

/**
 *
 * @author yasmineghazy
 */
public class Constants {

    //Background Path in the app 
    public static String BACKGROUND = "/tictactoe/resource/images/background.jpg";
    public static String STYLE = "/tictactoe/resource/style/Style.css";
    public static String VALIDATION_REGEX_USER = "\\b[a-zA-Z][a-zA-Z0-9\\-._]{3,}\\b";
    public static String VALIDATION_REGEX_PASS = "\\b[a-zA-Z0-9\\-._]{3,}\\b";
    public static String SPLASH = "/tictactoe/resource/images/loading.gif";
    public static String LOADER = "/tictactoe/resource/images/loader.gif";
    public static String MUSIC = "/tictactoe/resource/sounds/music.mp3";
     public static User currentUser;

    public static String getFileDirectory() {
        String fileDirectroy = System.getProperty("user.dir");
        fileDirectroy += "/XCandyO/";
        return fileDirectroy;
    }
}

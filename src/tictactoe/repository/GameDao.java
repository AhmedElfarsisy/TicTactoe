/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import tictactoe.helper.Constants;
import tictactoe.model.Game;
import tictactoe.repository.models.Player;

/**
 *
 * @author A.Elfarsisy
 */
public class GameDao {

    File gameFile;
    ArrayList<Game> gamesList;
    File[] listFiles;
    private static GameDao shared;

    private GameDao() {
    }

    public static GameDao getInstance() {
        if (shared == null) {
            shared = new GameDao();
        }
        return shared;
    }

    public void createGameFile() {
        String property = System.getProperty("user.dir");
        File file = new File(property, "XCandyO");
        file.mkdir();
    }

    public void createRecordGameFile(String playerName) {
        try {
            Date date = new Date();
            long time = date.getTime();
            //Uniqu folder Name for player

            //Create directory called XCandyO insind it you can find players directories
            File playerDirectory = new File(Constants.getFileDirectory(), playerName);
            playerDirectory.mkdir();
            playerDirectory.getAbsolutePath();
            //Unique file  name for game with it date the file inside the player name 
            gameFile = new File(playerDirectory.getAbsolutePath(), time + ".txt");
            gameFile.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void writeGame(Object object) {
        try {
            System.out.println("Write Games");
            //String gameName = gameFile.getName();
            FileOutputStream fos = new FileOutputStream(gameFile);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(fos);
            objectOutStream.writeObject(object);
            objectOutStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Game> readGamesFromFiles(String gamePlayerName) {
        File file = new File(Constants.getFileDirectory(), gamePlayerName);
        gamesList = new ArrayList<>();
        if (file.exists()) {
            listFiles = file.listFiles();
            for (File f : listFiles) {
                try {
                    FileInputStream fos = new FileInputStream(f);
                    ObjectInputStream objectOutStream = new ObjectInputStream(fos);
                    Game gameObject = (Game) objectOutStream.readObject();
                    gamesList.add(gameObject);
                    objectOutStream.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

            }

        }

        return gamesList;

    }

}

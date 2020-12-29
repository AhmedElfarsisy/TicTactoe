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
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.helper.Constants;
import tictactoe.repository.models.Game;
import tictactoe.repository.models.Player;

/**
 *
 * @author A.Elfarsisy
 */
public class GameDao {

    Game game;
    Player player1;
    Player player2;
    Player player;
    File gameFile;
    ArrayList<Game> gamesList;
    File[] listFiles;

    public GameDao() {
        System.out.println("Dao Constratctor");
        player1 = new Player("Ahmed Elfarsisy", 50);
        player2 = new Player("Yassmin Ghazy", 160);
        player = new Player("Mostfa", 150);

    }

    public void createGameFile() {
        String property = System.getProperty("user.dir");
        File file = new File(property, "XCandyO");
        file.mkdir();
    }

    public void createRecordGameFile() {
        try {
            System.out.println("create Record game file");
            Date date = new Date();
            long time = date.getTime();
            //Uniqu folder Name for player
            String gamePlayerName =player1.getName();
            //Create directory called XCandyO insind it you can find players directories
            File playerDirectory = new File(Constants.getFileDirectory(), gamePlayerName);
            playerDirectory.mkdir();
            playerDirectory.getAbsolutePath();
            //Unique file  name for game with it date the file inside the player name 
            gameFile = new File(playerDirectory.getAbsolutePath(), time + ".txt");
            gameFile.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void writeGame() {
        try {
            System.out.println("Write Games");
            //String gameName = gameFile.getName();
            FileOutputStream fos = new FileOutputStream(gameFile);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(fos);
            objectOutStream.writeObject(game);
            objectOutStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void getRecordedGames() {
        System.out.println("get Record Games");
        String gamePlayerName;
        gamePlayerName = player1.getName();
        File file = new File(Constants.getFileDirectory(), gamePlayerName);
        if (file.exists()) {
            listFiles = file.listFiles();
        }

    }

    public ArrayList<Game> readGamesFromFiles() {
        System.out.println("Read recorded games");
        gamesList = new ArrayList<>();

        for (File f : listFiles) {
            try {
                //      String gameName = gameFile.getName();
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
       
            return gamesList; 
        
    }

    public void addDummyData() {
        System.out.println("Add dummy data");
      
        game = new Game(player1.getName(), player2.getName(), "win");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.repository.defaults;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yasmineghazy
 */
public class UserDefaults {

    File file;
    ObjectOutput objectOS;
    ObjectInput objectIS;
    Map<DefaultKey, Object> map;

    //Singelton object
    private static UserDefaults shared;

    public static UserDefaults getInstance() {
        if (shared == null) {
            shared = new UserDefaults();
        }
        return shared;
    }

    public UserDefaults() {
        try {
            String property = System.getProperty("user.dir") + "/XCandyO/";
            //Create logical file
            file = new File(property, "UserDefaults.txt");
            file.createNewFile();
            map = new HashMap<>();
        } catch (IOException ex) {
            Logger.getLogger(UserDefaults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveMap() {
        try {
            if (file.exists()) {
                // write to file
                objectOS = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file, false)));
                objectOS.writeObject(map);
                objectOS.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserDefaults.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserDefaults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void set(DefaultKey key, Object value) {

        // write to file
        map.put(key, value);
        saveMap();
    }

    public void loadMap() {
        try {
            // read from file
            if (file.exists()) {
                objectIS = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                map = (Map<DefaultKey, Object>) objectIS.readObject();
                objectIS.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserDefaults.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UserDefaults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object get(DefaultKey key) {
        loadMap();
        return map.get(key);
    }

    public void remove(DefaultKey key) {
        loadMap();
        map.remove(key);
        saveMap();
    }

}

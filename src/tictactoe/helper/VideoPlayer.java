/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.helper;

import java.io.File;
import java.util.Optional;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import tictactoe.repository.defaults.DefaultKey;
import tictactoe.repository.defaults.UserDefaults;
import tictactoe.presenter.auth.register.RegisterViewBase;


/**
 *
 * @author Heba
 */
public class VideoPlayer {
    private static MediaPlayer mediaPlayer;
    private static MediaView mediaView;
    private Thread thread;
    
    private static VideoPlayer shared; 
    //userState indicate whether a user is winner or loser
    public static VideoPlayer getInstance(String userState){
        if(shared == null)
            shared = new VideoPlayer(userState);
        
        return shared;
    }
    
    //decide upon player status
    private VideoPlayer(String userState) {
            //thread = new Thread(new Runnable() {
              //@Override
              //public void run() {
                  String fileDirectroy = System.getProperty("user.dir");
                  String winnerVideoFile = fileDirectroy + "/src/tictactoe/resource/videos/vid0.mp4";
                  String loserVideoFile = fileDirectroy + "/src/tictactoe/resource/videos/vid2.mp4";
                  Media video;
                  if (userState.equalsIgnoreCase("winner")){
                      video = new Media(new File(winnerVideoFile).toURI().toString());
                      mediaPlayer = new MediaPlayer(video);
                      
                  }else{
                      video = new Media(new File(loserVideoFile).toURI().toString());
                      mediaPlayer = new MediaPlayer(video);
                  }
                  //mediaPlayer.setAutoPlay(true);
                  
                  //mediaPlayer = new MediaPlayer(video);
                  
                  //mediaPlayer.setAutoPlay(true);
                  //mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                  /*
                  mediaPlayer.setVolume(getVolume());
                  mediaPlayer.setOnReady(() -> {
                  mediaPlayer.play();
                  });
                  
                  
                  mediaPlayer.setOnReady(() -> {
                  mediaPlayer.play();
                  });
                  */
                  //mediaPlayer.setOnEndOfMedia(() -> {
                  //mediaPlayer.seek(Duration.ZERO); //new play time
                  //});
                  
                  
                  //Scene scene = new Scene(new RegisterController() , 200, 100);
                  
                  //mediaPlayer.play();
                
                }
              
          
          //});
    //}   
    
    
    
    public  void setVolume(Double volume){
//        if(volume == 0){
//            stop();
//        }
        mediaPlayer.setVolume(volume);
        UserDefaults.getInstance().set(DefaultKey.MUSICVOLUME, volume);
    }
    
    public Double getVolume(){
        Double volume = (Double) UserDefaults.getInstance().get(DefaultKey.MUSICVOLUME);
        if(volume == null){
            setVolume(0.5);
        }
        return volume;
    }

    
    public void play(){
        
        mediaPlayer.play();
        mediaView = new MediaView(mediaPlayer);
        
        mediaView.setX(300);
        mediaView.setY(100);
        mediaView.setFitWidth(600);
        mediaView.setFitHeight(400);
        //thread.start();   */
        
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setResizable(false);
        alert.getDialogPane().setPrefSize(600, 400);
        VBox content = new VBox(200, mediaView);
        //alert.setContentText("Result");
        content.setAlignment(Pos.CENTER);
        alert.getDialogPane().setContent(content);
        alert.setOnShowing(e -> mediaPlayer.play());
        alert.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = alert.showAndWait();
        //if (result.isPresent() /*&& result.get() == ButtonType.CANCEL*/) {
            //alert.hide();
            mediaPlayer.stop();
        //}
    }
    
    public void stop(){
        mediaPlayer.stop();
        //thread.stop();
        //System.out.println(thread.getState());
        //System.out.println(Thread.activeCount());
    }}
    


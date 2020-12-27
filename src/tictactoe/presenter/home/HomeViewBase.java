package tictactoe.presenter.home;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tictactoe.helper.Constants;

public  class HomeViewBase extends Pane {

    protected final ImageView backgroundIV;
    protected final VBox vBox;
    protected final Label homeLbl;
    protected  Button singlePlayerBtn;
    protected  Button multiPlayerOfflineBtn;
    protected  Button multiPlayerOnlineBtn;
    protected  Button optionsBtn;
    protected  Button logoutBtn;
    protected final Label gameNameLbl;
    protected final Label letUsPlayLbl;
    protected final Label ticTacToeLbl;

    public HomeViewBase() {

        backgroundIV = new ImageView();
        vBox = new VBox();
        homeLbl = new Label();
        singlePlayerBtn = new Button();
        multiPlayerOfflineBtn = new Button();
        multiPlayerOnlineBtn = new Button();
        optionsBtn = new Button();
        logoutBtn = new Button();
        gameNameLbl = new Label();
        letUsPlayLbl = new Label();
        ticTacToeLbl = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #ffffff;");

        backgroundIV.setFitHeight(400.0);
        backgroundIV.setFitWidth(300.0);
        backgroundIV.setPickOnBounds(true);
        backgroundIV.setImage(new Image(getClass().getResource(Constants.BACKGROUND).toExternalForm()));

        vBox.setLayoutX(300.0);
        vBox.setPrefHeight(400.0);
        vBox.setPrefWidth(300.0);
        vBox.setSpacing(10.0);
        vBox.setStyle("-fx-background-color: #FFFFFF;");

        homeLbl.setAlignment(javafx.geometry.Pos.CENTER);
        homeLbl.setPrefHeight(17.0);
        homeLbl.setPrefWidth(293.0);
        homeLbl.setText("Home");
        homeLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        homeLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        homeLbl.setFont(new Font("Cooper Black", 30.0));
        VBox.setMargin(homeLbl, new Insets(10.0, 0.0, 0.0, 0.0));

        singlePlayerBtn.setMnemonicParsing(false);
        singlePlayerBtn.setPrefHeight(25.0);
        singlePlayerBtn.setPrefWidth(303.0);
        singlePlayerBtn.setStyle("-fx-background-color: #00B8D0;");
        singlePlayerBtn.setText("Single Player");
        singlePlayerBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        VBox.setMargin(singlePlayerBtn, new Insets(48.0, 0.0, 0.0, 0.0));
        singlePlayerBtn.setFont(new Font("Cooper Black", 20.0));

        multiPlayerOfflineBtn.setMnemonicParsing(false);
        multiPlayerOfflineBtn.setPrefHeight(25.0);
        multiPlayerOfflineBtn.setPrefWidth(303.0);
        multiPlayerOfflineBtn.setStyle("-fx-background-color: #00B8D0;");
        multiPlayerOfflineBtn.setText("Multi Player offline");
        multiPlayerOfflineBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        multiPlayerOfflineBtn.setFont(new Font("Cooper Black", 20.0));

        multiPlayerOnlineBtn.setMnemonicParsing(false);
        multiPlayerOnlineBtn.setPrefHeight(25.0);
        multiPlayerOnlineBtn.setPrefWidth(303.0);
        multiPlayerOnlineBtn.setStyle("-fx-background-color: #00B8D0;");
        multiPlayerOnlineBtn.setText("Multi Player online");
        multiPlayerOnlineBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        multiPlayerOnlineBtn.setFont(new Font("Cooper Black", 20.0));

        optionsBtn.setMnemonicParsing(false);
        optionsBtn.setPrefHeight(25.0);
        optionsBtn.setPrefWidth(303.0);
        optionsBtn.setStyle("-fx-background-color: #00B8D0;");
        optionsBtn.setText("Options");
        optionsBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        optionsBtn.setFont(new Font("Cooper Black", 20.0));

        logoutBtn.setMnemonicParsing(false);
        logoutBtn.setPrefHeight(25.0);
        logoutBtn.setPrefWidth(303.0);
        logoutBtn.setStyle("-fx-background-color: #00B8D0;");
        logoutBtn.setText("Logout");
        logoutBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        logoutBtn.setFont(new Font("Cooper Black", 20.0));
        vBox.setPadding(new Insets(10.0));

        gameNameLbl.setAlignment(javafx.geometry.Pos.CENTER);
        gameNameLbl.setLayoutX(4.0);
        gameNameLbl.setLayoutY(20.0);
        gameNameLbl.setPrefHeight(17.0);
        gameNameLbl.setPrefWidth(293.0);
        gameNameLbl.setText("X CANDY O");
        gameNameLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameNameLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        gameNameLbl.setFont(new Font("Cooper Black", 30.0));

        letUsPlayLbl.setAlignment(javafx.geometry.Pos.CENTER);
        letUsPlayLbl.setLayoutX(4.0);
        letUsPlayLbl.setLayoutY(145.0);
        letUsPlayLbl.setPrefHeight(17.0);
        letUsPlayLbl.setPrefWidth(293.0);
        letUsPlayLbl.setText("Let 's play ");
        letUsPlayLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        letUsPlayLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        letUsPlayLbl.setFont(new Font("Cooper Black", 20.0));

        ticTacToeLbl.setAlignment(javafx.geometry.Pos.CENTER);
        ticTacToeLbl.setLayoutX(4.0);
        ticTacToeLbl.setLayoutY(176.0);
        ticTacToeLbl.setPrefHeight(17.0);
        ticTacToeLbl.setPrefWidth(293.0);
        ticTacToeLbl.setText("Tic-Tac-Toe");
        ticTacToeLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        ticTacToeLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        ticTacToeLbl.setFont(new Font("Cooper Black", 30.0));

        getChildren().add(backgroundIV);
        vBox.getChildren().add(homeLbl);
        vBox.getChildren().add(singlePlayerBtn);
        vBox.getChildren().add(multiPlayerOfflineBtn);
        vBox.getChildren().add(multiPlayerOnlineBtn);
        vBox.getChildren().add(optionsBtn);
        vBox.getChildren().add(logoutBtn);
        getChildren().add(vBox);
        getChildren().add(gameNameLbl);
        getChildren().add(letUsPlayLbl);
        getChildren().add(ticTacToeLbl);
        
        logoutBtn.setVisible(false);

    }
}

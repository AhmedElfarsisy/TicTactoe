package tictactoe.presenter.onlineplayers;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tictactoe.helper.Constants;

public class OnlinePlayersViewBase extends Pane {

    protected final ImageView backgroundIV;
    protected final VBox vBox;
    protected final Label playerLbl;
    protected final ListView LV;
    protected final Button asktoplaybtn;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Button backBtn;

    public OnlinePlayersViewBase() {

        backgroundIV = new ImageView();
        vBox = new VBox();
        playerLbl = new Label();
        LV = new ListView();
        asktoplaybtn = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        backBtn = new Button();

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
        backgroundIV.setImage(new Image(getClass().getResourceAsStream(Constants.BACKGROUND)));

        vBox.setLayoutX(300.0);
        vBox.setPrefHeight(400.0);
        vBox.setPrefWidth(300.0);
        vBox.setSpacing(10.0);
        vBox.setStyle("-fx-background-color: #FFFFFF;");

        playerLbl.setAlignment(javafx.geometry.Pos.CENTER);
        playerLbl.setPrefHeight(17.0);
        playerLbl.setPrefWidth(293.0);
        playerLbl.setText("Online Players");
        playerLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        playerLbl.setFont(new Font("Cooper Black", 30.0));
        VBox.setMargin(playerLbl, new Insets(10.0, 0.0, 0.0, 0.0));

        LV.setPrefHeight(200.0);
        LV.setPrefWidth(200.0);

        asktoplaybtn.setMnemonicParsing(false);
        asktoplaybtn.setPrefHeight(25.0);
        asktoplaybtn.setPrefWidth(303.0);
        asktoplaybtn.setStyle("-fx-background-color: #00B8D0;");
        asktoplaybtn.setText("Ask to play");
        asktoplaybtn.setTextFill(javafx.scene.paint.Color.WHITE);
        asktoplaybtn.setFont(new Font("Cooper Black", 20.0));
        vBox.setPadding(new Insets(10.0));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(4.0);
        label.setLayoutY(20.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(293.0);
        label.setText("X CANDY O");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        label.setFont(new Font("Cooper Black", 30.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(4.0);
        label0.setLayoutY(145.0);
        label0.setPrefHeight(17.0);
        label0.setPrefWidth(293.0);
        label0.setText("Let ’s play ");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        label0.setFont(new Font("Cooper Black", 20.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setLayoutX(4.0);
        label1.setLayoutY(176.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(293.0);
        label1.setText("Tic-Tac-Toe");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        label1.setFont(new Font("Cooper Black", 30.0));

        backBtn.setLayoutX(500.0);
        backBtn.setLayoutY(350.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(50.0);
        backBtn.setPrefWidth(100.0);
        backBtn.setStyle("-fx-background-color: white;");
        backBtn.setText("back>");
        backBtn.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        backBtn.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        backBtn.setFont(new Font("Cooper Black", 20.0));

        getChildren().add(backgroundIV);
        vBox.getChildren().add(playerLbl);
        vBox.getChildren().add(LV);
        vBox.getChildren().add(asktoplaybtn);
        getChildren().add(vBox);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(backBtn);

    }
}

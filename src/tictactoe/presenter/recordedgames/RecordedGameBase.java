package tictactoe.presenter.recordedgames;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tictactoe.helper.Constants;
import tictactoe.repository.models.Game;

public  class RecordedGameBase extends Pane {

    protected final ImageView backgroundIV;
    protected final VBox vBox;
    protected final Label label;
    protected  TableView recordedGamestTV;
    protected  TableColumn<Game,String> player1RecordedGameTC;
    protected  TableColumn<Game,String> player2RecordedGameTC;
    protected  TableColumn<Game,String> resultRecordedGameTC;
    protected  Button showbtn;
    protected  Button backbtn;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;

    public RecordedGameBase() {

        backgroundIV = new ImageView();
        vBox = new VBox();
        label = new Label();
        recordedGamestTV = new TableView();
        player1RecordedGameTC = new TableColumn();
        player2RecordedGameTC = new TableColumn();
        resultRecordedGameTC = new TableColumn();
        showbtn = new Button();
        backbtn = new Button();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();

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

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setPrefHeight(17.0);
        label.setPrefWidth(293.0);
        label.setText("Recorded Games");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        label.setFont(new Font("Cooper Black", 30.0));
        VBox.setMargin(label, new Insets(10.0, 0.0, 0.0, 0.0));

        recordedGamestTV.setPrefHeight(200.0);
        recordedGamestTV.setPrefWidth(200.0);

        player1RecordedGameTC.setPrefWidth(107.0);
        player1RecordedGameTC.setText("player");

        player2RecordedGameTC.setPrefWidth(94.0);
        player2RecordedGameTC.setText("player2");

        resultRecordedGameTC.setPrefWidth(78.0);
        resultRecordedGameTC.setText("result");

        showbtn.setMnemonicParsing(false);
        showbtn.setPrefHeight(25.0);
        showbtn.setPrefWidth(303.0);
        showbtn.setStyle("-fx-background-color: #00B8D0;");
        showbtn.setText("show");
        showbtn.setTextFill(javafx.scene.paint.Color.WHITE);
        showbtn.setFont(new Font("Cooper Black", 20.0));

        backbtn.setAlignment(javafx.geometry.Pos.BOTTOM_RIGHT);
        backbtn.setLayoutX(20.0);
        backbtn.setLayoutY(285.0);
        backbtn.setMnemonicParsing(false);
        backbtn.setPrefHeight(38.0);
        backbtn.setPrefWidth(95.0);
        backbtn.setStyle("-fx-background-color: #00B8D0;");
        backbtn.setText("Back>");
        backbtn.setTextFill(javafx.scene.paint.Color.WHITE);
        backbtn.setFont(new Font("Cooper Black", 20.0));
        VBox.setMargin(backbtn, new Insets(0.0, 0.0, 0.0, 185.0));
        vBox.setPadding(new Insets(10.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(4.0);
        label0.setLayoutY(20.0);
        label0.setPrefHeight(17.0);
        label0.setPrefWidth(293.0);
        label0.setText("X CANDY O");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        label0.setFont(new Font("Cooper Black", 30.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setLayoutX(4.0);
        label1.setLayoutY(145.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(293.0);
        label1.setText("Let �s play ");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        label1.setFont(new Font("Cooper Black", 20.0));

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setLayoutX(4.0);
        label2.setLayoutY(176.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(293.0);
        label2.setText("Tic-Tac-Toe");
        label2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        label2.setFont(new Font("Cooper Black", 30.0));

        getChildren().add(backgroundIV);
        vBox.getChildren().add(label);
        recordedGamestTV.getColumns().add(player1RecordedGameTC);
        recordedGamestTV.getColumns().add(player2RecordedGameTC);
        recordedGamestTV.getColumns().add(resultRecordedGameTC);
        vBox.getChildren().add(recordedGamestTV);
        vBox.getChildren().add(showbtn);
        vBox.getChildren().add(backbtn);
        getChildren().add(vBox);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);

    }
}

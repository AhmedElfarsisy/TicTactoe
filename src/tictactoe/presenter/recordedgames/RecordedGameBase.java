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

public class RecordedGameBase extends Pane {

    protected final ImageView backgroundIV;
    protected final VBox vBox;
    protected final Label label;
    protected final TableView recordedGamestTV;
    protected final TableColumn<Game,String> player1RecordedGameTC;
    protected final TableColumn<Game,String>  player2RecordedGameTC;
    protected final TableColumn<Game,String> resultRecordedGameTC;
    protected final TableColumn<Game,String> resultRecordedGameTC1;
    protected final Button showBtn;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Button backBtn;

    public RecordedGameBase() {

        backgroundIV = new ImageView();
        vBox = new VBox();
        label = new Label();
        recordedGamestTV = new TableView();
        player1RecordedGameTC = new TableColumn();
        player2RecordedGameTC = new TableColumn();
        resultRecordedGameTC = new TableColumn();
        resultRecordedGameTC1 = new TableColumn();
        showBtn = new Button();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
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

        player1RecordedGameTC.setPrefWidth(70.0);
        player1RecordedGameTC.setText("player");

        player2RecordedGameTC.setPrefWidth(70.0);
        player2RecordedGameTC.setText("player2");

        resultRecordedGameTC.setPrefWidth(70.0);
        resultRecordedGameTC.setText("result");

        resultRecordedGameTC1.setPrefWidth(70.0);
        resultRecordedGameTC1.setText("Date");

        showBtn.setMnemonicParsing(false);
        showBtn.setPrefHeight(25.0);
        showBtn.setPrefWidth(303.0);
        showBtn.setStyle("-fx-background-color: #00B8D0;");
        showBtn.setText("show");
        showBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        showBtn.setFont(new Font("Cooper Black", 20.0));
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
        label1.setText("Let ’s play ");
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
        vBox.getChildren().add(label);
        recordedGamestTV.getColumns().add(player1RecordedGameTC);
        recordedGamestTV.getColumns().add(player2RecordedGameTC);
        recordedGamestTV.getColumns().add(resultRecordedGameTC);
        recordedGamestTV.getColumns().add(resultRecordedGameTC1);
        vBox.getChildren().add(recordedGamestTV);
        vBox.getChildren().add(showBtn);
        getChildren().add(vBox);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(backBtn);

    }
}

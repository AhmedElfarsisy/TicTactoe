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

public class RecordedGameBase extends Pane {

    protected final ImageView backgroundIV;
    protected final VBox vBox;
    protected final Label label;
    protected final TableView tableView;
    protected final TableColumn player1;
    protected final TableColumn player2;
    protected final TableColumn result;
    protected final Button showbtn;
    protected final Button backbtn;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;

    public RecordedGameBase() {

        backgroundIV = new ImageView();
        vBox = new VBox();
        label = new Label();
        tableView = new TableView();
        player1 = new TableColumn();
        player2 = new TableColumn();
        result = new TableColumn();
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
        backgroundIV.setImage(new Image(getClass().getResourceAsStream(Constants.background)));


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

        tableView.setPrefHeight(200.0);
        tableView.setPrefWidth(200.0);

        player1.setPrefWidth(107.0);
        player1.setText("player");

        player2.setPrefWidth(94.0);
        player2.setText("player2");

        result.setPrefWidth(78.0);
        result.setText("result");

        showbtn.setMnemonicParsing(false);
        showbtn.setPrefHeight(25.0);
        showbtn.setPrefWidth(303.0);
        showbtn.setStyle("-fx-background-color: #00B8D0;");
        showbtn.setText("show");
        showbtn.setTextFill(javafx.scene.paint.Color.WHITE);
        showbtn.setFont(new Font("Cooper Black", 20.0));

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
        tableView.getColumns().add(player1);
        tableView.getColumns().add(player2);
        tableView.getColumns().add(result);
        vBox.getChildren().add(tableView);
        vBox.getChildren().add(showbtn);
        vBox.getChildren().add(backbtn);
        getChildren().add(vBox);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);

    }
}

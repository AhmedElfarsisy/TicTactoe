package tictactoe.presenter.game;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tictactoe.helper.Constants;

public class GameViewBase extends BorderPane {

    protected final HBox hBox;
    protected final StackPane stackPane;
    protected final ImageView backgroundIV;
    protected final BorderPane borderPane;
    protected final Label gameNameLbl;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Label playersLbl;
    protected final Label firstPlayerNameLbl;
    protected final Label secondPlayerNameLbl;
    protected final Label firstPlayerCharLbl;
    protected final Label secondPlayerCharLbl;
    protected final Label scoreLbl;
    protected final Label firstPlayerScoreLbl;
    protected final Label secondPlayerScoreLbl;
    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final AnchorPane anchorPane1;
    protected final VBox vBox;
    protected final BorderPane borderPane0;
    protected final Label playerTurnLbl;
    protected final BorderPane borderPane1;
    protected final GridPane gameBoardGP;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Button boardBtn00;
    protected final Button boardBtn01;
    protected final Button boardBtn02;
    protected final Button boardBtn10;
    protected final Button boardBtn11;
    protected final Button boardBtn12;
    protected final Button boardBtn20;
    protected final Button boardBtn21;
    protected final Button boardBtn22;
    protected final AnchorPane anchorPane2;
    protected final AnchorPane anchorPane3;
    protected final AnchorPane anchorPane4;
    protected final AnchorPane anchorPane5;
    protected final AnchorPane anchorPane6;
    protected final Button playAgainBtn;
    protected final AnchorPane anchorPane7;
    protected final Button backBtn;
    protected final AnchorPane anchorPane8;
    protected final AnchorPane anchorPane9;
    protected final AnchorPane anchorPane10;
    protected final AnchorPane anchorPane11;

    public GameViewBase() {

        hBox = new HBox();
        stackPane = new StackPane();
        backgroundIV = new ImageView();
        borderPane = new BorderPane();
        gameNameLbl = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        playersLbl = new Label();
        firstPlayerNameLbl = new Label();
        secondPlayerNameLbl = new Label();
        firstPlayerCharLbl = new Label();
        secondPlayerCharLbl = new Label();
        scoreLbl = new Label();
        firstPlayerScoreLbl = new Label();
        secondPlayerScoreLbl = new Label();
        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        anchorPane1 = new AnchorPane();
        vBox = new VBox();
        borderPane0 = new BorderPane();
        playerTurnLbl = new Label();
        borderPane1 = new BorderPane();
        gameBoardGP = new GridPane();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        boardBtn00 = new Button();
        boardBtn01 = new Button();
        boardBtn02 = new Button();
        boardBtn10 = new Button();
        boardBtn11 = new Button();
        boardBtn12 = new Button();
        boardBtn20 = new Button();
        boardBtn21 = new Button();
        boardBtn22 = new Button();
        anchorPane2 = new AnchorPane();
        anchorPane3 = new AnchorPane();
        anchorPane4 = new AnchorPane();
        anchorPane5 = new AnchorPane();
        anchorPane6 = new AnchorPane();
        playAgainBtn = new Button();
        anchorPane7 = new AnchorPane();
        backBtn = new Button();
        anchorPane8 = new AnchorPane();
        anchorPane9 = new AnchorPane();
        anchorPane10 = new AnchorPane();
        anchorPane11 = new AnchorPane();

        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: white;");

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(400.0);
        hBox.setPrefWidth(669.0);

        stackPane.setPrefHeight(150.0);
        stackPane.setPrefWidth(200.0);

        backgroundIV.setFitHeight(400.0);
        backgroundIV.setFitWidth(300.0);
        backgroundIV.setPickOnBounds(true);
        backgroundIV.setImage(new Image(getClass().getResource(Constants.BACKGROUND).toExternalForm()));

        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(gameNameLbl, javafx.geometry.Pos.CENTER);
        gameNameLbl.setAlignment(javafx.geometry.Pos.CENTER);
        gameNameLbl.setPrefHeight(50.0);
        gameNameLbl.setPrefWidth(293.0);
        gameNameLbl.setText("X CANDY O");
        gameNameLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameNameLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        gameNameLbl.setFont(new Font("Cooper Black", 30.0));
        borderPane.setTop(gameNameLbl);
        StackPane.setMargin(borderPane, new Insets(10.0));

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(170.0);
        gridPane.setPrefWidth(267.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(75.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(75.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(80.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(69.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(86.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(76.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowIndex(playersLbl, 1);
        playersLbl.setAlignment(javafx.geometry.Pos.CENTER);
        playersLbl.setPrefHeight(17.0);
        playersLbl.setPrefWidth(293.0);
        playersLbl.setText("Players");
        playersLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playersLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        playersLbl.setFont(new Font("Cooper Black", 14.0));

        GridPane.setColumnIndex(firstPlayerNameLbl, 1);
        firstPlayerNameLbl.setAlignment(javafx.geometry.Pos.CENTER);
        firstPlayerNameLbl.setPrefHeight(17.0);
        firstPlayerNameLbl.setPrefWidth(293.0);
        firstPlayerNameLbl.setText("You");
        firstPlayerNameLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        firstPlayerNameLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        firstPlayerNameLbl.setFont(new Font("Cooper Black", 14.0));

        GridPane.setColumnIndex(secondPlayerNameLbl, 2);
        secondPlayerNameLbl.setAlignment(javafx.geometry.Pos.CENTER);
        secondPlayerNameLbl.setPrefHeight(17.0);
        secondPlayerNameLbl.setPrefWidth(293.0);
        secondPlayerNameLbl.setText("Computer");
        secondPlayerNameLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        secondPlayerNameLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        secondPlayerNameLbl.setFont(new Font("Cooper Black", 14.0));

        GridPane.setColumnIndex(firstPlayerCharLbl, 1);
        GridPane.setRowIndex(firstPlayerCharLbl, 1);
        firstPlayerCharLbl.setAlignment(javafx.geometry.Pos.CENTER);
        firstPlayerCharLbl.setPrefHeight(17.0);
        firstPlayerCharLbl.setPrefWidth(293.0);
        firstPlayerCharLbl.setText("X");
        firstPlayerCharLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        firstPlayerCharLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        firstPlayerCharLbl.setFont(new Font("Cooper Black", 20.0));

        GridPane.setColumnIndex(secondPlayerCharLbl, 2);
        GridPane.setRowIndex(secondPlayerCharLbl, 1);
        secondPlayerCharLbl.setAlignment(javafx.geometry.Pos.CENTER);
        secondPlayerCharLbl.setPrefHeight(17.0);
        secondPlayerCharLbl.setPrefWidth(293.0);
        secondPlayerCharLbl.setText("O");
        secondPlayerCharLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        secondPlayerCharLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        secondPlayerCharLbl.setFont(new Font("Cooper Black", 20.0));

        GridPane.setRowIndex(scoreLbl, 2);
        scoreLbl.setAlignment(javafx.geometry.Pos.CENTER);
        scoreLbl.setPrefHeight(17.0);
        scoreLbl.setPrefWidth(293.0);
        scoreLbl.setText("Score");
        scoreLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        scoreLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        scoreLbl.setFont(new Font("Cooper Black", 14.0));

        GridPane.setColumnIndex(firstPlayerScoreLbl, 1);
        GridPane.setRowIndex(firstPlayerScoreLbl, 2);
        firstPlayerScoreLbl.setAlignment(javafx.geometry.Pos.CENTER);
        firstPlayerScoreLbl.setPrefHeight(17.0);
        firstPlayerScoreLbl.setPrefWidth(293.0);
        firstPlayerScoreLbl.setText("0");
        firstPlayerScoreLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        firstPlayerScoreLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        firstPlayerScoreLbl.setFont(new Font("Cooper Black", 20.0));

        GridPane.setColumnIndex(secondPlayerScoreLbl, 2);
        GridPane.setRowIndex(secondPlayerScoreLbl, 2);
        secondPlayerScoreLbl.setAlignment(javafx.geometry.Pos.CENTER);
        secondPlayerScoreLbl.setPrefHeight(17.0);
        secondPlayerScoreLbl.setPrefWidth(293.0);
        secondPlayerScoreLbl.setText("0");
        secondPlayerScoreLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        secondPlayerScoreLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        secondPlayerScoreLbl.setFont(new Font("Cooper Black", 20.0));
        gridPane.setPadding(new Insets(50.0, 0.0, 0.0, 0.0));
        borderPane.setCenter(gridPane);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(224.0);
        anchorPane.setPrefWidth(6.0);
        borderPane.setLeft(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(224.0);
        anchorPane0.setPrefWidth(7.0);
        borderPane.setRight(anchorPane0);

        BorderPane.setAlignment(anchorPane1, javafx.geometry.Pos.CENTER);
        anchorPane1.setPrefHeight(148.0);
        anchorPane1.setPrefWidth(280.0);
        borderPane.setBottom(anchorPane1);

        vBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        vBox.setPrefHeight(400.0);
        vBox.setPrefWidth(470.0);
        vBox.setSpacing(10.0);

        borderPane0.setPrefHeight(399.0);
        borderPane0.setPrefWidth(280.0);

        BorderPane.setAlignment(playerTurnLbl, javafx.geometry.Pos.CENTER);
        playerTurnLbl.setAlignment(javafx.geometry.Pos.CENTER);
        playerTurnLbl.setPrefHeight(50.0);
        playerTurnLbl.setPrefWidth(280.0);
        playerTurnLbl.setText("Your Turn");
        playerTurnLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerTurnLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        playerTurnLbl.setFont(new Font("Cooper Black", 30.0));
        borderPane0.setTop(playerTurnLbl);

        BorderPane.setAlignment(borderPane1, javafx.geometry.Pos.CENTER);
        borderPane1.setPrefHeight(200.0);
        borderPane1.setPrefWidth(200.0);

        BorderPane.setAlignment(gameBoardGP, javafx.geometry.Pos.CENTER);
        gameBoardGP.setAlignment(javafx.geometry.Pos.CENTER);
        gameBoardGP.setHgap(10.0);
        gameBoardGP.setPrefHeight(200.0);
        gameBoardGP.setPrefWidth(200.0);
        gameBoardGP.setVgap(10.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(100.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(100.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(100.0);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        boardBtn00.setMnemonicParsing(false);
        boardBtn00.setPrefHeight(25.0);
        boardBtn00.setPrefWidth(303.0);
        boardBtn00.setStyle("-fx-background-color: #00B8D0;");
        boardBtn00.setTextFill(javafx.scene.paint.Color.WHITE);
        boardBtn00.setFont(new Font("Cooper Black", 20.0));

        GridPane.setColumnIndex(boardBtn01, 1);
        boardBtn01.setMnemonicParsing(false);
        boardBtn01.setPrefHeight(25.0);
        boardBtn01.setPrefWidth(303.0);
        boardBtn01.setStyle("-fx-background-color: #00B8D0;");
        boardBtn01.setTextFill(javafx.scene.paint.Color.WHITE);
        boardBtn01.setFont(new Font("Cooper Black", 20.0));

        GridPane.setColumnIndex(boardBtn02, 2);
        boardBtn02.setMnemonicParsing(false);
        boardBtn02.setPrefHeight(25.0);
        boardBtn02.setPrefWidth(303.0);
        boardBtn02.setStyle("-fx-background-color: #00B8D0;");
        boardBtn02.setTextFill(javafx.scene.paint.Color.WHITE);
        boardBtn02.setFont(new Font("Cooper Black", 20.0));

        GridPane.setRowIndex(boardBtn10, 1);
        boardBtn10.setMnemonicParsing(false);
        boardBtn10.setPrefHeight(25.0);
        boardBtn10.setPrefWidth(303.0);
        boardBtn10.setStyle("-fx-background-color: #00B8D0;");
        boardBtn10.setTextFill(javafx.scene.paint.Color.WHITE);
        boardBtn10.setFont(new Font("Cooper Black", 20.0));

        GridPane.setColumnIndex(boardBtn11, 1);
        GridPane.setRowIndex(boardBtn11, 1);
        boardBtn11.setMnemonicParsing(false);
        boardBtn11.setPrefHeight(25.0);
        boardBtn11.setPrefWidth(303.0);
        boardBtn11.setStyle("-fx-background-color: #00B8D0;");
        boardBtn11.setTextFill(javafx.scene.paint.Color.WHITE);
        boardBtn11.setFont(new Font("Cooper Black", 20.0));

        GridPane.setColumnIndex(boardBtn12, 2);
        GridPane.setRowIndex(boardBtn12, 1);
        boardBtn12.setMnemonicParsing(false);
        boardBtn12.setPrefHeight(25.0);
        boardBtn12.setPrefWidth(303.0);
        boardBtn12.setStyle("-fx-background-color: #00B8D0;");
        boardBtn12.setTextFill(javafx.scene.paint.Color.WHITE);
        boardBtn12.setFont(new Font("Cooper Black", 20.0));

        GridPane.setRowIndex(boardBtn20, 2);
        boardBtn20.setMnemonicParsing(false);
        boardBtn20.setPrefHeight(25.0);
        boardBtn20.setPrefWidth(303.0);
        boardBtn20.setStyle("-fx-background-color: #00B8D0;");
        boardBtn20.setTextFill(javafx.scene.paint.Color.WHITE);
        boardBtn20.setFont(new Font("Cooper Black", 20.0));

        GridPane.setColumnIndex(boardBtn21, 1);
        GridPane.setRowIndex(boardBtn21, 2);
        boardBtn21.setMnemonicParsing(false);
        boardBtn21.setPrefHeight(25.0);
        boardBtn21.setPrefWidth(303.0);
        boardBtn21.setStyle("-fx-background-color: #00B8D0;");
        boardBtn21.setTextFill(javafx.scene.paint.Color.WHITE);
        boardBtn21.setFont(new Font("Cooper Black", 20.0));

        GridPane.setColumnIndex(boardBtn22, 2);
        GridPane.setRowIndex(boardBtn22, 2);
        boardBtn22.setMnemonicParsing(false);
        boardBtn22.setPrefHeight(25.0);
        boardBtn22.setPrefWidth(303.0);
        boardBtn22.setStyle("-fx-background-color: #00B8D0;");
        boardBtn22.setTextFill(javafx.scene.paint.Color.WHITE);
        boardBtn22.setFont(new Font("Cooper Black", 20.0));
        borderPane1.setCenter(gameBoardGP);

        BorderPane.setAlignment(anchorPane2, javafx.geometry.Pos.CENTER);
        anchorPane2.setPrefHeight(45.0);
        anchorPane2.setPrefWidth(280.0);
        borderPane1.setTop(anchorPane2);

        BorderPane.setAlignment(anchorPane3, javafx.geometry.Pos.CENTER);
        anchorPane3.setPrefHeight(150.0);
        anchorPane3.setPrefWidth(50.0);
        borderPane1.setLeft(anchorPane3);

        BorderPane.setAlignment(anchorPane4, javafx.geometry.Pos.CENTER);
        anchorPane4.setPrefHeight(150.0);
        anchorPane4.setPrefWidth(50.0);
        borderPane1.setRight(anchorPane4);

        BorderPane.setAlignment(anchorPane5, javafx.geometry.Pos.CENTER);
        anchorPane5.setPrefHeight(45.0);
        anchorPane5.setPrefWidth(280.0);
        borderPane1.setBottom(anchorPane5);
        borderPane0.setCenter(borderPane1);

        BorderPane.setAlignment(anchorPane6, javafx.geometry.Pos.CENTER);
        anchorPane6.setPrefHeight(303.0);
        anchorPane6.setPrefWidth(0.0);
        borderPane0.setRight(anchorPane6);

        BorderPane.setAlignment(playAgainBtn, javafx.geometry.Pos.CENTER);
        playAgainBtn.setMnemonicParsing(false);
        playAgainBtn.setPrefHeight(40.0);
        playAgainBtn.setPrefWidth(347.0);
        playAgainBtn.setStyle("-fx-background-color: #00B8D0;");
        playAgainBtn.setText("Play Again");
        playAgainBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        playAgainBtn.setFont(new Font("Cooper Black", 20.0));
        borderPane0.setBottom(playAgainBtn);

        BorderPane.setAlignment(anchorPane7, javafx.geometry.Pos.CENTER);
        anchorPane7.setPrefHeight(240.0);
        anchorPane7.setPrefWidth(1.0);
        borderPane0.setLeft(anchorPane7);

        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(50.0);
        backBtn.setPrefWidth(100.0);
        backBtn.setStyle("-fx-background-color: white;");
        backBtn.setText("back>");
        backBtn.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        backBtn.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        backBtn.setFont(new Font("Cooper Black", 20.0));
        VBox.setMargin(backBtn, new Insets(0.0, -10.0, 0.0, 0.0));
        vBox.setPadding(new Insets(10.0, 10.0, 0.0, 10.0));
        setCenter(hBox);

        BorderPane.setAlignment(anchorPane8, javafx.geometry.Pos.CENTER);
        anchorPane8.setPrefHeight(0.0);
        anchorPane8.setPrefWidth(567.0);
        setTop(anchorPane8);

        BorderPane.setAlignment(anchorPane9, javafx.geometry.Pos.CENTER);
        anchorPane9.setPrefHeight(400.0);
        anchorPane9.setPrefWidth(0.0);
        setLeft(anchorPane9);

        BorderPane.setAlignment(anchorPane10, javafx.geometry.Pos.CENTER);
        anchorPane10.setPrefHeight(400.0);
        anchorPane10.setPrefWidth(0.0);
        setRight(anchorPane10);

        BorderPane.setAlignment(anchorPane11, javafx.geometry.Pos.CENTER);
        anchorPane11.setPrefHeight(0.0);
        anchorPane11.setPrefWidth(767.0);
        setBottom(anchorPane11);

        stackPane.getChildren().add(backgroundIV);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(playersLbl);
        gridPane.getChildren().add(firstPlayerNameLbl);
        gridPane.getChildren().add(secondPlayerNameLbl);
        gridPane.getChildren().add(firstPlayerCharLbl);
        gridPane.getChildren().add(secondPlayerCharLbl);
        gridPane.getChildren().add(scoreLbl);
        gridPane.getChildren().add(firstPlayerScoreLbl);
        gridPane.getChildren().add(secondPlayerScoreLbl);
        stackPane.getChildren().add(borderPane);
        hBox.getChildren().add(stackPane);
        gameBoardGP.getColumnConstraints().add(columnConstraints2);
        gameBoardGP.getColumnConstraints().add(columnConstraints3);
        gameBoardGP.getColumnConstraints().add(columnConstraints4);
        gameBoardGP.getRowConstraints().add(rowConstraints2);
        gameBoardGP.getRowConstraints().add(rowConstraints3);
        gameBoardGP.getRowConstraints().add(rowConstraints4);
        gameBoardGP.getChildren().add(boardBtn00);
        gameBoardGP.getChildren().add(boardBtn01);
        gameBoardGP.getChildren().add(boardBtn02);
        gameBoardGP.getChildren().add(boardBtn10);
        gameBoardGP.getChildren().add(boardBtn11);
        gameBoardGP.getChildren().add(boardBtn12);
        gameBoardGP.getChildren().add(boardBtn20);
        gameBoardGP.getChildren().add(boardBtn21);
        gameBoardGP.getChildren().add(boardBtn22);
        vBox.getChildren().add(borderPane0);
        vBox.getChildren().add(backBtn);
        hBox.getChildren().add(vBox);

    }
}

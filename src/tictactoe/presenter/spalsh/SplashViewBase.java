package tictactoe.presenter.spalsh;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import tictactoe.helper.Constants;

public  class SplashViewBase extends AnchorPane {

    protected final StackPane stackPane;
    protected final ImageView backgroundIV;
    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final AnchorPane anchorPane1;
    protected final Label gameNameLbl;

    public SplashViewBase() {

        stackPane = new StackPane();
        backgroundIV = new ImageView();
        borderPane = new BorderPane();
        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        anchorPane1 = new AnchorPane();
        gameNameLbl = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        stackPane.setPrefHeight(150.0);
        stackPane.setPrefWidth(200.0);

        backgroundIV.setFitHeight(450.0);
        backgroundIV.setFitWidth(600.0);
        backgroundIV.setPickOnBounds(true);
        backgroundIV.setImage(new Image(getClass().getResource(Constants.SPLASH).toExternalForm()));

        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);
        StackPane.setMargin(borderPane, new Insets(0.0));

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

        BorderPane.setAlignment(gameNameLbl, javafx.geometry.Pos.CENTER);
        gameNameLbl.setAlignment(javafx.geometry.Pos.CENTER);
        gameNameLbl.setPrefHeight(128.0);
        gameNameLbl.setPrefWidth(338.0);
        gameNameLbl.setText("Welcome to our Game X CANDY O");
        gameNameLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameNameLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        gameNameLbl.setWrapText(true);
        gameNameLbl.setFont(new Font("Cooper Black", 30.0));
        borderPane.setTop(gameNameLbl);

        stackPane.getChildren().add(backgroundIV);
        stackPane.getChildren().add(borderPane);
        getChildren().add(stackPane);

    }
}

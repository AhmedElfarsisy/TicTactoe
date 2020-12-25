package tictactoe.presenter.options;

import tictactoe.presenter.home.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class HomeViewBase extends Pane {

    protected final ImageView backgroundIV;
    protected final VBox vBox;
    protected final Label homeLbl;
    protected final Button singlePlayerBtn;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;

  public HomeViewBase(Stage stage) {

        backgroundIV = new ImageView();
        vBox = new VBox();
        homeLbl = new Label();
        singlePlayerBtn = new Button();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();

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
        backgroundIV.setImage(new Image(getClass().getResourceAsStream("/tictactoe/resource/images/background.jpeg")));
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

        button.setMnemonicParsing(false);
        button.setPrefHeight(25.0);
        button.setPrefWidth(303.0);
        button.setStyle("-fx-background-color: #00B8D0;");
        button.setText("Multi Player offline");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("Cooper Black", 20.0));

        button0.setMnemonicParsing(false);
        button0.setPrefHeight(25.0);
        button0.setPrefWidth(303.0);
        button0.setStyle("-fx-background-color: #00B8D0;");
        button0.setText("Multi Player online");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font("Cooper Black", 20.0));

        button1.setMnemonicParsing(false);
        button1.setPrefHeight(25.0);
        button1.setPrefWidth(303.0);
        button1.setStyle("-fx-background-color: #00B8D0;");
        button1.setText("Options");
        button1.setTextFill(javafx.scene.paint.Color.WHITE);
        button1.setFont(new Font("Cooper Black", 20.0));

        button2.setMnemonicParsing(false);
        button2.setPrefHeight(25.0);
        button2.setPrefWidth(303.0);
        button2.setStyle("-fx-background-color: #00B8D0;");
        button2.setText("Logout");
        button2.setTextFill(javafx.scene.paint.Color.WHITE);
        button2.setFont(new Font("Cooper Black", 20.0));
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
        label0.setText("Let �s play ");
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

        getChildren().add(backgroundIV);
        vBox.getChildren().add(homeLbl);
        vBox.getChildren().add(singlePlayerBtn);
        vBox.getChildren().add(button);
        vBox.getChildren().add(button0);
        vBox.getChildren().add(button1);
        vBox.getChildren().add(button2);
        getChildren().add(vBox);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);

    }

  
   

}

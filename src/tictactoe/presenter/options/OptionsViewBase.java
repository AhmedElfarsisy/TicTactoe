package tictactoe.presenter.options;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tictactoe.helper.Constants;

public class OptionsViewBase extends Pane {

    protected final ImageView backgroundIV;
    protected final VBox VBox;
    protected final Label homeLbl;
    protected final Button recordedGamesBtn;
    protected final Button themesBtn;
    protected final HBox hBox;
    protected final Label homeLbl1;
    protected final Slider slider;
    protected final Button levelsBtn;
    protected final Label gameNameLbl;
    protected final Label letUsPlayLbl;
    protected final Label ticTacToeLbl;
    protected final Button backBtn;

    public OptionsViewBase() {

        backgroundIV = new ImageView();
        VBox = new VBox();
        homeLbl = new Label();
        recordedGamesBtn = new Button();
        themesBtn = new Button();
        hBox = new HBox();
        homeLbl1 = new Label();
        slider = new Slider();
        levelsBtn = new Button();
        gameNameLbl = new Label();
        letUsPlayLbl = new Label();
        ticTacToeLbl = new Label();
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

        VBox.setLayoutX(300.0);
        VBox.setPrefHeight(400.0);
        VBox.setPrefWidth(300.0);
        VBox.setSpacing(10.0);
        VBox.setStyle("-fx-background-color: #FFFFFF;");

        homeLbl.setAlignment(javafx.geometry.Pos.CENTER);
        homeLbl.setPrefHeight(17.0);
        homeLbl.setPrefWidth(293.0);
        homeLbl.setText("Options");
        homeLbl.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        homeLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        homeLbl.setFont(new Font("Cooper Black", 30.0));
        VBox.setMargin(homeLbl, new Insets(10.0, 0.0, 0.0, 0.0));

        recordedGamesBtn.setMnemonicParsing(false);
        recordedGamesBtn.setPrefHeight(25.0);
        recordedGamesBtn.setPrefWidth(303.0);
        recordedGamesBtn.setStyle("-fx-background-color: #00B8D0;");
        recordedGamesBtn.setText("Recorded Games");
        recordedGamesBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        VBox.setMargin(recordedGamesBtn, new Insets(48.0, 0.0, 0.0, 0.0));
        recordedGamesBtn.setFont(new Font("Cooper Black", 20.0));

        themesBtn.setMnemonicParsing(false);
        themesBtn.setPrefHeight(25.0);
        themesBtn.setPrefWidth(303.0);
        themesBtn.setStyle("-fx-background-color: #00B8D0;");
        themesBtn.setText("Themes");
        themesBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        themesBtn.setFont(new Font("Cooper Black", 20.0));

        hBox.setPrefHeight(40.0);
        hBox.setPrefWidth(280.0);

        homeLbl1.setPrefHeight(40.0);
        homeLbl1.setPrefWidth(293.0);
        homeLbl1.setText("Music Volume");
        homeLbl1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        homeLbl1.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        homeLbl1.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        homeLbl1.setFont(new Font(14.0));

        slider.setBlockIncrement(0.1);
        slider.setMax(1.0);
        slider.setMin(0.0);
        slider.setPrefHeight(40.0);
        slider.setPrefWidth(399.0);
        slider.setValue(0.5);

        levelsBtn.setMnemonicParsing(false);
        levelsBtn.setPrefHeight(25.0);
        levelsBtn.setPrefWidth(303.0);
        levelsBtn.setStyle("-fx-background-color: #00B8D0;");
        levelsBtn.setText("Levels");
        levelsBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        levelsBtn.setFont(new Font("Cooper Black", 20.0));
        VBox.setPadding(new Insets(10.0));

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
        VBox.getChildren().add(homeLbl);
        VBox.getChildren().add(recordedGamesBtn);
        VBox.getChildren().add(themesBtn);
        hBox.getChildren().add(homeLbl1);
        hBox.getChildren().add(slider);
        VBox.getChildren().add(hBox);
        VBox.getChildren().add(levelsBtn);
        getChildren().add(VBox);
        getChildren().add(gameNameLbl);
        getChildren().add(letUsPlayLbl);
        getChildren().add(ticTacToeLbl);
        getChildren().add(backBtn);

    }
}

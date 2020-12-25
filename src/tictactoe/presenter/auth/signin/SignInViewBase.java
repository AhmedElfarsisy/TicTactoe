package tictactoe.presenter.auth.signin;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tictactoe.helper.Constants;

public class SignInViewBase extends GridPane {

    protected final ImageView imageView;
    protected final VBox vBox;
    protected final Label loginLbl;
    protected final Label userNameLbl;
    protected final TextField userNameTF;
    protected final Label passwordLbl;
    protected final PasswordField passwordPF;
    protected final Button loginBtn;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final Hyperlink signUpHP;
    protected final Label notHaveAccountLbl;
    protected final Button backBtn;
    protected final Label xCandyOLbl;
    protected final Label letsPlayLbl;
    protected final Label ticTacToeLbl;

    public SignInViewBase() {

        imageView = new ImageView();
        vBox = new VBox();
        loginLbl = new Label();
        userNameLbl = new Label();
        userNameTF = new TextField();
        passwordLbl = new Label();
        passwordPF = new PasswordField();
        loginBtn = new Button();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        signUpHP = new Hyperlink();
        notHaveAccountLbl = new Label();
        backBtn = new Button();
        xCandyOLbl = new Label();
        letsPlayLbl = new Label();
        ticTacToeLbl = new Label();

        setMaxHeight(400.0);
        setMaxWidth(600.0);
        setMinHeight(400.0);
        setMinWidth(600.0);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(430.0);
        imageView.setFitWidth(648.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource(Constants.background).toExternalForm()));

        vBox.setLayoutX(300.0);
        vBox.setLayoutY(1.0);
        vBox.setPrefHeight(400.0);
        vBox.setPrefWidth(300.0);
        vBox.setStyle("-fx-background-color: #ffffff;");

        loginLbl.setId("loginLbl");
        loginLbl.setText("Login");
        loginLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        loginLbl.setFont(new Font("Cooper Black", 30.0));
        loginLbl.setPadding(new Insets(15.0, 105.0, 15.0, 105.0));
        VBox.setMargin(loginLbl, new Insets(0.0));

        userNameLbl.setId("userNameLbl");
        userNameLbl.setPrefHeight(44.0);
        userNameLbl.setPrefWidth(307.0);
        userNameLbl.setText("User Name");
        userNameLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        userNameLbl.setFont(new Font("Cooper Black", 16.0));
        userNameLbl.setPadding(new Insets(10.0, 0.0, 10.0, 0.0));
        VBox.setMargin(userNameLbl, new Insets(0.0, 10.0, 0.0, 10.0));

        userNameTF.setId("userNameTF");
        userNameTF.setPrefHeight(30.0);
        userNameTF.setPrefWidth(280.0);
        VBox.setMargin(userNameTF, new Insets(0.0, 10.0, 0.0, 10.0));
        userNameTF.setPadding(new Insets(0.0, 10.0, 0.0, 10.0));

        passwordLbl.setId("passwordLbl");
        passwordLbl.setPrefHeight(44.0);
        passwordLbl.setPrefWidth(307.0);
        passwordLbl.setText("Password");
        passwordLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        passwordLbl.setFont(new Font("Cooper Black", 16.0));
        passwordLbl.setPadding(new Insets(10.0, 0.0, 10.0, 0.0));
        VBox.setMargin(passwordLbl, new Insets(0.0, 10.0, 0.0, 10.0));

        passwordPF.setId("passwordPF");
        passwordPF.setPrefHeight(30.0);
        passwordPF.setPrefWidth(280.0);
        VBox.setMargin(passwordPF, new Insets(0.0, 10.0, 0.0, 10.0));

        loginBtn.setId("loginBtn");
        loginBtn.setMnemonicParsing(false);
        loginBtn.setPrefHeight(25.0);
        loginBtn.setPrefWidth(328.0);
        loginBtn.setStyle("-fx-background-color: #00b8d0;");
        loginBtn.setText("Login");
        loginBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        VBox.setMargin(loginBtn, new Insets(20.0, 10.0, 20.0, 10.0));
        loginBtn.setPadding(new Insets(10.0, 0.0, 10.0, 0.0));
        loginBtn.setFont(new Font("Cooper Black", 20.0));

        gridPane.setPrefHeight(24.0);
        gridPane.setPrefWidth(300.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(242.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(121.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(242.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(116.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(144.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(63.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(signUpHP, 2);
        signUpHP.setId("signUpHP");
        signUpHP.setPrefHeight(20.0);
        signUpHP.setPrefWidth(58.0);
        signUpHP.setText("Sign up");
        signUpHP.setFont(new Font("Cooper Black", 11.0));

        GridPane.setColumnIndex(notHaveAccountLbl, 1);
        notHaveAccountLbl.setId("notHaveAccountLbl");
        notHaveAccountLbl.setPrefHeight(21.0);
        notHaveAccountLbl.setPrefWidth(116.0);
        notHaveAccountLbl.setText("Don't have account?");
        notHaveAccountLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        notHaveAccountLbl.setFont(new Font("Cooper Black", 11.0));

        backBtn.setId("backBtn");
        backBtn.setLayoutX(20.0);
        backBtn.setLayoutY(267.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(25.0);
        backBtn.setPrefWidth(328.0);
        backBtn.setStyle("-fx-background-color: #ffffff;");
        backBtn.setText("Back >");
        backBtn.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        backBtn.setPadding(new Insets(10.0, 0.0, 10.0, 0.0));
        backBtn.setFont(new Font("Cooper Black", 15.0));
        VBox.setMargin(backBtn, new Insets(25.0, 10.0, 0.0, 230.0));

        xCandyOLbl.setId("xCandyOLbl");
        xCandyOLbl.setText("X Candy O");
        xCandyOLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        xCandyOLbl.setFont(new Font("Cooper Black", 30.0));
        xCandyOLbl.setPadding(new Insets(15.0, 70.0, 15.0, 70.0));

        letsPlayLbl.setId("letsPlayLbl");
        letsPlayLbl.setLayoutX(2.0);
        letsPlayLbl.setLayoutY(110.0);
        letsPlayLbl.setText("Let's play");
        letsPlayLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        letsPlayLbl.setFont(new Font("Cooper Black", 20.0));
        letsPlayLbl.setPadding(new Insets(20.0, 96.0, 20.0, 96.0));

        ticTacToeLbl.setId("ticTacToeLbl");
        ticTacToeLbl.setLayoutY(145.0);
        ticTacToeLbl.setText("Tic-Tac-Toe");
        ticTacToeLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        ticTacToeLbl.setFont(new Font("Cooper Black", 30.0));
        ticTacToeLbl.setPadding(new Insets(20.0, 60.0, 20.0, 60.0));

        getChildren().add(imageView);
        vBox.getChildren().add(loginLbl);
        vBox.getChildren().add(userNameLbl);
        vBox.getChildren().add(userNameTF);
        vBox.getChildren().add(passwordLbl);
        vBox.getChildren().add(passwordPF);
        vBox.getChildren().add(loginBtn);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(signUpHP);
        gridPane.getChildren().add(notHaveAccountLbl);
        vBox.getChildren().add(gridPane);
        vBox.getChildren().add(backBtn);
        getChildren().add(vBox);
        getChildren().add(xCandyOLbl);
        getChildren().add(letsPlayLbl);
        getChildren().add(ticTacToeLbl);

    }
}

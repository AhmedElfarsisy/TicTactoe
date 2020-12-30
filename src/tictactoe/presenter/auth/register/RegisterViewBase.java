package tictactoe.presenter.auth.register;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tictactoe.helper.Constants;

public class RegisterViewBase extends Pane {

    protected final ImageView imageView;
    protected final VBox vbox;
    protected final Label singnUpLbl;
    protected final Label userNameLbl;
    protected final TextField userNameTF;
    protected final Label passwordLbl;
    protected final PasswordField passwordPF;
    protected final Label confirmPasswordLbl;
    protected final PasswordField confirmPasswordPF;
    protected final Button signUpBtn;
    protected final Button backBtn;
    protected final Label xCandyOLbl;
    protected final Label letsPlayLbl;
    protected final Label ticTacToeLbl;

    public RegisterViewBase() {

        imageView = new ImageView();
        vbox = new VBox();
        singnUpLbl = new Label();
        userNameLbl = new Label();
        userNameTF = new TextField();
        passwordLbl = new Label();
        passwordPF = new PasswordField();
        confirmPasswordLbl = new Label();
        confirmPasswordPF = new PasswordField();
        signUpBtn = new Button();
        backBtn = new Button();
        xCandyOLbl = new Label();
        letsPlayLbl = new Label();
        ticTacToeLbl = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(400.0);
        imageView.setFitWidth(300.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource(Constants.BACKGROUND).toExternalForm()));

        vbox.setId("userNameTF");
        vbox.setLayoutX(300.0);
        vbox.setLayoutY(2.0);
        vbox.setPrefHeight(400.0);
        vbox.setPrefWidth(300.0);
        vbox.setStyle("-fx-background-color: #ffffff;");

        singnUpLbl.setId("signUpLbl");
        singnUpLbl.setPrefHeight(59.0);
        singnUpLbl.setPrefWidth(300.0);
        singnUpLbl.setText(" Sign up");
        singnUpLbl.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        singnUpLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        singnUpLbl.setOpaqueInsets(new Insets(0.0));
        VBox.setMargin(singnUpLbl, new Insets(0.0));
        singnUpLbl.setPadding(new Insets(15.0, 80.0, 15.0, 80.0));
        singnUpLbl.setFont(new Font("Cooper Black", 30.0));

        userNameLbl.setId("userNameLbl");
        userNameLbl.setPrefHeight(37.0);
        userNameLbl.setPrefWidth(300.0);
        userNameLbl.setText("User Name");
        userNameLbl.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        userNameLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        userNameLbl.setOpaqueInsets(new Insets(0.0));
        userNameLbl.setPadding(new Insets(0.0, 10.0, 0.0, 10.0));
        userNameLbl.setFont(new Font("Cooper Black", 16.0));

        userNameTF.setId("userNameTF");
        userNameTF.setPrefHeight(30.0);
        userNameTF.setPrefWidth(280.0);
        VBox.setMargin(userNameTF, new Insets(0.0, 10.0, 0.0, 10.0));
        userNameTF.setFont(new Font(16.0));

        passwordLbl.setId("passwordLbl");
        passwordLbl.setPrefHeight(34.0);
        passwordLbl.setPrefWidth(300.0);
        passwordLbl.setText("Password");
        passwordLbl.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        passwordLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        passwordLbl.setOpaqueInsets(new Insets(0.0));
        passwordLbl.setFont(new Font("Cooper Black", 16.0));
        VBox.setMargin(passwordLbl, new Insets(0.0));
        passwordLbl.setPadding(new Insets(0.0, 10.0, 0.0, 10.0));

        passwordPF.setId("passwordPF");
        passwordPF.setPrefHeight(30.0);
        passwordPF.setPrefWidth(280.0);
        VBox.setMargin(passwordPF, new Insets(0.0, 10.0, 0.0, 10.0));
        passwordPF.setFont(new Font(16.0));

        confirmPasswordLbl.setId("confirmPasswordLbl");
        confirmPasswordLbl.setPrefHeight(34.0);
        confirmPasswordLbl.setPrefWidth(300.0);
        confirmPasswordLbl.setText("Confirm Password");
        confirmPasswordLbl.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        confirmPasswordLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        confirmPasswordLbl.setOpaqueInsets(new Insets(0.0));
        confirmPasswordLbl.setPadding(new Insets(0.0, 10.0, 0.0, 10.0));
        confirmPasswordLbl.setFont(new Font("Cooper Black", 16.0));

        confirmPasswordPF.setId("confirmPasswordPF");
        confirmPasswordPF.setPrefHeight(30.0);
        confirmPasswordPF.setPrefWidth(280.0);
        VBox.setMargin(confirmPasswordPF, new Insets(0.0, 10.0, 0.0, 10.0));
        confirmPasswordPF.setFont(new Font(16.0));

        signUpBtn.setId("signUpBtn");
        signUpBtn.setMnemonicParsing(false);
        signUpBtn.setPrefHeight(41.0);
        signUpBtn.setPrefWidth(312.0);
        signUpBtn.setStyle("-fx-background-color: #00b8d0;");
        signUpBtn.setText("Sign Up");
        signUpBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        VBox.setMargin(signUpBtn, new Insets(10.0));
        signUpBtn.setFont(new Font("Cooper Black", 20.0));

        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(50.0);
        backBtn.setPrefWidth(100.0);
        backBtn.setStyle("-fx-background-color: white;");
        backBtn.setText("back>");
        backBtn.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        backBtn.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        backBtn.setFont(new Font("Cooper Black", 20.0));
        VBox.setMargin(backBtn, new Insets(50.0, 0.0, 0.0, 200.0));

        xCandyOLbl.setId("xCandyOLbl");
        xCandyOLbl.setLayoutX(1.0);
        xCandyOLbl.setLayoutY(1.0);
        xCandyOLbl.setPrefHeight(59.0);
        xCandyOLbl.setPrefWidth(300.0);
        xCandyOLbl.setText("X Candy O");
        xCandyOLbl.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        xCandyOLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        xCandyOLbl.setOpaqueInsets(new Insets(0.0));
        xCandyOLbl.setPadding(new Insets(15.0, 70.0, 15.0, 70.0));
        xCandyOLbl.setFont(new Font("Cooper Black", 30.0));

        letsPlayLbl.setId("letsP;ayLbl");
        letsPlayLbl.setLayoutX(1.0);
        letsPlayLbl.setLayoutY(114.0);
        letsPlayLbl.setPrefHeight(59.0);
        letsPlayLbl.setPrefWidth(300.0);
        letsPlayLbl.setText("Let's play");
        letsPlayLbl.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        letsPlayLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        letsPlayLbl.setOpaqueInsets(new Insets(0.0));
        letsPlayLbl.setPadding(new Insets(20.0, 100.0, 20.0, 100.0));
        letsPlayLbl.setFont(new Font("Cooper Black", 20.0));

        ticTacToeLbl.setId("ticTacToeLbl");
        ticTacToeLbl.setLayoutX(1.0);
        ticTacToeLbl.setLayoutY(146.0);
        ticTacToeLbl.setPrefHeight(59.0);
        ticTacToeLbl.setPrefWidth(300.0);
        ticTacToeLbl.setText("Tic-Tac-Toe");
        ticTacToeLbl.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        ticTacToeLbl.setTextFill(javafx.scene.paint.Color.valueOf("#00b8d0"));
        ticTacToeLbl.setOpaqueInsets(new Insets(0.0));
        ticTacToeLbl.setPadding(new Insets(20.0, 60.0, 20.0, 60.0));
        ticTacToeLbl.setFont(new Font("Cooper Black", 30.0));

        getChildren().add(imageView);
        vbox.getChildren().add(singnUpLbl);
        vbox.getChildren().add(userNameLbl);
        vbox.getChildren().add(userNameTF);
        vbox.getChildren().add(passwordLbl);
        vbox.getChildren().add(passwordPF);
        vbox.getChildren().add(confirmPasswordLbl);
        vbox.getChildren().add(confirmPasswordPF);
        vbox.getChildren().add(signUpBtn);
        vbox.getChildren().add(backBtn);
        getChildren().add(vbox);
        getChildren().add(xCandyOLbl);
        getChildren().add(letsPlayLbl);
        getChildren().add(ticTacToeLbl);

    }
}

package com.example.hotel_transylvania;

import java.io.IOException;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private FontAwesomeIconView back;

    @FXML
    private FontAwesomeIconView close;
    @FXML
    private Hyperlink frogetPassword;

    @FXML
    private MFXButton login;

    @FXML
    private Text passwordError;

    @FXML
    private MFXPasswordField passwordField;

    @FXML
    private Hyperlink signupText;

    @FXML
    private Text userError;

    @FXML
    private Text loginError;

    @FXML
    private MFXTextField usernameField;

    Boolean check[] = new Boolean[2];


    @FXML
    void checkName(KeyEvent event) {
        String text = usernameField.getText();

        if (text.contains(" ")) {
            check[0] = false;
            usernameField.setStyle("-fx-border-color:  red;");
            userError.setText("*Spaces Not Allowed");
        } else if (text.length() < 4) {
            check[0] = false;
            usernameField.setStyle("-fx-border-color:  red;");
            userError.setText("*Use atleast 4 characters");
        } else {
            check[0] = true;
            usernameField.setStyle("-fx-border-color:  #8F6620;");
            userError.setText("");
        }



    }

    @FXML
    void checkPassword(KeyEvent event) {
        String text = passwordField.getText();

        if (text.length() < 8) {
            check[1] = false;
            passwordField.setStyle("-fx-border-color:  red;");
            passwordError.setText("*Use atleast 8 characters");
        } else {
            check[1] = true;
            passwordField.setStyle("-fx-border-color:  #8F6620;");
            passwordError.setText("");
        }
    }

    @FXML
    void backClicked(MouseEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Startup.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);

    }

    @FXML
    void forgetClicked(MouseEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Forget.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loginClicked(MouseEvent event) {

        if (usernameField.getText().isEmpty()) {
            usernameField.setStyle("-fx-border-color:  red;");
            userError.setText("*Field is empty");
            check[0] = false;
        }

        if (passwordField.getText().isEmpty()) {
            passwordField.setStyle("-fx-border-color:  red;");
            passwordError.setText("*Field is empty");
            check[1] = false;
        }
        if (check[0] && check[1]) {
//            FileHandling file = new FileHandling();
//            boolean check = file.checkLogin(usernameField.getText(),passwordField.getText());
            UserDB datebase = new UserDB();
            boolean check = datebase.checkLogin(usernameField.getText(),passwordField.getText());
            if(check) {
                try {
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
                    Parent root = loader.load();
                    HomeController home = loader.getController();
                    home.signedIn(usernameField.getText());
                    Booking book = new Booking();
                    book.setUsername(usernameField.getText());
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    // stage.initStyle(StageStyle.DECORATED);
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                loginError.setText("Username or Password is incorrect");

            }
        }
    }

    @FXML
    void signClicked(MouseEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

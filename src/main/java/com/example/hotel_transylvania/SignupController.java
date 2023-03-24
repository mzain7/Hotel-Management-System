package com.example.hotel_transylvania;

import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.regex.Pattern;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;


public class SignupController implements Initializable {
    @FXML
    private FontAwesomeIconView back;

    @FXML
    private FontAwesomeIconView close;

    @FXML
    private Text conPasswordError;

    @FXML
    private MFXPasswordField conPasswordField;

    @FXML
    private Text conPasswordFloat;

    @FXML
    private Text contactError;

    @FXML
    private MFXTextField contactField;

    @FXML
    private Text emailError;

    @FXML
    private MFXTextField emailField;

    @FXML
    private Text firstError;

    @FXML
    private MFXTextField firstNameField;

    @FXML
    private Text lastError;

    @FXML
    private MFXTextField lastNameField;

    @FXML
    private Hyperlink loginText;

    @FXML
    private Text passwordError;

    @FXML
    private MFXPasswordField passwordField;

    @FXML
    private MFXButton signup;

    @FXML
    private Text userError;

    @FXML
    private MFXTextField userField;


    Boolean check[] = new Boolean[7];




    @FXML
    void checkUser(KeyEvent event) {
        String text = userField.getText();

        if (text.contains(" ")) {
            check[2] = false;
            userField.setStyle("-fx-border-color:  red;");
            userError.setText("*Spaces Not Allowed");
        } else if (text.length() < 4) {
            check[2] = false;
            userField.setStyle("-fx-border-color:  red;");
            userError.setText("*Use atleast 2 characters");
        }else {
            check[2] = true;
            userError.setText("");
            userField.setStyle("-fx-border-color:  #8F6620;");
        }
    }

    @FXML
    void checkConPassword(KeyEvent event) {
        String text = conPasswordField.getText();

        if (!passwordField.getText().equals(text)) {
            check[6] = false;
            conPasswordField.setStyle("-fx-border-color:  red;");
            conPasswordError.setText("*Password does not match");
        }else {
            check[6] = true;
            conPasswordField.setStyle("-fx-border-color:  #8F6620;");
            conPasswordError.setText("");
        }

    }

    @FXML
    void checkContact(KeyEvent event) {
        String text = contactField.getText();

        if (text.contains(" ")) {
            check[3] = false;
            contactField.setStyle("-fx-border-color:  red;");
            contactError.setText("*Spaces Not Allowed");
        } else if (!checkNumber(text)) {
            check[3] = false;
            contactField.setStyle("-fx-border-color:  red;");
            contactError.setText("*Only + and 0-9 are allowed");

        } else if (text.length() < 9) {
            check[3] = false;
            contactField.setStyle("-fx-border-color:  red;");
            contactError.setText("*Use at least 9 characters");
        }else {
            check[3] = true;
            contactField.setStyle("-fx-border-color:  #8F6620;");
            contactError.setText("");
        }
    }

    @FXML
    void checkEmail(KeyEvent event) {

        String text = emailField.getText();

        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        if (!patternMatches(text, regexPattern)) {
            check[4] = false;
            emailField.setStyle("-fx-border-color:  red;");
            emailError.setText("Invalid Email");
        }else{
            emailError.setText("");
            emailField.setStyle("-fx-border-color:  #8F6620;");
            check[4] = true;

        }

    }

    @FXML
    void checkFirstName(KeyEvent event) {
        String text = firstNameField.getText();

        if (text.contains(" ")) {
            check[0] = false;
            firstNameField.setStyle("-fx-border-color:  red;");
            firstError.setText("*Spaces Not Allowed");
        } else if (text.length() < 2) {
            check[0] = false;
            firstNameField.setStyle("-fx-border-color:  red;");
            firstError.setText("*Use atleast 2 characters");
        }else {
            check[0] = true;
            firstError.setText("");
            firstNameField.setStyle("-fx-border-color:  #8F6620;");
        }
    }

    @FXML
    void checkLastName(KeyEvent event) {
        String text = lastNameField.getText();

        if (text.contains(" ")) {
            check[1] = false;
            lastNameField.setStyle("-fx-border-color:  red;");
            lastError.setText("*Spaces Not Allowed");
        } else if (text.length() < 2) {
            check[1] = false;
            lastNameField.setStyle("-fx-border-color:  red;");
            lastError.setText("*Use atleast 2 characters");
        }else {
            check[1] = true;
            lastError.setText("");
            lastNameField.setStyle("-fx-border-color:  #8F6620;");
        }
    }

    @FXML
    void checkPassword(KeyEvent event) {
        String text = passwordField.getText();

        if (text.length() < 8) {
            check[5] = false;
            passwordField.setStyle("-fx-border-color:  red;");
            passwordError.setText("*Use atleast 8 characters");
        }else {
            check[5] = true;
            passwordField.setStyle("-fx-border-color:  #8F6620;");
            passwordError.setText("");
        }

    }








    @FXML
    void backClicked(MouseEvent event) {
        try {
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Startup.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            // stage.initStyle(StageStyle.DECORATED);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void signupClicked(MouseEvent event) {
        if (firstNameField.getText().isEmpty()) {
            firstNameField.setStyle("-fx-border-color:  red;");
            firstError.setText("*Field is empty");
            check[0] = false;
        }
        if (lastNameField.getText().isEmpty()) {
            lastNameField.setStyle("-fx-border-color:  red;");
            lastError.setText("*Field is empty");
            check[1] = false;
        }
        if (contactField.getText().isEmpty()) {
            contactField.setStyle("-fx-border-color:  red;");
            contactError.setText("*Field is empty");
            check[2] = false;
        }

        if (userField.getText().isEmpty()) {
            userField.setStyle("-fx-border-color:  red;");
            userError.setText("*Field is empty");
            check[3] = false;
        }
        if (emailField.getText().isEmpty()) {
            emailField.setStyle("-fx-border-color:  red;");
            emailError.setText("*Field is empty");
            check[4] = false;
        }
        if (passwordField.getText().isEmpty()) {
            passwordField.setStyle("-fx-border-color:  red;");
            passwordError.setText("*Field is empty");
            check[5] = false;
        }
        if (conPasswordField.getText().isEmpty()) {
            conPasswordField.setStyle("-fx-border-color:  red;");
            conPasswordError.setText("*Field is empty");
            check[6] = false;
        }

        if (check[0] && check[1] && check[2] && check[3] && check[4] && check[5] && check[6]) {
//            FileHandling file = new FileHandling(firstNameField.getText(),lastNameField.getText(),
//                    userField.getText(),contactField.getText(),emailField.getText(),passwordField.getText());
//            file.writeFile();

            UserDB database = new UserDB(firstNameField.getText(),lastNameField.getText(),
                    userField.getText(),contactField.getText(),emailField.getText(),passwordField.getText());

            loginClicked(event);

        }
    }

    @FXML
    void loginClicked(MouseEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            // stage.initStyle(StageStyle.DECORATED);
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public boolean checkNumber(String str) {
        int i = 0;
        if (!str.isEmpty()) {

            if (str.charAt(0) == '+') {
                i = 1;
            }

            for (i = 1; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }

            }
        }

        return true;
    }


    public void validateEmail() {
        String emailAddress = emailField.getText();
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!patternMatches(emailAddress, regexPattern)) {
            emailError.setText("Invalid Email");
        }else{
            emailError.setText("");
        }
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

}


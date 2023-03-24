package com.example.hotel_transylvania;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class ForgetController {
    @FXML
    private AnchorPane ChangePassword;

    @FXML
    private AnchorPane OtpCheck;

    @FXML
    private FontAwesomeIconView back;

    @FXML
    private MFXButton checkOtp;

    @FXML
    private FontAwesomeIconView close;

    @FXML
    private Text conPasswordError;

    @FXML
    private MFXPasswordField conPasswordField;

    @FXML
    private AnchorPane emailConfirmation;

    @FXML
    private Text emailError;

    @FXML
    private Text otpError;

    @FXML
    private Text remains;

    @FXML
    private MFXTextField emailField;

    @FXML
    private MFXTextField otp;

    @FXML
    private Text passwordError;

    @FXML
    private MFXPasswordField passwordField;

    @FXML
    private MFXButton sendEmail;

    @FXML
    private MFXButton next;

    @FXML
    private Text sendError;

    boolean check[] = new boolean[2];


//    FileHandling file = new FileHandling();
    UserDB database = new UserDB();

    EmailAuthentication emailAuthentication;

    @FXML
    void backClicked(MouseEvent event) {
        try {
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void checkEmail(KeyEvent event) {
        String text = emailField.getText();
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!patternMatches(text, regexPattern)) {
            check1= false;
            emailField.setStyle("-fx-border-color:  red;");
            emailError.setText("Invalid Email");
        }else{
            emailError.setText("");
            emailField.setStyle("-fx-border-color:  #8F6620;");
            check1 = true;

        }
    }

    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);
    }

    boolean check1;
    @FXML
    void sendClicked(MouseEvent event) {
//        FileHandling checker = new FileHandling();
        if(check1 && database.checkEmial(emailField.getText())){
            emailAuthentication = new EmailAuthentication(emailField.getText());
            emailAuthentication.sendOtp();
            emailConfirmation.setVisible(false);
            OtpCheck.setVisible(true);
        }else{
            sendError.setText("Email is not Registered");
        }
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
    int otpChecker;

    @FXML
    void otpCheck(MouseEvent event) {
        if(otp.getText().equals(emailAuthentication.otp)){
            OtpCheck.setVisible(false);
            ChangePassword.setVisible(true);
        }else{
            otpError.setText("OTP does not match");
            otpChecker++;
            remains.setText(4-otpChecker+" attempts remaining");
        }
        if(otpChecker >= 4){
            checkOtp.setDisable(true);
            remains.setVisible(false);
            otpError.setVisible(false);
        }
    }

    @FXML
    void checkConPassword(KeyEvent event) {
        String text = conPasswordField.getText();

        if (!passwordField.getText().equals(text)) {
            check[0] = false;
            conPasswordField.setStyle("-fx-border-color:  red;");
            conPasswordError.setText("*Password does not match");
        }else {
            check[0] = true;
            conPasswordField.setStyle("-fx-border-color:  #8F6620;");
            conPasswordError.setText("");
        }

    }

    @FXML
    void checkPassword(KeyEvent event) {
        String text = passwordField.getText();

        if (text.length() < 8) {
            check[1] = false;
            passwordField.setStyle("-fx-border-color:  red;");
            passwordError.setText("*Use atleast 8 characters");
        }else {
            check[1] = true;
            passwordField.setStyle("-fx-border-color:  #8F6620;");
            passwordError.setText("");
        }

    }


    @FXML
    void nextClicked(MouseEvent event) {
        if(check[0]&&check[1]){
            database.changePassword(passwordField.getText(),emailField.getText());
            Main.changeScene(event,"Login.fxml");
        }
    }


}

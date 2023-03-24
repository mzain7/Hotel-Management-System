package com.example.hotel_transylvania;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class StartupController implements Initializable{
    @FXML
    private MFXButton loginButton;

    @FXML
    private MFXButton signupButton;

    @FXML
    private FontAwesomeIconView closeBtn;

    @FXML
    private AnchorPane loading;

    @FXML
    private AnchorPane startup;

    static int count = 0;
    @FXML
    void loginBtnClicked(MouseEvent event) {
        try {
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
    void signupBtnClicked(MouseEvent event) {
        try {
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
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
       if (count==0) {
           loading.setVisible(true);
           startup.setVisible(false);
           Sleep sleep = new Sleep();
           Thread myThread = new Thread(sleep);
           myThread.start();
           count++;
       }
    }


    public class Sleep implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                loading.setVisible(false);
                startup.setVisible(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

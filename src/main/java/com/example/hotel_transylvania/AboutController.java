package com.example.hotel_transylvania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void bookingBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Bookings.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void servicesBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Wellness.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void galleryBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Gallery.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            e.getMessage();


        }
    }

    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);

    }
    @FXML
    void backClicked(MouseEvent event) {
        Main.changeScene(event,"Homepage.fxml");
    }
}

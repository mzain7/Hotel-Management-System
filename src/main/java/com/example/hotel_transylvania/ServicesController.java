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

public class ServicesController {

    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    void galleryClicked(MouseEvent event) {
        Main.changeScene(event,"Gallery.fxml");
    }
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

    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);

    }
    @FXML
    void backClicked(MouseEvent event) {
        Main.changeScene(event,"Homepage.fxml");
    }

    @FXML
    void aboutClicked(MouseEvent event) {
        Main.changeScene(event,"About.fxml");
    }
}
package com.example.hotel_transylvania;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SingleRoomsController {
    @FXML
    void book(MouseEvent event) {
        Main.changeScene(event,"Booking.fxml");
    }


    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);

    }

    @FXML
    void backClicked(MouseEvent event) {
        Main.changeScene(event,"Bookings.fxml");
    }
}
